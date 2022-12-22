package org.webrtc;

import org.webrtc.VideoEncoder;

public class H264Encoder extends WrappedNativeVideoEncoder {
    static native long nativeCreateEncoder();

    static native boolean nativeIsSupported();

    public boolean isHardwareEncoder() {
        return false;
    }

    public /* bridge */ /* synthetic */ VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        return super.encode(videoFrame, encodeInfo);
    }

    public /* bridge */ /* synthetic */ String getImplementationName() {
        return super.getImplementationName();
    }

    public /* bridge */ /* synthetic */ VideoEncoder.ScalingSettings getScalingSettings() {
        return super.getScalingSettings();
    }

    public /* bridge */ /* synthetic */ VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        return super.initEncode(settings, callback);
    }

    public /* bridge */ /* synthetic */ VideoCodecStatus release() {
        return super.release();
    }

    public /* bridge */ /* synthetic */ VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i) {
        return super.setRateAllocation(bitrateAllocation, i);
    }

    public long createNativeVideoEncoder() {
        return nativeCreateEncoder();
    }
}
