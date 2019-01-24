package com.stackroute.muzixuser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixuser.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    //  @Query("SELECT t FROM track t WHERE t.trackName-=?1")
    public User findByUserName(String name);



}
