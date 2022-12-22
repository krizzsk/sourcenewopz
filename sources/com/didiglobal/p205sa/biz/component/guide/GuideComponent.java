package com.didiglobal.p205sa.biz.component.guide;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;

@ComponentName(category = 2, type = "sa_user_guide")
/* renamed from: com.didiglobal.sa.biz.component.guide.GuideComponent */
public class GuideComponent extends BaseComponent<GuideCardView, GuidCardPresenter> {
    /* access modifiers changed from: protected */
    public GuideCardView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new GuideCardView();
    }

    /* access modifiers changed from: protected */
    public GuidCardPresenter onCreatePresenter(ComponentParams componentParams) {
        return new GuidCardPresenter(componentParams);
    }
}
