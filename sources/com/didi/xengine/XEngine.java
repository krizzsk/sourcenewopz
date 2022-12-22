package com.didi.xengine;

import android.content.Context;
import com.android.didi.bfflib.BffExtra;
import com.didi.xengine.callback.XEBizParamMapCallback;
import com.didi.xengine.callback.XECallback;
import com.didi.xengine.callback.XESceneGetter;
import com.didi.xengine.callback.XEngineCallbackImpl;
import com.didi.xengine.config.EngineConfig;
import com.didi.xengine.config.EngineInitInstance;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEParamBuilder;
import com.didiglobal.enginecore.TemplateCompRegister;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.XEngineCommitCallback;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.XEngineInnerRequest;
import com.didiglobal.enginecore.cache.XECacheMgr;
import com.didiglobal.enginecore.data.model.EngineCommitModel;
import com.didiglobal.enginecore.data.model.EngineInnerRequestModel;
import com.didiglobal.enginecore.data.parser.XEEngineParser;
import com.didiglobal.enginecore.data.parser.model.EngineParseModel;
import com.didiglobal.enginecore.push.EnginePushRegister;
import com.didiglobal.enginecore.push.PushCallbackCreator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;

public class XEngine {

    /* renamed from: a */
    private XEngineInnerRequest f45179a = new XEngineInnerRequest();

    /* renamed from: b */
    private XEParamBuilder f45180b = new XEParamBuilder(this);

    /* renamed from: c */
    private String f45181c;

    /* renamed from: d */
    private EnginePushRegister f45182d;

    /* renamed from: e */
    private XESceneGetter f45183e;

    /* renamed from: f */
    private XECacheMgr f45184f;

    public XEngine(String str) {
        this.f45181c = str;
    }

    public void initCache(Context context) {
        XECacheMgr xECacheMgr = new XECacheMgr(context.getApplicationContext());
        this.f45184f = xECacheMgr;
        this.f45179a.setCacheManager(xECacheMgr);
    }

    public void register(Context context, final XESceneGetter xESceneGetter, XEngineDataHandleCallback xEngineDataHandleCallback) {
        if (xESceneGetter != null) {
            this.f45183e = xESceneGetter;
            if (this.f45182d == null) {
                this.f45182d = new EnginePushRegister();
            }
            this.f45182d.register(context, new PushCallbackCreator() {
                public XEngineCallback getEngineCallback() {
                    return new XECallback(xESceneGetter.getCurrentScene());
                }

                public String getCurrentScene() {
                    return xESceneGetter.getCurrentScene();
                }
            }, xEngineDataHandleCallback);
            XEngineInnerRequest xEngineInnerRequest = this.f45179a;
            if (xEngineInnerRequest != null) {
                xEngineInnerRequest.setDataHandleCallback(xEngineDataHandleCallback);
                return;
            }
            return;
        }
        throw new NullPointerException("XESceneGetter can not be null");
    }

    public void unregister() {
        EnginePushRegister enginePushRegister = this.f45182d;
        if (enginePushRegister != null) {
            enginePushRegister.unregister();
            this.f45182d = null;
        }
        XEngineInnerRequest xEngineInnerRequest = this.f45179a;
        if (xEngineInnerRequest != null) {
            xEngineInnerRequest.setDataHandleCallback((XEngineDataHandleCallback) null);
        }
    }

    public void setXEConfig(EngineConfig engineConfig) {
        EngineInitInstance.getInstance().setConfig(this.f45181c, engineConfig);
    }

