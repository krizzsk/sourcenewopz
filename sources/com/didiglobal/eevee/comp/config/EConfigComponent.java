package com.didiglobal.eevee.comp.config;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.EeveeComponent;

@ComponentName(type = "eevee_config")
public class EConfigComponent extends EeveeComponent<EAbsConfigView, EAbsConfigPresenter> {
    /* access modifiers changed from: protected */
    public EAbsConfigView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public EAbsConfigPresenter onCreatePresenter(ComponentParams componentParams) {
        return new EConfigPresenter(componentParams);
    }
}
