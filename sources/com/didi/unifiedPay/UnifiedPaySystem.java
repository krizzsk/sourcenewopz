package com.didi.unifiedPay;

import android.content.Context;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.api.IUnifiedPayApi;
import com.didi.unifiedPay.sdk.internal.api.UnifiedMerchantPayApiImpl;
import com.didi.unifiedPay.sdk.internal.api.UnifiedNonTripPayApiImpl;
import com.didi.unifiedPay.sdk.internal.api.UnifiedTripPayApiImpl;

public class UnifiedPaySystem {

    /* renamed from: com.didi.unifiedPay.UnifiedPaySystem$1 */
    static /* synthetic */ class C144331 {

        /* renamed from: $SwitchMap$com$didi$unifiedPay$sdk$internal$PayConstant$PayBillType */
        static final /* synthetic */ int[] f44362xf898f1eb;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType[] r0 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44362xf898f1eb = r0
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.Trip     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f44362xf898f1eb     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.NoneTrip     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f44362xf898f1eb     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.Merchant     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.UnifiedPaySystem.C144331.<clinit>():void");
        }
    }

    public static IUnifiedPayApi createUnifiedPay(Context context, PayConstant.PayBillType payBillType) {
        int i = C144331.f44362xf898f1eb[payBillType.ordinal()];
        if (i == 1) {
            return new UnifiedTripPayApiImpl(context);
        }
        if (i == 2) {
            return new UnifiedNonTripPayApiImpl(context);
        }
        if (i != 3) {
            return null;
        }
        return new UnifiedMerchantPayApiImpl(context);
    }

    private UnifiedPaySystem() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }
}
