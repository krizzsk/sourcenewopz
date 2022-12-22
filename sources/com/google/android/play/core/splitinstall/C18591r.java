package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.play.core.splitinstall.r */
final class C18591r implements C18576d {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f53337a;

    /* renamed from: b */
    final /* synthetic */ Intent f53338b;

    /* renamed from: c */
    final /* synthetic */ Context f53339c;

    /* renamed from: d */
    final /* synthetic */ C18593t f53340d;

    C18591r(C18593t tVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.f53340d = tVar;
        this.f53337a = splitInstallSessionState;
        this.f53338b = intent;
        this.f53339c = context;
    }

    /* renamed from: a */
    public final void mo149292a() {
        this.f53340d.f53346d.post(new C18592s(this.f53340d, this.f53337a, 5, 0));
    }

    /* renamed from: a */
    public final void mo149293a(int i) {
        this.f53340d.f53346d.post(new C18592s(this.f53340d, this.f53337a, 6, i));
    }

    /* renamed from: b */
    public final void mo149294b() {
        if (!this.f53338b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.f53338b.putExtra("triggered_from_app_after_verification", true);
            this.f53339c.sendBroadcast(this.f53338b);
            return;
        }
        this.f53340d.f53193a.mo149083b("Splits copied and verified more than once.", new Object[0]);
    }
}
