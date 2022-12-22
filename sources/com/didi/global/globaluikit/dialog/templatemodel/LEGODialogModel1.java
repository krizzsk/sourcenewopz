package com.didi.global.globaluikit.dialog.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;

public class LEGODialogModel1 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f22521a;

    public LEGODialogModel1(String str, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(lEGOBtnTextAndCallback);
        this.f22521a = str;
    }

    public String getTitle() {
        return this.f22521a;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mTitle = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mTitle.text = getTitle();
    }
}
