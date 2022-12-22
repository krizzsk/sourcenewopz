package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class WeChatPaySdkData extends SdkData {
    public static final ModelObject.Creator<WeChatPaySdkData> CREATOR = new ModelObject.Creator<>(WeChatPaySdkData.class);
    public static final ModelObject.Serializer<WeChatPaySdkData> SERIALIZER = new ModelObject.Serializer<WeChatPaySdkData>() {
        public JSONObject serialize(WeChatPaySdkData weChatPaySdkData) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("appid", weChatPaySdkData.getAppid());
                jSONObject.putOpt(WeChatPaySdkData.f849b, weChatPaySdkData.getNoncestr());
                jSONObject.putOpt(WeChatPaySdkData.f850c, weChatPaySdkData.getPackageValue());
                jSONObject.putOpt(WeChatPaySdkData.f851d, weChatPaySdkData.getPartnerid());
                jSONObject.putOpt(WeChatPaySdkData.f852e, weChatPaySdkData.getPrepayid());
                jSONObject.putOpt("sign", weChatPaySdkData.getSign());
                jSONObject.putOpt("timestamp", weChatPaySdkData.getTimestamp());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(WeChatPaySdkData.class, e);
            }
        }

        public WeChatPaySdkData deserialize(JSONObject jSONObject) {
            WeChatPaySdkData weChatPaySdkData = new WeChatPaySdkData();
            weChatPaySdkData.setAppid(jSONObject.optString("appid", (String) null));
            weChatPaySdkData.setNoncestr(jSONObject.optString(WeChatPaySdkData.f849b, (String) null));
            weChatPaySdkData.setPackageValue(jSONObject.optString(WeChatPaySdkData.f850c, (String) null));
            weChatPaySdkData.setPartnerid(jSONObject.optString(WeChatPaySdkData.f851d, (String) null));
            weChatPaySdkData.setPrepayid(jSONObject.optString(WeChatPaySdkData.f852e, (String) null));
            weChatPaySdkData.setSign(jSONObject.optString("sign", (String) null));
            weChatPaySdkData.setTimestamp(jSONObject.optString("timestamp", (String) null));
            return weChatPaySdkData;
        }
    };

    /* renamed from: a */
    private static final String f848a = "appid";

    /* renamed from: b */
    private static final String f849b = "noncestr";

    /* renamed from: c */
    private static final String f850c = "packageValue";

    /* renamed from: d */
    private static final String f851d = "partnerid";

    /* renamed from: e */
    private static final String f852e = "prepayid";

    /* renamed from: f */
    private static final String f853f = "sign";

    /* renamed from: g */
    private static final String f854g = "timestamp";

    /* renamed from: h */
    private String f855h;

    /* renamed from: i */
    private String f856i;

    /* renamed from: j */
    private String f857j;

    /* renamed from: k */
    private String f858k;

    /* renamed from: l */
    private String f859l;

    /* renamed from: m */
    private String f860m;

    /* renamed from: n */
    private String f861n;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getAppid() {
        return this.f855h;
    }

    public void setAppid(String str) {
        this.f855h = str;
    }

    public String getNoncestr() {
        return this.f856i;
    }

    public void setNoncestr(String str) {
        this.f856i = str;
    }

    public String getPackageValue() {
        return this.f857j;
    }

    public void setPackageValue(String str) {
        this.f857j = str;
    }

    public String getPartnerid() {
        return this.f858k;
    }

    public void setPartnerid(String str) {
        this.f858k = str;
    }

    public String getPrepayid() {
        return this.f859l;
    }

    public void setPrepayid(String str) {
        this.f859l = str;
    }

    public String getSign() {
        return this.f860m;
    }

    public void setSign(String str) {
        this.f860m = str;
    }

    public String getTimestamp() {
        return this.f861n;
    }

    public void setTimestamp(String str) {
        this.f861n = str;
    }
}
