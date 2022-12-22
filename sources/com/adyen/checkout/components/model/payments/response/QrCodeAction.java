package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class QrCodeAction extends Action {
    public static final String ACTION_TYPE = "qrCode";
    public static final ModelObject.Creator<QrCodeAction> CREATOR = new ModelObject.Creator<>(QrCodeAction.class);
    public static final ModelObject.Serializer<QrCodeAction> SERIALIZER = new ModelObject.Serializer<QrCodeAction>() {
        public JSONObject serialize(QrCodeAction qrCodeAction) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", qrCodeAction.getType());
                jSONObject.putOpt("paymentData", qrCodeAction.getPaymentData());
                jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, qrCodeAction.getPaymentMethodType());
                jSONObject.putOpt(QrCodeAction.f812a, qrCodeAction.getQrCodeData());
                jSONObject.putOpt("url", qrCodeAction.getUrl());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(QrCodeAction.class, e);
            }
        }

        public QrCodeAction deserialize(JSONObject jSONObject) {
            QrCodeAction qrCodeAction = new QrCodeAction();
            qrCodeAction.setType(jSONObject.optString("type", (String) null));
            qrCodeAction.setPaymentData(jSONObject.optString("paymentData", (String) null));
            qrCodeAction.setPaymentMethodType(jSONObject.optString(Action.PAYMENT_METHOD_TYPE, (String) null));
            qrCodeAction.setQrCodeData(jSONObject.optString(QrCodeAction.f812a));
            qrCodeAction.setUrl(jSONObject.optString("url"));
            return qrCodeAction;
        }
    };

    /* renamed from: a */
    private static final String f812a = "qrCodeData";

    /* renamed from: b */
    private static final String f813b = "url";

    /* renamed from: c */
    private String f814c;

    /* renamed from: d */
    private String f815d;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getQrCodeData() {
        return this.f814c;
    }

    public void setQrCodeData(String str) {
        this.f814c = str;
    }

    public String getUrl() {
        return this.f815d;
    }

    public void setUrl(String str) {
        this.f815d = str;
    }
}
