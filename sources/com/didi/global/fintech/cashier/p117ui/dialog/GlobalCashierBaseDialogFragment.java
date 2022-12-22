package com.didi.global.fintech.cashier.p117ui.dialog;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "handler", "Landroid/os/Handler;", "dismiss", "", "dismissAllowingStateLoss", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierBaseDialogFragment */
/* compiled from: GlobalCashierBaseDialogFragment.kt */
public abstract class GlobalCashierBaseDialogFragment extends DialogFragment {

    /* renamed from: a */
    private final Handler f21708a = new Handler(Looper.getMainLooper());

    public void show(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        if (TextUtils.isEmpty(str)) {
            str = "_global_cashier_dialog";
        }
        this.f21708a.post(new Runnable(str, this) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ GlobalCashierBaseDialogFragment f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GlobalCashierBaseDialogFragment.m15813a(FragmentManager.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15813a(FragmentManager fragmentManager, String str, GlobalCashierBaseDialogFragment globalCashierBaseDialogFragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$manager");
        Intrinsics.checkNotNullParameter(globalCashierBaseDialogFragment, "this$0");
        if (!fragmentManager.isDestroyed()) {
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (!Intrinsics.areEqual((Object) findFragmentByTag, (Object) globalCashierBaseDialogFragment)) {
                if (findFragmentByTag instanceof DialogFragment) {
                    ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
                }
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
                try {
                    beginTransaction.add((Fragment) globalCashierBaseDialogFragment, str);
                    beginTransaction.commitAllowingStateLoss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }

    public void dismissAllowingStateLoss() {
        this.f21708a.removeCallbacksAndMessages((Object) null);
        this.f21708a.post(new Runnable() {
            public final void run() {
                GlobalCashierBaseDialogFragment.m15814a(GlobalCashierBaseDialogFragment.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15814a(GlobalCashierBaseDialogFragment globalCashierBaseDialogFragment) {
        Intrinsics.checkNotNullParameter(globalCashierBaseDialogFragment, "this$0");
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
