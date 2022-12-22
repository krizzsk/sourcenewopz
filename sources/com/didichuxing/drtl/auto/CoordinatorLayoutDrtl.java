package com.didichuxing.drtl.auto;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.tookit.DrtlViewExKt;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "CoordinatorLayout", value = {IDrtl.class})
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/drtl/auto/CoordinatorLayoutDrtl;", "Lcom/didichuxing/drtl/auto/IDrtl;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "()V", "apply", "", "coordinatorLayout", "getType", "Ljava/lang/Class;", "drtl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ViewGroupDRtl.kt */
public final class CoordinatorLayoutDrtl implements IDrtl<CoordinatorLayout> {
    public boolean filter(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        return IDrtl.DefaultImpls.filter(this, obj);
    }

    public void onApply(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        IDrtl.DefaultImpls.onApply(this, obj);
    }

    public Class<CoordinatorLayout> getType() {
        return CoordinatorLayout.class;
    }

    public void apply(CoordinatorLayout coordinatorLayout) {
        Intrinsics.checkParameterIsNotNull(coordinatorLayout, "coordinatorLayout");
        View view = coordinatorLayout;
        DrtlViewExKt.rtlMargin(view);
        DrtlViewExKt.rtlPadding(view);
        DrtlViewExKt.rtlLayoutParams(view);
        DrtlViewExKt.rtlForegroundGravity(view);
    }
}
