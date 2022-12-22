package com.didi.beatles.p099im.views;

import com.didi.beatles.p099im.adapter.MessageAdapter;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.views.messageCard.IMBaseRenderView;

/* renamed from: com.didi.beatles.im.views.IMCustomChatRowProvider */
public interface IMCustomChatRowProvider {
    IMBaseRenderView getCustomChatRow(int i, MessageAdapter messageAdapter);

    int getCustomChatRowType(IMMessage iMMessage);
}
