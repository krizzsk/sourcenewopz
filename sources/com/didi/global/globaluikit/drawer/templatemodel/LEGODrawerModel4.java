package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.LEGOLinkModelAndCallback;

public class LEGODrawerModel4 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f22579a;

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener f22580b;

    public LEGODrawerModel4(String str, String str2, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        super(str, lEGOBtnTextAndCallback);
        this.f22579a = str2;
        this.f22580b = lEGOOnAntiShakeClickListener;
        addMinorBtn(lEGOBtnTextAndCallback2);
    }

    /* renamed from: a */
    private String m16225a() {
        return this.f22579a;
    }

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener m16226b() {
        return this.f22580b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m16225a();
        LEGOLinkModelAndCallback lEGOLinkModelAndCallback = new LEGOLinkModelAndCallback();
        lEGOLinkModelAndCallback.linkModel = widgetModel;
        lEGOLinkModelAndCallback.listener = m16226b();
        lEGODrawerModel.link = lEGOLinkModelAndCallback;
        lEGODrawerModel.isTwoBtnHorizontal = true;
        return lEGODrawerModel;
    }
}
