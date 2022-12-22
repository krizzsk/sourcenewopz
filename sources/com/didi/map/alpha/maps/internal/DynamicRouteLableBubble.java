package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.common.MarkerBitmapUtil;

public class DynamicRouteLableBubble implements ILableBubble {

    /* renamed from: a */
    private LableMarkerConfig f24492a;

    /* renamed from: b */
    private MarkerBitmapUtil f24493b;

    /* renamed from: c */
    private final String f24494c = "dynamic/multi_bubble_left_day_2x.9.png";

    /* renamed from: d */
    private final String f24495d = "dynamic/multi_bubble_right_day_2x.9.png";

    /* renamed from: e */
    private final String f24496e = "dynamic/multi_bubble_left_day_3x.9.png";

    /* renamed from: f */
    private final String f24497f = "dynamic/multi_bubble_right_day_3x.9.png";

    /* renamed from: g */
    private final String f24498g = "dynamic/multi_bubble_left_night_2x.9.png";

    /* renamed from: h */
    private final String f24499h = "dynamic/multi_bubble_right_night_2x.9.png";

    /* renamed from: i */
    private final String f24500i = "dynamic/multi_bubble_left_night_3x.9.png";

    /* renamed from: j */
    private final String f24501j = "dynamic/multi_bubble_right_night_3x.9.png";

    /* renamed from: k */
    private final String f24502k = "dynamic/fast_day.9.png";

    /* renamed from: l */
    private final String f24503l = "dynamic/fast_day3.9.png";

    /* renamed from: m */
    private final String f24504m = "dynamic/slow_day.9.png";

    /* renamed from: n */
    private final String f24505n = "dynamic/slow_day3.9.png";

    /* renamed from: o */
    private final String f24506o = "dynamic/fast_night.9.png";

    /* renamed from: p */
    private final String f24507p = "dynamic/fast_night3.9.png";

    /* renamed from: q */
    private final String f24508q = "dynamic/slow_night.9.png";

    /* renamed from: r */
    private final String f24509r = "dynamic/slow_night3.9.png";

    /* renamed from: s */
    private final String f24510s = "dynamic/slow_red_day.9.png";

    /* renamed from: t */
    private final String f24511t = "dynamic/slow_red_day3.9.png";

    public Bitmap getMarkerBitmap(Context context, String str, int i, String str2, String str3, boolean z, int i2) {
        return null;
    }

    private DynamicRouteLableBubble() {
    }

    public DynamicRouteLableBubble(LableMarkerConfig lableMarkerConfig, MarkerBitmapUtil markerBitmapUtil) {
        this.f24492a = lableMarkerConfig;
        this.f24493b = markerBitmapUtil;
    }

    public int getTextColor(boolean z, String str) {
        String str2 = str.split(",")[0];
        if (str2.contains("快")) {
            if (!z) {
                return Color.parseColor("#02974E");
            }
            return Color.parseColor("#AFCFED");
        } else if (str2.contains("慢")) {
            if (!z) {
                return Color.parseColor("#F2514B");
            }
            return Color.parseColor("#87B2E0");
        } else if (!z) {
            return Color.parseColor("#6A7A8A");
        } else {
            return Color.parseColor("#87B2E0");
        }
    }

    public int[] getTextColorForDynamicRouteBubble(boolean z, String str) {
        int[] iArr = new int[2];
        if (str.split(",")[0].contains("快")) {
            if (!z) {
                iArr[0] = Color.parseColor("#009E65");
                iArr[1] = Color.parseColor("#37AD82");
            } else {
                iArr[0] = Color.parseColor("#EBF6FF");
                iArr[1] = Color.parseColor("#C4D3E5");
            }
        } else if (!z) {
            iArr[0] = Color.parseColor("#4B4B4D");
            iArr[1] = Color.parseColor("#787E89");
        } else {
            iArr[0] = Color.parseColor("#A8C4DE");
            iArr[1] = Color.parseColor("#8DA9C7");
        }
        return iArr;
    }

