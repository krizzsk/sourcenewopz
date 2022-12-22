package com.didi.component.framework.pages.invitation.helper;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.ToastHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"toast", "", "Landroidx/fragment/app/Fragment;", "msg", "", "imgRes", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/Integer;)V", "framework_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ToastHelper.kt */
public final class ToastHelperKt {
    public static final void toast(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        Intrinsics.checkNotNull(activity);
        ToastHelper.showShortCompleted((Context) activity, str);
    }

    public static final void toast(Fragment fragment, String str, Integer num) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        Intrinsics.checkNotNull(activity);
        ToastHelper.showShortCompleted((Context) activity, str, num == null ? 0 : num.intValue());
    }
}