    public void simpleRequest(Context context, XEBizParamsImpl xEBizParamsImpl, Map<String, Object> map, String[] strArr) {
        xEBizParamsImpl.scene = m32455a(xEBizParamsImpl.scene);
        this.f45180b.buildBizParamsMap(xEBizParamsImpl, new XEBizParamMapCallback(xEBizParamsImpl, map, strArr, context) {
            public final /* synthetic */ XEBizParamsImpl f$1;
            public final /* synthetic */ Map f$2;
            public final /* synthetic */ String[] f$3;
            public final /* synthetic */ Context f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void getBizMap(Map map) {
                XEngine.this.m32457a(this.f$1, this.f$2, this.f$3, this.f$4, map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32457a(XEBizParamsImpl xEBizParamsImpl, Map map, String[] strArr, Context context, Map map2) {
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel(xEBizParamsImpl.scene, map2, map, new XECallback(xEBizParamsImpl.scene));
        engineInnerRequestModel.requestKeys = strArr;
        engineInnerRequestModel.requestCache = xEBizParamsImpl.requestCache;
        engineInnerRequestModel.requestCacheOnly = xEBizParamsImpl.requestCacheOnly;
        this.f45179a.xEngineLoad4Simple(context, engineInnerRequestModel);
    }

    public void commitRequest(Context context, XECommitBizParams xECommitBizParams, Map<String, Object> map) {
        xECommitBizParams.scene = m32455a(xECommitBizParams.scene);
        this.f45180b.buildBizParamsMap(xECommitBizParams, new XEBizParamMapCallback(xECommitBizParams, map, context) {
            public final /* synthetic */ XECommitBizParams f$1;
            public final /* synthetic */ Map f$2;
            public final /* synthetic */ Context f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void getBizMap(Map map) {
                XEngine.this.m32458a(this.f$1, this.f$2, this.f$3, map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32458a(XECommitBizParams xECommitBizParams, Map map, Context context, Map map2) {
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel(xECommitBizParams.scene, map2, map, new XECallback(xECommitBizParams.scene));
        engineInnerRequestModel.commitModel = new EngineCommitModel(xECommitBizParams.callback);
        engineInnerRequestModel.commitModel.commitModel = xECommitBizParams.commitModel;
        if (engineInnerRequestModel.commitModel.commitModel == null && xECommitBizParams.extraParams != null && !xECommitBizParams.extraParams.isEmpty()) {
            new Gson().toJson((Object) xECommitBizParams.extraParams);
        }
        this.f45179a.xEngineCommit(context, engineInnerRequestModel);
    }

    public void pageRequest(Context context, XEBizParamsImpl xEBizParamsImpl, Map<String, Object> map) {
        xEBizParamsImpl.scene = m32455a(xEBizParamsImpl.scene);
        this.f45180b.buildBizParamsMap(xEBizParamsImpl, new XEBizParamMapCallback(xEBizParamsImpl, map, context) {
            public final /* synthetic */ XEBizParamsImpl f$1;
            public final /* synthetic */ Map f$2;
            public final /* synthetic */ Context f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void getBizMap(Map map) {
                XEngine.this.m32456a(this.f$1, this.f$2, this.f$3, map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32456a(XEBizParamsImpl xEBizParamsImpl, Map map, Context context, Map map2) {
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel(xEBizParamsImpl.scene, map2, map, new XECallback(xEBizParamsImpl.scene));
        engineInnerRequestModel.requestCache = xEBizParamsImpl.requestCache;
        engineInnerRequestModel.requestCacheOnly = xEBizParamsImpl.requestCacheOnly;
        this.f45179a.xEngineLoad(context, engineInnerRequestModel);
    }

    public void engineDispatch(Context context, String str, JsonObject jsonObject, XEngineDataHandleCallback xEngineDataHandleCallback) {
        XEEngineParser.parseAndDispatch(context, EngineParseModel.Companion.createParseModel(str, TemplateCompRegister.getTemplateKeyList(), TemplateCompRegister.getRequiredTemplateSet(str), jsonObject, new XEngineCallbackImpl(str), (XEngineCommitCallback) null, (BffExtra) null, xEngineDataHandleCallback));
    }

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        if (this.f45184f != null && xECacheParamsImpl != null) {
            if (bool.booleanValue()) {
                this.f45184f.putDefault(xECacheParamsImpl.scene, xECacheParamsImpl.component, xECacheParamsImpl.jsonString, true);
            } else {
                this.f45184f.putNormal(xECacheParamsImpl.scene, xECacheParamsImpl.component, xECacheParamsImpl.jsonString, true);
            }
        }
    }

    public XECacheMgr getCacheMgr() {
        return this.f45184f;
    }

    public void setEngineCallbackTimeOut(int i) {
        this.f45179a.setEngineCallbackTimeOut(i);
    }

    public void setEngineReqRunnableTimeOut(int i) {
        this.f45179a.setEngineReqRunnableTimeOut(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f45183e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m32455a(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x000e
            com.didi.xengine.callback.XESceneGetter r0 = r1.f45183e
            if (r0 == 0) goto L_0x000e
            java.lang.String r2 = r0.getCurrentScene()
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.xengine.XEngine.m32455a(java.lang.String):java.lang.String");
    }
}
