package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.drawer.LEGOCheckboxModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel6 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f22584a;

    /* renamed from: b */
    private LEGOCheckboxListener f22585b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f22586c;

    public LEGODrawerModel6(String str, String str2, boolean z, LEGOCheckboxListener lEGOCheckboxListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        super(str, lEGOBtnTextAndCallback);
        this.f22584a = str2;
        this.f22586c = z;
        this.f22585b = lEGOCheckboxListener;
        addMinorBtn(lEGOBtnTextAndCallback2);
    }

    /* renamed from: a */
    private String m16232a() {
        return this.f22584a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public LEGOCheckboxListener m16234b() {
        return this.f22585b;
    }

    public boolean getChecked() {
        return this.f22586c;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m16232a();
        LEGOCheckboxModelAndCallback lEGOCheckboxModelAndCallback = new LEGOCheckboxModelAndCallback();
        lEGOCheckboxModelAndCallback.cbModel = widgetModel;
        lEGOCheckboxModelAndCallback.checked = getChecked();
        lEGOCheckboxModelAndCallback.listener = new LEGOCheckboxListener() {
            public void onCheckedChanged(boolean z) {
                boolean unused = LEGODrawerModel6.this.f22586c = z;
                LEGODrawerModel6.this.m16234b().onCheckedChanged(z);
            }
        };
        lEGODrawerModel.checkbox = lEGOCheckboxModelAndCallback;
        lEGODrawerModel.isTwoBtnHorizontal = true;
        return lEGODrawerModel;
    }
}
