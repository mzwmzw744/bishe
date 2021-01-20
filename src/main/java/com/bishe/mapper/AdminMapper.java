package com.bishe.mapper;

import com.bishe.bean.Admin;
import com.bishe.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMapper {
    Admin getAdminByName(String adminName);
}

