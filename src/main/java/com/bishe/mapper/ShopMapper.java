package com.bishe.mapper;

import com.bishe.bean.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    int updateShopHeadPic(String shopHeadPic,int id );

    int shopMainPictureCreate(Shop shop);

    int shopCreate(Shop shop);

    String shopDelete();

    int getShopAccount(int userId);

    List<Shop> getShopMessage(int userId,int min,int max);

    Shop getShopById(int id);

    int updateShop(Shop shop);
}
