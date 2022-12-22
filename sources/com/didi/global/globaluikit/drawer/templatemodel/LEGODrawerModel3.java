package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.LEGOLinkModelAndCallback;

public class LEGODrawerModel3 extends LEGOBaseDrawerModel {

    /* renamed from: a */
    private String f22577a;

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener f22578b;

    public LEGODrawerModel3(String str, String str2, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(str, lEGOBtnTextAndCallback);
        this.f22577a = str2;
        this.f22578b = lEGOOnAntiShakeClickListener;
    }

    /* renamed from: a */
    private String m16223a() {
        return this.f22577a;
    }

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener m16224b() {
        return this.f22578b;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
        widgetModel.text = m16223a();
        LEGOLinkModelAndCallback lEGOLinkModelAndCallback = new LEGOLinkModelAndCallback();
        lEGOLinkModelAndCallback.linkModel = widgetModel;
        lEGOLinkModelAndCallback.listener = m16224b();
        lEGODrawerModel.link = lEGOLinkModelAndCallback;
        return lEGODrawerModel;
    }
}
