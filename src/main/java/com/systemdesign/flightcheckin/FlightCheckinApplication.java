package com.systemdesign.flightcheckin;

import com.systemdesign.flightcheckin.entity.Trip;
import com.systemdesign.flightcheckin.pojo.CheckInRequest;
import com.systemdesign.flightcheckin.service.AdminService;
import com.systemdesign.flightcheckin.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FlightCheckinApplication implements CommandLineRunner {
	@Autowired
	private AdminService adminService;
	@Autowired
	private CheckInService checkInService;

	public static void main(String[] args) {
		SpringApplication.run(FlightCheckinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.adminService.createData();
		this.test();
	}

	public void test() {
		List<CheckInRequest> checkInRequestList = new ArrayList<>();

		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(1L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(2L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(4L).userId(3L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(4L).userId(4L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(5L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(6L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(2L).userId(7L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(8L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(3L).userId(9L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(10L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(11L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(12L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(5L).userId(13L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(5L).userId(14L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(1L).userId(15L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(2L).userId(16L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(3L).userId(17L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(6L).userId(18L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(6L).userId(19L).build());
		checkInRequestList.add(CheckInRequest.builder().seatId(5L).userId(20L).build());
//		checkInService.checkIn(checkInRequestList);
		checkInService.checkIn();
	}
}
