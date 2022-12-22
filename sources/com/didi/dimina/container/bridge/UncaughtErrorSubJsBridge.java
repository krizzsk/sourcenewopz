package com.didi.dimina.container.bridge;

import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.debug.uncaught.error.UncaughtErrorBean;
import com.didi.dimina.container.debug.uncaught.error.UncaughtErrorManager;
import com.didi.dimina.container.debug.uncaught.error.UncaughtErrorPageManager;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/UncaughtErrorSubJsBridge;", "", "mDMMina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "reportUncaughtError", "", "paras", "Lorg/json/JSONObject;", "callback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "Companion", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UncaughtErrorSubJsBridge.kt */
public final class UncaughtErrorSubJsBridge {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "UncaughtErrorSubJsBridge";

    /* renamed from: a */
    private final DMMina f16666a;

    public UncaughtErrorSubJsBridge(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "mDMMina");
        this.f16666a = dMMina;
        LogUtil.iRelease(TAG, "init()");
        UncaughtErrorPageManager uncaughtErrorPageManager = UncaughtErrorPageManager.INSTANCE;
        FragmentActivity activity = this.f16666a.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "mDMMina.activity");
        uncaughtErrorPageManager.init(activity);
    }

    public final void reportUncaughtError(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UncaughtErrorBean uncaughtErrorBean;
        LogUtil.iRelease(TAG, " reportUncaughtError() open:" + DebugKitStoreUtil.getUncaughtErrorBoardOpen() + ' ' + jSONObject);
        if (DebugKitStoreUtil.getUncaughtErrorBoardOpen() && jSONObject != null && (uncaughtErrorBean = (UncaughtErrorBean) JSONUtil.jsonToObject(jSONObject.toString(), UncaughtErrorBean.class)) != null) {
            DMConfig config = this.f16666a.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "mDMMina.config");
            DMConfig.LaunchConfig launchConfig = config.getLaunchConfig();
            Intrinsics.checkExpressionValueIsNotNull(launchConfig, "mDMMina.config.launchConfig");
            String appId = launchConfig.getAppId();
            UncaughtErrorManager uncaughtErrorManager = UncaughtErrorManager.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(appId, "jsAppId");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "paras.toString()");
            uncaughtErrorManager.storage(appId, jSONObject2);
            UncaughtErrorManager.INSTANCE.show(appId, uncaughtErrorBean);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/UncaughtErrorSubJsBridge$Companion;", "", "()V", "TAG", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: UncaughtErrorSubJsBridge.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
