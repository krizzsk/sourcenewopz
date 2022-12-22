package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.common.MarkerBitmapUtil;

public class MultiRouteLableBubble implements ILableBubble {
    public static final String multi_leftb = "dynamic/multi_bubble_leftb_day_2x.9.png";
    public static final String multi_leftb3x = "dynamic/multi_bubble_leftb_day_3x.9.png";
    public static final String multi_night_leftb = "dynamic/multi_bubble_leftb_night_2x.9.png";
    public static final String multi_night_leftb3x = "dynamic/multi_bubble_leftb_night_3x.9.png";
    public static final String multi_night_rightb = "dynamic/multi_bubble_rightb_night_2x.9.png";
    public static final String multi_night_rightb3x = "dynamic/multi_bubble_rightb_night_3x.9.png";
    public static final String multi_rightb = "dynamic/multi_bubble_rightb_day_2x.9.png";
    public static final String multi_rightb3x = "dynamic/multi_bubble_rightb_day_3x.9.png";

    /* renamed from: a */
    private LableMarkerConfig f24541a;

    /* renamed from: b */
    private MarkerBitmapUtil f24542b;

    /* renamed from: c */
    private final String f24543c = "dynamic/multi_bubble_left_day_2x.9.png";

    /* renamed from: d */
    private final String f24544d = "dynamic/multi_bubble_right_day_2x.9.png";

    /* renamed from: e */
    private final String f24545e = "dynamic/multi_bubble_left_day_3x.9.png";

    /* renamed from: f */
    private final String f24546f = "dynamic/multi_bubble_right_day_3x.9.png";

    /* renamed from: g */
    private final String f24547g = "dynamic/multi_bubble_left_night_2x.9.png";

    /* renamed from: h */
    private final String f24548h = "dynamic/multi_bubble_right_night_2x.9.png";

    /* renamed from: i */
    private final String f24549i = "dynamic/multi_bubble_left_night_3x.9.png";

    /* renamed from: j */
    private final String f24550j = "dynamic/multi_bubble_right_night_3x.9.png";

    /* renamed from: k */
    private final String f24551k = "dynamic/fast_day.9.png";

    /* renamed from: l */
    private final String f24552l = "dynamic/fast_day3.9.png";

    /* renamed from: m */
    private final String f24553m = "dynamic/slow_day.9.png";

    /* renamed from: n */
    private final String f24554n = "dynamic/slow_day3.9.png";

    /* renamed from: o */
    private final String f24555o = "dynamic/fast_night.9.png";

    /* renamed from: p */
    private final String f24556p = "dynamic/fast_night3.9.png";

    /* renamed from: q */
    private final String f24557q = "dynamic/slow_night.9.png";

    /* renamed from: r */
    private final String f24558r = "dynamic/slow_night3.9.png";

    /* renamed from: s */
    private final String f24559s = "dynamic/slow_red_day.9.png";

    /* renamed from: t */
    private final String f24560t = "dynamic/slow_red_day3.9.png";

    public Bitmap getMarkerBitmap(Context context, String str, int i, String str2, String str3, boolean z, int i2) {
        return null;
    }

    private MultiRouteLableBubble() {
    }

