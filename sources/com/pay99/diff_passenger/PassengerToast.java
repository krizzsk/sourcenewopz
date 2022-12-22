package com.pay99.diff_passenger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import com.didi.global.globaluikit.button.UnitUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.pay99.diff_base.base.IToastDiff;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/pay99/diff_passenger/PassengerToast;", "Lcom/pay99/diff_base/base/IToastDiff;", "()V", "configToast", "Landroid/widget/Toast;", "context", "Landroid/content/Context;", "toast", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PassengerToast.kt */
public final class PassengerToast extends IToastDiff {
    public Toast configToast(Context context, Toast toast) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toast, BlocksConst.ACTION_TYPE_TOAST);
        toast.setView(LayoutInflater.from(context).inflate(R.layout.w_common_toast_new, (ViewGroup) null));
        toast.setGravity(81, 0, UnitUtils.dp2px(context, 108.0f));
        return toast;
    }
}
