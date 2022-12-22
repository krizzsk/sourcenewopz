package com.didi.component.comp_recommend_boarding_point;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_recommend_boarding_point.present.RecommendBoardingPointPresent;
import com.didi.component.comp_recommend_boarding_point.view.RecommendBoardingPointView;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "xpanel_pax_boarding_modify_card")
public class RecommendBoardingPointComponent extends BaseComponent<IRecommendBoardingPointView, AbsRecommendBoardingPointPresent> {
    /* access modifiers changed from: protected */
    public IRecommendBoardingPointView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new RecommendBoardingPointView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsRecommendBoardingPointPresent onCreatePresenter(ComponentParams componentParams) {
        return new RecommendBoardingPointPresent(componentParams);
    }
}
