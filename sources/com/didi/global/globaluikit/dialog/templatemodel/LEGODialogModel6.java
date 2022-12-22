package com.didi.global.globaluikit.dialog.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;

public class LEGODialogModel6 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f22531a;

    /* renamed from: b */
    private String f22532b;

    /* renamed from: c */
    private String f22533c;

    /* renamed from: d */
    private LEGOOnAntiShakeClickListener f22534d;

    public LEGODialogModel6(String str, String str2, String str3, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(lEGOBtnTextAndCallback);
        this.f22531a = str;
        this.f22532b = str2;
        this.f22533c = str3;
        this.f22534d = lEGOOnAntiShakeClickListener;
    }

    public LEGOOnAntiShakeClickListener getLinkClickedListener() {
        return this.f22534d;
    }

    public String getTitle() {
        return this.f22531a;
    }

    public String getContent() {
        return this.f22532b;
    }

    public String getDiscriptionText() {
        return this.f22533c;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mTitle = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mTitle.text = getTitle();
        lEGORealUsedModel.mContent = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mContent.text = getContent();
        lEGORealUsedModel.mDescription = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mDescription.text = getDiscriptionText();
        lEGORealUsedModel.mLinkClickedListener = getLinkClickedListener();
    }
}
