package com.didi.component.cancelbar;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.cancelbar.impl.CancelPresenter;
import com.didi.component.cancelbar.impl.CancelView;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "cancel_panel")
public class CancelComponent extends BaseComponent<ICancelView, AbsCancelPresenter<? extends ICancelView>> {
    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        super.init(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsCancelPresenter<? extends ICancelView> onCreatePresenter(ComponentParams componentParams) {
        return new CancelPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public ICancelView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new CancelView(componentParams.bizCtx.getContext(), viewGroup);
    }
}
