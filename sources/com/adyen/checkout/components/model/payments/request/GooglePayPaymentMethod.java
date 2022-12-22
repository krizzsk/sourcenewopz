package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class GooglePayPaymentMethod extends PaymentMethodDetails {
    public static final ModelObject.Creator<GooglePayPaymentMethod> CREATOR = new ModelObject.Creator<>(GooglePayPaymentMethod.class);
    public static final ModelObject.Serializer<GooglePayPaymentMethod> SERIALIZER = new ModelObject.Serializer<GooglePayPaymentMethod>() {
        public JSONObject serialize(GooglePayPaymentMethod googlePayPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", googlePayPaymentMethod.getType());
                jSONObject.putOpt(GooglePayPaymentMethod.f766a, googlePayPaymentMethod.getGooglePayToken());
                jSONObject.putOpt(GooglePayPaymentMethod.f767b, googlePayPaymentMethod.getGooglePayCardNetwork());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(GooglePayPaymentMethod.class, e);
            }
        }

        public GooglePayPaymentMethod deserialize(JSONObject jSONObject) {
            GooglePayPaymentMethod googlePayPaymentMethod = new GooglePayPaymentMethod();
            googlePayPaymentMethod.setType(jSONObject.optString("type", (String) null));
            googlePayPaymentMethod.setGooglePayToken(jSONObject.optString(GooglePayPaymentMethod.f766a, (String) null));
            googlePayPaymentMethod.setGooglePayCardNetwork(jSONObject.optString(GooglePayPaymentMethod.f767b, (String) null));
            return googlePayPaymentMethod;
        }
    };

    /* renamed from: a */
    private static final String f766a = "googlePayToken";

    /* renamed from: b */
    private static final String f767b = "googlePayCardNetwork";

    /* renamed from: c */
    private String f768c;

    /* renamed from: d */
    private String f769d;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getGooglePayToken() {
        return this.f768c;
    }

    public void setGooglePayToken(String str) {
        this.f768c = str;
    }

    public String getGooglePayCardNetwork() {
        return this.f769d;
    }

    public void setGooglePayCardNetwork(String str) {
        this.f769d = str;
    }
}
