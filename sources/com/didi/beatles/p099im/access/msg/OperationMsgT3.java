package com.didi.beatles.p099im.access.msg;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.msg.OperationMsgT3 */
public class OperationMsgT3 implements Serializable {
    public List<OperationMsgT3Item> items;

    /* renamed from: com.didi.beatles.im.access.msg.OperationMsgT3$OperationMsgT3Item */
    public static class OperationMsgT3Item implements Serializable {
        public String action;
        public String icon;
        public String title;
    }
}
