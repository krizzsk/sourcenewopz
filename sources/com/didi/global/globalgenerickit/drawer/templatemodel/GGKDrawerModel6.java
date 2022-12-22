package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKCheckboxListener;
import com.didi.global.globalgenerickit.drawer.GGKCheckboxModelAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;

public class GGKDrawerModel6 extends GGKBaseDrawerModel {

    /* renamed from: a */
    private String f22182a;

    /* renamed from: b */
    private GGKCheckboxListener f22183b;

    public GGKDrawerModel6(String str, String str2, GGKCheckboxListener gGKCheckboxListener, GGKBtnTextAndCallback gGKBtnTextAndCallback, GGKBtnTextAndCallback gGKBtnTextAndCallback2) {
        super(str, gGKBtnTextAndCallback);
        this.f22182a = str2;
        this.f22183b = gGKCheckboxListener;
        addMinorBtn(gGKBtnTextAndCallback2);
    }

    public String getCbText() {
        return this.f22182a;
    }

    public GGKCheckboxListener getListener() {
        return this.f22183b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getCbText();
        GGKCheckboxModelAndCallback gGKCheckboxModelAndCallback = new GGKCheckboxModelAndCallback();
        gGKCheckboxModelAndCallback.cbModel = widgetModel;
        gGKCheckboxModelAndCallback.listener = getListener();
        gGKDrawerModel.checkbox = gGKCheckboxModelAndCallback;
        gGKDrawerModel.isTwoBtnHorizontal = true;
        return gGKDrawerModel;
    }
}
