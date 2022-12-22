package com.didi.component.driverbar.impl;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u0004*\u0002H\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"childViewOf", "R", "C", "Lcom/didi/component/driverbar/impl/DriverBarFieldBase;", "Landroid/view/View;", "id", "", "(Lcom/didi/component/driverbar/impl/DriverBarFieldBase;I)Landroid/view/View;", "comp-driverbar_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarFieldView.kt */
public final class DriverBarFieldViewKt {
    public static final <C extends DriverBarFieldBase, R extends View> R childViewOf(C c, int i) {
        Intrinsics.checkNotNullParameter(c, "<this>");
        View view = c.mContainerView;
        if (view == null) {
            return null;
        }
        return view.findViewById(i);
    }
}
