package com.didi.sdk.audiorecorder.service;

import com.didi.sdk.audiorecorder.service.multiprocess.conn.MultiProcessServiceConnectionFactory;

public final class RecordServiceConnectionFactory {
    public static IRecordServiceConnection create() {
        return new MultiProcessServiceConnectionFactory().create();
    }
}
