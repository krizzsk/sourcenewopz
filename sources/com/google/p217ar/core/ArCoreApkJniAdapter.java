package com.google.p217ar.core;

import android.app.Activity;
import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.google.p217ar.core.ArCoreApk;
import com.google.p217ar.core.Session;
import com.google.p217ar.core.exceptions.ResourceExhaustedException;
import com.google.p217ar.core.exceptions.UnavailableApkTooOldException;
import com.google.p217ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.p217ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p217ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.p217ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ar.core.ArCoreApkJniAdapter */
class ArCoreApkJniAdapter {

    /* renamed from: a */
    private static final Map<Class<? extends Throwable>, Integer> f53441a;

    ArCoreApkJniAdapter() {
    }

    static int checkAvailability(Context context) {
        try {
            return ArCoreApk.getInstance().checkAvailability(context).nativeCode;
        } catch (Throwable th) {
            m38251a(th);
            return ArCoreApk.Availability.UNKNOWN_ERROR.nativeCode;
        }
    }

    static int requestInstall(Activity activity, boolean z, int[] iArr) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z).nativeCode;
            return Session.C18632a.SUCCESS.f53480j;
        } catch (Throwable th) {
            return m38251a(th);
        }
    }

    static int requestInstallCustom(Activity activity, boolean z, int i, int i2, int[] iArr) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z, ArCoreApk.InstallBehavior.forNumber(i), ArCoreApk.UserMessageType.forNumber(i2)).nativeCode;
            return Session.C18632a.SUCCESS.f53480j;
        } catch (Throwable th) {
            return m38251a(th);
        }
    }

    /* renamed from: a */
    private static int m38251a(Throwable th) {
        SystemUtils.log(6, "ARCore-ArCoreApkJniAdapter", "Exception details:", th, "com.google.ar.core.ArCoreApkJniAdapter", 20);
        Class<?> cls = th.getClass();
        if (f53441a.containsKey(cls)) {
            return f53441a.get(cls).intValue();
        }
        return Session.C18632a.ERROR_FATAL.f53480j;
    }

    static {
        HashMap hashMap = new HashMap();
        f53441a = hashMap;
        hashMap.put(IllegalArgumentException.class, Integer.valueOf(Session.C18632a.ERROR_INVALID_ARGUMENT.f53480j));
        f53441a.put(ResourceExhaustedException.class, Integer.valueOf(Session.C18632a.ERROR_RESOURCE_EXHAUSTED.f53480j));
        f53441a.put(UnavailableArcoreNotInstalledException.class, Integer.valueOf(Session.C18632a.UNAVAILABLE_ARCORE_NOT_INSTALLED.f53480j));
        f53441a.put(UnavailableDeviceNotCompatibleException.class, Integer.valueOf(Session.C18632a.UNAVAILABLE_DEVICE_NOT_COMPATIBLE.f53480j));
        f53441a.put(UnavailableApkTooOldException.class, Integer.valueOf(Session.C18632a.UNAVAILABLE_APK_TOO_OLD.f53480j));
        f53441a.put(UnavailableSdkTooOldException.class, Integer.valueOf(Session.C18632a.UNAVAILABLE_SDK_TOO_OLD.f53480j));
        f53441a.put(UnavailableUserDeclinedInstallationException.class, Integer.valueOf(Session.C18632a.UNAVAILABLE_USER_DECLINED_INSTALLATION.f53480j));
    }
}
