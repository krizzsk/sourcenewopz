package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import org.json.JSONObject;

public class FlightOrderInfo extends BaseObject {
    private String endAddress;
    private String flightNumber;
    private int flightStatus;
    private int oType;
    private int onboard_tip;
    private String onboard_tip_text_after;
    private String onboard_tip_text_before;
    private String onboard_tip_url_after;
    private String onboard_tip_url_before;
    private String orderId;
    private String startAddress;
    private long time;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.orderId = optJSONObject.optString("oid");
            this.oType = optJSONObject.optInt(ParamKeys.PARAM_OTYPE);
            this.flightNumber = optJSONObject.optString("flight_no");
            this.time = optJSONObject.optLong("time") * 1000;
            this.startAddress = optJSONObject.optString("start");
            this.endAddress = optJSONObject.optString("dest");
            this.flightStatus = optJSONObject.optInt("status");
            this.onboard_tip = optJSONObject.optInt("onboard_tip");
            this.onboard_tip_text_before = optJSONObject.optString("onboard_tip_text_before");
            this.onboard_tip_text_after = optJSONObject.optString("onboard_tip_text_after");
            this.onboard_tip_url_before = optJSONObject.optString("onboard_tip_url_before");
            this.onboard_tip_url_after = optJSONObject.optString("onboard_tip_url_after");
        }
    }

    public String getOnboard_tip_url_before() {
        return this.onboard_tip_url_before;
    }

    public void setOnboard_tip_url_before(String str) {
        this.onboard_tip_url_before = str;
    }

    public String getOnboard_tip_url_after() {
        return this.onboard_tip_url_after;
    }

    public void setOnboard_tip_url_after(String str) {
        this.onboard_tip_url_after = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public int getoType() {
        return this.oType;
    }

    public void setoType(int i) {
        this.oType = i;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String str) {
        this.flightNumber = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String getStartAddress() {
        return this.startAddress;
    }

    public void setStartAddress(String str) {
        this.startAddress = str;
    }

    public String getEndAddress() {
        return this.endAddress;
    }

    public void setEndAddress(String str) {
        this.endAddress = str;
    }

    public int getOnboard_tip() {
        return this.onboard_tip;
    }

    public void setOnboard_tip(int i) {
        this.onboard_tip = i;
    }

    public String getOnboard_tip_text_before() {
        return this.onboard_tip_text_before;
    }

    public void setOnboard_tip_text_before(String str) {
        this.onboard_tip_text_before = str;
    }

    public String getOnboard_tip_text_after() {
        return this.onboard_tip_text_after;
    }

    public void setOnboard_tip_text_after(String str) {
        this.onboard_tip_text_after = str;
    }

    public int getFlightStatus() {
        return this.flightStatus;
    }

    public void setFlightStatus(int i) {
        this.flightStatus = i;
    }

    public boolean isFlightCanceled() {
        return this.flightStatus == -1;
    }

    public String toString() {
        return "FlightOrderInfo{orderId='" + this.orderId + '\'' + ", oType=" + this.oType + ", flightNumber='" + this.flightNumber + '\'' + ", time=" + this.time + ", startAddress='" + this.startAddress + '\'' + ", endAddress='" + this.endAddress + '\'' + ", flightStatus=" + this.flightStatus + ", onboard_tip=" + this.onboard_tip + ", onboard_tip_text_before='" + this.onboard_tip_text_before + '\'' + ", onboard_tip_text_after='" + this.onboard_tip_text_after + '\'' + ", onboard_tip_url_before='" + this.onboard_tip_url_before + '\'' + ", onboard_tip_url_after='" + this.onboard_tip_url_after + '\'' + '}';
    }
}
