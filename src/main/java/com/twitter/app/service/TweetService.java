package com.twitter.app.service;

import com.twitter.app.model.dto.TweetDto;
import com.twitter.app.model.entity.TweetEntity;
import com.twitter.app.model.mapper.TweetMapper;
import com.twitter.app.repository.TweetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author david
 */
@Service
@Slf4j
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
            .sorted((t1, t2) -> Long.compare(t2.getId(), t1.getId()))
            .collect(Collectors.toList());
    }

    public TweetDto saveTweet(TweetDto tweetDto) {
        TweetEntity tweet = tweetRepository.save(tweetMapper.toEntity(tweetDto));
        log.info("[x] saved tweet");
        return tweetMapper.toDto(tweet);
    }

}
