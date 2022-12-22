package com.adyen.checkout.components.model.payments;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class Amount extends ModelObject {
    public static final ModelObject.Creator<Amount> CREATOR = new ModelObject.Creator<>(Amount.class);
    public static final Amount EMPTY;
    public static final ModelObject.Serializer<Amount> SERIALIZER = new ModelObject.Serializer<Amount>() {
        public JSONObject serialize(Amount amount) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("currency", amount.getCurrency());
                jSONObject.putOpt("value", Integer.valueOf(amount.getValue()));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Amount.class, e);
            }
        }

        public Amount deserialize(JSONObject jSONObject) {
            Amount amount = new Amount();
            amount.setCurrency(jSONObject.optString("currency", (String) null));
            amount.setValue(jSONObject.optInt("value", -1));
            return amount;
        }
    };

    /* renamed from: a */
    private static final String f728a = "NONE";

    /* renamed from: b */
    private static final int f729b = -1;

    /* renamed from: c */
    private static final String f730c = "currency";

    /* renamed from: d */
    private static final String f731d = "value";

    /* renamed from: e */
    private String f732e;

    /* renamed from: f */
    private int f733f;

    static {
        Amount amount = new Amount();
        EMPTY = amount;
        amount.setCurrency("NONE");
        EMPTY.setValue(-1);
    }

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getCurrency() {
        return this.f732e;
    }

    public void setCurrency(String str) {
        this.f732e = str;
    }

    public int getValue() {
        return this.f733f;
    }

    public void setValue(int i) {
        this.f733f = i;
    }

    public boolean isEmpty() {
        return "NONE".equals(this.f732e) || this.f733f == -1;
    }
}
