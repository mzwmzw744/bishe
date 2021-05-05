package com.bishe.mapper;

import com.bishe.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BackstageMapper {

    Admin getAdminByName(String adminName);

    Admin getAdminPowerById(int id);

    @Select("select * from adminApply")
     List<AdminApply>  getAllAdministratorApply();


    @Insert("insert into adminApply values (null,#{name},#{password},#{applyGrade},#{applyRemarks},#{addPower},#{deletePower},#{updatePower},#{selectPower})")
    int addAdministratorApply(AdminApply administratorApply);

    List<Shop> getAllShopByTime();

    int updateShopAuditStatusTj(int id);

    int updateShopAuditStatusQxTj(int id);

    int setMessage(String message);

    String getMessage();

    List<ShopFamilyAccount> getAccountByShopFamily();
}

