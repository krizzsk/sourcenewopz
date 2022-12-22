package com.didi.global.globaluikit.drawer.templatemodel;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;

public class LEGODrawerModel9 extends LEGOBaseDrawerModel {
    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        return lEGODrawerModel;
    }

    public LEGODrawerModel9(String str, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback3) {
        super(str, lEGOBtnTextAndCallback);
        addMinorBtn(lEGOBtnTextAndCallback2);
        addMinorBtn(lEGOBtnTextAndCallback3);
        setDrawerStyle(5);
    }
}
