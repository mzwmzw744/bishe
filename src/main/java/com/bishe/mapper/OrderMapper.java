package com.bishe.mapper;

import com.bishe.bean.Address;
import com.bishe.bean.BuyOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface OrderMapper {

int addOrder(BuyOrder buyOrder);
}