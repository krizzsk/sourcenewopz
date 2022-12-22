package com.didichuxing.security.cardverify.model;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.constant.Server;
import com.didichuxing.security.cardverify.model.bean.WithdrawPollResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawVerifyResult;
import com.didichuxing.security.cardverify.utils.ParamUtils;
import java.util.HashMap;

public class CardModel {

    /* renamed from: a */
    private Context f48938a;

    /* renamed from: b */
    private CardSecService f48939b;

    /* renamed from: c */
    private DiCardVerifyParam f48940c;

    public CardModel(Context context, DiCardVerifyParam diCardVerifyParam) {
        this.f48938a = context;
        this.f48940c = diCardVerifyParam;
        this.f48939b = (CardSecService) new RpcServiceFactory(context).newRpcService(CardSecService.class, Server.GLOBAL_SEC_HOST);
    }

    public void doWithdraw(RpcService.Callback<WithdrawResult> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(this.f48940c, hashMap);
        this.f48939b.doWithdraw(hashMap, callback);
    }

    public void pollingQueryWithdrawStatus(RpcService.Callback<WithdrawPollResult> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(this.f48940c, hashMap);
        this.f48939b.pollingQueryWithdrawStatus(hashMap, callback);
    }

    public void verifyWithdraw(String str, String str2, RpcService.Callback<WithdrawVerifyResult> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(this.f48940c, hashMap);
        hashMap.put("amountString", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("phone", str2);
        }
        this.f48939b.verifyWithdraw(hashMap, callback);
    }
}
