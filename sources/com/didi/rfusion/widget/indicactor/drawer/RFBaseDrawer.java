package com.didi.rfusion.widget.indicactor.drawer;

import android.animation.ArgbEvaluator;
import android.graphics.Paint;
import com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 /2\u00020\u0001:\u0002/0B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0002J0\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020#H\u0016J\u001c\u0010,\u001a\u00060\u0012R\u00020\u00002\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020#H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u00061"}, mo175978d2 = {"Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer;", "Lcom/didi/rfusion/widget/indicactor/drawer/RFDrawer;", "mIndicatorOptions", "Lcom/didi/rfusion/widget/indicactor/option/RFIndicatorOptions;", "(Lcom/didi/rfusion/widget/indicactor/option/RFIndicatorOptions;)V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "getArgbEvaluator$r_fusion_ninePhoneRelease", "()Landroid/animation/ArgbEvaluator;", "setArgbEvaluator$r_fusion_ninePhoneRelease", "(Landroid/animation/ArgbEvaluator;)V", "isWidthEquals", "", "()Z", "getMIndicatorOptions$r_fusion_ninePhoneRelease", "()Lcom/didi/rfusion/widget/indicactor/option/RFIndicatorOptions;", "setMIndicatorOptions$r_fusion_ninePhoneRelease", "mMeasureResult", "Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer$MeasureResult;", "mPaint", "Landroid/graphics/Paint;", "getMPaint$r_fusion_ninePhoneRelease", "()Landroid/graphics/Paint;", "setMPaint$r_fusion_ninePhoneRelease", "(Landroid/graphics/Paint;)V", "maxWidth", "", "getMaxWidth$r_fusion_ninePhoneRelease", "()F", "setMaxWidth$r_fusion_ninePhoneRelease", "(F)V", "minWidth", "getMinWidth$r_fusion_ninePhoneRelease", "setMinWidth$r_fusion_ninePhoneRelease", "measureHeight", "", "measureWidth", "onLayout", "", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "MeasureResult", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFBaseDrawer.kt */
public abstract class RFBaseDrawer implements RFDrawer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INDICATOR_PADDING = 3;
    public static final int INDICATOR_PADDING_ADDITION = 6;

    /* renamed from: a */
    private final MeasureResult f33590a;

    /* renamed from: b */
    private float f33591b;

    /* renamed from: c */
    private float f33592c;

    /* renamed from: d */
    private Paint f33593d = new Paint();

    /* renamed from: e */
    private ArgbEvaluator f33594e = new ArgbEvaluator();

    /* renamed from: f */
    private RFIndicatorOptions f33595f;

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public RFBaseDrawer(RFIndicatorOptions rFIndicatorOptions) {
        Intrinsics.checkParameterIsNotNull(rFIndicatorOptions, "mIndicatorOptions");
        this.f33595f = rFIndicatorOptions;
        this.f33593d.setAntiAlias(true);
        this.f33590a = new MeasureResult();
    }

    public final RFIndicatorOptions getMIndicatorOptions$r_fusion_ninePhoneRelease() {
        return this.f33595f;
    }

    public final void setMIndicatorOptions$r_fusion_ninePhoneRelease(RFIndicatorOptions rFIndicatorOptions) {
        Intrinsics.checkParameterIsNotNull(rFIndicatorOptions, "<set-?>");
        this.f33595f = rFIndicatorOptions;
    }

    public final float getMaxWidth$r_fusion_ninePhoneRelease() {
        return this.f33591b;
    }

    public final void setMaxWidth$r_fusion_ninePhoneRelease(float f) {
        this.f33591b = f;
    }

    public final float getMinWidth$r_fusion_ninePhoneRelease() {
        return this.f33592c;
    }

    public final void setMinWidth$r_fusion_ninePhoneRelease(float f) {
        this.f33592c = f;
    }

    public final Paint getMPaint$r_fusion_ninePhoneRelease() {
        return this.f33593d;
    }

    public final void setMPaint$r_fusion_ninePhoneRelease(Paint paint) {
        Intrinsics.checkParameterIsNotNull(paint, "<set-?>");
        this.f33593d = paint;
    }

    public final ArgbEvaluator getArgbEvaluator$r_fusion_ninePhoneRelease() {
        return this.f33594e;
    }

    public final void setArgbEvaluator$r_fusion_ninePhoneRelease(ArgbEvaluator argbEvaluator) {
        Intrinsics.checkParameterIsNotNull(argbEvaluator, "<set-?>");
        this.f33594e = argbEvaluator;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer$Companion;", "", "()V", "INDICATOR_PADDING", "", "INDICATOR_PADDING_ADDITION", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFBaseDrawer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isWidthEquals() {
        return this.f33595f.getNormalSliderWidth() == this.f33595f.getCheckedSliderWidth();
    }

    public MeasureResult onMeasure(int i, int i2) {
        this.f33591b = RangesKt.coerceAtLeast(this.f33595f.getNormalSliderWidth(), this.f33595f.getCheckedSliderWidth());
        this.f33592c = RangesKt.coerceAtMost(this.f33595f.getNormalSliderWidth(), this.f33595f.getCheckedSliderWidth());
        this.f33590a.setMeasureResult$r_fusion_ninePhoneRelease(m23670a(), measureHeight());
        return this.f33590a;
    }

    /* access modifiers changed from: protected */
    public int measureHeight() {
        return ((int) this.f33595f.getSliderHeight()) + 3;
    }

    /* renamed from: a */
    private final int m23670a() {
        float pageSize = (float) (this.f33595f.getPageSize() - 1);
        return ((int) ((this.f33595f.getSliderGap() * pageSize) + this.f33591b + (pageSize * this.f33592c))) + 6;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer$MeasureResult;", "", "(Lcom/didi/rfusion/widget/indicactor/drawer/RFBaseDrawer;)V", "<set-?>", "", "measureHeight", "getMeasureHeight", "()I", "setMeasureHeight$r_fusion_ninePhoneRelease", "(I)V", "measureWidth", "getMeasureWidth", "setMeasureWidth$r_fusion_ninePhoneRelease", "setMeasureResult", "", "setMeasureResult$r_fusion_ninePhoneRelease", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFBaseDrawer.kt */
    public final class MeasureResult {
        private int measureHeight;
        private int measureWidth;

        public MeasureResult() {
        }

        public final int getMeasureWidth() {
            return this.measureWidth;
        }

        public final void setMeasureWidth$r_fusion_ninePhoneRelease(int i) {
            this.measureWidth = i;
        }

        public final int getMeasureHeight() {
            return this.measureHeight;
        }

        public final void setMeasureHeight$r_fusion_ninePhoneRelease(int i) {
            this.measureHeight = i;
        }

        public final void setMeasureResult$r_fusion_ninePhoneRelease(int i, int i2) {
            this.measureWidth = i;
            this.measureHeight = i2;
        }
    }
}
