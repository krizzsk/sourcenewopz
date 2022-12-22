package com.didi.soda.customer.timemachine;

public class MachineConst {

    public class Event {
        public static final String API_TRACE = "sailing_c_x_api_traceID";
        public static final String PAGE_ENTRY = "sailing_c_x_page_entry";
        public static final String PAGE_LEAVE = "sailing_c_x_page_leave";
        public static final String SYSTEM_BACKGROUND = "sailing_c_x_system_enterBackground";
        public static final String SYSTEM_FOREGROUND = "sailing_c_x_system_becomeActive";

        public Event() {
        }
    }

    public class Params {
        public static final String BASE_URL = "baseUrl";
        public static final String PAGE_NAME = "pageName";
        public static final String TRACE_ID = "traceID";

        public Params() {
        }
    }
}
