package com.didi.component.comp_flex.automatic_match;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "flex_automatic_match_card")
public class AutomatichMatchComponent extends BaseComponent<AutomaticMatchView, AutomaticMatchPresenter> {
    /* access modifiers changed from: protected */
    public AutomaticMatchView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new AutomaticMatchView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AutomaticMatchPresenter onCreatePresenter(ComponentParams componentParams) {
        return new AutomaticMatchPresenter(componentParams);
    }
}
