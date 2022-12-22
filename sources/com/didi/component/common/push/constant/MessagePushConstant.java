package com.didi.component.common.push.constant;

public class MessagePushConstant {

    public static class EXPECTATION_MANAGEMENT_TYPE {
        public static final int DUSE_STATUS_BROADCAST_SUCCESS = 5;
        public static final int DUSE_STATUS_DISPATCH = 1;
        public static final int DUSE_STATUS_ENTER_BROADCAST_CUBE = 3;
        public static final int DUSE_STATUS_INIT = 2;
    }

    public static class EXPECTATION_SCENE_TYPE {
        public static final int SCENE_CAR = 6;
        public static final int SCENE_FAST = 1;
        public static final int SCENE_ZERO = 3;
    }

    public static class FCM_TYPE {
        public static final int COMMON_ROUTER = 15;
        public static final int IM_MESSAGE = 259;
        public static final int ORDER_STATUS = 11;
        public static final int PAY_4_WAITING = 10;
        public static final int SPLIT_FARE_INVITE = 12;
        public static final int VOIP_OPEN = 18;
    }
}
