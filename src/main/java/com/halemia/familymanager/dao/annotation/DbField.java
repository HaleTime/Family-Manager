package com.halemia.familymanager.dao.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 19:11
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DbField {

    String value();
}
