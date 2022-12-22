package com.didi.map.global.flow.scene.order.bluetooth_meet.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0012\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0006\u0010.\u001a\u00020&J\b\u0010/\u001a\u00020&H\u0002J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0007H\u0016J\u0006\u00102\u001a\u00020&R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMTripleRippleView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CIRCLE_COLOR_FROM", "CIRCLE_TRANSPARENT_END", "", "CIRCLE_TRANSPARENT_FROM", "CIRCLE_TRANSPARENT_MIDDLE_1", "CIRCLE_TRANSPARENT_MIDDLE_2", "RADIUS_1_FROM", "RADIUS_1_TO", "RADIUS_2_FROM", "RADIUS_2_TO", "RADIUS_3_FROM", "RADIUS_3_TO", "STROKE_COLOR_FROM", "STROKE_TRANSPARENT_END", "STROKE_TRANSPARENT_FROM", "STROKE_TRANSPARENT_MIDDLE_1", "STROKE_TRANSPARENT_MIDDLE_2", "STROKE_WIDTH", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "curValue", "fillColorList", "", "paint", "Landroid/graphics/Paint;", "radiusList", "strokeColorList", "cancel", "", "dp2px", "dp", "handleAnimationFraction", "value", "onDraw", "canvas", "Landroid/graphics/Canvas;", "reset", "resetData", "setVisibility", "visibility", "start", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMTripleRippleView.kt */
public final class BTMTripleRippleView extends View {

    /* renamed from: a */
    private final float f26548a;

    /* renamed from: b */
    private final int f26549b;

    /* renamed from: c */
    private final float f26550c;

    /* renamed from: d */
    private final float f26551d;

    /* renamed from: e */
    private final float f26552e;

    /* renamed from: f */
    private final float f26553f;

    /* renamed from: g */
    private final int f26554g;

    /* renamed from: h */
    private final float f26555h;

    /* renamed from: i */
    private final float f26556i;

    /* renamed from: j */
    private final float f26557j;

    /* renamed from: k */
    private final float f26558k;

    /* renamed from: l */
    private final float f26559l;

    /* renamed from: m */
    private final float f26560m;

    /* renamed from: n */
    private final float f26561n;

    /* renamed from: o */
    private final float f26562o;

    /* renamed from: p */
    private final float f26563p;

    /* renamed from: q */
    private final float f26564q;

    /* renamed from: r */
    private final List<Float> f26565r;

    /* renamed from: s */
    private final List<Integer> f26566s;

    /* renamed from: t */
    private final List<Integer> f26567t;

    /* renamed from: u */
    private float f26568u;

    /* renamed from: v */
    private final Paint f26569v;

