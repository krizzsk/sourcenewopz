package com.didi.component.confirmbroadingpoint;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.confirmbroadingpoint.impl.ConfirmGetOnPresenter;
import com.didi.component.confirmbroadingpoint.impl.UpdatePickUpBroadingPointNewPresenter;
import com.didi.component.confirmbroadingpoint.impl.view.ConfirmBroadingPointViewV2;
import com.didi.component.confirmbroadingpoint.impl.view.ConfirmGetOnView;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "confirm_broading_point")
public class ConfirmBroadingPointComponent extends BaseComponent<IConfirmBroadingPointView, AbsConfirmBroadingPointPresenter> {
    private AbsConfirmBroadingPointPresenter mCurrentPresenter;

    /* access modifiers changed from: protected */
    public AbsConfirmBroadingPointPresenter onCreatePresenter(ComponentParams componentParams) {
        this.mCurrentPresenter = null;
        int i = componentParams.pageID;
        if (i == 1030) {
            this.mCurrentPresenter = new ConfirmGetOnPresenter(componentParams);
        } else if (i != 1035) {
            this.mCurrentPresenter = new ConfirmGetOnPresenter(componentParams);
        } else {
            this.mCurrentPresenter = new UpdatePickUpBroadingPointNewPresenter(componentParams);
        }
        return this.mCurrentPresenter;
    }

    /* access modifiers changed from: protected */
    public IConfirmBroadingPointView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        if (componentParams.pageID == 1035) {
            return new ConfirmBroadingPointViewV2(componentParams.getActivity(), viewGroup);
        }
        return new ConfirmGetOnView(componentParams.getActivity(), viewGroup);
    }
}
