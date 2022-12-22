package com.google.p217ar.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.google.p217ar.core.ArCoreApk;
import com.google.p217ar.core.exceptions.FatalException;
import com.google.p217ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p217ar.core.exceptions.UnavailableUserDeclinedInstallationException;

/* renamed from: com.google.ar.core.h */
/* compiled from: ArCoreApkImpl */
final class C18665h extends ArCoreApk {

    /* renamed from: b */
    private static final C18665h f53531b = new C18665h();

    /* renamed from: a */
    Exception f53532a;

    /* renamed from: c */
    private boolean f53533c;

    /* renamed from: d */
    private int f53534d;

    /* renamed from: e */
    private long f53535e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArCoreApk.Availability f53536f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f53537g;

    /* renamed from: h */
    private C18673p f53538h;

    /* renamed from: i */
    private boolean f53539i;

    /* renamed from: j */
    private boolean f53540j;

    /* renamed from: k */
    private int f53541k;

    C18665h() {
    }

    /* renamed from: a */
    public static C18665h m38292a() {
        return f53531b;
    }

    public final ArCoreApk.Availability checkAvailability(Context context) {
        if (!m38294c()) {
            return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
        }
        try {
            if (mo149635b(context)) {
                mo149634b();
                return C18646aj.m38287a(context);
            }
            synchronized (this) {
                if ((this.f53536f == null || this.f53536f.isUnknown()) && !this.f53537g) {
                    this.f53537g = true;
                    C18646aj ajVar = new C18646aj(this);
                    if (mo149635b(context)) {
                        ajVar.mo149385a(ArCoreApk.Availability.SUPPORTED_INSTALLED);
                    } else if (m38296d(context) != -1) {
                        ajVar.mo149385a(ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD);
                    } else if (m38295c(context)) {
                        ajVar.mo149385a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                    } else {
                        mo149633a(context).mo149643a(context, (ArCoreApk.C18625a) ajVar);
                    }
                }
                if (this.f53536f != null) {
                    ArCoreApk.Availability availability = this.f53536f;
                    return availability;
                } else if (this.f53537g) {
                    ArCoreApk.Availability availability2 = ArCoreApk.Availability.UNKNOWN_CHECKING;
                    return availability2;
                } else {
                    SystemUtils.log(6, "ARCore-ArCoreApk", "request not running but result is null?", (Throwable) null, "com.google.ar.core.h", 32);
                    ArCoreApk.Availability availability3 = ArCoreApk.Availability.UNKNOWN_ERROR;
                    return availability3;
                }
            }
        } catch (FatalException e) {
            SystemUtils.log(6, "ARCore-ArCoreApk", "Error while checking app details and ARCore status", e, "com.google.ar.core.h", 10);
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        }
    }

    public final ArCoreApk.InstallStatus requestInstall(Activity activity, boolean z, ArCoreApk.InstallBehavior installBehavior, ArCoreApk.UserMessageType userMessageType) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        if (!m38294c()) {
            throw new UnavailableDeviceNotCompatibleException();
        } else if (mo149635b(activity)) {
            mo149634b();
            return m38291a(activity);
        } else if (this.f53533c) {
            return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
        } else {
            Exception exc = this.f53532a;
            if (exc != null) {
                if (z) {
                    SystemUtils.log(5, "ARCore-ArCoreApk", "Clearing previous failure: ", exc, "com.google.ar.core.h", 44);
                    this.f53532a = null;
                } else if (exc instanceof UnavailableDeviceNotCompatibleException) {
                    throw ((UnavailableDeviceNotCompatibleException) exc);
                } else if (exc instanceof UnavailableUserDeclinedInstallationException) {
                    throw ((UnavailableUserDeclinedInstallationException) exc);
                } else if (exc instanceof RuntimeException) {
                    throw ((RuntimeException) exc);
                } else {
                    throw new RuntimeException("Unexpected exception type", this.f53532a);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f53535e > 5000) {
                this.f53534d = 0;
            }
            int i = this.f53534d + 1;
            this.f53534d = i;
            this.f53535e = uptimeMillis;
            if (i <= 2) {
                try {
                    activity.startActivity(new Intent(activity, InstallActivity.class).putExtra("message", userMessageType).putExtra("behavior", installBehavior));
                    this.f53533c = true;
                    return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
                } catch (ActivityNotFoundException e) {
                    throw new FatalException("Failed to launch InstallActivity", e);
                }
            } else {
                throw new FatalException("Requesting ARCore installation too rapidly.");
            }
        }
    }

