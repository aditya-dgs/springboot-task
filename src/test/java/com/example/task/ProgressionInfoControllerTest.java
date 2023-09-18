package com.example.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ProgressionInfoControllerTest {

    @InjectMocks
    private ProgressionInfoController progressionInfoController;

    @Mock
    private ProgressionInfoRepo progressionInfoRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProgressionInfoTest() {

        ProgressionInfo mockInfoObject = new ProgressionInfo();
        when(progressionInfoRepo.findById(2)).thenReturn(Optional.of(mockInfoObject));
        assertEquals(mockInfoObject, progressionInfoController.getProgressionInfo(2));
    }
}
