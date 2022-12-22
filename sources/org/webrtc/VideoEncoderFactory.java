package org.webrtc;

public interface VideoEncoderFactory {
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo);

    VideoCodecInfo[] getImplementations();

    VideoCodecInfo[] getSupportedCodecs();

    /* renamed from: org.webrtc.VideoEncoderFactory$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static VideoCodecInfo[] $default$getImplementations(VideoEncoderFactory _this) {
            return _this.getSupportedCodecs();
        }
    }
}
