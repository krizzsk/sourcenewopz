package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel2 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f22068a;

    public GGKDialogModel2(String str, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f22068a = str;
    }

    public String getContentText() {
        return this.f22068a;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f22086b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22086b.text = getContentText();
    }
}
