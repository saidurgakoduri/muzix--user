package com.stackroute.muzixuser.seeddata;


        import com.stackroute.muzixuser.domain.User;
        import com.stackroute.muzixuser.exceptions.UserAlreadyExistsException;
        import com.stackroute.muzixuser.service.UserService;

        import com.stackroute.muzixuser.service.UserService;
        import lombok.Data;

        import org.springframework.beans.factory.annotation.Autowired;

        import org.springframework.context.ApplicationListener;

        import org.springframework.context.annotation.Primary;

        import org.springframework.context.event.ContextRefreshedEvent;

        import org.springframework.core.env.Environment;

        import org.springframework.stereotype.Component;

@Component

@Data

@Primary

public class SeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>

{

    @Autowired

    Environment environment;

    @Autowired

    UserService userService;

    User feedUserData=new User();

    @Override

    public void onApplicationEvent(ContextRefreshedEvent event)

    {

        feedUserData.setUserId(Integer.parseInt(environment.getProperty("song.1.trackId")));

        feedUserData.setUserName(environment.getProperty("song.1.trackName"));

        feedUserData.setComment(environment.getProperty("song.1.comment"));

        try {

            userService.saveUser(feedUserData);

        } catch (UserAlreadyExistsException e) {

            e.printStackTrace();

        }

        feedUserData.setUserId(Integer.parseInt(environment.getProperty("song.2.trackId")));

        feedUserData.setUserName(environment.getProperty("song.2.trackName"));

        feedUserData.setComment(environment.getProperty("song.2.comment"));

        try {

            userService.saveUser(feedUserData);

        } catch (UserAlreadyExistsException e) {

            e.printStackTrace();

        }

        feedUserData.setUserId(Integer.parseInt(environment.getProperty("song.3.trackId")));

        feedUserData.setUserName(environment.getProperty("song.3.trackName"));

        feedUserData.setComment(environment.getProperty("song.3.comment"));

        try {

            userService.saveUser(feedUserData);

        } catch (UserAlreadyExistsException e) {

            e.printStackTrace();

        }



    }

}