package com.didi.payment.commonsdk.widget;

import android.text.InputFilter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/payment/commonsdk/widget/WalletAmountEditText$maxAmountInputFilter$1", "Landroid/text/InputFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletAmountEditText.kt */
public final class WalletAmountEditText$maxAmountInputFilter$1 implements InputFilter {
    final /* synthetic */ WalletAmountEditText this$0;

    WalletAmountEditText$maxAmountInputFilter$1(WalletAmountEditText walletAmountEditText) {
        this.this$0 = walletAmountEditText;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[Catch:{ Exception -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022 A[Catch:{ Exception -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039 A[Catch:{ Exception -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ Exception -> 0x00d7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence filter(java.lang.CharSequence r3, int r4, int r5, android.text.Spanned r6, int r7, int r8) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d7 }
            if (r6 != 0) goto L_0x000a
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00d7 }
            goto L_0x000c
        L_0x000a:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00d7 }
        L_0x000c:
            r1.<init>(r6)     // Catch:{ Exception -> 0x00d7 }
            r6 = 0
            if (r3 != 0) goto L_0x0014
        L_0x0012:
            r3 = r6
            goto L_0x001f
        L_0x0014:
            java.lang.CharSequence r3 = r3.subSequence(r4, r5)     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x001b
            goto L_0x0012
        L_0x001b:
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d7 }
        L_0x001f:
            if (r3 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r3 = r0
        L_0x0023:
            r1.replace(r7, r8, r3)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r4 = "builder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x00d7 }
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x00d7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00d7 }
            r5 = 0
            if (r4 == 0) goto L_0x005a
            com.didi.payment.commonsdk.widget.WalletAmountEditText r3 = r2.this$0     // Catch:{ Exception -> 0x00d7 }
            kotlin.jvm.functions.Function1 r3 = r3.getOnAmountValidListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x0042
            goto L_0x0049
        L_0x0042:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r4)     // Catch:{ Exception -> 0x00d7 }
        L_0x0049:
            com.didi.payment.commonsdk.widget.WalletAmountEditText r3 = r2.this$0     // Catch:{ Exception -> 0x00d7 }
            kotlin.jvm.functions.Function1 r3 = r3.getOnExceedListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x0052
            goto L_0x0059
        L_0x0052:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r4)     // Catch:{ Exception -> 0x00d7 }
        L_0x0059:
            return r6
        L_0x005a:
            com.didi.payment.commonsdk.widget.WalletAmountEditText r4 = r2.this$0     // Catch:{ Exception -> 0x00d7 }
            com.didi.payment.commonsdk.ui.helper.NFloatInputHelper r7 = r4.getFloatInputHelper()     // Catch:{ Exception -> 0x00d7 }
            float r3 = r7.parseFloatValue(r3)     // Catch:{ Exception -> 0x00d7 }
            r7 = 0
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0086
            kotlin.jvm.functions.Function1 r3 = r4.getOnAmountValidListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x0070
            goto L_0x0077
        L_0x0070:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r7)     // Catch:{ Exception -> 0x00d7 }
        L_0x0077:
            kotlin.jvm.functions.Function1 r3 = r4.getOnExceedListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x007e
            goto L_0x0085
        L_0x007e:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r4)     // Catch:{ Exception -> 0x00d7 }
        L_0x0085:
            return r6
        L_0x0086:
            int r7 = r4.getMaxValue()     // Catch:{ Exception -> 0x00d7 }
            r8 = 1
            if (r7 < 0) goto L_0x00b6
            int r3 = com.didi.payment.base.utils.MathUtil.dollarToCent((float) r3)     // Catch:{ Exception -> 0x00d7 }
            int r7 = r4.getMaxValue()     // Catch:{ Exception -> 0x00d7 }
            if (r3 <= r7) goto L_0x00b6
            kotlin.jvm.functions.Function1 r3 = r4.getOnAmountValidListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x009e
            goto L_0x00a5
        L_0x009e:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r5)     // Catch:{ Exception -> 0x00d7 }
        L_0x00a5:
            kotlin.jvm.functions.Function1 r3 = r4.getOnExceedListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x00ac
            goto L_0x00b3
        L_0x00ac:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r4)     // Catch:{ Exception -> 0x00d7 }
        L_0x00b3:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00d6
        L_0x00b6:
            kotlin.jvm.functions.Function1 r3 = r4.getOnAmountValidListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x00bd
            goto L_0x00c4
        L_0x00bd:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r7)     // Catch:{ Exception -> 0x00d7 }
        L_0x00c4:
            kotlin.jvm.functions.Function1 r3 = r4.getOnExceedListener()     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x00cb
            goto L_0x00d2
        L_0x00cb:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x00d7 }
            r3.invoke(r4)     // Catch:{ Exception -> 0x00d7 }
        L_0x00d2:
            r3 = r6
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x00d7 }
            r0 = r3
        L_0x00d6:
            return r0
        L_0x00d7:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.commonsdk.widget.WalletAmountEditText$maxAmountInputFilter$1.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }
}
