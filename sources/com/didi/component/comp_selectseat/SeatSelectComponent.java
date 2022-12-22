package com.didi.component.comp_selectseat;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_selectseat.presenter.SeatSelectPresenter;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "select_seat")
public class SeatSelectComponent extends BaseComponent<AbsSeatSelectView, AbsSeatSelectPresenter> {
    /* access modifiers changed from: protected */
    public AbsSeatSelectView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsSeatSelectPresenter onCreatePresenter(ComponentParams componentParams) {
        return new SeatSelectPresenter(componentParams.bizCtx);
    }
}
