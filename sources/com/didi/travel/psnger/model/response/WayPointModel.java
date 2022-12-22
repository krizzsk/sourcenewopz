package com.didi.travel.psnger.model.response;

import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WayPointModel extends BaseObject {
    private static final int TYPE_DIALOG_MODEL_CANCEL = 0;
    private static final int TYPE_DIALOG_MODEL_OK = 1;
    public int carPrice;
    public int driverDisplayPrice;
    private HashMap<String, Object> mLogData;
    private String message;
    private int status;
    private String title;
    private String version;
    private List<WayPointDialogModel> wayPointDialogModelList;

    public HashMap<String, Object> getLogData() {
        return this.mLogData;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public List<WayPointDialogModel> getWayPointDialogModelList() {
        return this.wayPointDialogModelList;
    }

    public void setWayPointDialogModelList(List<WayPointDialogModel> list) {
        this.wayPointDialogModelList = list;
    }

    public WayPointDialogModel getCancelDialogModel() {
        List<WayPointDialogModel> list = this.wayPointDialogModelList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (WayPointDialogModel next : this.wayPointDialogModelList) {
            if (next.getType() == 0) {
                return next;
            }
        }
        return null;
    }

    public WayPointDialogModel getOKDialogModel() {
        List<WayPointDialogModel> list = this.wayPointDialogModelList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (WayPointDialogModel next : this.wayPointDialogModelList) {
            if (next.getType() == 1) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.carPrice = optJSONObject.optInt("car_price");
            this.driverDisplayPrice = optJSONObject.optInt("driver_display_price");
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(Const.POPUP);
            if (optJSONObject3 != null) {
                this.title = optJSONObject3.optString("title");
                this.message = optJSONObject3.optString("show_msg");
                this.wayPointDialogModelList = new ArrayList();
                try {
                    JSONArray jSONArray = optJSONObject3.getJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    if (jSONArray != null) {
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            WayPointDialogModel wayPointDialogModel = new WayPointDialogModel();
                            wayPointDialogModel.parse(jSONArray.optString(i));
                            this.wayPointDialogModelList.add(wayPointDialogModel);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("extension");
            if (!(optJSONObject4 == null || (optJSONObject2 = optJSONObject4.optJSONObject("log_data")) == null)) {
                this.mLogData = (HashMap) new Gson().fromJson(optJSONObject2.toString(), new TypeToken<HashMap<String, Object>>() {
                }.getType());
            }
            this.version = optJSONObject.optInt(ParamKeys.PARAM_WAY_POINTS_VERSION) + "";
        }
    }

    public String toString() {
        return "WayPointModel{status=" + this.status + ", title='" + this.title + '\'' + ", message='" + this.message + '\'' + ", version='" + this.version + '\'' + '}';
    }
}
