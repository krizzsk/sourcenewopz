package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.jni.SwigApolloCallback;

class MapEngineImpl$1 extends SwigApolloCallback {
    final /* synthetic */ C9186f this$0;
    final /* synthetic */ EngineDynamicConfigProvider val$engineDynamicConfigProvider;

    MapEngineImpl$1(C9186f fVar, EngineDynamicConfigProvider engineDynamicConfigProvider) {
        this.this$0 = fVar;
        this.val$engineDynamicConfigProvider = engineDynamicConfigProvider;
    }

    public Object OnGetApolloInt(String str, String str2) {
        EngineDynamicConfigProvider engineDynamicConfigProvider = this.val$engineDynamicConfigProvider;
        if (engineDynamicConfigProvider == null) {
            return null;
        }
        return engineDynamicConfigProvider.getInt(str, str2);
    }

    public Object OnGetApolloStringLength(String str, String str2) {
        EngineDynamicConfigProvider engineDynamicConfigProvider = this.val$engineDynamicConfigProvider;
        if (engineDynamicConfigProvider == null) {
            return null;
        }
        return engineDynamicConfigProvider.getStringLength(str, str2);
    }

    public Object OnGetApolloString(String str, String str2) {
        EngineDynamicConfigProvider engineDynamicConfigProvider = this.val$engineDynamicConfigProvider;
        if (engineDynamicConfigProvider == null) {
            return null;
        }
        return engineDynamicConfigProvider.getString(str, str2);
    }
}
