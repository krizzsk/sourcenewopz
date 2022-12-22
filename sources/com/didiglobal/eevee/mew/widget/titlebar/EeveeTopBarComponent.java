package com.didiglobal.eevee.mew.widget.titlebar;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.EeveeComponent;

@ComponentName(type = "eevee_top_bar")
public class EeveeTopBarComponent extends EeveeComponent<EeveeTopBarView, C16807a> {
    /* access modifiers changed from: protected */
    public EeveeTopBarView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new EeveeTopBarView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public C16807a onCreatePresenter(ComponentParams componentParams) {
        C16807a aVar = new C16807a(componentParams);
        aVar.mo122486a(this);
        return aVar;
    }
}
