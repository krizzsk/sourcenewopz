package com.didichuxing.sofa.animation;

import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class Animator extends C16457c implements C16459e {

    /* renamed from: a */
    private static final String f49075a = "Animator";

    /* renamed from: b */
    private List<C16473t> f49076b = new ArrayList();

    interface PrepareAnimationCallback {
        void onPrepared();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo121013a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo121015a(C16472s sVar);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo121017b(C16472s sVar);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo121019c(C16472s sVar);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void mo121020d(C16472s sVar);

    public abstract boolean isRunning();

    public abstract boolean isStarted();

    public abstract Animator start();

    public abstract void stop();

    /* renamed from: d */
    private void m35299d() {
        SystemUtils.log(3, "sofa.animation.Animator", "Reverse is unsupported.", (Throwable) null, "com.didichuxing.sofa.animation.Animator", 34);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121016a(C16473t tVar) {
        if (tVar != null) {
            this.f49076b.add(tVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo121018b() {
        return !this.f49076b.isEmpty();
    }

    /* renamed from: e */
    private List<C16473t> m35300e() {
        return this.f49076b;
    }

    /* renamed from: f */
    private void m35301f() {
        this.f49076b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121014a(final PrepareAnimationCallback prepareAnimationCallback) {
        if (mo121018b()) {
            final List<C16473t> e = m35300e();
            for (C16473t a : e) {
                View a2 = a.mo121140a();
                if (a2 == null) {
                    LoggerUtil.m35315e(f49075a, "prepareAnimation error: target is null !!");
                } else {
                    a2.setVisibility(4);
                }
            }
            for (C16473t a3 : e) {
                View a4 = a3.mo121140a();
                if (a4 != null) {
                    a4.post(new Runnable() {
                        public void run() {
                            for (C16473t b : e) {
                                b.mo121141b().run();
                            }
                            PrepareAnimationCallback prepareAnimationCallback = prepareAnimationCallback;
                            if (prepareAnimationCallback != null) {
                                prepareAnimationCallback.onPrepared();
                            }
                        }
                    });
                    return;
                }
            }
        } else if (prepareAnimationCallback != null) {
            prepareAnimationCallback.onPrepared();
        }
    }
}
