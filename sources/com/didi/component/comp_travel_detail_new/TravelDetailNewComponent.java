package com.didi.component.comp_travel_detail_new;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_travel_detail_new.presenter.TravelDetailNewPresenter;
import com.didi.component.comp_travel_detail_new.view.TravelDetailNewView;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "travel_group_info_common")
public class TravelDetailNewComponent extends BaseComponent<AbsTravelDetailNewView, AbsTravelDetailNewPresenter> {
    /* access modifiers changed from: protected */
    public AbsTravelDetailNewView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new TravelDetailNewView(componentParams.bizCtx.getContext());
    }

    /* access modifiers changed from: protected */
    public AbsTravelDetailNewPresenter onCreatePresenter(ComponentParams componentParams) {
        return new TravelDetailNewPresenter(componentParams.bizCtx);
    }
}
