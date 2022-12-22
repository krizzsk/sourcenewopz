package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.DisposalSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeV2Presenter$popUpKycInfoDialog$1$2", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$popUpKycInfoDialog$1$2 */
/* compiled from: WalletHomeV2Presenter.kt */
public final class WalletHomeV2Presenter$popUpKycInfoDialog$1$2 extends DoubleCheckOnClickListener {
    final /* synthetic */ Ref.ObjectRef<WalletDialog> $dialog;
    final /* synthetic */ DisposalSection $dialogData;
    final /* synthetic */ Entry $item;
    final /* synthetic */ String $productLine;
    final /* synthetic */ WalletHomeV2Presenter this$0;

    WalletHomeV2Presenter$popUpKycInfoDialog$1$2(String str, DisposalSection disposalSection, Entry entry, Ref.ObjectRef<WalletDialog> objectRef, WalletHomeV2Presenter walletHomeV2Presenter) {
        this.$productLine = str;
        this.$dialogData = disposalSection;
        this.$item = entry;
        this.$dialog = objectRef;
        this.this$0 = walletHomeV2Presenter;
    }

    public void doClick(View view) {
        WalletHomeTrackerManager.Companion companion = WalletHomeTrackerManager.Companion;
        String str = this.$productLine;
        DisposalSection disposalSection = this.$dialogData;
        companion.trackHomeKycPopupCK(str, disposalSection == null ? null : disposalSection.getBlockId(), "next time");
        Entry entry = this.$item;
        if (entry != null) {
            this.this$0.onConsumeItemClicked(entry);
        }
        WalletDialog walletDialog = (WalletDialog) this.$dialog.element;
        if (walletDialog != null) {
            walletDialog.dismiss();
        }
    }
}
