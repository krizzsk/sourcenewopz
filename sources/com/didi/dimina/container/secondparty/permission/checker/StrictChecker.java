package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import android.os.Build;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;

public final class StrictChecker implements PermissionChecker {
    public boolean hasPermission(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : strArr) {
            if (!m12889a(context, a)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasPermission(Context context, List<String> list) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : list) {
            if (!m12889a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m12889a(Context context, String str) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals(Permission.ACCESS_FINE_LOCATION)) {
                        c = 3;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals(Permission.ACCESS_COARSE_LOCATION)) {
                        c = 2;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals(Permission.CAMERA)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals(Permission.RECORD_AUDIO)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1977429404:
                    if (str.equals(Permission.READ_CONTACTS)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 1) {
                return m12892d(context);
            }
            if (c == 2) {
                return m12888a(context);
            }
            if (c == 3) {
                return m12890b(context);
            }
            if (c != 4) {
                return true;
            }
            return m12891c(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m12888a(Context context) throws Throwable {
        return new C7589b(context).mo55894a();
    }

    /* renamed from: b */
    private static boolean m12890b(Context context) throws Throwable {
        return new C7590c(context).mo55894a();
    }

    /* renamed from: c */
    private static boolean m12891c(Context context) throws Throwable {
        return new C7591d(context).mo55894a();
    }

    /* renamed from: d */
    private static boolean m12892d(Context context) throws Throwable {
        return new C7588a(context).mo55894a();
    }
}
