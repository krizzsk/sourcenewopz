package com.didiglobal.eevee.xengine;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.IView;
import com.didi.component_processor.annonation.ComponentName;

@ComponentName(type = "eevee_xengine")
public class GlobalXEngineComponent extends BaseComponent<IView, AbsGlobalXEnginePresenter> {
    public ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams) {
        return null;
    }

    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    public boolean recreateWhenNodeChange(ComponentParams componentParams) {
        return true;
    }

    /* access modifiers changed from: protected */
    public AbsGlobalXEnginePresenter onCreatePresenter(ComponentParams componentParams) {
        return new GlobalXEnginePresenter(componentParams);
    }
}
