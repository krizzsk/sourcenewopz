package com.ddmap.sdk.degrade.gnav;

import com.ddmap.sdk.degrade.ICrashListener;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/ddmap/sdk/degrade/gnav/GoogleNavDegrade$startCrashMonitor$1", "Lcom/ddmap/sdk/degrade/ICrashListener;", "onCrashed", "", "reason", "", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: GoogleNavDegrade.kt */
public final class GoogleNavDegrade$startCrashMonitor$1 implements ICrashListener {
    final /* synthetic */ GNavApollo $apollo;
    final /* synthetic */ GoogleNavDegrade this$0;

    GoogleNavDegrade$startCrashMonitor$1(GoogleNavDegrade googleNavDegrade, GNavApollo gNavApollo) {
        this.this$0 = googleNavDegrade;
        this.$apollo = gNavApollo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCrashed(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "reason"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r1 = r6.this$0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "崩溃发生 = "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.m2617f(r7)
            com.ddmap.sdk.degrade.gnav.GNavApollo r7 = r6.$apollo
            java.lang.String r1 = "apollo"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)
            java.lang.String r7 = r7.getCrashKey()
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r2 = r6.this$0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "crashKey = "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r2.m2617f(r3)
            java.lang.String r2 = "crashKey"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 2
            r4 = 0
            r5 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) r2, (boolean) r5, (int) r3, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x0058
            return
        L_0x0058:
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r0 = r6.this$0
            r0.m2613d(r7)
            com.ddmap.sdk.degrade.gnav.GNavApollo r0 = r6.$apollo
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.util.List r0 = r0.getCrashRules()
            java.util.Iterator r0 = r0.iterator()
        L_0x006a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00cc
            java.lang.Object r1 = r0.next()
            com.ddmap.sdk.degrade.gnav.crashrule.ICrashRule r1 = (com.ddmap.sdk.degrade.gnav.crashrule.ICrashRule) r1
            boolean r2 = r1 instanceof com.ddmap.sdk.degrade.gnav.crashrule.AccumulateCrashRule
            if (r2 == 0) goto L_0x009e
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r2 = r6.this$0
            org.json.JSONArray r2 = r2.m2608b(r7)
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r3 = r6.this$0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "当前累积崩溃情况 = "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.m2617f(r4)
            com.ddmap.sdk.degrade.gnav.crashrule.AccumulateCrashRule r1 = (com.ddmap.sdk.degrade.gnav.crashrule.AccumulateCrashRule) r1
            boolean r1 = r1.needDegrade((org.json.JSONArray) r2)
        L_0x009c:
            r5 = r1
            goto L_0x00c5
        L_0x009e:
            boolean r2 = r1 instanceof com.ddmap.sdk.degrade.gnav.crashrule.ContinuousCrashRule
            if (r2 == 0) goto L_0x00c5
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r2 = r6.this$0
            int r2 = r2.m2610c(r7)
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r3 = r6.this$0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "当前连续崩溃次数 = "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.m2617f(r4)
            com.ddmap.sdk.degrade.gnav.crashrule.ContinuousCrashRule r1 = (com.ddmap.sdk.degrade.gnav.crashrule.ContinuousCrashRule) r1
            boolean r1 = r1.needDegrade((int) r2)
            goto L_0x009c
        L_0x00c5:
            if (r5 == 0) goto L_0x006a
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade r7 = r6.this$0
            r7.m2612d()
        L_0x00cc:
            com.ddmap.sdk.degrade.gnav.GoogleNavDegrade$Companion r7 = com.ddmap.sdk.degrade.gnav.GoogleNavDegrade.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "是否需要降级 ："
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r7.debug(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ddmap.sdk.degrade.gnav.GoogleNavDegrade$startCrashMonitor$1.onCrashed(java.lang.String):void");
    }
}
