package com.didichuxing.mlcp.drtc.interfaces;

import android.graphics.Bitmap;
import com.didichuxing.mlcp.drtc.enums.DrtcCaptureFrameType;

public interface FrameReceiver {
    void receiveNewFrame(Bitmap bitmap, DrtcCaptureFrameType drtcCaptureFrameType);
}
