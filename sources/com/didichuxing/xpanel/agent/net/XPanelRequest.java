package com.didichuxing.xpanel.agent.net;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.xpanel.AbsXPanel;
import com.didichuxing.xpanel.agent.NetworkCache;
import com.didichuxing.xpanel.debug.models.DebugInfo;
import com.didichuxing.xpanel.util.LimitQueue;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.util.XPanelApolloUtil;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class XPanelRequest {
    public static final String AGENT_FIRST_SERVER = "";
    public static final String AGENT_OFFLINE = "";
    public static final String AGENT_OFFLINE_JAPAN = "";
    public static final String AGENT_OFFLINE_MEXICO = "";
    public static final String AGENT_ONLINE = "https://ct.didiglobal.com//agent/v2/feeds";
    public static final String AGENT_ONLINE_GLOBAL = "https://ctv3.didiglobal.com/agent/v3/feeds";
    public static final String AGENT_ONLINE_HOST = "https://ctv3.didiglobal.com/";
    public static final String AGENT_QA = "";
    public static final String JAPAN = "JAPAN";

    /* renamed from: b */
    private static final String f49305b = "https://ctv3.didiglobal.com/";

    /* renamed from: d */
    private static final String f49306d = "passenger/pXpanelFeeds";

    /* renamed from: h */
    private static XPanelRequest f49307h = null;
    public static boolean isV3 = true;
    public static LimitQueue<DebugInfo> mDebugInfos = new LimitQueue<>(10);
    public static String mDebugUrl = "https://ctv3.didiglobal.com/";
    public static String sBaseUrl = "https://ctv3.didiglobal.com/";

    /* renamed from: a */
    RpcServiceFactory f49308a;

    /* renamed from: c */
    private boolean f49309c = false;

    /* renamed from: e */
    private XPanelRequestService f49310e;

    /* renamed from: f */
    private XPanelRequestService f49311f;

    /* renamed from: g */
    private Context f49312g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public HashMap<String, Object> f49313i;

    public interface ISuccess {
        boolean onSuccessAndIntercept(String str);
    }

    private XPanelRequest(Context context) {
        this.f49312g = context;
        this.f49308a = new RpcServiceFactory(context);
        m35565a();
    }

    /* renamed from: a */
    private void m35565a() {
        this.f49309c = true;
        this.f49311f = (XPanelRequestService) this.f49308a.newRpcService(XPanelRequestService.class, sBaseUrl);
        this.f49310e = (XPanelRequestService) this.f49308a.newRpcService(XPanelRequestService.class, mDebugUrl);
    }

    public static void reDefineURL(String str) {
        m35566a(str);
    }

    /* renamed from: a */
    private static void m35566a(String str) {
        if (!sBaseUrl.equals(str)) {
            sBaseUrl = str;
            if ("https://ctv3.didiglobal.com/".equals(str)) {
                mDebugUrl = AGENT_ONLINE;
            }
            if ("https://ctv3.didiglobal.com/".equals(sBaseUrl)) {
                mDebugUrl = AGENT_ONLINE_GLOBAL;
            }
            XPanelRequest xPanelRequest = f49307h;
            if (xPanelRequest != null) {
                xPanelRequest.m35565a();
            }
        }
    }

    public static void changeDebugURL(String str) {
        if (!mDebugUrl.equals(str)) {
            mDebugUrl = str;
            XPanelRequest xPanelRequest = f49307h;
            if (xPanelRequest != null) {
                xPanelRequest.m35565a();
            }
        }
    }

    public static XPanelRequest getInstance(Context context) {
        if (f49307h == null) {
            f49307h = new XPanelRequest(context.getApplicationContext());
        }
        return f49307h;
    }

    public void getXPanelConfig(boolean z, HashMap<String, Object> hashMap, ResponseListener<XPanelResponse> responseListener, XPanelResponse xPanelResponse, ISuccess iSuccess) {
        boolean z2 = true;
        if (Utils.isDebug(this.f49312g) || XPanelApolloUtil.isXPanelXdbgEnable()) {
            hashMap.put("x_dbg", 1);
        }
        this.f49313i = hashMap;
        if (!z) {
            String cache = NetworkCache.getInstance().getCache(hashMap);
            if (!TextUtils.isEmpty(cache)) {
                getRpcCallback(true, hashMap, this.f49312g, responseListener, xPanelResponse, iSuccess).onSuccess(cache);
                return;
            }
        }
        if (XPanelApolloUtil.getUseBffEnabled() != 1) {
            z2 = false;
        }
        final RpcService.Callback<String> rpcCallback = getRpcCallback(false, hashMap, this.f49312g, responseListener, xPanelResponse, iSuccess);
        if (z2) {
            IBffProxy.Ability build = new IBffProxy.Ability.Builder(this.f49312g, f49306d).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    if (jsonObject == null) {
                        rpcCallback.onFailure(new IOException("result is null."));
                        return;
                    }
                    LogcatUtil.m35796i("XPanelRequest", "@onSuccess bff ability back");
                    rpcCallback.onSuccess(jsonObject.toString());
                }

                public void onFailure(IOException iOException) {
                    rpcCallback.onFailure(iOException);
                }
            }).build();
            LogcatUtil.m35796i("XPanelRequest", "start request bff ability: passenger/pXpanelFeeds");
            Bff.call(build);
        } else if (isV3) {
            this.f49311f.getAgentv3(hashMap, rpcCallback);
        } else {
            this.f49311f.getAgent(hashMap, rpcCallback);
        }
    }

    public void queryUpdate(HashMap<String, Object> hashMap, ResponseListener responseListener, BaseObject baseObject) {
        this.f49311f.queryUpdateCard(hashMap, getRpcCallback(false, hashMap, this.f49312g, responseListener, baseObject, (ISuccess) null));
    }

    /* access modifiers changed from: protected */
    public RpcService.Callback<String> getRpcCallback(boolean z, HashMap<String, Object> hashMap, Context context, ResponseListener responseListener, BaseObject baseObject, ISuccess iSuccess) {
        final boolean z2 = z;
        final HashMap<String, Object> hashMap2 = hashMap;
        final ISuccess iSuccess2 = iSuccess;
        final BaseObject baseObject2 = baseObject;
        final ResponseListener responseListener2 = responseListener;
        return new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                if (!z2) {
                    NetworkCache.getInstance().putCache(hashMap2, str);
                }
                ISuccess iSuccess = iSuccess2;
                if (iSuccess == null || !iSuccess.onSuccessAndIntercept(str)) {
                    baseObject2.parse(str);
                    if (responseListener2 != null) {
                        if (AbsXPanel.mIsDebug) {
                            XPanelRequest.mDebugInfos.offer(new DebugInfo(str, XPanelRequest.this.f49313i, XPanelRequest.mDebugUrl));
                        }
                        if (!baseObject2.isAvailable()) {
                            NetworkCache.getInstance().clearCache(hashMap2);
                            responseListener2.onFail(baseObject2);
                            responseListener2.onFinish(baseObject2);
                            return;
                        }
                        responseListener2.onSuccess(baseObject2);
                        responseListener2.onFinish(baseObject2);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                baseObject2.setErrorCode(-900);
                if (AbsXPanel.mIsDebug) {
                    XPanelRequest.mDebugInfos.offer(new DebugInfo((String) null, XPanelRequest.this.f49313i, XPanelRequest.mDebugUrl));
                }
                baseObject2.setThrowable(iOException);
                ResponseListener responseListener = responseListener2;
                if (responseListener != null) {
                    responseListener.onError(baseObject2);
                    responseListener2.onFinish(baseObject2);
                }
            }
        };
    }

    public boolean isNeedReload() {
        return this.f49309c;
    }

    public void setReloadStatus(boolean z) {
        this.f49309c = z;
    }
}
