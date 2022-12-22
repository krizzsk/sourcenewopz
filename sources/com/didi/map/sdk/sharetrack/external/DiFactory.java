package com.didi.map.sdk.sharetrack.external;

import android.content.Context;
import com.didi.common.map.MapVendor;
import com.didi.map.sdk.sharetrack.logger.DLog;

public class DiFactory {

    /* renamed from: com.didi.map.sdk.sharetrack.external.DiFactory$1 */
    static /* synthetic */ class C101791 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.common.map.MapVendor[] r0 = com.didi.common.map.MapVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$MapVendor = r0
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.DIDI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.sharetrack.external.DiFactory.C101791.<clinit>():void");
        }
    }

    public static INavDelegate createNavigator(Context context, MapVendor mapVendor, boolean z) {
        try {
            int i = C101791.$SwitchMap$com$didi$common$map$MapVendor[mapVendor.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    Object newInstance = Class.forName("com.didi.map.sdk.sharetrack.hawaii.HawaiiNavigatorImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    if (newInstance instanceof INavDelegate) {
                        return (INavDelegate) newInstance;
                    }
                }
            } else if (!z) {
                Object newInstance2 = Class.forName("com.didi.map.sdk.sharetrack.google.GGShareTrackDriverImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                if (newInstance2 instanceof INavDelegate) {
                    return (INavDelegate) newInstance2;
                }
                return null;
            } else {
                Object newInstance3 = Class.forName("com.didi.map.sdk.googlenavadapter.GoogleNavigatorImpl2").getConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance3 instanceof INavDelegate) {
                    return (INavDelegate) newInstance3;
                }
            }
            return null;
        } catch (Exception e) {
            DLog.m20357d("DiDiNavFactory", e.toString(), new Object[0]);
            return null;
        }
    }

    public static IRouteSearcher getRouteSearcher(Context context, MapVendor mapVendor) {
        if (mapVendor == null) {
            return null;
        }
        try {
            if (C101791.$SwitchMap$com$didi$common$map$MapVendor[mapVendor.ordinal()] == 1) {
                Object newInstance = Class.forName("com.didi.map.sdk.sharetrack.google.GGRouteSearcherImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                if (newInstance instanceof IRouteSearcher) {
                    return (IRouteSearcher) newInstance;
                }
            }
            return null;
        } catch (Exception e) {
            DLog.m20357d("DiDiNavFactory", e.toString(), new Object[0]);
            return null;
        }
    }
}
