package com.didi.payment.wallet.global.wallet.view.widget;

import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletBalanceTypeAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/widget/BalanceTypeDialogFragment$initView$2", "Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletBalanceTypeAdapter$ItemClickListener;", "onItemClick", "", "item", "Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BalanceTypeDialogFragment.kt */
public final class BalanceTypeDialogFragment$initView$2 implements WalletBalanceTypeAdapter.ItemClickListener {
    final /* synthetic */ BalanceTypeDialogFragment this$0;

    BalanceTypeDialogFragment$initView$2(BalanceTypeDialogFragment balanceTypeDialogFragment) {
        this.this$0 = balanceTypeDialogFragment;
    }

    public void onItemClick(WalletBalanceOption walletBalanceOption) {
        Intrinsics.checkNotNullParameter(walletBalanceOption, "item");
        Function1<WalletBalanceOption, Unit> timeListener = this.this$0.getTimeListener();
        if (timeListener != null) {
            timeListener.invoke(walletBalanceOption);
        }
        this.this$0.dismiss();
    }
}
