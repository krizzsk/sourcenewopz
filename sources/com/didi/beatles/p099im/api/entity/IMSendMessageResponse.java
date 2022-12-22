package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMSendMessageResponse */
public class IMSendMessageResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMSendMessageResponse$Body */
    public static class Body implements Serializable {
        public long[] mids;
        public RspMsg[] msgs;
        public String recom;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMSendMessageResponse$RspMsg */
    public static class RspMsg implements Serializable {
        public long mid;
        public String uniq_msg_id;
    }
}
