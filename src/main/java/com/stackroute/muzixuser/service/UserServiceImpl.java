package com.stackroute.muzixuser.service;
//

import org.springframework.beans.factory.annotation.Autowired;
import com.stackroute.muzixuser.repository.UserRepository;
import com.stackroute.muzixuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import com.stackroute.muzixuser.domain.User;
import com.stackroute.muzixuser.exceptions.UserAlreadyExistsException;
import com.stackroute.muzixuser.exceptions.UserNotFoundException;



import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        User savedUser = null;
        if (userRepository.existsById(user.getUserId())) {
            System.out.println("User already exist");
        } else {
            savedUser = userRepository.save(user);
            if (savedUser == null) {
                System.out.println("user already exist");
            }
        }

        return savedUser;


    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();


    }

    @Override
    public User updateUser(User user) {
        user.setUserName(user.getUserName());
        user.setComment(user.getComment());
        return userRepository.save(user);

    }

    @Override
    public User findByName(String name) {

        return userRepository.findByUserName(name);
    }


    @Override
    public User deleteUser(int userId) throws UserNotFoundException {

        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return deleteUser(userId);
        } else {
            throw new UserNotFoundException("User not found");
        }

    }
}