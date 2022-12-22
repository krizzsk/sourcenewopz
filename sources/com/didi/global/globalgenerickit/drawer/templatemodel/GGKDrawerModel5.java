package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKCheckboxListener;
import com.didi.global.globalgenerickit.drawer.GGKCheckboxModelAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;

public class GGKDrawerModel5 extends GGKBaseDrawerModel {

    /* renamed from: a */
    private String f22180a;

    /* renamed from: b */
    private GGKCheckboxListener f22181b;

    public GGKDrawerModel5(String str, String str2, GGKCheckboxListener gGKCheckboxListener, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(str, gGKBtnTextAndCallback);
        this.f22180a = str2;
        this.f22181b = gGKCheckboxListener;
    }

    public String getCbText() {
        return this.f22180a;
    }

    public GGKCheckboxListener getListener() {
        return this.f22181b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getCbText();
        GGKCheckboxModelAndCallback gGKCheckboxModelAndCallback = new GGKCheckboxModelAndCallback();
        gGKCheckboxModelAndCallback.cbModel = widgetModel;
        gGKCheckboxModelAndCallback.listener = getListener();
        gGKDrawerModel.checkbox = gGKCheckboxModelAndCallback;
        return gGKDrawerModel;
    }
}
