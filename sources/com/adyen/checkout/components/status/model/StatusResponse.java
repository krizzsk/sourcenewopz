package com.adyen.checkout.components.status.model;

import android.os.Parcel;
import com.adyen.checkout.components.model.payments.request.Address;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONException;
import org.json.JSONObject;

public class StatusResponse extends ModelObject {
    public static final ModelObject.Creator<StatusResponse> CREATOR = new ModelObject.Creator<>(StatusResponse.class);
    public static final String PAYLOAD = "payload";
    public static final String RESULT_CODE = "resultCode";
    public static final ModelObject.Serializer<StatusResponse> SERIALIZER = new ModelObject.Serializer<StatusResponse>() {
        public JSONObject serialize(StatusResponse statusResponse) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", statusResponse.getType());
                jSONObject.putOpt("payload", statusResponse.getPayload());
                jSONObject.putOpt(StatusResponse.RESULT_CODE, statusResponse.getResultCode());
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(Address.class, e);
            }
        }

        public StatusResponse deserialize(JSONObject jSONObject) {
            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setType(jSONObject.optString("type", (String) null));
            statusResponse.setPayload(jSONObject.optString("payload", (String) null));
            statusResponse.setResultCode(jSONObject.optString(StatusResponse.RESULT_CODE, (String) null));
            return statusResponse;
        }
    };
    public static final String TYPE = "type";

    /* renamed from: a */
    private String f891a;

    /* renamed from: b */
    private String f892b;

    /* renamed from: c */
    private String f893c;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getType() {
        return this.f891a;
    }

    public void setType(String str) {
        this.f891a = str;
    }

    public String getPayload() {
        return this.f892b;
    }

    public void setPayload(String str) {
        this.f892b = str;
    }

    public String getResultCode() {
        return this.f893c;
    }

    public void setResultCode(String str) {
        this.f893c = str;
    }
}
