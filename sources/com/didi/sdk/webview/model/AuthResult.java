package com.didi.sdk.webview.model;

import android.text.TextUtils;
import androidx.core.provider.FontsContractCompat;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthResult {

    /* renamed from: a */
    private String f38489a;

    /* renamed from: b */
    private String f38490b;

    /* renamed from: c */
    private String f38491c;

    /* renamed from: d */
    private String f38492d;

    /* renamed from: e */
    private String f38493e;

    /* renamed from: f */
    private String f38494f;

    public AuthResult(Map<String, String> map, boolean z) {
        if (map != null) {
            for (String next : map.keySet()) {
                if (TextUtils.equals(next, "resultStatus")) {
                    this.f38489a = map.get(next);
                } else if (TextUtils.equals(next, "result")) {
                    this.f38490b = map.get(next);
                } else if (TextUtils.equals(next, "memo")) {
                    this.f38491c = map.get(next);
                }
            }
            for (String str : this.f38490b.split(ParamKeys.SIGN_AND)) {
                if (str.startsWith("alipay_open_id")) {
                    this.f38494f = m27271a(m27270a("alipay_open_id=", str), z);
                } else if (str.startsWith(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE)) {
                    this.f38493e = m27271a(m27270a("auth_code=", str), z);
                } else if (str.startsWith(FontsContractCompat.Columns.RESULT_CODE)) {
                    this.f38492d = m27271a(m27270a("result_code=", str), z);
                }
            }
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultStatus", this.f38489a);
            jSONObject.put("result", this.f38490b);
            jSONObject.put("memo", this.f38491c);
            jSONObject.put(StatusResponse.RESULT_CODE, this.f38492d);
            jSONObject.put("authCode", this.f38493e);
            jSONObject.put("alipayOpenId", this.f38494f);
            return jSONObject.toString();
        } catch (Exception | JSONException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private String m27271a(String str, boolean z) {
        if (!z || TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(Const.jsQuote)) {
            str = str.replaceFirst(Const.jsQuote, "");
        }
        return str.endsWith(Const.jsQuote) ? str.substring(0, str.length() - 1) : str;
    }

    public String toString() {
        return "resultStatus={" + this.f38489a + "};memo={" + this.f38491c + "};result={" + this.f38490b + "}";
    }

    /* renamed from: a */
    private String m27270a(String str, String str2) {
        return str2.substring(str.length(), str2.length());
    }

    public String getResultStatus() {
        return this.f38489a;
    }

    public String getMemo() {
        return this.f38491c;
    }

    public String getResult() {
        return this.f38490b;
    }

    public String getResultCode() {
        return this.f38492d;
    }

    public String getAuthCode() {
        return this.f38493e;
    }

    public String getAlipayOpenId() {
        return this.f38494f;
    }
}
