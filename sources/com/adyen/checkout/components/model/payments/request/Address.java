package com.adyen.checkout.components.model.payments.request;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class Address extends ModelObject {
    public static final String ADDRESS_COUNTRY_NULL_PLACEHOLDER = "ZZ";
    public static final String ADDRESS_NULL_PLACEHOLDER = "null";
    public static final ModelObject.Creator<Address> CREATOR = new ModelObject.Creator<>(Address.class);
    public static final ModelObject.Serializer<Address> SERIALIZER = new ModelObject.Serializer<Address>() {
        public JSONObject serialize(Address address) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("city", address.getCity());
                jSONObject.putOpt("country", address.getCountry());
                jSONObject.putOpt(Address.f736c, address.getHouseNumberOrName());
                jSONObject.putOpt(Address.f737d, address.getPostalCode());
                jSONObject.putOpt(Address.f738e, address.getStateOrProvince());
                jSONObject.putOpt(Address.f739f, address.getStreet());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Address.class, e);
            }
        }

        public Address deserialize(JSONObject jSONObject) {
            Address address = new Address();
            address.setCity(jSONObject.optString("city", (String) null));
            address.setCountry(jSONObject.optString("country", (String) null));
            address.setHouseNumberOrName(jSONObject.optString(Address.f736c, (String) null));
            address.setPostalCode(jSONObject.optString(Address.f737d, (String) null));
            address.setStateOrProvince(jSONObject.optString(Address.f738e, (String) null));
            address.setStreet(jSONObject.optString(Address.f739f, (String) null));
            return address;
        }
    };

    /* renamed from: a */
    private static final String f734a = "city";

    /* renamed from: b */
    private static final String f735b = "country";

    /* renamed from: c */
    private static final String f736c = "houseNumberOrName";

    /* renamed from: d */
    private static final String f737d = "postalCode";

    /* renamed from: e */
    private static final String f738e = "stateOrProvince";

    /* renamed from: f */
    private static final String f739f = "street";

    /* renamed from: g */
    private String f740g;

    /* renamed from: h */
    private String f741h;

    /* renamed from: i */
    private String f742i;

    /* renamed from: j */
    private String f743j;

    /* renamed from: k */
    private String f744k;

    /* renamed from: l */
    private String f745l;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getCity() {
        return this.f740g;
    }

    public void setCity(String str) {
        this.f740g = str;
    }

    public String getCountry() {
        return this.f741h;
    }

    public void setCountry(String str) {
        this.f741h = str;
    }

    public String getHouseNumberOrName() {
        return this.f742i;
    }

    public void setHouseNumberOrName(String str) {
        this.f742i = str;
    }

    public String getPostalCode() {
        return this.f743j;
    }

    public void setPostalCode(String str) {
        this.f743j = str;
    }

    public String getStateOrProvince() {
        return this.f744k;
    }

    public void setStateOrProvince(String str) {
        this.f744k = str;
    }

    public String getStreet() {
        return this.f745l;
    }

    public void setStreet(String str) {
        this.f745l = str;
    }
}
