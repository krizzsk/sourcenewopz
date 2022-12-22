package com.didi.map.global.flow.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;

public class LaunchExternalMapUtil {

    public enum NavMode {
        DRIVING,
        BICYCLING,
        TWO_WHEELER,
        WALKING
    }

    public static void launchGoogleMapWithWalkNav(Context context, LatLng latLng, NavMode navMode) {
        if (context != null && LatLngUtils.locateCorrect(latLng)) {
            try {
                StringBuilder sb = new StringBuilder("google.navigation:");
                sb.append("q=");
                sb.append(latLng.latitude + "," + latLng.longitude);
                String str = "";
                if (navMode != null) {
                    int i = C97531.f27263xddcef5bb[navMode.ordinal()];
                    str = i != 1 ? i != 2 ? i != 3 ? "w" : "l" : "b" : "d";
                }
                sb.append(ParamKeys.SIGN_AND);
                sb.append("mode=");
                sb.append(str);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
                intent.setPackage("com.google.android.apps.maps");
                intent.setFlags(268435456);
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
                DLog.m7384d("LaunchExternalMapUtil", "Third Google nav Exception ex = " + e.toString(), new Object[0]);
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.utils.LaunchExternalMapUtil$1 */
    static /* synthetic */ class C97531 {

        /* renamed from: $SwitchMap$com$didi$map$global$flow$utils$LaunchExternalMapUtil$NavMode */
        static final /* synthetic */ int[] f27263xddcef5bb;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.map.global.flow.utils.LaunchExternalMapUtil$NavMode[] r0 = com.didi.map.global.flow.utils.LaunchExternalMapUtil.NavMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27263xddcef5bb = r0
                com.didi.map.global.flow.utils.LaunchExternalMapUtil$NavMode r1 = com.didi.map.global.flow.utils.LaunchExternalMapUtil.NavMode.DRIVING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27263xddcef5bb     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.flow.utils.LaunchExternalMapUtil$NavMode r1 = com.didi.map.global.flow.utils.LaunchExternalMapUtil.NavMode.BICYCLING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27263xddcef5bb     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.flow.utils.LaunchExternalMapUtil$NavMode r1 = com.didi.map.global.flow.utils.LaunchExternalMapUtil.NavMode.TWO_WHEELER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27263xddcef5bb     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.flow.utils.LaunchExternalMapUtil$NavMode r1 = com.didi.map.global.flow.utils.LaunchExternalMapUtil.NavMode.WALKING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.utils.LaunchExternalMapUtil.C97531.<clinit>():void");
        }
    }

    public static boolean isInstallGoogleMap(Context context) {
        Intent intent = new Intent();
        intent.setPackage("com.google.android.apps.maps");
        return intent.resolveActivity(context.getPackageManager()) != null;
    }
}
