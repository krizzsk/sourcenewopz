package com.didi.dimina.starbox;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.mina.DMLaunchLifecycleManager;
import com.didi.dimina.starbox.module.jsbridge.performance.PerfFloatPage;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/dimina/starbox/StarBox$openMonitor$1", "Lcom/didi/dimina/container/mina/DMLaunchLifecycleManager$LaunchLifecycleCallback;", "onAppLaunch", "", "dmMina", "Lcom/didi/dimina/container/DMMina;", "starbox_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: StarBox.kt */
public final class StarBox$openMonitor$1 extends DMLaunchLifecycleManager.LaunchLifecycleCallback {
    StarBox$openMonitor$1() {
    }

    public void onAppLaunch(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "dmMina");
        DMConfig config = dMMina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "dmMina.config");
        DMConfig.LaunchConfig launchConfig = config.getLaunchConfig();
        Intrinsics.checkExpressionValueIsNotNull(launchConfig, "dmMina.config.launchConfig");
        String appId = launchConfig.getAppId();
        MMKVUtil instance = MMKVUtil.getInstance();
        Object obj = instance.get(PerfFloatPage.KEY_MONITOR_IS_OPEN + appId, false);
        if (obj != null) {
            PerfFloatPage.trigger(((Boolean) obj).booleanValue(), appId);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
