package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONObject;

public class CharteredComboInfo extends BaseObject implements Comparable<CharteredComboInfo> {
    public String desc;
    public double distance;

    /* renamed from: id */
    public int f44215id;
    public int isDefault;
    public double money;
    public CarCharteredH5RentInfo rented_info;
    public int time;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.f44215id = jSONObject.optInt(ParamKeys.PARAM_COMBO_ID);
        this.money = jSONObject.optDouble("combo_fee");
        this.distance = jSONObject.optDouble("combo_distance");
        this.time = jSONObject.optInt("combo_time");
        this.isDefault = jSONObject.optInt("is_default_combo");
        this.desc = jSONObject.optString("combo_desc");
        CarCharteredH5RentInfo carCharteredH5RentInfo = new CarCharteredH5RentInfo();
        this.rented_info = carCharteredH5RentInfo;
        carCharteredH5RentInfo.package_title = jSONObject.optString("package_title");
        this.rented_info.package_id = jSONObject.optString("package_id");
    }

    public boolean isDefault() {
        return 1 == this.isDefault;
    }

    public int compareTo(CharteredComboInfo charteredComboInfo) {
        return Double.compare((double) this.time, (double) charteredComboInfo.time);
    }

    public String toString() {
        return "ComboInfo{id=" + this.f44215id + ", money=" + this.money + ", distance=" + this.distance + ", time=" + this.time + '}';
    }
}
