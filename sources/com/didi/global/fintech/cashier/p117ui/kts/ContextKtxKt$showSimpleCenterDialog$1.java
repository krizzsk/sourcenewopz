package com.didi.global.fintech.cashier.p117ui.kts;

import androidx.fragment.app.DialogFragment;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierAlertDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/global/fintech/cashier/ui/kts/ContextKtxKt$showSimpleCenterDialog$1", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierAlertDialog$OnBtnClickListener;", "onBtnClick", "", "fragment", "Landroidx/fragment/app/DialogFragment;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.kts.ContextKtxKt$showSimpleCenterDialog$1 */
/* compiled from: ContextKtx.kt */
public final class ContextKtxKt$showSimpleCenterDialog$1 implements GlobalCashierAlertDialog.OnBtnClickListener {
    final /* synthetic */ Function0<Unit> $positiveClick;

    ContextKtxKt$showSimpleCenterDialog$1(Function0<Unit> function0) {
        this.$positiveClick = function0;
    }

    public void onBtnClick(DialogFragment dialogFragment) {
        Function0<Unit> function0 = this.$positiveClick;
        if (function0 != null) {
            function0.invoke();
        }
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }
}
