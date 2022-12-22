package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class Issuer extends ModelObject {
    public static final ModelObject.Creator<Issuer> CREATOR = new ModelObject.Creator<>(Issuer.class);
    public static final ModelObject.Serializer<Issuer> SERIALIZER = new ModelObject.Serializer<Issuer>() {
        public JSONObject serialize(Issuer issuer) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("id", issuer.getId());
                jSONObject.putOpt("name", issuer.getName());
                jSONObject.putOpt(Issuer.f683c, Boolean.valueOf(issuer.isDisabled()));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(PaymentMethod.class, e);
            }
        }

        public Issuer deserialize(JSONObject jSONObject) {
            Issuer issuer = new Issuer();
            issuer.setId(jSONObject.optString("id", (String) null));
            issuer.setName(jSONObject.optString("name", (String) null));
            issuer.setDisabled(jSONObject.optBoolean(Issuer.f683c, false));
            return issuer;
        }
    };

    /* renamed from: a */
    private static final String f681a = "id";

    /* renamed from: b */
    private static final String f682b = "name";

    /* renamed from: c */
    private static final String f683c = "disabled";

    /* renamed from: d */
    private String f684d;

    /* renamed from: e */
    private String f685e;

    /* renamed from: f */
    private boolean f686f;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getId() {
        return this.f684d;
    }

    public String getName() {
        return this.f685e;
    }

    public boolean isDisabled() {
        return this.f686f;
    }

    public void setId(String str) {
        this.f684d = str;
    }

    public void setName(String str) {
        this.f685e = str;
    }

    public void setDisabled(boolean z) {
        this.f686f = z;
    }
}
