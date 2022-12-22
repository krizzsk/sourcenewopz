package com.didichuxing.mlcp.drtc.interfaces;

import android.content.Context;
import com.didichuxing.mlcp.drtc.enums.DrtcCaptureFrameType;
import com.didichuxing.mlcp.drtc.enums.DrtcMode;
import org.webrtc.SurfaceViewRenderer;

public interface CallingService {
    void addListener(CallingServiceListener callingServiceListener);

    int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str);

    int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode);

    int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode, boolean z);

    int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode, boolean z, boolean z2);

    int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, boolean z);

    int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, boolean z);

    DrtcCaptureFrameType captureLocalFrame(FrameReceiver frameReceiver);

    int hangupCalling();

    void removeListener(CallingServiceListener callingServiceListener);

    int setupRemoteVideo(SurfaceViewRenderer surfaceViewRenderer);
}
