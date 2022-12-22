package com.didi.map.google.config;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/map/google/config/Config;", "", "()V", "Companion", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Config.kt */
public final class Config {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static boolean DEBUG = false;
    public static boolean DEBUG_ORA = false;
    public static String DEBUG_ORA_URL = "";
    public static String DEBUG_TAG = "sctx_test";
    public static boolean DEFAULT_BLUETOOTH_SCAN = false;
    public static final int DURATION_100 = 100;
    public static final int DURATION_DEFAULT = 0;
    public static final int MULTI_ROUTE = 1;
    public static final String POINT_DISMISS_KEY = "point_dismiss";
    public static final String PREFERENCE_NAME = "settings";
    public static final String ROUTE_TYPE_KEY = "route_type";
    public static int RecommendDuration;
    public static int RouteType = 1;
    public static final int SINGLE_ROUTE = 0;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/map/google/config/Config$Companion;", "", "()V", "DEBUG", "", "DEBUG_ORA", "DEBUG_ORA_URL", "", "DEBUG_TAG", "DEFAULT_BLUETOOTH_SCAN", "DURATION_100", "", "DURATION_DEFAULT", "MULTI_ROUTE", "POINT_DISMISS_KEY", "PREFERENCE_NAME", "ROUTE_TYPE_KEY", "RecommendDuration", "RouteType", "SINGLE_ROUTE", "RouteTypeD", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Config.kt */
    public static final class Companion {

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo175978d2 = {"Lcom/didi/map/google/config/Config$Companion$RouteTypeD;", "", "base-sync-trip_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        @Retention(AnnotationRetention.SOURCE)
        @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
        /* compiled from: Config.kt */
        public @interface RouteTypeD {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
