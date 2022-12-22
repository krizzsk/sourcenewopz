package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.didi.component.core.ComponentParams;

public class WaitRspJarvisPresenter extends AbsJarvisPresenter {
    /* access modifiers changed from: protected */
    public String getPage() {
        return "wait";
    }

    public WaitRspJarvisPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        requestJarvisStatus();
    }
}
