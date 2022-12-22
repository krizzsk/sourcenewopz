package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public final class Item extends ModelObject {
    public static final ModelObject.Creator<Item> CREATOR = new ModelObject.Creator<>(Item.class);
    public static final ModelObject.Serializer<Item> SERIALIZER = new ModelObject.Serializer<Item>() {
        public JSONObject serialize(Item item) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("id", item.getId());
                jSONObject.putOpt("name", item.getName());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Item.class, e);
            }
        }

        public Item deserialize(JSONObject jSONObject) {
            Item item = new Item();
            item.setId(jSONObject.optString("id", (String) null));
            item.setName(jSONObject.optString("name", (String) null));
            return item;
        }
    };

    /* renamed from: a */
    private static final String f687a = "id";

    /* renamed from: b */
    private static final String f688b = "name";

    /* renamed from: c */
    private String f689c;

    /* renamed from: d */
    private String f690d;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getId() {
        return this.f689c;
    }

    public String getName() {
        return this.f690d;
    }

    public void setId(String str) {
        this.f689c = str;
    }

    public void setName(String str) {
        this.f690d = str;
    }
}