    public String getMarkerFileName(boolean z, String str, int i) {
        String str2 = str.split(",")[0];
        char c = 1;
        if (i == 1) {
            c = 65535;
        }
        return !z ? BitmapUtil.fDensityXH >= 1.0f ? c < 0 ? "dynamic/multi_bubble_left_day_2x.9.png" : "dynamic/multi_bubble_right_day_2x.9.png" : c < 0 ? "dynamic/multi_bubble_left_day_3x.9.png" : "dynamic/multi_bubble_right_day_3x.9.png" : BitmapUtil.fDensityXH >= 1.0f ? c < 0 ? "dynamic/multi_bubble_left_night_2x.9.png" : "dynamic/multi_bubble_right_night_2x.9.png" : c < 0 ? "dynamic/multi_bubble_left_night_3x.9.png" : "dynamic/multi_bubble_right_night_3x.9.png";
    }

    public String getIconFileName(boolean z, String str) {
        String str2 = str.split(",")[0];
        if (!z) {
            return str2.contains("快") ? BitmapUtil.fDensityXH >= 1.0f ? "dynamic/fast_day.9.png" : "dynamic/fast_day3.9.png" : str2.contains("慢") ? BitmapUtil.fDensityXH >= 1.0f ? "dynamic/slow_red_day.9.png" : "dynamic/slow_red_day3.9.png" : BitmapUtil.fDensityXH >= 1.0f ? "dynamic/slow_day.9.png" : "dynamic/slow_day3.9.png";
        }
        if (str2.contains("快")) {
            return BitmapUtil.fDensityXH >= 1.0f ? "dynamic/fast_night.9.png" : "dynamic/fast_night3.9.png";
        }
        if (str2.contains("慢")) {
            if (BitmapUtil.fDensityXH >= 1.0f) {
                return "dynamic/slow_night.9.png";
            }
        } else if (BitmapUtil.fDensityXH >= 1.0f) {
            return "dynamic/slow_night.9.png";
        }
        return "dynamic/slow_night3.9.png";
    }

