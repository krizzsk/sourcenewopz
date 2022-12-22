package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKImgModel;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;

public class GGKDrawerModel10 extends GGKBaseDrawerModel {
    public GGKDrawerModel10(String str, GGKImgModel gGKImgModel, GGKBtnTextAndCallback gGKBtnTextAndCallback, GGKBtnTextAndCallback gGKBtnTextAndCallback2) {
        super(str, gGKBtnTextAndCallback);
        setImgModel(gGKImgModel);
        addMinorBtn(gGKBtnTextAndCallback2);
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        gGKDrawerModel.isImgUp = false;
        gGKDrawerModel.isTwoBtnHorizontal = true;
        return gGKDrawerModel;
    }
}
