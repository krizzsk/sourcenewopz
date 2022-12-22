package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMShareLocationBody */
public class IMShareLocationBody implements Serializable {
    public String shareId;
    public String text;
    public List<LocationUser> user;

    /* renamed from: com.didi.beatles.im.api.entity.IMShareLocationBody$LocationUser */
    public class LocationUser implements Serializable {
        public String img;
        public long uid;

        public LocationUser() {
        }
    }
}
