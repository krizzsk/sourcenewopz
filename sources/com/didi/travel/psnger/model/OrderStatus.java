package com.didi.travel.psnger.model;

import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;

public final class OrderStatus {
    public static int CARPOOL_STATUS_DEFAULT = 0;
    public static int CARPOOL_STATUS_START_TRIP = 400700;
    public static int CARPOOL_STATUS_WAIT_CORIDER_ON_BOARD_BEFORE_LATE = 400701;
    public static int CARPOOL_STATUS_WAIT_CORIDER_ON_BOARD_LATE = 400702;
    public static final int ORDER_STATUS_ASSIGN_TIMEOUT = 7005;
    public static final int ORDER_STATUS_CANCEL_TRIP = 6;
    public static final int ORDER_STATUS_CANCEL_TRIP_NOPAY = 6001;
    public static final int ORDER_STATUS_CANCEL_TRIP_PAID = 6002;
    public static final int ORDER_STATUS_CLOSE_ORDER = 2;
    public static final int ORDER_STATUS_CLOSE_ORDER_BY_CHANGE = 2002;
    public static final int ORDER_STATUS_CLOSE_ORDER_BY_DIVERSION = 2004;
    public static final int ORDER_STATUS_CLOSE_ORDER_BY_MIS = 2001;
    public static final int ORDER_STATUS_CLOSE_ORDER_BY_SERVICE = 2003;
    public static final int ORDER_STATUS_CLOSE_ORDER_NO_DRIVER_SERVICE = 2005;
    public static final int ORDER_STATUS_COMPANY_ACCEPTED = 7008;
    public static final int ORDER_STATUS_COMPANY_UNACCEPTED = 7007;
    public static final int ORDER_STATUS_DOING = 4;
    public static final int ORDER_STATUS_DOING_BILLING_LAT = 4005;
    public static final int ORDER_STATUS_DOING_CHANING = 4000;
    public static final int ORDER_STATUS_DOING_DRIVER_ARRIVAL = 4003;
    public static final int ORDER_STATUS_DOING_DRIVER_LAT = 4002;
    public static final int ORDER_STATUS_DOING_ON_SERVICE = 4006;
    public static final int ORDER_STATUS_DOING_PASSENGER_LAT = 4004;
    public static final int ORDER_STATUS_DOING_TRAVEL_START_SOON = 4007;
    public static final int ORDER_STATUS_DOING_WAIT = 4001;
    public static final int ORDER_STATUS_NOT_PAY = 5;
    public static final int ORDER_STATUS_NOT_PAY_CANCEL = 5002;
    public static final int ORDER_STATUS_NOT_PAY_DRIVER_CANCEL = 5003;
    public static final int ORDER_STATUS_NOT_PAY_NORMAL = 5001;
    public static final int ORDER_STATUS_PAY_FINISH = 3;
    public static final int ORDER_STATUS_RESET = 0;
    public static final int ORDER_STATUS_WAIT_ARRRIVAL = 1;
    public static final int ORDER_STATUS_WAIT_RESPONSE = 7;
    public static final int ORDER_STATUS_WAIT_RESPONSE_ASSIGN_DOING = 7004;
    public static final int ORDER_STATUS_WAIT_RESPONSE_ASSIGN_SUCCESS = 7003;
    public static int QUIT_SPLIT_FARE_CODE = 700013;

    public static boolean isOnService(ICarOrder iCarOrder) {
        if (iCarOrder == null) {
            return false;
        }
        IOrderStatus orderStatus = iCarOrder.getOrderStatus();
        if ((orderStatus != null ? orderStatus.status() : iCarOrder.getStatus()) == 4) {
            return true;
        }
        return false;
    }

    public static boolean isWaitResponse(ICarOrder iCarOrder) {
        if (iCarOrder == null) {
            return false;
        }
        IOrderStatus orderStatus = iCarOrder.getOrderStatus();
        if ((orderStatus != null ? orderStatus.status() : iCarOrder.getStatus()) == 7) {
            return true;
        }
        return false;
    }
}
