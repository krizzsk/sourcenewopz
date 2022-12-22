package com.didi.beatles.p099im.access.msg;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.access.msg.OperationMsgT1 */
public class OperationMsgT1 implements Serializable {
    public String action;
    @SerializedName("action_type")
    public int actionType;
    public String content;
    public int luncherMode;
    public long timeStamp;
    public String title;
}
