package com.halemia.familymanager.dao.pojo.base;

import com.halemia.familymanager.dao.annotation.DbField;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 18:32
 */

@Getter
@Setter
public class BaseDao extends Dao{

    @DbField("family_id")
    private Long familyId;

}
