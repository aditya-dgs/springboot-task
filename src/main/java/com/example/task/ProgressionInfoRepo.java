package com.example.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressionInfoRepo extends JpaRepository<ProgressionInfo, Integer> {

    List<ProgressionInfo> findByProgressionName(String ProgressionName);
}
