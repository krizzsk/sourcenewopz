package com.didiglobal.travel.infra.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a#\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\b\u001a#\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0005H\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\b\u001a#\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u0002*\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\b¨\u0006\u0012"}, mo175978d2 = {"gone", "", "Landroid/view/View;", "onClick", "block", "Lkotlin/Function1;", "onClickEmpty", "onClickNone", "onLongClick", "", "onLongClickNone", "removeFromParent", "requireViewByIdCompat", "T", "id", "", "(Landroid/view/View;I)Landroid/view/View;", "visible", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: View.kt */
public final class ViewKt {
    public static final void gone(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$gone");
        view.setVisibility(8);
    }

    public static final void visible(View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$visible");
        view.setVisibility(z ? 0 : 4);
    }

    public static final void removeFromParent(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$removeFromParent");
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static final void onClick(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$onClick");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        view.setOnClickListener(new ViewKt$onClick$1(function1));
    }

    public static final void onLongClick(View view, Function1<? super View, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$onLongClick");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        view.setOnLongClickListener(new ViewKt$onLongClick$1(function1));
    }

    public static final void onClickEmpty(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$onClickEmpty");
        view.setOnClickListener(ViewKt$onClickEmpty$1.INSTANCE);
    }

    public static final void onClickNone(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$onClickNone");
        view.setOnClickListener((View.OnClickListener) null);
    }

    public static final void onLongClickNone(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$onLongClickNone");
        view.setOnLongClickListener((View.OnLongClickListener) null);
    }

    public static final <T extends View> T requireViewByIdCompat(View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "$this$requireViewByIdCompat");
        T requireViewById = Build.VERSION.SDK_INT >= 28 ? view.requireViewById(i) : null;
        if (requireViewById != null || (requireViewById = view.findViewById(i)) != null) {
            return requireViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View".toString());
    }
}
