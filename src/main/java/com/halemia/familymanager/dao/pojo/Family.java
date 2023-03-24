package com.halemia.familymanager.dao.pojo;

import com.halemia.familymanager.dao.annotation.DbField;
import com.halemia.familymanager.dao.annotation.DbTable;
import com.halemia.familymanager.dao.pojo.base.Dao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@DbTable("t_family")
public class Family extends Dao implements Serializable {

    private Long id;
    @DbField("family_name")
    private String familyName;

}
