package com.didi.payment.paymethod.server.global;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.paymethod.server.global.request.BalanceQueryReq;
import com.didi.payment.paymethod.server.global.request.SignCancelReq;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.request.SignReq;
import com.didi.payment.paymethod.server.global.response.BalanceQueryResp;
import com.didi.payment.paymethod.server.global.response.SignCancelResp;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.server.global.response.SignResultResp;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;

public class GlobalPayMethodModel implements IGlobalPayMethodModel {

    /* renamed from: a */
    private static final String f30963a = "channel_id";

    /* renamed from: b */
    private static final String f30964b = "bind_type";

    /* renamed from: c */
    private static final String f30965c = "polling_times";

    /* renamed from: d */
    private static final String f30966d = "https://pay.didiglobal.com";

    /* renamed from: e */
    private Context f30967e;

    /* renamed from: f */
    private GlobalRpcService f30968f;

    public GlobalPayMethodModel(Context context) {
        this.f30967e = context;
        this.f30968f = (GlobalRpcService) new RpcServiceFactory(context).newRpcService(GlobalRpcService.class, "https://pay.didiglobal.com");
    }

    /* renamed from: a */
    private HashMap<String, Object> m21753a() {
        return PayBaseParamUtil.getHttpBaseParams(this.f30967e);
    }

    public void sign(SignReq signReq, RpcService.Callback<SignResultResp> callback) {
        if (signReq != null && callback != null) {
            HashMap<String, Object> a = m21753a();
            a.put("bind_type", Integer.valueOf(signReq.bindType));
            a.put("channel_id", Integer.valueOf(signReq.channelId));
            this.f30968f.sign(a, callback);
        }
    }

    public void cancelSign(SignCancelReq signCancelReq, RpcService.Callback<SignCancelResp> callback) {
        if (signCancelReq != null && callback != null) {
            HashMap<String, Object> a = m21753a();
            a.put("channel_id", Integer.valueOf(signCancelReq.channelId));
            this.f30968f.cancelSign(a, callback);
        }
    }

    public void pollSignStatus(SignPollingQueryReq signPollingQueryReq, RpcService.Callback<SignPollingQueryResp> callback) {
        if (signPollingQueryReq != null && callback != null) {
            HashMap<String, Object> a = m21753a();
            a.put("channel_id", Integer.valueOf(signPollingQueryReq.channelId));
            a.put("polling_times", Integer.valueOf(signPollingQueryReq.pollingTimes));
            this.f30968f.pollSignStatus(a, callback);
        }
    }

    public void queryBalance(BalanceQueryReq balanceQueryReq, RpcService.Callback<BalanceQueryResp> callback) {
        if (balanceQueryReq != null && callback != null) {
            HashMap<String, Object> a = m21753a();
            a.put("channel_id", Integer.valueOf(balanceQueryReq.channelId));
            this.f30968f.queryBalance(a, callback);
        }
    }
}
