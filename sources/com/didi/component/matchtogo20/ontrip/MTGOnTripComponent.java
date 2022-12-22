package com.didi.component.matchtogo20.ontrip;

import android.view.ViewGroup;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.matchtogo20.ontrip.presenter.MTGOnTripPresenter;
import com.didi.component.matchtogo20.ontrip.view.IMTGOnTripView;
import com.didi.component.matchtogo20.ontrip.view.MTGOnTripView;

@ComponentRegister(product = "ride", type = "xpanel_carpool_matchontrip")
public class MTGOnTripComponent extends SelfControlComponent<IMTGOnTripView, AbsMTGOnTripPresenter, MTGOnTripController> {
    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        super.init(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public IMTGOnTripView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new MTGOnTripView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsMTGOnTripPresenter onCreatePresenter(ComponentParams componentParams) {
        return new MTGOnTripPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public MTGOnTripController createInflateController() {
        return new MTGOnTripController();
    }
}
