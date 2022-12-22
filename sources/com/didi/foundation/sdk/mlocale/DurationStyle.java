package com.didi.foundation.sdk.mlocale;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/foundation/sdk/mlocale/DurationStyle;", "", "style", "", "(Ljava/lang/String;II)V", "getStyle", "()I", "SS", "MM", "HH", "DD", "MM_SS", "HH_MM", "DD_HH", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Style.kt */
public enum DurationStyle {
    SS(0),
    MM(1),
    HH(2),
    DD(3),
    MM_SS(4),
    HH_MM(5),
    DD_HH(6);
    
    private final int style;

    private DurationStyle(int i) {
        this.style = i;
    }

    public final int getStyle() {
        return this.style;
    }
}
