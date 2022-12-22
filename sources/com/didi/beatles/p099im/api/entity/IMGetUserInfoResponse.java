package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMGetUserInfoResponse */
public class IMGetUserInfoResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMGetUserInfoResponse$Body */
    public static class Body implements Serializable {
        public List<UserInfo> infos;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMGetUserInfoResponse$UserExtendInfo */
    public static class UserExtendInfo implements Serializable {
        public String fol;
        public int owner;
        public int status;
        public String tag;
        public String ulink;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMGetUserInfoResponse$UserInfo */
    public static class UserInfo implements Serializable {
        public UserExtendInfo extend;
        public int m_icon;
        public String name;
        public String pic;
        public long uid;
    }
}
