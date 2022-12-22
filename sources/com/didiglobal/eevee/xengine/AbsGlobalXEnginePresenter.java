package com.didiglobal.eevee.xengine;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.xengine.XEngine;
import com.didi.xengine.callback.XEReqUtilMethod;
import com.didi.xengine.callback.XESceneGetter;
import com.didi.xengine.config.EngineConfig;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.enginecore.push.EnginePushRegister;
import com.google.gson.JsonArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010)\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J/\u0010/\u001a\u0002H0\"\u0004\b\u0000\u001002\b\u00101\u001a\u0004\u0018\u00010\"2\b\u00102\u001a\u0004\u0018\u00010\"2\u0006\u00103\u001a\u0002H0H\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\"H\u0016J\b\u00106\u001a\u00020\"H&J\b\u00107\u001a\u00020&H\u0002J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010<\u001a\u00020&2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010?\u001a\u00020&2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020&H\u0016J\u0012\u0010C\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010-H\u0016J!\u0010D\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010GJ\u0012\u0010H\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010-H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006I"}, mo175978d2 = {"Lcom/didiglobal/eevee/xengine/AbsGlobalXEnginePresenter;", "Lcom/didiglobal/common/common/never/component/EeveeCompPresenterImpl;", "Lcom/didiglobal/common/common/never/component/EeveeIView;", "Lcom/didi/xengine/callback/XESceneGetter;", "Lcom/didiglobal/enginecore/XEngineDataHandleCallback;", "Lcom/didi/xengine/callback/XEReqUtilMethod;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "RELEASE_XENGINE_TIME_OUT", "", "commitListener", "Lcom/didi/component/never/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/xengine/request/XECommitBizParams;", "componentParams", "getComponentParams", "()Lcom/didi/component/never/core/ComponentParams;", "setComponentParams", "config", "Lcom/didi/xengine/config/EngineConfig;", "engine", "Lcom/didi/xengine/XEngine;", "getEngine", "()Lcom/didi/xengine/XEngine;", "setEngine", "(Lcom/didi/xengine/XEngine;)V", "pushRegister", "Lcom/didiglobal/enginecore/push/EnginePushRegister;", "getPushRegister", "()Lcom/didiglobal/enginecore/push/EnginePushRegister;", "setPushRegister", "(Lcom/didiglobal/enginecore/push/EnginePushRegister;)V", "createCommonParams", "", "", "", "scene", "engineCommit", "", "engineCommitRequest", "commitParams", "engineDispatch", "Lcom/didi/xengine/request/XEDispatchBizParams;", "engineRequest", "commonReq", "Lcom/didi/xengine/request/XEBizParamsImpl;", "engineSimpleRequest", "getApolloParam", "T", "toggleKey", "paramKey", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getCurrentScene", "getScene", "initEngine", "isFiltered", "", "filter", "Lcom/google/gson/JsonArray;", "onAdd", "bundle", "Landroid/os/Bundle;", "onDataHandle", "model", "Lcom/didiglobal/enginecore/data/model/XEDataHandleModel;", "onRemove", "pageRequest", "setCache", "Lcom/didi/xengine/request/XECacheParamsImpl;", "isDefault", "(Lcom/didi/xengine/request/XECacheParamsImpl;Ljava/lang/Boolean;)V", "simpleRequest", "e_comp_xengine_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: AbsGlobalXEnginePresenter.kt */
public abstract class AbsGlobalXEnginePresenter extends EeveeCompPresenterImpl<EeveeIView<?>> implements XEReqUtilMethod, XESceneGetter, XEngineDataHandleCallback {

    /* renamed from: a */
    private final int f50094a = 10000;

    /* renamed from: b */
    private ComponentParams f50095b;

    /* renamed from: c */
    private XEngine f50096c;

    /* renamed from: d */
    private EnginePushRegister f50097d;

    /* renamed from: e */
    private EngineConfig f50098e;

    /* renamed from: f */
    private final BaseEventPublisher.OnEventListener<XECommitBizParams> f50099f = new AbsGlobalXEnginePresenter$commitListener$1(this);

    public abstract String getScene();

    public boolean isFiltered(JsonArray jsonArray) {
        return false;
    }

    public AbsGlobalXEnginePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public final ComponentParams getComponentParams() {
        return this.f50095b;
    }

    /* access modifiers changed from: protected */
    public final void setComponentParams(ComponentParams componentParams) {
        this.f50095b = componentParams;
    }

    /* access modifiers changed from: protected */
    public final XEngine getEngine() {
        return this.f50096c;
    }

    /* access modifiers changed from: protected */
    public final void setEngine(XEngine xEngine) {
        this.f50096c = xEngine;
    }

    /* access modifiers changed from: protected */
    public final EnginePushRegister getPushRegister() {
        return this.f50097d;
    }

    /* access modifiers changed from: protected */
    public final void setPushRegister(EnginePushRegister enginePushRegister) {
        this.f50097d = enginePushRegister;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m36095a();
        XEngine xEngine = this.f50096c;
        if (xEngine != null) {
            xEngine.register(this.mContext, this, this);
        }
        subscribe("event_xengine_commit", this.f50099f);
    }

    /* renamed from: a */
    private final void m36095a() {
        this.f50096c = new XEngine("eevee");
        this.f50098e = new EngineConfig.Builder().setReqMethod(this).build();
        XEngine xEngine = this.f50096c;
        if (xEngine != null) {
            xEngine.setEngineCallbackTimeOut(this.f50094a);
            xEngine.setXEConfig(this.f50098e);
            if (((Number) m36093a("x_engine_cache_enable", "use_cache", 0)).intValue() == 1) {
                xEngine.initCache(this.mContext);
            }
        }
    }

    public void onRemove() {
        super.onRemove();
        XEngine xEngine = this.f50096c;
        if (xEngine != null) {
            xEngine.unregister();
        }
        unsubscribe("event_xengine_commit", this.f50099f);
    }

    public String getCurrentScene() {
        return getScene();
    }

    public void onDataHandle(XEDataHandleModel xEDataHandleModel) {
        if (xEDataHandleModel != null) {
            String handleType = xEDataHandleModel.getHandleType();
            int hashCode = handleType.hashCode();
            if (hashCode == 284771450) {
                boolean equals = handleType.equals(XENetConstant.DataHandlerAction.ACTION_DISPATCH);
            } else if (hashCode == 502538434) {
                handleType.equals(XENetConstant.DataHandlerAction.ACTION_INTERCEPT);
            }
        }
    }

    public void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        engineRequest(xEBizParamsImpl);
    }

    public void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        engineSimpleRequest(xEBizParamsImpl);
    }

    public void engineCommit(XECommitBizParams xECommitBizParams) {
        if (xECommitBizParams != null) {
            CharSequence charSequence = xECommitBizParams.scene;
            if (charSequence == null || charSequence.length() == 0) {
                xECommitBizParams.scene = getScene();
            }
            XEngine xEngine = this.f50096c;
            if (xEngine != null) {
                Context context = this.mContext;
                String str = xECommitBizParams.scene;
                Intrinsics.checkExpressionValueIsNotNull(str, "p.scene");
                xEngine.commitRequest(context, xECommitBizParams, m36094a(str));
            }
        }
    }

    public void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        XEngine xEngine;
        if (xEDispatchBizParams != null && (xEngine = this.f50096c) != null) {
            xEngine.engineDispatch(this.mContext, xEDispatchBizParams.scene, xEDispatchBizParams.dispatchData, xEDispatchBizParams.dataHandleCallback);
        }
    }

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        XEngine xEngine;
        if (xECacheParamsImpl != null && (xEngine = this.f50096c) != null) {
            xEngine.setCache(xECacheParamsImpl, bool);
        }
    }

    public void engineRequest(XEBizParamsImpl xEBizParamsImpl) {
        XEngine xEngine;
        if (xEBizParamsImpl != null && (xEngine = this.f50096c) != null) {
            Context context = this.mContext;
            String str = xEBizParamsImpl.scene;
            Intrinsics.checkExpressionValueIsNotNull(str, "it.scene");
            xEngine.pageRequest(context, xEBizParamsImpl, m36094a(str));
        }
    }

    public void engineSimpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        if (xEBizParamsImpl != null) {
            String str = xEBizParamsImpl.scene;
            XEngine xEngine = this.f50096c;
            if (xEngine != null) {
                Context context = this.mContext;
                Intrinsics.checkExpressionValueIsNotNull(str, "scene");
                xEngine.simpleRequest(context, xEBizParamsImpl, m36094a(str), xEBizParamsImpl.requestKeys);
            }
        }
    }

    public void engineCommitRequest(XECommitBizParams xECommitBizParams) {
        if (xECommitBizParams != null) {
            if (TextUtils.isEmpty(xECommitBizParams.scene)) {
                xECommitBizParams.scene = getScene();
            }
            String str = xECommitBizParams.scene;
            XEngine xEngine = this.f50096c;
            if (xEngine != null) {
                Context context = this.mContext;
                Intrinsics.checkExpressionValueIsNotNull(str, "scene");
                xEngine.commitRequest(context, xECommitBizParams, m36094a(str));
            }
        }
    }

    /* renamed from: a */
    private final Map<String, Object> m36094a(String str) {
        Map<String, Object> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            str = getScene();
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("scene", str);
        }
        return hashMap;
    }

    /* renamed from: a */
    private final <T> T m36093a(String str, String str2, T t) {
        try {
            IToggle toggle = Apollo.getToggle(str);
            Intrinsics.checkExpressionValueIsNotNull(toggle, "toggle");
            return toggle.getExperiment().getParam(str2, t);
        } catch (Exception unused) {
            return t;
        }
    }
}
