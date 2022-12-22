package com.didi.component.core;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.common.map.Map;
import com.didi.sdk.app.BusinessContext;
import java.lang.ref.WeakReference;

public class ComponentParams {
    public static final int ROLE_DRIVER = 1;
    public static final int ROLE_PASSENGER = 0;
    public static final int ROLE_UNKNOWN = -1;

    /* renamed from: a */
    private WeakReference<Activity> f12734a;

    /* renamed from: b */
    private WeakReference<Fragment> f12735b;
    public int bid;
    public BusinessContext bizCtx;

    /* renamed from: c */
    private WeakReference<Map> f12736c;
    public int comboType;
    public final Bundle extras = new Bundle();
    public int pageID;
    public String psid;
    public int role = -1;
    public int scene;
    public String type;
    public int versionCode;

    public static ComponentParams from(BusinessContext businessContext, String str, int i, int i2) {
        ComponentParams componentParams = new ComponentParams();
        componentParams.bizCtx = businessContext;
        componentParams.psid = str;
        componentParams.pageID = i;
        componentParams.comboType = i2;
        return componentParams;
    }

    public ComponentParams add(BusinessContext businessContext) {
        this.bizCtx = businessContext;
        return this;
    }

    public ComponentParams add(Activity activity) {
        this.f12734a = new WeakReference<>(activity);
        return this;
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f12734a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public ComponentParams add(Fragment fragment) {
        this.f12735b = new WeakReference<>(fragment);
        return this;
    }

    public Fragment getFragment() {
        WeakReference<Fragment> weakReference = this.f12735b;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }

    public ComponentParams add(String str) {
        this.psid = str;
        return this;
    }

    public ComponentParams add(int i) {
        this.pageID = i;
        return this;
    }

    public ComponentParams type(String str) {
        this.type = str;
        return this;
    }

    public ComponentParams role(int i) {
        this.role = i;
        return this;
    }

    public ComponentParams scene(int i) {
        this.scene = i;
        return this;
    }

    public ComponentParams versionCode(int i) {
        this.versionCode = i;
        return this;
    }

    public ComponentParams add(Map map) {
        this.f12736c = new WeakReference<>(map);
        return this;
    }

    public ComponentParams add(Bundle bundle) {
        if (bundle != null) {
            this.extras.putAll(bundle);
        }
        return this;
    }

    public Map getMap() {
        WeakReference<Map> weakReference = this.f12736c;
        if (weakReference != null) {
            return (Map) weakReference.get();
        }
        return null;
    }

    public <T> T getExtra(String str) {
        return this.extras.get(str);
    }

    public String toString() {
        return "ComponentParams{bizCtx=" + this.bizCtx + ", activity=" + this.f12734a + ", fragment=" + this.f12735b + ", map=" + this.f12736c + ", psid='" + this.psid + '\'' + ", pageID=" + this.pageID + ", extras=" + this.extras + '}';
    }
}
