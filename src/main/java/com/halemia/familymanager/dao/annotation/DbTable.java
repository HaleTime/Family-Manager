package com.halemia.familymanager.dao.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 19:11
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DbTable {

    String value();
}
