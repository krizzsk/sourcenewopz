package com.didi.global.globalgenerickit.dialog;

import android.text.TextWatcher;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel5 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f22075a;

    /* renamed from: b */
    private String f22076b;

    /* renamed from: c */
    private TextWatcher f22077c;

    /* renamed from: d */
    private String f22078d;

    public GGKDialogModel5(String str, String str2, String str3, GGKBtnTextAndCallback gGKBtnTextAndCallback, TextWatcher textWatcher) {
        super(gGKBtnTextAndCallback);
        this.f22075a = str;
        this.f22076b = str2;
        this.f22077c = textWatcher;
        this.f22078d = str3;
    }

    public String getTitle() {
        return this.f22075a;
    }

    public String getContent() {
        return this.f22076b;
    }

    public TextWatcher getEditListener() {
        return this.f22077c;
    }

    public String getHint() {
        return this.f22078d;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f22085a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22085a.text = getTitle();
        gGKRealUsedModel.f22086b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22086b.text = getContent();
        gGKRealUsedModel.f22088d = getEditListener();
        gGKRealUsedModel.f22089e = getHint();
    }
}
