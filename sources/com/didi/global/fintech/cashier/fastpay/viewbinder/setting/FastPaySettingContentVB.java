package com.didi.global.fintech.cashier.fastpay.viewbinder.setting;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingContentViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingPresenter;
import com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItemData;
import com.didi.global.fintech.cashier.fastpay.viewbinder.FastPayBaseVB;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo;
import com.didi.global.fintech.cashier.p117ui.IFastPaySettingContentViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/viewbinder/setting/FastPaySettingContentVB;", "Lcom/didi/global/fintech/cashier/fastpay/viewbinder/FastPayBaseVB;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;", "Lcom/didi/global/fintech/cashier/ui/IFastPaySettingContentViewHolder;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingContentViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;)V", "curLimitIndex", "", "getCurLimitIndex", "()I", "setCurLimitIndex", "(I)V", "dialogConfirm", "", "getDialogConfirm", "()Ljava/lang/String;", "setDialogConfirm", "(Ljava/lang/String;)V", "limitItems", "", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItemData;", "onPaymentLimitClick", "", "onPaymentOrderClick", "onTermUrlClick", "setupView", "data", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySettingContentVB.kt */
public final class FastPaySettingContentVB extends FastPayBaseVB<FastPayInfoResponse, IFastPaySettingPresenter, IFastPaySettingContentViewHolder> implements IFastPaySettingContentViewBinder<FastPayInfoResponse> {

    /* renamed from: a */
    private final List<FastPayLimitItemData> f21611a = new ArrayList();

    /* renamed from: b */
    private int f21612b;

    /* renamed from: c */
    private String f21613c = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPaySettingContentVB(IFastPaySettingPresenter iFastPaySettingPresenter) {
        super(iFastPaySettingPresenter);
        Intrinsics.checkNotNullParameter(iFastPaySettingPresenter, "presenter");
    }

    public final int getCurLimitIndex() {
        return this.f21612b;
    }

    public final void setCurLimitIndex(int i) {
        this.f21612b = i;
    }

    public final String getDialogConfirm() {
        return this.f21613c;
    }

