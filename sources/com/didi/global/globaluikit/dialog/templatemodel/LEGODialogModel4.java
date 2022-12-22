package com.didi.global.globaluikit.dialog.templatemodel;

import android.widget.CompoundButton;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;

public class LEGODialogModel4 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f22525a;

    /* renamed from: b */
    private String f22526b;

    /* renamed from: c */
    private String f22527c;

    /* renamed from: d */
    private CompoundButton.OnCheckedChangeListener f22528d;

    public LEGODialogModel4(String str, String str2, String str3, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super(lEGOBtnTextAndCallback);
        this.f22526b = str2;
        this.f22525a = str;
        this.f22527c = str3;
        this.f22528d = onCheckedChangeListener;
    }

    public String getTitle() {
        return this.f22525a;
    }

    public String getContent() {
        return this.f22526b;
    }

    public String getCheckBoxText() {
        return this.f22527c;
    }

    public CompoundButton.OnCheckedChangeListener getCheckboxListener() {
        return this.f22528d;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mTitle = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent.text = getContent();
        lEGORealUsedModel.mTitle.text = getTitle();
        lEGORealUsedModel.mCheckContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mCheckContent.text = getCheckBoxText();
        lEGORealUsedModel.mLEGOCheckboxListener = getCheckboxListener();
    }
}
