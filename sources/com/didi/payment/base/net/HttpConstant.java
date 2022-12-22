package com.didi.payment.base.net;

public interface HttpConstant {

    public interface ContentType {
        public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    }

    public interface HttpError {
        public static final String ERROR_ANALYSIS = "-3";
        public static final String ERROR_NETWORK = "-1";
        public static final String ERROR_STATUS = "-2";
    }

    public interface HttpName {
        public static final String HTTP_LOG_EVENT = "pay_request_statistics";
        public static final String HTTP_LOG_STATUS = "status";
        public static final String HTTP_LOG_TIME = "time";
        public static final String HTTP_LOG_URL = "url";
    }
}
