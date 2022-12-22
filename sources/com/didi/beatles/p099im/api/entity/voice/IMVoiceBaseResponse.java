package com.didi.beatles.p099im.api.entity.voice;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.voice.IMVoiceBaseResponse */
public abstract class IMVoiceBaseResponse<T> implements Serializable {
    public T body;
    public String errmsg;
    public int errno;
}
