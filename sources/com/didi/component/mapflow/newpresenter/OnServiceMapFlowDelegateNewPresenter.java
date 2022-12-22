package com.didi.component.mapflow.newpresenter;

import android.os.Bundle;
import com.didi.address.FromType;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter;
import com.didi.map.global.flow.scene.sug.ISugSceneCallback;
import com.didi.sdk.address.address.entity.Address;

public class OnServiceMapFlowDelegateNewPresenter extends OnServiceMapFlowDelegatePresenter {
    public OnServiceMapFlowDelegateNewPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void forwardUpdatePickupPage() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE_V2, true);
        forward(1035, bundle);
    }

    /* access modifiers changed from: protected */
    public void enterSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        this.mLogger.info("OnServiceMapFlowDelegateNewPresenter enterSugPageScene..", new Object[0]);
        if (address == null) {
            this.mLogger.error("OnServiceMapFlowDelegateNewPresenter target is empty", new Object[0]);
            return;
        }
        this.mIsShowingUpdatePickUp = false;
        this.mPoiChangedAddress = address;
        enterNewSugPageScene(i, address, fromType, iSugSceneCallback);
    }
}
