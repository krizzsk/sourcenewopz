package com.didi.component.carpool.info;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.carpool.info.presenter.AbsCarpoolInfoPresenter;
import com.didi.component.carpool.info.presenter.OnServiceCarpoolInfoPresenter;
import com.didi.component.carpool.info.view.CarpoolDetailView;
import com.didi.component.carpool.info.view.ICarpoolInfoView;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "travel_group_carpool_info")
public class CarpoolInfoComponent extends BaseComponent<ICarpoolInfoView, AbsCarpoolInfoPresenter> {
    /* access modifiers changed from: protected */
    public ICarpoolInfoView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new CarpoolDetailView(componentParams.bizCtx.getContext(), componentParams.pageID);
    }

    /* access modifiers changed from: protected */
    public AbsCarpoolInfoPresenter onCreatePresenter(ComponentParams componentParams) {
        return new OnServiceCarpoolInfoPresenter(componentParams);
    }
}
