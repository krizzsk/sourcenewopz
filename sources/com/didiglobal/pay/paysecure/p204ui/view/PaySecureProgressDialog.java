package com.didiglobal.pay.paysecure.p204ui.view;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\"\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/PaySecureProgressDialog;", "", "()V", "sProgressDialogFragment", "Lcom/didiglobal/pay/paysecure/ui/view/ProgressDialogFragment;", "dismissProgressDialogFragmentSafely", "", "showDialog", "context", "Landroidx/fragment/app/FragmentActivity;", "msg", "", "cancel", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.PaySecureProgressDialog */
/* compiled from: PaySecureProgressDialog.kt */
public final class PaySecureProgressDialog {
    public static final PaySecureProgressDialog INSTANCE = new PaySecureProgressDialog();

    /* renamed from: a */
    private static ProgressDialogFragment f50462a;

    private PaySecureProgressDialog() {
    }

    public final synchronized void showDialog(FragmentActivity fragmentActivity, String str, boolean z) {
        if (fragmentActivity != null) {
            if (f50462a == null) {
                f50462a = new ProgressDialogFragment();
            }
            ProgressDialogFragment progressDialogFragment = f50462a;
            if (progressDialogFragment == null) {
                Intrinsics.throwNpe();
            }
            if (!progressDialogFragment.isAdded()) {
                try {
                    ProgressDialogFragment progressDialogFragment2 = f50462a;
                    if (progressDialogFragment2 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (str == null) {
                        Intrinsics.throwNpe();
                    }
                    progressDialogFragment2.setContent(str, z);
                    ProgressDialogFragment progressDialogFragment3 = f50462a;
                    if (progressDialogFragment3 == null) {
                        Intrinsics.throwNpe();
                    }
                    FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                    Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "context.supportFragmentManager");
                    progressDialogFragment3.show(supportFragmentManager, (String) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        } else {
            return;
        }
        return;
    }

    public final synchronized void dismissProgressDialogFragmentSafely() {
        try {
            if (f50462a != null) {
                ProgressDialogFragment progressDialogFragment = f50462a;
                if (progressDialogFragment == null) {
                    Intrinsics.throwNpe();
                }
                progressDialogFragment.dismiss();
            }
            f50462a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
}
