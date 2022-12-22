package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.drawer.LEGOCheckboxModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel5 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f22581a;

    /* renamed from: b */
    private LEGOCheckboxListener f22582b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f22583c;

    public LEGODrawerModel5(String str, String str2, boolean z, LEGOCheckboxListener lEGOCheckboxListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(str, lEGOBtnTextAndCallback);
        this.f22581a = str2;
        this.f22583c = z;
        this.f22582b = lEGOCheckboxListener;
    }

    /* renamed from: a */
    private String m16228a() {
        return this.f22581a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public LEGOCheckboxListener m16230b() {
        return this.f22582b;
    }

    public boolean getChecked() {
        return this.f22583c;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m16228a();
        LEGOCheckboxModelAndCallback lEGOCheckboxModelAndCallback = new LEGOCheckboxModelAndCallback();
        lEGOCheckboxModelAndCallback.cbModel = widgetModel;
        lEGOCheckboxModelAndCallback.checked = getChecked();
        lEGOCheckboxModelAndCallback.listener = new LEGOCheckboxListener() {
            public void onCheckedChanged(boolean z) {
                boolean unused = LEGODrawerModel5.this.f22583c = z;
                LEGODrawerModel5.this.m16230b().onCheckedChanged(z);
            }
        };
        lEGODrawerModel.checkbox = lEGOCheckboxModelAndCallback;
        return lEGODrawerModel;
    }
}
