package com.didiglobal.eevee.comp.e_topbanner;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IView;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.EeveeComponent;
import com.didiglobal.common.common.never.component.EeveeIView;

@ComponentName(type = "eevee_top_banner")
public class EeveeTopBannerComponent extends EeveeComponent<EeveeIView, C16770a> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public ComponentPresenter onCreatePresenter(ComponentParams componentParams) {
        return new C16770a(componentParams);
    }
}
