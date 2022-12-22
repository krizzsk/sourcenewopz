package com.didi.component.xengineordercompat;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;
import com.didi.component.xengineordercompat.presenter.AbsGlobalXEngineOrderDetailCompatPresenter;
import com.didi.component.xengineordercompat.presenter.GlobalXEngineOrderDetailCompatPresenter;

@ComponentRegister(product = "ride", type = "global_x_engine_order_detail_compat")
public class GlobalXEngineOrderDetailCompatComponent extends BaseComponent<IView, AbsGlobalXEngineOrderDetailCompatPresenter> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsGlobalXEngineOrderDetailCompatPresenter onCreatePresenter(ComponentParams componentParams) {
        return new GlobalXEngineOrderDetailCompatPresenter(componentParams);
    }
}
