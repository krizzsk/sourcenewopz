package com.didichuxing.mlcp.drtc.sdk;

import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.interfaces.InCallingService;
import com.didichuxing.mlcp.drtc.utils.DrtcAudioManager;

public class DrtcInCallingServiceImpl implements InCallingService {

    /* renamed from: a */
    private final DrtcSDK f48347a;

    /* renamed from: b */
    private final DrtcAudioManager f48348b;

    DrtcInCallingServiceImpl(DrtcSDK drtcSDK) {
        if (drtcSDK != null) {
            this.f48347a = drtcSDK;
            this.f48348b = drtcSDK.f48392b;
            return;
        }
        throw new NullPointerException("Drtc SDK should not be null");
    }

    public void enableSpeaker(boolean z) {
        DrtcSDK drtcSDK = this.f48347a;
        if (drtcSDK != null) {
            drtcSDK.mo119024a("[I] Client change speaker:" + z);
            this.f48348b.mo119046a(z);
        }
    }

    public void pushExternalAudioFrame(byte[] bArr) {
        DrtcPluginHandle drtcPluginHandle = this.f48347a.f48391a;
        if (drtcPluginHandle != null) {
            drtcPluginHandle.pushAudioManual(bArr);
        }
    }

    public boolean restartExAudioRec() {
        DrtcPluginHandle drtcPluginHandle = this.f48347a.f48391a;
        if (drtcPluginHandle != null) {
            return drtcPluginHandle.startExAudioRecorder();
        }
        return false;
    }

    public boolean setAudioStatus(boolean z) {
        DrtcSDK drtcSDK = this.f48347a;
        if (drtcSDK == null) {
            return false;
        }
        drtcSDK.mo119024a("[I] Client mute audio :" + z);
        this.f48347a.f48391a.mute(z);
        return true;
    }

    public boolean stopExAudioRec() {
        DrtcPluginHandle drtcPluginHandle = this.f48347a.f48391a;
        if (drtcPluginHandle != null) {
            return drtcPluginHandle.stopExAudioRecorder();
        }
        return false;
    }

    public boolean switchCamera(DrtcCameraType drtcCameraType) {
        DrtcSDK drtcSDK = this.f48347a;
        if (drtcSDK == null || drtcSDK.f48391a == null) {
            return false;
        }
        drtcSDK.mo119024a("[I] Client switch camera to :" + drtcCameraType.toString());
        return this.f48347a.f48391a.mo119002a(drtcCameraType);
    }
}
