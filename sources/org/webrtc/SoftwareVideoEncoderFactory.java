package org.webrtc;

import com.didichuxing.mlcp.drtc.consts.RTCConsts;
import java.util.ArrayList;
import java.util.HashMap;
import org.webrtc.VideoEncoderFactory;

public class SoftwareVideoEncoderFactory implements VideoEncoderFactory {
    public /* synthetic */ VideoCodecInfo[] getImplementations() {
        return VideoEncoderFactory.CC.$default$getImplementations(this);
    }

    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        if (videoCodecInfo.name.equalsIgnoreCase(RTCConsts.VIDEO_CODEC_H264) && H264Encoder.nativeIsSupported()) {
            return new H264Encoder();
        }
        if (videoCodecInfo.name.equalsIgnoreCase(RTCConsts.VIDEO_CODEC_VP8)) {
            return new LibvpxVp8Encoder();
        }
        if (!videoCodecInfo.name.equalsIgnoreCase("VP9") || !LibvpxVp9Encoder.nativeIsSupported()) {
            return null;
        }
        return new LibvpxVp9Encoder();
    }

    public VideoCodecInfo[] getSupportedCodecs() {
        return supportedCodecs();
    }

    static VideoCodecInfo[] supportedCodecs() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VideoCodecInfo(RTCConsts.VIDEO_CODEC_VP8, new HashMap()));
        if (H264Encoder.nativeIsSupported()) {
            arrayList.add(H264Utils.DEFAULT_H264_BASELINE_PROFILE_CODEC);
        }
        if (LibvpxVp9Encoder.nativeIsSupported()) {
            arrayList.add(new VideoCodecInfo("VP9", new HashMap()));
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }
}