    public final ArCoreApk.InstallStatus requestInstall(Activity activity, boolean z) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        ArCoreApk.UserMessageType userMessageType;
        ArCoreApk.InstallBehavior installBehavior = m38295c(activity) ? ArCoreApk.InstallBehavior.REQUIRED : ArCoreApk.InstallBehavior.OPTIONAL;
        if (m38295c(activity)) {
            userMessageType = ArCoreApk.UserMessageType.APPLICATION;
        } else {
            userMessageType = ArCoreApk.UserMessageType.USER_ALREADY_INFORMED;
        }
        return requestInstall(activity, z, installBehavior, userMessageType);
    }

    /* renamed from: a */
    private static ArCoreApk.InstallStatus m38291a(Activity activity) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        PendingIntent b = C18646aj.m38288b(activity);
        if (b != null) {
            try {
                SystemUtils.log(4, "ARCore-ArCoreApk", "Starting setup activity", (Throwable) null, "com.google.ar.core.h", 77);
                activity.startIntentSender(b.getIntentSender(), (Intent) null, 0, 0, 0);
                return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
            } catch (IntentSender.SendIntentException | RuntimeException e) {
                SystemUtils.log(5, "ARCore-ArCoreApk", "Setup activity launch failed", e, "com.google.ar.core.h", 81);
            }
        }
        return ArCoreApk.InstallStatus.INSTALLED;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized C18673p mo149633a(Context context) {
        if (this.f53538h == null) {
            C18673p pVar = new C18673p((byte) 0);
            pVar.mo149642a(context.getApplicationContext());
            this.f53538h = pVar;
        }
        return this.f53538h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void mo149634b() {
        if (this.f53532a == null) {
            this.f53534d = 0;
        }
        this.f53533c = false;
        if (this.f53538h != null) {
            this.f53538h.mo149640a();
            this.f53538h = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo149635b(Context context) {
        m38297e(context);
        return m38296d(context) == 0 || m38296d(context) >= this.f53541k;
    }

    /* renamed from: c */
    private final boolean m38295c(Context context) {
        m38297e(context);
        return this.f53540j;
    }

    /* renamed from: c */
    private static boolean m38294c() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: d */
    private static int m38296d(Context context) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), "com.google.ar.core", 4);
            int i = packageInfo.versionCode;
            if (i == 0 && (packageInfo.services == null || packageInfo.services.length == 0)) {
                return -1;
            }
            return i;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    /* renamed from: e */
    private final synchronized void m38297e(Context context) {
        if (!this.f53539i) {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            try {
                Bundle bundle = SystemUtils.getApplicationInfo(packageManager, packageName, 128).metaData;
                if (bundle.containsKey("com.google.ar.core")) {
                    this.f53540j = bundle.getString("com.google.ar.core").equals("required");
                    if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                        this.f53541k = bundle.getInt("com.google.ar.core.min_apk_version");
                        ActivityInfo[] activityInfoArr = SystemUtils.getPackageInfo(packageManager, packageName, 1).activities;
                        String canonicalName = InstallActivity.class.getCanonicalName();
                        int length = activityInfoArr.length;
                        boolean z = false;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (canonicalName.equals(activityInfoArr[i].name)) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z) {
                            String valueOf = String.valueOf(canonicalName);
                            throw new FatalException(valueOf.length() != 0 ? "Application manifest must contain activity ".concat(valueOf) : new String("Application manifest must contain activity "));
                        } else {
                            this.f53539i = true;
                        }
                    } else {
                        throw new FatalException("Application manifest must contain meta-data com.google.ar.core.min_apk_version");
                    }
                } else {
                    throw new FatalException("Application manifest must contain meta-data com.google.ar.core");
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new FatalException("Could not load application package metadata", e);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new FatalException("Could not load application package info", e2);
            }
        }
    }
}
