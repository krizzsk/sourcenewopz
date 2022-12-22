package com.didi.universal.pay.biz.manager;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.universal.pay.biz.model.UniversalPayItemModel;
import com.didi.universal.pay.biz.util.UniversalPayOmegaUtil;
import com.didi.universal.pay.sdk.method.model.PayInfo;
import com.didi.universal.pay.sdk.model.ThirdPayResult;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.util.DeviceUtil;
import com.didi.universal.pay.sdk.util.OmegaUtils;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversalPayOmegaManager {

    /* renamed from: a */
    private Context f45095a;

    /* renamed from: b */
    private UniversalPayParams f45096b;

    /* renamed from: c */
    private String f45097c;

    /* renamed from: d */
    private String f45098d;

    /* renamed from: e */
    private String f45099e;

    /* renamed from: f */
    private String f45100f;

    public UniversalPayOmegaManager(Context context, UniversalPayParams universalPayParams) {
        this.f45095a = context;
        this.f45096b = universalPayParams;
    }

    public void initBaseParam(PayInfo payInfo) {
        if (payInfo != null) {
            this.f45100f = payInfo.outTradeId;
            if (payInfo.billDetail != null) {
                this.f45097c = UniversalPayOmegaUtil.getCoupon(payInfo.billDetail.deductions);
                List<UniversalPayItemModel> payChannelsModel = UniversalViewModelManager.getPayChannelsModel(this.f45095a, payInfo.billDetail);
                this.f45099e = UniversalPayMethodManager.getPayMethod(payChannelsModel);
                this.f45098d = UniversalPayOmegaUtil.getPayChannel(payChannelsModel);
            }
        }
    }

    public void addFailPoint(String str, boolean z) {
        addPoint(str, z ? "noresult" : "fail", (String) null, (String) null, (ThirdPayResult) null);
    }

    public void addNormalPoint(String str) {
        addPoint(str, (String) null, (String) null, (String) null, (ThirdPayResult) null);
    }

    public void addChangePoint(String str, String str2, String str3) {
        addPoint(str, (String) null, str2, str3, (ThirdPayResult) null);
    }

    public void addThirdPayPoint(String str, ThirdPayResult thirdPayResult) {
        addPoint(str, (String) null, (String) null, (String) null, thirdPayResult);
    }

    public void addPoint(String str, String str2, String str3, String str4, ThirdPayResult thirdPayResult) {
        Object obj;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.f45096b.oid)) {
            hashMap.put("id", this.f45096b.oid);
            hashMap.put("order_id", this.f45096b.oid);
        }
        if (!TextUtils.isEmpty(this.f45100f)) {
            hashMap.put("out_trade_id", this.f45100f);
        }
        hashMap.put("payscene", Integer.valueOf(this.f45096b.isPrepay ? 2 : this.f45096b.isTrip ? 0 : 1));
        if (!TextUtils.isEmpty(this.f45099e)) {
            hashMap.put(GlobalPayOmegaConstant.EventKey.PAYMETHOD_NAME, this.f45099e);
        }
        if (!TextUtils.isEmpty(this.f45097c)) {
            hashMap.put("coupon", this.f45097c);
        }
        if (!TextUtils.isEmpty(this.f45098d)) {
            hashMap.put("channel_id", this.f45098d);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("pays", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("paym1", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("paym2", str4);
        }
        if (thirdPayResult != null) {
            hashMap.put("result", Integer.valueOf(thirdPayResult.result));
        }
        try {
            if (this.f45096b.bid > 0) {
                obj = Integer.valueOf(this.f45096b.bid);
            } else {
                obj = PayBaseParamUtil.getStringParam(this.f45095a, "product_id");
            }
            hashMap.put("business_id", obj);
            hashMap.put("uid", PayBaseParamUtil.getStringParam(this.f45095a, "uid"));
            hashMap.put("app_uni_id", DeviceUtil.getPackageName(this.f45095a));
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaUtils.trackEvent(str, (String) null, (Map<String, Object>) hashMap);
    }
}
