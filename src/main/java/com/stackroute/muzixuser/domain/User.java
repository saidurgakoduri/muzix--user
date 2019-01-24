package com.stackroute.muzixuser.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


//import javax.persistence.*;

@Document(collection="Users")
//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    private String comment;

//    public Track( String trackName, String comment) {
//        this.trackName = trackName;
//        this.comment = comment;
//    }
}
