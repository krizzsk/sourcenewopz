package com.didi.sdk.messagecenter.model;

import com.squareup.wire.Message;

public class BaseMessage<T extends Message> extends PushMessage {
    public long activityId;
    public T msg;
    public Long pid;
    public byte[] raw;
    public String topic;
    public String type;
}
