package com.example.task;

import jakarta.persistence.*;

@Entity
//@Table(name = "progression_info")
public class ProgressionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer progressionId;
    private Integer gameId;
    private String progressionName;

    @Override
    public String toString() {
        return "ProgressionInfo{" +
                "progressionId=" + progressionId +
                ", gameId=" + gameId +
                ", progressionName='" + progressionName + '\'' +
                '}';
    }

    public ProgressionInfo(Integer progressionId, Integer gameId, String progressionName) {
        this.progressionId = progressionId;
        this.gameId = gameId;
        this.progressionName = progressionName;
    }


    public ProgressionInfo() {
    }

    public Integer getProgressionId() {
        return progressionId;
    }

    public void setProgressionId(Integer progressionId) {
        this.progressionId = progressionId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getProgressionName() {
        return progressionName;
    }

    public void setProgressionName(String progressionName) {
        this.progressionName = progressionName;
    }
}
