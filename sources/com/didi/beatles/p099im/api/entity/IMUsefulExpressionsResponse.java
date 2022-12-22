package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMUsefulExpressionsResponse */
public class IMUsefulExpressionsResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMUsefulExpressionsResponse$Body */
    public static class Body implements Serializable {
        public List<Content> info;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMUsefulExpressionsResponse$Content */
    public class Content implements Serializable {
        public String txt;

        public Content() {
        }
    }
}
