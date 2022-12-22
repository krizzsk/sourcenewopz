package com.didiglobal.p205sa.biz.component.xengine;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.xengine.XEngine;
import com.didi.xengine.callback.XEReqUtilMethod;
import com.didi.xengine.callback.XESceneGetter;
import com.didi.xengine.config.EngineConfig;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.enginecore.push.EnginePushRegister;
import com.didiglobal.enginecore.utils.XEngineLog;
import com.didiglobal.p205sa.biz.component.xengine.lifecycle.SAXEngineLifeCycle;
import com.google.gson.JsonArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!2\u0006\u0010$\u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010)\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020\"H\u0016J\b\u00100\u001a\u00020\"H&J\b\u00101\u001a\u00020&H\u0002J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u00020&2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020&2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020&H\u0016J\u0012\u0010=\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010>\u001a\u00020&2\b\u0010\u0006\u001a\u0004\u0018\u00010-H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006?"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/AbsSAXEnginePresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didi/component/never/core/IView;", "Lcom/didi/xengine/callback/XESceneGetter;", "Lcom/didiglobal/enginecore/XEngineDataHandleCallback;", "Lcom/didi/xengine/callback/XEReqUtilMethod;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "RELEASE_XENGINE_TIME_OUT", "", "commitListener", "Lcom/didi/component/never/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/xengine/request/XECommitBizParams;", "componentParams", "getComponentParams", "()Lcom/didi/component/never/core/ComponentParams;", "setComponentParams", "config", "Lcom/didi/xengine/config/EngineConfig;", "engine", "Lcom/didi/xengine/XEngine;", "getEngine", "()Lcom/didi/xengine/XEngine;", "setEngine", "(Lcom/didi/xengine/XEngine;)V", "pushRegister", "Lcom/didiglobal/enginecore/push/EnginePushRegister;", "getPushRegister", "()Lcom/didiglobal/enginecore/push/EnginePushRegister;", "setPushRegister", "(Lcom/didiglobal/enginecore/push/EnginePushRegister;)V", "createCommonParams", "", "", "", "scene", "engineCommit", "", "engineCommitRequest", "commitParams", "engineDispatch", "Lcom/didi/xengine/request/XEDispatchBizParams;", "engineRequest", "commonReq", "Lcom/didi/xengine/request/XEBizParamsImpl;", "engineSimpleRequest", "getCurrentScene", "getScene", "initEngine", "isFiltered", "", "filter", "Lcom/google/gson/JsonArray;", "onAdd", "bundle", "Landroid/os/Bundle;", "onDataHandle", "model", "Lcom/didiglobal/enginecore/data/model/XEDataHandleModel;", "onRemove", "pageRequest", "simpleRequest", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.AbsSAXEnginePresenter */
/* compiled from: AbsSAXEnginePresenter.kt */
public abstract class AbsSAXEnginePresenter extends ComponentPresenterImpl<IView<?>> implements XEReqUtilMethod, XESceneGetter, XEngineDataHandleCallback {

    /* renamed from: a */
    private final int f51192a = 10000;

    /* renamed from: b */
    private ComponentParams f51193b;

    /* renamed from: c */
    private XEngine f51194c;

    /* renamed from: d */
    private EnginePushRegister f51195d;

    /* renamed from: e */
    private EngineConfig f51196e;

    /* renamed from: f */
    private final BaseEventPublisher.OnEventListener<XECommitBizParams> f51197f = new AbsSAXEnginePresenter$commitListener$1(this);

    public abstract String getScene();

    public boolean isFiltered(JsonArray jsonArray) {
        return false;
    }

    public AbsSAXEnginePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public final ComponentParams getComponentParams() {
        return this.f51193b;
    }

    /* access modifiers changed from: protected */
    public final void setComponentParams(ComponentParams componentParams) {
        this.f51193b = componentParams;
    }

    /* access modifiers changed from: protected */
    public final XEngine getEngine() {
        return this.f51194c;
    }

    /* access modifiers changed from: protected */
    public final void setEngine(XEngine xEngine) {
        this.f51194c = xEngine;
    }

    /* access modifiers changed from: protected */
    public final EnginePushRegister getPushRegister() {
        return this.f51195d;
    }

