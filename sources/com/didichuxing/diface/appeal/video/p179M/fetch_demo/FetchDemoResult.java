package com.didichuxing.diface.appeal.video.p179M.fetch_demo;

import com.didichuxing.diface.data.BaseResult;
import java.io.Serializable;

/* renamed from: com.didichuxing.diface.appeal.video.M.fetch_demo.FetchDemoResult */
public class FetchDemoResult extends BaseResult {
    public Data data;

    /* renamed from: com.didichuxing.diface.appeal.video.M.fetch_demo.FetchDemoResult$Data */
    public static class Data implements Serializable {
        public int code;
        public String message;
        public Result result;

        /* renamed from: com.didichuxing.diface.appeal.video.M.fetch_demo.FetchDemoResult$Data$Result */
        public static class Result implements Serializable {
            public String demoPhotoUrl;
            public String teachVideoUrl;
        }
    }
}
