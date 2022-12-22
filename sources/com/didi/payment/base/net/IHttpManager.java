package com.didi.payment.base.net;

import android.content.Context;
import java.util.Map;

public interface IHttpManager {
    void download(String str, String str2, DownCallback downCallback);

    void get(String str, Map<String, String> map, Map<String, Object> map2, HttpCallback httpCallback);

    void init(Context context, HttpConfig httpConfig);

    void post(String str, Map<String, String> map, Map<String, Object> map2, HttpCallback httpCallback);

    void post(String str, Map<String, String> map, Map<String, Object> map2, Map<String, Object> map3, HttpCallback httpCallback);
}
