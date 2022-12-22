package com.didi.soda.customer.foundation.tracker.error;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ErrorTracker {

    /* renamed from: a */
    private static final String f41099a = "ErrorTracker";

    /* renamed from: b */
    private static ErrorTrackerHandler f41100b;
    public String mErrorMsg;
    public String mErrorName;
    public String mErrorType;
    public Map<String, Object> mMap;
    public String mModuleName;

    private ErrorTracker(String str) {
        this.mErrorName = str;
        this.mMap = new HashMap();
    }

    public static Builder create(String str) {
        return new Builder(str);
    }

    public static void init(ErrorTrackerHandler errorTrackerHandler) {
        f41100b = errorTrackerHandler;
    }

    public static String getExceptionMsg(Exception exc) {
        if (exc == null) {
            return "";
        }
        StackTraceElement[] stackTrace = exc.getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(exc.toString() + " ");
        for (int i = 0; i < stackTrace.length; i++) {
            stringBuffer.append(stackTrace[i].toString() + " ");
        }
        return stringBuffer.toString();
    }

    public static String getErrorType(Exception exc) {
        if (exc == null) {
            return "";
        }
        if (exc.getCause() == null) {
            return exc.getClass().getSimpleName();
        }
        return exc.getCause().getClass().getSimpleName();
    }

    public void addParams(String str, Object obj) {
        this.mMap.put(str, obj);
    }

    public String toString() {
        return "ErrorTracker{mMap=" + this.mMap + ", mErrorName='" + this.mErrorName + '\'' + '}';
    }

    public void trackError() {
        ErrorTrackerHandler errorTrackerHandler = f41100b;
        if (errorTrackerHandler != null) {
            errorTrackerHandler.trackError(this.mModuleName, this.mErrorName, this.mErrorType, this.mErrorMsg, this.mMap);
        }
    }

    public static final class Builder {
        private ErrorTracker mErrorTracker;

        private Builder(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mErrorTracker = new ErrorTracker(str);
                return;
            }
            throw new IllegalStateException("mErrorName must have value");
        }

        public Builder addErrorMsg(String str) {
            this.mErrorTracker.mErrorMsg = str;
            addParam("error_msg", str);
            return this;
        }

        public Builder addErrorType(String str) {
            this.mErrorTracker.mErrorType = str;
            addParam("error_type", str);
            return this;
        }

        public Builder addModuleName(String str) {
            this.mErrorTracker.mModuleName = str;
            addParam("module_name", str);
            return this;
        }

        public Builder addParam(String str, Object obj) {
            this.mErrorTracker.addParams(str, obj);
            return this;
        }

        public ErrorTracker build() {
            return this.mErrorTracker;
        }
    }

    private final class ErrorKey {
        public static final String ERROR_MSG = "error_msg";
        public static final String ERROR_TYPE = "error_type";
        public static final String MODULE_NAME = "module_name";

        private ErrorKey() {
        }
    }
}
