package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentComponentData<PaymentMethodDetailsT extends PaymentMethodDetails> extends ModelObject {
    public static final ModelObject.Creator<PaymentComponentData> CREATOR = new ModelObject.Creator<>(PaymentComponentData.class);
    public static final ModelObject.Serializer<PaymentComponentData> SERIALIZER = new ModelObject.Serializer<PaymentComponentData>() {
        public JSONObject serialize(PaymentComponentData paymentComponentData) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(PaymentComponentData.f774a, ModelUtils.serializeOpt(paymentComponentData.getPaymentMethod(), PaymentMethodDetails.SERIALIZER));
                jSONObject.putOpt(PaymentComponentData.f775b, Boolean.valueOf(paymentComponentData.isStorePaymentMethodEnable()));
                jSONObject.putOpt(PaymentComponentData.f776c, paymentComponentData.getShopperReference());
                jSONObject.putOpt("amount", ModelUtils.serializeOpt(paymentComponentData.getAmount(), Amount.SERIALIZER));
                jSONObject.putOpt(PaymentComponentData.f778e, ModelUtils.serializeOpt(paymentComponentData.getBillingAddress(), Address.SERIALIZER));
                jSONObject.putOpt(PaymentComponentData.f779f, ModelUtils.serializeOpt(paymentComponentData.getDeliveryAddress(), Address.SERIALIZER));
                jSONObject.putOpt(PaymentComponentData.f780g, ModelUtils.serializeOpt(paymentComponentData.getShopperName(), ShopperName.SERIALIZER));
                jSONObject.putOpt(PaymentComponentData.f781h, paymentComponentData.getTelephoneNumber());
                jSONObject.putOpt(PaymentComponentData.f782i, paymentComponentData.getShopperEmail());
                jSONObject.putOpt(PaymentComponentData.f783j, paymentComponentData.getDateOfBirth());
                jSONObject.putOpt(PaymentComponentData.f784k, paymentComponentData.getSocialSecurityNumber());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(PaymentComponentData.class, e);
            }
        }

        public PaymentComponentData deserialize(JSONObject jSONObject) {
            PaymentComponentData paymentComponentData = new PaymentComponentData();
            paymentComponentData.setPaymentMethod((PaymentMethodDetails) ModelUtils.deserializeOpt(jSONObject.optJSONObject(PaymentComponentData.f774a), PaymentMethodDetails.SERIALIZER));
            paymentComponentData.setStorePaymentMethod(jSONObject.optBoolean(PaymentComponentData.f775b));
            paymentComponentData.setShopperReference(jSONObject.optString(PaymentComponentData.f776c));
            paymentComponentData.setAmount((Amount) ModelUtils.deserializeOpt(jSONObject.optJSONObject("amount"), Amount.SERIALIZER));
            paymentComponentData.setBillingAddress((Address) ModelUtils.deserializeOpt(jSONObject.optJSONObject(PaymentComponentData.f778e), Address.SERIALIZER));
            paymentComponentData.setDeliveryAddress((Address) ModelUtils.deserializeOpt(jSONObject.optJSONObject(PaymentComponentData.f779f), Address.SERIALIZER));
            paymentComponentData.setShopperName((ShopperName) ModelUtils.deserializeOpt(jSONObject.optJSONObject(PaymentComponentData.f780g), ShopperName.SERIALIZER));
            paymentComponentData.setTelephoneNumber(jSONObject.optString(PaymentComponentData.f781h));
            paymentComponentData.setShopperEmail(jSONObject.optString(PaymentComponentData.f782i));
            paymentComponentData.setDateOfBirth(jSONObject.optString(PaymentComponentData.f783j));
            paymentComponentData.setSocialSecurityNumber(jSONObject.optString(PaymentComponentData.f784k));
            return paymentComponentData;
        }
    };

    /* renamed from: a */
    private static final String f774a = "paymentMethod";

    /* renamed from: b */
    private static final String f775b = "storePaymentMethod";

    /* renamed from: c */
    private static final String f776c = "shopperReference";

    /* renamed from: d */
    private static final String f777d = "amount";

    /* renamed from: e */
    private static final String f778e = "billingAddress";

    /* renamed from: f */
    private static final String f779f = "deliveryAddress";

    /* renamed from: g */
    private static final String f780g = "shopperName";

    /* renamed from: h */
    private static final String f781h = "telephoneNumber";

    /* renamed from: i */
    private static final String f782i = "shopperEmail";

    /* renamed from: j */
    private static final String f783j = "dateOfBirth";

    /* renamed from: k */
    private static final String f784k = "socialSecurityNumber";

    /* renamed from: l */
    private PaymentMethodDetailsT f785l;

    /* renamed from: m */
    private boolean f786m;

    /* renamed from: n */
    private String f787n;

    /* renamed from: o */
    private Amount f788o;

    /* renamed from: p */
    private Address f789p;

    /* renamed from: q */
    private Address f790q;

    /* renamed from: r */
    private ShopperName f791r;

    /* renamed from: s */
    private String f792s;

    /* renamed from: t */
    private String f793t;

    /* renamed from: u */
    private String f794u;

    /* renamed from: v */
    private String f795v;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public PaymentMethodDetailsT getPaymentMethod() {
        return this.f785l;
    }

    public void setPaymentMethod(PaymentMethodDetailsT paymentmethoddetailst) {
        this.f785l = paymentmethoddetailst;
    }

    public void setStorePaymentMethod(boolean z) {
        this.f786m = z;
    }

    public boolean isStorePaymentMethodEnable() {
        return this.f786m;
    }

    public void setShopperReference(String str) {
        this.f787n = str;
    }

    public String getShopperReference() {
        return this.f787n;
    }

    public Amount getAmount() {
        return this.f788o;
    }

    public void setAmount(Amount amount) {
        this.f788o = amount;
    }

    public Address getBillingAddress() {
        return this.f789p;
    }

    public void setBillingAddress(Address address) {
        this.f789p = address;
    }

    public Address getDeliveryAddress() {
        return this.f790q;
    }

    public void setDeliveryAddress(Address address) {
        this.f790q = address;
    }

    public ShopperName getShopperName() {
        return this.f791r;
    }

    public void setShopperName(ShopperName shopperName) {
        this.f791r = shopperName;
    }

    public String getTelephoneNumber() {
        return this.f792s;
    }

    public void setTelephoneNumber(String str) {
        this.f792s = str;
    }

    public String getShopperEmail() {
        return this.f793t;
    }

    public void setShopperEmail(String str) {
        this.f793t = str;
    }

    public String getDateOfBirth() {
        return this.f794u;
    }

    public void setDateOfBirth(String str) {
        this.f794u = str;
    }

    public String getSocialSecurityNumber() {
        return this.f795v;
    }

    public void setSocialSecurityNumber(String str) {
        this.f795v = str;
    }
}
