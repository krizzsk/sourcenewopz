package com.didi.component.timepicker;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.timepicker.impl.presenter.NewTimePickerPresenter;
import com.didi.component.timepicker.impl.view.NewTimePickerView;

@ComponentRegister(product = "ride", type = "time_picker")
public class TimePickerComponent extends BaseComponent<ITimePickerView, AbsTimePickerPresenter> {
    /* access modifiers changed from: protected */
    public AbsTimePickerPresenter onCreatePresenter(ComponentParams componentParams) {
        return new NewTimePickerPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public ITimePickerView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new NewTimePickerView(componentParams.getActivity(), viewGroup);
    }
}
