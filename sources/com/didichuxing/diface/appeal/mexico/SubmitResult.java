package com.didichuxing.diface.appeal.mexico;

import java.io.Serializable;

public class SubmitResult implements Serializable {
    public static final int CODE_REPEATED_SUBMIT = 100004;
    public String appealId;

    public String getAppealId() {
        return this.appealId;
    }

    public void setAppealId(String str) {
        this.appealId = str;
    }
}
