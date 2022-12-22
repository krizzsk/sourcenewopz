package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "index", "", "it", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierMainPresenter.kt */
final class GlobalCashierMainPresenter$onPayChannelClick$1 extends Lambda implements Function2<Integer, Payment, Boolean> {
    final /* synthetic */ Payment $balance;

    /* renamed from: $d */
    final /* synthetic */ ChannelItemViewHolderData f21447$d;
    final /* synthetic */ GlobalCashierMainPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierMainPresenter$onPayChannelClick$1(ChannelItemViewHolderData channelItemViewHolderData, GlobalCashierMainPresenter globalCashierMainPresenter, Payment payment) {
        super(2);
        this.f21447$d = channelItemViewHolderData;
        this.this$0 = globalCashierMainPresenter;
        this.$balance = payment;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Payment) obj2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        if ((r0 == null ? false : kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.isEnough(), (java.lang.Object) true)) != false) goto L_0x0126;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(int r9, com.didi.global.fintech.cashier.model.net.response.Payment r10) {
        /*
            r8 = this;
            java.lang.String r9 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            r9 = 0
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData r0 = r8.f21447$d     // Catch:{ Exception -> 0x0023 }
            java.lang.Integer r0 = r0.getUniqueId()     // Catch:{ Exception -> 0x0023 }
            int r1 = r10.uniqueId()     // Catch:{ Exception -> 0x0023 }
            if (r0 != 0) goto L_0x0013
            goto L_0x0027
        L_0x0013:
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0023 }
            if (r0 != r1) goto L_0x0027
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter r0 = r8.this$0     // Catch:{ Exception -> 0x0023 }
            com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter r0 = (com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter) r0     // Catch:{ Exception -> 0x0023 }
            r1 = 2
            r2 = 0
            com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter.DefaultImpls.omegaPayMethodCk$default(r0, r10, r9, r1, r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0027:
            int r0 = r10.uniqueId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "onPayChannelClick: "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            r2 = 4
            r5 = 0
            r7 = 113(0x71, float:1.58E-43)
            java.lang.String r3 = "Arirus"
            java.lang.String r6 = "com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onPayChannelClick$1"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData r0 = r8.f21447$d
            java.lang.Integer r0 = r0.getUniqueId()
            int r1 = r10.uniqueId()
            r2 = 1
            if (r0 != 0) goto L_0x004f
            goto L_0x005e
        L_0x004f:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x005e
            boolean r10 = r10.getSelected()
            if (r10 != 0) goto L_0x0126
            r9 = 1
            goto L_0x0126
        L_0x005e:
            com.didi.global.fintech.cashier.model.net.response.Payment r0 = r8.$balance
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x008c
            com.didi.global.fintech.cashier.model.net.response.Payment r0 = r8.$balance
            boolean r0 = r0.getSelected()
            if (r0 == 0) goto L_0x0126
            com.didi.global.fintech.cashier.model.net.response.Payment r0 = r8.$balance
            com.didi.global.fintech.cashier.model.net.response.Payment$BalanceInfo r0 = r0.getBalanceInfo()
            if (r0 != 0) goto L_0x0078
            r0 = 0
            goto L_0x0084
        L_0x0078:
            java.lang.Boolean r0 = r0.isEnough()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x0084:
            if (r0 == 0) goto L_0x0126
            boolean r9 = r10.getSelected()
            goto L_0x0126
        L_0x008c:
            com.didi.global.fintech.cashier.model.net.response.Payment r0 = r8.$balance
            if (r0 != 0) goto L_0x0092
        L_0x0090:
            r0 = 0
            goto L_0x0099
        L_0x0092:
            boolean r0 = r0.getSelected()
            if (r0 != r2) goto L_0x0090
            r0 = 1
        L_0x0099:
            if (r0 == 0) goto L_0x00b5
            com.didi.global.fintech.cashier.model.net.response.Payment r0 = r8.$balance
            com.didi.global.fintech.cashier.model.net.response.Payment$BalanceInfo r0 = r0.getBalanceInfo()
            if (r0 != 0) goto L_0x00a5
            r0 = 0
            goto L_0x00b1
        L_0x00a5:
            java.lang.Boolean r0 = r0.isEnough()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x00b1:
            if (r0 == 0) goto L_0x00b5
            goto L_0x0126
        L_0x00b5:
            com.didi.global.fintech.cashier.model.net.response.Payment r0 = r8.$balance
            if (r0 != 0) goto L_0x00bb
        L_0x00b9:
            r2 = 0
            goto L_0x00c1
        L_0x00bb:
            boolean r0 = r0.getSelected()
            if (r0 != r2) goto L_0x00b9
        L_0x00c1:
            if (r2 == 0) goto L_0x010d
            com.didi.global.fintech.cashier.model.net.response.Payment r0 = r8.$balance
            com.didi.global.fintech.cashier.model.net.response.Payment$BalanceInfo r0 = r0.getBalanceInfo()
            if (r0 != 0) goto L_0x00cd
            r0 = 0
            goto L_0x00d9
        L_0x00cd:
            java.lang.Boolean r0 = r0.isEnough()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x00d9:
            if (r0 == 0) goto L_0x010d
            r0 = r10
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r0 = (com.didi.global.fintech.cashier.model.net.response.BasicPayment) r0
            boolean r0 = com.didi.global.fintech.cashier.core.GlobalCashierContantsKt.isThirdChannel(r0)
            if (r0 == 0) goto L_0x00e5
            goto L_0x0126
        L_0x00e5:
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData r0 = r8.f21447$d
            java.lang.Integer r0 = r0.getChannelId()
            r1 = 190(0xbe, float:2.66E-43)
            if (r0 != 0) goto L_0x00f0
            goto L_0x00f6
        L_0x00f0:
            int r0 = r0.intValue()
            if (r0 == r1) goto L_0x0108
        L_0x00f6:
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData r0 = r8.f21447$d
            java.lang.Integer r0 = r0.getChannelId()
            r1 = 120(0x78, float:1.68E-43)
            if (r0 != 0) goto L_0x0101
            goto L_0x0126
        L_0x0101:
            int r0 = r0.intValue()
            if (r0 == r1) goto L_0x0108
            goto L_0x0126
        L_0x0108:
            boolean r9 = r10.getSelected()
            goto L_0x0126
        L_0x010d:
            r0 = r10
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r0 = (com.didi.global.fintech.cashier.model.net.response.BasicPayment) r0
            boolean r0 = com.didi.global.fintech.cashier.core.GlobalCashierContantsKt.isThirdChannel(r0)
            if (r0 == 0) goto L_0x0117
            goto L_0x0126
        L_0x0117:
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData r0 = r8.f21447$d
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r0 = r0.getOperatorType()
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r1 = com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData.Operation.OPERATION_CHECK
            if (r0 != r1) goto L_0x0122
            goto L_0x0126
        L_0x0122:
            boolean r9 = r10.getSelected()
        L_0x0126:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onPayChannelClick$1.invoke(int, com.didi.global.fintech.cashier.model.net.response.Payment):java.lang.Boolean");
    }
}
