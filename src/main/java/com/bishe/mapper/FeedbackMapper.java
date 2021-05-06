package com.bishe.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FeedbackMapper {
    int addFeedback(int userId,String word);
}
