package com.didi.dimina.container.bridge.blankscreen;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J&\u0010\n\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J0\u0010\u0013\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J0\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0003\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/blankscreen/CheckViewColorTool;", "", "()V", "DEBUG_SAVE_BITMAP", "", "DEFAULT_COLOR_RATE", "", "DEFAULT_IS_SAME_COLOR", "TAG", "", "colorRate", "bitmap", "Landroid/graphics/Bitmap;", "vCount", "", "hCount", "view", "Landroid/view/View;", "getBitmapFromView", "isSameColor", "rate", "", "saveBitmap", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CheckViewColorTool.kt */
public final class CheckViewColorTool {
    public static final float DEFAULT_COLOR_RATE = 0.0f;
    public static final CheckViewColorTool INSTANCE = new CheckViewColorTool();

    /* renamed from: a */
    private static final String f16693a = "CheckBlankTool";

    /* renamed from: b */
    private static final boolean f16694b = false;

    /* renamed from: c */
    private static final boolean f16695c = false;

    @JvmStatic
    /* renamed from: a */
    private static final void m12318a(Bitmap bitmap) {
    }

    @JvmStatic
    public static final float colorRate(Bitmap bitmap) {
        return colorRate$default(bitmap, 0, 0, 6, (Object) null);
    }

    @JvmStatic
    public static final float colorRate(Bitmap bitmap, int i) {
        return colorRate$default(bitmap, i, 0, 4, (Object) null);
    }

    @JvmStatic
    public static final float colorRate(View view) {
        return colorRate$default(view, 0, 0, 6, (Object) null);
    }

    @JvmStatic
    public static final float colorRate(View view, int i) {
        return colorRate$default(view, i, 0, 4, (Object) null);
    }

    @JvmStatic
    public static final boolean isSameColor(Bitmap bitmap) {
        return isSameColor$default(bitmap, 0.0d, 0, 0, 14, (Object) null);
    }

    @JvmStatic
    public static final boolean isSameColor(Bitmap bitmap, double d) {
        return isSameColor$default(bitmap, d, 0, 0, 12, (Object) null);
    }

    @JvmStatic
    public static final boolean isSameColor(Bitmap bitmap, double d, int i) {
        return isSameColor$default(bitmap, d, i, 0, 8, (Object) null);
    }

    @JvmStatic
    public static final boolean isSameColor(View view) {
        return isSameColor$default(view, 0.0d, 0, 0, 14, (Object) null);
    }

    @JvmStatic
    public static final boolean isSameColor(View view, double d) {
        return isSameColor$default(view, d, 0, 0, 12, (Object) null);
    }

    @JvmStatic
    public static final boolean isSameColor(View view, double d, int i) {
        return isSameColor$default(view, d, i, 0, 8, (Object) null);
    }

    private CheckViewColorTool() {
    }

