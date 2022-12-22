package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;

public class NextAlipayResult {
    public String memo;
    public String result;
    public String resultStatus;

    public NextAlipayResult(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                if (str2.startsWith("resultStatus")) {
                    this.resultStatus = m31422a(str2, "resultStatus");
                }
                if (str2.startsWith("result")) {
                    this.result = m31422a(str2, "result");
                }
                if (str2.startsWith("memo")) {
                    this.memo = m31422a(str2, "memo");
                }
            }
        }
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
    }

    /* renamed from: a */
    private String m31422a(String str, String str2) {
        if (TextUtil.isEmpty(str)) {
            return "";
        }
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }
}
