package com.systemdesign.flightcheckin.service;

import com.github.javafaker.Faker;
import com.systemdesign.flightcheckin.entity.Seat;
import com.systemdesign.flightcheckin.entity.Trip;
import com.systemdesign.flightcheckin.entity.User;
import com.systemdesign.flightcheckin.repository.SeatRepository;
import com.systemdesign.flightcheckin.repository.TripRepository;
import com.systemdesign.flightcheckin.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private SeatRepository seatRepository;
    private TripRepository tripRepository;
    private UserRepository userRepository;
    private Faker faker;

    public AdminService(final SeatRepository seatRepository,
                        final TripRepository tripRepository,
                        final UserRepository userRepository) {
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
        faker = new Faker();
    }

    public void createData() {
        //Users
        for (int i=0;i<200;i++) {
            User user = User.builder().name(faker.name().fullName()).build();
            userRepository.save(user);
        }
        //Trips
        Trip trip = tripRepository.save(Trip.builder().source("India").destination("London").build());
        //Seats
        createSeatsForTrip(trip);
    }

    public void createSeatsForTrip(Trip trip) {
        for(int i=1; i<21; i++) {
            for (char c='A'; c<'G'; c++) {
                String seatNumber = ((Integer)i).toString() + c;
                Seat seat = Seat.builder().tripId(trip.getId()).number(seatNumber).build() ;
                seatRepository.save(seat);
            }
        }
    }
}
