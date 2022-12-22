package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class CardPaymentMethod extends PaymentMethodDetails {
    public static final ModelObject.Creator<CardPaymentMethod> CREATOR = new ModelObject.Creator<>(CardPaymentMethod.class);
    public static final String PAYMENT_METHOD_TYPE = "scheme";
    public static final ModelObject.Serializer<CardPaymentMethod> SERIALIZER = new ModelObject.Serializer<CardPaymentMethod>() {
        public JSONObject serialize(CardPaymentMethod cardPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", cardPaymentMethod.getType());
                jSONObject.putOpt(CardPaymentMethod.f750a, cardPaymentMethod.getEncryptedCardNumber());
                jSONObject.putOpt(CardPaymentMethod.f751b, cardPaymentMethod.getEncryptedExpiryMonth());
                jSONObject.putOpt(CardPaymentMethod.f752c, cardPaymentMethod.getEncryptedExpiryYear());
                jSONObject.putOpt(CardPaymentMethod.f753d, cardPaymentMethod.getEncryptedSecurityCode());
                jSONObject.putOpt(CardPaymentMethod.f755f, cardPaymentMethod.getStoredPaymentMethodId());
                jSONObject.putOpt(CardPaymentMethod.f754e, cardPaymentMethod.getHolderName());
                jSONObject.putOpt(CardPaymentMethod.f756g, cardPaymentMethod.getEncryptedPassword());
                jSONObject.putOpt(CardPaymentMethod.f757h, cardPaymentMethod.getTaxNumber());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(IdealPaymentMethod.class, e);
            }
        }

        public CardPaymentMethod deserialize(JSONObject jSONObject) {
            CardPaymentMethod cardPaymentMethod = new CardPaymentMethod();
            cardPaymentMethod.setType(jSONObject.optString("type", (String) null));
            cardPaymentMethod.setEncryptedCardNumber(jSONObject.optString(CardPaymentMethod.f750a, (String) null));
            cardPaymentMethod.setEncryptedExpiryMonth(jSONObject.optString(CardPaymentMethod.f751b, (String) null));
            cardPaymentMethod.setEncryptedExpiryYear(jSONObject.optString(CardPaymentMethod.f752c, (String) null));
            cardPaymentMethod.setStoredPaymentMethodId(jSONObject.optString(CardPaymentMethod.f755f));
            cardPaymentMethod.setEncryptedSecurityCode(jSONObject.optString(CardPaymentMethod.f753d, (String) null));
            cardPaymentMethod.setHolderName(jSONObject.optString(CardPaymentMethod.f754e, (String) null));
            cardPaymentMethod.setEncryptedPassword(jSONObject.optString(CardPaymentMethod.f756g, (String) null));
            cardPaymentMethod.setTaxNumber(jSONObject.optString(CardPaymentMethod.f757h));
            return cardPaymentMethod;
        }
    };

    /* renamed from: a */
    private static final String f750a = "encryptedCardNumber";

    /* renamed from: b */
    private static final String f751b = "encryptedExpiryMonth";

    /* renamed from: c */
    private static final String f752c = "encryptedExpiryYear";

    /* renamed from: d */
    private static final String f753d = "encryptedSecurityCode";

    /* renamed from: e */
    private static final String f754e = "holderName";

    /* renamed from: f */
    private static final String f755f = "storedPaymentMethodId";

    /* renamed from: g */
    private static final String f756g = "encryptedPassword";

    /* renamed from: h */
    private static final String f757h = "taxNumber";

    /* renamed from: i */
    private String f758i;

    /* renamed from: j */
    private String f759j;

    /* renamed from: k */
    private String f760k;

    /* renamed from: l */
    private String f761l;

    /* renamed from: m */
    private String f762m;

    /* renamed from: n */
    private String f763n;

    /* renamed from: o */
    private String f764o;

    /* renamed from: p */
    private String f765p;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getEncryptedCardNumber() {
        return this.f758i;
    }

    public void setEncryptedCardNumber(String str) {
        this.f758i = str;
    }

    public String getEncryptedExpiryMonth() {
        return this.f759j;
    }

    public void setEncryptedExpiryMonth(String str) {
        this.f759j = str;
    }

    public String getEncryptedExpiryYear() {
        return this.f760k;
    }

    public void setEncryptedExpiryYear(String str) {
        this.f760k = str;
    }

    public String getEncryptedSecurityCode() {
        return this.f761l;
    }

    public void setEncryptedSecurityCode(String str) {
        this.f761l = str;
    }

    public String getEncryptedPassword() {
        return this.f762m;
    }

    public void setEncryptedPassword(String str) {
        this.f762m = str;
    }

    public String getTaxNumber() {
        return this.f765p;
    }

    public void setTaxNumber(String str) {
        this.f765p = str;
    }

    public String getHolderName() {
        return this.f763n;
    }

    public void setHolderName(String str) {
        this.f763n = str;
    }

    public void setStoredPaymentMethodId(String str) {
        this.f764o = str;
    }

    public String getStoredPaymentMethodId() {
        return this.f764o;
    }
}
