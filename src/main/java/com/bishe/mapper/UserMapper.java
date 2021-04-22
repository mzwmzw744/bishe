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

    int userHeadPicUpdate(User user);

    User getUserById(int userID);

    int changePassword(String password,int id);

    int changeUserName(String userName,int id);

    int czBalance(String balance,int id);

    int xfBalance(String balance,int id);
}

