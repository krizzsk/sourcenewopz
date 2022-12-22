package com.didi.component.evaluateentrance.evaluate;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsFiveStarPresenter;
import com.didi.component.evaluateentrance.evaluate.presenter.FiveStarPresenter;
import com.didi.component.evaluateentrance.evaluate.view.AbsFiveStarView;
import com.didi.component.evaluateentrance.evaluate.view.FiveStarView;

@ComponentRegister(product = "ride", type = "evaluate_five_star_entrance")
public class FiveStarComponet extends BaseComponent<AbsFiveStarView, AbsFiveStarPresenter> {
    /* access modifiers changed from: protected */
    public AbsFiveStarView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new FiveStarView(componentParams.bizCtx.getContext());
    }

    /* access modifiers changed from: protected */
    public AbsFiveStarPresenter onCreatePresenter(ComponentParams componentParams) {
        return new FiveStarPresenter(componentParams);
    }
}
