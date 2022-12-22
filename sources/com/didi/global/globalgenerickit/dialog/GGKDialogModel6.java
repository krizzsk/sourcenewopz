package com.didi.global.globalgenerickit.dialog;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;
import java.util.ArrayList;
import java.util.List;

public class GGKDialogModel6 extends GGKBaseDialogModel {

    /* renamed from: a */
    private String f22079a;

    /* renamed from: b */
    private List<String> f22080b;

    public GGKDialogModel6(String str, List<String> list, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(gGKBtnTextAndCallback);
        this.f22079a = str;
        this.f22080b = list;
    }

    public String getSubTitle() {
        return this.f22079a;
    }

    public List<String> getSubContents() {
        return this.f22080b;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(GGKRealUsedModel gGKRealUsedModel) {
        gGKRealUsedModel.f22095k = new GGKRealUsedModel.TextWidgetModel();
        gGKRealUsedModel.f22095k.text = getSubTitle();
        ArrayList arrayList = new ArrayList();
        for (String str : getSubContents()) {
            GGKRealUsedModel.TextWidgetModel textWidgetModel = new GGKRealUsedModel.TextWidgetModel();
            textWidgetModel.text = str;
            arrayList.add(textWidgetModel);
        }
        gGKRealUsedModel.f22096l = arrayList;
    }
}
