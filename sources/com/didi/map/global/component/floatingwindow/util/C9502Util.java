package com.didi.map.global.component.floatingwindow.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/util/Util;", "", "()V", "TAG", "", "checkDeviceHasNavigationBar", "", "context", "Landroid/content/Context;", "commonROMPermissionCheck", "getNavigationBarHeight", "", "getStatusBarHeight", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.map.global.component.floatingwindow.util.Util */
/* compiled from: Util.kt */
public final class C9502Util {
    public static final C9502Util INSTANCE = new C9502Util();
    public static final String TAG = "MapFloatingWindow";

    private C9502Util() {
    }

    public final boolean commonROMPermissionCheck(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(context)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private final int m18305a(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        SystemUtils.log(3, TAG, Intrinsics.stringPlus("Status height:", Integer.valueOf(dimensionPixelSize)), (Throwable) null, "com.didi.map.global.component.floatingwindow.util.Util", 32);
        return dimensionPixelSize;
    }

    /* renamed from: b */
    private final int m18306b(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        SystemUtils.log(3, TAG, Intrinsics.stringPlus("Navi height:", Integer.valueOf(dimensionPixelSize)), (Throwable) null, "com.didi.map.global.component.floatingwindow.util.Util", 43);
        return dimensionPixelSize;
    }

    public final boolean checkDeviceHasNavigationBar(Context context) {
        if (context == null) {
            return false;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if (invoke != null) {
                String str = (String) invoke;
                if (Intrinsics.areEqual((Object) "1", (Object) str)) {
                    return false;
                }
                if (Intrinsics.areEqual((Object) "0", (Object) str)) {
                    return true;
                }
                return z;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            SystemUtils.log(3, TAG, Intrinsics.stringPlus("checkDeviceHasNavigationBar error: ", e), (Throwable) null, "com.didi.map.global.component.floatingwindow.util.Util", 70);
        }
    }
}
