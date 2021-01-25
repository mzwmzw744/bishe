package com.bishe.mapper;

import com.bishe.bean.Admin;
import com.bishe.bean.AdminApply;
import com.bishe.bean.User;
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

//    insert into superAdministratorApply values (null,'小华6','123','超级管理员','我是小华6',true,true,true,true)
// @Insert("insert into superAdministratorApply values (null,#{name},#{password},#{applyGrade},#{applyRemarks},true,true,true,true)")

}

