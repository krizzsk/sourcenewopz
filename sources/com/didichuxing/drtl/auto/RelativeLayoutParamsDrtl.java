package com.didichuxing.drtl.auto;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.tookit.DrtlViewExKt;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "RelativeLayout.LayoutParams", value = {IDrtl.class})
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didichuxing/drtl/auto/RelativeLayoutParamsDrtl;", "Lcom/didichuxing/drtl/auto/IDrtl;", "Landroid/widget/RelativeLayout$LayoutParams;", "()V", "apply", "", "params", "fixRules", "baseRule", "", "fiRules", "getType", "Ljava/lang/Class;", "drtl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LayoutParamsDRtl.kt */
public final class RelativeLayoutParamsDrtl implements IDrtl<RelativeLayout.LayoutParams> {
    public boolean filter(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        return IDrtl.DefaultImpls.filter(this, obj);
    }

    public void onApply(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        IDrtl.DefaultImpls.onApply(this, obj);
    }

    public Class<RelativeLayout.LayoutParams> getType() {
        return RelativeLayout.LayoutParams.class;
    }

    public void apply(RelativeLayout.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "params");
        DrtlViewExKt.rtlMargin((ViewGroup.MarginLayoutParams) layoutParams);
        m34037a(layoutParams, 0, 16);
        m34037a(layoutParams, 5, 18);
        m34037a(layoutParams, 9, 20);
        m34037a(layoutParams, 1, 17);
        m34037a(layoutParams, 7, 18);
        m34037a(layoutParams, 11, 21);
    }

    /* renamed from: a */
    private final void m34037a(RelativeLayout.LayoutParams layoutParams, int i, int i2) {
        if (layoutParams.getRules()[i] != 0) {
            layoutParams.addRule(i2, layoutParams.getRules()[i]);
        }
    }
}
