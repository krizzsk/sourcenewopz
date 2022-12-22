package com.didi.beatles.p099im.protocol.model;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.protocol.model.IMPluginMsgWrapper */
public class IMPluginMsgWrapper implements Serializable {
    public String content;
    public int eid;
    public String listText;

    public IMPluginMsgWrapper(String str, String str2) {
        this.eid = 0;
        this.content = str;
        this.listText = str2;
    }

    public IMPluginMsgWrapper(int i, String str, String str2) {
        this.eid = i;
        this.content = str;
        this.listText = str2;
    }
}
