package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMMessagesLoadCallback */
public interface IMMessagesLoadCallback extends IMSucceedCallback {
    void onHistoryMessageLoad(List<IMMessage> list, boolean z);
}
