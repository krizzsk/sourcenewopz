package com.didi.component.home_exception;

import android.view.ViewGroup;
import com.didi.component.home_exception.presenter.ExceptionPresenter;
import com.didi.component.home_exception.view.ExceptionView;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;

@ComponentName(type = "eevee_enable_location")
public class HomeExceptionComponent extends BaseComponent<AbsExceptionView, AbsExceptionPresenter> {
    /* access modifiers changed from: protected */
    public AbsExceptionView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new ExceptionView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public AbsExceptionPresenter onCreatePresenter(ComponentParams componentParams) {
        return new ExceptionPresenter(componentParams);
    }
}
