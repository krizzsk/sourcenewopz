package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1 */
/* compiled from: WalletHomeV2Presenter.kt */
final class WalletHomeV2Presenter$onConsumeItemClicked$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Entry $data;
    final /* synthetic */ Entry $item;
    final /* synthetic */ WalletHomeV2Presenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeV2Presenter$onConsumeItemClicked$1$1(WalletHomeV2Presenter walletHomeV2Presenter, Entry entry, Entry entry2) {
        super(1);
        this.this$0 = walletHomeV2Presenter;
        this.$data = entry;
        this.$item = entry2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r12 = r12.getAccountSection();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.lang.Integer r12) {
        /*
            r11 = this;
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r12 = r11.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r12 = r12.f32661e
            r0 = 0
            if (r12 != 0) goto L_0x000b
        L_0x0009:
            r12 = r0
            goto L_0x0016
        L_0x000b:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r12 = r12.getAccountSection()
            if (r12 != 0) goto L_0x0012
            goto L_0x0009
        L_0x0012:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.DisposalSection r12 = r12.getDisposalSection()
        L_0x0016:
            r1 = 1
            r2 = 0
            if (r12 == 0) goto L_0x005f
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r12 = r11.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r12 = r12.f32661e
            if (r12 != 0) goto L_0x0024
        L_0x0022:
            r12 = 0
            goto L_0x0039
        L_0x0024:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r12 = r12.getAccountSection()
            if (r12 != 0) goto L_0x002b
            goto L_0x0022
        L_0x002b:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.DisposalSection r12 = r12.getDisposalSection()
            if (r12 != 0) goto L_0x0032
            goto L_0x0022
        L_0x0032:
            boolean r12 = r12.getHasPreBlock()
            if (r12 != r1) goto L_0x0022
            r12 = 1
        L_0x0039:
            if (r12 == 0) goto L_0x005f
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r12 = r11.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r3 = r11.$data
            java.lang.String r4 = r3.getProductLine()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r5 = r11.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r5 = r5.f32661e
            if (r5 != 0) goto L_0x004d
        L_0x004b:
            r5 = r0
            goto L_0x0058
        L_0x004d:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r5 = r5.getAccountSection()
            if (r5 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.DisposalSection r5 = r5.getDisposalSection()
        L_0x0058:
            boolean r12 = r12.m23106a(r3, r4, r5)
            if (r12 == 0) goto L_0x005f
            return
        L_0x005f:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r12 = r11.$data
            java.lang.String r12 = r12.getProductLine()
            if (r12 != 0) goto L_0x0069
            r12 = 0
            goto L_0x006d
        L_0x0069:
            int r12 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r12, r2, r1, r0)
        L_0x006d:
            java.lang.Boolean r12 = com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil.isBitcoin(r12)
            java.lang.String r3 = "isBitcoin(data.productLine?.toDefaultInt() ?: 0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0094
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r12 = r11.this$0
            android.app.Activity r12 = r12.f32658b
            android.content.Context r12 = (android.content.Context) r12
            java.lang.Boolean r12 = com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil.checkBitcoinWelPage(r12)
            java.lang.String r3 = "checkBitcoinWelPage(mContext)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0094
            return
        L_0x0094:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r12 = r11.$data
            java.lang.String r12 = r12.getProductLine()
            if (r12 != 0) goto L_0x009e
        L_0x009c:
            r12 = 0
            goto L_0x00a7
        L_0x009e:
            int r12 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r12, r2, r1, r0)
            r3 = 606(0x25e, float:8.49E-43)
            if (r12 != r3) goto L_0x009c
            r12 = 1
        L_0x00a7:
            if (r12 == 0) goto L_0x00b6
            boolean r12 = com.didi.payment.base.utils.WalletApolloUtil.isBoletoScanOptEnable()
            if (r12 != 0) goto L_0x00b6
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r12 = r11.$data
            java.lang.String r3 = "99pay://one/consume/scan"
            r12.setLinkUrl(r3)
        L_0x00b6:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r12 = r11.$data
            java.lang.String r12 = r12.getLinkUrl()
            if (r12 != 0) goto L_0x00c0
        L_0x00be:
            r12 = 0
            goto L_0x00ce
        L_0x00c0:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.String r3 = "/prepayCard_banner"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 2
            boolean r12 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r12, (java.lang.CharSequence) r3, (boolean) r2, (int) r4, (java.lang.Object) r0)
            if (r12 != r1) goto L_0x00be
            r12 = 1
        L_0x00ce:
            if (r12 == 0) goto L_0x0120
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r12 = r11.$data
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r3 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r5 = r11.$data
            java.lang.String r5 = r5.getLinkUrl()
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r6 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.HOME_SKU
            java.lang.String r6 = r6.getValue()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r7 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            java.lang.String r8 = r7.getStatus()
            java.lang.String r7 = "home_page"
            java.lang.String r9 = "1"
            java.lang.String r10 = ""
            java.lang.String r4 = r4.buildPrepaidUrl(r5, r6, r7, r8, r9, r10)
            java.lang.String r3 = r3.buildWalletUrl(r4)
            r12.setLinkUrl(r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r4 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r12 = r11.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r12 = r12.f32661e
            if (r12 != 0) goto L_0x0105
        L_0x0103:
            r5 = r0
            goto L_0x0118
        L_0x0105:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r12 = r12.getAccountSection()
            if (r12 != 0) goto L_0x010c
            goto L_0x0103
        L_0x010c:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.PrepaidStatus r12 = r12.getMarketingArea()
            if (r12 != 0) goto L_0x0113
            goto L_0x0103
        L_0x0113:
            java.lang.Integer r12 = r12.getType()
            r5 = r12
        L_0x0118:
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r6 = "fin_prepaidcard_SKU_ck"
            com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager.Companion.trackCardPrepaidApply$default(r4, r5, r6, r7, r8, r9)
        L_0x0120:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r12 = r11.$data
            java.lang.String r12 = r12.getLinkUrl()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r3 = r11.$data
            java.lang.String r3 = r3.getProductLine()
            if (r3 != 0) goto L_0x0130
        L_0x012e:
            r3 = 0
            goto L_0x0139
        L_0x0130:
            int r3 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r3, r2, r1, r0)
            r4 = 665(0x299, float:9.32E-43)
            if (r3 != r4) goto L_0x012e
            r3 = 1
        L_0x0139:
            if (r3 == 0) goto L_0x0147
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r12 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r3 = r11.$data
            java.lang.String r3 = r3.getLinkUrl()
            java.lang.String r12 = r12.buildWalletUrl(r3)
        L_0x0147:
            com.didi.drouter.router.Request r12 = com.didi.drouter.api.DRouter.build((java.lang.String) r12)
            java.lang.String r3 = "build(routerUrl)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r3 = r11.$data
            com.didi.payment.base.view.PayRichInfo r3 = r3.getPromotionText()
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x015b
            goto L_0x0161
        L_0x015b:
            java.lang.String r3 = r3.text
            if (r3 != 0) goto L_0x0160
            goto L_0x0161
        L_0x0160:
            r4 = r3
        L_0x0161:
            java.lang.String r3 = "activity_text"
            r12.putExtra((java.lang.String) r3, (java.lang.String) r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r3 = r11.$item
            java.lang.String r3 = r3.getProductLine()
            if (r3 != 0) goto L_0x016f
            goto L_0x0177
        L_0x016f:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt.toDefaultInt$default(r3, r2, r1, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0177:
            java.io.Serializable r0 = (java.io.Serializable) r0
            java.lang.String r2 = "product_line"
            r12.putExtra((java.lang.String) r2, (java.io.Serializable) r0)
            java.lang.String r0 = "page_refer"
            java.lang.String r2 = "wallet_home"
            r12.putExtra((java.lang.String) r0, (java.lang.String) r2)
            com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil.putBitcoinExtra(r12)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r0 = r11.$data
            java.lang.String r0 = r0.getLinkUrl()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r2 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r3 = "crashPageTitle"
            java.lang.String r2 = r2.findUrlStrParam(r0, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r3 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r4 = "crashPageText"
            java.lang.String r3 = r3.findUrlStrParam(r0, r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r4 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r5 = "crashType"
            java.lang.String r4 = r4.findUrlStrParam(r0, r5)
            java.lang.String r5 = "crash_page_title"
            r12.putExtra((java.lang.String) r5, (java.lang.String) r2)
            java.lang.String r2 = "crash_page_subtitle"
            r12.putExtra((java.lang.String) r2, (java.lang.String) r3)
            java.lang.String r2 = "crash_type"
            r12.putExtra((java.lang.String) r2, (java.lang.String) r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r2 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r3 = "tracker"
            java.lang.String r2 = r2.findUrlStrParam(r0, r3)
            com.didi.payment.base.tracker.PayTracker.trackEvent(r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r2 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletUriParam.Companion
            java.lang.String r3 = "refresh"
            int r0 = r2.findUrlIntParam(r0, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1 r2 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r3 = r11.this$0
            r2.<init>(r3)
            if (r0 != r1) goto L_0x01e3
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r0 = r11.this$0
            android.app.Activity r0 = r0.f32658b
            android.content.Context r0 = (android.content.Context) r0
            com.didi.drouter.router.RouterCallback r2 = (com.didi.drouter.router.RouterCallback) r2
            r12.start(r0, r2)
            goto L_0x01ee
        L_0x01e3:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r0 = r11.this$0
            android.app.Activity r0 = r0.f32658b
            android.content.Context r0 = (android.content.Context) r0
            r12.start(r0)
        L_0x01ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1.invoke(java.lang.Integer):void");
    }
}
