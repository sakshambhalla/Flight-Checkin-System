package com.systemdesign.flightcheckin.service;

import com.systemdesign.flightcheckin.entity.Seat;
import com.systemdesign.flightcheckin.entity.User;
import com.systemdesign.flightcheckin.pojo.CheckInRequest;
import com.systemdesign.flightcheckin.repository.SeatRepository;
import com.systemdesign.flightcheckin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@EnableTransactionManagement
public class CheckInService {
    @Autowired
    private SeatService seatService;
    @Autowired
    private UserRepository userRepository;

//    public void checkIn(List<CheckInRequest> checkInRequestList) {
////        ExecutorService executorService = Executors.newFixedThreadPool(checkInRequestList.size());
////        for (CheckInRequest checkInRequest: checkInRequestList) {
////            executorService.submit(seatService.bookSeat(checkInRequest));
////        }
////        executorService.shutdown();
//        checkInRequestList.parallelStream().forEach(checkInRequest -> {
//            seatService.bookSeat(checkInRequest);
//        });
////        for (CheckInRequest checkInRequest: checkInRequestList) {
////            seatService.bookSeat(checkInRequest);
////        }
//    }

    public void checkIn() {
        List<User> users = new ArrayList<>();
        Iterator<User> iterator = userRepository.findAll().iterator();

        while (iterator.hasNext()) {
            users.add(iterator.next());
        }
        users.parallelStream().forEach(user -> {
            seatService.bookSeat(user);
        });
    }

}

