package com.didi.component.comp_xengine.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.request.XESimpleReqParams;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.xengine.XEngine;
import com.didi.xengine.callback.XECallback;
import com.didi.xengine.callback.XEReqUtilMethod;
import com.didi.xengine.callback.XESceneGetter;
import com.didi.xengine.config.EngineConfig;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;
import com.didiglobal.enginecore.XEParserCallback;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.XEngineInnerRequest;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.push.EnginePushRegister;
import com.didiglobal.enginecore.push.PushCallbackCreator;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class AbsGlobalXEnginePresenter extends BaseExpressPresenter<IView> implements XEReqUtilMethod, XESceneGetter, XEngineDataHandleCallback {

    /* renamed from: a */
    private static final int f12509a = 10000000;

    /* renamed from: b */
    private static final int f12510b = 15000;

    /* renamed from: c */
    private EngineConfig f12511c;
    protected final BaseEventPublisher.OnEventListener<XECommitBizParams> commitListener = new BaseEventPublisher.OnEventListener<XECommitBizParams>() {
        public void onEvent(String str, XECommitBizParams xECommitBizParams) {
            AbsGlobalXEnginePresenter.this.engineCommit(xECommitBizParams);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MyXEngineCallback f12512d;

    /* renamed from: e */
    private final BaseEventPublisher.OnEventListener<XESimpleReqParams> f12513e = new BaseEventPublisher.OnEventListener<XESimpleReqParams>() {
        public void onEvent(String str, XESimpleReqParams xESimpleReqParams) {
            AbsGlobalXEnginePresenter.this.simpleRequest(xESimpleReqParams);
        }
    };
    protected XEngine engine;
    protected ComponentParams mComponentParams;
    protected EnginePushRegister pushRegister;

    /* access modifiers changed from: protected */
    public abstract String getScene();

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
    }

    public AbsGlobalXEnginePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m8498b();
        subscribe(BaseEventKeys.XEngine.EVENT_XENGINE_SIMPLE_REQUEST, this.f12513e);
        subscribe("event_xengine_commit", this.commitListener);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* renamed from: b */
    private void m8498b() {
        XEngine xEngine = new XEngine(XERequestKey.X_ENGINE_TYPE_4_PASSENGER);
        this.engine = xEngine;
        xEngine.register(this.mContext, this, this);
        this.engine.setEngineCallbackTimeOut(15000);
        EngineConfig build = new EngineConfig.Builder().setReqMethod(this).build();
        this.f12511c = build;
        this.engine.setXEConfig(build);
        this.pushRegister = new EnginePushRegister();
        this.f12512d = new MyXEngineCallback(getScene());
        this.pushRegister.register(this.mContext, new PushCallbackCreator() {
            public XEngineCallback getEngineCallback() {
                return AbsGlobalXEnginePresenter.this.f12512d;
            }

            public String getCurrentScene() {
                return AbsGlobalXEnginePresenter.this.getScene();
            }
        }, this);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.XEngine.EVENT_XENGINE_SIMPLE_REQUEST, this.f12513e);
        unsubscribe("event_xengine_commit", this.commitListener);
        engineUnregister();
    }

    /* access modifiers changed from: protected */
    public void engineUnregister() {
        EnginePushRegister enginePushRegister = this.pushRegister;
        if (enginePushRegister != null) {
            enginePushRegister.unregister();
        }
    }

    public void engineRequest(XEBizParamsImpl xEBizParamsImpl) {
        this.engine.pageRequest(this.mContext, xEBizParamsImpl, m8497a(xEBizParamsImpl.scene));
    }

    /* renamed from: a */
    private Map<String, Object> m8497a(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("scene", str);
        }
        if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().oid == null)) {
            hashMap.put("oid", CarOrderHelper.getOrder().oid);
        }
        return hashMap;
    }

    public void engineSimpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        this.engine.simpleRequest(this.mContext, xEBizParamsImpl, m8497a(xEBizParamsImpl.scene), xEBizParamsImpl.requestKeys);
    }

    public void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        if (xEDispatchBizParams != null && xEDispatchBizParams.dispatchData != null && !TextUtils.isEmpty(xEDispatchBizParams.scene)) {
            JsonObject jsonObject = xEDispatchBizParams.dispatchData;
            this.engine.engineDispatch(this.mContext, xEDispatchBizParams.scene, jsonObject, this);
        }
    }

    @Deprecated
    public void simpleRequest(XESimpleReqParams xESimpleReqParams) {
        final String str = xESimpleReqParams.requestKey;
        HashMap hashMap = new HashMap();
        if (xESimpleReqParams.bizParams != null) {
            hashMap.put("biz_param", new JSONObject(xESimpleReqParams.bizParams));
        }
        String scene = xESimpleReqParams.scene == null ? getScene() : xESimpleReqParams.scene;
        if (scene != null) {
            hashMap.put("scene", scene);
        }
        final XECallback xECallback = new XECallback(scene);
        new XEngineInnerRequest().loadFromNet4Simple(this.mContext, hashMap, str, new XEParserCallback() {
            public void onFail(Exception exc) {
                HashMap hashMap = new HashMap();
                hashMap.put(str, new EngineErrorException(exc));
                xECallback.onFailed(hashMap);
            }

            public void onSuccess(XEngineData xEngineData, List<XEComponent> list) {
                xECallback.onSuccess(xEngineData, list);
            }

            public void onRenderSuccess(XEngineData xEngineData, List<XEComponent> list) {
                xECallback.onSuccessWithRenderList(xEngineData, list);
            }
        });
    }

    public boolean isFiltered(JsonArray jsonArray) {
        if (jsonArray == null) {
            return false;
        }
        try {
            String scene = getScene();
            this.f12512d.setScene(scene);
            Iterator<JsonElement> it = jsonArray.iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject = it.next().getAsJsonObject();
                if (scene.equals(asJsonObject.get("scene").getAsString())) {
                    if (!asJsonObject.has("status")) {
                        return true;
                    }
                    JsonArray asJsonArray = asJsonObject.get("status").getAsJsonArray();
                    if (asJsonArray.size() == 0) {
                        return true;
                    }
                    List list = (List) new Gson().fromJson((JsonElement) asJsonArray, new TypeToken<List<String>>() {
                    }.getType());
                    CarOrder order = CarOrderHelper.getOrder();
                    if (order != null && list.contains(String.valueOf(order.substatus))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void onDataHandle(XEDataHandleModel xEDataHandleModel) {
        if (xEDataHandleModel != null) {
            String handleType = xEDataHandleModel.getHandleType();
            char c = 65535;
            int hashCode = handleType.hashCode();
            if (hashCode != 284771450) {
                if (hashCode == 502538434 && handleType.equals(XENetConstant.DataHandlerAction.ACTION_INTERCEPT)) {
                    c = 0;
                }
            } else if (handleType.equals(XENetConstant.DataHandlerAction.ACTION_DISPATCH)) {
                c = 1;
            }
            if (c == 0) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.XEngine.EVENT_XENGINE_DATA_HANDLE, xEDataHandleModel);
            }
        }
    }

    public String getCurrentScene() {
        return getScene();
    }

    public void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        engineRequest(xEBizParamsImpl);
    }

    public void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        engineSimpleRequest(xEBizParamsImpl);
    }

    public void engineCommit(XECommitBizParams xECommitBizParams) {
        if (xECommitBizParams != null) {
            if (TextUtils.isEmpty(xECommitBizParams.scene)) {
                xECommitBizParams.scene = getScene();
            }
            this.engine.commitRequest(this.mContext, xECommitBizParams, m8497a(xECommitBizParams.scene));
        }
    }

    private class MyXEngineCallback implements XEngineCallback {
        private XECallback callback;
        private String scene;

        MyXEngineCallback(String str) {
            this.scene = str;
            this.callback = new XECallback(str);
        }

        public void setScene(String str) {
            this.scene = str;
            this.callback = new XECallback(str);
        }

        public void onSuccess(XEngineData xEngineData, List<XEComponent> list) {
            this.callback.onSuccess(xEngineData, list);
        }

        public void onSuccessWithRenderList(XEngineData xEngineData, List<XEComponent> list) {
            this.callback.onSuccessWithRenderList(xEngineData, list);
        }

        public void onFailed(Map<String, EngineErrorException> map) {
            this.callback.onFailed(map);
        }
    }
}
