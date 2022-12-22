package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.UserAgreementSection;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/holder/ProtocolViewHolder$onBindViewHolder$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.ProtocolViewHolder$onBindViewHolder$1 */
/* compiled from: ProtocolViewHolder.kt */
public final class ProtocolViewHolder$onBindViewHolder$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ WalletHomeHolderData<UserAgreementSection> $info;
    final /* synthetic */ ProtocolViewHolder this$0;

    ProtocolViewHolder$onBindViewHolder$1(ProtocolViewHolder protocolViewHolder, WalletHomeHolderData<UserAgreementSection> walletHomeHolderData) {
        this.this$0 = protocolViewHolder;
        this.$info = walletHomeHolderData;
    }

    public void doClick(View view) {
        Context context = this.this$0.itemView.getContext();
        if (context != null) {
            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
            UserAgreementSection contentObj = this.$info.getContentObj();
            WebBrowserUtil.startInternalWebActivity(baseContext, contentObj == null ? null : contentObj.getLinkUrl(), "");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    }
}
