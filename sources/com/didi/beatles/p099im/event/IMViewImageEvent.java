package com.didi.beatles.p099im.event;

import com.didi.beatles.p099im.module.entity.IMMessage;

/* renamed from: com.didi.beatles.im.event.IMViewImageEvent */
public class IMViewImageEvent {
    public IMMessage message;

    public IMViewImageEvent(IMMessage iMMessage) {
        this.message = iMMessage;
    }
}
