package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKDrawerModel7 extends GGKDrawerModel3 {

    /* renamed from: a */
    private String f22184a;

    /* renamed from: b */
    private GGKBtnTextAndCallback f22185b;

    public GGKDrawerModel7(String str, String str2, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener, String str3, GGKBtnTextAndCallback gGKBtnTextAndCallback, GGKBtnTextAndCallback gGKBtnTextAndCallback2) {
        super(str, str2, gGKOnAntiShakeClickListener, gGKBtnTextAndCallback2);
        this.f22184a = str3;
        this.f22185b = gGKBtnTextAndCallback;
    }

    public String getSelectedText() {
        return this.f22184a;
    }

    public GGKBtnTextAndCallback getChangeBtn() {
        return this.f22185b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        super.convertOthers(gGKDrawerModel);
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getSelectedText();
        gGKDrawerModel.selectedText = widgetModel;
        gGKDrawerModel.changeBtn = getChangeBtn();
        return gGKDrawerModel;
    }
}
