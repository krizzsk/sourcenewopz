package com.didiglobal.e_container.home;

import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.container.EeveeContainer;

@ComponentName(category = 4, type = "eevee_template_container_mew")
public class HomeContainerComponent extends EeveeContainer<HomeContainerPresenter> {
    /* access modifiers changed from: protected */
    public HomeContainerPresenter onCreatePresenter(ComponentParams componentParams) {
        return new HomeContainerPresenter(componentParams);
    }
}
