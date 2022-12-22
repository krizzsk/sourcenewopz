package com.didiglobal.e_where2go;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.EeveeComponent;

@ComponentName(type = "eevee_where_to_go")
public class EWhere2goComponent extends EeveeComponent<EWhere2goView, EWhere2goPresenter> {
    /* access modifiers changed from: protected */
    public EWhere2goView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new EWhere2goView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public EWhere2goPresenter onCreatePresenter(ComponentParams componentParams) {
        return new EWhere2goPresenter(componentParams);
    }
}
