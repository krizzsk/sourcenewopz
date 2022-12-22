package com.didi.beatles.p099im.event;

import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.event.IMMessageColloectionUpdateEvent */
public class IMMessageColloectionUpdateEvent {
    public List<IMMessage> updateMessages;

    public IMMessageColloectionUpdateEvent(List<IMMessage> list) {
        this.updateMessages = list;
    }
}
