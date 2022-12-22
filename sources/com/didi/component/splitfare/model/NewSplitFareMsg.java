package com.didi.component.splitfare.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NewSplitFareMsg implements Serializable {
    public static final int INVITE_FROM_INNER_PUSH = 1;
    public static final int INVITE_FROM_MESSAGE = 3;
    public static final int INVITE_FROM_NOTIFICATION = 4;
    public static final int INVITE_FROM_OUTER_PUSH = 2;
    public int from;
    @SerializedName("icon")
    public String iconUrl;
    public transient boolean inHome;
    @SerializedName("title")
    public String msg;
    @SerializedName("oid")
    public String orderId;

    public String toString() {
        return "[NewSplitFareMsg], msg=" + this.msg + ", iconUrl=" + this.iconUrl;
    }
}