    /* access modifiers changed from: protected */
    public final void setPushRegister(EnginePushRegister enginePushRegister) {
        this.f51195d = enginePushRegister;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m36669a();
        XEngine xEngine = this.f51194c;
        if (xEngine != null) {
            xEngine.register(this.mContext, this, this);
        }
        subscribe(SAXEngineConstants.SA_EVENT_XENGINE_COMMIT, this.f51197f);
        SAXEngineLifeCycle.INSTANCE.setServiceEngineActive(true);
    }

    /* renamed from: a */
    private final void m36669a() {
        if (DebugUtils.isDebug()) {
            XEngineLog.setOutput(true);
        }
        this.f51194c = new XEngine(SAXEngineConstants.SA_XENGINE_TYPE);
        this.f51196e = new EngineConfig.Builder().setReqMethod(this).build();
        XEngine xEngine = this.f51194c;
        if (xEngine != null) {
            xEngine.setEngineCallbackTimeOut(this.f51192a);
            xEngine.setXEConfig(this.f51196e);
            xEngine.initCache(this.mContext);
        }
    }

    public void onRemove() {
        super.onRemove();
        XEngine xEngine = this.f51194c;
        if (xEngine != null) {
            xEngine.unregister();
        }
        unsubscribe(SAXEngineConstants.SA_EVENT_XENGINE_COMMIT, this.f51197f);
        SAXEngineLifeCycle.INSTANCE.setServiceEngineActive(false);
    }

    public String getCurrentScene() {
        return getScene();
    }

    public void onDataHandle(XEDataHandleModel xEDataHandleModel) {
        if (xEDataHandleModel != null) {
            String handleType = xEDataHandleModel.getHandleType();
            if (!Intrinsics.areEqual((Object) handleType, (Object) XENetConstant.DataHandlerAction.ACTION_INTERCEPT)) {
                Intrinsics.areEqual((Object) handleType, (Object) XENetConstant.DataHandlerAction.ACTION_DISPATCH);
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
            XEngine engine = getEngine();
            if (engine != null) {
                Context context = this.mContext;
                String str = xECommitBizParams.scene;
                Intrinsics.checkNotNullExpressionValue(str, "p.scene");
                engine.commitRequest(context, xECommitBizParams, m36668a(str));
            }
        }
    }

    public void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        XEngine engine;
        if (xEDispatchBizParams != null && (engine = getEngine()) != null) {
            engine.engineDispatch(this.mContext, xEDispatchBizParams.scene, xEDispatchBizParams.dispatchData, xEDispatchBizParams.dataHandleCallback);
        }
    }

    public void engineRequest(XEBizParamsImpl xEBizParamsImpl) {
        XEngine engine;
        if (xEBizParamsImpl != null && (engine = getEngine()) != null) {
            Context context = this.mContext;
            String str = xEBizParamsImpl.scene;
            Intrinsics.checkNotNullExpressionValue(str, "it.scene");
            engine.pageRequest(context, xEBizParamsImpl, m36668a(str));
        }
    }

    public void engineSimpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        if (xEBizParamsImpl != null) {
            String str = xEBizParamsImpl.scene;
            XEngine engine = getEngine();
            if (engine != null) {
                Context context = this.mContext;
                Intrinsics.checkNotNullExpressionValue(str, "scene");
                engine.simpleRequest(context, xEBizParamsImpl, m36668a(str), xEBizParamsImpl.requestKeys);
            }
        }
    }

    public void engineCommitRequest(XECommitBizParams xECommitBizParams) {
        if (xECommitBizParams != null) {
            if (TextUtils.isEmpty(xECommitBizParams.scene)) {
                xECommitBizParams.scene = getScene();
            }
            String str = xECommitBizParams.scene;
            XEngine engine = getEngine();
            if (engine != null) {
                Context context = this.mContext;
                Intrinsics.checkNotNullExpressionValue(str, "scene");
                engine.commitRequest(context, xECommitBizParams, m36668a(str));
            }
        }
    }

    /* renamed from: a */
    private final Map<String, Object> m36668a(String str) {
        Map<String, Object> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            str = getScene();
        }
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            hashMap.put("scene", str);
        }
        if (!TextUtils.isEmpty(charSequence) && Intrinsics.areEqual((Object) "sa_home", (Object) str)) {
            hashMap.put("sa_type", Integer.valueOf(SaApolloUtil.INSTANCE.getSaType().getType()));
        }
        return hashMap;
    }
}
