package com.didi.component.messagebar;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;
import com.didi.component.messagebar.impl.MessageBarPresenter;

@ComponentRegister(product = "ride", type = "message")
public class MessageBarComponent extends BaseComponent<IView, AbsMessageBarPresenter> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsMessageBarPresenter onCreatePresenter(ComponentParams componentParams) {
        return new MessageBarPresenter(componentParams);
    }
}
