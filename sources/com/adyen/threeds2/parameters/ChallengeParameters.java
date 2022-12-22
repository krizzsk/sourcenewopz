package com.adyen.threeds2.parameters;

import android.content.Context;

public final class ChallengeParameters {

    /* renamed from: a */
    private String f1081a;

    /* renamed from: b */
    private String f1082b;

    /* renamed from: c */
    private String f1083c;

    /* renamed from: d */
    private String f1084d;

    /* renamed from: e */
    private String f1085e;

    public static String getEmbeddedRequestorAppURL(Context context) {
        return "adyen3ds2://" + context.getPackageName();
    }

    public String get3DSServerTransactionID() {
        return this.f1081a;
    }

    public String getAcsRefNumber() {
        return this.f1083c;
    }

    public String getAcsSignedContent() {
        return this.f1084d;
    }

    public String getAcsTransactionID() {
        return this.f1082b;
    }

    public String getThreeDSRequestorAppURL() {
        return this.f1085e;
    }

    public void set3DSServerTransactionID(String str) {
        this.f1081a = str;
    }

    public void setAcsRefNumber(String str) {
        this.f1083c = str;
    }

    public void setAcsSignedContent(String str) {
        this.f1084d = str;
    }

    public void setAcsTransactionID(String str) {
        this.f1082b = str;
    }

    public void setThreeDSRequestorAppURL(String str) {
        this.f1085e = str;
    }
}
