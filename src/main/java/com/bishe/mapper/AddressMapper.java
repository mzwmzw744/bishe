package com.bishe.mapper;

import com.bishe.bean.Address;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface AddressMapper {

    int addUserAddress(Address address);

    Address getUserAddress(int user_id);

    int deleteUserAddress(int user_id);
}