package com.didichuxing.dfbasesdk.algomodel;

import java.util.List;

public class AlgoModelConfigResult {
    public Data data;

    public static class Data {
        public int code;
        public String message;
        public List<ResultModel> result;
    }

    public static class ResultModel {
        public String md5;
        public int type;
        public String url;
    }
}