    public MultiRouteLableBubble(LableMarkerConfig lableMarkerConfig, MarkerBitmapUtil markerBitmapUtil) {
        this.f24541a = lableMarkerConfig;
        this.f24542b = markerBitmapUtil;
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
                return Color.parseColor("#6A7A8A");
            }
            return Color.parseColor("#87B2E0");
        } else if (!z) {
            return Color.parseColor("#6A7A8A");
        } else {
            return Color.parseColor("#87B2E0");
        }
    }

    public int[] getTextColorForMultiBubble(boolean z, String str) {
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
        if (i == 3 || i == 4) {
            return BitmapUtil.fDensityXH >= 1.0f ? i == 3 ? z ? multi_night_leftb : multi_leftb : z ? multi_night_rightb : multi_rightb : i == 3 ? z ? multi_night_leftb3x : multi_leftb3x : z ? multi_night_rightb3x : multi_rightb3x;
        }
        char c = 1;
        if (i == 1) {
            c = 65535;
        }
        return !z ? BitmapUtil.fDensityXH >= 1.0f ? c < 0 ? "dynamic/multi_bubble_left_day_2x.9.png" : "dynamic/multi_bubble_right_day_2x.9.png" : c < 0 ? "dynamic/multi_bubble_left_day_3x.9.png" : "dynamic/multi_bubble_right_day_3x.9.png" : BitmapUtil.fDensityXH >= 1.0f ? c < 0 ? "dynamic/multi_bubble_left_night_2x.9.png" : "dynamic/multi_bubble_right_night_2x.9.png" : c < 0 ? "dynamic/multi_bubble_left_night_3x.9.png" : "dynamic/multi_bubble_right_night_3x.9.png";
    }

    public String getIconFileName(boolean z, String str) {
        String str2 = str.split(",")[0];
        if (!z) {
            return str2.contains("快") ? BitmapUtil.fDensityXH >= 1.0f ? "dynamic/fast_day.9.png" : "dynamic/fast_day3.9.png" : (!str2.contains("慢") ? BitmapUtil.fDensityXH < 1.0f : BitmapUtil.fDensityXH < 1.0f) ? "dynamic/slow_day3.9.png" : "dynamic/slow_day.9.png";
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

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap getMarkerBitmap(android.content.Context r15, java.lang.String r16, int r17, java.lang.String r18, java.lang.String r19, boolean r20, int r21, boolean r22, boolean r23) {
        /*
            r14 = this;
            r1 = r14
            r3 = r15
            r2 = r16
            r7 = r18
            r4 = r22
            r5 = r23
            if (r3 != 0) goto L_0x000e
            r0 = 0
            return r0
        L_0x000e:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r2.split(r0)
            r6 = 0
            r8 = r0[r6]
            int r9 = r0.length
            r10 = 2
            if (r9 <= r10) goto L_0x001e
            r9 = r0[r10]
            goto L_0x0020
        L_0x001e:
            java.lang.String r9 = ""
        L_0x0020:
            r10 = 4
            int r11 = r0.length     // Catch:{ Exception -> 0x0039 }
            r12 = 3
            if (r11 <= r12) goto L_0x002c
            r11 = r0[r12]     // Catch:{ Exception -> 0x0039 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x0039 }
            goto L_0x002d
        L_0x002c:
            r11 = 0
        L_0x002d:
            int r12 = r0.length     // Catch:{ Exception -> 0x0037 }
            if (r12 <= r10) goto L_0x0055
            r0 = r0[r10]     // Catch:{ Exception -> 0x0037 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0056
        L_0x0037:
            r0 = move-exception
            goto L_0x003b
        L_0x0039:
            r0 = move-exception
            r11 = 0
        L_0x003b:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "bubble getBitmap exception:"
            r12.append(r13)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            java.lang.String r12 = "MultiRoute"
            com.didi.hawaii.log.HWLog.m16761i(r12, r0)
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 != 0) goto L_0x0064
            int r12 = java.lang.Math.abs(r11)
            r13 = 200(0xc8, float:2.8E-43)
            if (r12 > r13) goto L_0x0064
            if (r4 != 0) goto L_0x0064
            r12 = 1
            goto L_0x0065
        L_0x0064:
            r12 = 0
        L_0x0065:
            int[] r12 = r14.m17508a(r15, r12, r9, r7)
            if (r20 == 0) goto L_0x007f
            int[] r10 = new int[r10]
            com.didi.map.common.MarkerBitmapUtil r2 = r1.f24542b
            java.lang.String r5 = ""
            r3 = r15
            r4 = r8
            r6 = r17
            r7 = r18
            r8 = r12
            r9 = r19
            android.graphics.Bitmap r0 = r2.getMultiRouteBubbleBitmap_V2(r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x00a2
        L_0x007f:
            com.didi.map.alpha.maps.internal.LableMarkerManager$MultiBubbleParams r10 = new com.didi.map.alpha.maps.internal.LableMarkerManager$MultiBubbleParams
            r10.<init>()
            r10.strTime = r8
            int[] r2 = r14.getTextColorForMultiBubble(r5, r2)
            r10.textColorArray = r2
            r10.fileName = r7
            r10.padding = r12
            r10.isDynamicRoute = r6
            r10.is2DFullBrowser = r4
            r10.isNight = r5
            r10.lable = r9
            r10.diffDistance = r11
            r10.diffTrafficLightCnt = r0
            com.didi.map.common.MarkerBitmapUtil r0 = r1.f24542b
            android.graphics.Bitmap r0 = r0.getMultiRouteBubbleBitmap(r15, r10)
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.alpha.maps.internal.MultiRouteLableBubble.getMarkerBitmap(android.content.Context, java.lang.String, int, java.lang.String, java.lang.String, boolean, int, boolean, boolean):android.graphics.Bitmap");
    }

    public int[] getBitmapWh(Context context, String str, String str2, String str3, String str4, boolean z, int i, boolean z2, boolean z3) {
        int i2;
        int i3;
        if (context == null) {
            return null;
        }
        String[] split = str.split(",");
        String str5 = split[0];
        try {
            i3 = split.length > 3 ? Integer.parseInt(split[3]) : 0;
            try {
                if (split.length > 4) {
                    i2 = Integer.parseInt(split[4]);
                    int[] a = m17508a(context, i2 != 0 && Math.abs(i3) > 200 && !z2, str2, str3);
                    LableMarkerManager.MultiBubbleParams multiBubbleParams = new LableMarkerManager.MultiBubbleParams();
                    multiBubbleParams.strTime = str5;
                    multiBubbleParams.textColorArray = getTextColorForMultiBubble(z3, str);
                    multiBubbleParams.fileName = str3;
                    multiBubbleParams.padding = a;
                    multiBubbleParams.isDynamicRoute = false;
                    multiBubbleParams.is2DFullBrowser = z2;
                    multiBubbleParams.isNight = z3;
                    multiBubbleParams.lable = str2;
                    multiBubbleParams.diffDistance = i3;
                    multiBubbleParams.diffTrafficLightCnt = i2;
                    return this.f24542b.getMultiRouteWH(context, multiBubbleParams);
                }
            } catch (Exception e) {
                e = e;
                HWLog.m16761i("MultiRoute", "bubble getBitmap exception:" + e.toString());
                i2 = 0;
                int[] a2 = m17508a(context, i2 != 0 && Math.abs(i3) > 200 && !z2, str2, str3);
                LableMarkerManager.MultiBubbleParams multiBubbleParams2 = new LableMarkerManager.MultiBubbleParams();
                multiBubbleParams2.strTime = str5;
                multiBubbleParams2.textColorArray = getTextColorForMultiBubble(z3, str);
                multiBubbleParams2.fileName = str3;
                multiBubbleParams2.padding = a2;
                multiBubbleParams2.isDynamicRoute = false;
                multiBubbleParams2.is2DFullBrowser = z2;
                multiBubbleParams2.isNight = z3;
                multiBubbleParams2.lable = str2;
                multiBubbleParams2.diffDistance = i3;
                multiBubbleParams2.diffTrafficLightCnt = i2;
                return this.f24542b.getMultiRouteWH(context, multiBubbleParams2);
            }
        } catch (Exception e2) {
            e = e2;
            i3 = 0;
            HWLog.m16761i("MultiRoute", "bubble getBitmap exception:" + e.toString());
            i2 = 0;
            int[] a22 = m17508a(context, i2 != 0 && Math.abs(i3) > 200 && !z2, str2, str3);
            LableMarkerManager.MultiBubbleParams multiBubbleParams22 = new LableMarkerManager.MultiBubbleParams();
            multiBubbleParams22.strTime = str5;
            multiBubbleParams22.textColorArray = getTextColorForMultiBubble(z3, str);
            multiBubbleParams22.fileName = str3;
            multiBubbleParams22.padding = a22;
            multiBubbleParams22.isDynamicRoute = false;
            multiBubbleParams22.is2DFullBrowser = z2;
            multiBubbleParams22.isNight = z3;
            multiBubbleParams22.lable = str2;
            multiBubbleParams22.diffDistance = i3;
            multiBubbleParams22.diffTrafficLightCnt = i2;
            return this.f24542b.getMultiRouteWH(context, multiBubbleParams22);
        }
        i2 = 0;
        int[] a222 = m17508a(context, i2 != 0 && Math.abs(i3) > 200 && !z2, str2, str3);
        LableMarkerManager.MultiBubbleParams multiBubbleParams222 = new LableMarkerManager.MultiBubbleParams();
        multiBubbleParams222.strTime = str5;
        multiBubbleParams222.textColorArray = getTextColorForMultiBubble(z3, str);
        multiBubbleParams222.fileName = str3;
        multiBubbleParams222.padding = a222;
        multiBubbleParams222.isDynamicRoute = false;
        multiBubbleParams222.is2DFullBrowser = z2;
        multiBubbleParams222.isNight = z3;
        multiBubbleParams222.lable = str2;
        multiBubbleParams222.diffDistance = i3;
        multiBubbleParams222.diffTrafficLightCnt = i2;
        return this.f24542b.getMultiRouteWH(context, multiBubbleParams222);
    }

    /* renamed from: a */
    private int[] m17508a(Context context, boolean z, String str, String str2) {
        int[] iArr = new int[4];
        if (z) {
            if (str2.contains("leftb")) {
                iArr[0] = DisplayUtils.dip2px(context, 12.5f);
                iArr[1] = DisplayUtils.dip2px(context, 21.5f);
                iArr[2] = DisplayUtils.dip2px(context, 20.0f);
                iArr[3] = DisplayUtils.dip2px(context, 10.5f);
                return iArr;
            } else if (str2.contains("left")) {
                iArr[0] = DisplayUtils.dip2px(context, 20.0f);
                iArr[1] = DisplayUtils.dip2px(context, 10.5f);
                iArr[2] = DisplayUtils.dip2px(context, 12.5f);
                iArr[3] = DisplayUtils.dip2px(context, 21.5f);
            } else if (str2.contains("rightb")) {
                iArr[0] = DisplayUtils.dip2px(context, 20.0f);
                iArr[1] = DisplayUtils.dip2px(context, 21.5f);
                iArr[2] = DisplayUtils.dip2px(context, 12.5f);
                iArr[3] = DisplayUtils.dip2px(context, 10.5f);
                return iArr;
            } else {
                iArr[0] = DisplayUtils.dip2px(context, 12.5f);
                iArr[1] = DisplayUtils.dip2px(context, 10.5f);
                iArr[2] = DisplayUtils.dip2px(context, 20.0f);
                iArr[3] = DisplayUtils.dip2px(context, 21.5f);
            }
        } else if (str2.contains("leftb")) {
            iArr[0] = DisplayUtils.dip2px(context, 12.5f);
            iArr[1] = DisplayUtils.dip2px(context, 21.5f);
            iArr[2] = DisplayUtils.dip2px(context, 19.5f);
            iArr[3] = DisplayUtils.dip2px(context, 10.5f);
            return iArr;
        } else if (str2.contains("left")) {
            iArr[0] = DisplayUtils.dip2px(context, 19.5f);
            iArr[1] = DisplayUtils.dip2px(context, 10.5f);
            iArr[2] = DisplayUtils.dip2px(context, 12.5f);
            iArr[3] = DisplayUtils.dip2px(context, 21.5f);
        } else if (str2.contains("rightb")) {
            iArr[0] = DisplayUtils.dip2px(context, 20.0f);
            iArr[1] = DisplayUtils.dip2px(context, 21.5f);
            iArr[2] = DisplayUtils.dip2px(context, 12.5f);
            iArr[3] = DisplayUtils.dip2px(context, 10.5f);
            return iArr;
        } else {
            iArr[0] = DisplayUtils.dip2px(context, 12.5f);
            iArr[1] = DisplayUtils.dip2px(context, 10.5f);
            iArr[2] = DisplayUtils.dip2px(context, 19.5f);
            iArr[3] = DisplayUtils.dip2px(context, 21.5f);
        }
        return iArr;
    }
}
