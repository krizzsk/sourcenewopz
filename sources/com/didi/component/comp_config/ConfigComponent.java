package com.didi.component.comp_config;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_config.presenter.ConfigPresenter;
import com.didi.component.comp_config.presenter.ConfirmConfigPresenter;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "config")
public class ConfigComponent extends BaseComponent<AbsConfigView, AbsConfigPresenter> {
    /* access modifiers changed from: protected */
    public AbsConfigView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsConfigPresenter onCreatePresenter(ComponentParams componentParams) {
        if (componentParams.pageID == 1030) {
            return new ConfirmConfigPresenter(componentParams.bizCtx);
        }
        return new ConfigPresenter(componentParams.bizCtx);
    }
}
