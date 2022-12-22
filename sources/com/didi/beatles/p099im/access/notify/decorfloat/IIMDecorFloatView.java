package com.didi.beatles.p099im.access.notify.decorfloat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.IIMDecorFloatView */
public interface IIMDecorFloatView {
    public static final int REMOVE_TYPE_DEFAULT = 0;
    public static final int REMOVE_TYPE_USER_CLICK = 2;
    public static final int REMOVE_TYPE_USER_CLOSE = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.access.notify.decorfloat.IIMDecorFloatView$RemoveType */
    public @interface RemoveType {
    }

    void onFloatViewRemoved(int i);
}
