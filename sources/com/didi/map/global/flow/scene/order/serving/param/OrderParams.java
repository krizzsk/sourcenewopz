package com.didi.map.global.flow.scene.order.serving.param;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.List;

public class OrderParams {
    public static final int STAGE_CANCEL = 3;
    public static final int STAGE_EXCEPTION = 4;
    public static final int STAGE_ON_TRIP = 2;
    public static final int STAGE_PICKUP = 0;
    public static final int STAGE_WAIT = 1;
    public Bitmap carpoolEndIcon;
    public Bitmap carpoolStartIcon;
    public long driverId;
    public boolean isShowExtendedAnimation;
    public String lastOrderId;
    public String licensePlateNumber;
    public List<OdPoint> odPoints;
    public long odPointsTimestamp;
    public String orderId;
    public int orderStage;
    public int orderType;
    public String phoneNumPassenger;
    public int pickupExtendedAnimDurationInMs;
    public String productID;
    public String srcTag;
    public String stationWalkGuideLink;
    public String stationWalkGuidePhoto;
    public String travelId;

    public OrderParams(String str, long j, String str2) {
        this.orderId = str;
        this.driverId = j;
        this.phoneNumPassenger = str2;
    }

    public boolean isCarpoolOrder() {
        return !TextUtils.isEmpty(this.travelId);
    }

    public String toString() {
        return "OrderParams{orderId='" + this.orderId + '\'' + ", driverId=" + this.driverId + ", licensePlateNumber='" + this.licensePlateNumber + '\'' + ", phoneNumPassenger='" + this.phoneNumPassenger + '\'' + ", travelId='" + this.travelId + '\'' + ", productID='" + this.productID + '\'' + ", carpoolStartIcon=" + this.carpoolStartIcon + ", carpoolEndIcon=" + this.carpoolEndIcon + ", pickupExtendedAnimDurationInMs=" + this.pickupExtendedAnimDurationInMs + ", isShowExtendedAnimation=" + this.isShowExtendedAnimation + ", orderStage=" + this.orderStage + ", orderType=" + this.orderType + ", srcTag='" + this.srcTag + '\'' + ", stationWalkGuideLink='" + this.stationWalkGuideLink + '\'' + ", stationWalkGuidePhoto='" + this.stationWalkGuidePhoto + '\'' + '}';
    }
}
