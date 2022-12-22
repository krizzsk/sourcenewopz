package com.didi.beatles.p099im.event;

import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.event.IMMessageUpdateReadStatusEvent */
public class IMMessageUpdateReadStatusEvent {
    public List<IMMessage> list;

    public IMMessageUpdateReadStatusEvent(List<IMMessage> list2) {
        this.list = list2;
    }
}
