package com.didiglobal.enginecore;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.BffExtra;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.enginecore.cache.XECacheCallBack;
import com.didiglobal.enginecore.cache.XECacheMgr;
import com.didiglobal.enginecore.data.exception.BffException;
import com.didiglobal.enginecore.data.exception.CacheFailException;
import com.didiglobal.enginecore.data.model.EngineInnerRequestModel;
import com.didiglobal.enginecore.data.network.XERequester;
import com.didiglobal.enginecore.data.parser.XEEngineParser;
import com.didiglobal.enginecore.data.parser.XEParser;
import com.didiglobal.enginecore.data.parser.model.EngineParseModel;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.didiglobal.enginecore.utils.XEngineLog;
import com.didiglobal.enginecore.utils.XEngineUtil;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class XEngineInnerRequest {
    public static int XE_CALLBACK_TIME_OUT = 6000;
    public static int XE_REQ_RUNNABLE_TIME_OUT = 3000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public XEngineDataHandleCallback f50111a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public XECacheMgr f50112b;

    public void setDataHandleCallback(XEngineDataHandleCallback xEngineDataHandleCallback) {
        this.f50111a = xEngineDataHandleCallback;
    }

    public void setCacheManager(XECacheMgr xECacheMgr) {
        this.f50112b = xECacheMgr;
    }

    @Deprecated
    public void loadFromNet4Simple(Context context, Map<String, Object> map, String str, XEParserCallback xEParserCallback) {
        final List<XETemplateComponent> templateList = TemplateCompRegister.getTemplateList();
        final Map<String, Object> map2 = map;
        final String str2 = str;
        final Context context2 = context;
        final XEParserCallback xEParserCallback2 = xEParserCallback;
        XERequester.expoRequest(context, map, str, new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                if (!(XEngineInnerRequest.this.f50112b == null || jsonObject == null)) {
                    Object obj = map2.get("scene");
                    String str = (obj == null || !(obj instanceof String)) ? "" : (String) obj;
                    JsonObject asObject = XEParserUtil.getAsObject("data", jsonObject);
                    if (asObject != null && !TextUtils.isEmpty(str)) {
                        XEngineInnerRequest.this.f50112b.putNormal(str, str2, asObject, false);
                    }
                }
                new XEParser().parseFromNet(context2, templateList, str2, jsonObject, xEParserCallback2);
            }

            public void onFailure(IOException iOException) {
                XEParserCallback xEParserCallback = xEParserCallback2;
                if (xEParserCallback != null) {
                    xEParserCallback.onFail(iOException);
                }
            }
        });
    }

    public void xEngineLoad4Simple(Context context, EngineInnerRequestModel engineInnerRequestModel) {
        if (engineInnerRequestModel != null) {
            if (this.f50112b != null && engineInnerRequestModel.requestCache.booleanValue()) {
                m36110b(context, engineInnerRequestModel);
            }
            if (!engineInnerRequestModel.requestCacheOnly.booleanValue()) {
                m36108a(context, engineInnerRequestModel);
            }
        }
    }

    /* renamed from: a */
    private void m36108a(final Context context, final EngineInnerRequestModel engineInnerRequestModel) {
        XERequester.engineSimpleRequest(context, engineInnerRequestModel.bizParams, engineInnerRequestModel.commonParams, engineInnerRequestModel.requestKeys, new BffCallBack<JsonObject>() {
            public void onSuccess(JsonObject jsonObject, BffExtra bffExtra) {
                if (!(XEngineInnerRequest.this.f50112b == null || jsonObject == null)) {
                    JsonObject asObject = XEParserUtil.getAsObject("data", jsonObject);
                    String str = engineInnerRequestModel.scene;
                    if (asObject != null && !TextUtils.isEmpty(str)) {
                        XEngineInnerRequest.this.f50112b.putNormal4Simple(str, engineInnerRequestModel.requestKeys, asObject);
                    }
                }
                EngineParseModel createParseModel = EngineParseModel.Companion.createParseModel(engineInnerRequestModel.scene, TemplateCompRegister.getTemplateKeyList(), XEngineUtil.buildRequiredSet(engineInnerRequestModel.requestKeys), jsonObject, engineInnerRequestModel.callback, (XEngineCommitCallback) null, bffExtra, XEngineInnerRequest.this.f50111a);
                createParseModel.setSimpleRequest(true);
                XEEngineParser.parse(context, createParseModel);
            }

            public void onFailure(BffExtra bffExtra) {
                BffException bffException;
                BffException bffException2;
                HashSet<String> hashSet = engineInnerRequestModel.commonParams == null ? new HashSet<>() : new HashSet<>(Arrays.asList(engineInnerRequestModel.requestKeys));
                if (bffExtra == null) {
                    bffException = new BffException("xengine bff error");
                } else {
                    if (bffExtra.exception == null) {
                        bffException2 = new BffException(bffExtra.traceId);
                    } else {
                        bffException2 = new BffException(bffExtra.traceId, bffExtra.exception);
                    }
                    bffException = bffException2;
                }
                HashMap hashMap = new HashMap();
                if (!hashSet.isEmpty()) {
                    for (String put : hashSet) {
                        hashMap.put(put, bffException);
                    }
                }
                engineInnerRequestModel.callback.onFailed(hashMap);
            }
        });
    }

    /* renamed from: b */
    private void m36110b(final Context context, final EngineInnerRequestModel engineInnerRequestModel) {
        this.f50112b.cacheSimpleRequest(engineInnerRequestModel.scene, engineInnerRequestModel.requestKeys[0], new XECacheCallBack<JsonObject>() {
            public void onCacheFailure() {
                HashSet<String> hashSet = engineInnerRequestModel.commonParams == null ? new HashSet<>() : new HashSet<>(Arrays.asList(engineInnerRequestModel.requestKeys));
                HashMap hashMap = new HashMap();
                CacheFailException cacheFailException = new CacheFailException("cacheSimpleRequest failed");
                if (!hashSet.isEmpty()) {
                    for (String put : hashSet) {
                        hashMap.put(put, cacheFailException);
                    }
                }
                engineInnerRequestModel.callback.onFailed(hashMap);
            }

            public void onCacheSuccess(JsonObject jsonObject) {
                EngineParseModel createParseModel = EngineParseModel.Companion.createParseModel(engineInnerRequestModel.scene, TemplateCompRegister.getTemplateKeyList(), XEngineUtil.buildRequiredSet(engineInnerRequestModel.requestKeys), jsonObject, engineInnerRequestModel.callback, (XEngineCommitCallback) null, (BffExtra) null, XEngineInnerRequest.this.f50111a);
                createParseModel.setCache(true);
                createParseModel.setSimpleRequest(true);
                XEEngineParser.parseAndDispatch(context, createParseModel);
            }
        });
    }

    public void xEngineCommit(final Context context, final EngineInnerRequestModel engineInnerRequestModel) {
        if (engineInnerRequestModel != null && engineInnerRequestModel.commitModel != null) {
            XERequester.engineCommit(context, engineInnerRequestModel.bizParams, engineInnerRequestModel.commonParams, engineInnerRequestModel.commitModel.commitModel, new BffCallBack<JsonObject>() {
                public void onSuccess(JsonObject jsonObject, BffExtra bffExtra) {
                    XEEngineParser.parse(context, EngineParseModel.Companion.createParseModel(engineInnerRequestModel.scene, TemplateCompRegister.getTemplateKeyList(), (Set<String>) null, jsonObject, engineInnerRequestModel.callback, engineInnerRequestModel.commitModel.commitCallback, bffExtra, XEngineInnerRequest.this.f50111a));
                }

                public void onFailure(BffExtra bffExtra) {
                    BffException bffException;
                    BffException bffException2;
                    if (bffExtra == null) {
                        bffException = new BffException("xengine commit bff error");
                    } else {
                        if (bffExtra.exception == null) {
                            bffException2 = new BffException(bffExtra.traceId);
                        } else {
                            bffException2 = new BffException(bffExtra.traceId, bffExtra.exception);
                        }
                        bffException = bffException2;
                    }
                    engineInnerRequestModel.callback.onFailed(new HashMap());
                    engineInnerRequestModel.commitModel.commitCallback.onFailed(bffException);
                }
            });
        }
    }

    public void xEngineLoad(Context context, EngineInnerRequestModel engineInnerRequestModel) {
        if (engineInnerRequestModel != null) {
            if (this.f50112b != null && engineInnerRequestModel.requestCache.booleanValue()) {
                XEngineLog.m36188fi("requestCache");
                m36111c(context, engineInnerRequestModel);
            }
            if (!engineInnerRequestModel.requestCacheOnly.booleanValue()) {
                m36112d(context, engineInnerRequestModel);
            }
        }
    }

    /* renamed from: c */
    private void m36111c(final Context context, final EngineInnerRequestModel engineInnerRequestModel) {
        this.f50112b.cachePageRequest(engineInnerRequestModel.scene, new XECacheCallBack<JsonObject>() {
            public void onCacheFailure() {
                XEngineLog.m36188fi("onCacheFailure");
                HashMap hashMap = new HashMap();
                CacheFailException cacheFailException = new CacheFailException("cachePageRequest failed");
                Set<String> registeredRequestKeysSet = TemplateCompRegister.getRegisteredRequestKeysSet(engineInnerRequestModel.scene);
                if (registeredRequestKeysSet != null && !registeredRequestKeysSet.isEmpty()) {
                    for (String put : registeredRequestKeysSet) {
                        hashMap.put(put, cacheFailException);
                    }
                }
                engineInnerRequestModel.callback.onFailed(hashMap);
            }

            public void onCacheSuccess(JsonObject jsonObject) {
                XEngineLog.m36188fi("onCacheSuccess");
                EngineParseModel createParseModel = EngineParseModel.Companion.createParseModel(engineInnerRequestModel.scene, TemplateCompRegister.getTemplateKeyList(), TemplateCompRegister.getRequiredTemplateSet(engineInnerRequestModel.scene), jsonObject, engineInnerRequestModel.callback, (XEngineCommitCallback) null, (BffExtra) null, XEngineInnerRequest.this.f50111a);
                createParseModel.setCache(true);
                XEEngineParser.parseAndDispatch(context, createParseModel);
            }
        });
    }

    /* renamed from: d */
    private void m36112d(final Context context, final EngineInnerRequestModel engineInnerRequestModel) {
        XERequester.enginePageRequest(context, engineInnerRequestModel.bizParams, engineInnerRequestModel.commonParams, new BffCallBack<JsonObject>() {
            public void onSuccess(JsonObject jsonObject, BffExtra bffExtra) {
                XEngineLog.m36188fi("netrequest onSuccess");
                if (!(XEngineInnerRequest.this.f50112b == null || jsonObject == null)) {
                    JsonObject asObject = XEParserUtil.getAsObject("data", jsonObject);
                    String str = engineInnerRequestModel.scene;
                    if (asObject != null && !TextUtils.isEmpty(str)) {
                        XEngineInnerRequest.this.f50112b.putNormal(str, (String) null, asObject, true);
                    }
                }
                XEEngineParser.parse(context, EngineParseModel.Companion.createParseModel(engineInnerRequestModel.scene, TemplateCompRegister.getTemplateKeyList(), TemplateCompRegister.getRequiredTemplateSet(engineInnerRequestModel.scene), jsonObject, engineInnerRequestModel.callback, (XEngineCommitCallback) null, bffExtra, XEngineInnerRequest.this.f50111a));
            }

            public void onFailure(BffExtra bffExtra) {
                BffException bffException;
                BffException bffException2;
                XEngineLog.m36188fi("netrequest onFailure");
                if (bffExtra == null) {
                    bffException = new BffException("xengine page request bff error");
                } else {
                    if (bffExtra.exception == null) {
                        bffException2 = new BffException(bffExtra.traceId);
                    } else {
                        bffException2 = new BffException(bffExtra.traceId, bffExtra.exception);
                    }
                    bffException = bffException2;
                }
                HashMap hashMap = new HashMap();
                Set<String> registeredRequestKeysSet = TemplateCompRegister.getRegisteredRequestKeysSet(engineInnerRequestModel.scene);
                if (registeredRequestKeysSet != null && !registeredRequestKeysSet.isEmpty()) {
                    for (String put : registeredRequestKeysSet) {
                        hashMap.put(put, bffException);
                    }
                }
                engineInnerRequestModel.callback.onFailed(hashMap);
            }
        });
    }

    public void setEngineCallbackTimeOut(int i) {
        XE_CALLBACK_TIME_OUT = i;
    }

    public void setEngineReqRunnableTimeOut(int i) {
        XE_REQ_RUNNABLE_TIME_OUT = i;
    }
}
