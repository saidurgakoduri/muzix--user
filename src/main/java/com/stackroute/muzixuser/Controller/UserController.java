package com.stackroute.muzixuser.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


        import com.stackroute.muzixuser.domain.User;
        import com.stackroute.muzixuser.exceptions.UserAlreadyExistsException;
        import com.stackroute.muzixuser.exceptions.UserNotFoundException;
        import com.stackroute.muzixuser.service.UserService;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value="Muzix", description="user")
public class UserController
{
    private UserService userService;
    ResponseEntity responseEntity;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Accept user into repository")
    @PostMapping("user")
    public ResponseEntity<?> saveTrack(@RequestBody User user) throws UserAlreadyExistsException,UserNotFoundException
    {

        try {
            userService.saveUser(user);
            responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
        }catch (UserAlreadyExistsException ex)
        {
            responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }

    @ApiOperation(value = "return user into repository")
    @GetMapping("user")
    public ResponseEntity<?> getAllTracks()
    {
        return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping("userByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name)
    {

        User track = userService.findByName(name);
        return new ResponseEntity<User>(userService.findByName(name),HttpStatus.OK);

    }


    @ApiOperation(value = "update user into repository")
    @PutMapping("user")
    public  ResponseEntity<?> updateTrack(@RequestBody User user)
    {

        userService.updateUser(user);
        responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "delete user from repository")
    @DeleteMapping("user/{userId}")
    public ResponseEntity<?> deleteTrack(@PathVariable("userId") int userId) throws UserNotFoundException {
        userService.deleteUser(userId);
        responseEntity = new ResponseEntity<String>("deleted", HttpStatus.OK);
        return responseEntity;
    }
}
