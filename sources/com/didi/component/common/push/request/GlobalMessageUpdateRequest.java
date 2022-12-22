package com.didi.component.common.push.request;

import com.didi.app.delegate.MsgGateService;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.p071io.IOUtils;
import org.json.JSONObject;

public class GlobalMessageUpdateRequest extends BaseRequest {

    /* renamed from: a */
    private static final String f11706a = "https://msggate.didiglobal.com/";

    /* renamed from: b */
    private final HttpRpcClient f11707b = ((HttpRpcClient) new RpcServiceFactory(DIDIApplication.getAppContext()).getRpcClient("http"));

    public GlobalMessageUpdateRequest() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new Runnable() {
            public void run() {
                SystemUtils.setProcessThreadPriority(10);
            }
        });
        this.f11707b.newBuilder().setExecutorService(newSingleThreadExecutor);
    }

    public void uploadPushId(String str, final RpcService.Callback<String> callback) {
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        if (loginInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("p_id", str);
            hashMap.put("state", 3);
            hashMap.put(ServerParam.PARAM_APP_TYPE_PUSH, AppUtils.getMetaDataByKey(EventKeys.APP_FCM_APPKEY));
            hashMap.put("token", loginInfo.getToken());
            this.f11707b.newRpc(new HttpRpcRequest.Builder().get(m7930a(MsgGateService.URL, hashMap)).build()).enqueue(new HttpRpc.Callback() {
                public void onSuccess(HttpRpcResponse httpRpcResponse) {
                    try {
                        String iOUtils = IOUtils.toString(httpRpcResponse.getEntity().getContent(), "utf-8");
                        int optInt = new JSONObject(iOUtils).optInt("errno", -1);
                        if (optInt != 0) {
                            OmegaSDKAdapter.trackEvent("Msggate_Upload_Failed");
                            if (callback != null) {
                                RpcService.Callback callback = callback;
                                callback.onFailure(new IOException("errno = " + optInt));
                            }
                        } else if (callback != null) {
                            callback.onSuccess(iOUtils);
                        }
                    } catch (Exception e) {
                        OmegaSDKAdapter.trackEvent("Msggate_Upload_Failed");
                        RpcService.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onFailure(new IOException(e.getMessage()));
                        }
                        e.printStackTrace();
                    }
                }

                public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                    OmegaSDKAdapter.trackEvent("Msggate_Upload_Failed");
                    RpcService.Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(iOException);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private String m7930a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder(str);
        boolean z = true;
        for (String next : map.keySet()) {
            if (!(next == null || map.get(next) == null)) {
                if (z) {
                    z = false;
                    sb.append("?");
                } else {
                    sb.append(ParamKeys.SIGN_AND);
                }
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
            }
        }
        return sb.toString();
    }
}
