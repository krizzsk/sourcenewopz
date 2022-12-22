package com.global.didi.elvish;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo175978d2 = {"Lcom/global/didi/elvish/DateStyle;", "", "style", "", "(Ljava/lang/String;II)V", "getStyle", "()I", "DATE_DD_MM_YYYY", "DATE_DD_MM_YY", "DATE_MTH_YYYY", "DATE_EEE_DD_MTH", "DATE_DD_MTH", "NONE", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Style.kt */
public enum DateStyle {
    DATE_DD_MM_YYYY(2),
    DATE_DD_MM_YY(3),
    DATE_MTH_YYYY(4),
    DATE_EEE_DD_MTH(5),
    DATE_DD_MTH(6),
    NONE(-1);
    
    private final int style;

    private DateStyle(int i) {
        this.style = i;
    }

    public final int getStyle() {
        return this.style;
    }
}
