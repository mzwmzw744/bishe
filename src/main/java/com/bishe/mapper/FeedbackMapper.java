package com.bishe.mapper;

import com.bishe.bean.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FeedbackMapper {
    int addFeedback(int userId,String word);

    List<Feedback> getFeedback();
}