    public final void setDialogConfirm(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f21613c = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setupView(com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse r12) {
        /*
            r11 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            super.setupView(r12)
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r11.getViewHolder()
            com.didi.global.fintech.cashier.ui.IFastPaySettingContentViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IFastPaySettingContentViewHolder) r0
            r1 = 0
            if (r0 != 0) goto L_0x0012
            goto L_0x0021
        L_0x0012:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo r2 = r12.getShowInfo()
            if (r2 != 0) goto L_0x001a
            r2 = r1
            goto L_0x001e
        L_0x001a:
            java.lang.String r2 = r2.getTitle()
        L_0x001e:
            r0.updateMainTitle(r2)
        L_0x0021:
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r11.getViewHolder()
            com.didi.global.fintech.cashier.ui.IFastPaySettingContentViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IFastPaySettingContentViewHolder) r0
            if (r0 != 0) goto L_0x002a
            goto L_0x0039
        L_0x002a:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo r2 = r12.getShowInfo()
            if (r2 != 0) goto L_0x0032
            r2 = r1
            goto L_0x0036
        L_0x0032:
            java.lang.String r2 = r2.getSubTitle()
        L_0x0036:
            r0.updateSubTitle(r2)
        L_0x0039:
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r11.getViewHolder()
            com.didi.global.fintech.cashier.ui.IFastPaySettingContentViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IFastPaySettingContentViewHolder) r0
            if (r0 != 0) goto L_0x0042
            goto L_0x0051
        L_0x0042:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo r2 = r12.getShowInfo()
            if (r2 != 0) goto L_0x004a
            r2 = r1
            goto L_0x004e
        L_0x004a:
            java.lang.String r2 = r2.getIconUrl()
        L_0x004e:
            r0.updateIconUrl(r2)
        L_0x0051:
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r11.getViewHolder()
            com.didi.global.fintech.cashier.ui.IFastPaySettingContentViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IFastPaySettingContentViewHolder) r0
            if (r0 != 0) goto L_0x005a
            goto L_0x0070
        L_0x005a:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo r2 = r12.getShowInfo()
            if (r2 != 0) goto L_0x0062
            r2 = r1
            goto L_0x0066
        L_0x0062:
            java.lang.String r2 = r2.getExplain()
        L_0x0066:
            com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB$setupView$1 r3 = new com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB$setupView$1
            r3.<init>(r11)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r0.updateTermUrl(r2, r3)
        L_0x0070:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r2 = r11
            com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB r2 = (com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB) r2
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo r2 = r12.getShowInfo()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0084
        L_0x0082:
            r2 = 0
            goto L_0x0099
        L_0x0084:
            java.lang.String r2 = r2.getPaymentOrderTitle()
            if (r2 != 0) goto L_0x008b
            goto L_0x0082
        L_0x008b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0095
            r2 = 1
            goto L_0x0096
        L_0x0095:
            r2 = 0
        L_0x0096:
            if (r2 != r3) goto L_0x0082
            r2 = 1
        L_0x0099:
            if (r2 == 0) goto L_0x009d
            r2 = r11
            goto L_0x009e
        L_0x009d:
            r2 = r1
        L_0x009e:
            com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB r2 = (com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB) r2
            if (r2 != 0) goto L_0x00a3
            goto L_0x00c5
        L_0x00a3:
            com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingItem$Companion r5 = com.didi.global.fintech.cashier.p117ui.viewholder.FastPaySettingItem.Companion
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayShowInfo r6 = r12.getShowInfo()
            if (r6 != 0) goto L_0x00ad
            r6 = r1
            goto L_0x00b1
        L_0x00ad:
            java.lang.String r6 = r6.getPaymentOrderTitle()
        L_0x00b1:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r7 = 0
            com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB$setupView$3$1 r8 = new com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB$setupView$3$1
            r8.<init>(r2)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r9 = 2
            r10 = 0
            com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingItem r2 = com.didi.global.fintech.cashier.p117ui.viewholder.FastPaySettingItem.Companion.insByOrder$default(r5, r6, r7, r8, r9, r10)
            r0.add(r2)
        L_0x00c5:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit r2 = r12.getPaymentLimit()
            if (r2 == 0) goto L_0x00ec
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit r2 = r12.getPaymentLimit()
            if (r2 != 0) goto L_0x00d3
        L_0x00d1:
            r2 = 0
            goto L_0x00e8
        L_0x00d3:
            java.lang.String r2 = r2.getTitle()
            if (r2 != 0) goto L_0x00da
            goto L_0x00d1
        L_0x00da:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x00e4
            r2 = 1
            goto L_0x00e5
        L_0x00e4:
            r2 = 0
        L_0x00e5:
            if (r2 != r3) goto L_0x00d1
            r2 = 1
        L_0x00e8:
            if (r2 == 0) goto L_0x00ec
            r2 = 1
            goto L_0x00ed
        L_0x00ec:
            r2 = 0
        L_0x00ed:
            if (r2 == 0) goto L_0x00f1
            r2 = r11
            goto L_0x00f2
        L_0x00f1:
            r2 = r1
        L_0x00f2:
            com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB r2 = (com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB) r2
            if (r2 != 0) goto L_0x00f8
            goto L_0x01ae
        L_0x00f8:
            com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingItem$Companion r5 = com.didi.global.fintech.cashier.p117ui.viewholder.FastPaySettingItem.Companion
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit r6 = r12.getPaymentLimit()
            if (r6 != 0) goto L_0x0102
            r6 = r1
            goto L_0x0106
        L_0x0102:
            java.lang.String r6 = r6.getTitle()
        L_0x0106:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit r7 = r12.getPaymentLimit()
            if (r7 != 0) goto L_0x0111
        L_0x010f:
            r7 = r1
            goto L_0x011c
        L_0x0111:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimitItem r7 = r7.getCurLimit()
            if (r7 != 0) goto L_0x0118
            goto L_0x010f
        L_0x0118:
            java.lang.String r7 = r7.getAmount_display()
        L_0x011c:
            com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB$setupView$5$1 r8 = new com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB$setupView$5$1
            r8.<init>(r2)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingItem r5 = r5.insByLimit(r6, r7, r8)
            r0.add(r5)
            java.util.List<com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItemData> r5 = r2.f21611a
            r5.clear()
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit r5 = r12.getPaymentLimit()
            if (r5 != 0) goto L_0x0137
            goto L_0x019a
        L_0x0137:
            java.util.List r5 = r5.getPayLimits()
            if (r5 != 0) goto L_0x013e
            goto L_0x019a
        L_0x013e:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r6 = 0
        L_0x0145:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x019a
            java.lang.Object r7 = r5.next()
            int r8 = r6 + 1
            if (r6 >= 0) goto L_0x0156
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0156:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimitItem r7 = (com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimitItem) r7
            int r9 = r7.uniqueId()
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit r10 = r12.getPaymentLimit()
            if (r10 != 0) goto L_0x0164
        L_0x0162:
            r9 = 0
            goto L_0x0172
        L_0x0164:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimitItem r10 = r10.getCurLimit()
            if (r10 != 0) goto L_0x016b
            goto L_0x0162
        L_0x016b:
            int r10 = r10.uniqueId()
            if (r9 != r10) goto L_0x0162
            r9 = 1
        L_0x0172:
            if (r9 == 0) goto L_0x0176
            r9 = r2
            goto L_0x0177
        L_0x0176:
            r9 = r1
        L_0x0177:
            if (r9 != 0) goto L_0x017a
            goto L_0x017d
        L_0x017a:
            r2.setCurLimitIndex(r6)
        L_0x017d:
            java.util.List<com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItemData> r6 = r2.f21611a
            com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItemData r9 = new com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItemData
            r10 = 3
            r9.<init>(r1, r1, r10, r1)
            java.lang.String r10 = r7.getAmount_display()
            r9.setContent(r10)
            java.lang.String r7 = r7.getAmount()
            r9.setAmount(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            r6.add(r9)
            r6 = r8
            goto L_0x0145
        L_0x019a:
            com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayLimit r12 = r12.getPaymentLimit()
            java.lang.String r1 = ""
            if (r12 != 0) goto L_0x01a3
            goto L_0x01ab
        L_0x01a3:
            java.lang.String r12 = r12.getButton()
            if (r12 != 0) goto L_0x01aa
            goto L_0x01ab
        L_0x01aa:
            r1 = r12
        L_0x01ab:
            r2.setDialogConfirm(r1)
        L_0x01ae:
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r12 = r11.getViewHolder()
            com.didi.global.fintech.cashier.ui.IFastPaySettingContentViewHolder r12 = (com.didi.global.fintech.cashier.p117ui.IFastPaySettingContentViewHolder) r12
            if (r12 != 0) goto L_0x01b7
            goto L_0x01ba
        L_0x01b7:
            r12.updateSettingItems(r0)
        L_0x01ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.fastpay.viewbinder.setting.FastPaySettingContentVB.setupView(com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse):void");
    }

    public void onTermUrlClick() {
        FastPayShowInfo showInfo;
        IFastPaySettingPresenter iFastPaySettingPresenter = (IFastPaySettingPresenter) getPresenter();
        FastPayInfoResponse fastPayInfoResponse = (FastPayInfoResponse) getData();
        String str = null;
        if (!(fastPayInfoResponse == null || (showInfo = fastPayInfoResponse.getShowInfo()) == null)) {
            str = showInfo.getExplainUrl();
        }
        iFastPaySettingPresenter.onTermUrlClick(str);
    }

    public void onPaymentLimitClick() {
        ((IFastPaySettingPresenter) getPresenter()).onPayLimitClick(this.f21611a, this.f21612b, this.f21613c);
    }

    public void onPaymentOrderClick() {
        FastPayShowInfo showInfo;
        String paymentOrderTitle;
        IFastPaySettingPresenter iFastPaySettingPresenter = (IFastPaySettingPresenter) getPresenter();
        FastPayInfoResponse fastPayInfoResponse = (FastPayInfoResponse) getData();
        String str = "Payment Order";
        if (!(fastPayInfoResponse == null || (showInfo = fastPayInfoResponse.getShowInfo()) == null || (paymentOrderTitle = showInfo.getPaymentOrderTitle()) == null)) {
            str = paymentOrderTitle;
        }
        iFastPaySettingPresenter.onPayOrderClick(str);
    }
}
