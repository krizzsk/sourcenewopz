package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMMessageDown */
public class IMMessageDown implements Serializable {
    public IMDetailBody body = new IMDetailBody();
    @SerializedName("card_view")
    public String dmcCardInfo;
    public String head_url;
    public int mact;
    public long mattr;
    public int mid;
    public int msg_type;
    public String nick;
    public long peer_uid;
    public int product;
    public int session_type;
    public long sid;
    public long time;
    public long uid;
    public String uniq_msg_id;
}
