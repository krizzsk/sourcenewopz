package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class RestoreViewOnCreateController extends Controller {
    /* access modifiers changed from: protected */
    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    protected RestoreViewOnCreateController() {
        super((Bundle) null);
    }

    protected RestoreViewOnCreateController(Bundle bundle) {
        super(bundle);
    }

    /* access modifiers changed from: protected */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return onCreateView(layoutInflater, viewGroup, this.f8309b == null ? null : this.f8309b.getBundle("Controller.viewState.bundle"));
    }
}
