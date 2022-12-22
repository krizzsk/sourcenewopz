package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.u */
final class C18605u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallRequest f53398a;

    /* renamed from: b */
    final /* synthetic */ C18607w f53399b;

    C18605u(C18607w wVar, SplitInstallRequest splitInstallRequest) {
        this.f53399b = wVar;
        this.f53398a = splitInstallRequest;
    }

    public final void run() {
        C18593t a = this.f53399b.f53402b;
        List<String> moduleNames = this.f53398a.getModuleNames();
        List a2 = C18607w.m38213b(this.f53398a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList(moduleNames));
        }
        if (!a2.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList(a2));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        a.mo149189a(SplitInstallSessionState.m38082a(bundle));
    }
}
