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
@DbTable("t_item")
public class Item extends BaseDao implements Serializable {

    private Long id;
    @DbField("item_name")
    private String itemName;
    private String icon;
    private Float num;
    private Long validity;
    private String tag;
    @DbField("position_id")
    private Long positionId;
    @DbField("user_id")
    private Long userId;
    @DbField("created_at")
    private Long createdAt;
}
