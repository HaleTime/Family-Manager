package com.halemia.familymanager.dao.mapper;

import com.halemia.familymanager.dao.SnowflakeIdWorker;
import com.halemia.familymanager.dao.annotation.DbField;
import com.halemia.familymanager.dao.annotation.DbTable;
import com.halemia.familymanager.dao.pojo.base.Dao;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 19:07
 */
public class SqlProvider implements ProviderMethodResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlProvider.class);

    private static final SnowflakeIdWorker SNOWFLAKEIDWORKER = new SnowflakeIdWorker();


    public String insert(Dao dao) {
        Class<? extends Dao> daoClass = dao.getClass();
        String table = getTableName(daoClass);
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(table).append("(");
        Field[] declaredFields = daoClass.getDeclaredFields();
        List<String> dbField = new ArrayList<>();
        List<String> insertValue = new ArrayList<>();
        Arrays.stream(declaredFields).forEach(field -> {
            String name = field.getName();
            if ("id".equalsIgnoreCase(name)) {
                long id = SNOWFLAKEIDWORKER.nextId();
                insertValue.add(id+"");
            }else {
                insertValue.add(String.format("#{%s}", name));
            }
            String fieldName = getFieldName(field);
            dbField.add(fieldName);
        });
        sb.append(String.join(",", dbField))
                .append(") values(")
                .append(String.join(",", insertValue))
                .append(")");

        return sb.toString();
    }

    public String update(Dao dao) {
        Class<? extends Dao> daoClass = dao.getClass();
        String table = getTableName(daoClass);
        Field[] declaredFields = daoClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(table).append(" SET ");
        Arrays.stream(declaredFields).forEach(field -> {
            String name = field.getName();
            if ("id".equalsIgnoreCase(name)) {
                return;
            }
            String dbName = getFieldName(field);
            try {
                Object o = field.get(dao);
                if (o == null) return;
            } catch (IllegalAccessException e) {
                LOGGER.error(e.getMessage(), e);
            }
            sb.append(dbName).append(" = #{").append(name).append("}, ");
        });
        sb.deleteCharAt(sb.length() - 2);
        sb.append(" WHERE id = #{id}");
        return sb.toString();
    }

    public String getById(Long id, Class<? extends Dao> daoClass) {
        String tableName = getTableName(daoClass);
        SQL sql = new SQL();
        select(daoClass, sql);
        sql.FROM(tableName).WHERE("id = #{id}");
        return sql.toString();
    }

    /**
     * 获取select内容
     * @param daoClass
     * @param sql
     */
    private void select(Class<? extends Dao> daoClass, SQL sql) {
        Field[] declaredFields = daoClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            String name = field.getName();
            DbField annotation = field.getAnnotation(DbField.class);
            String select = annotation == null ? name : annotation.value() + " as " + name;
            sql.SELECT(select);
        });
        Class<?> superclass = daoClass.getSuperclass();
        if (superclass == Dao.class) {
            Field[] daoFields = superclass.getDeclaredFields();
            Arrays.stream(daoFields).forEach(field -> {
                String name = field.getName();
                DbField annotation = field.getAnnotation(DbField.class);
                String select = annotation == null ? name : annotation.value() + " as " + name;
                sql.SELECT(select);
            });
        }
    }

    public String getByCondition(Map<String, Object> condistion, Class<? extends Dao> daoClass) {
        String tableName = getTableName(daoClass);
        SQL sql = new SQL();
        select(daoClass, sql);
        sql.FROM(tableName);
        condistion.forEach((key, value) -> sql.WHERE(key + "=" + value));
        return sql.toString();
    }


    public String getByDao(Dao dao) {
        if (dao == null) {
            throw new RuntimeException("Dao cannot be null!");
        }
        Class<? extends Dao> aClass = dao.getClass();
        String tableName = getTableName(aClass);
        SQL sql = new SQL();
        sql.SELECT("*")
                .FROM(tableName);
        Field[] declaredFields = aClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            field.setAccessible(true);
            String key = field.getName();
            Object value = null;
            try {
                value = field.get(dao);
            } catch (IllegalAccessException e) {
                LOGGER.error(e.getMessage(), e);
            }
            if (value == null) return;
            DbField dbField = field.getAnnotation(DbField.class);
            if (dbField != null) {
                key = dbField.value();
            }
            sql.WHERE(key + "=" + value);
        });
        return sql.toString();
    }

    public String delete(Long id, Class<? extends Dao> daoClass) {
        String tableName = getTableName(daoClass);
        return "DELETE FROM " + tableName + " WHERE id = #{id}";
    }

    private String getFieldName(Field field) {
        field.setAccessible(true);
        String name = field.getName();
        DbField fieldAnnotation = field.getAnnotation(DbField.class);
        return fieldAnnotation == null ? name : fieldAnnotation.value();
    }

    private String getTableName(Class<? extends Dao> daoClass) {
        DbTable annotation = daoClass.getAnnotation(DbTable.class);
        if (annotation == null) {
            throw new RuntimeException(String.format("Annotation of 'DbTable' must be on the %s !", daoClass.getSimpleName()));
        }
        return annotation.value();
    }
}
