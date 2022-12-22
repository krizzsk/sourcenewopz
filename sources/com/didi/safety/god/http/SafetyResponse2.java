package com.didi.safety.god.http;

import java.io.Serializable;

public class SafetyResponse2<T> implements Serializable {
    public int apiCode;
    public String apiMsg;
    public Data<T> data;

    public static class Data<T> implements Serializable {
        public int code;
        public String message;
        public T result;
    }
}
