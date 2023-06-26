package com.systemdesign.flightcheckin.repository;

import com.systemdesign.flightcheckin.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
