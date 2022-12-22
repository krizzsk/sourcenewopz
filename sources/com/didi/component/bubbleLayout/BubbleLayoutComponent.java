package com.didi.component.bubbleLayout;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.bubbleLayout.impl.BubbleLayoutPresenter;
import com.didi.component.bubbleLayout.impl.BubbleLayoutView;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "bubble_layout")
public class BubbleLayoutComponent extends BaseComponent<IBubbleLayoutView, AbsBubbleLayoutPresenter> {
    /* access modifiers changed from: protected */
    public IBubbleLayoutView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new BubbleLayoutView(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsBubbleLayoutPresenter onCreatePresenter(ComponentParams componentParams) {
        return new BubbleLayoutPresenter(componentParams);
    }
}
