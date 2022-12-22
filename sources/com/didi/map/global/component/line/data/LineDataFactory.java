package com.didi.map.global.component.line.data;

import android.content.Context;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.component.line.data.route.BubblePageRoute;
import com.didi.map.global.component.line.data.route.MultiLineRoute;
import com.didi.map.global.component.line.data.route.NormalRoute;
import com.didi.map.global.component.line.data.route.OrderTrajRoute;

public class LineDataFactory {

    public enum LineDataType {
        ROUTE_PLAN,
        ROUTE_MULTI_PLAN,
        ROUTE_ORDER,
        ROUTE_TRAJ,
        ROUTE_BUBBLE_PAGE
    }

    /* renamed from: com.didi.map.global.component.line.data.LineDataFactory$1 */
    static /* synthetic */ class C95251 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$line$data$LineDataFactory$LineDataType */
        static final /* synthetic */ int[] f25785x1f22b583;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.global.component.line.data.LineDataFactory$LineDataType[] r0 = com.didi.map.global.component.line.data.LineDataFactory.LineDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25785x1f22b583 = r0
                com.didi.map.global.component.line.data.LineDataFactory$LineDataType r1 = com.didi.map.global.component.line.data.LineDataFactory.LineDataType.ROUTE_PLAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25785x1f22b583     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.line.data.LineDataFactory$LineDataType r1 = com.didi.map.global.component.line.data.LineDataFactory.LineDataType.ROUTE_ORDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25785x1f22b583     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.line.data.LineDataFactory$LineDataType r1 = com.didi.map.global.component.line.data.LineDataFactory.LineDataType.ROUTE_TRAJ     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f25785x1f22b583     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.component.line.data.LineDataFactory$LineDataType r1 = com.didi.map.global.component.line.data.LineDataFactory.LineDataType.ROUTE_MULTI_PLAN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f25785x1f22b583     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.global.component.line.data.LineDataFactory$LineDataType r1 = com.didi.map.global.component.line.data.LineDataFactory.LineDataType.ROUTE_BUBBLE_PAGE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.line.data.LineDataFactory.C95251.<clinit>():void");
        }
    }

    public static BaseLineRoute createLineRoute(Context context, LineDataType lineDataType) {
        BaseLineRoute baseLineRoute = null;
        if (context == null) {
            return null;
        }
        int i = C95251.f25785x1f22b583[lineDataType.ordinal()];
        if (i == 1) {
            baseLineRoute = new NormalRoute();
        } else if (i != 2) {
            if (i == 3) {
                baseLineRoute = new OrderTrajRoute();
            } else if (i == 4) {
                baseLineRoute = new MultiLineRoute();
            } else if (i == 5) {
                baseLineRoute = new BubblePageRoute();
            } else {
                throw new IllegalStateException("Unexpected value: " + lineDataType);
            }
        }
        if (baseLineRoute != null) {
            baseLineRoute.create(context);
        }
        return baseLineRoute;
    }
}
