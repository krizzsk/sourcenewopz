package com.didiglobal.travel.util.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.async.AsyncLayoutFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, mo175978d2 = {"inflateViewAsync", "Landroid/view/View;", "Landroid/content/Context;", "layoutId", "", "root", "Landroid/view/ViewGroup;", "attachToRoot", "", "Landroid/view/LayoutInflater;", "TheOneSDKGlobal_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: View.kt */
public final class ViewEx {
    public static final View inflateViewAsync(Context context, int i, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        boolean z2 = true;
        if (i != 0) {
            View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(i);
            if (viewByResId != null) {
                return viewByResId;
            }
            LayoutInflater from = LayoutInflater.from(context);
            if (viewGroup == null || !z) {
                z2 = false;
            }
            View inflate = from.inflate(i, viewGroup, z2);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(this).inflate(layou… != null && attachToRoot)");
            return inflate;
        }
        throw new IllegalArgumentException("Must provide valid layout resource id".toString());
    }

    public static final View inflateViewAsync(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "<this>");
        boolean z2 = true;
        if (i != 0) {
            View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(i);
            if (viewByResId != null) {
                return viewByResId;
            }
            if (viewGroup == null || !z) {
                z2 = false;
            }
            View inflate = layoutInflater.inflate(i, viewGroup, z2);
            Intrinsics.checkNotNullExpressionValue(inflate, "this.inflate(layoutId, r… != null && attachToRoot)");
            return inflate;
        }
        throw new IllegalArgumentException("Must provide valid layout resource id".toString());
    }
}
