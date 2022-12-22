package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultPayViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultPresenter;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierResultPayViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierResultPayViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierResultPayViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultPayViewBinder;", "presenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultPresenter;)V", "disableBtn", "", "setupView", "data", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierResultPayViewBinder.kt */
public final class GlobalCashierResultPayViewBinder extends GlobalCashierBaseViewBinder<IGlobalCashierResultPayViewHolder, IGlobalCashierResultPresenter, SuccessInfoResponse> implements IGlobalCashierResultPayViewBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierResultPayViewBinder(IGlobalCashierResultPresenter iGlobalCashierResultPresenter) {
        super(iGlobalCashierResultPresenter);
        Intrinsics.checkNotNullParameter(iGlobalCashierResultPresenter, "presenter");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setupView(com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse r11) {
        /*
            r10 = this;
            super.setupView(r11)
            r0 = 0
            if (r11 != 0) goto L_0x0007
            goto L_0x000d
        L_0x0007:
            com.didi.global.fintech.cashier.model.net.response.ResultPriceInfo r1 = r11.getPriceInfo()
            if (r1 != 0) goto L_0x0011
        L_0x000d:
            r1 = r0
            r7 = r1
            goto L_0x0083
        L_0x0011:
            com.didi.global.fintech.cashier.model.net.response.PriceAmount r2 = r1.getActualAmount()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x001a
            goto L_0x0020
        L_0x001a:
            java.util.List r2 = r2.getSplit()
            if (r2 != 0) goto L_0x0023
        L_0x0020:
            r6 = r0
            r7 = r6
            goto L_0x0047
        L_0x0023:
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r6 = r0
            r7 = r6
            r5 = 0
        L_0x002c:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0047
            java.lang.Object r8 = r2.next()
            int r9 = r5 + 1
            if (r5 >= 0) goto L_0x003d
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x003d:
            java.lang.String r8 = (java.lang.String) r8
            if (r5 != 0) goto L_0x0042
            r6 = r8
        L_0x0042:
            if (r5 != r4) goto L_0x0045
            r7 = r8
        L_0x0045:
            r5 = r9
            goto L_0x002c
        L_0x0047:
            java.util.List r1 = r1.getAdditionalInfo()
            if (r1 == 0) goto L_0x0081
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0059:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0081
            java.lang.Object r5 = r2.next()
            int r8 = r3 + 1
            if (r3 >= 0) goto L_0x006a
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x006a:
            com.didi.global.fintech.cashier.model.net.response.ResultPriceInfo$ResultAdditionalInfo r5 = (com.didi.global.fintech.cashier.model.net.response.ResultPriceInfo.ResultAdditionalInfo) r5
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            int r5 = r1.size()
            int r5 = r5 - r4
            if (r3 == r5) goto L_0x007f
            java.lang.String r3 = "\n"
            r0.append(r3)
        L_0x007f:
            r3 = r8
            goto L_0x0059
        L_0x0081:
            r1 = r0
            r0 = r6
        L_0x0083:
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r2 = r10.getViewHolder()
            com.didi.global.fintech.cashier.ui.IGlobalCashierResultPayViewHolder r2 = (com.didi.global.fintech.cashier.p117ui.IGlobalCashierResultPayViewHolder) r2
            if (r2 != 0) goto L_0x008c
            goto L_0x008f
        L_0x008c:
            r2.updateAmountInfo(r0, r7, r1)
        L_0x008f:
            if (r11 != 0) goto L_0x0092
            goto L_0x00b7
        L_0x0092:
            java.util.List r0 = r11.getPayments()
            if (r0 != 0) goto L_0x0099
            goto L_0x00b7
        L_0x0099:
            com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser$Companion r1 = com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser.Companion
            com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder$setupView$2$1 r2 = new com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder$setupView$2$1
            com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser$Companion r3 = com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser.Companion
            r2.<init>(r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.util.List r0 = r1.parseDataList(r0, r2)
            if (r0 != 0) goto L_0x00ab
            goto L_0x00b7
        L_0x00ab:
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r1 = r10.getViewHolder()
            com.didi.global.fintech.cashier.ui.IGlobalCashierResultPayViewHolder r1 = (com.didi.global.fintech.cashier.p117ui.IGlobalCashierResultPayViewHolder) r1
            if (r1 != 0) goto L_0x00b4
            goto L_0x00b7
        L_0x00b4:
            r1.updatePaymentMethod(r0)
        L_0x00b7:
            if (r11 != 0) goto L_0x00ba
            goto L_0x00e5
        L_0x00ba:
            com.didi.global.fintech.cashier.model.net.response.ReturnButton r11 = r11.getButton()
            if (r11 != 0) goto L_0x00c1
            goto L_0x00e5
        L_0x00c1:
            com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser$Companion r0 = com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser.Companion
            com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder$setupView$3$1 r1 = new com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder$setupView$3$1
            com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser$Companion r2 = com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser.Companion
            r1.<init>(r2)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r11 = r0.parseData(r11, r1)
            com.didi.global.fintech.cashier.ui.viewholder.MerchantButtonData r11 = (com.didi.global.fintech.cashier.p117ui.viewholder.MerchantButtonData) r11
            com.didi.global.fintech.cashier.ui.IGlobalCashierBaseViewHolder r0 = r10.getViewHolder()
            com.didi.global.fintech.cashier.ui.IGlobalCashierResultPayViewHolder r0 = (com.didi.global.fintech.cashier.p117ui.IGlobalCashierResultPayViewHolder) r0
            if (r0 != 0) goto L_0x00db
            goto L_0x00e5
        L_0x00db:
            com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder$setupView$3$2$1 r1 = new com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder$setupView$3$2$1
            r1.<init>(r10, r11)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.updateReturnButton(r11, r1)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder.setupView(com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse):void");
    }

    public void disableBtn() {
        IGlobalCashierResultPayViewHolder iGlobalCashierResultPayViewHolder = (IGlobalCashierResultPayViewHolder) getViewHolder();
        if (iGlobalCashierResultPayViewHolder != null) {
            iGlobalCashierResultPayViewHolder.disableReturnButton();
        }
    }
}
