package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.pojo.base.Dao;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CommonDao {

    @SelectProvider(type = SqlProvider.class, method = "getById")
    <T extends Dao> T getById(@Param("id") Long id, Class<T> daoClass);

    @SelectProvider(type = SqlProvider.class, method = "getByCondition")
    <T extends Dao> List<T> getByCondition(Map<String, Object> condistion, Class<T> daoClass);

    @SelectProvider(type = SqlProvider.class, method = "getByDao")
    <T extends Dao> List<T> getByDao(Dao dao);

    @InsertProvider(type = SqlProvider.class, method = "insert")
    Long insert(Dao dao);

    @UpdateProvider(type = SqlProvider.class, method = "update")
    boolean update(Dao dao);

    @DeleteProvider(type = SqlProvider.class, method = "delete")
    boolean delete(Long id, Class<? extends Dao> daoClass);

}
