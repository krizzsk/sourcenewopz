package com.didi.sdk.audiorecorder.speechdetect;

import com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer;

public class TTServerWrapper {
    public void getTTServerName(DataTransferServer.AcquireServerNameCallback acquireServerNameCallback) {
        acquireServerNameCallback.onAcquired("");
    }
}
