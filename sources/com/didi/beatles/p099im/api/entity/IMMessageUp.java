package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMMessageUp */
public class IMMessageUp implements Serializable {
    public IMDetailBody body = new IMDetailBody();
    public int is_qk;
    public long local_id;
    @SerializedName("msg_source")
    public int msg_source;
    public int msg_type;
    public long order_id;
    public long route_id;
    public long sid;
    public long time;
}
