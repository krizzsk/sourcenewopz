package com.didi.sdk.audiorecorder.service;

import com.didi.sdk.audiorecorder.AudioRecordContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IRecordServiceConnection extends IRecordService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionMode {
        public static final int MAIN_PROCESS = 0;
        public static final int MULTI_PROCESS = 1;
    }

    void updateRecordContext(String str, AudioRecordContext audioRecordContext);
}
