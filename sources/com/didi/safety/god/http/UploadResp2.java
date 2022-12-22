package com.didi.safety.god.http;

public class UploadResp2 extends AbsX1Resp {
    public static final int UPLOAD_CODE_100001 = 100001;
    public static final int UPLOAD_CODE_100004 = 100004;
    public static final int UPLOAD_CODE_100005 = 100005;
    public static final int UPLOAD_CODE_100006 = 100006;
    public static final int UPLOAD_CODE_100013 = 100013;
    public static final int UPLOAD_CODE_100016 = 100016;
    public static final int UPLOAD_CODE_200001 = 200001;
    public static final int UPLOAD_CODE_200005 = 200005;
    public static final int UPLOAD_CODE_300001 = 300001;
    public static final int UPLOAD_CODE_OK = 100000;
    public static final int UPLOAD_CODE_VIN_NOT_CONSISTENT = 100012;
    public String body;
    public String bugFieldTips;
    public String content;
    public String[] fieldMiss = new String[0];
    public String highImg;
    public OcrValue ocrValue;
    public String tailoringImg;
    public String title;
    public String vin;

    public static boolean isSpecialFailCode(int i) {
        return i == 100004 || i == 100005 || i == 100006 || i == 100001 || i == 200001 || i == 200005 || i == 100013 || i == 300001 || i == 100016;
    }
}