    public static /* synthetic */ boolean isSameColor$default(View view, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            d = 1.0d;
        }
        if ((i3 & 4) != 0) {
            i = view != null ? view.getHeight() : 0;
        }
        if ((i3 & 8) != 0) {
            i2 = view != null ? view.getWidth() : 0;
        }
        return isSameColor(view, d, i, i2);
    }

    @JvmStatic
    public static final boolean isSameColor(View view, double d, int i, int i2) {
        return isSameColor(view != null ? m12317a(view) : null, d, i, i2);
    }

    public static /* synthetic */ boolean isSameColor$default(Bitmap bitmap, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            d = 1.0d;
        }
        if ((i3 & 4) != 0) {
            i = bitmap != null ? bitmap.getHeight() : 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bitmap != null ? bitmap.getWidth() : 0;
        }
        return isSameColor(bitmap, d, i, i2);
    }

    @JvmStatic
    public static final boolean isSameColor(Bitmap bitmap, double d, int i, int i2) {
        if (bitmap != null) {
            try {
                m12318a(bitmap);
                if (((double) colorRate(bitmap, i, i2)) >= d) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                LogUtil.eRelease(f16693a, "exception||" + Log.getStackTraceString(e));
            }
        }
        return false;
    }

    public static /* synthetic */ float colorRate$default(View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = view != null ? view.getHeight() : 0;
        }
        if ((i3 & 4) != 0) {
            i2 = view != null ? view.getWidth() : 0;
        }
        return colorRate(view, i, i2);
    }

    @JvmStatic
    public static final float colorRate(View view, int i, int i2) {
        return colorRate(view != null ? m12317a(view) : null, i, i2);
    }

    public static /* synthetic */ float colorRate$default(Bitmap bitmap, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = bitmap != null ? bitmap.getHeight() : 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bitmap != null ? bitmap.getWidth() : 0;
        }
        return colorRate(bitmap, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c2, code lost:
        if (r13 >= r14) goto L_0x00c4;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float colorRate(android.graphics.Bitmap r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "CheckBlankTool"
            if (r0 == 0) goto L_0x01ab
            int r5 = r16.getWidth()     // Catch:{ Exception -> 0x018e }
            int r6 = r16.getHeight()     // Catch:{ Exception -> 0x018e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
            r7.<init>()     // Catch:{ Exception -> 0x018e }
            java.lang.String r8 = "bitmap width:"
            r7.append(r8)     // Catch:{ Exception -> 0x018e }
            r7.append(r5)     // Catch:{ Exception -> 0x018e }
            java.lang.String r8 = " height:"
            r7.append(r8)     // Catch:{ Exception -> 0x018e }
            r7.append(r6)     // Catch:{ Exception -> 0x018e }
            java.lang.String r8 = " vCount:"
            r7.append(r8)     // Catch:{ Exception -> 0x018e }
            r7.append(r1)     // Catch:{ Exception -> 0x018e }
            java.lang.String r8 = ", hCount:"
            r7.append(r8)     // Catch:{ Exception -> 0x018e }
            r7.append(r2)     // Catch:{ Exception -> 0x018e }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x018e }
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r7)     // Catch:{ Exception -> 0x018e }
            if (r5 <= 0) goto L_0x018c
            if (r6 <= 0) goto L_0x018c
            if (r1 == 0) goto L_0x018c
            if (r2 != 0) goto L_0x0048
            goto L_0x018c
        L_0x0048:
            int r7 = kotlin.ranges.RangesKt.coerceAtMost((int) r1, (int) r6)     // Catch:{ Exception -> 0x018e }
            int r7 = r6 / r7
            int r8 = kotlin.ranges.RangesKt.coerceAtMost((int) r2, (int) r5)     // Catch:{ Exception -> 0x018e }
            int r8 = r5 / r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
            r9.<init>()     // Catch:{ Exception -> 0x018e }
            java.lang.String r10 = "bitmap vStep:"
            r9.append(r10)     // Catch:{ Exception -> 0x018e }
            r9.append(r7)     // Catch:{ Exception -> 0x018e }
            java.lang.String r10 = " hStep:"
            r9.append(r10)     // Catch:{ Exception -> 0x018e }
            r9.append(r8)     // Catch:{ Exception -> 0x018e }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x018e }
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r9)     // Catch:{ Exception -> 0x018e }
            int r1 = r1 * r2
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x018e }
            r2.<init>()     // Catch:{ Exception -> 0x018e }
            r9 = 0
            kotlin.ranges.IntRange r5 = kotlin.ranges.RangesKt.until((int) r9, (int) r5)     // Catch:{ Exception -> 0x018e }
            kotlin.ranges.IntProgression r5 = (kotlin.ranges.IntProgression) r5     // Catch:{ Exception -> 0x018e }
            kotlin.ranges.IntProgression r5 = kotlin.ranges.RangesKt.step((kotlin.ranges.IntProgression) r5, (int) r8)     // Catch:{ Exception -> 0x018e }
            int r8 = r5.getFirst()     // Catch:{ Exception -> 0x018e }
            int r10 = r5.getLast()     // Catch:{ Exception -> 0x018e }
            int r5 = r5.getStep()     // Catch:{ Exception -> 0x018e }
            java.lang.String r11 = "colorMap.values"
            if (r5 < 0) goto L_0x0095
            if (r8 > r10) goto L_0x010c
            goto L_0x0097
        L_0x0095:
            if (r8 < r10) goto L_0x010c
        L_0x0097:
            java.util.Collection r12 = r2.values()     // Catch:{ Exception -> 0x018e }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r11)     // Catch:{ Exception -> 0x018e }
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch:{ Exception -> 0x018e }
            int r12 = kotlin.collections.CollectionsKt.sumOfInt(r12)     // Catch:{ Exception -> 0x018e }
            if (r12 < r1) goto L_0x00a7
            goto L_0x010c
        L_0x00a7:
            kotlin.ranges.IntRange r12 = kotlin.ranges.RangesKt.until((int) r9, (int) r6)     // Catch:{ Exception -> 0x018e }
            kotlin.ranges.IntProgression r12 = (kotlin.ranges.IntProgression) r12     // Catch:{ Exception -> 0x018e }
            kotlin.ranges.IntProgression r12 = kotlin.ranges.RangesKt.step((kotlin.ranges.IntProgression) r12, (int) r7)     // Catch:{ Exception -> 0x018e }
            int r13 = r12.getFirst()     // Catch:{ Exception -> 0x018e }
            int r14 = r12.getLast()     // Catch:{ Exception -> 0x018e }
            int r12 = r12.getStep()     // Catch:{ Exception -> 0x018e }
            if (r12 < 0) goto L_0x00c2
            if (r13 > r14) goto L_0x0107
            goto L_0x00c4
        L_0x00c2:
            if (r13 < r14) goto L_0x0107
        L_0x00c4:
            java.util.Collection r15 = r2.values()     // Catch:{ Exception -> 0x018e }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r11)     // Catch:{ Exception -> 0x018e }
            java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ Exception -> 0x018e }
            int r15 = kotlin.collections.CollectionsKt.sumOfInt(r15)     // Catch:{ Exception -> 0x018e }
            if (r15 < r1) goto L_0x00d4
            goto L_0x0107
        L_0x00d4:
            int r15 = r0.getPixel(r8, r13)     // Catch:{ Exception -> 0x018e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x018e }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x018e }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x018e }
            if (r4 == 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x018e }
        L_0x00e9:
            java.lang.String r9 = "colorMap[currentPixelList] ?: 0"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r9)     // Catch:{ Exception -> 0x018e }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x018e }
            r9 = r2
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ Exception -> 0x018e }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x018e }
            int r4 = r4 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x018e }
            r9.put(r15, r4)     // Catch:{ Exception -> 0x018e }
            if (r13 == r14) goto L_0x0107
            int r13 = r13 + r12
            r9 = 0
            goto L_0x00c4
        L_0x0107:
            if (r8 == r10) goto L_0x010c
            int r8 = r8 + r5
            r9 = 0
            goto L_0x0097
        L_0x010c:
            r16.recycle()     // Catch:{ Exception -> 0x018e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
            r0.<init>()     // Catch:{ Exception -> 0x018e }
            java.lang.String r1 = "colorMapSum||"
            r0.append(r1)     // Catch:{ Exception -> 0x018e }
            java.util.Collection r1 = r2.values()     // Catch:{ Exception -> 0x018e }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r11)     // Catch:{ Exception -> 0x018e }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x018e }
            int r1 = kotlin.collections.CollectionsKt.sumOfInt(r1)     // Catch:{ Exception -> 0x018e }
            r0.append(r1)     // Catch:{ Exception -> 0x018e }
            java.lang.String r1 = " colorMap"
            r0.append(r1)     // Catch:{ Exception -> 0x018e }
            r0.append(r2)     // Catch:{ Exception -> 0x018e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x018e }
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r0)     // Catch:{ Exception -> 0x018e }
            java.util.Collection r0 = r2.values()     // Catch:{ Exception -> 0x018e }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r11)     // Catch:{ Exception -> 0x018e }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x018e }
            java.util.List r0 = kotlin.collections.CollectionsKt.sortedDescending(r0)     // Catch:{ Exception -> 0x018e }
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ Exception -> 0x018e }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x018e }
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x018a
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x018e }
            java.lang.String r1 = "sortedDescending[0]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)     // Catch:{ Exception -> 0x018e }
            java.lang.Number r0 = (java.lang.Number) r0     // Catch:{ Exception -> 0x018e }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x018e }
            java.util.Collection r1 = r2.values()     // Catch:{ Exception -> 0x018e }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r11)     // Catch:{ Exception -> 0x018e }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x018e }
            int r1 = kotlin.collections.CollectionsKt.sumOfInt(r1)     // Catch:{ Exception -> 0x018e }
            float r0 = (float) r0     // Catch:{ Exception -> 0x018e }
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r2
            float r1 = (float) r1     // Catch:{ Exception -> 0x018e }
            float r0 = r0 / r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018e }
            r1.<init>()     // Catch:{ Exception -> 0x018e }
            java.lang.String r2 = "countRate:"
            r1.append(r2)     // Catch:{ Exception -> 0x018e }
            r1.append(r0)     // Catch:{ Exception -> 0x018e }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x018e }
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r1)     // Catch:{ Exception -> 0x018e }
            r4 = r0
            goto L_0x018b
        L_0x018a:
            r4 = 0
        L_0x018b:
            return r4
        L_0x018c:
            r1 = 0
            return r1
        L_0x018e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "exception||"
            r1.append(r2)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.didi.dimina.container.util.LogUtil.eRelease(r3, r0)
            r1 = 0
            return r1
        L_0x01ab:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.blankscreen.CheckViewColorTool.colorRate(android.graphics.Bitmap, int, int):float");
    }

    @JvmStatic
    /* renamed from: a */
    private static final Bitmap m12317a(View view) {
        try {
            if (view.getWidth() > 0) {
                if (view.getHeight() > 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                    if (createBitmap == null) {
                        createBitmap = null;
                    }
                    Canvas canvas = createBitmap != null ? new Canvas(createBitmap) : null;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
                    int x = (int) view.getX();
                    int y = (int) view.getY();
                    view.layout(x, y, view.getMeasuredWidth() + x, view.getMeasuredHeight() + y);
                    view.draw(canvas);
                    return createBitmap;
                }
            }
            LogUtil.iRelease(f16693a, "view  width <= 0 || height <= 0");
            return null;
        } catch (Exception e) {
            LogUtil.eRelease(f16693a, "getBitmapFromView exception||" + Log.getStackTraceString(e));
            TraceUtil.techSagaScreenBlankMonitorException();
            return null;
        }
    }
}
