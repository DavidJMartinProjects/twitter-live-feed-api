package com.twitter.app.service;

import java.util.List;

import com.twitter.app.model.dto.TweetDto;

/**
 * @author DavidJMartin
 */
public interface TweetService {
    List<TweetDto> getTweets();
    TweetDto saveTweet(TweetDto tweetDto);
}
