package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel2 extends LEGOBaseDrawerModel {
    public LEGODrawerModel2(String str, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        super(str, lEGOBtnTextAndCallback);
        addMinorBtn(lEGOBtnTextAndCallback2);
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        lEGODrawerModel.isTwoBtnHorizontal = true;
        return lEGODrawerModel;
    }
}
