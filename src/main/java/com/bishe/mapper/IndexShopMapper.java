package com.bishe.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IndexShopMapper {
    /**
     * 首页最新
     * @return 首页最新上架商品
     */
    List getShopNew(int page,int offset);

    List getLikeShop(int page,int offset);
}
