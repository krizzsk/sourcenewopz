package com.didi.component.comp_recommend_boarding_point;

import com.didi.component.core.IView;

public interface IRecommendBoardingPointView extends IView<AbsRecommendBoardingPointPresent> {
    void hideView();

    void setButtonText(String str);

    void setContent(String str);

    void setTime(String str);

    void setTitle(String str);
}
