package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMPullSessionListResponse */
public class IMPullSessionListResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMPullSessionListResponse$Body */
    public static class Body implements Serializable {
        public List<GroupEntity> group;
        public Single single;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullSessionListResponse$GroupEntity */
    public static class GroupEntity implements Serializable {
        long lmt;
        long max_mid;
        long sid;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullSessionListResponse$Single */
    public static class Single implements Serializable {
        public long max_mid;
        public List<IMMessageDown> msgs;
    }
}
