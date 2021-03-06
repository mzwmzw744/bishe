package com.bishe.mapper;

import com.bishe.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User getUserByEmail(String email);

    User getUserByUserName(String Phone);

    List<User> getAllUser();

    int addUser(User user);

    int getUserIsRepeat(User user);


}

