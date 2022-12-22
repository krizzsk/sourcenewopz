package com.didi.beatles.p099im.access;

import com.didi.beatles.p099im.access.IMRecorderProtocol;

/* renamed from: com.didi.beatles.im.access.IIMRecorder */
public interface IIMRecorder {
    void registerRecorderProtocolHandler(IMRecorderProtocol.IIMRecorderProtocolHandler iIMRecorderProtocolHandler);

    void releaseRecorder(int i);

    void requireRecorder(int i);

    void unRegisterRecorderProtocolHandler(IMRecorderProtocol.IIMRecorderProtocolHandler iIMRecorderProtocolHandler);
}
