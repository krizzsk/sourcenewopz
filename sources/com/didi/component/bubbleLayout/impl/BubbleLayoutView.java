package com.didi.component.bubbleLayout.impl;

import android.view.View;
import android.view.ViewGroup;
import com.didi.component.bubbleLayout.AbsBubbleLayoutPresenter;
import com.didi.component.bubbleLayout.IBubbleLayoutView;
import com.didi.component.bubbleLayout.anycar.AnycarBubbleLayout;
import com.didi.component.bubbleLayout.view.BubbleAnimationLayout;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IViewContainer;

public class BubbleLayoutView implements IBubbleLayoutView, IViewContainer {

    /* renamed from: a */
    private BubbleAnimationLayout f11127a;

    /* renamed from: b */
    private AnycarBubbleLayout f11128b;

    /* renamed from: c */
    private AbsBubbleLayoutPresenter f11129c;

    public BubbleLayoutView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f11127a = new BubbleAnimationLayout(componentParams.getActivity());
    }

    public View getView() {
        return this.f11127a;
    }

    public void setPresenter(AbsBubbleLayoutPresenter absBubbleLayoutPresenter) {
        this.f11129c = absBubbleLayoutPresenter;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        AbsBubbleLayoutPresenter absBubbleLayoutPresenter = this.f11129c;
        if (absBubbleLayoutPresenter != null) {
            absBubbleLayoutPresenter.setComponentCreator(iComponentCreator);
        }
    }
}
