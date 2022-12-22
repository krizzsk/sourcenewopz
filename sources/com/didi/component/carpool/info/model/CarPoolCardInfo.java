package com.didi.component.carpool.info.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CarPoolCardInfo extends BaseObject {
    public int guideType = 0;
    public LEGORichInfo noticeInfo;
    public List<TravelInfoMsg> travelInfoMsgList = new ArrayList();
    public List<WaitLinePointData> waitPoints = new ArrayList();

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        super.parse(jSONObject);
        if (jSONObject != null) {
            try {
                if (jSONObject.has("normal") && (optJSONObject = jSONObject.optJSONObject("normal")) != null && optJSONObject.has("data") && (optJSONObject2 = optJSONObject.optJSONObject("data")) != null) {
                    if (optJSONObject2.has("willing_to_go_info")) {
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("willing_to_go_info");
                        if (optJSONObject4 != null && optJSONObject4.has("wait_line_data") && (optJSONArray2 = optJSONObject4.optJSONArray("wait_line_data")) != null && optJSONArray2.length() > 0) {
                            for (int i = 0; i < optJSONArray2.length(); i++) {
                                JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i);
                                WaitLinePointData waitLinePointData = new WaitLinePointData();
                                waitLinePointData.parse(optJSONObject5);
                                this.waitPoints.add(waitLinePointData);
                            }
                        }
                        if (optJSONObject4 != null && optJSONObject4.has(ParamKeys.PARAM_GUIDE_TYPE)) {
                            this.guideType = optJSONObject4.optInt(ParamKeys.PARAM_GUIDE_TYPE);
                        }
                    }
                    if (optJSONObject2.has("travel_info_msg") && (optJSONArray = optJSONObject2.optJSONArray("travel_info_msg")) != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject6 = optJSONArray.optJSONObject(i2);
                            TravelInfoMsg travelInfoMsg = new TravelInfoMsg();
                            travelInfoMsg.parse(optJSONObject6);
                            this.travelInfoMsgList.add(travelInfoMsg);
                        }
                    }
                    if (optJSONObject2.has("notice_info") && (optJSONObject3 = optJSONObject2.optJSONObject("notice_info")) != null) {
                        LEGORichInfo lEGORichInfo = new LEGORichInfo();
                        this.noticeInfo = lEGORichInfo;
                        lEGORichInfo.setInfo(optJSONObject3.toString());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
