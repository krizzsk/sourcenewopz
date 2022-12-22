package com.didi.beatles.p099im.protocol.view;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.protocol.view.IMGuideConfig */
public class IMGuideConfig {
    public static final String POS_MORE = "more";
    public static final String POS_MSG = "msg";
    public String position;
    public String text;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.protocol.view.IMGuideConfig$PosTag */
    public @interface PosTag {
    }

    public IMGuideConfig(String str, String str2) {
        this.position = str;
        this.text = str2;
    }
}
