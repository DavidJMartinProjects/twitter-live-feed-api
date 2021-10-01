package com.twitter.app.twitter.listener;

import com.twitter.app.message.producer.MessageProducer;
import com.twitter.app.model.dto.TweetDto;
import com.twitter.app.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;

/**
 * @author david
 */
@Component
@Slf4j
public class TweetListener extends StatusAdapter {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private TweetService tweetService;

    @Override
    public void onStatus(Status status) {
        TweetDto tweet = TweetDto.builder()
            .createdAt(String.valueOf(status.getCreatedAt().getTime()))
            .user(status.getUser().getScreenName())
            .text(status.getText())
            .place(status.getPlace().getCountry())
            .build();

        tweetService.saveTweet(tweet);
        messageProducer.sendMessage(tweet);
    }

}
