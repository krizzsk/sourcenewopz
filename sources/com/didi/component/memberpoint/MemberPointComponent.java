package com.didi.component.memberpoint;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.memberpoint.impl.MemberPointPresenter;
import com.didi.component.memberpoint.impl.MemberPointView;

@ComponentRegister(product = "ride", type = "memberpoint")
public class MemberPointComponent extends BaseComponent<IMemberPointView, AbsMemberPointPresenter> {
    /* access modifiers changed from: protected */
    public IMemberPointView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new MemberPointView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsMemberPointPresenter onCreatePresenter(ComponentParams componentParams) {
        return new MemberPointPresenter(componentParams);
    }
}
