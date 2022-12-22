package com.didi.beatles.p099im.event;

import com.didi.beatles.p099im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.event.IMMessageSysCardShowEvent */
public class IMMessageSysCardShowEvent {
    public IMMessage message;

    public IMMessageSysCardShowEvent(IMMessage iMMessage) {
        this.message = iMMessage;
    }
}
