package com.example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Autowired
	private ProgressionInfoRepo progressionInfoRepo;

	@Autowired
	private ProgressionMatchExpiryInfoRepo progressionMatchExpiryInfoRepo;

	@Override
	public void run(String... args) throws Exception {

		ProgressionInfo l1 = new ProgressionInfo(1, 1, "SuperSmash");
		ProgressionInfo l2 = new ProgressionInfo(2, 1, "LLC");
		ProgressionInfo l3 = new ProgressionInfo(3, 1, "IPL");

		progressionInfoRepo.saveAll(List.of(l1, l2, l3));

		ProgressionMatchExpiryInfo l1m1 = new ProgressionMatchExpiryInfo(1, 1, "L1_Match_1", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/2023 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("03/01/2023 01:00:00").getTime() / 1000));
		ProgressionMatchExpiryInfo l1m2 = new ProgressionMatchExpiryInfo(2, 1, "L1 Match 2", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/12/2023 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("04/12/2023 01:00:00").getTime() / 1000));
		ProgressionMatchExpiryInfo l1m3 = new ProgressionMatchExpiryInfo(3, 1, "L1 Match 3", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/09/2023 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/10/2023 01:00:00").getTime() / 1000));

		ProgressionMatchExpiryInfo l2m1 = new ProgressionMatchExpiryInfo(4, 2, "L2 Match 1", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/2022 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/02/2022 01:00:00").getTime() / 1000));
		ProgressionMatchExpiryInfo l2m2 = new ProgressionMatchExpiryInfo(5, 2, "L2 Match 2", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/2024 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("03/01/2024 01:00:00").getTime() / 1000));

		ProgressionMatchExpiryInfo l3m1 = new ProgressionMatchExpiryInfo(6, 3, "L3 Match 1", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/2013 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/2017 01:00:00").getTime() / 1000));
		ProgressionMatchExpiryInfo l3m2 = new ProgressionMatchExpiryInfo(7, 3, "L3 Match 2", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/2022 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/2024 01:00:00").getTime() / 1000));
		ProgressionMatchExpiryInfo l3m3 = new ProgressionMatchExpiryInfo(8, 3, "L3 Match 3", String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/11/2023 01:00:00").getTime() / 1000), String.valueOf(new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/12/2023 01:00:00").getTime() / 1000));

		progressionMatchExpiryInfoRepo.saveAll(List.of(l1m1, l1m2, l1m3, l2m1, l2m2, l3m1, l3m2, l3m2, l3m3));

	}
}
