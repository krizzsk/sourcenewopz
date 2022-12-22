package com.didi.global.fintech.cashier.core.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a&\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, mo175978d2 = {"addView", "", "activity", "Landroid/app/Activity;", "childView", "Landroid/view/View;", "bindBtn", "listener", "Lkotlin/Function1;", "", "cashier_core_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtilsKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15756a(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$listener");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        function1.invoke(view);
    }

    public static final int bindBtn(int i, Activity activity, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(function1, "listener");
        View findViewById = activity.findViewById(i);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ViewUtilsKt.m15756a(Function1.this, view);
                }
            });
        }
        return i;
    }

    public static final int addView(int i, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "childView");
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(i);
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
        return i;
    }
}
