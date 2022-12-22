package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class InputDetail extends ModelObject {
    public static final ModelObject.Creator<InputDetail> CREATOR = new ModelObject.Creator<>(InputDetail.class);
    public static final ModelObject.Serializer<InputDetail> SERIALIZER = new ModelObject.Serializer<InputDetail>() {
        public JSONObject serialize(InputDetail inputDetail) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("items", ModelUtils.serializeOptList(inputDetail.getItems(), Item.SERIALIZER));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(InputDetail.class, e);
            }
        }

        public InputDetail deserialize(JSONObject jSONObject) {
            InputDetail inputDetail = new InputDetail();
            inputDetail.setItems(ModelUtils.deserializeOptList(jSONObject.optJSONArray("items"), Item.SERIALIZER));
            return inputDetail;
        }
    };

    /* renamed from: a */
    private static final String f679a = "items";

    /* renamed from: b */
    private List<Item> f680b;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public List<Item> getItems() {
        return this.f680b;
    }

    public void setItems(List<Item> list) {
        this.f680b = list;
    }
}
