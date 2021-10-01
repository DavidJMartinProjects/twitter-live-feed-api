package com.twitter.app.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * @author david
 */
@Entity
@Table(name = "tweet")
@Data
@Builder
public class TweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String createdAt;
    private String text;
    private String place;

    @Column(name = "user_")
    private String user;

}
