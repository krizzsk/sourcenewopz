package com.didi.component.payentrance;

import android.view.ViewGroup;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.payentrance.newui.presenter.NewUIUnifiedPayEntrancePresenter;
import com.didi.component.payentrance.newui.view.NewUiIPayEntranceViewContainer;
import com.didi.component.payentrance.newui.view.NewUiPayEntranceView;

@ComponentRegister(product = "ride", type = "xpanel_pax_pending_pay_card")
public class NewUIPayEntranceComponent extends AbsPayEntranceComponent {
    /* access modifiers changed from: protected */
    public NewUIUnifiedPayEntrancePresenter onCreatePresenter(ComponentParams componentParams) {
        return new NewUIUnifiedPayEntrancePresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public NewUiIPayEntranceViewContainer onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new NewUiPayEntranceView(componentParams.bizCtx.getContext());
    }
}
