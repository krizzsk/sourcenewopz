package com.adyen.checkout.components;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionComponentData extends ModelObject {
    public static final ModelObject.Creator<ActionComponentData> CREATOR = new ModelObject.Creator<>(ActionComponentData.class);
    public static final ModelObject.Serializer<ActionComponentData> SERIALIZER = new ModelObject.Serializer<ActionComponentData>() {
        public JSONObject serialize(ActionComponentData actionComponentData) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("paymentData", actionComponentData.getPaymentData());
                jSONObject.putOpt("details", actionComponentData.getDetails());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(ActionComponentData.class, e);
            }
        }

        public ActionComponentData deserialize(JSONObject jSONObject) {
            ActionComponentData actionComponentData = new ActionComponentData();
            actionComponentData.setPaymentData(jSONObject.optString("paymentData"));
            actionComponentData.setDetails(jSONObject.optJSONObject("details"));
            return actionComponentData;
        }
    };

    /* renamed from: a */
    private static final String f585a = "paymentData";

    /* renamed from: b */
    private static final String f586b = "details";

    /* renamed from: c */
    private String f587c;

    /* renamed from: d */
    private JSONObject f588d;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getPaymentData() {
        return this.f587c;
    }

    public void setPaymentData(String str) {
        this.f587c = str;
    }

    public JSONObject getDetails() {
        return this.f588d;
    }

    public void setDetails(JSONObject jSONObject) {
        this.f588d = jSONObject;
    }
}
