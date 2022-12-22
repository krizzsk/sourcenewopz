package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.GGKLinkModelAndCallback;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKDrawerModel3 extends GGKBaseDrawerModel {

    /* renamed from: a */
    private String f22176a;

    /* renamed from: b */
    private GGKOnAntiShakeClickListener f22177b;

    public GGKDrawerModel3(String str, String str2, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(str, gGKBtnTextAndCallback);
        this.f22176a = str2;
        this.f22177b = gGKOnAntiShakeClickListener;
    }

    public String getLinkText() {
        return this.f22176a;
    }

    public GGKOnAntiShakeClickListener getListener() {
        return this.f22177b;
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        GGKDrawerModel.WidgetModel widgetModel = new GGKDrawerModel.WidgetModel();
        widgetModel.text = getLinkText();
        GGKLinkModelAndCallback gGKLinkModelAndCallback = new GGKLinkModelAndCallback();
        gGKLinkModelAndCallback.linkModel = widgetModel;
        gGKLinkModelAndCallback.listener = getListener();
        gGKDrawerModel.link = gGKLinkModelAndCallback;
        return gGKDrawerModel;
    }
}
