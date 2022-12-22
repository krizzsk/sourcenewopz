package com.didi.component.notalk;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.notalk.notalk2.NoTalkPresenterV2;
import com.didi.component.notalk.notalk2.NoTalkViewV2;
import com.didi.component.notalk.presenter.AbsNoTalkPresenter;
import com.didi.component.notalk.view.INoTalkView;

@ComponentRegister(product = "ride", type = "non_talking")
public class NoTalkComponent extends BaseComponent<INoTalkView, AbsNoTalkPresenter> {
    /* access modifiers changed from: protected */
    public INoTalkView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        if (componentParams.getActivity() != null) {
            return new NoTalkViewV2(componentParams.getActivity());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsNoTalkPresenter onCreatePresenter(ComponentParams componentParams) {
        if (componentParams.getActivity() != null) {
            return new NoTalkPresenterV2(componentParams);
        }
        return null;
    }
}
