package com.didi.payment.creditcard.global.model;

import com.didi.payment.creditcard.base.encryption.LianLianEncryptUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalBankCardInfo {

    /* renamed from: a */
    private String f30364a = "";

    /* renamed from: b */
    private String f30365b = "";

    /* renamed from: c */
    private String f30366c = "";

    /* renamed from: d */
    private String f30367d = "";

    public void setNumber(String str) {
        this.f30364a = str;
    }

    public void setCvc(String str) {
        this.f30365b = str;
    }

    public void setExpiryMonth(String str) {
        this.f30366c = str;
    }

    public void setExpiryYear(String str) {
        this.f30367d = str;
    }

    public String encryptWithAES(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("number", this.f30364a);
            jSONObject.put("cvc", this.f30365b);
            jSONObject.put("expirationMonth", this.f30366c);
            jSONObject.put("expirationYear", this.f30367d);
            return LianLianEncryptUtils.encryptWithAES(jSONObject.toString(), str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
