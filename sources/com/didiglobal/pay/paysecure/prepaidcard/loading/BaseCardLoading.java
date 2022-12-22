package com.didiglobal.pay.paysecure.prepaidcard.loading;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didiglobal.pay.paysecure.p204ui.view.PaySecureProgressDialog;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/loading/BaseCardLoading;", "Lcom/didiglobal/pay/paysecure/prepaidcard/loading/ILoading;", "()V", "hideLoading", "", "isViewAlive", "", "context", "Landroid/app/Activity;", "showLoading", "Landroidx/fragment/app/FragmentActivity;", "view", "Landroid/view/View;", "msg", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseCardLoading.kt */
public final class BaseCardLoading implements ILoading {
    public void showLoading(FragmentActivity fragmentActivity, View view, String str) {
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "context");
        if (m36257a(fragmentActivity)) {
            PaySecureProgressDialog paySecureProgressDialog = PaySecureProgressDialog.INSTANCE;
            if (TextUtils.isEmpty(str)) {
                str = fragmentActivity.getString(R.string.pay_secure_loading_msg);
            }
            paySecureProgressDialog.showDialog(fragmentActivity, str, false);
        }
    }

    public void hideLoading() {
        PaySecureProgressDialog.INSTANCE.dismissProgressDialogFragmentSafely();
    }

    /* renamed from: a */
    private final boolean m36257a(Activity activity) {
        return !activity.isFinishing() && !activity.isDestroyed();
    }
}
