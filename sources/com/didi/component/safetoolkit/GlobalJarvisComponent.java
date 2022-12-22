package com.didi.component.safetoolkit;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenter;
import com.didi.component.safetoolkit.presenter.EndJarvisPresenter;
import com.didi.component.safetoolkit.presenter.HomeJarvisPresenter;
import com.didi.component.safetoolkit.presenter.OnServiceJarvisPresenter;
import com.didi.component.safetoolkit.presenter.WaitRspJarvisPresenter;
import com.didi.component.safetoolkit.views.IJarvisView;
import com.didi.component.safetoolkit.views.JarvisView;

@ComponentRegister(product = "ride", type = "safe_jarvis")
public class GlobalJarvisComponent extends BaseComponent<IJarvisView, AbsJarvisPresenter> {
    /* access modifiers changed from: protected */
    public IJarvisView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new JarvisView(componentParams.bizCtx.getContext());
    }

    /* access modifiers changed from: protected */
    public AbsJarvisPresenter onCreatePresenter(ComponentParams componentParams) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new HomeJarvisPresenter(componentParams);
        }
        if (i != 1040) {
            return null;
        }
        switch (componentParams.scene) {
            case 10401:
                return new WaitRspJarvisPresenter(componentParams);
            case 10402:
                return new OnServiceJarvisPresenter(componentParams);
            case 10403:
                return new EndJarvisPresenter(componentParams);
            default:
                return null;
        }
    }
}
