package com.didi.component.pudo;

import android.view.ViewGroup;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.pudo.newversion.ConfirmGetOnPresenter;
import com.didi.component.pudo.newversion.ConfirmGetOnPudoView;

@ComponentRegister(product = "ride", type = "pudo")
public class PudoComponent extends SelfControlComponent<IPudoView, AbsPudoPresenter, C6604a> {
    /* access modifiers changed from: protected */
    public IPudoView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new ConfirmGetOnPudoView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public C6604a createInflateController() {
        return new C6604a();
    }

    /* access modifiers changed from: protected */
    public AbsPudoPresenter onCreatePresenter(ComponentParams componentParams) {
        return new ConfirmGetOnPresenter(componentParams);
    }
}
