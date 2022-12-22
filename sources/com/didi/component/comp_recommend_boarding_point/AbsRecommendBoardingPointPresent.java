package com.didi.component.comp_recommend_boarding_point;

import android.content.Context;
import com.didi.component.comp_recommend_boarding_point.IRecommendBoardingPointView;
import com.didi.component.core.IPresenter;

public abstract class AbsRecommendBoardingPointPresent<V extends IRecommendBoardingPointView> extends IPresenter<V> {
    public abstract void cardUseDismissClick(boolean z);

    public AbsRecommendBoardingPointPresent(Context context) {
        super(context);
    }
}
