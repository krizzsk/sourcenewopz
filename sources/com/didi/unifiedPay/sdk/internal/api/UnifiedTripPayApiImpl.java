package com.didi.unifiedPay.sdk.internal.api;

import android.content.Context;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.net.UnipayServiceFactory;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.sdk.net.service.UniPayTripHttpServiceImpl;

public class UnifiedTripPayApiImpl extends AbsUnifiedPayApi {

    /* renamed from: c */
    private UniPayTripHttpServiceImpl f44565c;

    public UnifiedTripPayApiImpl(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public IUnipayService createService(Context context) {
        UniPayTripHttpServiceImpl uniPayTripHttpServiceImpl = (UniPayTripHttpServiceImpl) UnipayServiceFactory.createUnipayServiceFactory(context).getService(PayConstant.PayBillType.Trip);
        this.f44565c = uniPayTripHttpServiceImpl;
        return uniPayTripHttpServiceImpl;
    }

    /* access modifiers changed from: protected */
    public void initService() {
        this.f44565c.init(this.mBid, this.mOid);
    }
}
