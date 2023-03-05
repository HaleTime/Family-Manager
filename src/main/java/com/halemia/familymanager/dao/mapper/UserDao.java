package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.pojo.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User getUserById(Long id);

    @Insert("INSERT into t_user(id,name,password,admin,open_id,family_id) values(#{id},#{name},#{password},#{admin},#{openId},#{familyId})")
    int insert(User user);

    @UpdateProvider(type = SqlProvider.class, method = "update")
    boolean update(User user);

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    boolean delete(Long id);

}
