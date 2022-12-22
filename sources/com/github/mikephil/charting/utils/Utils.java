package com.github.mikephil.charting.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.List;

public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final double DOUBLE_EPSILON = Double.longBitsToDouble(1);
    public static final float FDEG2RAD = 0.017453292f;
    public static final float FLOAT_EPSILON = Float.intBitsToFloat(1);

    /* renamed from: a */
    private static DisplayMetrics f52510a = null;

    /* renamed from: b */
    private static int f52511b = 50;

    /* renamed from: c */
    private static int f52512c = 8000;

    /* renamed from: d */
    private static Rect f52513d = new Rect();

    /* renamed from: e */
    private static Paint.FontMetrics f52514e = new Paint.FontMetrics();

    /* renamed from: f */
    private static Rect f52515f = new Rect();

    /* renamed from: g */
    private static final int[] f52516g = {1, 10, 100, 1000, 10000, 100000, 1000000, HotpatchStateConst.ROLLBACK_PATHCH, 100000000, com.airbnb.lottie.utils.Utils.SECOND_IN_NANOS};

    /* renamed from: h */
    private static ValueFormatter f52517h = m37288a();

    /* renamed from: i */
    private static Rect f52518i = new Rect();

    /* renamed from: j */
    private static Rect f52519j = new Rect();

    /* renamed from: k */
    private static Paint.FontMetrics f52520k = new Paint.FontMetrics();

    public static float getNormalizedAngle(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        return f % 360.0f;
    }

    public static void init(Context context) {
        if (context == null) {
            f52511b = ViewConfiguration.getMinimumFlingVelocity();
            f52512c = ViewConfiguration.getMaximumFlingVelocity();
            SystemUtils.log(6, "MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL", (Throwable) null, "com.github.mikephil.charting.utils.Utils", 62);
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        f52511b = viewConfiguration.getScaledMinimumFlingVelocity();
        f52512c = viewConfiguration.getScaledMaximumFlingVelocity();
        f52510a = context.getResources().getDisplayMetrics();
    }

    @Deprecated
    public static void init(Resources resources) {
        f52510a = resources.getDisplayMetrics();
        f52511b = ViewConfiguration.getMinimumFlingVelocity();
        f52512c = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static float convertDpToPixel(float f) {
        DisplayMetrics displayMetrics = f52510a;
        if (displayMetrics != null) {
            return f * displayMetrics.density;
        }
        SystemUtils.log(6, "MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.", (Throwable) null, "com.github.mikephil.charting.utils.Utils", 105);
        return f;
    }

    public static float convertPixelsToDp(float f) {
        DisplayMetrics displayMetrics = f52510a;
        if (displayMetrics != null) {
            return f / displayMetrics.density;
        }
        SystemUtils.log(6, "MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.", (Throwable) null, "com.github.mikephil.charting.utils.Utils", 126);
        return f;
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = f52513d;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static float getLineHeight(Paint paint) {
        return getLineHeight(paint, f52514e);
    }

    public static float getLineHeight(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint) {
        return getLineSpacing(paint, f52514e);
    }

    public static float getLineSpacing(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static FSize calcTextSize(Paint paint, String str) {
        FSize instance = FSize.getInstance(0.0f, 0.0f);
        calcTextSize(paint, str, instance);
        return instance;
    }

    public static void calcTextSize(Paint paint, String str, FSize fSize) {
        Rect rect = f52515f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.width = (float) rect.width();
        fSize.height = (float) rect.height();
    }

    /* renamed from: a */
    private static ValueFormatter m37288a() {
        return new DefaultValueFormatter(1);
    }

    public static ValueFormatter getDefaultValueFormatter() {
        return f52517h;
    }

    public static String formatNumber(float f, int i, boolean z) {
        return formatNumber(f, i, z, '.');
    }

    public static String formatNumber(float f, int i, boolean z, char c) {
        boolean z2;
        float f2 = f;
        char[] cArr = new char[35];
        if (f2 == 0.0f) {
            return "0";
        }
        int i2 = 0;
        boolean z3 = f2 < 1.0f && f2 > -1.0f;
        if (f2 < 0.0f) {
            f2 = -f2;
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr = f52516g;
        int i3 = i;
        int length = i3 > iArr.length ? iArr.length - 1 : i3;
        long round = (long) Math.round(f2 * ((float) f52516g[length]));
        int i4 = 34;
        long j = round;
        boolean z4 = false;
        while (true) {
            if (j == 0 && i2 >= length + 1) {
                break;
            }
            int i5 = (int) (j % 10);
            j /= 10;
            int i6 = i4 - 1;
            cArr[i4] = (char) (i5 + 48);
            i2++;
            if (i2 == length) {
                i4 = i6 - 1;
                cArr[i6] = ',';
                i2++;
                z4 = true;
            } else {
                if (z && j != 0 && i2 > length) {
                    if (z4) {
                        if ((i2 - length) % 4 == 0) {
                            i4 = i6 - 1;
                            cArr[i6] = c;
                        }
                    } else if ((i2 - length) % 4 == 3) {
                        i4 = i6 - 1;
                        cArr[i6] = c;
                    }
                    i2++;
                }
                i4 = i6;
            }
        }
        if (z3) {
            cArr[i4] = '0';
            i2++;
            i4--;
        }
        if (z2) {
            cArr[i4] = '-';
            i2++;
        }
        int i7 = 35 - i2;
        return String.valueOf(cArr, i7, 35 - i7);
    }

    public static float roundToNextSignificant(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d) || d == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d < 0.0d ? -d : d)))))));
        return ((float) Math.round(d * ((double) pow))) / pow;
    }

    public static int getDecimals(float f) {
        float roundToNextSignificant = roundToNextSignificant((double) f);
        if (Float.isInfinite(roundToNextSignificant)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10((double) roundToNextSignificant))) + 2;
    }

    public static int[] convertIntegers(List<Integer> list) {
        int[] iArr = new int[list.size()];
        copyIntegers(list, iArr);
        return iArr;
    }

    public static void copyIntegers(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i = 0; i < length; i++) {
            iArr[i] = list.get(i).intValue();
        }
    }

    public static String[] convertStrings(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = list.get(i);
        }
        return strArr;
    }

    public static void copyStrings(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i = 0; i < length; i++) {
            strArr[i] = list.get(i);
        }
    }

    public static double nextUp(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        double d2 = d + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d2) + (d2 >= 0.0d ? 1 : -1));
    }

    public static MPPointF getPosition(MPPointF mPPointF, float f, float f2) {
        MPPointF instance = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f, f2, instance);
        return instance;
    }

    public static void getPosition(MPPointF mPPointF, float f, float f2, MPPointF mPPointF2) {
        double d = (double) f;
        double d2 = (double) f2;
        mPPointF2.f52498x = (float) (((double) mPPointF.f52498x) + (Math.cos(Math.toRadians(d2)) * d));
        mPPointF2.f52499y = (float) (((double) mPPointF.f52499y) + (d * Math.sin(Math.toRadians(d2))));
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) f52512c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            if (i != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static void postInvalidateOnAnimation(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10);
        }
    }

    public static int getMinimumFlingVelocity() {
        return f52511b;
    }

    public static int getMaximumFlingVelocity() {
        return f52512c;
    }

    public static void drawImage(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        MPPointF instance = MPPointF.getInstance();
        instance.f52498x = (float) (i - (i3 / 2));
        instance.f52499y = (float) (i2 - (i4 / 2));
        drawable.copyBounds(f52518i);
        drawable.setBounds(f52518i.left, f52518i.top, f52518i.left + i3, f52518i.top + i3);
        int save = canvas.save();
        canvas.translate(instance.f52498x, instance.f52499y);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void drawXAxisValue(Canvas canvas, String str, float f, float f2, Paint paint, MPPointF mPPointF, float f3) {
        float fontMetrics = paint.getFontMetrics(f52520k);
        paint.getTextBounds(str, 0, str.length(), f52519j);
        float f4 = 0.0f - ((float) f52519j.left);
        float f5 = (-f52520k.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f3 != 0.0f) {
            float width = f4 - (((float) f52519j.width()) * 0.5f);
            float f6 = f5 - (fontMetrics * 0.5f);
            if (!(mPPointF.f52498x == 0.5f && mPPointF.f52499y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees((float) f52519j.width(), fontMetrics, f3);
                f -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f52498x - 0.5f);
                f2 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f52499y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f, f2);
            canvas.rotate(f3);
            canvas.drawText(str, width, f6, paint);
            canvas.restore();
        } else {
            if (!(mPPointF.f52498x == 0.0f && mPPointF.f52499y == 0.0f)) {
                f4 -= ((float) f52519j.width()) * mPPointF.f52498x;
                f5 -= fontMetrics * mPPointF.f52499y;
            }
            canvas.drawText(str, f4 + f, f5 + f2, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static void drawMultilineText(Canvas canvas, StaticLayout staticLayout, float f, float f2, TextPaint textPaint, MPPointF mPPointF, float f3) {
        float fontMetrics = textPaint.getFontMetrics(f52520k);
        float width = (float) staticLayout.getWidth();
        float lineCount = ((float) staticLayout.getLineCount()) * fontMetrics;
        float f4 = 0.0f - ((float) f52519j.left);
        float f5 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f3 != 0.0f) {
            float f6 = f4 - (width * 0.5f);
            float f7 = f5 - (lineCount * 0.5f);
            if (!(mPPointF.f52498x == 0.5f && mPPointF.f52499y == 0.5f)) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(width, lineCount, f3);
                f -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f52498x - 0.5f);
                f2 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f52499y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f, f2);
            canvas.rotate(f3);
            canvas.translate(f6, f7);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            if (!(mPPointF.f52498x == 0.0f && mPPointF.f52499y == 0.0f)) {
                f4 -= width * mPPointF.f52498x;
                f5 -= lineCount * mPPointF.f52499y;
            }
            canvas.save();
            canvas.translate(f4 + f, f5 + f2);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static void drawMultilineText(Canvas canvas, String str, float f, float f2, TextPaint textPaint, FSize fSize, MPPointF mPPointF, float f3) {
        TextPaint textPaint2 = textPaint;
        drawMultilineText(canvas, new StaticLayout(str, 0, str.length(), textPaint2, (int) Math.max(Math.ceil((double) fSize.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f, f2, textPaint2, mPPointF, f3);
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize fSize, float f) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize fSize, float f) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f);
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f, float f2, float f3) {
        return getSizeOfRotatedRectangleByRadians(f, f2, f3 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float f, float f2, float f3) {
        double d = (double) f3;
        return FSize.getInstance(Math.abs(((float) Math.cos(d)) * f) + Math.abs(((float) Math.sin(d)) * f2), Math.abs(f * ((float) Math.sin(d))) + Math.abs(f2 * ((float) Math.cos(d))));
    }

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }
}
