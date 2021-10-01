package com.twitter.app.service;

import com.twitter.app.model.dto.TweetDto;
import com.twitter.app.model.entity.TweetEntity;
import com.twitter.app.model.mapper.TweetMapper;
import com.twitter.app.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author david
 */
@Service
public class TweetService {

    private final TweetMapper tweetMapper;

    private final TweetRepository tweetRepository;

    @Autowired
    public TweetService(TweetMapper tweetMapper, TweetRepository tweetRepository) {
        this.tweetMapper = tweetMapper;
        this.tweetRepository = tweetRepository;
    }

    public List<TweetDto> getTweets() {
        return tweetRepository.findAll()
                .stream()
                .map(tweetMapper::toDto)
                .collect(Collectors.toList());
    }

    public TweetDto saveTweet(TweetDto tweetDto) {
        TweetEntity tweet = tweetRepository.save(tweetMapper.toEntity(tweetDto));
        return tweetMapper.toDto(tweet);
    }

}
