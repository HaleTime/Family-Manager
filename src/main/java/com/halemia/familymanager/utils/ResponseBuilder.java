package com.halemia.familymanager.utils;

import com.halemia.familymanager.bean.ResultResponse;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 21:30
 */
public class ResponseBuilder {

    public static final String SUCCESS = "200";
    public static final String OK = "OK";

    public static ResultResponse success(Object data) {
        return new ResultResponse(SUCCESS, OK, data);
    }

    public static ResultResponse fail(String code, String msg) {
        return new ResultResponse(code, msg, null);
    }
}
