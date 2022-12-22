package com.didi.beatles.p099im.module;

import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.IMPreSendCallback */
public interface IMPreSendCallback {
    void insertSuccess(List<IMMessage> list);
}
