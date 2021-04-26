package com.bishe.mapper;

import com.bishe.bean.Shop;
import com.bishe.bean.ShopMainPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    int updateShopMainPic(String url,int id);

    int updateShopMainPic_1(String url,int id);

    int updateShopMainPic_2(String url,int id);

    int updateShopMainPic_3(String url,int id);

    int updateShopMainPic_4(String url,int id);

    int updateShopMainPic_5(String url,int id);

    int updateShopMainPic_6(String url,int id);

    int updateShopMainPic_7(String url,int id);

    int updateShopMainPic_8(String url,int id);

    int updateShopMainPic_9(String url,int id);

    int updateShopMainPic_10(String url,int id);



    ShopMainPicture getAllShopPicByShopId(@Param("id") int id);

    int updateShopHeadPic(String shopHeadPic,int id );

    int shopMainPictureCreate(Shop shop);

    int shopCreate(Shop shop);

    String shopDelete();

    int getShopAccount(int userId);

    List<Shop> getShopMessage(int userId,@Param("pageSize") int pageSize,@Param("offset") int offset);

    List<Shop> getShopMessageByTime(int userId);

    Shop getShopById(int id);

    int updateShop(Shop shop);

    ShopMainPicture getShopMainPicByShopID(@Param("id") int id);

    int updateShopState(Shop shop);

    List<Shop> getTjShop(int pageSize,int offset);

}
