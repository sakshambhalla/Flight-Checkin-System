package com.systemdesign.flightcheckin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id) && Objects.equals(tripId, seat.tripId) && Objects.equals(UserId, seat.UserId) && Objects.equals(number, seat.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tripId, UserId, number);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long tripId;
    private Long UserId;
    private String number;
}
