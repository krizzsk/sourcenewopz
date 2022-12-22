package com.didichuxing.drtl.auto;

import android.view.View;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.tookit.DrtlViewExKt;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "View", value = {IDrtl.class})
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didichuxing/drtl/auto/ViewRtl;", "Lcom/didichuxing/drtl/auto/IDrtl;", "Landroid/view/View;", "()V", "apply", "", "view", "filter", "", "any", "", "getType", "Ljava/lang/Class;", "drtl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ViewDRtl.kt */
public final class ViewRtl implements IDrtl<View> {
    public void onApply(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        IDrtl.DefaultImpls.onApply(this, obj);
    }

    public Class<View> getType() {
        return View.class;
    }

    public boolean filter(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        return obj instanceof View;
    }

    public void apply(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        DrtlViewExKt.rtlPadding(view);
        DrtlViewExKt.rtlMargin(view);
        DrtlViewExKt.rtlLayoutParams(view);
        DrtlViewExKt.rtlForegroundGravity(view);
    }
}
