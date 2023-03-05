package com.halemia.familymanager.dao.pojo;

import com.halemia.familymanager.dao.annotation.DbField;
import com.halemia.familymanager.dao.annotation.DbTable;
import com.halemia.familymanager.dao.pojo.base.BaseDao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@DbTable("t_room")
public class Room extends BaseDao implements Serializable {

    private Long id;
    @DbField("room_name")
    private String roomName;

}
