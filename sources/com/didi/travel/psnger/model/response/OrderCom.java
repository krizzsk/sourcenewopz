package com.didi.travel.psnger.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderCom extends BaseObject {
    private int anyCarPreferencePriority;
    private List<AnyCarRequestingInfo> anyCarRequestingList = new ArrayList();
    private int businessId;
    private String oid = "";

    public String getOid() {
        return this.oid;
    }

    public int getBusinessId() {
        return this.businessId;
    }

    public int getAnyCarPreferencePriority() {
        return this.anyCarPreferencePriority;
    }

    public List<AnyCarRequestingInfo> getAnyCarRequestingList() {
        return this.anyCarRequestingList;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject != null && jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oid = optJSONObject.optString("order_id");
            this.businessId = optJSONObject.optInt("business_id");
            this.anyCarPreferencePriority = optJSONObject.optInt("anycar_preference_priority");
            JSONArray optJSONArray = optJSONObject.optJSONArray("anycar_requesting_info_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONObject2 != null) {
                        AnyCarRequestingInfo anyCarRequestingInfo = new AnyCarRequestingInfo();
                        anyCarRequestingInfo.parse(jSONObject2);
                        this.anyCarRequestingList.add(anyCarRequestingInfo);
                    }
                }
            }
        }
    }

    public static class AnyCarRequestingInfo implements Parcelable {
        public static final Parcelable.Creator<AnyCarRequestingInfo> CREATOR = new Parcelable.Creator<AnyCarRequestingInfo>() {
            public AnyCarRequestingInfo createFromParcel(Parcel parcel) {
                return new AnyCarRequestingInfo(parcel);
            }

            public AnyCarRequestingInfo[] newArray(int i) {
                return new AnyCarRequestingInfo[i];
            }
        };
        public String car_level;
        public String product_id;
        public String require_level;

        public int describeContents() {
            return 0;
        }

        protected AnyCarRequestingInfo(Parcel parcel) {
            this.product_id = parcel.readString();
            this.require_level = parcel.readString();
            this.car_level = parcel.readString();
        }

        public AnyCarRequestingInfo() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.product_id);
            parcel.writeString(this.require_level);
            parcel.writeString(this.car_level);
        }

        public void parse(JSONObject jSONObject) {
            this.product_id = jSONObject.optString("product_id");
            this.require_level = jSONObject.optString("require_level");
            this.car_level = jSONObject.optString("car_level");
        }
    }
}
