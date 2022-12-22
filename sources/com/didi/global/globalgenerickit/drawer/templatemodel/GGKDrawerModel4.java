package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.GGKLinkModelAndCallback;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKDrawerModel4 extends GGKBaseDrawerModel {

    /* renamed from: a */
    private String f22178a;

    /* renamed from: b */
    private GGKOnAntiShakeClickListener f22179b;

    public GGKDrawerModel4(String str, String str2, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener, GGKBtnTextAndCallback gGKBtnTextAndCallback, GGKBtnTextAndCallback gGKBtnTextAndCallback2) {
        super(str, gGKBtnTextAndCallback);
        this.f22178a = str2;
        this.f22179b = gGKOnAntiShakeClickListener;
        addMinorBtn(gGKBtnTextAndCallback2);
    }

    public String getLinkText() {
        return this.f22178a;
    }

    public GGKOnAntiShakeClickListener getListener() {
        return this.f22179b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getLinkText();
        GGKLinkModelAndCallback gGKLinkModelAndCallback = new GGKLinkModelAndCallback();
        gGKLinkModelAndCallback.linkModel = widgetModel;
        gGKLinkModelAndCallback.listener = getListener();
        gGKDrawerModel.link = gGKLinkModelAndCallback;
        gGKDrawerModel.isTwoBtnHorizontal = true;
        return gGKDrawerModel;
    }
}
