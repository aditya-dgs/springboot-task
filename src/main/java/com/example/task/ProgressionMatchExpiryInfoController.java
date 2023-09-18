package com.example.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;


@Controller
public class ProgressionMatchExpiryInfoController {
    @Autowired
    private ProgressionMatchExpiryInfoRepo progressionMatchExpiryInfoRepo;

    @QueryMapping("getProgressionMatchExpiryInfo")
    public ProgressionMatchExpiryInfo getProgressionMatchExpiryInfo(@Argument Integer matchId){
        System.out.println(matchId);
        return this.progressionMatchExpiryInfoRepo.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found!"));
    }

    @QueryMapping("getAllProgressionMatchExpiryInfo")
    public List<ProgressionMatchExpiryInfo> getAllProgressionMatchExpiryInfo(){
        return this.progressionMatchExpiryInfoRepo.findAll();
    }

    @MutationMapping("createProgressionMatchExpiryInfo")
    public ProgressionMatchExpiryInfo createProgressionMatchExpiryInfo(@Argument Integer matchId, @Argument Integer progressionId, @Argument String matchName, @Argument String startDate, @Argument String endDate){
        return this.progressionMatchExpiryInfoRepo.save(new ProgressionMatchExpiryInfo(matchId, progressionId, matchName, startDate, endDate));
    }


//   Create other API where you will give Progression_name and it will return you all matches associated with that Progression.
    @QueryMapping("getMatchByProgressionName")
    public List<ProgressionMatchExpiryInfo> getMatchByProgressionName(@Argument String progressionName)  {
        return this.progressionMatchExpiryInfoRepo.getMatchByProgressionName(progressionName);
    }

//    Create an API where you will give progression and match_name, it will return you whether that match is
//    running, expired, upcoming on the basis of date. Throw 404 if match is not available for that progression
    @QueryMapping("getMatchStatus")
    public ResponseEntity<String> getMatchStatus(@Argument String matchName){

        ProgressionMatchExpiryInfo info = progressionMatchExpiryInfoRepo.findByMatchName(matchName);

        if(null == info) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        long now = Instant.now().toEpochMilli() / 1000;
        long startDate = Long.parseLong(String.valueOf(info.getStartDate()));
        long endDate = Long.parseLong(String.valueOf(info.getEndDate()));

        String response = "";
        if(now > startDate && now < endDate) response = "Running";
        else if(now < startDate) response = "Upcoming";
        else response = "Expired";

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
