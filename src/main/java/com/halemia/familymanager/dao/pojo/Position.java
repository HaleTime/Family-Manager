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
@DbTable("t_position")
public class Position extends BaseDao implements Serializable {

    private Long id;
    @DbField("position_name")
    private String positionName;

}
