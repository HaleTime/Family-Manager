package com.halemia.familymanager.dao.pojo;

import com.halemia.familymanager.dao.annotation.DbField;
import com.halemia.familymanager.dao.annotation.DbTable;
import com.halemia.familymanager.dao.pojo.base.BaseDao;
import com.halemia.familymanager.dao.pojo.base.Dao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@DbTable("t_user")
public class User extends BaseDao implements Serializable {

    private Long id;
    private String name;
    private String password;
    private String admin;
    @DbField("open_id")
    private String openId;
}
