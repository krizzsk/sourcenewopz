package com.didi.global.globaluikit.dialog.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;
import java.util.ArrayList;
import java.util.List;

public class LEGODialogModel5 extends LEGOBaseDialogModel {

    /* renamed from: a */
    private String f22529a;

    /* renamed from: b */
    private List<String> f22530b;

    public LEGODialogModel5(String str, List<String> list, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(lEGOBtnTextAndCallback);
        this.f22529a = str;
        this.f22530b = list;
    }

    public String getSubTitle() {
        return this.f22529a;
    }

    public List<String> getSubContents() {
        return this.f22530b;
    }

    /* access modifiers changed from: protected */
    public void convertOthers(LEGORealUsedModel lEGORealUsedModel) {
        lEGORealUsedModel.mSubTitle = new LEGORealUsedModel.TextWidgetModel();
        lEGORealUsedModel.mSubTitle.text = getSubTitle();
        ArrayList arrayList = new ArrayList();
        for (String str : getSubContents()) {
            LEGORealUsedModel.TextWidgetModel textWidgetModel = new LEGORealUsedModel.TextWidgetModel();
            textWidgetModel.text = str;
            arrayList.add(textWidgetModel);
        }
        lEGORealUsedModel.mSubContents = arrayList;
    }
}
