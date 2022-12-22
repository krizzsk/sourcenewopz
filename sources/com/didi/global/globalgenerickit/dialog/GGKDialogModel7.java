package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKDialogModel7 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f22081a;

    /* renamed from: b */
    private String f22082b;

    /* renamed from: c */
    private String f22083c;

    /* renamed from: d */
    private GGKOnAntiShakeClickListener f22084d;

    public GGKDialogModel7(String str, String str2, String str3, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f22081a = str;
        this.f22082b = str2;
        this.f22083c = str3;
        this.f22084d = gGKOnAntiShakeClickListener;
    }

    public GGKOnAntiShakeClickListener getLinkClickedListener() {
        return this.f22084d;
    }

    public String getTitle() {
        return this.f22081a;
    }

    public String getContent() {
        return this.f22082b;
    }

    public String getDiscriptionText() {
        return this.f22083c;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f22085a = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22085a.text = getTitle();
        gGKRealUsedModel.f22086b = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22086b.text = getContent();
        gGKRealUsedModel.f22092h = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22092h.text = getDiscriptionText();
        gGKRealUsedModel.f22093i = getLinkClickedListener();
    }
}
