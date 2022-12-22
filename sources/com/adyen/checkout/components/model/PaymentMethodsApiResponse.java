package com.adyen.checkout.components.model;

import android.os.Parcel;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentMethodsApiResponse extends ModelObject {
    public static final ModelObject.Creator<PaymentMethodsApiResponse> CREATOR = new ModelObject.Creator<>(PaymentMethodsApiResponse.class);
    public static final ModelObject.Serializer<PaymentMethodsApiResponse> SERIALIZER = new ModelObject.Serializer<PaymentMethodsApiResponse>() {
        public JSONObject serialize(PaymentMethodsApiResponse paymentMethodsApiResponse) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(PaymentMethodsApiResponse.f667a, ModelUtils.serializeOptList(paymentMethodsApiResponse.getStoredPaymentMethods(), StoredPaymentMethod.SERIALIZER));
                jSONObject.putOpt(PaymentMethodsApiResponse.f668b, ModelUtils.serializeOptList(paymentMethodsApiResponse.getPaymentMethods(), PaymentMethod.SERIALIZER));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(PaymentMethodsApiResponse.class, e);
            }
        }

        public PaymentMethodsApiResponse deserialize(JSONObject jSONObject) {
            PaymentMethodsApiResponse paymentMethodsApiResponse = new PaymentMethodsApiResponse();
            paymentMethodsApiResponse.setStoredPaymentMethods(ModelUtils.deserializeOptList(jSONObject.optJSONArray(PaymentMethodsApiResponse.f667a), StoredPaymentMethod.SERIALIZER));
            paymentMethodsApiResponse.setPaymentMethods(ModelUtils.deserializeOptList(jSONObject.optJSONArray(PaymentMethodsApiResponse.f668b), PaymentMethod.SERIALIZER));
            return paymentMethodsApiResponse;
        }
    };

    /* renamed from: a */
    private static final String f667a = "storedPaymentMethods";

    /* renamed from: b */
    private static final String f668b = "paymentMethods";

    /* renamed from: c */
    private List<StoredPaymentMethod> f669c;

    /* renamed from: d */
    private List<PaymentMethod> f670d;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public List<StoredPaymentMethod> getStoredPaymentMethods() {
        return this.f669c;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return this.f670d;
    }

    public void setStoredPaymentMethods(List<StoredPaymentMethod> list) {
        this.f669c = list;
    }

    public void setPaymentMethods(List<PaymentMethod> list) {
        this.f670d = list;
    }
}
