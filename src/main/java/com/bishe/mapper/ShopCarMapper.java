package com.bishe.mapper;

import com.bishe.bean.Address;
import com.bishe.bean.ShopCarBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ShopCarMapper {
    int addShopCar(ShopCarBean shopCarBean);

    List<ShopCarBean> getShopCar(int userId);

    int deleteShopCar(int shop_id,int user_id);

}