package com.didi.sdk.audiorecorder;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface AudioRecordContext extends BaseAudioRecordContext {

    public interface AudioSegmentDuration {
        public static final int MAX = 900000;
        public static final int MIN = 10000;
        public static final int _5_MINUTES = 300000;
    }

    public interface ClientType {
        public static final int DRIVER = 1;
        public static final int PASSENGER = 2;
    }

    public static class ConvertSwitchConfig {
        public int amrBitRate;
        public int amrSwitch;
        public int pcmSwitch;
    }

    public interface Logger {
        void log(String str);

        void log(String str, Throwable th);
    }

    ConvertSwitchConfig getConvertImplSwitch();
}
