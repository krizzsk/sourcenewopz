package com.didi.beatles.p099im.access.msg;

/* renamed from: com.didi.beatles.im.access.msg.IMMessageUpdate */
public interface IMMessageUpdate {
    void onResult(boolean z);

    String updateContent(IMMessageFilter iMMessageFilter, String str);
}
