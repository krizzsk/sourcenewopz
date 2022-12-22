package com.didichuxing.drtl.auto;

import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.tookit.DrtlViewExKt;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "LinearLayout", value = {IDrtl.class})
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/drtl/auto/LinearLayoutDRtl;", "Lcom/didichuxing/drtl/auto/IDrtl;", "Landroid/widget/LinearLayout;", "()V", "apply", "", "linearLayout", "getType", "Ljava/lang/Class;", "resetGravity", "drtl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ViewGroupDRtl.kt */
public final class LinearLayoutDRtl implements IDrtl<LinearLayout> {
    public boolean filter(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        return IDrtl.DefaultImpls.filter(this, obj);
    }

    public void onApply(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "any");
        IDrtl.DefaultImpls.onApply(this, obj);
    }

    public void apply(LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "linearLayout");
        View view = linearLayout;
        DrtlViewExKt.rtlMargin(view);
        DrtlViewExKt.rtlPadding(view);
        m34036a(linearLayout, linearLayout);
        DrtlViewExKt.rtlLayoutParams(view);
        DrtlViewExKt.rtlForegroundGravity(view);
    }

    /* renamed from: a */
    private final void m34036a(LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (Build.VERSION.SDK_INT >= 24) {
            linearLayout.setGravity(DrtlViewExKt.rtlGravity(linearLayout.getGravity()));
            return;
        }
        try {
            Field declaredField = LinearLayout.class.getDeclaredField("mGravity");
            Intrinsics.checkExpressionValueIsNotNull(declaredField, "clazz.getDeclaredField(\"mGravity\")");
            declaredField.setAccessible(true);
            Integer num = (Integer) declaredField.get(linearLayout2);
            linearLayout.setGravity(DrtlViewExKt.rtlGravity(num != null ? num.intValue() : BadgeDrawable.TOP_START));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Class<LinearLayout> getType() {
        return LinearLayout.class;
    }
}
