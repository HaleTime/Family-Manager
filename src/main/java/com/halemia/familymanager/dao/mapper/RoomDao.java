package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RoomDao {

    @Select("SELECT * FROM t_room WHERE id = #{id}")
    Room getRoomById(int id);

    @Insert("INSERT into t_room(id,room_name,family_id) values(#{id},#{roomName},#{familyId})")
    int insert(Room room);

    @Update("UPDATE t_room set room_name=#{roomName} WHERE id = #{id}")
    boolean update(Room room);

    @Delete("DELETE FROM t_room WHERE id = #{id}")
    boolean delete(int id);

}
