package com.didi.unifiedPay.component.model;

import java.io.Serializable;

public class DownGradeInfo implements Serializable {
    public CharSequence text;
    public DownGrade type;
    public String url;

    public enum DownGrade {
        NORMAL,
        NOT_STABLE,
        NOT_USEABLE
    }

    public DownGradeInfo(DownGrade downGrade, CharSequence charSequence) {
        this.type = downGrade;
        this.text = charSequence;
    }
}
