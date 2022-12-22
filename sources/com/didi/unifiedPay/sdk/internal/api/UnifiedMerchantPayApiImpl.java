package com.didi.unifiedPay.sdk.internal.api;

import android.content.Context;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.net.UnipayServiceFactory;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.sdk.net.service.UniPayMerchantHttpServiceImpl;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.model.DPayRequest;
import org.json.JSONObject;

public class UnifiedMerchantPayApiImpl extends AbsUnifiedPayApi {

    /* renamed from: c */
    private UniPayMerchantHttpServiceImpl f44563c;
    protected DPayRequest mDPayRequest;
    protected JSONObject mExtraParams;
    protected MerchantRequestType mRequestType;

    public UnifiedMerchantPayApiImpl(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public IUnipayService createService(Context context) {
        UniPayMerchantHttpServiceImpl uniPayMerchantHttpServiceImpl = (UniPayMerchantHttpServiceImpl) UnipayServiceFactory.createUnipayServiceFactory(context).getService(PayConstant.PayBillType.Merchant);
        this.f44563c = uniPayMerchantHttpServiceImpl;
        return uniPayMerchantHttpServiceImpl;
    }

    public void setDPayRequest(DPayRequest dPayRequest) {
        this.mDPayRequest = dPayRequest;
    }

    public void setExtraParam(JSONObject jSONObject) {
        this.mExtraParams = jSONObject;
    }

    public void setRequestType(MerchantRequestType merchantRequestType) {
        this.mRequestType = merchantRequestType;
    }

    /* access modifiers changed from: protected */
    public void initService() {
        this.f44563c.init(this.mPayParam, this.mRequestType, this.mDPayRequest, this.mExtraParams);
    }
}
