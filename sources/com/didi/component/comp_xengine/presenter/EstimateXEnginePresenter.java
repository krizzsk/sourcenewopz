package com.didi.component.comp_xengine.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;

public class EstimateXEnginePresenter extends ServiceXEnginePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f12514a = XERequestKey.SCENE_ESTIMATE;
    protected BaseEventPublisher.OnEventListener<String> sceneListener = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (BaseEventKeys.XEngine.EVENT_XENGINE_SCENE_HANDLE.equals(str)) {
                String unused = EstimateXEnginePresenter.this.f12514a = str2;
            }
        }
    };

    public EstimateXEnginePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.XEngine.EVENT_XENGINE_SCENE_HANDLE, this.sceneListener);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.XEngine.EVENT_XENGINE_SCENE_HANDLE, this.sceneListener);
    }

    /* access modifiers changed from: protected */
    public String getScene() {
        return this.f12514a;
    }
}
