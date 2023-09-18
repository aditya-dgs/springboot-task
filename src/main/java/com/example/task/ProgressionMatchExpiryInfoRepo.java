package com.example.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProgressionMatchExpiryInfoRepo extends JpaRepository<ProgressionMatchExpiryInfo, Integer> {

    @Query(nativeQuery = true, value = "SELECT a.match_id, a.progression_id, a.match_name, a.start_date, a.end_date FROM progression_match_expiry_info a JOIN progression_info b ON a.progression_id = b.progression_id WHERE b.progression_name = :progressionName")
    List<ProgressionMatchExpiryInfo> getMatchByProgressionName(String progressionName);

    ProgressionMatchExpiryInfo findByMatchName(String matchName);

}
