package com.didi.sdk.push;

public class AppEvent {
    public static final int AppEventBackFrontSwitch = 0;
    public static final int AppEventNetStatusChange = 1;

    public static class AppBackFrontEventValue {
        public static final int AppBackground = 1;
        public static final int AppForeground = 0;
    }

    public static class AppNetStatusChangeEventValue {
        public static final int AppNetStatusNoNet = 0;
        public static final int AppNetStatusWWAN = 1;
        public static final int AppNetStatusWiFi = 2;
    }
}
