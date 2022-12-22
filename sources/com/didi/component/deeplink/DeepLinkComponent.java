package com.didi.component.deeplink;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;

@ComponentRegister(product = "ride", type = "deeplink")
public class DeepLinkComponent extends BaseComponent<IView, AbsDeepLinkPresenter> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsDeepLinkPresenter onCreatePresenter(ComponentParams componentParams) {
        return m8719a(componentParams);
    }

    /* renamed from: a */
    private AbsDeepLinkPresenter m8719a(ComponentParams componentParams) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new HomeDeepLinkPresenter(componentParams.getActivity());
        }
        if (i != 1030) {
            return null;
        }
        return new ConfirmDeepLinkPresenter(componentParams.getActivity());
    }
}
