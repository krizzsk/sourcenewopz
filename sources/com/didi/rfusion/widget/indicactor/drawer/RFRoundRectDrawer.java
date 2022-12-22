package com.didi.rfusion.widget.indicactor.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J1\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/rfusion/widget/indicactor/drawer/RFRoundRectDrawer;", "Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer;", "indicatorOptions", "Lcom/didi/rfusion/widget/indicactor/option/RFIndicatorOptions;", "(Lcom/didi/rfusion/widget/indicactor/option/RFIndicatorOptions;)V", "mRectF", "Landroid/graphics/RectF;", "calculateTranslateWidth", "", "sliderWidth", "drawCheckedSlider", "", "canvas", "Landroid/graphics/Canvas;", "drawInequalitySlider", "pageSize", "", "drawRoundRect", "rx", "ry", "alpha", "(Landroid/graphics/Canvas;FFLjava/lang/Float;)V", "drawScaleSlider", "i", "drawUncheckedSlider", "getTranslateProgress", "getTransparentProgress", "hasCheckedProgress", "", "onDraw", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFRoundRectDrawer.kt */
public class RFRoundRectDrawer extends RFBaseDrawer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f33596b = "RFRoundRectDrawer";

    /* renamed from: c */
    private static final float f33597c = 0.1f;

    /* renamed from: a */
    private RectF f33598a = new RectF();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFRoundRectDrawer(RFIndicatorOptions rFIndicatorOptions) {
        super(rFIndicatorOptions);
        Intrinsics.checkParameterIsNotNull(rFIndicatorOptions, "indicatorOptions");
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        int pageSize = getMIndicatorOptions$r_fusion_ninePhoneRelease().getPageSize();
        if (pageSize <= 1) {
            return;
        }
        if (isWidthEquals() && getMIndicatorOptions$r_fusion_ninePhoneRelease().getSlideMode() != 0) {
            m23678b(canvas, pageSize);
            m23673a(canvas);
        } else if (getMIndicatorOptions$r_fusion_ninePhoneRelease().getSlideMode() == 4) {
            for (int i = 0; i < pageSize; i++) {
                m23675a(canvas, i);
            }
        } else {
            m23679c(canvas, pageSize);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02c4  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m23675a(android.graphics.Canvas r26, int r27) {
        /*
            r25 = this;
            r7 = r25
            r8 = r26
            r9 = r27
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r10 = r0.getCheckedSliderColor()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r11 = r0.getSliderGap()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r12 = r0.getSliderHeight()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r13 = r0.getCurrentPosition()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r14 = r0.getNormalSliderWidth()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r15 = r0.getCheckedSliderWidth()
            r6 = 1
            r5 = 0
            if (r9 >= r13) goto L_0x0082
            android.graphics.Paint r0 = r25.getMPaint$r_fusion_ninePhoneRelease()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r1 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r1 = r1.getNormalSliderColor()
            r0.setColor(r1)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getPageSize()
            int r0 = r0 - r6
            if (r13 != r0) goto L_0x0067
            float r0 = (float) r9
            float r1 = r0 * r14
            float r0 = r0 * r11
            float r1 = r1 + r0
            float r15 = r15 - r14
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r0 = r0.getSlideProgress()
            float r15 = r15 * r0
            float r1 = r1 + r15
            goto L_0x006d
        L_0x0067:
            float r0 = (float) r9
            float r1 = r0 * r14
            float r0 = r0 * r11
            float r1 = r1 + r0
        L_0x006d:
            android.graphics.RectF r0 = r7.f33598a
            float r14 = r14 + r1
            r0.set(r1, r5, r14, r12)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r25
            r1 = r26
            r2 = r12
            r3 = r12
            m23676a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0376
        L_0x0082:
            if (r9 != r13) goto L_0x032b
            android.graphics.Paint r0 = r25.getMPaint$r_fusion_ninePhoneRelease()
            r0.setColor(r10)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r4 = r0.getSlideProgress()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getPageSize()
            int r0 = r0 - r6
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Int"
            if (r13 != r0) goto L_0x0183
            boolean r0 = r25.m23680c()
            if (r0 != 0) goto L_0x00cd
            android.animation.ArgbEvaluator r0 = r25.getArgbEvaluator$r_fusion_ninePhoneRelease()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r2 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r2 = r2.getNormalSliderColor()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.evaluate(r4, r1, r2)
            if (r0 == 0) goto L_0x00c7
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x00d5
        L_0x00c7:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r3)
            throw r0
        L_0x00cd:
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getNormalSliderColor()
        L_0x00d5:
            android.graphics.Paint r1 = r25.getMPaint$r_fusion_ninePhoneRelease()
            r1.setColor(r0)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getPageSize()
            int r0 = r0 - r6
            float r0 = (float) r0
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r1 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r1 = r1.getSliderGap()
            float r1 = r1 + r14
            float r0 = r0 * r1
            float r2 = r0 + r15
            float r0 = r2 - r15
            float r1 = r15 - r14
            float r1 = r1 * r4
            float r1 = r1 + r0
            android.graphics.RectF r0 = r7.f33598a
            r0.set(r1, r5, r2, r12)
            r16 = 0
            r17 = 8
            r18 = 0
            r0 = r25
            r19 = r1
            r1 = r26
            r20 = r2
            r2 = r12
            r21 = r3
            r3 = r12
            r22 = r4
            r4 = r16
            r5 = r17
            r16 = r13
            r13 = 1
            r6 = r18
            m23676a(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r25.m23680c()
            if (r0 == 0) goto L_0x017a
            android.graphics.Paint r0 = r25.getMPaint$r_fusion_ninePhoneRelease()
            android.animation.ArgbEvaluator r1 = r25.getArgbEvaluator$r_fusion_ninePhoneRelease()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r3 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r3 = r3.getNormalSliderColor()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6 = r22
            java.lang.Object r1 = r1.evaluate(r6, r2, r3)
            if (r1 == 0) goto L_0x0172
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r0.setColor(r1)
            float r0 = r7.m23672a((float) r15)
            r1 = r19
            float r0 = r0 + r1
            r2 = r20
            float r0 = kotlin.ranges.RangesKt.coerceAtMost((float) r0, (float) r2)
            android.graphics.RectF r2 = r7.f33598a
            r5 = 0
            r2.set(r1, r5, r0, r12)
            float r0 = r25.m23677b()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r7.m23674a(r8, r12, r12, r0)
            r17 = r11
            r1 = r21
            goto L_0x0256
        L_0x0172:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r4 = r21
            r0.<init>(r4)
            throw r0
        L_0x017a:
            r17 = r11
            r1 = r21
            r11 = r22
        L_0x0180:
            r3 = 0
            goto L_0x0258
        L_0x0183:
            r6 = r4
            r16 = r13
            r13 = 1
            r4 = r3
            float r0 = (float) r13
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0253
            boolean r1 = r25.m23680c()
            if (r1 != 0) goto L_0x01ba
            android.animation.ArgbEvaluator r1 = r25.getArgbEvaluator$r_fusion_ninePhoneRelease()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r3 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r3 = r3.getNormalSliderColor()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r1 = r1.evaluate(r6, r2, r3)
            if (r1 == 0) goto L_0x01b4
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x01c2
        L_0x01b4:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r4)
            throw r0
        L_0x01ba:
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r1 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r1 = r1.getNormalSliderColor()
        L_0x01c2:
            android.graphics.Paint r2 = r25.getMPaint$r_fusion_ninePhoneRelease()
            r2.setColor(r1)
            float r1 = (float) r9
            float r2 = r1 * r14
            float r1 = r1 * r11
            float r3 = r2 + r1
            float r1 = r3 + r14
            float r2 = r15 - r14
            float r0 = r0 - r6
            float r2 = r2 * r0
            float r2 = r2 + r1
            android.graphics.RectF r0 = r7.f33598a
            r0.set(r3, r5, r2, r12)
            r17 = 0
            r18 = 8
            r19 = 0
            r0 = r25
            r1 = r26
            r13 = r2
            r2 = r12
            r23 = r3
            r3 = r12
            r24 = r4
            r4 = r17
            r5 = r18
            r17 = r11
            r11 = r6
            r6 = r19
            m23676a(r0, r1, r2, r3, r4, r5, r6)
            boolean r0 = r25.m23680c()
            if (r0 == 0) goto L_0x024f
            float r0 = r7.m23672a((float) r15)
            r2 = r23
            float r3 = r2 + r0
            float r0 = kotlin.ranges.RangesKt.coerceAtMost((float) r3, (float) r13)
            android.graphics.Paint r1 = r25.getMPaint$r_fusion_ninePhoneRelease()
            android.animation.ArgbEvaluator r3 = r25.getArgbEvaluator$r_fusion_ninePhoneRelease()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r5 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r5 = r5.getNormalSliderColor()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r3 = r3.evaluate(r11, r4, r5)
            if (r3 == 0) goto L_0x0247
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r1.setColor(r3)
            android.graphics.RectF r1 = r7.f33598a
            r3 = 0
            r1.set(r2, r3, r0, r12)
            float r0 = r25.m23677b()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r7.m23674a(r8, r12, r12, r0)
            r1 = r24
            goto L_0x0258
        L_0x0247:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r1 = r24
            r0.<init>(r1)
            throw r0
        L_0x024f:
            r1 = r24
            goto L_0x0180
        L_0x0253:
            r1 = r4
            r17 = r11
        L_0x0256:
            r3 = 0
            r11 = r6
        L_0x0258:
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getPageSize()
            r2 = 1
            int r0 = r0 - r2
            r4 = 0
            r5 = r16
            if (r5 != r0) goto L_0x02c4
            float r0 = (float) r4
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0376
            boolean r0 = r25.m23680c()
            if (r0 != 0) goto L_0x029b
            android.animation.ArgbEvaluator r0 = r25.getArgbEvaluator$r_fusion_ninePhoneRelease()
            float r2 = (float) r2
            float r2 = r2 - r11
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r5 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r5 = r5.getNormalSliderColor()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.evaluate(r2, r4, r5)
            if (r0 == 0) goto L_0x0295
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x02a3
        L_0x0295:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r1)
            throw r0
        L_0x029b:
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getNormalSliderColor()
        L_0x02a3:
            android.graphics.Paint r1 = r25.getMPaint$r_fusion_ninePhoneRelease()
            r1.setColor(r0)
            float r5 = r14 + r3
            float r15 = r15 - r14
            float r15 = r15 * r11
            float r5 = r5 + r15
            android.graphics.RectF r0 = r7.f33598a
            r0.set(r3, r3, r5, r12)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r25
            r1 = r26
            r2 = r12
            r3 = r12
            m23676a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0376
        L_0x02c4:
            float r0 = (float) r4
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0376
            boolean r0 = r25.m23680c()
            if (r0 != 0) goto L_0x02f9
            android.animation.ArgbEvaluator r0 = r25.getArgbEvaluator$r_fusion_ninePhoneRelease()
            r2 = 1
            float r2 = (float) r2
            float r2 = r2 - r11
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r5 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r5 = r5.getNormalSliderColor()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.evaluate(r2, r4, r5)
            if (r0 == 0) goto L_0x02f3
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0301
        L_0x02f3:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            r0.<init>(r1)
            throw r0
        L_0x02f9:
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getNormalSliderColor()
        L_0x0301:
            android.graphics.Paint r1 = r25.getMPaint$r_fusion_ninePhoneRelease()
            r1.setColor(r0)
            float r0 = (float) r9
            float r1 = r0 * r14
            float r0 = r0 * r17
            float r1 = r1 + r0
            float r1 = r1 + r14
            float r0 = r17 + r15
            float r1 = r1 + r0
            float r0 = r1 - r14
            float r15 = r15 - r14
            float r15 = r15 * r11
            float r0 = r0 - r15
            android.graphics.RectF r2 = r7.f33598a
            r2.set(r0, r3, r1, r12)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r25
            r1 = r26
            r2 = r12
            r3 = r12
            m23676a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0376
        L_0x032b:
            r17 = r11
            r5 = r13
            r0 = 1
            r3 = 0
            int r13 = r5 + 1
            if (r13 != r9) goto L_0x0340
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r0 = r0.getSlideProgress()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0376
        L_0x0340:
            android.graphics.Paint r0 = r25.getMPaint$r_fusion_ninePhoneRelease()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r1 = r25.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r1 = r1.getNormalSliderColor()
            r0.setColor(r1)
            float r0 = (float) r9
            float r1 = r25.getMinWidth$r_fusion_ninePhoneRelease()
            float r1 = r1 * r0
            float r0 = r0 * r17
            float r1 = r1 + r0
            float r0 = r25.getMinWidth$r_fusion_ninePhoneRelease()
            float r15 = r15 - r0
            float r1 = r1 + r15
            android.graphics.RectF r0 = r7.f33598a
            float r2 = r25.getMinWidth$r_fusion_ninePhoneRelease()
            float r2 = r2 + r1
            r0.set(r1, r3, r2, r12)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r25
            r1 = r26
            r2 = r12
            r3 = r12
            m23676a(r0, r1, r2, r3, r4, r5, r6)
        L_0x0376:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.indicactor.drawer.RFRoundRectDrawer.m23675a(android.graphics.Canvas, int):void");
    }

    /* renamed from: b */
    private final void m23678b(Canvas canvas, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            getMPaint$r_fusion_ninePhoneRelease().setColor(getMIndicatorOptions$r_fusion_ninePhoneRelease().getNormalSliderColor());
            float f = (float) i2;
            float maxWidth$r_fusion_ninePhoneRelease = (getMaxWidth$r_fusion_ninePhoneRelease() * f) + (f * getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderGap()) + (getMaxWidth$r_fusion_ninePhoneRelease() - getMinWidth$r_fusion_ninePhoneRelease());
            this.f33598a.set(maxWidth$r_fusion_ninePhoneRelease, 0.0f, getMinWidth$r_fusion_ninePhoneRelease() + maxWidth$r_fusion_ninePhoneRelease, getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight());
            m23676a(this, canvas, getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight(), getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight(), (Float) null, 8, (Object) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
        if (r3.floatValue() < getMIndicatorOptions$r_fusion_ninePhoneRelease().getSlideProgress()) goto L_0x005a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m23673a(android.graphics.Canvas r12) {
        /*
            r11 = this;
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r0 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r0 = r0.getCurrentPosition()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r1 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r1 = r1.getSliderGap()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r2 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r2 = r2.getSliderHeight()
            android.graphics.Paint r3 = r11.getMPaint$r_fusion_ninePhoneRelease()
            boolean r4 = r11.m23680c()
            if (r4 != 0) goto L_0x002b
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r4 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r4 = r4.getCheckedSliderColor()
            goto L_0x0033
        L_0x002b:
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r4 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            int r4 = r4.getNormalSliderColor()
        L_0x0033:
            r3.setColor(r4)
            boolean r3 = r11.m23680c()
            r10 = 0
            if (r3 == 0) goto L_0x005a
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r3 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            java.lang.Float r3 = r3.getCheckedProgress()
            if (r3 != 0) goto L_0x004a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x004a:
            float r3 = r3.floatValue()
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r4 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r4 = r4.getSlideProgress()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0089
        L_0x005a:
            float r3 = (float) r0
            float r4 = r11.getMaxWidth$r_fusion_ninePhoneRelease()
            float r4 = r4 * r3
            float r3 = r3 * r1
            float r4 = r4 + r3
            float r3 = r11.getMaxWidth$r_fusion_ninePhoneRelease()
            float r3 = r3 + r1
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r5 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r5 = r5.getSlideProgress()
            float r3 = r3 * r5
            float r4 = r4 + r3
            android.graphics.RectF r3 = r11.f33598a
            float r5 = r11.getMaxWidth$r_fusion_ninePhoneRelease()
            float r5 = r5 + r4
            r3.set(r4, r10, r5, r2)
            r7 = 0
            r8 = 8
            r9 = 0
            r3 = r11
            r4 = r12
            r5 = r2
            r6 = r2
            m23676a(r3, r4, r5, r6, r7, r8, r9)
        L_0x0089:
            boolean r3 = r11.m23680c()
            if (r3 == 0) goto L_0x00c6
            float r3 = r11.getMaxWidth$r_fusion_ninePhoneRelease()
            float r3 = r3 + r1
            com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions r4 = r11.getMIndicatorOptions$r_fusion_ninePhoneRelease()
            float r4 = r4.getSlideProgress()
            float r4 = r4 * r3
            float r3 = r11.m23672a((float) r3)
            float r3 = java.lang.Math.min(r4, r3)
            float r0 = (float) r0
            float r4 = r11.getMaxWidth$r_fusion_ninePhoneRelease()
            float r4 = r4 * r0
            float r0 = r0 * r1
            float r4 = r4 + r0
            float r4 = r4 + r3
            android.graphics.RectF r0 = r11.f33598a
            float r1 = r11.getMaxWidth$r_fusion_ninePhoneRelease()
            float r1 = r1 + r4
            r0.set(r4, r10, r1, r2)
            r7 = 0
            r8 = 8
            r9 = 0
            r3 = r11
            r4 = r12
            r5 = r2
            r6 = r2
            m23676a(r3, r4, r5, r6, r7, r8, r9)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.indicactor.drawer.RFRoundRectDrawer.m23673a(android.graphics.Canvas):void");
    }

    /* renamed from: c */
    private final void m23679c(Canvas canvas, int i) {
        float f;
        int i2;
        float f2 = 0.0f;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 == getMIndicatorOptions$r_fusion_ninePhoneRelease().getCurrentPosition()) {
                f = getMaxWidth$r_fusion_ninePhoneRelease();
            } else {
                f = getMinWidth$r_fusion_ninePhoneRelease();
            }
            Paint mPaint$r_fusion_ninePhoneRelease = getMPaint$r_fusion_ninePhoneRelease();
            if (i3 != getMIndicatorOptions$r_fusion_ninePhoneRelease().getCurrentPosition() || m23680c()) {
                i2 = getMIndicatorOptions$r_fusion_ninePhoneRelease().getNormalSliderColor();
            } else {
                i2 = getMIndicatorOptions$r_fusion_ninePhoneRelease().getCheckedSliderColor();
            }
            mPaint$r_fusion_ninePhoneRelease.setColor(i2);
            this.f33598a.set(f2, 0.0f, f2 + f, getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight());
            m23676a(this, canvas, getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight(), getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight(), (Float) null, 8, (Object) null);
            if (i3 == getMIndicatorOptions$r_fusion_ninePhoneRelease().getCurrentPosition() && m23680c()) {
                getMPaint$r_fusion_ninePhoneRelease().setColor(getMIndicatorOptions$r_fusion_ninePhoneRelease().getCheckedSliderColor());
                this.f33598a.set(f2, 0.0f, m23672a(f) + f2, getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight());
                m23674a(canvas, getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight(), getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight(), Float.valueOf(m23677b()));
            }
            f2 += f + getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderGap();
        }
    }

    /* renamed from: a */
    private final float m23672a(float f) {
        Float checkedProgress = getMIndicatorOptions$r_fusion_ninePhoneRelease().getCheckedProgress();
        if (checkedProgress == null) {
            Intrinsics.throwNpe();
        }
        if (checkedProgress.floatValue() == 0.0f) {
            return 0.0f;
        }
        return getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight() + ((f - getMIndicatorOptions$r_fusion_ninePhoneRelease().getSliderHeight()) * m23671a());
    }

    /* renamed from: a */
    private final float m23671a() {
        Float checkedProgress = getMIndicatorOptions$r_fusion_ninePhoneRelease().getCheckedProgress();
        if (checkedProgress == null) {
            Intrinsics.throwNpe();
        }
        return Math.max(0.0f, checkedProgress.floatValue() - 0.1f);
    }

    /* renamed from: b */
    private final float m23677b() {
        Float checkedProgress = getMIndicatorOptions$r_fusion_ninePhoneRelease().getCheckedProgress();
        if (checkedProgress == null) {
            Intrinsics.throwNpe();
        }
        return Math.min(checkedProgress.floatValue(), 0.1f) / 0.1f;
    }

    /* renamed from: a */
    static /* synthetic */ void m23676a(RFRoundRectDrawer rFRoundRectDrawer, Canvas canvas, float f, float f2, Float f3, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                f3 = null;
            }
            rFRoundRectDrawer.m23674a(canvas, f, f2, f3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect");
    }

    /* renamed from: a */
    private final void m23674a(Canvas canvas, float f, float f2, Float f3) {
        int alpha = getMPaint$r_fusion_ninePhoneRelease().getAlpha();
        if (f3 != null) {
            getMPaint$r_fusion_ninePhoneRelease().setAlpha((int) (((float) alpha) * f3.floatValue()));
        }
        canvas.drawRoundRect(this.f33598a, f, f2, getMPaint$r_fusion_ninePhoneRelease());
        getMPaint$r_fusion_ninePhoneRelease().setAlpha(alpha);
    }

    /* renamed from: c */
    private final boolean m23680c() {
        return getMIndicatorOptions$r_fusion_ninePhoneRelease().getCheckedProgress() != null;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/rfusion/widget/indicactor/drawer/RFRoundRectDrawer$Companion;", "", "()V", "TAG", "", "TRANSPARENT_PROGRESS", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFRoundRectDrawer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
