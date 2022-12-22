package com.didi.component.service.activity.risk.dialog;

import com.didi.component.common.dialog.DialogInfo;

public class LoadingDialogInfo extends DialogInfo {

    /* renamed from: a */
    private String f15702a;

    public LoadingDialogInfo(int i) {
        super(i);
    }

    public LoadingDialogInfo setMessage(String str) {
        this.f15702a = str;
        return this;
    }

    public String getMessage() {
        return this.f15702a;
    }
}
