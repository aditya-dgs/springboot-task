package com.example.task;

import jakarta.persistence.*;

@Entity
public class ProgressionMatchExpiryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;
    private Integer progressionId;
    private String matchName;
    private String startDate;
    private String endDate;

    public ProgressionMatchExpiryInfo(Integer matchId, Integer ProgressionId, String matchName, String startDate, String endDate) {
        this.matchId = matchId;
        this.progressionId = ProgressionId;
        this.matchName = matchName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ProgressionMatchExpiryInfo() {
    }

    public ProgressionMatchExpiryInfo(int matchId, int ProgressionId, String matchName, String startDate, String endDate) {
        this.matchId = matchId;
        this.progressionId = ProgressionId;
        this.matchName = matchName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getObject() {
        return progressionId;
    }

    public void setObject(Integer ProgressionId) {
        this.progressionId = ProgressionId;
    }

    public String getMatchName() {
        return matchName;
    }

    public Integer getProgressionId() {
        return progressionId;
    }

    public void setProgressionId(Integer progressionId) {
        this.progressionId = progressionId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }


}
