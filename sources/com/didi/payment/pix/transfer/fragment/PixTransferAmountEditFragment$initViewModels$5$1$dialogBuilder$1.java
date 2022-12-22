package com.didi.payment.pix.transfer.fragment;

import android.os.Bundle;
import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.transfer.p141vm.model.BankAccountMetaData;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment$initViewModels$5$1$dialogBuilder$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
public final class PixTransferAmountEditFragment$initViewModels$5$1$dialogBuilder$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    PixTransferAmountEditFragment$initViewModels$5$1$dialogBuilder$1(PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        this.this$0 = pixTransferAmountEditFragment;
    }

    public void doClick(View view) {
        BankAccountMetaData access$getBankAccountMeta$p = this.this$0.f31257w;
        if (access$getBankAccountMeta$p != null) {
            PixTransferAmountEditFragment pixTransferAmountEditFragment = this.this$0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("pix_transfer", true);
            bundle.putString("name", access$getBankAccountMeta$p.getPayeeName());
            bundle.putString("cpf", access$getBankAccountMeta$p.getCpf());
            bundle.putString("bank_name", access$getBankAccountMeta$p.getPspName());
            bundle.putString("bank_code", access$getBankAccountMeta$p.getPspId());
            bundle.putString("bank_card", access$getBankAccountMeta$p.getCardNo());
            bundle.putString("agent_code", access$getBankAccountMeta$p.getAgency());
            ((Request) DRouter.build("99pay://one/transfertobank").putExtras(bundle)).start(pixTransferAmountEditFragment.getActivity());
        }
    }
}
