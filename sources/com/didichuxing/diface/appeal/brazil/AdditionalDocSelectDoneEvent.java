package com.didichuxing.diface.appeal.brazil;

import android.text.TextUtils;

public class AdditionalDocSelectDoneEvent {
    public final String select;

    public AdditionalDocSelectDoneEvent(String str) {
        this.select = str;
    }

    public boolean isCancel() {
        return TextUtils.isEmpty(this.select);
    }
}
