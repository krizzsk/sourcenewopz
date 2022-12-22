package com.didi.component.evaluateentrance.evaluate.presenter;

import android.content.Context;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluateentrance.evaluate.view.AbsFiveStarView;

public abstract class AbsFiveStarPresenter extends AbsEvaluatePresenter<AbsFiveStarView> implements XpNewAdapter {
    public abstract void onEvaluatedClicked(int i, String str);

    public AbsFiveStarPresenter(Context context) {
        super(context);
    }

    public AbsFiveStarPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
