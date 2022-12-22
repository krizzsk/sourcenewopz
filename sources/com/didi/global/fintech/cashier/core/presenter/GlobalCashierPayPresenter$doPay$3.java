package com.didi.global.fintech.cashier.core.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
final class GlobalCashierPayPresenter$doPay$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlobalCashierPayPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPayPresenter$doPay$3(GlobalCashierPayPresenter globalCashierPayPresenter) {
        super(0);
        this.this$0 = globalCashierPayPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r15 = this;
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r0 = r15.this$0
            java.lang.Class<com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor> r1 = com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.class
            com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor r0 = r0.m15739a(r1)
            r1 = r0
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor r1 = (com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor) r1
            if (r1 != 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            r2 = 0
            r3 = 0
            r5 = 2
            r6 = 0
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.DefaultImpls.loading$default(r1, r2, r3, r5, r6)
        L_0x0016:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r15.this$0
            java.util.List r1 = r1.getMSelectPayments()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0029:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x009f
            java.lang.Object r2 = r1.next()
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo r4 = r2.getInstallment()
            if (r4 != 0) goto L_0x003e
        L_0x003c:
            r4 = r3
            goto L_0x0072
        L_0x003e:
            java.util.List r4 = r4.getSuggestPlans()
            if (r4 != 0) goto L_0x0045
            goto L_0x003c
        L_0x0045:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x004b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0068
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r6 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r6
            java.lang.Boolean r6 = r6.getSelected()
            r7 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x004b
            goto L_0x0069
        L_0x0068:
            r5 = r3
        L_0x0069:
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r5 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r5
            if (r5 != 0) goto L_0x006e
            goto L_0x003c
        L_0x006e:
            java.lang.Integer r4 = r5.getNumber()
        L_0x0072:
            java.lang.Integer r5 = r2.getChannelId()
            if (r4 == 0) goto L_0x0092
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r6 = new com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo
            r7 = 3
            r6.<init>(r3, r3, r7, r3)
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r2 = r2.getExtraInfo()
            if (r2 != 0) goto L_0x0085
            goto L_0x0089
        L_0x0085:
            java.lang.String r3 = r2.getCardIndex()
        L_0x0089:
            r6.setCardIndex(r3)
            r6.setInstallmentNumber(r4)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0096
        L_0x0092:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r6 = r2.getExtraInfo()
        L_0x0096:
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r2 = new com.didi.global.fintech.cashier.model.net.response.BasicPayment
            r2.<init>(r5, r6)
            r0.add(r2)
            goto L_0x0029
        L_0x009f:
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r15.this$0
            java.util.List r1 = r1.getMExtraPayments()
            java.util.Collection r1 = (java.util.Collection) r1
            r0.addAll(r1)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r15.this$0
            com.didi.global.fintech.cashier.model.net.request.PrepayRequest r2 = new com.didi.global.fintech.cashier.model.net.request.PrepayRequest
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 255(0xff, float:3.57E-43)
            r14 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r4 = r15.this$0
            java.lang.String r5 = r4.getMOutTradeId()
            if (r5 != 0) goto L_0x00c7
            java.lang.String r5 = ""
        L_0x00c7:
            r2.setOut_trade_id(r5)
            java.lang.String r5 = r4.getMPasswordToken()
            if (r5 != 0) goto L_0x00d1
            goto L_0x00d4
        L_0x00d1:
            r2.setPassword_token(r5)
        L_0x00d4:
            java.lang.Boolean r5 = r4.getMBoletoConfirm()
            if (r5 != 0) goto L_0x00db
            goto L_0x00e6
        L_0x00db:
            boolean r5 = r5.booleanValue()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r2.setPay_tip_confirmed(r5)
        L_0x00e6:
            java.lang.String r5 = "merchant_wsgenv"
            java.lang.Object r5 = r4.getParamByName(r5)
            java.lang.String r5 = (java.lang.String) r5
            r2.setMerchant_wsgenv(r5)
            java.util.List r5 = r2.getUser_select()
            java.util.Collection r0 = (java.util.Collection) r0
            r5.addAll(r0)
            com.didi.global.fintech.cashier.model.net.request.PrepayRequest$ThirdParty r0 = r2.getThird_party()
            com.didi.global.fintech.cashier.model.net.request.PrepayRequest$ThreeDSV2 r5 = r4.getMThreeDSV2()
            r0.setThree_ds_v2(r5)
            java.lang.String r0 = r4.getMCvv()
            r2.setCvv(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.prePay(r2)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r0 = r15.this$0
            r0.setMCvv(r3)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r0 = r15.this$0
            r0.setMPasswordToken(r3)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r0 = r15.this$0
            r0.setMThreeDSV2(r3)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r0 = r15.this$0
            r0.setMBoletoConfirm(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter$doPay$3.invoke():void");
    }
}
