package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class Configuration extends ModelObject {
    public static final ModelObject.Creator<Configuration> CREATOR = new ModelObject.Creator<>(Configuration.class);
    public static final ModelObject.Serializer<Configuration> SERIALIZER = new ModelObject.Serializer<Configuration>() {
        public JSONObject serialize(Configuration configuration) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Configuration.f671a, configuration.getMerchantId());
                jSONObject.putOpt(Configuration.f672b, configuration.getGatewayMerchantId());
                jSONObject.putOpt("intent", configuration.getIntent());
                jSONObject.putOpt(Configuration.f674d, configuration.getKoreanAuthenticationRequired());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(PaymentMethod.class, e);
            }
        }

        public Configuration deserialize(JSONObject jSONObject) {
            Configuration configuration = new Configuration();
            configuration.setMerchantId(jSONObject.optString(Configuration.f671a, (String) null));
            configuration.setGatewayMerchantId(jSONObject.optString(Configuration.f672b, (String) null));
            configuration.setIntent(jSONObject.optString("intent", (String) null));
            configuration.setKoreanAuthenticationRequired(jSONObject.optString(Configuration.f674d, (String) null));
            return configuration;
        }
    };

    /* renamed from: a */
    private static final String f671a = "merchantId";

    /* renamed from: b */
    private static final String f672b = "gatewayMerchantId";

    /* renamed from: c */
    private static final String f673c = "intent";

    /* renamed from: d */
    private static final String f674d = "koreanAuthenticationRequired";

    /* renamed from: e */
    private String f675e;

    /* renamed from: f */
    private String f676f;

    /* renamed from: g */
    private String f677g;

    /* renamed from: h */
    private String f678h;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getMerchantId() {
        return this.f675e;
    }

    public String getGatewayMerchantId() {
        return this.f676f;
    }

    public String getIntent() {
        return this.f677g;
    }

    public String getKoreanAuthenticationRequired() {
        return this.f678h;
    }

    public void setMerchantId(String str) {
        this.f675e = str;
    }

    public void setGatewayMerchantId(String str) {
        this.f676f = str;
    }

    public void setIntent(String str) {
        this.f677g = str;
    }

    public void setKoreanAuthenticationRequired(String str) {
        this.f678h = str;
    }
}
