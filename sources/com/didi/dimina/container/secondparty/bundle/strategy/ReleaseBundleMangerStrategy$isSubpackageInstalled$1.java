package com.didi.dimina.container.secondparty.bundle.strategy;

import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.LogUtil;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "aBoolean", "", "callback"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ReleaseBundleMangerStrategy.kt */
final class ReleaseBundleMangerStrategy$isSubpackageInstalled$1<T> implements IDMCommonAction<Boolean> {
    final /* synthetic */ BundleManagerStrategy.SubpackageInstallCallback $callback;
    final /* synthetic */ String $jsAppId;
    final /* synthetic */ String $moduleName;

    ReleaseBundleMangerStrategy$isSubpackageInstalled$1(String str, String str2, BundleManagerStrategy.SubpackageInstallCallback subpackageInstallCallback) {
        this.$jsAppId = str;
        this.$moduleName = str2;
        this.$callback = subpackageInstallCallback;
    }

    public /* synthetic */ void callback(Object obj) {
        callback(((Boolean) obj).booleanValue());
    }

    public final void callback(boolean z) {
        LogUtil.iRelease(ReleaseBundleMangerStrategy.TAG, "isModuleInstalled() -> " + this.$jsAppId + "\t moduleName=" + this.$moduleName + "\t :" + z);
        BundleManagerStrategy.SubpackageInstallCallback subpackageInstallCallback = this.$callback;
        if (subpackageInstallCallback != null) {
            subpackageInstallCallback.callback(z);
        }
    }
}
