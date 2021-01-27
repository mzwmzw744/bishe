package com.bishe.mapper;

import com.bishe.bean.Admin;
import com.bishe.bean.AdminApply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMapper {

    @Select("select * from adminApply where id = #{id}")
    AdminApply adminApplySelectByID(int id);

    @Delete("delete from adminApply where id = #{id}")
    int adminApplyDeleteByID(int id);

    @Insert("Insert into admin values(#{id},#{name},#{password},#{face})")
    int adminInsert(Admin admin);

    List<Admin>  adminInformationQuery();
}