package com.didi.beatles.p099im.protocol.view;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.protocol.view.IMSkinConfig */
public class IMSkinConfig {
    public static final int CANCEL = 3;
    public static final int COMMON = 2;
    public static final int DISABLE = 1;
    public int paddingConfig = -1;
    public List<Element> skinElement = new ArrayList(2);

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.protocol.view.IMSkinConfig$SkinTag */
    public @interface SkinTag {
    }

    /* renamed from: com.didi.beatles.im.protocol.view.IMSkinConfig$Element */
    public static class Element {
        public int drawable;
        public int tag;

        public Element(int i, int i2) {
            this.tag = i;
            this.drawable = i2;
        }
    }
}
