package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsFiveStarPresenter;

public abstract class AbsFiveStarView implements IFiveStarView {
    protected final Context context;
    protected ViewGroup parentView;
    protected AbsFiveStarPresenter presenter;

    public AbsFiveStarView(Context context2) {
        this.context = context2;
    }

    public View getView() {
        return this.parentView;
    }

    public void setPresenter(AbsFiveStarPresenter absFiveStarPresenter) {
        this.presenter = absFiveStarPresenter;
    }
}
