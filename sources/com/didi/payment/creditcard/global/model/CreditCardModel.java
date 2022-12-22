package com.didi.payment.creditcard.global.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.creditcard.global.constant.GlobalServer;
import com.didi.payment.creditcard.global.model.bean.BindCardInfo;
import com.didi.payment.creditcard.global.model.bean.OCRVerifyInfo;
import com.didi.payment.creditcard.global.model.bean.PollResult;
import com.didi.payment.creditcard.global.model.bean.PublicKeyInfo;
import com.didi.payment.creditcard.global.model.bean.SignCancelCheckResult;
import com.didi.payment.creditcard.global.model.bean.SignCancelResult;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.model.bean.SignThreeDSResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawPageInfo;
import com.didi.payment.creditcard.global.model.bean.WithdrawPollResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawVerifyResult;
import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;
import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class CreditCardModel {

    /* renamed from: a */
    private Context f30361a;

    /* renamed from: b */
    private GlobalCreditCardService f30362b;

    /* renamed from: c */
    private GlobalCreditCardSecService f30363c;

    public CreditCardModel(Context context) {
        this.f30361a = context;
        this.f30362b = (GlobalCreditCardService) new RpcServiceFactory(context).newRpcService(GlobalCreditCardService.class, GlobalServer.GLOBAL_HOST);
        this.f30363c = (GlobalCreditCardSecService) new RpcServiceFactory(context).newRpcService(GlobalCreditCardSecService.class, GlobalServer.GLOBAL_SEC_HOST);
    }

    /* renamed from: a */
    private HashMap<String, Object> m21336a() {
        return PayBaseParamUtil.getHttpBaseParams(this.f30361a);
    }

    /* renamed from: b */
    private HashMap<String, Object> m21337b() {
        HashMap<String, Object> httpBaseParams = PayBaseParamUtil.getHttpBaseParams(this.f30361a);
        httpBaseParams.put("uid", PayBaseParamUtil.getParam(this.f30361a, "uid"));
        httpBaseParams.put("phone", PayBaseParamUtil.getParam(this.f30361a, "phone"));
        httpBaseParams.put("location_country", PayBaseParamUtil.getParam(this.f30361a, "country"));
        httpBaseParams.put("ostype", 1);
        httpBaseParams.put("sence", 1);
        httpBaseParams.put("terminal_id", PayBaseParamUtil.getParam(this.f30361a, "terminal_id"));
        httpBaseParams.put("product_id", PayBaseParamUtil.getParam(this.f30361a, "product_id"));
        return httpBaseParams;
    }

    public void queryPublicKey(int i, RpcService.Callback<PublicKeyInfo> callback) {
        HashMap<String, Object> a = m21336a();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_id", i);
            a.put("param", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f30362b.queryPublicKey(a, callback);
    }

    public void signCard(Map<String, Object> map, RpcService.Callback<SignResult> callback) {
        HashMap<String, Object> a = m21336a();
        a.putAll(map);
        this.f30362b.doSign(a, callback);
    }

    public void signThreeDSDetails(Map<String, Object> map, String str, String str2, String str3, String str4, String str5, String str6, RpcService.Callback<SignThreeDSResult> callback) {
        HashMap<String, Object> a = m21336a();
        a.putAll(map);
        a.put("token", str);
        a.put("cardIndex", str2);
        a.put("channelId", 150);
        HashMap hashMap = new HashMap();
        hashMap.put("cardIndex", str2);
        hashMap.put("channelId", 150);
        hashMap.put("threeDSVendor", str3);
        hashMap.put("threeDSShopper", str4);
        hashMap.put("threeDSDetails", str5);
        hashMap.put("paymentData", str6);
        this.f30362b.doSignThreeDSDetails(a, hashMap, callback);
    }

    public void cancelSign(int i, String str, RpcService.Callback<SignCancelResult> callback) {
        HashMap<String, Object> a = m21336a();
        a.put("channel_id", Integer.valueOf(i));
        a.put("card_index", str);
        a.put("utc_offset", PayBaseParamUtil.getStringParam(this.f30361a, "utc_offset"));
        this.f30362b.cancelSign(a, callback);
    }

    public void cancelSignCheck(int i, String str, RpcService.Callback<SignCancelCheckResult> callback) {
        HashMap<String, Object> a = m21336a();
        a.put("channel_id", Integer.valueOf(i));
        a.put("card_index", str);
        a.put("utc_offset", PayBaseParamUtil.getStringParam(this.f30361a, "utc_offset"));
        this.f30362b.cancelSignCheck(a, callback);
    }

    public void querySignResult(int i, String str, int i2, RpcService.Callback<PollResult> callback) {
        HashMap<String, Object> a = m21336a();
        a.put("channel_id", Integer.valueOf(i));
        a.put("card_index", str);
        a.put("polling_times", Integer.valueOf(i2));
        a.put("utc_offset", PayBaseParamUtil.getStringParam(this.f30361a, "utc_offset"));
        this.f30362b.querySignResult(a, callback);
    }

    public void ocrVerify(String str, String str2, String str3, RpcService.Callback<OCRVerifyInfo> callback) {
        HashMap<String, Object> a = m21336a();
        a.put("risk_info", str);
        a.put(AudioUploader.REQ_PARAMS.ENCRYPT_KEY, str2);
        a.put("vendor_type", str3);
        this.f30362b.orcVerify(a, callback);
    }

    public void requestBindCardSignInfo(String str, RpcService.Callback<BindCardInfo> callback) {
        HashMap<String, Object> a = m21336a();
        a.put("channel_id", 150);
        if (!TextUtils.isEmpty(str)) {
            a.put("resource_id", str);
        }
        this.f30362b.requestBindCardSignInfo(a, callback);
    }

    public void requestWithdrawInfo(String str, RpcService.Callback<WithdrawPageInfo> callback) {
        HashMap<String, Object> b = m21337b();
        b.put("card_index", str);
        this.f30363c.requestWithdrawInfo(b, callback);
    }

    public void doWithdraw(String str, RpcService.Callback<WithdrawResult> callback) {
        HashMap<String, Object> b = m21337b();
        b.put("card_index", str);
        this.f30363c.doWithdraw(b, callback);
    }

    public void pollingQueryWithdrawStatus(String str, RpcService.Callback<WithdrawPollResult> callback) {
        HashMap<String, Object> b = m21337b();
        b.put("card_index", str);
        this.f30363c.pollingQueryWithdrawStatus(b, callback);
    }

    public void verifyWithdraw(String str, String str2, String str3, RpcService.Callback<WithdrawVerifyResult> callback) {
        HashMap<String, Object> b = m21337b();
        b.put("card_index", str2);
        b.put("amountString", str);
        if (!TextUtils.isEmpty(str3)) {
            b.put("product_id", str3);
        }
        this.f30363c.verifyWithdraw(b, callback);
    }

    public void checkCardNo(String str, int i, String str2, RpcService.Callback<DidiGlobalCheckCardData.CheckCardResult> callback) {
        HashMap<String, Object> a = m21336a();
        a.put("card_index", str);
        a.put("business_id", Integer.valueOf(i));
        a.put("encrypt_card_no", str2);
        a.put("location_country", PayBaseParamUtil.getParam(this.f30361a, "country"));
        a.put("a3", PayBaseParamUtil.getParam(this.f30361a, "a3"));
        this.f30362b.checkCardNo(a, callback);
    }
}
