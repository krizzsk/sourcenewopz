package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChooseImageResp {
    public static final int CODE_FAIL_NO_PERMISSIONS = 1001;
    public static final int CODE_FAIL_UNKNOWN_ERROR = 1003;
    public static final int CODE_FAIL_USER_CANCEL = 1002;
    public static final int CODE_OK = 1000;
    public static final String IMAGE_PATH_PREFIX = "dimina://";
    public final int code;
    public final Data data = new Data();
    public final String msg;

    /* renamed from: a */
    private String m12772a(int i) {
        switch (i) {
            case 1000:
                return "ok";
            case 1001:
                return "no permissions";
            case 1002:
                return "user cancel";
            default:
                return "unknown error";
        }
    }

    public ChooseImageResp(int i) {
        this.code = i;
        this.msg = m12772a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55735a(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            for (int i = 0; i < length; i++) {
                strArr2[i] = IMAGE_PATH_PREFIX + strArr[i];
            }
            this.data.tempFilePaths = new String[length];
            System.arraycopy(strArr2, 0, this.data.tempFilePaths, 0, length);
        }
    }

    public static class Data {
        public String[] tempFilePaths;

        /* access modifiers changed from: package-private */
        public boolean havePaths() {
            String[] strArr = this.tempFilePaths;
            return strArr != null && strArr.length > 0;
        }
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.code);
            jSONObject.put("msg", this.msg);
            if (this.code != 1000) {
                jSONObject.put("data", new JSONObject());
            } else if (this.data == null || !this.data.havePaths()) {
                jSONObject.put("data", new JSONObject());
            } else {
                JSONArray jSONArray = new JSONArray();
                for (String put : this.data.tempFilePaths) {
                    jSONArray.put(put);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tempFilePaths", jSONArray);
                jSONObject.put("data", jSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static ChooseImageResp buildOne(int i, String... strArr) {
        ChooseImageResp chooseImageResp = new ChooseImageResp(i);
        chooseImageResp.mo55735a(strArr);
        return chooseImageResp;
    }
}