    /* renamed from: w */
    private final ValueAnimator f26570w;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMTripleRippleView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMTripleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BTMTripleRippleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BTMTripleRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f26548a = m18823b(1.0f);
        this.f26549b = Color.parseColor("#26FFFFFF");
        this.f26550c = 15.0f;
        this.f26551d = 6.0f;
        this.f26553f = 15.0f;
        this.f26554g = Color.parseColor("#7FFFFFFF");
        this.f26555h = 50.0f;
        this.f26556i = 20.0f;
        this.f26558k = 50.0f;
        float f = (float) 2;
        this.f26559l = m18823b(202.0f) / f;
        this.f26560m = m18823b(222.0f) / f;
        this.f26561n = m18823b(340.0f) / f;
        this.f26562o = m18823b(360.0f) / f;
        this.f26563p = m18823b(562.0f) / f;
        this.f26564q = m18823b(582.0f) / f;
        this.f26565r = new ArrayList();
        this.f26566s = new ArrayList();
        this.f26567t = new ArrayList();
        this.f26569v = new Paint();
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 2.8f}).setDuration(2800);
        duration.setRepeatMode(1);
        duration.setRepeatCount(-1);
        duration.setInterpolator(new LinearInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BTMTripleRippleView.m18822a(BTMTripleRippleView.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(duration, "");
        duration.addListener(new C9665x390a9d53(this));
        Unit unit = Unit.INSTANCE;
        this.f26570w = duration;
        m18820a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18822a(BTMTripleRippleView bTMTripleRippleView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(bTMTripleRippleView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            bTMTripleRippleView.m18821a(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18820a() {
        this.f26565r.clear();
        this.f26565r.add(Float.valueOf(this.f26559l));
        this.f26565r.add(Float.valueOf(this.f26561n));
        this.f26565r.add(Float.valueOf(this.f26563p));
        this.f26566s.clear();
        this.f26566s.add(Integer.valueOf(this.f26549b));
        this.f26566s.add(Integer.valueOf(this.f26549b));
        this.f26566s.add(Integer.valueOf(this.f26549b));
        this.f26567t.clear();
        this.f26567t.add(Integer.valueOf(this.f26554g));
        this.f26567t.add(Integer.valueOf(this.f26554g));
        this.f26567t.add(Integer.valueOf(this.f26554g));
    }

    /* renamed from: a */
    private final void m18821a(float f) {
        float f2 = f;
        this.f26568u = f2;
        int min = Math.min(getWidth(), getHeight()) / 2;
        if (0.0f <= f2 && f2 <= 1.0f) {
            List<Float> list = this.f26565r;
            float f3 = this.f26559l;
            list.set(0, Float.valueOf(f3 + ((this.f26560m - f3) * f2)));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            float f4 = this.f26550c;
            String format = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f4 + ((this.f26551d - f4) * f2))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            this.f26566s.set(0, Integer.valueOf(Color.parseColor(format)));
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            float f5 = this.f26555h;
            String format2 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f5 + ((this.f26556i - f5) * f2))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            this.f26567t.set(0, Integer.valueOf(Color.parseColor(format2)));
        }
        if (0.3f <= f2 && f2 <= 1.3f) {
            float f6 = f2 - 0.3f;
            List<Float> list2 = this.f26565r;
            float f7 = this.f26561n;
            list2.set(1, Float.valueOf(f7 + ((this.f26562o - f7) * f6)));
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            float f8 = this.f26550c;
            String format3 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f8 + ((this.f26551d - f8) * f6))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
            this.f26566s.set(1, Integer.valueOf(Color.parseColor(format3)));
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            float f9 = this.f26555h;
            String format4 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f9 + ((this.f26556i - f9) * f6))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
            this.f26567t.set(1, Integer.valueOf(Color.parseColor(format4)));
        }
        if (0.6f <= f2 && f2 <= 1.6f) {
            float f10 = f2 - 0.6f;
            List<Float> list3 = this.f26565r;
            float f11 = this.f26563p;
            list3.set(2, Float.valueOf(f11 + ((((float) min) - f11) * f10)));
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            float f12 = this.f26550c;
            String format5 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f12 + ((this.f26551d - f12) * f10))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "java.lang.String.format(format, *args)");
            this.f26566s.set(2, Integer.valueOf(Color.parseColor(format5)));
            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
            float f13 = this.f26555h;
            String format6 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f13 + ((this.f26556i - f13) * f10))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format6, "java.lang.String.format(format, *args)");
            this.f26567t.set(2, Integer.valueOf(Color.parseColor(format6)));
        }
        if (1.0f <= f2 && f2 <= 1.2f) {
            StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
            float f14 = this.f26551d;
            float f15 = f2 - 1.0f;
            String format7 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (((double) f14) + (((double) ((this.f26552e - f14) * f15)) / 0.2d))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format7, "java.lang.String.format(format, *args)");
            this.f26566s.set(0, Integer.valueOf(Color.parseColor(format7)));
            StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
            float f16 = this.f26556i;
            String format8 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (((double) f16) + (((double) ((this.f26557j - f16) * f15)) / 0.2d))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format8, "java.lang.String.format(format, *args)");
            this.f26567t.set(0, Integer.valueOf(Color.parseColor(format8)));
        }
        if (f2 > 1.2f && f2 <= 2.2f) {
            StringCompanionObject stringCompanionObject9 = StringCompanionObject.INSTANCE;
            float f17 = this.f26552e;
            float f18 = f2 - 1.2f;
            String format9 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f17 + ((this.f26553f - f17) * f18))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format9, "java.lang.String.format(format, *args)");
            this.f26566s.set(0, Integer.valueOf(Color.parseColor(format9)));
            StringCompanionObject stringCompanionObject10 = StringCompanionObject.INSTANCE;
            float f19 = this.f26557j;
            String format10 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f19 + ((this.f26558k - f19) * f18))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format10, "java.lang.String.format(format, *args)");
            this.f26567t.set(0, Integer.valueOf(Color.parseColor(format10)));
            this.f26565r.set(0, Float.valueOf(this.f26559l));
        }
        if (1.3f <= f2 && f2 <= 1.5f) {
            StringCompanionObject stringCompanionObject11 = StringCompanionObject.INSTANCE;
            float f20 = this.f26551d;
            double d = (double) f20;
            float f21 = this.f26552e - f20;
            float f22 = f2 - 1.3f;
            String format11 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (d + (((double) (f21 * f22)) / 0.2d))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format11, "java.lang.String.format(format, *args)");
            this.f26566s.set(1, Integer.valueOf(Color.parseColor(format11)));
            StringCompanionObject stringCompanionObject12 = StringCompanionObject.INSTANCE;
            float f23 = this.f26556i;
            String format12 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (((double) f23) + (((double) ((this.f26557j - f23) * f22)) / 0.2d))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format12, "java.lang.String.format(format, *args)");
            this.f26567t.set(1, Integer.valueOf(Color.parseColor(format12)));
        }
        if (f2 > 1.5f && f2 <= 2.5f) {
            StringCompanionObject stringCompanionObject13 = StringCompanionObject.INSTANCE;
            float f24 = this.f26552e;
            float f25 = f2 - 1.5f;
            String format13 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f24 + ((this.f26553f - f24) * f25))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format13, "java.lang.String.format(format, *args)");
            this.f26566s.set(1, Integer.valueOf(Color.parseColor(format13)));
            StringCompanionObject stringCompanionObject14 = StringCompanionObject.INSTANCE;
            float f26 = this.f26557j;
            String format14 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f26 + ((this.f26558k - f26) * f25))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format14, "java.lang.String.format(format, *args)");
            this.f26567t.set(1, Integer.valueOf(Color.parseColor(format14)));
            this.f26565r.set(1, Float.valueOf(this.f26561n));
        }
        if (1.6f <= f2 && f2 <= 1.8f) {
            StringCompanionObject stringCompanionObject15 = StringCompanionObject.INSTANCE;
            float f27 = this.f26551d;
            double d2 = (double) f27;
            float f28 = this.f26552e - f27;
            float f29 = f2 - 1.6f;
            String format15 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (d2 + (((double) (f28 * f29)) / 0.2d))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format15, "java.lang.String.format(format, *args)");
            this.f26566s.set(2, Integer.valueOf(Color.parseColor(format15)));
            StringCompanionObject stringCompanionObject16 = StringCompanionObject.INSTANCE;
            float f30 = this.f26556i;
            String format16 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (((double) f30) + (((double) ((this.f26557j - f30) * f29)) / 0.2d))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format16, "java.lang.String.format(format, *args)");
            this.f26567t.set(2, Integer.valueOf(Color.parseColor(format16)));
        }
        if (f2 > 1.8f && f2 <= 2.8f) {
            StringCompanionObject stringCompanionObject17 = StringCompanionObject.INSTANCE;
            float f31 = this.f26552e;
            float f32 = f2 - 1.8f;
            String format17 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f31 + ((this.f26553f - f31) * f32))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format17, "java.lang.String.format(format, *args)");
            this.f26566s.set(2, Integer.valueOf(Color.parseColor(format17)));
            StringCompanionObject stringCompanionObject18 = StringCompanionObject.INSTANCE;
            float f33 = this.f26557j;
            String format18 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((((int) (f33 + ((this.f26558k - f33) * f32))) * 255) / 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(format18, "java.lang.String.format(format, *args)");
            this.f26567t.set(2, Integer.valueOf(Color.parseColor(format18)));
            this.f26565r.set(2, Float.valueOf(this.f26563p));
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            float floatValue = this.f26565r.get(i).floatValue();
            int intValue = this.f26566s.get(i).intValue();
            int intValue2 = this.f26567t.get(i).intValue();
            if (floatValue > 0.0f) {
                this.f26569v.setStyle(Paint.Style.FILL);
                this.f26569v.setColor(intValue);
                if (canvas != null) {
                    float f = (float) 2;
                    canvas.drawCircle(((float) getWidth()) / f, ((float) getHeight()) / f, floatValue - this.f26548a, this.f26569v);
                }
                this.f26569v.setColor(intValue2);
                this.f26569v.setStyle(Paint.Style.STROKE);
                if (canvas != null) {
                    float f2 = (float) 2;
                    canvas.drawCircle(((float) getWidth()) / f2, ((float) getHeight()) / f2, floatValue - (this.f26548a / f2), this.f26569v);
                }
            }
            if (i2 <= 2) {
                i = i2;
            } else {
                return;
            }
        }
    }

    public final void start() {
        if (!this.f26570w.isRunning()) {
            this.f26570w.start();
        }
    }

    public final void cancel() {
        if (this.f26570w.isRunning()) {
            this.f26570w.cancel();
        }
    }

    public final void reset() {
        cancel();
        m18820a();
        invalidate();
    }

    public void setVisibility(int i) {
        if (i == 8 || i == 4) {
            reset();
        }
        super.setVisibility(i);
    }

    /* renamed from: b */
    private final float m18823b(float f) {
        return (f * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }
}
