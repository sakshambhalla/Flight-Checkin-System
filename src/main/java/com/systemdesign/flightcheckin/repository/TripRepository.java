package com.systemdesign.flightcheckin.repository;

import com.systemdesign.flightcheckin.entity.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
    Trip findBySourceAndDestination(String source, String destination);
}
