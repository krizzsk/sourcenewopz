package com.didi.beatles.p099im.access.msg;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.access.msg.OperationMsgT2 */
public class OperationMsgT2 implements Serializable {
    public String action;
    @SerializedName("action_type")
    public int actionType;
    public String content;
    public String image;
    public int imageHeight;
    public int imageWidth;
    public int luncherMode;
    public long overTime;
    public int template;
    public long timeStamp;
    public String title;
    public int type;
}
