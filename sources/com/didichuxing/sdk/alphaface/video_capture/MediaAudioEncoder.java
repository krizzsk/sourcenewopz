package com.didichuxing.sdk.alphaface.video_capture;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.sdk.alphaface.video_capture.MediaEncoder;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaAudioEncoder extends MediaEncoder {
    public static final int FRAMES_PER_BUFFER = 25;
    public static final int SAMPLES_PER_FRAME = 1024;

    /* renamed from: a */
    private static final boolean f48812a = false;

    /* renamed from: b */
    private static final String f48813b = "MediaAudioEncoder";

    /* renamed from: c */
    private static final String f48814c = "audio/mp4a-latm";

    /* renamed from: d */
    private static final int f48815d = 44100;

    /* renamed from: e */
    private static final int f48816e = 64000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int[] f48817f = {1, 0, 5, 7, 6};

    /* renamed from: g */
    private AudioThread f48818g = null;

    public MediaAudioEncoder(MediaMuxerWrapper mediaMuxerWrapper, MediaEncoder.MediaEncoderListener mediaEncoderListener) {
        super(mediaMuxerWrapper, mediaEncoderListener);
    }

    /* renamed from: a */
    private static final MediaCodecInfo m35029a(String str) {
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
        if (m35029a(f48814c) == null) {
            SystemUtils.log(6, f48813b, "Unable to find an appropriate codec for audio/mp4a-latm", (Throwable) null, "com.didichuxing.sdk.alphaface.video_capture.MediaAudioEncoder", 99);
            return;
        }
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(f48814c, 44100, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(SDKConsts.TAG_KEY_BITRATE, f48816e);
        createAudioFormat.setInteger("channel-count", 1);
        this.mMediaCodec = MediaCodec.createEncoderByType(f48814c);
        this.mMediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mMediaCodec.start();
        if (this.mListener != null) {
            try {
                this.mListener.onPrepared(this);
            } catch (Exception e) {
                SystemUtils.log(6, f48813b, "prepare:", e, "com.didichuxing.sdk.alphaface.video_capture.MediaAudioEncoder", 133);
                if (this.mListener != null) {
                    MediaEncoder.MediaEncoderListener mediaEncoderListener = this.mListener;
                    mediaEncoderListener.onError("MediaAudioEncoder prepare error, " + Log.getStackTraceString(e));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void startRecording() {
        super.startRecording();
        if (this.f48818g == null) {
            AudioThread audioThread = new AudioThread();
            this.f48818g = audioThread;
            audioThread.start();
        }
    }

    /* access modifiers changed from: protected */
    public void release() {
        this.f48818g = null;
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
                for (int audioRecord2 : MediaAudioEncoder.f48817f) {
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
                    SystemUtils.log(6, MediaAudioEncoder.f48813b, "failed to initialize AudioRecord", (Throwable) null, "com.didichuxing.sdk.alphaface.video_capture.MediaAudioEncoder$AudioThread", 247);
                }
            } catch (Exception e) {
                SystemUtils.log(6, MediaAudioEncoder.f48813b, "AudioThread#run", e, "com.didichuxing.sdk.alphaface.video_capture.MediaAudioEncoder$AudioThread", 252);
                if (MediaAudioEncoder.this.mListener != null) {
                    MediaAudioEncoder.this.mListener.onError("AudioThread#run error, " + Log.getStackTraceString(e));
                }
            }
        }
    }
}
