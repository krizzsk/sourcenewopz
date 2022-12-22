package com.didi.soda.goods.page;

import com.didi.soda.router.IInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/goods/page/GoodsPurchasePageInterceptor;", "Lcom/didi/soda/router/IInterceptor;", "()V", "intercept", "", "request", "Lcom/didi/soda/router/Request;", "response", "Lcom/didi/soda/router/Response;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GoodsPurchasePageInterceptor.kt */
public final class GoodsPurchasePageInterceptor implements IInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "GoodsPurchasePageInterceptor";

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/goods/page/GoodsPurchasePageInterceptor$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GoodsPurchasePageInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if ((r2 == null || r2.length() == 0) != false) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean intercept(com.didi.soda.router.Request r7, com.didi.soda.router.Response r8) {
        /*
            r6 = this;
            r8 = 0
            if (r7 != 0) goto L_0x0004
            return r8
        L_0x0004:
            android.os.Bundle r7 = r7.getExtras()
            java.lang.String r0 = "GoodsPurchasePageInterceptor"
            if (r7 != 0) goto L_0x0014
            java.lang.String r7 = "未传入商品信息"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29102e((java.lang.String) r0, (java.lang.String) r7)
            goto L_0x009b
        L_0x0014:
            java.lang.String r1 = "shopid"
            java.lang.Object r1 = r7.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "itemid"
            java.lang.Object r2 = r7.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "itementity"
            java.lang.Object r3 = r7.get(r3)
            com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity r3 = (com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity) r3
            java.lang.String r4 = "cartitementity"
            java.lang.Object r4 = r7.get(r4)
            r5 = 1
            if (r3 != 0) goto L_0x005d
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0043
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r1 = 0
            goto L_0x0044
        L_0x0043:
            r1 = 1
        L_0x0044:
            if (r1 != 0) goto L_0x0056
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0053
            int r1 = r2.length()
            if (r1 != 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r1 = 0
            goto L_0x0054
        L_0x0053:
            r1 = 1
        L_0x0054:
            if (r1 == 0) goto L_0x0068
        L_0x0056:
            java.lang.String r1 = "未指定结构体时，必须传入shopId和itemId"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29102e((java.lang.String) r0, (java.lang.String) r1)
            goto L_0x0066
        L_0x005d:
            com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity r1 = r3.node
            if (r1 != 0) goto L_0x0068
            java.lang.String r1 = "item node == null"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29102e((java.lang.String) r0, (java.lang.String) r1)
        L_0x0066:
            r1 = 1
            goto L_0x0069
        L_0x0068:
            r1 = 0
        L_0x0069:
            r2 = 0
            if (r4 == 0) goto L_0x008e
            java.lang.String r3 = "cart_id"
            java.lang.Object r7 = r7.get(r3)
            boolean r3 = r7 instanceof java.lang.String
            if (r3 == 0) goto L_0x0079
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x007a
        L_0x0079:
            r7 = r2
        L_0x007a:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0084
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0085
        L_0x0084:
            r8 = 1
        L_0x0085:
            if (r8 == 0) goto L_0x008e
            java.lang.String r7 = "cart not null, cartId is empty"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29102e((java.lang.String) r0, (java.lang.String) r7)
            r8 = 1
            goto L_0x008f
        L_0x008e:
            r8 = r1
        L_0x008f:
            if (r8 == 0) goto L_0x009b
            r7 = 2131954137(0x7f1309d9, float:1.9544765E38)
            java.lang.String r7 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r7)
            com.didi.soda.customer.foundation.util.ToastUtil.showCustomerErrorToast(r2, r7)
        L_0x009b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.goods.page.GoodsPurchasePageInterceptor.intercept(com.didi.soda.router.Request, com.didi.soda.router.Response):boolean");
    }
}
