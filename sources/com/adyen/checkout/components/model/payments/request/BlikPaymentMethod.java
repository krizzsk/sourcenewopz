package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class BlikPaymentMethod extends PaymentMethodDetails {
    public static final ModelObject.Creator<BlikPaymentMethod> CREATOR = new ModelObject.Creator<>(BlikPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "blik";
    public static final ModelObject.Serializer<BlikPaymentMethod> SERIALIZER = new ModelObject.Serializer<BlikPaymentMethod>() {
        public JSONObject serialize(BlikPaymentMethod blikPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", blikPaymentMethod.getType());
                jSONObject.putOpt(BlikPaymentMethod.f746a, blikPaymentMethod.getBlikCode());
                jSONObject.putOpt(BlikPaymentMethod.f747b, blikPaymentMethod.getStoredPaymentMethodId());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(BlikPaymentMethod.class, e);
            }
        }

        public BlikPaymentMethod deserialize(JSONObject jSONObject) {
            BlikPaymentMethod blikPaymentMethod = new BlikPaymentMethod();
            blikPaymentMethod.setType(jSONObject.optString("type", (String) null));
            blikPaymentMethod.setBlikCode(jSONObject.optString(BlikPaymentMethod.f746a, (String) null));
            blikPaymentMethod.setStoredPaymentMethodId(jSONObject.optString(BlikPaymentMethod.f747b, (String) null));
            return blikPaymentMethod;
        }
    };

    /* renamed from: a */
    private static final String f746a = "blikCode";

    /* renamed from: b */
    private static final String f747b = "storedPaymentMethodId";

    /* renamed from: c */
    private String f748c;

    /* renamed from: d */
    private String f749d;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getBlikCode() {
        return this.f748c;
    }

    public String getStoredPaymentMethodId() {
        return this.f749d;
    }

    public void setBlikCode(String str) {
        this.f748c = str;
    }

    public void setStoredPaymentMethodId(String str) {
        this.f749d = str;
    }
}
