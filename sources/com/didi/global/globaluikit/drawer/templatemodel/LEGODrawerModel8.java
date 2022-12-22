package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGOBtnModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel8 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f22589a;

    /* renamed from: b */
    private LEGOBtnTextAndCallback f22590b;

    public LEGODrawerModel8(String str, String str2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback3) {
        super(str, lEGOBtnTextAndCallback2);
        this.f22589a = str2;
        this.f22590b = lEGOBtnTextAndCallback;
        addMinorBtn(lEGOBtnTextAndCallback3);
    }

    /* renamed from: a */
    private String m16237a() {
        return this.f22589a;
    }

    /* renamed from: b */
    private LEGOBtnTextAndCallback m16238b() {
        return this.f22590b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m16237a();
        LEGODrawerModel.WidgetModel widgetModel2 = new LEGODrawerModel.WidgetModel();
        widgetModel2.text = m16238b().getText();
        LEGOBtnModelAndCallback lEGOBtnModelAndCallback = new LEGOBtnModelAndCallback();
        lEGOBtnModelAndCallback.btnModel = widgetModel2;
        lEGOBtnModelAndCallback.listener = m16238b().getListener();
        lEGODrawerModel.leftText = widgetModel;
        lEGODrawerModel.rightBtn = lEGOBtnModelAndCallback;
        lEGODrawerModel.isTwoBtnHorizontal = true;
        return lEGODrawerModel;
    }
}
