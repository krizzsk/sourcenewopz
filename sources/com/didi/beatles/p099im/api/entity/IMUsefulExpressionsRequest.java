package com.didi.beatles.p099im.api.entity;

import android.text.TextUtils;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMUsefulExpressionsRequest */
public class IMUsefulExpressionsRequest extends IMBaseRequest {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMUsefulExpressionsRequest$Body */
    public static class Body implements Serializable {
        public Content cont;
        public int source;
        public int sub_type;
    }

    public IMUsefulExpressionsRequest(int i, int i2, String str, String str2) {
        super(16);
        Body body2 = new Body();
        this.body = body2;
        body2.sub_type = i;
        this.body.source = i2;
        if (!TextUtils.isEmpty(str)) {
            Content content = new Content();
            content.txt = str;
            content.src_txt = str2;
            this.body.cont = content;
        }
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMUsefulExpressionsRequest$Content */
    public class Content implements Serializable {
        public String src_txt;
        public String txt;

        public Content() {
        }
    }
}
