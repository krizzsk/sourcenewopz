package com.didi.beatles.p099im.event;

import com.didi.beatles.p099im.module.entity.IMSession;
import java.util.List;

/* renamed from: com.didi.beatles.im.event.IMSessionInfoUpdateEvent */
public class IMSessionInfoUpdateEvent {
    public List<IMSession> imSessionList;

    public IMSessionInfoUpdateEvent(List<IMSession> list) {
        this.imSessionList = list;
    }
}
