package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMGetSessionInfoResponse */
public class IMGetSessionInfoResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMGetSessionInfoResponse$Body */
    public static class Body implements Serializable {
        public List<IMSessionInfo> infos;
        public String recom;
    }
}
