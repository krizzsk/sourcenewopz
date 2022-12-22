package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class ShopperName extends ModelObject {
    public static final ModelObject.Creator<ShopperName> CREATOR = new ModelObject.Creator<>(ShopperName.class);
    public static final ModelObject.Serializer<ShopperName> SERIALIZER = new ModelObject.Serializer<ShopperName>() {
        public JSONObject serialize(ShopperName shopperName) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(ShopperName.f801a, shopperName.getFirstName());
                jSONObject.putOpt(ShopperName.f802b, shopperName.getInfix());
                jSONObject.putOpt(ShopperName.f803c, shopperName.getLastName());
                jSONObject.putOpt(ShopperName.f804d, shopperName.getGender());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(ShopperName.class, e);
            }
        }

        public ShopperName deserialize(JSONObject jSONObject) {
            ShopperName shopperName = new ShopperName();
            shopperName.setFirstName(jSONObject.optString(ShopperName.f801a, (String) null));
            shopperName.setInfix(jSONObject.optString(ShopperName.f802b, (String) null));
            shopperName.setLastName(jSONObject.optString(ShopperName.f803c, (String) null));
            shopperName.setGender(jSONObject.optString(ShopperName.f804d, (String) null));
            return shopperName;
        }
    };

    /* renamed from: a */
    private static final String f801a = "firstName";

    /* renamed from: b */
    private static final String f802b = "infix";

    /* renamed from: c */
    private static final String f803c = "lastName";

    /* renamed from: d */
    private static final String f804d = "gender";

    /* renamed from: e */
    private String f805e;

    /* renamed from: f */
    private String f806f;

    /* renamed from: g */
    private String f807g;

    /* renamed from: h */
    private String f808h;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getFirstName() {
        return this.f805e;
    }

    public void setFirstName(String str) {
        this.f805e = str;
    }

    public String getInfix() {
        return this.f806f;
    }

    public void setInfix(String str) {
        this.f806f = str;
    }

    public String getLastName() {
        return this.f807g;
    }

    public void setLastName(String str) {
        this.f807g = str;
    }

    public String getGender() {
        return this.f808h;
    }

    public void setGender(String str) {
        this.f808h = str;
    }
}
