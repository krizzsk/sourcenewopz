package com.didi.component.expectation.model;

import android.text.TextUtils;
import com.didi.component.common.model.bubble.CommonBubbleItemModel;
import com.didi.component.common.push.CommonPushManager;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.json.JSONObject;

public class ExpectationData {
    @SerializedName("car_request_bubble_tip")
    public CommonBubbleItemModel carRequestingBubbleTip;
    @SerializedName("car_request_list")
    public List<AnyCarRequesting> carRequestingList;
    @SerializedName("count_order")
    private int countOrder;
    @SerializedName("coupon_info")
    private CouponInfo couponInfo;
    @SerializedName("adjust_price_card")
    public FlexRaise flex_raise;
    @SerializedName("matching_state")
    private List<MatchingState> matchingStateList;
    @SerializedName("progress_state")
    private List<ProgressState> progressStateList;
    @SerializedName("bar_type")
    private int sceneType;
    @SerializedName("skip_push")
    public int skip_push;
    @SerializedName("syncMsg")
    private JSONObject syncMsg;
    @SerializedName("time_prefix")
    private String timePreFix;
    @SerializedName("total_wait_time")
    private int totalWaitTime;
    @SerializedName("use_privilege")
    public UsePrivilege usePrivilege;
    @SerializedName("waited_time")
    private int waitedTime;

    public int getSceneType() {
        return this.sceneType;
    }

    public void setSceneType(int i) {
        this.sceneType = i;
    }

    public int getWaitedTime() {
        return this.waitedTime;
    }

    public void setWaitedTime(int i) {
        this.waitedTime = i;
    }

    public CouponInfo getCouponInfo() {
        return this.couponInfo;
    }

    public void setCouponInfo(CouponInfo couponInfo2) {
        this.couponInfo = couponInfo2;
    }

    public String getTimePreFix() {
        return this.timePreFix;
    }

    public int getTotalWaitTime() {
        return this.totalWaitTime;
    }

    public void setTotalWaitTime(int i) {
        this.totalWaitTime = i;
    }

    public int getCountOrder() {
        return this.countOrder;
    }

    public void setCountOrder(int i) {
        this.countOrder = i;
    }

    public List<MatchingState> getMatchingStateList() {
        return this.matchingStateList;
    }

    public void setMatchingStateList(List<MatchingState> list) {
        this.matchingStateList = list;
    }

    public List<ProgressState> getProgressStateList() {
        return this.progressStateList;
    }

    public void setProgressStateList(List<ProgressState> list) {
        this.progressStateList = list;
    }

    public ExpectationManagementModel getExpectationManagementModel() {
        ExpectationManagementModel expectationManagementPair;
        JSONObject jSONObject = this.syncMsg;
        if (jSONObject == null || (expectationManagementPair = CommonPushManager.getExpectationManagementPair(jSONObject.toString())) == null) {
            return null;
        }
        if (!TextUtils.isEmpty(expectationManagementPair.oid) || !TextUtils.isEmpty(expectationManagementPair.oid_base64)) {
            return expectationManagementPair;
        }
        return null;
    }
}
