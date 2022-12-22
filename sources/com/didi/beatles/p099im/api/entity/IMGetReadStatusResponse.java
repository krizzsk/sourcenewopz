package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMGetReadStatusResponse */
public class IMGetReadStatusResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMGetReadStatusResponse$Body */
    public static class Body implements Serializable {
        public List<Long> mids;
    }
}
