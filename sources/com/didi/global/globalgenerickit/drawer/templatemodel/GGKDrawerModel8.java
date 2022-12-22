package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKDrawerModel8 extends GGKDrawerModel3 {

    /* renamed from: a */
    private String f22186a;

    /* renamed from: b */
    private GGKBtnTextAndCallback f22187b;

    public GGKDrawerModel8(String str, String str2, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener, String str3, GGKBtnTextAndCallback gGKBtnTextAndCallback, GGKBtnTextAndCallback gGKBtnTextAndCallback2, GGKBtnTextAndCallback gGKBtnTextAndCallback3) {
        super(str, str2, gGKOnAntiShakeClickListener, gGKBtnTextAndCallback2);
        this.f22186a = str3;
        this.f22187b = gGKBtnTextAndCallback;
        addMinorBtn(gGKBtnTextAndCallback3);
    }

    public String getSelectedText() {
        return this.f22186a;
    }

    public GGKBtnTextAndCallback getChangeBtn() {
        return this.f22187b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        super.convertOthers(gGKDrawerModel);
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getSelectedText();
        gGKDrawerModel.selectedText = widgetModel;
        gGKDrawerModel.changeBtn = getChangeBtn();
        gGKDrawerModel.isTwoBtnHorizontal = true;
        return gGKDrawerModel;
    }
}
