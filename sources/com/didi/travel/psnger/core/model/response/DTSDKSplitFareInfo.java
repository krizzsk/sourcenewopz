package com.didi.travel.psnger.core.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DTSDKSplitFareInfo extends BaseObject {
    public static final int SPLIT_ROLE_OWNER = 1;
    public static final int SPLIT_ROLE_USER = 0;
    public static final int SPLIT_STATUS_FINISHED = 6;
    public static final int SPLIT_STATUS_INIT = 0;
    public static final int SPLIT_STATUS_OWNER_CANCELED = 3;
    public static final int SPLIT_STATUS_PAY_SUCCESS = 4;
    public static final int SPLIT_STATUS_SERVICE_CLOSED = 5;
    public static final int SPLIT_STATUS_UNKNOWN = -1;
    public static final int SPLIT_STATUS_USER_ACCEPTED = 1;
    public static final int SPLIT_STATUS_USER_REFUSED = 2;
    public String fee_msg_content;
    public String fee_msg_title;
    public int is_available;
    public int is_visible;
    public List<PayWayModel.PayWayItem> splitUserPayList;
    public int split_fare_role = -1;
    public String split_msg_content;
    public String split_msg_title;
    public int split_status = -1;
    public List<SplitUser> split_user_list = new ArrayList();

    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            this.is_visible = jSONObject.optInt("is_visible");
            this.is_available = jSONObject.optInt("is_available");
            this.split_status = jSONObject.optInt("split_status", -1);
            this.fee_msg_title = jSONObject.optString("fee_msg_title");
            this.fee_msg_content = jSONObject.optString("available_msg_content");
            this.split_msg_title = jSONObject.optString("split_msg_title");
            this.split_msg_content = jSONObject.optString("split_msg_content");
            this.split_fare_role = jSONObject.optInt("split_fare_role", -1);
            this.split_user_list.clear();
            if (jSONObject.has("split_user_list")) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("split_user_list");
                int length = optJSONArray2.length();
                for (int i = 0; i < length; i++) {
                    SplitUser splitUser = new SplitUser();
                    splitUser.parse(optJSONArray2.optJSONObject(i));
                    this.split_user_list.add(splitUser);
                }
            }
            if (jSONObject.has("user_pay_list") && (optJSONArray = jSONObject.optJSONArray("user_pay_list")) != null) {
                this.splitUserPayList = new JsonUtil().parseJSONArray(optJSONArray, new PayWayModel.PayWayItem());
            }
        }
    }

    public static class SplitUser extends BaseObject {
        public int _extType = 0;
        public String avatar_url;
        public String name;
        public String nick;
        public String phone;
        public String pid;
        public int role;
        public int status;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.pid = jSONObject.optString("pid");
                this.status = jSONObject.optInt("status");
                this.avatar_url = jSONObject.optString("avatar_url");
                this.name = jSONObject.optString("name");
                this.nick = jSONObject.optString("nick");
                this.phone = jSONObject.optString("phone");
                this.role = jSONObject.optInt("role");
            }
        }
    }

    public boolean isOwner() {
        return this.split_fare_role == 1;
    }
}
