package com.systemdesign.flightcheckin.repository;

import com.systemdesign.flightcheckin.entity.Seat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatRepository extends CrudRepository<Seat, Long> {
    @Query(value = "select * from seat where id = :id FOR UPDATE", nativeQuery = true)
    Seat findSeatById(Long id);

    @Modifying
    @Query("Update Seat set user_id = :userId where id = :seatId")
    int setUserForSeatId(Long seatId, Long userId);

    @Query(value = "select * from seat where user_id is NULL order by id limit 1 FOR UPDATE SKIP LOCKED", nativeQuery = true)
    Seat findFirstAvailableSeat();
}
