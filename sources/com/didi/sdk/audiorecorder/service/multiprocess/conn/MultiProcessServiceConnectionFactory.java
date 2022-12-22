package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import com.didi.sdk.audiorecorder.service.IRecordServiceConnection;

public final class MultiProcessServiceConnectionFactory {
    public IRecordServiceConnection create() {
        return new MultiProcessRecordServiceConnection();
    }
}
