package com.didi.soda.customer.flutter.performance;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.foundation.sdk.log.LogService;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.logging.Logger;
import com.didi.soda.customer.flutter.FlutterCommons;
import com.didi.soda.customer.flutter.FlutterHelper;
import java.util.HashMap;

public final class FlutterPerformanceTracker {
    public static final String EVENT_LOW_MEMORY = "memory_low";
    public static final String EVENT_SHOW_ORDER_DETAIL = "page_order_detail_sw";
    public static final String EVENT_UNKNOWN = "unknown";
    public static final String KEY_CONTAINER_CREATE = "flutter_container_create";
    public static final String KEY_EVENT = "flutter_event";
    public static final String KEY_MANUFACTURER = "flutter_manufacturer";
    public static final String KEY_MODEL = "flutter_model";
    public static final String KEY_OSTYPE = "flutter_ostype";
    public static final String KEY_OS_VERSION = "flutter_osversion";
    public static final String KEY_START = "flutter_start";
    public static final String KEY_TYPE = "flutter_type";
    public static final String TYPE_FLUTTER = "flutter";
    public static final String TYPE_NATIVE = "native";
    public static final String TYPE_UNKNOWN = "unknown";

    private FlutterPerformanceTracker() {
    }

    public static void trackMemoryLow() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", EVENT_LOW_MEMORY);
        FlutterHelper.trackFlutterPerformance(hashMap);
    }

    public static class TrackerInternal {
        long mContainerCreateEnd;
        long mDataLoadedEnd;
        String mEventName = "unknown";
        private Logger mLogger = LogService.getLogger(TrackerInternal.class.getName());
        long mOnCreateEnd;
        long mStart;
        String mType = "unknown";

        public long getStart() {
            return this.mStart;
        }

        public TrackerInternal refreshStart() {
            this.mStart = System.currentTimeMillis();
            return this;
        }

        public TrackerInternal eventName(String str) {
            this.mEventName = str;
            return this;
        }

        public TrackerInternal flutterPageToEvent(String str) {
            if (TextUtils.isEmpty(str)) {
                this.mEventName = "unknown";
            } else {
                char c = 65535;
                if (str.hashCode() == -306410479 && str.equals(FlutterCommons.FLUTTER_ROUTE_ORDER_DETAIL)) {
                    c = 0;
                }
                if (c != 0) {
                    this.mEventName = "unknown";
                } else {
                    this.mEventName = FlutterPerformanceTracker.EVENT_SHOW_ORDER_DETAIL;
                }
            }
            return this;
        }

        public TrackerInternal type(String str) {
            this.mType = str;
            return this;
        }

        public void recordOnCreate() {
            this.mOnCreateEnd = System.currentTimeMillis();
        }

        public void recordContainerOnCreate() {
            this.mContainerCreateEnd = System.currentTimeMillis();
        }

        public void recordOnDataLoaded(boolean z) {
            this.mDataLoadedEnd = z ? System.currentTimeMillis() : 0;
            track();
        }

        public void turnIntoFlutter(Bundle bundle) {
            this.mType = "flutter";
            bundle.putString(FlutterPerformanceTracker.KEY_EVENT, this.mEventName);
            bundle.putString(FlutterPerformanceTracker.KEY_TYPE, this.mType);
            bundle.putLong(FlutterPerformanceTracker.KEY_START, this.mStart);
            bundle.putLong(FlutterPerformanceTracker.KEY_CONTAINER_CREATE, this.mContainerCreateEnd);
            bundle.putString(FlutterPerformanceTracker.KEY_OSTYPE, FlutterHelper.getOSType());
            bundle.putString(FlutterPerformanceTracker.KEY_MANUFACTURER, FlutterHelper.getManufacturer());
            bundle.putString(FlutterPerformanceTracker.KEY_MODEL, FlutterHelper.getModel());
            bundle.putString(FlutterPerformanceTracker.KEY_OS_VERSION, FlutterHelper.getOSVersion());
        }

        public void destroy() {
            this.mEventName = "unknown";
            this.mType = "unknown";
            this.mStart = 0;
            this.mOnCreateEnd = 0;
            this.mDataLoadedEnd = 0;
            this.mContainerCreateEnd = 0;
        }

        /* access modifiers changed from: protected */
        public void track() {
            long j = this.mOnCreateEnd;
            long j2 = this.mStart;
            long j3 = j - j2;
            long j4 = this.mDataLoadedEnd - j2;
            long j5 = this.mContainerCreateEnd - j2;
            this.mLogger.debug("======= Flutter Performance tracker =========", new Object[0]);
            Logger logger = this.mLogger;
            logger.debug("=== event = " + this.mEventName, new Object[0]);
            Logger logger2 = this.mLogger;
            logger2.debug("=== type = " + this.mType, new Object[0]);
            Logger logger3 = this.mLogger;
            logger3.debug("=== cost_create = " + (((double) j3) / 1000.0d) + RavenKey.STACK, new Object[0]);
            Logger logger4 = this.mLogger;
            logger4.debug("=== cost_data_load = " + (((double) j4) / 1000.0d) + RavenKey.STACK, new Object[0]);
            Logger logger5 = this.mLogger;
            logger5.debug("=== cost_container_create = " + (((double) j5) / 1000.0d) + RavenKey.STACK, new Object[0]);
            this.mLogger.debug("=============================================", new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("event", this.mEventName);
            hashMap.put("type", this.mType);
            hashMap.put("start", Long.valueOf(this.mStart));
            hashMap.put("end_create", Long.valueOf(this.mOnCreateEnd));
            hashMap.put("end_data_load", Long.valueOf(this.mDataLoadedEnd));
            hashMap.put("end_container_create", Long.valueOf(this.mContainerCreateEnd));
            hashMap.put("cost_create", Long.valueOf(j3));
            hashMap.put("cost_data_load", Long.valueOf(j4));
            hashMap.put("cost_container_create", Long.valueOf(j5));
            FlutterHelper.trackFlutterPerformance(hashMap);
        }
    }
}
