package com.didiglobal.dittoview.mvvm;

import android.view.View;

public class DittoView {

    /* renamed from: a */
    private View f49893a;

    /* renamed from: b */
    private DittoViewBinder f49894b;

    public View getView() {
        return this.f49893a;
    }

    public DittoView(DittoViewBinder dittoViewBinder, View view) {
        this.f49894b = dittoViewBinder;
        this.f49893a = view;
    }

    public void bind(DittoData dittoData) {
        this.f49894b.bind(this.f49893a, dittoData);
    }
}
