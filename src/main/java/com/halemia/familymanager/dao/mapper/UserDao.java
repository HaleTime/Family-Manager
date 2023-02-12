package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.pojo.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User getUserById(int id);

    @Insert("INSERT into t_user(name,password,admin) values(#{name},#{password},#{admin})")
    int insert(User user);

    @Update("UPDATE t_user set name=#{name},password=#{password} WHERE id = #{id}")
    boolean update(User user);

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    boolean delete(int id);

}
