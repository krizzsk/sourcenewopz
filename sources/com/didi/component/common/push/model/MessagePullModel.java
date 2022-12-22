package com.didi.component.common.push.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MessagePullModel implements Serializable {
    public String errmsg;
    public int errno;
    public ArrayList<MessagePullItem> msgbody;
    public int remain_number;
}
