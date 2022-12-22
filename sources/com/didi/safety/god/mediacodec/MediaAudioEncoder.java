package com.didi.safety.god.mediacodec;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.didi.safety.god.mediacodec.MediaEncoder;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaAudioEncoder extends MediaEncoder {
    public static final int FRAMES_PER_BUFFER = 25;
    public static final int SAMPLES_PER_FRAME = 1024;

    /* renamed from: a */
    private static final boolean f34640a = false;

    /* renamed from: b */
    private static final String f34641b = "MediaAudioEncoder";

    /* renamed from: c */
    private static final String f34642c = "audio/mp4a-latm";

    /* renamed from: d */
    private static final int f34643d = 44100;

    /* renamed from: e */
    private static final int f34644e = 64000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int[] f34645f = {1, 0, 5, 7, 6};

    /* renamed from: g */
    private AudioThread f34646g = null;

    public MediaAudioEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener) {
        super(mediaMuxerWrapper, mediaEncoderListener);
    }

    /* renamed from: a */
    private static final MediaCodecInfo m24475a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void prepare() throws IOException {
        this.mTrackIndex = -1;
        this.mIsEOS = false;
        this.mMuxerStarted = false;
        if (m24475a(f34642c) == null) {
            SystemUtils.log(6, f34641b, "Unable to find an appropriate codec for audio/mp4a-latm", (Throwable) null, "com.didi.safety.god.mediacodec.MediaAudioEncoder", 77);
            return;
        }
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(f34642c, 44100, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(SDKConsts.TAG_KEY_BITRATE, f34644e);
        createAudioFormat.setInteger("channel-count", 1);
        this.mMediaCodec = MediaCodec.createEncoderByType(f34642c);
        this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mMediaCodec.start();
        if (this.mListener != null) {
            try {
                this.mListener.onPrepared(this);
            } catch (Exception e) {
                SystemUtils.log(6, f34641b, "prepare:", e, "com.didi.safety.god.mediacodec.MediaAudioEncoder", 98);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startRecording() {
        super.startRecording();
        if (this.f34646g == null) {
            AudioThread audioThread = new AudioThread();
            this.f34646g = audioThread;
            audioThread.start();
        }
    }

    /* access modifiers changed from: protected */
    public void release() {
        this.f34646g = null;
        super.release();
    }

    private class AudioThread extends Thread {
        private AudioThread() {
        }

        public void run() {
            SystemUtils.setProcessThreadPriority(-19);
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                int i = 25600;
                if (25600 < minBufferSize) {
                    i = ((minBufferSize / 1024) + 1) * 1024 * 2;
                }
                AudioRecord audioRecord = null;
                for (int audioRecord2 : MediaAudioEncoder.f34645f) {
                    try {
                        AudioRecord audioRecord3 = new AudioRecord(audioRecord2, 44100, 16, 2, i);
                        if (audioRecord3.getState() != 1) {
                            audioRecord3 = null;
                        }
                        audioRecord = audioRecord3;
                    } catch (Exception unused) {
                        audioRecord = null;
                    }
                    if (audioRecord != null) {
                        break;
                    }
                }
                if (audioRecord != null) {
                    try {
                        if (MediaAudioEncoder.this.mIsCapturing) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                            audioRecord.startRecording();
                            while (MediaAudioEncoder.this.mIsCapturing && !MediaAudioEncoder.this.mRequestStop && !MediaAudioEncoder.this.mIsEOS) {
                                allocateDirect.clear();
                                int read = audioRecord.read(allocateDirect, 1024);
                                if (read > 0) {
                                    allocateDirect.position(read);
                                    allocateDirect.flip();
                                    MediaAudioEncoder.this.encode(allocateDirect, read, MediaAudioEncoder.this.getPTSUs());
                                    MediaAudioEncoder.this.frameAvailableSoon();
                                }
                            }
                            MediaAudioEncoder.this.frameAvailableSoon();
                            audioRecord.stop();
                        }
                        audioRecord.release();
                    } catch (Throwable th) {
                        audioRecord.release();
                        throw th;
                    }
                } else {
                    SystemUtils.log(6, MediaAudioEncoder.f34641b, "failed to initialize AudioRecord", (Throwable) null, "com.didi.safety.god.mediacodec.MediaAudioEncoder$AudioThread", 177);
                }
            } catch (Exception e) {
                SystemUtils.log(6, MediaAudioEncoder.f34641b, "AudioThread#run", e, "com.didi.safety.god.mediacodec.MediaAudioEncoder$AudioThread", 180);
            }
        }
    }
}
