package com.didi.global.globalgenerickit.dialog;

import android.widget.CompoundButton;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;

public class GGKDialogModel4 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f22071a;

    /* renamed from: b */
    private String f22072b;

    /* renamed from: c */
    private String f22073c;

    /* renamed from: d */
    private CompoundButton.OnCheckedChangeListener f22074d;

    public GGKDialogModel4(String str, String str2, String str3, GGKBtnTextAndCallback gGKBtnTextAndCallback, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super(gGKBtnTextAndCallback);
        this.f22072b = str2;
        this.f22071a = str;
        this.f22073c = str3;
        this.f22074d = onCheckedChangeListener;
    }

    public String getTitle() {
        return this.f22071a;
    }

    public String getContent() {
        return this.f22072b;
    }

    public String getCheckBoxText() {
        return this.f22073c;
    }

    public CompoundButton.OnCheckedChangeListener getCheckboxListener() {
        return this.f22074d;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f22085a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22086b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22086b.text = getContent();
        gGKRealUsedModel.f22085a.text = getTitle();
        gGKRealUsedModel.f22087c = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22087c.text = getCheckBoxText();
        gGKRealUsedModel.f22090f = getCheckboxListener();
    }
}
