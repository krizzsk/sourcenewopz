package com.didi.component.matchtogo20.wait;

import android.view.ViewGroup;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.matchtogo20.wait.presenter.MTGWaitAcceptPresenter;
import com.didi.component.matchtogo20.wait.view.IMTGWaitAcceptView;
import com.didi.component.matchtogo20.wait.view.MTGWaitAcceptView;

@ComponentRegister(product = "ride", type = "xpanel_carpool_matchtogo")
public class MTGWaitAcceptComponent extends SelfControlComponent<IMTGWaitAcceptView, AbsMTGWaitAcceptPresenter, MTGWaitAcceptController> {
    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        super.init(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public IMTGWaitAcceptView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new MTGWaitAcceptView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsMTGWaitAcceptPresenter onCreatePresenter(ComponentParams componentParams) {
        return new MTGWaitAcceptPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public MTGWaitAcceptController createInflateController() {
        return new MTGWaitAcceptController();
    }
}
