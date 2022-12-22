package com.didiglobal.eevee.mew;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.EeveeComponent;

@ComponentName(type = "eevee_mew")
public class EMewComponent extends EeveeComponent<EMewView, C16805a> {
    /* access modifiers changed from: protected */
    public EMewView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new EMewView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public C16805a onCreatePresenter(ComponentParams componentParams) {
        return new C16805a(componentParams);
    }
}
