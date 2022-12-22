package com.didi.soda.customer.blocks.actions;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2*\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/BusinessPageActionInterceptor;", "Lcom/didi/soda/customer/blocks/actions/ActionInterceptor;", "()V", "intercept", "", "pageName", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActionInterceptor.kt */
public final class BusinessPageActionInterceptor implements ActionInterceptor {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[Catch:{ Exception -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean intercept(java.lang.String r4, com.didi.app.nova.skeleton.ScopeContext r5, java.util.HashMap<java.lang.String, java.lang.Object> r6) {
        /*
            r3 = this;
            java.lang.String r5 = "pageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            r5 = 0
            r0 = 0
            if (r6 != 0) goto L_0x000c
        L_0x000a:
            r1 = r0
            goto L_0x0024
        L_0x000c:
            java.lang.String r1 = "businessType"
            java.lang.Object r1 = r6.get(r1)     // Catch:{ Exception -> 0x006a }
            if (r1 != 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x006a }
            if (r1 != 0) goto L_0x001c
            goto L_0x000a
        L_0x001c:
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x006a }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x006a }
        L_0x0024:
            java.lang.String r2 = "businessPage"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r2)     // Catch:{ Exception -> 0x006a }
            if (r4 == 0) goto L_0x006e
            r4 = 3
            if (r1 != 0) goto L_0x0030
            goto L_0x006e
        L_0x0030:
            int r2 = r1.intValue()     // Catch:{ Exception -> 0x006a }
            if (r2 != r4) goto L_0x006e
            java.lang.String r4 = "shopId"
            java.lang.Object r4 = r6.get(r4)     // Catch:{ Exception -> 0x006a }
            if (r4 != 0) goto L_0x0041
            r4 = r0
            goto L_0x0045
        L_0x0041:
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x006a }
        L_0x0045:
            com.didi.soda.business.BusinessOpen$Companion r2 = com.didi.soda.business.BusinessOpen.Companion     // Catch:{ Exception -> 0x006a }
            com.didi.soda.business.BusinessOpen r4 = r2.create(r4)     // Catch:{ Exception -> 0x006a }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x006a }
            com.didi.soda.business.BusinessOpen r4 = r4.businessType(r1)     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = "url"
            java.lang.Object r6 = r6.get(r1)     // Catch:{ Exception -> 0x006a }
            if (r6 != 0) goto L_0x005d
            goto L_0x0061
        L_0x005d:
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x006a }
        L_0x0061:
            com.didi.soda.business.BusinessOpen r4 = r4.url(r0)     // Catch:{ Exception -> 0x006a }
            r4.open()     // Catch:{ Exception -> 0x006a }
            r5 = 1
            goto L_0x006e
        L_0x006a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.actions.BusinessPageActionInterceptor.intercept(java.lang.String, com.didi.app.nova.skeleton.ScopeContext, java.util.HashMap):boolean");
    }
}
