package com.didi.soda.bill.dialog;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ<\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u000f0\u0016j\u0002`\u00172\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\u000f0\u0016j\u0002`\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/bill/dialog/PayErrorGuideDialogHelper;", "", "()V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "payFailGuideFloatingView", "Lcom/didi/soda/bill/dialog/PayFailGuideFloatingView;", "shopId", "getShopId", "setShopId", "hidePayFailGuideView", "", "showPayFailGuideView", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "alert", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "recommendPayCallback", "Lkotlin/Function0;", "Lcom/didi/soda/bill/dialog/RecommendPayCallback;", "otherPayCallback", "Lcom/didi/soda/bill/dialog/OtherPayCallback;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayErrorGuideDialogHelper.kt */
public final class PayErrorGuideDialogHelper {

    /* renamed from: a */
    private String f38990a;

    /* renamed from: b */
    private String f38991b;

    /* renamed from: c */
    private PayFailGuideFloatingView f38992c;

    public final String getCartId() {
        return this.f38990a;
    }

    public final void setCartId(String str) {
        this.f38990a = str;
    }

    public final String getShopId() {
        return this.f38991b;
    }

    public final void setShopId(String str) {
        this.f38991b = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0040, code lost:
        r2 = r2.payChannel;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showPayFailGuideView(com.didi.app.nova.skeleton.ScopeContext r4, com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r5, kotlin.jvm.functions.Function0<kotlin.Unit> r6, kotlin.jvm.functions.Function0<kotlin.Unit> r7) {
        /*
            r3 = this;
            java.lang.String r0 = "scopeContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "recommendPayCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "otherPayCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            if (r5 != 0) goto L_0x0015
            goto L_0x005f
        L_0x0015:
            r3.hidePayFailGuideView()
            r0 = 0
            r3.f38992c = r0
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r1 = new com.didi.soda.bill.dialog.PayFailGuideFloatingView
            r1.<init>()
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r6 = r1.setRecommendCallback(r6)
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r6 = r6.setOtherPayCallback(r7)
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r6 = r6.setAlertEntity(r5)
            r3.f38992c = r6
            com.didi.soda.bill.BillOmegaHelper$Companion r6 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r7 = r3.getCartId()
            java.lang.String r1 = r3.getShopId()
            com.didi.soda.customer.foundation.rpc.entity.bill.AlertExtraEntity r2 = r5.getExtra()
            if (r2 != 0) goto L_0x0040
        L_0x003e:
            r2 = r0
            goto L_0x004b
        L_0x0040:
            com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r2 = r2.payChannel
            if (r2 != 0) goto L_0x0045
            goto L_0x003e
        L_0x0045:
            int r2 = r2.channelId
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x004b:
            com.didi.soda.customer.foundation.rpc.entity.bill.AlertExtraEntity r5 = r5.getExtra()
            if (r5 != 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            java.lang.String r0 = r5.payChannelRecommendList
        L_0x0054:
            r6.tracePayErrorGuideDialogSW(r7, r1, r2, r0)
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r5 = r3.f38992c
            if (r5 != 0) goto L_0x005c
            goto L_0x005f
        L_0x005c:
            r5.show(r4)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.dialog.PayErrorGuideDialogHelper.showPayFailGuideView(com.didi.app.nova.skeleton.ScopeContext, com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    public final void hidePayFailGuideView() {
        PayFailGuideFloatingView payFailGuideFloatingView = this.f38992c;
        if (payFailGuideFloatingView != null) {
            payFailGuideFloatingView.dismiss();
        }
    }
}
