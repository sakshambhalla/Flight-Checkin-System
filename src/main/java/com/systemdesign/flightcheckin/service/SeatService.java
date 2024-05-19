package com.systemdesign.flightcheckin.service;

import com.systemdesign.flightcheckin.entity.Seat;
import com.systemdesign.flightcheckin.entity.User;
import com.systemdesign.flightcheckin.pojo.CheckInRequest;
import com.systemdesign.flightcheckin.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    public void bookSeat(User user) {
        Seat s = getFirstAvailableSeat();
        if (s == null) {
            System.out.println("User - " + user.getId() + " - name - " + user.getName() + " - could not get any seat");
            return;
        }
        bookSeat(s.getId(), user.getId());
        System.out.println("User - " + user.getId() + " - name - " + user.getName() + " allotted seat number - " + s.getNumber() + " with id  - " +s.getId());
    }

    @Transactional
    public void bookSeat(CheckInRequest checkInRequest) {
        Seat seat = seatRepository.findSeatById(checkInRequest.getSeatId());
        if (seat != null && seat.getUserId() == null) {
            seatRepository.setUserForSeatId(checkInRequest.getSeatId(), checkInRequest.getUserId());
        }
    }

    public void bookSeat(Long seatId, Long userId) {
        seatRepository.setUserForSeatId(seatId, userId);
    }

    public Seat getFirstAvailableSeat() {
        return seatRepository.findFirstAvailableSeat();
    }
}
