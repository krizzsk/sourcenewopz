package com.didi.global.fintech.cashier.core;

import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, mo175978d2 = {"isInnerChannel", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "isThirdChannel", "cashier_core_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierContants.kt */
public final class GlobalCashierContantsKt {
    public static final boolean isThirdChannel(BasicPayment basicPayment) {
        Intrinsics.checkNotNullParameter(basicPayment, "<this>");
        Integer channelId = basicPayment.getChannelId();
        return channelId != null && channelId.intValue() == 212;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = r2.getChannelId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r2 = r2.getChannelId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isInnerChannel(com.didi.global.fintech.cashier.model.net.response.BasicPayment r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.Integer r0 = r2.getChannelId()
            if (r0 != 0) goto L_0x000c
            goto L_0x0014
        L_0x000c:
            int r0 = r0.intValue()
            r1 = 190(0xbe, float:2.66E-43)
            if (r0 == r1) goto L_0x0035
        L_0x0014:
            java.lang.Integer r0 = r2.getChannelId()
            r1 = 120(0x78, float:1.68E-43)
            if (r0 != 0) goto L_0x001d
            goto L_0x0023
        L_0x001d:
            int r0 = r0.intValue()
            if (r0 == r1) goto L_0x0035
        L_0x0023:
            java.lang.Integer r2 = r2.getChannelId()
            r0 = 150(0x96, float:2.1E-43)
            if (r2 != 0) goto L_0x002c
            goto L_0x0033
        L_0x002c:
            int r2 = r2.intValue()
            if (r2 != r0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.GlobalCashierContantsKt.isInnerChannel(com.didi.global.fintech.cashier.model.net.response.BasicPayment):boolean");
    }
}
