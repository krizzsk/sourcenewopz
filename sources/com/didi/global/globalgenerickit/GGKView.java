package com.didi.global.globalgenerickit;

import android.view.View;
import com.didiglobal.dittoview.impl.DittoViewBinderImpl;
import com.didiglobal.dittoview.mvvm.DittoData;

public class GGKView {

    /* renamed from: a */
    private View f22039a;

    /* renamed from: b */
    private GGKViewBinder f22040b;

    /* renamed from: c */
    private DittoViewBinderImpl f22041c;

    public View getView() {
        return this.f22039a;
    }

    public GGKView(GGKViewBinder gGKViewBinder, View view) {
        this.f22040b = gGKViewBinder;
        this.f22039a = view;
    }

    public GGKView(DittoViewBinderImpl dittoViewBinderImpl, View view) {
        this.f22039a = view;
        this.f22041c = dittoViewBinderImpl;
    }

    public void bind(GGKData gGKData) {
        this.f22040b.bind(this.f22039a, gGKData);
    }

    public void bind(DittoData dittoData) {
        this.f22041c.bind(this.f22039a, dittoData);
    }
}
