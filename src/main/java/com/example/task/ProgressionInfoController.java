package com.example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProgressionInfoController {

    @Autowired
    private ProgressionInfoRepo progressionInfoRepo;

    @QueryMapping("getProgressionInfo")
    public ProgressionInfo getProgressionInfo(@Argument Integer progressionId){
        return this.progressionInfoRepo.findById(progressionId).orElseThrow(() -> new RuntimeException("Progression not found!"));
    }

    @QueryMapping("getAllProgressionInfo")
    public List<ProgressionInfo> getAllProgressionInfo(){
        return this.progressionInfoRepo.findAll();
    }

    @MutationMapping("createProgressionInfo")
    public ProgressionInfo createProgressionInfo(@Argument Integer progressionId, @Argument Integer gameId, @Argument String progressionName){

        List<ProgressionInfo> alreadyExists = progressionInfoRepo.findByProgressionName(progressionName);

        if(!alreadyExists.isEmpty())
            throw new RuntimeException("Progression with name " + progressionName + " already exists !");

        return this.progressionInfoRepo.save(new ProgressionInfo(progressionId, gameId, progressionName));
    }
}
