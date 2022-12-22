package com.didi.beatles.p099im.push;

import com.didi.beatles.p099im.api.entity.IMBaseResponse;
import java.util.List;

/* renamed from: com.didi.beatles.im.push.IMNotificationMsg */
public class IMNotificationMsg extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.push.IMNotificationMsg$AckResponse */
    public static class AckResponse {
        public Long mid;
        public long sid;
    }

    /* renamed from: com.didi.beatles.im.push.IMNotificationMsg$Body */
    public static class Body {
        public List<NewMessages> new_msgs;
        public List<AckResponse> rd_acks;
        public List<String> uids;
    }

    /* renamed from: com.didi.beatles.im.push.IMNotificationMsg$NewMessages */
    public static class NewMessages {
        public Long mid;
        public int mty;
        public Long oid;
        public long sid;
        public int sty;
        public Long uid;
    }
}
