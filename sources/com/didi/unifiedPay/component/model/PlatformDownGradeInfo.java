package com.didi.unifiedPay.component.model;

import java.io.Serializable;

public class PlatformDownGradeInfo implements Serializable {
    public CharSequence text;
    public PlatformDownGrade type;
    public String url;

    public enum PlatformDownGrade {
        NORMAL,
        BALANCE_NOT_ENOUGH,
        NOT_USEABLE
    }

    public PlatformDownGradeInfo(PlatformDownGrade platformDownGrade, CharSequence charSequence) {
        this.text = charSequence;
        this.type = platformDownGrade;
    }
}
