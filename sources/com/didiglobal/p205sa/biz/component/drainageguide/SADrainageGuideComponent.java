package com.didiglobal.p205sa.biz.component.drainageguide;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;

@ComponentName(category = 2, type = "passenger_drainage_guide")
/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideComponent */
public class SADrainageGuideComponent extends BaseComponent<SADrainageGuideCardView, SADrainageGuideCardPresenter> {
    /* access modifiers changed from: protected */
    public SADrainageGuideCardView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new SADrainageGuideCardView();
    }

    /* access modifiers changed from: protected */
    public SADrainageGuideCardPresenter onCreatePresenter(ComponentParams componentParams) {
        return new SADrainageGuideCardPresenter(componentParams);
    }
}
