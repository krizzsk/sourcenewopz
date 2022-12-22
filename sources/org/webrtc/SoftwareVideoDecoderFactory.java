package org.webrtc;

import com.didichuxing.mlcp.drtc.consts.RTCConsts;
import java.util.ArrayList;
import java.util.HashMap;

public class SoftwareVideoDecoderFactory implements VideoDecoderFactory {
    @Deprecated
    public VideoDecoder createDecoder(String str) {
        return createDecoder(new VideoCodecInfo(str, new HashMap()));
    }

    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        if (videoCodecInfo.getName().equalsIgnoreCase(RTCConsts.VIDEO_CODEC_H264) && H264Decoder.nativeIsSupported()) {
            return new H264Decoder();
        }
        if (videoCodecInfo.getName().equalsIgnoreCase(RTCConsts.VIDEO_CODEC_VP8)) {
            return new LibvpxVp8Decoder();
        }
        if (!videoCodecInfo.getName().equalsIgnoreCase("VP9") || !LibvpxVp9Decoder.nativeIsSupported()) {
            return null;
        }
        return new LibvpxVp9Decoder();
    }

    public VideoCodecInfo[] getSupportedCodecs() {
        return supportedCodecs();
    }

    static VideoCodecInfo[] supportedCodecs() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VideoCodecInfo(RTCConsts.VIDEO_CODEC_VP8, new HashMap()));
        if (H264Decoder.nativeIsSupported()) {
            arrayList.add(H264Utils.DEFAULT_H264_BASELINE_PROFILE_CODEC);
        }
        if (LibvpxVp9Decoder.nativeIsSupported()) {
            arrayList.add(new VideoCodecInfo("VP9", new HashMap()));
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }
}
