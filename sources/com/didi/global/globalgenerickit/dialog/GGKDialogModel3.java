package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel3 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f22069a;

    /* renamed from: b */
    private String f22070b;

    public GGKDialogModel3(String str, String str2, GGKBtnTextAndCallback... gGKBtnTextAndCallbackArr) {
        super(gGKBtnTextAndCallbackArr);
        this.f22070b = str2;
        this.f22069a = str;
    }

    public GGKDialogModel3(String str, String str2) {
        super(new GGKBtnTextAndCallback[0]);
        this.f22070b = str2;
        this.f22069a = str;
    }

    public String getTitle() {
        return this.f22069a;
    }

    public String getContent() {
        return this.f22070b;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f22085a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22086b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22085a.text = getTitle();
        gGKRealUsedModel.f22086b.text = getContent();
    }
}
