package com.didi.global.globalgenerickit.drawer.templatemodel;

import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKImgModel;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;

public class GGkDrawerModel9 extends GGKBaseDrawerModel {
    public GGkDrawerModel9(String str, GGKImgModel gGKImgModel, GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        super(str, gGKBtnTextAndCallback);
        setImgModel(gGKImgModel);
    }

    /* access modifiers changed from: protected */
    public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
        gGKDrawerModel.isImgUp = false;
        return gGKDrawerModel;
    }
}
