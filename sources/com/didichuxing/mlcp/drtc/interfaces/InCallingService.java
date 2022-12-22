package com.didichuxing.mlcp.drtc.interfaces;

import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;

public interface InCallingService {
    void enableSpeaker(boolean z);

    void pushExternalAudioFrame(byte[] bArr);

    boolean restartExAudioRec();

    boolean setAudioStatus(boolean z);

    boolean stopExAudioRec();

    boolean switchCamera(DrtcCameraType drtcCameraType);
}
