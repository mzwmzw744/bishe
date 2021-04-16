package com.bishe.mapper;

import com.bishe.bean.Address;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface AddressMapper {

    int addUserAddress(Address address);

    List<Address> getUserAddress(int user_id);

    int deleteUserAddress(int user_id);
}