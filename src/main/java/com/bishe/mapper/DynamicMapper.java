package com.bishe.mapper;

import com.bishe.bean.Comment;
import com.bishe.bean.Dynamic;
import com.bishe.bean.GiveUp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DynamicMapper {
    int addMyDynamicPic_1(String url,int id);

    int addMyDynamicPic_2(String url,int id);

    int addMyDynamicPic_3(String url,int id);

    int addMyDynamicPic_4(String url,int id);

    int addMyDynamicPic_5(String url,int id);

    int addMyDynamicPic_6(String url,int id);

    int addMyDynamicPic_7(String url,int id);

    int addMyDynamicPic_8(String url,int id);

    int addMyDynamicPic_9(String url,int id);

    int createUserDynamic(Dynamic dynamic);

    List<Dynamic> getDynamicByTime(int pageSize, int offset);

    int tjpl(Comment comment);

    List<Comment> ckpl(int id);

    int pldz(GiveUp giveUp);

    int ckdzsfcf(GiveUp giveUp);

    int szdzsl(String dzsl,int id);

    String getDzsl(int id);

    List<Dynamic> getDynamicByUserId(int userId);
}
