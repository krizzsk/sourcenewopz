package com.adyen.checkout.components.model.payments.response;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VoucherAction extends Action {
    public static final String ACTION_TYPE = "voucher";
    public static final ModelObject.Creator<VoucherAction> CREATOR = new ModelObject.Creator<>(VoucherAction.class);
    public static final ModelObject.Serializer<VoucherAction> SERIALIZER = new ModelObject.Serializer<VoucherAction>() {
        public JSONObject serialize(VoucherAction voucherAction) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", voucherAction.getType());
                jSONObject.putOpt("paymentData", voucherAction.getPaymentData());
                jSONObject.putOpt(Action.PAYMENT_METHOD_TYPE, voucherAction.getPaymentMethodType());
                jSONObject.putOpt(VoucherAction.f832a, ModelUtils.serializeOpt(voucherAction.getSurcharge(), Amount.SERIALIZER));
                jSONObject.putOpt(VoucherAction.f833b, ModelUtils.serializeOpt(voucherAction.getInitialAmount(), Amount.SERIALIZER));
                jSONObject.putOpt(VoucherAction.f834c, ModelUtils.serializeOpt(voucherAction.getTotalAmount(), Amount.SERIALIZER));
                jSONObject.putOpt(VoucherAction.f835d, voucherAction.getIssuer());
                jSONObject.putOpt(VoucherAction.f836e, voucherAction.getExpiresAt());
                jSONObject.putOpt(VoucherAction.f837f, voucherAction.getReference());
                jSONObject.putOpt(VoucherAction.f838g, voucherAction.getAlternativeReference());
                jSONObject.putOpt(VoucherAction.f839h, voucherAction.getMerchantName());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(VoucherAction.class, e);
            }
        }

        public VoucherAction deserialize(JSONObject jSONObject) {
            VoucherAction voucherAction = new VoucherAction();
            voucherAction.setType(jSONObject.optString("type", (String) null));
            voucherAction.setPaymentData(jSONObject.optString("paymentData", (String) null));
            voucherAction.setPaymentMethodType(jSONObject.optString(Action.PAYMENT_METHOD_TYPE, (String) null));
            voucherAction.setSurcharge((Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject(VoucherAction.f832a), Amount.SERIALIZER));
            voucherAction.setInitialAmount((Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject(VoucherAction.f833b), Amount.SERIALIZER));
            voucherAction.setTotalAmount((Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject(VoucherAction.f834c), Amount.SERIALIZER));
            voucherAction.setIssuer(jSONObject.optString(VoucherAction.f835d));
            voucherAction.setExpiresAt(jSONObject.optString(VoucherAction.f836e));
            voucherAction.setReference(jSONObject.optString(VoucherAction.f837f));
            voucherAction.setAlternativeReference(jSONObject.optString(VoucherAction.f838g));
            voucherAction.setMerchantName(jSONObject.optString(VoucherAction.f839h));
            return voucherAction;
        }
    };

    /* renamed from: a */
    private static final String f832a = "surcharge";

    /* renamed from: b */
    private static final String f833b = "initialAmount";

    /* renamed from: c */
    private static final String f834c = "totalAmount";

    /* renamed from: d */
    private static final String f835d = "issuer";

    /* renamed from: e */
    private static final String f836e = "expiresAt";

    /* renamed from: f */
    private static final String f837f = "reference";

    /* renamed from: g */
    private static final String f838g = "alternativeReference";

    /* renamed from: h */
    private static final String f839h = "merchantName";

    /* renamed from: i */
    private Amount f840i;

    /* renamed from: j */
    private Amount f841j;

    /* renamed from: k */
    private Amount f842k;

    /* renamed from: l */
    private String f843l;

    /* renamed from: m */
    private String f844m;

    /* renamed from: n */
    private String f845n;

    /* renamed from: o */
    private String f846o;

    /* renamed from: p */
    private String f847p;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public Amount getSurcharge() {
        return this.f840i;
    }

    public void setSurcharge(Amount amount) {
        this.f840i = amount;
    }

    public Amount getInitialAmount() {
        return this.f841j;
    }

    public void setInitialAmount(Amount amount) {
        this.f841j = amount;
    }

    public Amount getTotalAmount() {
        return this.f842k;
    }

    public void setTotalAmount(Amount amount) {
        this.f842k = amount;
    }

    public String getIssuer() {
        return this.f843l;
    }

    public void setIssuer(String str) {
        this.f843l = str;
    }

    public String getExpiresAt() {
        return this.f844m;
    }

    public void setExpiresAt(String str) {
        this.f844m = str;
    }

    public String getReference() {
        return this.f845n;
    }

    public void setReference(String str) {
        this.f845n = str;
    }

    public String getAlternativeReference() {
        return this.f846o;
    }

    public void setAlternativeReference(String str) {
        this.f846o = str;
    }

    public String getMerchantName() {
        return this.f847p;
    }

    public void setMerchantName(String str) {
        this.f847p = str;
    }
}
