package com.didi.component.traveldetail;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.traveldetail.impl.TravelDetailPresenterV2;
import com.didi.component.traveldetail.impl.TravelDetailViewV2;

@ComponentRegister(product = "ride", type = "travel_detail_v2")
public class TravelDetailComponentV2 extends BaseComponent<TravelDetailViewV2, AbsTravelDetailPresenterV2> {
    /* access modifiers changed from: protected */
    public TravelDetailViewV2 onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new TravelDetailViewV2(componentParams.bizCtx.getContext(), componentParams.pageID);
    }

    /* access modifiers changed from: protected */
    public AbsTravelDetailPresenterV2 onCreatePresenter(ComponentParams componentParams) {
        return new TravelDetailPresenterV2(componentParams.bizCtx.getContext());
    }
}
