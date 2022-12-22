package com.didi.component.never.core;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ComponentParams {

    /* renamed from: a */
    private WeakReference<Activity> f14642a;

    /* renamed from: b */
    private WeakReference<Fragment> f14643b;

    /* renamed from: c */
    private WeakReference<Map> f14644c;
    public final Bundle extras = new Bundle();
    public String nodeId;
    public String type;

    public ComponentParams add(Activity activity) {
        this.f14642a = new WeakReference<>(activity);
        return this;
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f14642a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public static ComponentParams from(String str) {
        ComponentParams componentParams = new ComponentParams();
        componentParams.nodeId = str;
        return componentParams;
    }

    public ComponentParams add(Fragment fragment) {
        this.f14643b = new WeakReference<>(fragment);
        return this;
    }

    public Fragment getFragment() {
        WeakReference<Fragment> weakReference = this.f14643b;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }

    public ComponentParams type(String str) {
        this.type = str;
        return this;
    }

    public ComponentParams add(Map map) {
        this.f14644c = new WeakReference<>(map);
        return this;
    }

    public ComponentParams add(Bundle bundle) {
        if (bundle != null) {
            this.extras.putAll(bundle);
        }
        return this;
    }

    public Map getMap() {
        WeakReference<Map> weakReference = this.f14644c;
        if (weakReference != null) {
            return (Map) weakReference.get();
        }
        return null;
    }

    public <T> T getExtra(String str) {
        return this.extras.get(str);
    }

    public Object get(String str) {
        if (getMap() == null) {
            return null;
        }
        return getMap().get(str);
    }

    public String toString() {
        return "ComponentParams{, activity=" + this.f14642a + ", fragment=" + this.f14643b + ", map=" + this.f14644c + ", extras=" + this.extras + '}';
    }
}
