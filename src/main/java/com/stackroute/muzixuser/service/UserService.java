package com.stackroute.muzixuser.service;

import java.util.List;
import com.stackroute.muzixuser.domain.User;
import com.stackroute.muzixuser.exceptions.UserAlreadyExistsException;
import com.stackroute.muzixuser.exceptions.UserNotFoundException;



public interface UserService {
    public User saveUser(User user) throws UserAlreadyExistsException;
    public List<User> getAllUser();
    public User updateUser(User user);
    public User findByName(String name);
    //throws TrackAlreadyExistsException;


    public User deleteUser(int userId) throws UserNotFoundException;

}

