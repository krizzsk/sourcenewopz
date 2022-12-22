package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoredPaymentMethod extends ModelObject {
    public static final ModelObject.Creator<StoredPaymentMethod> CREATOR = new ModelObject.Creator<>(StoredPaymentMethod.class);
    public static final ModelObject.Serializer<StoredPaymentMethod> SERIALIZER = new ModelObject.Serializer<StoredPaymentMethod>() {
        public JSONObject serialize(StoredPaymentMethod storedPaymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", storedPaymentMethod.getType());
                jSONObject.putOpt("name", storedPaymentMethod.getName());
                jSONObject.putOpt("brand", storedPaymentMethod.getBrand());
                jSONObject.putOpt(StoredPaymentMethod.f710d, storedPaymentMethod.getExpiryMonth());
                jSONObject.putOpt(StoredPaymentMethod.f711e, storedPaymentMethod.getExpiryYear());
                jSONObject.putOpt(StoredPaymentMethod.f712f, storedPaymentMethod.getHolderName());
                jSONObject.putOpt("id", storedPaymentMethod.getId());
                jSONObject.putOpt(StoredPaymentMethod.f714h, storedPaymentMethod.getLastFour());
                jSONObject.putOpt(StoredPaymentMethod.f715i, storedPaymentMethod.getShopperEmail());
                jSONObject.putOpt(StoredPaymentMethod.f716j, new JSONArray(storedPaymentMethod.getSupportedShopperInteractions()));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(StoredPaymentMethod.class, e);
            }
        }

        public StoredPaymentMethod deserialize(JSONObject jSONObject) {
            StoredPaymentMethod storedPaymentMethod = new StoredPaymentMethod();
            storedPaymentMethod.setType(jSONObject.optString("type"));
            storedPaymentMethod.setName(jSONObject.optString("name"));
            storedPaymentMethod.setBrand(jSONObject.optString("brand"));
            storedPaymentMethod.setExpiryMonth(jSONObject.optString(StoredPaymentMethod.f710d));
            storedPaymentMethod.setExpiryYear(jSONObject.optString(StoredPaymentMethod.f711e));
            storedPaymentMethod.setHolderName(jSONObject.optString(StoredPaymentMethod.f712f));
            storedPaymentMethod.setId(jSONObject.optString("id"));
            storedPaymentMethod.setLastFour(jSONObject.optString(StoredPaymentMethod.f714h));
            storedPaymentMethod.setShopperEmail(jSONObject.optString(StoredPaymentMethod.f715i));
            List<String> parseOptStringList = JsonUtils.parseOptStringList(jSONObject.optJSONArray(StoredPaymentMethod.f716j));
            if (parseOptStringList != null) {
                storedPaymentMethod.setSupportedShopperInteractions(parseOptStringList);
            }
            return storedPaymentMethod;
        }
    };

    /* renamed from: a */
    private static final String f707a = "type";

    /* renamed from: b */
    private static final String f708b = "name";

    /* renamed from: c */
    private static final String f709c = "brand";

    /* renamed from: d */
    private static final String f710d = "expiryMonth";

    /* renamed from: e */
    private static final String f711e = "expiryYear";

    /* renamed from: f */
    private static final String f712f = "holderName";

    /* renamed from: g */
    private static final String f713g = "id";

    /* renamed from: h */
    private static final String f714h = "lastFour";

    /* renamed from: i */
    private static final String f715i = "shopperEmail";

    /* renamed from: j */
    private static final String f716j = "supportedShopperInteractions";

    /* renamed from: k */
    private static final String f717k = "Ecommerce";

    /* renamed from: l */
    private String f718l;

    /* renamed from: m */
    private String f719m;

    /* renamed from: n */
    private String f720n;

    /* renamed from: o */
    private String f721o;

    /* renamed from: p */
    private String f722p;

    /* renamed from: q */
    private String f723q;

    /* renamed from: r */
    private String f724r;

    /* renamed from: s */
    private String f725s;

    /* renamed from: t */
    private String f726t;

    /* renamed from: u */
    private List<String> f727u = Collections.emptyList();

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getType() {
        return this.f718l;
    }

    public String getName() {
        return this.f719m;
    }

    public String getBrand() {
        return this.f720n;
    }

    public String getExpiryMonth() {
        return this.f721o;
    }

    public String getExpiryYear() {
        return this.f722p;
    }

    public String getHolderName() {
        return this.f723q;
    }

    public String getId() {
        return this.f724r;
    }

    public String getLastFour() {
        return this.f725s;
    }

    public String getShopperEmail() {
        return this.f726t;
    }

    public List<String> getSupportedShopperInteractions() {
        return this.f727u;
    }

    public void setType(String str) {
        this.f718l = str;
    }

    public void setName(String str) {
        this.f719m = str;
    }

    public void setBrand(String str) {
        this.f720n = str;
    }

    public void setExpiryMonth(String str) {
        this.f721o = str;
    }

    public void setExpiryYear(String str) {
        this.f722p = str;
    }

    public void setHolderName(String str) {
        this.f723q = str;
    }

    public void setId(String str) {
        this.f724r = str;
    }

    public void setLastFour(String str) {
        this.f725s = str;
    }

    public void setShopperEmail(String str) {
        this.f726t = str;
    }

    public void setSupportedShopperInteractions(List<String> list) {
        this.f727u = list;
    }

    public boolean isEcommerce() {
        return this.f727u.contains(f717k);
    }
}
