package com.didi.global.fintech.cashier.core.utils;

import android.content.Context;

public class GlobalBubbleShowHelper {

    public enum BubbleType {
        FastPay
    }

    /* renamed from: com.didi.global.fintech.cashier.core.utils.GlobalBubbleShowHelper$1 */
    static /* synthetic */ class C84631 {

        /* renamed from: $SwitchMap$com$didi$global$fintech$cashier$core$utils$GlobalBubbleShowHelper$BubbleType */
        static final /* synthetic */ int[] f21490x435d3d26;

        static {
            int[] iArr = new int[BubbleType.values().length];
            f21490x435d3d26 = iArr;
            try {
                iArr[BubbleType.FastPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static boolean show(Context context, BubbleType bubbleType) {
        if (C84631.f21490x435d3d26[bubbleType.ordinal()] != 1) {
            return true;
        }
        boolean z = GlobalCashierSPUtil.getBoolean(context, bubbleType.name(), true);
        GlobalCashierSPUtil.putBoolean(context, bubbleType.name(), false);
        return z;
    }
}
