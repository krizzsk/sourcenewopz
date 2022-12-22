package com.didi.rfusion.widget.indicactor;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.indicactor.drawer.RFBaseDrawer;
import com.didi.rfusion.widget.indicactor.drawer.RFDrawer;
import com.didi.rfusion.widget.indicactor.drawer.RFRoundRectDrawer;
import com.didi.rfusion.widget.indicactor.option.RFIndicatorOptions;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\fH\u0004J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J0\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0017\u0010$\u001a\u00020\u00162\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0007J\u0010\u0010+\u001a\u00020\u00162\b\b\u0001\u0010%\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, mo175978d2 = {"Lcom/didi/rfusion/widget/indicactor/RFPageIndicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "indicatorDrawer", "Lcom/didi/rfusion/widget/indicactor/drawer/RFDrawer;", "indicatorOptions", "Lcom/didi/rfusion/widget/indicactor/option/RFIndicatorOptions;", "getCheckedProgress", "", "()Ljava/lang/Float;", "getCurrentPostion", "getIndicatorOption", "getPageSize", "getSlideMode", "getSlideProgress", "notifyDataChanged", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCheckedProgress", "progress", "(Ljava/lang/Float;)V", "setCurrentPosition", "position", "setPageSize", "pageSize", "setSlideProgress", "setType", "type", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFPageIndicator.kt */
public class RFPageIndicator extends View {

    /* renamed from: a */
    private final RFIndicatorOptions f33587a;

    /* renamed from: b */
    private final RFDrawer f33588b;

    /* renamed from: c */
    private HashMap f33589c;

    public RFPageIndicator(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33589c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33589c == null) {
            this.f33589c = new HashMap();
        }
        View view = (View) this.f33589c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33589c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFPageIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        RFIndicatorOptions rFIndicatorOptions = new RFIndicatorOptions();
        this.f33587a = rFIndicatorOptions;
        this.f33588b = new RFRoundRectDrawer(rFIndicatorOptions);
        RFIndicatorOptions rFIndicatorOptions2 = this.f33587a;
        rFIndicatorOptions2.setSlideMode(4);
        rFIndicatorOptions2.setNormalSliderWidth(RFResUtils.getDimens(context, R.dimen.rf_dimen_12));
        rFIndicatorOptions2.setCheckedSliderWidth(RFResUtils.getDimens(context, R.dimen.rf_dimen_20));
        rFIndicatorOptions2.setSliderHeight(RFResUtils.getDimens(context, R.dimen.rf_dimen_6));
        rFIndicatorOptions2.setSliderGap(RFResUtils.getDimens(context, R.dimen.rf_dimen_8));
        setType(1);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        RFBaseDrawer.MeasureResult onMeasure = this.f33588b.onMeasure(i, i2);
        setMeasuredDimension(onMeasure.getMeasureWidth(), onMeasure.getMeasureHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f33588b.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        this.f33588b.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public final RFIndicatorOptions getIndicatorOption() {
        return this.f33587a;
    }

    public final void setPageSize(int i) {
        this.f33587a.setPageSize(i);
    }

    public final int getPageSize() {
        return this.f33587a.getPageSize();
    }

    public final void setCurrentPosition(int i) {
        this.f33587a.setCurrentPosition(i);
    }

    public final int getCurrentPostion() {
        return this.f33587a.getCurrentPosition();
    }

    public final void setSlideProgress(float f) {
        this.f33587a.setSlideProgress(f);
    }

    public final float getSlideProgress() {
        return this.f33587a.getSlideProgress();
    }

    public final void setCheckedProgress(Float f) {
        this.f33587a.setCheckedProgress(f);
    }

    public final Float getCheckedProgress() {
        return this.f33587a.getCheckedProgress();
    }

    public final void setType(int i) {
        if (i == 0) {
            this.f33587a.setNormalSliderColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_16_93_5C000000));
            this.f33587a.setCheckedSliderColor(RFResUtils.getColor(getContext(), R.color.rf_color_white_100_FFFFFF));
        } else if (i == 1) {
            this.f33587a.setNormalSliderColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_15_0_0D000000));
            this.f33587a.setCheckedSliderColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_4_80_CCCCCC));
        }
    }

    public final int getSlideMode() {
        return this.f33587a.getSlideMode();
    }

    public final void notifyDataChanged() {
        invalidate();
    }
}
