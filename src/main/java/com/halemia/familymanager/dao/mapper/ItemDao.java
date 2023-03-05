package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.pojo.Item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ItemDao {

    @Select("SELECT * FROM t_item WHERE id = #{id}")
    Item getItemById(int id);

    @Insert("INSERT into t_item(id,item_name,icon,num,validity,tag,position_id,user_id,created_at,family_id)" +
            " values(#{id},#{itemName},#{icon},#{num},#{validity},#{tag},#{positionId},#{userId},#{createdAt},#{familyId})")
    int insert(Item item);

    @Update("UPDATE t_item set item_name=#{item_name},icon=#{icon},num=#{num},validity=#{validity},tag=#{tag},position_id=#{positionId} WHERE id = #{id}")
    boolean update(Item item);

    @Delete("DELETE FROM t_item WHERE id = #{id}")
    boolean delete(int id);

}
