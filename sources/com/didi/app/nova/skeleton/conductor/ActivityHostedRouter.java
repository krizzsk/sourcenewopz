package com.didi.app.nova.skeleton.conductor;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.FragmentLifecycleHandler;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;
import java.util.Collections;
import java.util.List;

public final class ActivityHostedRouter extends Router {

    /* renamed from: g */
    private FragmentLifecycleHandler f8272g;

    /* renamed from: h */
    private final TransactionIndexer f8273h = new TransactionIndexer();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Router mo40557c() {
        return this;
    }

    public final void invalidateOptionsMenu() {
    }

    public final void setHost(FragmentLifecycleHandler fragmentLifecycleHandler, ViewGroup viewGroup) {
        if (this.f8272g != fragmentLifecycleHandler || this.f8332d != viewGroup) {
            if (this.f8332d != null && (this.f8332d instanceof ControllerChangeHandler.ControllerChangeListener)) {
                removeChangeListener((ControllerChangeHandler.ControllerChangeListener) this.f8332d);
            }
            if (viewGroup instanceof ControllerChangeHandler.ControllerChangeListener) {
                addChangeListener((ControllerChangeHandler.ControllerChangeListener) viewGroup);
            }
            this.f8272g = fragmentLifecycleHandler;
            this.f8332d = viewGroup;
            mo40728i();
        }
    }

    public void saveInstanceState(Bundle bundle) {
        super.saveInstanceState(bundle);
        this.f8273h.saveInstanceState(bundle);
    }

    public void restoreInstanceState(Bundle bundle) {
        super.restoreInstanceState(bundle);
        this.f8273h.restoreInstanceState(bundle);
    }

    public Activity getActivity() {
        FragmentLifecycleHandler fragmentLifecycleHandler = this.f8272g;
        if (fragmentLifecycleHandler != null) {
            return fragmentLifecycleHandler.getLifecycleActivity();
        }
        return null;
    }

    public Fragment getFragment() {
        FragmentLifecycleHandler fragmentLifecycleHandler = this.f8272g;
        if (fragmentLifecycleHandler != null) {
            return fragmentLifecycleHandler.getAttachedFragment();
        }
        return null;
    }

    public void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
        this.f8272g = null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (mo40555a()) {
            this.f8272g.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40548a(Intent intent) {
        if (mo40555a()) {
            this.f8272g.startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40551a(String str, Intent intent, int i) {
        if (mo40555a()) {
            this.f8272g.startActivityForResult(str, intent, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40552a(String str, Intent intent, int i, Bundle bundle) {
        if (mo40555a()) {
            this.f8272g.startActivityForResult(str, intent, i, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40553a(String str, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (mo40555a()) {
            this.f8272g.startIntentSenderForResult(str, intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40550a(String str, int i) {
        if (mo40555a()) {
            this.f8272g.registerForActivityResult(str, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40549a(String str) {
        if (mo40555a()) {
            this.f8272g.unregisterForActivityResults(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40554a(String str, String[] strArr) {
        if (mo40555a()) {
            this.f8272g.requestPermissions(str, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo40555a() {
        return this.f8272g != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<Router> mo40556b() {
        return mo40555a() ? this.f8272g.getRouters() : Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TransactionIndexer mo40558d() {
        return this.f8273h;
    }

    public void onContextAvailable() {
        super.onContextAvailable();
    }
}
