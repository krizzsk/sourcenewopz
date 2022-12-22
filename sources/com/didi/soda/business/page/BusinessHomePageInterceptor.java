package com.didi.soda.business.page;

import com.didi.soda.router.IInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/business/page/BusinessHomePageInterceptor;", "Lcom/didi/soda/router/IInterceptor;", "()V", "intercept", "", "request", "Lcom/didi/soda/router/Request;", "p1", "Lcom/didi/soda/router/Response;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessHomePageInterceptor.kt */
public final class BusinessHomePageInterceptor implements IInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "BusinessHomePageInterceptor";

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean intercept(com.didi.soda.router.Request r7, com.didi.soda.router.Response r8) {
        /*
            r6 = this;
            r8 = 0
            if (r7 != 0) goto L_0x0005
            r7 = r8
            goto L_0x0009
        L_0x0005:
            android.os.Bundle r7 = r7.getExtras()
        L_0x0009:
            java.lang.String r0 = "BusinessHomePageInterceptor"
            r1 = 0
            r2 = 1
            if (r7 != 0) goto L_0x0018
            java.lang.String r7 = "未传入页面信息"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29102e((java.lang.String) r0, (java.lang.String) r7)
        L_0x0015:
            r1 = 1
            goto L_0x00c4
        L_0x0018:
            java.lang.String r3 = "shopid"
            java.lang.String r3 = r7.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x002c
            int r3 = r3.length()
            if (r3 != 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r3 = 0
            goto L_0x002d
        L_0x002c:
            r3 = 1
        L_0x002d:
            if (r3 == 0) goto L_0x0036
            java.lang.String r7 = "未传入shopId"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29102e((java.lang.String) r0, (java.lang.String) r7)
            goto L_0x0015
        L_0x0036:
            java.lang.String r0 = "scenetype"
            java.lang.String r3 = r7.getString(r0)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x004a
            int r4 = r3.length()
            if (r4 != 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r4 = 0
            goto L_0x004b
        L_0x004a:
            r4 = 1
        L_0x004b:
            java.lang.String r5 = "null"
            if (r4 != 0) goto L_0x0058
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0058
            r3 = 1
            goto L_0x0059
        L_0x0058:
            r3 = 0
        L_0x0059:
            if (r3 == 0) goto L_0x0069
            java.lang.String r0 = r7.getString(r0)
            int r0 = com.didi.soda.customer.foundation.util.NumberParseUtil.parseInt(r0)
            java.lang.String r3 = "sceneType"
            r7.putInt(r3, r0)
        L_0x0069:
            java.lang.String r0 = "businesstype"
            java.lang.String r3 = r7.getString(r0)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x007c
            int r4 = r3.length()
            if (r4 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r4 = 0
            goto L_0x007d
        L_0x007c:
            r4 = 1
        L_0x007d:
            if (r4 != 0) goto L_0x0088
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0088
            r3 = 1
            goto L_0x0089
        L_0x0088:
            r3 = 0
        L_0x0089:
            if (r3 == 0) goto L_0x0098
            java.lang.String r0 = r7.getString(r0)
            int r0 = com.didi.soda.customer.foundation.util.NumberParseUtil.parseInt(r0)
            java.lang.String r3 = "businessType"
            r7.putInt(r3, r0)
        L_0x0098:
            java.lang.String r0 = "orderid"
            java.lang.String r3 = r7.getString(r0)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x00ac
            int r4 = r3.length()
            if (r4 != 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r4 = 0
            goto L_0x00ad
        L_0x00ac:
            r4 = 1
        L_0x00ad:
            if (r4 != 0) goto L_0x00b7
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            if (r2 == 0) goto L_0x00c4
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r2 = "orderId"
            r7.putString(r2, r0)
        L_0x00c4:
            if (r1 == 0) goto L_0x00e5
            r7 = 2131954376(0x7f130ac8, float:1.954525E38)
            java.lang.String r7 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r7)
            com.didi.soda.customer.foundation.util.ToastUtil.showCustomerErrorToast(r8, r7)
            java.lang.String r7 = "sailing_c_business_home_page_interceptor_error"
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r7 = com.didi.soda.customer.foundation.tracker.error.ErrorTracker.create(r7)
            java.lang.String r8 = "shop"
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker$Builder r7 = r7.addModuleName(r8)
            com.didi.soda.customer.foundation.tracker.error.ErrorTracker r7 = r7.build()
            r7.trackError()
        L_0x00e5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.page.BusinessHomePageInterceptor.intercept(com.didi.soda.router.Request, com.didi.soda.router.Response):boolean");
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/business/page/BusinessHomePageInterceptor$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessHomePageInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
