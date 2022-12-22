package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class DriverBarV2Model extends BaseObject {
    public DriverBarBenefitModel benefitModel;
    public String bluetoothMeetOption = "";
    public LEGORichInfo carLabel;
    public String driverHomeUrl = "";
    public DriverExtensionModel extensionModel;
    public DriverShowModel farModel;

    /* renamed from: id */
    public String f13001id;
    public String imOption;
    public DriverShowModel nearModel;
    public String oid = "";
    public String phoneOption;
    public String requireLevel;
    public int showControlOptions = 0;
    public int switchNearEnable = 0;
    public String template;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONArray optJSONArray;
        JSONObject optJSONObject4;
        super.parse(jSONObject);
        if (jSONObject != null) {
            try {
                this.f13001id = jSONObject.optString("id");
                this.template = jSONObject.optString("template");
                if (jSONObject.has("normal") && (optJSONObject = jSONObject.optJSONObject("normal")) != null && optJSONObject.has("data") && (optJSONObject2 = optJSONObject.optJSONObject("data")) != null) {
                    if (optJSONObject2.has("far_info")) {
                        this.farModel = new DriverShowModel();
                        JSONObject optJSONObject5 = optJSONObject2.optJSONObject("far_info");
                        if (optJSONObject5 != null) {
                            this.farModel.parse(optJSONObject5);
                        }
                    }
                    if (optJSONObject2.has("near_info")) {
                        this.nearModel = new DriverShowModel();
                        JSONObject optJSONObject6 = optJSONObject2.optJSONObject("near_info");
                        if (optJSONObject6 != null) {
                            this.nearModel.parse(optJSONObject6);
                        }
                    }
                    this.showControlOptions = optJSONObject2.optInt("show_control_options");
                    this.switchNearEnable = optJSONObject2.optInt("switch_near_scene_enable");
                    this.driverHomeUrl = optJSONObject2.optString("driver_homepage_url");
                    this.oid = optJSONObject2.optString("oid");
                    this.requireLevel = optJSONObject2.optString("require_level");
                    if (optJSONObject2.has("car_label_name") && (optJSONObject4 = optJSONObject2.optJSONObject("car_label_name")) != null) {
                        LEGORichInfo lEGORichInfo = new LEGORichInfo();
                        this.carLabel = lEGORichInfo;
                        lEGORichInfo.setInfo(optJSONObject4.toString());
                    }
                    if (optJSONObject2.has("operations") && (optJSONArray = optJSONObject2.optJSONArray("operations")) != null) {
                        int length = optJSONArray.length();
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject7 = optJSONArray.optJSONObject(i);
                            if (optJSONObject7 != null) {
                                arrayList.add(optJSONObject7.toString());
                            }
                        }
                        if (arrayList.size() > 0) {
                            this.imOption = (String) arrayList.get(0);
                        }
                        if (arrayList.size() > 1) {
                            this.phoneOption = (String) arrayList.get(1);
                        }
                        if (arrayList.size() > 2) {
                            this.bluetoothMeetOption = (String) arrayList.get(2);
                        }
                    }
                    if (optJSONObject2.has("benefits") && (optJSONObject3 = optJSONObject2.optJSONObject("benefits")) != null) {
                        DriverBarBenefitModel driverBarBenefitModel = new DriverBarBenefitModel();
                        this.benefitModel = driverBarBenefitModel;
                        driverBarBenefitModel.parse(optJSONObject3);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
