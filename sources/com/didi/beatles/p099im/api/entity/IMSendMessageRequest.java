package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMSendMessageRequest */
public class IMSendMessageRequest extends IMBaseRequest {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMSendMessageRequest$Body */
    public static class Body implements Serializable {
        public String city_id;
        public List<IMMessageUp> msgs;
        public String new_srt;
        public String payload;
        public String peer_img;
        public String peer_nick;
        public long peer_uid;
        public String self_img;
        public String self_nick;
        public String soid;
    }

    public IMSendMessageRequest(String str, String str2, String str3, long j, String str4, String str5, int i, String str6, String str7, String str8) {
        super(3, i);
        Body body2 = new Body();
        this.body = body2;
        body2.new_srt = str;
        this.body.self_nick = str2;
        this.body.self_img = str3;
        this.body.peer_uid = j;
        this.body.peer_nick = str4;
        this.body.peer_img = str5;
        this.body.soid = str6;
        this.body.city_id = str7;
        this.body.payload = str8;
    }

    public IMSendMessageRequest(long j, String str, int i) {
        super(3);
        Body body2 = new Body();
        this.body = body2;
        body2.peer_uid = j;
        this.body.payload = str;
        this.product = i;
    }

    public void addMessage(IMMessageUp iMMessageUp) {
        if (this.body.msgs == null) {
            this.body.msgs = new ArrayList();
        }
        this.body.msgs.add(iMMessageUp);
    }
}
