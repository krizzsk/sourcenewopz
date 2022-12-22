package com.didi.unifiedPay.sdk.net;

import android.content.Context;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.sdk.net.service.UniPayMerchantHttpServiceImpl;
import com.didi.unifiedPay.sdk.net.service.UniPayNonTripHttpServiceImpl;
import com.didi.unifiedPay.sdk.net.service.UniPayTripHttpServiceImpl;

public class UnipayServiceFactory {
    private Context mContext;

    private UnipayServiceFactory(Context context) {
        this.mContext = context;
    }

    public static UnipayServiceFactory createUnipayServiceFactory(Context context) {
        return new UnipayServiceFactory(context);
    }

    /* renamed from: com.didi.unifiedPay.sdk.net.UnipayServiceFactory$1 */
    static /* synthetic */ class C144881 {

        /* renamed from: $SwitchMap$com$didi$unifiedPay$sdk$internal$PayConstant$PayBillType */
        static final /* synthetic */ int[] f44568xf898f1eb;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType[] r0 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44568xf898f1eb = r0
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.Trip     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f44568xf898f1eb     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.NoneTrip     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f44568xf898f1eb     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.Merchant     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.sdk.net.UnipayServiceFactory.C144881.<clinit>():void");
        }
    }

    public IUnipayService getService(PayConstant.PayBillType payBillType) {
        int i = C144881.f44568xf898f1eb[payBillType.ordinal()];
        if (i == 1) {
            return new UniPayTripHttpServiceImpl(this.mContext);
        }
        if (i == 2) {
            return new UniPayNonTripHttpServiceImpl(this.mContext);
        }
        if (i != 3) {
            return null;
        }
        return new UniPayMerchantHttpServiceImpl(this.mContext);
    }
}
