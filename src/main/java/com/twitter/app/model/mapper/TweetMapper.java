package com.twitter.app.model.mapper;

import com.twitter.app.model.dto.TweetDto;
import com.twitter.app.model.entity.TweetEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author david
 */
@Component
@Slf4j
public class TweetMapper {

    private ModelMapper modelMapper;

    public TweetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TweetDto toDto(TweetEntity tweetEntity) {
        log.debug("mapping entity with id: {} to dto.", tweetEntity.getId());
        return modelMapper.map(tweetEntity, TweetDto.class);
    }

    public TweetEntity toEntity(TweetDto tweetDto) {
        log.debug("mapping dto with to entity.");
        return modelMapper.map(tweetDto, TweetEntity.class);
    }

}
