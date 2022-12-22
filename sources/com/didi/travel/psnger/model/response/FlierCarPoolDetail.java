package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FlierCarPoolDetail extends BaseObject {
    public int errno;
    public int friendCnt;
    public List<FlierPosition> historyList = new ArrayList();
    public List<MapBubbleMsg> mapBubbleMsgList = new ArrayList();
    public List<Passenger> passengerList = new ArrayList();
    public String passengerPhone;
    public List<FlierPosition> positonList = new ArrayList();
    public String pushFlag;
    public PushInfo pushInfo;
    public String pushTips;
    public String rewardAmount;
    public String rewardStatus;
    public int searchPassenger;
    public List<TravelInfoMsg> travelInfoMsgList = new ArrayList();
    public String uid;

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("errno =");
        sb.append(this.errno);
        sb.append("\n");
        sb.append("search_passenger =");
        sb.append(this.searchPassenger);
        sb.append("\n");
        sb.append("uid =");
        sb.append(this.uid);
        sb.append("\n");
        sb.append("pushTips =");
        sb.append(this.pushTips);
        sb.append("\n");
        sb.append("passenger_phone =");
        sb.append(this.passengerPhone);
        sb.append("\n");
        sb.append("friendCnt =");
        sb.append(this.friendCnt);
        sb.append("\n");
        sb.append("pushFlag =");
        sb.append(this.pushFlag);
        sb.append("\n");
        for (int i = 0; i < this.passengerList.size(); i++) {
            sb.append("passengerList [" + i + "] =");
            sb.append(this.passengerList.get(i).toString());
            sb.append("\n");
        }
        for (int i2 = 0; i2 < this.positonList.size(); i2++) {
            sb.append("positonList [" + i2 + "] =");
            sb.append(this.positonList.get(i2).toString());
            sb.append("\n");
        }
        for (int i3 = 0; i3 < this.historyList.size(); i3++) {
            sb.append("historyList [" + i3 + "] =");
            sb.append(this.historyList.get(i3).toString());
            sb.append("\n");
        }
        for (int i4 = 0; i4 < this.travelInfoMsgList.size(); i4++) {
            sb.append("travelInfoMsgList [" + i4 + "] =");
            sb.append(this.travelInfoMsgList.get(i4).toString());
            sb.append("\n");
        }
        for (int i5 = 0; i5 < this.mapBubbleMsgList.size(); i5++) {
            sb.append("mapBubbleMsgList [" + i5 + "] =");
            sb.append(this.mapBubbleMsgList.get(i5).toString());
            sb.append("\n");
        }
        sb.append("pushInfo = ");
        if (this.pushInfo != null) {
            str = "" + this.pushInfo;
        } else {
            str = "null";
        }
        sb.append(str);
        sb.append("\n");
        return sb.toString();
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.errno = jSONObject.optInt("errno");
            if (jSONObject.optJSONObject("data") != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                this.searchPassenger = optJSONObject.optInt("search_passenger");
                this.uid = optJSONObject.optString("uid");
                this.pushTips = optJSONObject.optString("pushTips");
                this.rewardStatus = optJSONObject.optString("reward_status");
                this.rewardAmount = optJSONObject.optString("reward_amount");
                this.friendCnt = optJSONObject.optInt("friendCnt");
                this.passengerPhone = optJSONObject.optString(ParamKeys.PARAM_PASSENGER_PHONE);
                this.pushFlag = optJSONObject.optString("pushFlag");
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray(NativeProtocol.AUDIENCE_FRIENDS);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            Passenger passenger = new Passenger();
                            passenger.parse(jSONObject2);
                            this.passengerList.add(passenger);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("line_data");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                            FlierPosition flierPosition = new FlierPosition();
                            flierPosition.parse(jSONObject3);
                            this.positonList.add(flierPosition);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("history_data");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        int length3 = optJSONArray3.length();
                        for (int i3 = 0; i3 < length3; i3++) {
                            JSONObject jSONObject4 = optJSONArray3.getJSONObject(i3);
                            FlierPosition flierPosition2 = new FlierPosition();
                            flierPosition2.parse(jSONObject4);
                            this.historyList.add(flierPosition2);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    JSONArray optJSONArray4 = optJSONObject.optJSONArray("travel_info_msg");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        int length4 = optJSONArray4.length();
                        for (int i4 = 0; i4 < length4; i4++) {
                            JSONObject jSONObject5 = optJSONArray4.getJSONObject(i4);
                            TravelInfoMsg travelInfoMsg = new TravelInfoMsg();
                            travelInfoMsg.parse(jSONObject5);
                            this.travelInfoMsgList.add(travelInfoMsg);
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                try {
                    JSONArray optJSONArray5 = optJSONObject.optJSONArray("map_bubble_msg");
                    if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                        int length5 = optJSONArray5.length();
                        for (int i5 = 0; i5 < length5; i5++) {
                            JSONObject jSONObject6 = optJSONArray5.getJSONObject(i5);
                            MapBubbleMsg mapBubbleMsg = new MapBubbleMsg();
                            mapBubbleMsg.parse(jSONObject6);
                            this.mapBubbleMsgList.add(mapBubbleMsg);
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("push_info");
                if (optJSONObject2 != null) {
                    PushInfo pushInfo2 = new PushInfo();
                    this.pushInfo = pushInfo2;
                    pushInfo2.parse(optJSONObject2);
                }
            }
        }
    }

    public static class PushInfo extends BaseObject {
        public String msg;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.msg = jSONObject.optString("msg");
            }
        }

        public String toString() {
            return "{msg:" + this.msg + "}";
        }
    }
}
