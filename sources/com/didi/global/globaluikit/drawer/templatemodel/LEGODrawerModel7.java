package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGOBtnModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel7 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f22587a;

    /* renamed from: b */
    private LEGOBtnTextAndCallback f22588b;

    public LEGODrawerModel7(String str, String str2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        super(str, lEGOBtnTextAndCallback2);
        this.f22587a = str2;
        this.f22588b = lEGOBtnTextAndCallback;
    }

    /* renamed from: a */
    private String m16235a() {
        return this.f22587a;
    }

    /* renamed from: b */
    private LEGOBtnTextAndCallback m16236b() {
        return this.f22588b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m16235a();
        lEGODrawerModel.leftText = widgetModel;
        LEGODrawerModel.WidgetModel widgetModel2 = new LEGODrawerModel.WidgetModel();
        widgetModel2.text = m16236b().getText();
        LEGOBtnModelAndCallback lEGOBtnModelAndCallback = new LEGOBtnModelAndCallback();
        lEGOBtnModelAndCallback.btnModel = widgetModel2;
        lEGOBtnModelAndCallback.listener = m16236b().getListener();
        lEGODrawerModel.rightBtn = lEGOBtnModelAndCallback;
        return lEGODrawerModel;
    }
}
