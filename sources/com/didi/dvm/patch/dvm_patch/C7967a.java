package com.didi.dvm.patch.dvm_patch;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.PrintStream;
import java.util.Map;

/* renamed from: com.didi.dvm.patch.dvm_patch.a */
/* compiled from: EventTracker */
class C7967a extends C7968b {
    C7967a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59023a(String str, Map map) {
        PrintStream printStream = System.out;
        printStream.println("dvm_patch " + str + ",attr=" + map);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) map);
    }
}
