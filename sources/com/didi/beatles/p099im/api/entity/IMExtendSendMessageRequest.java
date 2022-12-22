package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMExtendSendMessageRequest */
public class IMExtendSendMessageRequest extends IMBaseRequest {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMExtendSendMessageRequest$Body */
    public static class Body implements Serializable {
        public String city_id;
        public List<IMMessageUp> msgs;
        public String new_srt;
        public String peer_img;
        public int peer_mattr;
        public String peer_nick;
        public long peer_uid;
        public String self_img;
        public int self_mattr;
        public String self_nick;
        public int send_type;
        public String soid;
        public String sys_text;
        public int ttl;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IMExtendSendMessageRequest(int i, int i2, int i3, String str, int i4, String str2, String str3, String str4, long j, String str5, String str6, int i5, String str7, String str8) {
        super(14, i5);
        Body body2 = new Body();
        this.body = body2;
        body2.self_mattr = i;
        this.body.peer_mattr = i2;
        this.body.send_type = i3;
        this.body.sys_text = str;
        this.body.ttl = i4;
        this.body.new_srt = str2;
        this.body.self_nick = str3;
        this.body.self_img = str4;
        this.body.peer_uid = j;
        this.body.peer_nick = str5;
        this.body.peer_img = str6;
        this.body.soid = str7;
        this.body.city_id = str8;
    }

    public void addMessage(IMMessageUp iMMessageUp) {
        if (this.body.msgs == null) {
            this.body.msgs = new ArrayList();
        }
        this.body.msgs.add(iMMessageUp);
    }
}
