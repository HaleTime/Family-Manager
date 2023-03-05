package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.pojo.Position;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PositionDao {

    @Select("SELECT * FROM t_position WHERE id = #{id}")
    Position getPositionById(int id);

    @Insert("INSERT into t_position(id,position_name,family_id) values(#{id},#{positionName},#{familyId})")
    int insert(Position position);

    @Update("UPDATE t_position set position_name=#{positionName} WHERE id = #{id}")
    boolean update(Position position);

    @Delete("DELETE FROM t_position WHERE id = #{id}")
    boolean delete(int id);

}
