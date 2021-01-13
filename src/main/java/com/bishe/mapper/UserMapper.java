package com.bishe.mapper;

import com.bishe.bean.Test;
import com.bishe.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    Test Test();

    User getUserByEmail(String email);

    User getUserByUserName(String Phone);

    int addUser(User user);

    int getUserIsRepeat(User user);
    
}

