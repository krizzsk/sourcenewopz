package com.didichuxing.diface.utils.http;

import java.io.Serializable;

public class BaseResult implements Serializable {
    public static final int API_CODE_SUCCESS = 200;
    public static final int CODE_FAILED_IO_ERROR = 1;
    public static final int CODE_FAILED_SERVER_ERROR = 2;
    public static final int CODE_PARSE_JSON_ERROR = 4;
    public static final int CODE_SUCCESS = 100000;
    public static final int CODE_USER_CANCEL = 3;
    public int apiCode;
    public String apiMsg;
    public String token;

    public String toString() {
        return "BaseResult{apiCode=" + this.apiCode + ", apiMsg='" + this.apiMsg + '\'' + '}';
    }
}
