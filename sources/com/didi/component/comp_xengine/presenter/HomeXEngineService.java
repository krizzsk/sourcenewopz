package com.didi.component.comp_xengine.presenter;

import android.os.Bundle;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.ComponentParams;

public class HomeXEngineService extends AbsGlobalXEnginePresenter {
    /* access modifiers changed from: protected */
    public String getScene() {
        return XERequestKey.SCENE_HOME;
    }

    public HomeXEngineService(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        subscribe("event_xengine_commit", this.commitListener);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe("event_xengine_commit", this.commitListener);
    }
}
