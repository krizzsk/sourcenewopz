package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.module.entity.IMSession;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMSessionCallback */
public interface IMSessionCallback extends IMSucceedCallback {
    public static final int SESSION_ACK_COUNT = 102;
    public static final int SESSION_CREATE_FAILED = 2;
    public static final int SESSION_CREATE_SUCCEED = 1;
    public static final int SESSION_DELETE_FAILED = 4;
    public static final int SESSION_DELETE_SUCCEED = 3;
    public static final int SESSION_UNREAD_COUNT = 101;

    void onSessionLoad(List<IMSession> list);

    void onSessionOptionResult(List<IMSession> list, int i);

    void onSessionStatusUpdate(List<IMSession> list);
}
