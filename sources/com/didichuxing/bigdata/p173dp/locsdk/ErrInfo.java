package com.didichuxing.bigdata.p173dp.locsdk;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ErrInfo */
public class ErrInfo {
    public static final int ERROR_APP_PERMISSION = 201;
    public static final int ERROR_HTTP_QUEUE_FULL = 306;
    public static final int ERROR_HTTP_REQUEST_EXCEPTION = 303;
    public static final int ERROR_HTTP_REQUEST_NORMAL_ERR = 302;
    public static final int ERROR_HTTP_REQUEST_NO_LOCATION_RETURN = 304;
    public static final int ERROR_HTTP_RESPONSE_NULL = 305;
    public static final int ERROR_LOCATION_PERMISSION = 101;
    public static final int ERROR_MODULE_PERMISSION = 202;
    public static final String ERROR_MSG_APP_PERMISSION = "应用没有被授权。";
    public static final String ERROR_MSG_HTTP_QUEUE_FULL = "网络请求队列已满。";
    public static final String ERROR_MSG_HTTP_REQUEST_EXCEPTION = "网络请求出现异常。";
    public static final String ERROR_MSG_HTTP_REQUEST_NORMAL_ERR = "网络请求常规错误。";
    public static final String ERROR_MSG_HTTP_REQUEST_NO_LOCATION_RETURN = "服务器没有返回位置信息。";
    public static final String ERROR_MSG_HTTP_RESPONSE_NULL = "网络请求返回结果异常。";
    public static final String ERROR_MSG_LOCATION_PERMISSION = "无定位权限，请授予应用定位相关权限,并开启定位开关和GPS。";
    public static final String ERROR_MSG_MODULE_PERMISSION = "业务模块没有被授权。";
    public static final String ERROR_MSG_NETWORK_CONNECTION = "网络连接错误，请检查网络。";
    public static final String ERROR_MSG_NO_ELEMENT_FOR_LOCATION = "无法获取用于定位的wifi热点或基站信息。";
    public static final String ERROR_MSG_OK = "成功。";
    public static final String ERROR_MSG_OTHERS = "其他原因引起的定位失败。";
    public static final String ERROR_MSG_TENCENT_BAD_JSON = "其他原因引起的定位失败。";
    public static final String ERROR_MSG_TENCENT_NETWORK = "网络请求出现异常。";
    public static final String ERROR_MSG_TENCENT_WGS84 = "其他原因引起的定位失败。";
    public static final int ERROR_NETWORK_CONNECTION = 301;
    public static final int ERROR_NO_ELEMENT_FOR_LOCATION = 103;
    public static final int ERROR_OK = 0;
    public static final int ERROR_OTHERS = 1000;
    public static final int ERROR_TENCENT_BAD_JSON = 2;
    public static final int ERROR_TENCENT_NETWORK = 1;
    public static final int ERROR_TENCENT_WGS84 = 4;
    public static final String SOURCE_DIDI = "didi";
    public static final String SOURCE_TENCENT = "tencent";

    /* renamed from: a */
    private int f45689a = 0;

    /* renamed from: b */
    private String f45690b = null;

    /* renamed from: c */
    private int f45691c = 0;

    /* renamed from: d */
    private String f45692d;

    /* renamed from: e */
    private String f45693e = null;

    /* renamed from: f */
    private long f45694f;

    /* renamed from: g */
    private long f45695g = 0;

    /* renamed from: h */
    private String f45696h = null;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo114295a() {
        return this.f45694f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114296a(long j) {
        this.f45694f = j;
    }

    public ErrInfo(int i) {
        this.f45689a = i;
    }

    public ErrInfo() {
    }

    public String getResponseMessage() {
        return this.f45693e;
    }

    public void setResponseMessage(String str) {
        this.f45693e = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo114297b() {
        return this.f45696h;
    }

    public void setRequestExceptionMessage(String str) {
        this.f45696h = str;
    }

    public String getSource() {
        return this.f45692d;
    }

    public void setSource(String str) {
        this.f45692d = str;
    }

    public int getErrNo() {
        return this.f45689a;
    }

    public void setErrNo(int i) {
        this.f45689a = i;
    }

    public String getErrMessage() {
        return this.f45690b;
    }

    public void setErrMessage(String str) {
        this.f45690b = str;
    }

    public int getResponseCode() {
        return this.f45691c;
    }

    public void setResponseCode(int i) {
        this.f45691c = i;
    }

    public void setLocalTime(long j) {
        this.f45695g = j;
    }

    public long getLocalTime() {
        return this.f45695g;
    }

    public String toString() {
        return "{errNo=" + this.f45689a + ", errMsg=" + this.f45690b + "}";
    }
}
