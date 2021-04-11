package com.bishe.mapper;

import com.bishe.bean.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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


}
