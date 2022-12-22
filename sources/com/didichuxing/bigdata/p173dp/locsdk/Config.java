package com.didichuxing.bigdata.p173dp.locsdk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.Config */
public class Config {
    public static final int GENERATED_LOC_TYPE_ALL = 0;
    public static final int GENERATED_LOC_TYPE_GPS = 1;
    public static final int GENERATED_LOC_TYPE_NETWORK = 2;
    public static final int LOC_TYPE_ALL = 0;
    public static final int LOC_TYPE_GPS = 1;
    public static final int LOC_TYPE_NETWORK = 2;
    public static final int LOC_TYPE_NETWORK_DIDI = 3;

    /* renamed from: a */
    private static volatile LocateMode f45670a = LocateMode.HIGH_ACCURATE;
    public static DIDILocationListener mNaviLocListener;
    public static volatile String mNaviModuleKey = null;
    public static volatile LocatePermissonStrategy sPermissionStrategy = LocatePermissonStrategy.LOCATE_IF_APP_PERMISSON_ALLOWED;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didichuxing.bigdata.dp.locsdk.Config$GENERATED_LOC_TYPE */
    public @interface GENERATED_LOC_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didichuxing.bigdata.dp.locsdk.Config$LOC_TYPE */
    public @interface LOC_TYPE {
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.Config$LocateMode */
    public enum LocateMode {
        HIGH_ACCURATE,
        SAVE_GPS_POWER
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.Config$LocatePermissonStrategy */
    public enum LocatePermissonStrategy {
        LOCATE_INGORE_PERMISSION,
        LOCATE_IF_APP_PERMISSON_ALLOWED,
        LOCATE_IF_SYSTEM_PERMISSON_ALLOWED,
        LOCATE_IF_ALL_PERMISSION_ALLOWED
    }

    public static LocateMode getFinalLocateMode() {
        return f45670a;
    }

    public static void setLocateMode(LocateMode locateMode) {
        f45670a = locateMode;
    }

    public static LocateMode getConigLocateMode() {
        return f45670a;
    }
}
