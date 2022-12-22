package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class SepaPaymentMethod extends PaymentMethodDetails {
    public static final ModelObject.Creator<SepaPaymentMethod> CREATOR = new ModelObject.Creator<>(SepaPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "sepadirectdebit";
    public static final ModelObject.Serializer<SepaPaymentMethod> SERIALIZER = new ModelObject.Serializer<SepaPaymentMethod>() {
        public JSONObject serialize(SepaPaymentMethod sepaPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", sepaPaymentMethod.getType());
                jSONObject.putOpt(SepaPaymentMethod.f797a, sepaPaymentMethod.getOwnerName());
                jSONObject.putOpt(SepaPaymentMethod.f798b, sepaPaymentMethod.getIban());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(SepaPaymentMethod.class, e);
            }
        }

        public SepaPaymentMethod deserialize(JSONObject jSONObject) {
            SepaPaymentMethod sepaPaymentMethod = new SepaPaymentMethod();
            sepaPaymentMethod.setType(jSONObject.optString("type", (String) null));
            sepaPaymentMethod.setOwnerName(jSONObject.optString(SepaPaymentMethod.f797a, (String) null));
            sepaPaymentMethod.setIban(jSONObject.optString(SepaPaymentMethod.f798b, (String) null));
            return sepaPaymentMethod;
        }
    };

    /* renamed from: a */
    private static final String f797a = "ownerName";

    /* renamed from: b */
    private static final String f798b = "iban";

    /* renamed from: c */
    private String f799c;

    /* renamed from: d */
    private String f800d;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getOwnerName() {
        return this.f799c;
    }

    public void setOwnerName(String str) {
        this.f799c = str;
    }

    public String getIban() {
        return this.f800d;
    }

    public void setIban(String str) {
        this.f800d = str;
    }
}
