package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.response.SdkData;
import com.adyen.checkout.components.util.PaymentMethodTypes;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class SdkAction<SdkDataT extends SdkData> extends Action {
    public static final String ACTION_TYPE = "sdk";
    public static final ModelObject.Creator<SdkAction> CREATOR = new ModelObject.Creator<>(SdkAction.class);
    public static final ModelObject.Serializer<SdkAction> SERIALIZER = new ModelObject.Serializer<SdkAction>() {
        public JSONObject serialize(SdkAction sdkAction) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", sdkAction.getType());
                jSONObject.putOpt("paymentData", sdkAction.getPaymentData());
                jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, sdkAction.getPaymentMethodType());
                ModelObject.Serializer<? extends SdkData> sdkDataSerializer = getSdkDataSerializer(sdkAction.getPaymentMethodType());
                if (sdkAction.getSdkData() != null) {
                    jSONObject.putOpt(SdkAction.f820a, ModelUtils.serializeOpt(sdkAction.getSdkData(), sdkDataSerializer));
                }
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(SdkAction.class, e);
            }
        }

        public SdkAction deserialize(JSONObject jSONObject) {
            SdkAction sdkAction = new SdkAction();
            sdkAction.setType(jSONObject.optString("type", (String) null));
            sdkAction.setPaymentData(jSONObject.optString("paymentData", (String) null));
            sdkAction.setPaymentMethodType(jSONObject.optString(Action.PAYMENT_METHOD_TYPE, (String) null));
            sdkAction.setSdkData((SdkData) ModelUtils.deserializeOpt(jSONObject.optJSONObject(SdkAction.f820a), getSdkDataSerializer(sdkAction.getPaymentMethodType())));
            return sdkAction;
        }

        private ModelObject.Serializer<? extends SdkData> getSdkDataSerializer(String str) {
            if (str != null) {
                char c = 65535;
                if (str.hashCode() == 525665560 && str.equals(PaymentMethodTypes.WECHAT_PAY_SDK)) {
                    c = 0;
                }
                if (c == 0) {
                    return WeChatPaySdkData.SERIALIZER;
                }
                throw new CheckoutException("sdkData not found for type paymentMethodType - " + str);
            }
            throw new CheckoutException("SdkAction cannot be parsed with null paymentMethodType.");
        }
    };

    /* renamed from: a */
    private static final String f820a = "sdkData";

    /* renamed from: b */
    private SdkDataT f821b;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public SdkDataT getSdkData() {
        return this.f821b;
    }

    public void setSdkData(SdkDataT sdkdatat) {
        this.f821b = sdkdatat;
    }
}
