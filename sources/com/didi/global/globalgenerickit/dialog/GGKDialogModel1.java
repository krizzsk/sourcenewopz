package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel1 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f22067a;

    public GGKDialogModel1(String str, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f22067a = str;
    }

    public String getTitle() {
        return this.f22067a;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f22085a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22085a.text = getTitle();
    }
}