    public int[] getBitmapWh(Context context, String str, String str2, String str3, String str4, boolean z, int i, boolean z2, boolean z3) {
        int i2;
        int i3;
        if (context == null) {
            return null;
        }
        String[] split = str.split(",");
        boolean z4 = false;
        String str5 = split[0];
        try {
            i3 = split.length > 3 ? Integer.parseInt(split[3]) : 0;
            try {
                if (split.length > 4) {
                    i2 = Integer.parseInt(split[4]);
                    if (i2 == 0 && Math.abs(i3) <= 200 && !z2) {
                        z4 = true;
                    }
                    int[] a = m17506a(context, z4, str2, str3);
                    LableMarkerManager.MultiBubbleParams multiBubbleParams = new LableMarkerManager.MultiBubbleParams();
                    multiBubbleParams.strTime = str5;
                    multiBubbleParams.textColorArray = getTextColorForDynamicRouteBubble(z3, str);
                    multiBubbleParams.fileName = str3;
                    multiBubbleParams.padding = a;
                    multiBubbleParams.isDynamicRoute = true;
                    multiBubbleParams.is2DFullBrowser = z2;
                    multiBubbleParams.isNight = z3;
                    multiBubbleParams.lable = str2;
                    multiBubbleParams.diffDistance = i3;
                    multiBubbleParams.diffTrafficLightCnt = i2;
                    return this.f24493b.getMultiRouteWH(context, multiBubbleParams);
                }
            } catch (Exception e) {
                e = e;
                HWLog.m16761i("MultiRoute", "bubble getBitmap exception:" + e.toString());
                i2 = 0;
                z4 = true;
                int[] a2 = m17506a(context, z4, str2, str3);
                LableMarkerManager.MultiBubbleParams multiBubbleParams2 = new LableMarkerManager.MultiBubbleParams();
                multiBubbleParams2.strTime = str5;
                multiBubbleParams2.textColorArray = getTextColorForDynamicRouteBubble(z3, str);
                multiBubbleParams2.fileName = str3;
                multiBubbleParams2.padding = a2;
                multiBubbleParams2.isDynamicRoute = true;
                multiBubbleParams2.is2DFullBrowser = z2;
                multiBubbleParams2.isNight = z3;
                multiBubbleParams2.lable = str2;
                multiBubbleParams2.diffDistance = i3;
                multiBubbleParams2.diffTrafficLightCnt = i2;
                return this.f24493b.getMultiRouteWH(context, multiBubbleParams2);
            }
        } catch (Exception e2) {
            e = e2;
            i3 = 0;
            HWLog.m16761i("MultiRoute", "bubble getBitmap exception:" + e.toString());
            i2 = 0;
            z4 = true;
            int[] a22 = m17506a(context, z4, str2, str3);
            LableMarkerManager.MultiBubbleParams multiBubbleParams22 = new LableMarkerManager.MultiBubbleParams();
            multiBubbleParams22.strTime = str5;
            multiBubbleParams22.textColorArray = getTextColorForDynamicRouteBubble(z3, str);
            multiBubbleParams22.fileName = str3;
            multiBubbleParams22.padding = a22;
            multiBubbleParams22.isDynamicRoute = true;
            multiBubbleParams22.is2DFullBrowser = z2;
            multiBubbleParams22.isNight = z3;
            multiBubbleParams22.lable = str2;
            multiBubbleParams22.diffDistance = i3;
            multiBubbleParams22.diffTrafficLightCnt = i2;
            return this.f24493b.getMultiRouteWH(context, multiBubbleParams22);
        }
        i2 = 0;
        z4 = true;
        int[] a222 = m17506a(context, z4, str2, str3);
        LableMarkerManager.MultiBubbleParams multiBubbleParams222 = new LableMarkerManager.MultiBubbleParams();
        multiBubbleParams222.strTime = str5;
        multiBubbleParams222.textColorArray = getTextColorForDynamicRouteBubble(z3, str);
        multiBubbleParams222.fileName = str3;
        multiBubbleParams222.padding = a222;
        multiBubbleParams222.isDynamicRoute = true;
        multiBubbleParams222.is2DFullBrowser = z2;
        multiBubbleParams222.isNight = z3;
        multiBubbleParams222.lable = str2;
        multiBubbleParams222.diffDistance = i3;
        multiBubbleParams222.diffTrafficLightCnt = i2;
        return this.f24493b.getMultiRouteWH(context, multiBubbleParams222);
    }

