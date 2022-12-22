package com.didi.component.splitfare.model;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateSplitFarePartner extends BaseObject {
    public SplitFareResult data;

    public static class SplitFareResult extends BaseObject {
        public List<SplitFareFailGroup> data;
        public DTSDKOrderDetail orderDetail;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.orderDetail = new DTSDKOrderDetail();
                if (jSONObject.optJSONObject("order_detail") != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.putOpt("data", jSONObject.optJSONObject("order_detail"));
                        this.orderDetail.parse(jSONObject2);
                        this.orderDetail.errno = 0;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.data = new JsonUtil().parseJSONArray(optJSONArray, new SplitFareFailGroup());
                }
            }
        }
    }

    public static class AreaCodeUserInfo extends BaseObject {
        public String countryCode;
        public String name;
        public String originPhone;
        public String phone;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            this.phone = jSONObject.optString("phone");
            this.name = jSONObject.optString("name");
            this.countryCode = jSONObject.optString("country_calling_code");
            this.originPhone = jSONObject.optString("origin_phone");
        }
    }

    public static class SplitFareFailGroup extends BaseObject {
        public String areaCode;
        public int areaNum;
        public List<AreaCodeUserInfo> contactList;
        public List<SplitFareFailUser> failUsers;
        public String subTitle;
        public String title;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.areaNum = jSONObject.optInt("area_num");
                JSONArray optJSONArray = jSONObject.optJSONArray("contact_list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.contactList = new JsonUtil().parseJSONArray(optJSONArray, new AreaCodeUserInfo());
                }
                this.areaCode = jSONObject.optString("areacode");
                this.title = jSONObject.optString("title");
                this.subTitle = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("fail_users");
                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                    this.failUsers = new JsonUtil().parseJSONArray(optJSONArray2, new SplitFareFailUser());
                }
            }
        }
    }

    public static class SplitFareFailUser extends BaseObject {
        public String countryCallingCode;
        public String name;
        public String originPhone;
        public String phone;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.originPhone = jSONObject.optString("origin_phone");
            this.name = jSONObject.optString("name");
            this.countryCallingCode = jSONObject.optString("country_calling_code");
            this.phone = jSONObject.optString("phone");
        }
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            SplitFareResult splitFareResult = new SplitFareResult();
            this.data = splitFareResult;
            splitFareResult.parse(jSONObject.optJSONObject("data"));
        }
    }
}
