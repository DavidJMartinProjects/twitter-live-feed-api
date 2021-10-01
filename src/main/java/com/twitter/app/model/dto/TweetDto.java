package com.twitter.app.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author david
 */
@Data
@Builder
public class TweetDto {

    private long id;

    private String createdAt;
    private String text;
    private String place;
    private String user;

}
