package com.didi.sdk.global.paypal.model;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.fastframe.entity.RpcBase;
import com.didi.sdk.global.constant.GlobalServer;
import com.didi.sdk.global.paypal.model.bean.PayPalSignCancelResult;
import com.didi.sdk.global.paypal.model.bean.PayPalSignResult;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.Gson;
import java.util.HashMap;

public class PayPalModel {

    /* renamed from: a */
    private Context f36204a;

    /* renamed from: b */
    private PayPalService f36205b;

    public PayPalModel(Context context) {
        this.f36204a = context;
        GlobalServer.initUrl();
        this.f36205b = (PayPalService) new RpcServiceFactory(context).newRpcService(PayPalService.class, GlobalServer.GLOBAL_HOST);
    }

    /* renamed from: a */
    private HashMap<String, Object> m25575a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }

    public void requestPayPalSignInfo(RpcService.Callback<PayPalSignResult> callback) {
        HashMap<String, Object> a = m25575a(this.f36204a);
        a.put("bind_type", 1);
        a.put("channel_id", 152);
        this.f36205b.requestPaypalSignInfo(a, callback);
    }

    public void cancelSign(int i, RpcService.Callback<PayPalSignCancelResult> callback) {
        HashMap<String, Object> a = m25575a(this.f36204a);
        a.put("channel_id", Integer.valueOf(i));
        this.f36205b.cancelSign(a, callback);
    }

    public void verifyPayPal(String str, RpcService.Callback<RpcBase> callback) {
        HashMap<String, Object> a = m25575a(this.f36204a);
        HashMap hashMap = new HashMap();
        hashMap.put("code", str);
        hashMap.put("channelId", 152);
        a.put("params", new Gson().toJson((Object) hashMap));
        this.f36205b.verifyPaypal(a, callback);
    }
}
