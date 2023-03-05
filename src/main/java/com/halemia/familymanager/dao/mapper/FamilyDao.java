package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.pojo.Family;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FamilyDao {

    @Select("SELECT * FROM t_family WHERE id = #{id}")
    Family getFamilyById(int id);

    @Insert("INSERT into t_family(id,family_name,family_id) values(#{id},#{familyName},#{familyId})")
    int insert(Family family);

    @Update("UPDATE t_family set family_name=#{familyName} WHERE id = #{id}")
    boolean update(Family family);

    @Delete("DELETE FROM t_family WHERE id = #{id}")
    boolean delete(int id);

}
