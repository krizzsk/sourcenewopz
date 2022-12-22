package com.didi.component.common.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.core.IComponent;

public class ComponentWrap {

    /* renamed from: a */
    private String f11470a;

    /* renamed from: b */
    private Bundle f11471b;

    /* renamed from: c */
    private IComponent f11472c;

    /* renamed from: d */
    private boolean f11473d;

    /* renamed from: e */
    private boolean f11474e;

    public ComponentWrap() {
        this.f11473d = true;
        this.f11474e = false;
    }

    public ComponentWrap(String str) {
        this(str, (Bundle) null, true);
    }

    public ComponentWrap(String str, boolean z) {
        this(str, (Bundle) null, z);
    }

    public ComponentWrap(String str, Bundle bundle) {
        this(str, bundle, true);
    }

    public ComponentWrap(String str, Bundle bundle, boolean z) {
        this.f11473d = true;
        this.f11474e = false;
        this.f11470a = str;
        this.f11471b = bundle;
        this.f11473d = z;
    }

    public String getType() {
        return this.f11470a;
    }

    public void setType(String str) {
        this.f11470a = str;
    }

    public Bundle getBundle() {
        return this.f11471b;
    }

    public void setBundle(Bundle bundle) {
        this.f11471b = bundle;
    }

    public IComponent getComponent() {
        return this.f11472c;
    }

    public void setComponent(IComponent iComponent) {
        this.f11472c = iComponent;
    }

    public boolean isUseMask() {
        return this.f11473d;
    }

    public void setUseMask(boolean z) {
        this.f11473d = z;
    }

    public boolean isClickMaskHide() {
        return this.f11474e;
    }

    public void setClickMaskHide(boolean z) {
        this.f11474e = z;
    }

    public IComponent getComponent(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(this.f11470a)) {
            return this.f11472c;
        }
        return null;
    }

    public void setComponent(String str, IComponent iComponent) {
        if (!TextUtils.isEmpty(str)) {
            this.f11470a = str;
            this.f11472c = iComponent;
        }
    }
}
