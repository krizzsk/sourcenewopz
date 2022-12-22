package com.didichuxing.drtl.tookit;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import com.didichuxing.drtl.Drtl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u001a\u0012\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\u00020\u000b\u001a\f\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\r\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u000b¨\u0006\u0013"}, mo175978d2 = {"reverse", "", "T", "array", "", "([Ljava/lang/Object;)V", "rtlGravity", "", "g", "allView", "", "Landroid/view/View;", "autoMirrored", "Landroid/graphics/drawable/Drawable;", "rtlForegroundGravity", "rtlLayoutParams", "rtlMargin", "Landroid/view/ViewGroup$MarginLayoutParams;", "rtlPadding", "drtl_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: DrtlViewEx.kt */
public final class DrtlViewExKt {
    public static final int rtlGravity(int i) {
        if ((i & 7) == 3) {
            i = (i & -4) | GravityCompat.START;
        }
        return (i & 7) == 5 ? (i & -6) | GravityCompat.END : i;
    }

    public static final void rtlMargin(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$rtlMargin");
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                rtlMargin((ViewGroup.MarginLayoutParams) layoutParams);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public static final void rtlMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.checkParameterIsNotNull(marginLayoutParams, "$this$rtlMargin");
        if (marginLayoutParams.leftMargin != 0) {
            marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
        }
        if (marginLayoutParams.rightMargin != 0) {
            marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
        }
    }

    public static final void rtlPadding(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$rtlPadding");
        if (view.getPaddingLeft() != 0 || view.getPaddingRight() != 0) {
            view.setPaddingRelative(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static final void autoMirrored(Drawable drawable) {
        if (drawable != null && DRtlToolkit.rtl() && Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(true);
        }
    }

    public static final void rtlLayoutParams(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$rtlLayoutParams");
        if (view.getLayoutParams() != null) {
            Drtl drtl = Drtl.INSTANCE;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkExpressionValueIsNotNull(layoutParams, "layoutParams");
            drtl.rtl(layoutParams);
        }
    }

    public static final void rtlForegroundGravity(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$rtlForegroundGravity");
        if (Build.VERSION.SDK_INT >= 23) {
            view.setForegroundGravity(rtlGravity(view.getForegroundGravity()));
        }
    }

    public static final List<View> allView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$allView");
        List<View> arrayList = new ArrayList<>();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                arrayList.add(childAt);
                if (childAt instanceof ViewGroup) {
                    arrayList.addAll(allView(childAt));
                }
            }
        } else {
            arrayList.add(view);
        }
        return arrayList;
    }

    public static final <T> void reverse(T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "array");
        ArraysKt.reverse(tArr);
    }
}
