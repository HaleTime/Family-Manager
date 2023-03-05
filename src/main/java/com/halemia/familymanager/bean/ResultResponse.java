package com.halemia.familymanager.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 21:29
 */
@Getter
@Setter
@AllArgsConstructor
public class ResultResponse {

    private String code;
    private String msg;
    private Object data;

}
