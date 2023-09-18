package com.example.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ProgressionMatchExpiryInfoTest {

    @InjectMocks
    private ProgressionMatchExpiryInfoController progressionMatchExpiryInfoController;
    @Mock
    private ProgressionMatchExpiryInfoRepo progressionMatchExpiryInfoRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMatchStatusRunning() {

        ProgressionMatchExpiryInfo mockInfo = new ProgressionMatchExpiryInfo();
        mockInfo.setStartDate(String.valueOf(Instant.now().getEpochSecond() - 3600)); // One hour ago
        mockInfo.setEndDate(String.valueOf(Instant.now().getEpochSecond() + 3600)); // One hour from now
        when(progressionMatchExpiryInfoRepo.findByMatchName(anyString())).thenReturn(mockInfo);

        ResponseEntity<String> responseEntity = progressionMatchExpiryInfoController.getMatchStatus("SampleMatch");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Running", responseEntity.getBody());
    }

    @Test
    public void testGetMatchStatusExpired() {

        ProgressionMatchExpiryInfo mockInfo = new ProgressionMatchExpiryInfo();
        mockInfo.setStartDate(String.valueOf(Instant.now().getEpochSecond() - 4800));
        mockInfo.setEndDate(String.valueOf(Instant.now().getEpochSecond() - 3600));
        when(progressionMatchExpiryInfoRepo.findByMatchName(anyString())).thenReturn(mockInfo);

        ResponseEntity<String> responseEntity = progressionMatchExpiryInfoController.getMatchStatus("SampleMatch");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Expired", responseEntity.getBody());
    }

    @Test
    public void testGetMatchStatusUpcoming() {

        ProgressionMatchExpiryInfo mockInfo = new ProgressionMatchExpiryInfo();
        mockInfo.setStartDate(String.valueOf(Instant.now().getEpochSecond() + 3600));
        mockInfo.setEndDate(String.valueOf(Instant.now().getEpochSecond() + 4800));
        when(progressionMatchExpiryInfoRepo.findByMatchName(anyString())).thenReturn(mockInfo);

        ResponseEntity<String> responseEntity = progressionMatchExpiryInfoController.getMatchStatus("SampleMatch");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Upcoming", responseEntity.getBody());
    }

    @Test
    public void getMatchByProgressionNameTest(){

        List<ProgressionMatchExpiryInfo> mockInfo = new ArrayList<>();
        mockInfo.add(new ProgressionMatchExpiryInfo(1, 1, "L1_Match_1", "", ""));

        when(progressionMatchExpiryInfoRepo.getMatchByProgressionName("LLC")).thenReturn(mockInfo);

        String leagueName = "LLC";
        List<ProgressionMatchExpiryInfo> actualMatchList = progressionMatchExpiryInfoController.getMatchByProgressionName(leagueName);

        assertEquals(mockInfo, actualMatchList);
    }

}

