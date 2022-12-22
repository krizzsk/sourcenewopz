package com.didi.beatles.p099im.access.core;

import com.didi.beatles.p099im.access.msg.IMMsg;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.core.IMUnreadMsgLoadCallback */
public interface IMUnreadMsgLoadCallback {
    void onIMMsgLoad(int i, int i2, List<IMMsg> list);
}
