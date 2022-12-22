package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.navigation.jni.swig.ApolloExperiment;
import com.dmap.navigation.jni.swig.ApolloToggle;

/* renamed from: com.dmap.navigation.engine.a.u */
/* compiled from: NavApolloToggle */
public final class C17410u extends ApolloToggle {

    /* renamed from: a */
    private IToggle f51846a = null;

    public C17410u(IToggle iToggle) {
        this.f51846a = iToggle;
    }

    public final ApolloExperiment getExperiment() {
        IToggle iToggle = this.f51846a;
        if (iToggle == null || !iToggle.allow()) {
            return null;
        }
        return new C17408s(this.f51846a.getExperiment());
    }

    public final boolean allow() {
        IToggle iToggle = this.f51846a;
        if (iToggle != null) {
            return iToggle.allow();
        }
        return false;
    }
}
