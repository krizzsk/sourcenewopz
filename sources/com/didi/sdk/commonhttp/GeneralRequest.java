package com.didi.sdk.commonhttp;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.CommonParamsUtil;
import com.didi.sdk.util.MD5;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class GeneralRequest {
    public static String BASE_COMMON_URL = "https://common.didiglobal.com/";

    /* renamed from: a */
    private C12141a f35649a;

    /* renamed from: b */
    private Context f35650b;

    public GeneralRequest(Context context, String str) {
        this.f35650b = context;
        context.getApplicationContext();
        this.f35649a = (C12141a) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(C12141a.class, str);
    }

    public GeneralRequest(Context context) {
        this.f35650b = context;
        context.getApplicationContext();
        this.f35649a = (C12141a) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(C12141a.class, BASE_COMMON_URL);
    }

    public void getShareTripInfo(String str, int i, final RpcService.Callback<String> callback) {
        SortedParams sortedParams = new SortedParams();
        m25250a(sortedParams, "token", NationTypeUtil.getNationComponentData().getLoginInfo().getKDToken());
        m25250a(sortedParams, "oid", str);
        m25250a(sortedParams, ServerParam.PARAM_PRODUCT_TYPE, Integer.valueOf(i));
        m25250a(sortedParams, "sign", MD5.toMD5(sortedParams.getNormalSortedUrlParamsString() + "&key=wNPucqgFYdj1").toLowerCase());
        HashMap<String, Object> addCommonParam = CommonParamsUtil.addCommonParam(new HashMap(), DIDIBaseApplication.getAppContext());
        addCommonParam.putAll(sortedParams);
        Bff.call(new IBffProxy.Ability.Builder(this.f35650b, "ibt-sec-heimdallr/getContent").setParams(addCommonParam).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                RpcService.Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (jsonObject != null) {
                    callback.onSuccess(jsonObject.toString());
                } else {
                    callback.onFailure(new IOException("value == null"));
                }
            }

            public void onFailure(IOException iOException) {
                RpcService.Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(iOException);
                }
            }
        }).build());
    }

    /* renamed from: a */
    private void m25250a(SortedParams sortedParams, String str, Object obj) {
        if (sortedParams != null && !TextUtils.isEmpty(str) && obj != null) {
            sortedParams.put(str, obj.toString());
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Object> createBaseParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("lang", NationTypeUtil.getNationComponentData().getLocaleCode());
        return hashMap;
    }
}
