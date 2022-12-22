package com.didi.unifiedPay.sdk.internal.api;

import android.content.Context;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.net.UnipayServiceFactory;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.sdk.net.service.UniPayNonTripHttpServiceImpl;

public class UnifiedNonTripPayApiImpl extends AbsUnifiedPayApi {

    /* renamed from: c */
    private UniPayNonTripHttpServiceImpl f44564c;

    public UnifiedNonTripPayApiImpl(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public IUnipayService createService(Context context) {
        UniPayNonTripHttpServiceImpl uniPayNonTripHttpServiceImpl = (UniPayNonTripHttpServiceImpl) UnipayServiceFactory.createUnipayServiceFactory(context).getService(PayConstant.PayBillType.NoneTrip);
        this.f44564c = uniPayNonTripHttpServiceImpl;
        return uniPayNonTripHttpServiceImpl;
    }

    /* access modifiers changed from: protected */
    public void initService() {
        this.f44564c.init(this.mPayParam);
    }
}
