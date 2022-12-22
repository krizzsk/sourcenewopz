package com.didi.xengine.request;

import android.os.Handler;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.xengine.XEngine;
import com.didi.xengine.callback.XEBizParamMapCallback;
import com.didi.xengine.model.XECallbackModel;
import com.didi.xengine.register.XEngineCallbackRegister;
import com.didiglobal.enginecore.XEngineInnerRequest;
import com.didiglobal.enginecore.callback.XEReqParamRunnableImpl;
import com.didiglobal.enginecore.callback.XERunnableCallback;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class XEParamBuilder {

    /* renamed from: a */
    private static final String f45192a = "scene";

    /* renamed from: b */
    private static final String f45193b = "biz_param";

    /* renamed from: c */
    private Map<String, XECallbackModel> f45194c = XEngineCallbackRegister.getCallbackMap();

    /* renamed from: d */
    private Map<String, XEReqParamRunnableImpl> f45195d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ThreadPoolExecutor f45196e;

    /* renamed from: f */
    private XEngine f45197f;

    private interface AsyncCallback {
        void getCallback(Map<String, Object> map);
    }

    public XEParamBuilder(XEngine xEngine) {
        this.f45197f = xEngine;
        this.f45195d = new HashMap();
        this.f45196e = new ThreadPoolExecutor(5, 50, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(50));
    }

    /* renamed from: a */
    private void m32464a(String str, AsyncCallback asyncCallback) {
        JsonObject jsonObject;
        HashMap hashMap = new HashMap();
        HashMap<String, JsonObject> buildSceneCacheData = this.f45197f.getCacheMgr() != null ? this.f45197f.getCacheMgr().buildSceneCacheData(str) : null;
        JsonParser jsonParser = new JsonParser();
        if (buildSceneCacheData != null && !buildSceneCacheData.isEmpty()) {
            for (String next : buildSceneCacheData.keySet()) {
                if ((this.f45194c.get(next) == null || (this.f45194c.get(next) != null && this.f45194c.get(next).requestParams == null)) && buildSceneCacheData.get(next) != null) {
                    try {
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty("cache", buildSceneCacheData.get(next).toString());
                        hashMap.put(next, jsonObject2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for (String next2 : this.f45194c.keySet()) {
            XECallbackModel xECallbackModel = this.f45194c.get(next2);
            if (!(xECallbackModel == null || str == null || xECallbackModel.scenes == null || !xECallbackModel.scenes.contains(str))) {
                if (xECallbackModel.requestParams != null) {
                    Object requestParams = xECallbackModel.requestParams.getRequestParams();
                    try {
                        if (requestParams instanceof String) {
                            jsonObject = jsonParser.parse((String) requestParams).getAsJsonObject();
                        } else if (requestParams instanceof JsonObject) {
                            jsonObject = (JsonObject) requestParams;
                        } else if (requestParams instanceof JSONObject) {
                            jsonObject = jsonParser.parse(requestParams.toString()).getAsJsonObject();
                        } else {
                            hashMap.put(next2, requestParams);
                            jsonObject = null;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (jsonObject != null) {
                        if (!(buildSceneCacheData == null || buildSceneCacheData.get(next2) == null)) {
                            jsonObject.addProperty("cache", buildSceneCacheData.get(next2).toString());
                        }
                        hashMap.put(next2, jsonObject);
                    }
                }
                if (xECallbackModel.runnable != null) {
                    try {
                        this.f45195d.put(next2, (XEReqParamRunnableImpl) xECallbackModel.runnable.clone());
                    } catch (CloneNotSupportedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        m32465a((Map<String, Object>) hashMap, asyncCallback);
    }

    /* renamed from: a */
    private void m32465a(Map<String, Object> map, final AsyncCallback asyncCallback) {
        Map<String, XEReqParamRunnableImpl> map2 = this.f45195d;
        if (map2 != null && !map2.isEmpty()) {
            Handler handler = new Handler();
            if (map == null) {
                map = new HashMap<>();
            }
            final HashMap hashMap = new HashMap(map);
            handler.postDelayed(new Runnable() {
                public void run() {
                    XEParamBuilder.this.f45196e.shutdownNow();
                    asyncCallback.getCallback(hashMap);
                }
            }, (long) XEngineInnerRequest.XE_REQ_RUNNABLE_TIME_OUT);
            AtomicInteger atomicInteger = new AtomicInteger(this.f45195d.size());
            for (Map.Entry next : this.f45195d.entrySet()) {
                if (next.getValue() != null) {
                    final Map.Entry entry = next;
                    final AtomicInteger atomicInteger2 = atomicInteger;
                    final HashMap hashMap2 = hashMap;
                    final Handler handler2 = handler;
                    final AsyncCallback asyncCallback2 = asyncCallback;
                    ((XEReqParamRunnableImpl) next.getValue()).setRunnableCallback(new XERunnableCallback() {
                        public void getCallback(Map<String, Object> map) {
                            JSONObject jSONObject;
                            SystemUtils.log(3, "FlutterXeng:eend", String.valueOf(System.currentTimeMillis()), (Throwable) null, "com.didi.xengine.request.XEParamBuilder$2", 133);
                            String str = (String) entry.getKey();
                            synchronized (XEParamBuilder.class) {
                                int decrementAndGet = atomicInteger2.decrementAndGet();
                                try {
                                    if (hashMap2.containsKey(str)) {
                                        jSONObject = new JSONObject(hashMap2.get(str) == null ? "" : hashMap2.get(str).toString());
                                        for (Map.Entry next : map.entrySet()) {
                                            jSONObject.put((String) next.getKey(), next.getValue());
                                        }
                                    } else {
                                        jSONObject = new JSONObject(map);
                                    }
                                    hashMap2.put(str, jSONObject);
                                    if (decrementAndGet <= 0) {
                                        handler2.removeCallbacksAndMessages((Object) null);
                                        asyncCallback2.getCallback(hashMap2);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    if (decrementAndGet <= 0) {
                                        handler2.removeCallbacksAndMessages((Object) null);
                                        asyncCallback2.getCallback(hashMap2);
                                    }
                                }
                            }
                        }
                    });
                    Runnable runnable = (Runnable) next.getValue();
                    if (!this.f45196e.isShutdown()) {
                        this.f45196e.execute(runnable);
                    }
                } else if (atomicInteger.get() <= 0) {
                    handler.removeCallbacksAndMessages((Object) null);
                    asyncCallback.getCallback(hashMap);
                }
            }
        } else if (asyncCallback != null) {
            asyncCallback.getCallback(map);
        }
    }

    public void buildBizParamsMap(final XEBizParam xEBizParam, final XEBizParamMapCallback xEBizParamMapCallback) {
        if (xEBizParam != null && xEBizParam.scene != null) {
            m32464a(TextUtils.isEmpty(xEBizParam.scene) ? "" : xEBizParam.scene, (AsyncCallback) new AsyncCallback() {
                public void getCallback(Map<String, Object> map) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("scene", xEBizParam.scene);
                    hashMap.put(XEParamBuilder.f45193b, map);
                    XEBizParamMapCallback xEBizParamMapCallback = xEBizParamMapCallback;
                    if (xEBizParamMapCallback != null) {
                        xEBizParamMapCallback.getBizMap(hashMap);
                    }
                }
            });
        }
    }
}
