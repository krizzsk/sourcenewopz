package com.didi.hawaii.net;

import android.content.Context;
import com.didi.hawaii.net.http.HttpContext;
import java.util.Map;

public class NetUtil {
    private static String userAgent = "";

    public static class NetResponse {
        public byte[] bytResponse = null;
        public String strCharset = "utf-8";
    }

    public static NetResponse doPost(String str, byte[] bArr) throws Exception {
        return doPost(str, bArr, (Map<String, String>) null);
    }

    public static NetResponse doPost(String str, byte[] bArr, Map<String, String> map) throws Exception {
        try {
            NetResponse netResponse = new NetResponse();
            netResponse.bytResponse = SyncTripCommonNetUtils.doPost(str, bArr, map);
            return netResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void initNet(Context context, String str) {
        userAgent = str;
        if (!SyncTripCommonNetUtils.isIsInited()) {
            SyncTripCommonNetUtils.init(context);
        }
        HttpContext.getInstance().init(context);
    }

    public static NetResponse doGet(String str) throws Exception {
        try {
            NetResponse netResponse = new NetResponse();
            netResponse.bytResponse = SyncTripCommonNetUtils.doGet(str);
            return netResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
