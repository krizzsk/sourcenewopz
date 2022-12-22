package com.didi.sdk.audiorecorder.helper.recorder.modules.fixed;

import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import java.io.IOException;

public interface IAmrHelper {
    void close() throws IOException;

    void handleFrame(byte[] bArr);

    boolean isClosed();

    void setAmrConsumer(Supporter.AmrConsumer amrConsumer);

    void start();
}