    /* renamed from: a */
    private int[] m17506a(Context context, boolean z, String str, String str2) {
        int[] iArr = new int[4];
        if (z) {
            if (str2.contains("left")) {
                iArr[0] = DisplayUtils.dip2px(context, 20.0f);
                iArr[1] = DisplayUtils.dip2px(context, 10.5f);
                iArr[2] = DisplayUtils.dip2px(context, 12.5f);
                iArr[3] = DisplayUtils.dip2px(context, 21.5f);
            } else {
                iArr[0] = DisplayUtils.dip2px(context, 12.5f);
                iArr[1] = DisplayUtils.dip2px(context, 10.5f);
                iArr[2] = DisplayUtils.dip2px(context, 20.0f);
                iArr[3] = DisplayUtils.dip2px(context, 21.5f);
            }
        } else if (str2.contains("left")) {
            iArr[0] = DisplayUtils.dip2px(context, 19.5f);
            iArr[1] = DisplayUtils.dip2px(context, 10.5f);
            iArr[2] = DisplayUtils.dip2px(context, 12.5f);
            iArr[3] = DisplayUtils.dip2px(context, 21.5f);
        } else {
            iArr[0] = DisplayUtils.dip2px(context, 12.5f);
            iArr[1] = DisplayUtils.dip2px(context, 10.5f);
            iArr[2] = DisplayUtils.dip2px(context, 19.5f);
            iArr[3] = DisplayUtils.dip2px(context, 21.5f);
        }
        return iArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap getMarkerBitmap(android.content.Context r16, java.lang.String r17, int r18, java.lang.String r19, java.lang.String r20, boolean r21, int r22, boolean r23, boolean r24) {
        /*
            r15 = this;
            r1 = r15
            r3 = r16
            r2 = r17
            r7 = r19
            r4 = r23
            r5 = r24
            if (r3 != 0) goto L_0x000f
            r0 = 0
            return r0
        L_0x000f:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r2.split(r0)
            r6 = 0
            r8 = r0[r6]
            int r9 = r0.length
            r10 = 2
            if (r9 <= r10) goto L_0x001f
            r9 = r0[r10]
            goto L_0x0021
        L_0x001f:
            java.lang.String r9 = ""
        L_0x0021:
            r10 = 4
            int r11 = r0.length     // Catch:{ Exception -> 0x003a }
            r12 = 3
            if (r11 <= r12) goto L_0x002d
            r11 = r0[r12]     // Catch:{ Exception -> 0x003a }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x003a }
            goto L_0x002e
        L_0x002d:
            r11 = 0
        L_0x002e:
            int r12 = r0.length     // Catch:{ Exception -> 0x0038 }
            if (r12 <= r10) goto L_0x0056
            r0 = r0[r10]     // Catch:{ Exception -> 0x0038 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0057
        L_0x0038:
            r0 = move-exception
            goto L_0x003c
        L_0x003a:
            r0 = move-exception
            r11 = 0
        L_0x003c:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "bubble getBitmap exception:"
            r12.append(r13)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            java.lang.String r12 = "MultiRoute"
            com.didi.hawaii.log.HWLog.m16761i(r12, r0)
        L_0x0056:
            r0 = 0
        L_0x0057:
            r12 = 1
            if (r0 != 0) goto L_0x0065
            int r13 = java.lang.Math.abs(r11)
            r14 = 200(0xc8, float:2.8E-43)
            if (r13 > r14) goto L_0x0065
            if (r4 != 0) goto L_0x0065
            r6 = 1
        L_0x0065:
            int[] r13 = r15.m17506a(r3, r6, r9, r7)
            if (r21 == 0) goto L_0x0080
            int[] r10 = new int[r10]
            com.didi.map.common.MarkerBitmapUtil r2 = r1.f24493b
            java.lang.String r5 = ""
            r3 = r16
            r4 = r8
            r6 = r18
            r7 = r19
            r8 = r13
            r9 = r20
            android.graphics.Bitmap r0 = r2.getMultiRouteBubbleBitmap_V2(r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x00a3
        L_0x0080:
            com.didi.map.alpha.maps.internal.LableMarkerManager$MultiBubbleParams r6 = new com.didi.map.alpha.maps.internal.LableMarkerManager$MultiBubbleParams
            r6.<init>()
            r6.strTime = r8
            int[] r2 = r15.getTextColorForDynamicRouteBubble(r5, r2)
            r6.textColorArray = r2
            r6.fileName = r7
            r6.padding = r13
            r6.isDynamicRoute = r12
            r6.is2DFullBrowser = r4
            r6.isNight = r5
            r6.lable = r9
            r6.diffDistance = r11
            r6.diffTrafficLightCnt = r0
            com.didi.map.common.MarkerBitmapUtil r0 = r1.f24493b
            android.graphics.Bitmap r0 = r0.getMultiRouteBubbleBitmap(r3, r6)
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.alpha.maps.internal.DynamicRouteLableBubble.getMarkerBitmap(android.content.Context, java.lang.String, int, java.lang.String, java.lang.String, boolean, int, boolean, boolean):android.graphics.Bitmap");
    }
}
