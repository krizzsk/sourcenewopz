package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onStatusMsgClicked$1$1 */
/* compiled from: WalletHomeV2Presenter.kt */
final class WalletHomeV2Presenter$onStatusMsgClicked$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Data $data;
    final /* synthetic */ Data $this_apply;
    final /* synthetic */ WalletHomeV2Presenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeV2Presenter$onStatusMsgClicked$1$1(Data data, WalletHomeV2Presenter walletHomeV2Presenter, Data data2) {
        super(1);
        this.$this_apply = data;
        this.this$0 = walletHomeV2Presenter;
        this.$data = data2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r14 = r14.getAccountBalance();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.lang.Integer r14) {
        /*
            r13 = this;
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r14 = r13.$this_apply
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r14 = r14.getAccountSection()
            r0 = 0
            if (r14 != 0) goto L_0x000b
        L_0x0009:
            r14 = r0
            goto L_0x0016
        L_0x000b:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountBalance r14 = r14.getAccountBalance()
            if (r14 != 0) goto L_0x0012
            goto L_0x0009
        L_0x0012:
            java.lang.String r14 = r14.getLinkUrl()
        L_0x0016:
            android.net.Uri r14 = android.net.Uri.parse(r14)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r7 = "channelId"
            int r8 = r1.findUrlIntParam(r14, r7)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r2 = "interestDetailMsg"
            java.lang.String r9 = r1.findUrlStrParam(r14, r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r2 = "balanceAmount"
            double r10 = r1.findUrlDoubleParam(r14, r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r2 = "kycStatus"
            int r12 = r1.findUrlIntParam(r14, r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r3 = "hasInterest"
            r2 = r14
            boolean r1 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion.findUrlBoolParam$default(r1, r2, r3, r4, r5, r6)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r2 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r3 = "currencyAcronym"
            java.lang.String r2 = r2.findUrlStrParam(r14, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r3 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r4 = "balanceMessage"
            java.lang.String r3 = r3.findUrlStrParam(r14, r4)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 1
            if (r4 != r5) goto L_0x007d
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r2 = r13.$this_apply
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r2 = r2.getAccountSection()
            if (r2 != 0) goto L_0x006a
        L_0x0068:
            r2 = r0
            goto L_0x0075
        L_0x006a:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r2 = r2.getAccountStatusMessage()
            if (r2 != 0) goto L_0x0071
            goto L_0x0068
        L_0x0071:
            com.didi.payment.base.view.PayRichInfo r2 = r2.getStatusMessage()
        L_0x0075:
            if (r2 != 0) goto L_0x008b
            com.didi.payment.base.view.PayRichInfo r2 = new com.didi.payment.base.view.PayRichInfo
            r2.<init>()
            goto L_0x008b
        L_0x007d:
            if (r4 != 0) goto L_0x0110
            com.didi.payment.base.view.PayRichInfo r4 = new com.didi.payment.base.view.PayRichInfo
            r4.<init>()
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            r4.text = r2
            r2 = r4
        L_0x008b:
            java.lang.String r14 = r14.toString()
            com.didi.drouter.router.Request r14 = com.didi.drouter.api.DRouter.build((java.lang.String) r14)
            java.lang.Object r14 = r14.putExtra((java.lang.String) r7, (int) r8)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r3 = "amountRichText"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r3, (java.io.Serializable) r2)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            r2 = 6
            java.lang.String r3 = "balance_tab"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r3, (int) r2)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            java.lang.String r2 = "balance_details"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r2, (java.lang.String) r9)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            java.lang.String r2 = "balance_account_status"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r2, (int) r12)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r2 = r13.$this_apply
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r2 = r2.getAccountSection()
            if (r2 != 0) goto L_0x00c5
            goto L_0x00c9
        L_0x00c5:
            com.didi.payment.base.service.IWalletService$AccountInfo r0 = r2.getAccountStatus()
        L_0x00c9:
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r2 = "balance_account_info"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r2, (java.io.Serializable) r0)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            java.lang.String r0 = "balance_amount"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r0, (double) r10)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            java.lang.String r0 = "has_interest"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r0, (boolean) r1)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r0 = r13.$this_apply
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r0.getNewFreezeSection()
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r1 = "key_block_data"
            java.lang.Object r14 = r14.putExtra((java.lang.String) r1, (java.io.Serializable) r0)
            com.didi.drouter.router.Request r14 = (com.didi.drouter.router.Request) r14
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r0 = r13.this$0
            android.app.Activity r0 = r0.f32658b
            android.content.Context r0 = (android.content.Context) r0
            r14.start(r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r14 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r0 = r13.this$0
            android.app.Activity r0 = r0.f32658b
            android.content.Context r0 = (android.content.Context) r0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r1 = r13.$data
            java.lang.String r2 = "amount"
            r14.trackHomeCardClick(r0, r1, r2)
            return
        L_0x0110:
            kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeV2Presenter$onStatusMsgClicked$1$1.invoke(java.lang.Integer):void");
    }
}
