package com.didichuxing.dfbasesdk.data;

import java.io.Serializable;

public class NewBaseResult<T> {
    public static final int CODE_BIZ_SUCCESS = 100000;
    public static final int CODE_FAILED_IO_ERROR = 1;
    public static final int CODE_FAILED_SERVER_ERROR = 2;
    public static final int CODE_GATEWAY_SUCCESS = 200;
    public static final int CODE_PARSE_JSON_ERROR = 4;
    public static final int CODE_USER_CANCEL = 3;
    public int apiCode;
    public String apiMsg;
    public Data<T> data;

    public static class Data<T> implements Serializable {
        public int code;
        public String message;
        public T result;
    }
}
