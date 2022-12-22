package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.didi.soda.home.topgun.component.filter.module.AbsFilterModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\fH\u0016J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/ExposureLinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/home/topgun/component/filter/module/AbsFilterModule$MoudleAppearListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mExposureListener", "Lkotlin/Function0;", "", "getMExposureListener", "()Lkotlin/jvm/functions/Function0;", "setMExposureListener", "(Lkotlin/jvm/functions/Function0;)V", "onMoudleAppear", "setExposureListener", "exposureListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExposureLinearLayout.kt */
public final class ExposureLinearLayout extends LinearLayout implements AbsFilterModule.MoudleAppearListener {

    /* renamed from: a */
    private Function0<Unit> f43047a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExposureLinearLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExposureLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExposureLinearLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposureLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Function0<Unit> getMExposureListener() {
        return this.f43047a;
    }

    public final void setMExposureListener(Function0<Unit> function0) {
        this.f43047a = function0;
    }

    public void onMoudleAppear() {
        Function0<Unit> function0 = this.f43047a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setExposureListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "exposureListener");
        this.f43047a = function0;
    }
}
