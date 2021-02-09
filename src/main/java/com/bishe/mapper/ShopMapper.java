package com.bishe.mapper;

import com.bishe.bean.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {

    int shopCreate(Shop shop);

    String shopDelete();

    int getShopAccount(int userId);

    List<Shop> getShopMessage(int userId,int min,int max);
}
