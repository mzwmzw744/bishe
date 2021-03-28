package com.bishe.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexShopMapper {
    /**
     * 首页最新
     * @return 首页最新上架商品
     */
    List getShopNew();
}
