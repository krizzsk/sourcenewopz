package com.didi.component.travelGroupInfo;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "travel_group_info_v2")
public class TravelGroupInfoComponentV2 extends BaseComponent<TravelGroupInfoViewV2, AbsTravelGroupInfoPresenterV2> {
    /* access modifiers changed from: protected */
    public TravelGroupInfoViewV2 onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new TravelGroupInfoViewV2(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsTravelGroupInfoPresenterV2 onCreatePresenter(ComponentParams componentParams) {
        return new TravelGroupInfoPresenterV2(componentParams.bizCtx.getContext());
    }
}
