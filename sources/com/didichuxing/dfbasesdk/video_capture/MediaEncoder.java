package com.didichuxing.dfbasesdk.video_capture;

import android.media.MediaCodec;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class MediaEncoder implements Runnable {
    protected static final int MSG_FRAME_AVAILABLE = 1;
    protected static final int MSG_STOP_RECORDING = 9;
    protected static final int TIMEOUT_USEC = 10000;

    /* renamed from: a */
    private static final boolean f46822a = true;

    /* renamed from: b */
    private static final String f46823b = "MediaEncoder";

    /* renamed from: c */
    private int f46824c;

    /* renamed from: d */
    private MediaCodec.BufferInfo f46825d;

    /* renamed from: e */
    private long f46826e = 0;
    protected volatile boolean mIsCapturing;
    protected boolean mIsEOS;
    protected final MediaEncoderListener mListener;
    protected MediaCodec mMediaCodec;
    protected boolean mMuxerStarted;
    protected volatile boolean mRequestStop;
    protected final Object mSync = new Object();
    protected int mTrackIndex;
    protected final WeakReference<MediaMuxerWrapper> mWeakMuxer;

    public interface MediaEncoderListener {
        void onError(String str);

        void onPrepared(MediaEncoder mediaEncoder);

        void onStopped(MediaEncoder mediaEncoder);
    }

    /* access modifiers changed from: package-private */
    public abstract void prepare() throws IOException;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaEncoder(com.didichuxing.dfbasesdk.video_capture.MediaMuxerWrapper r3, com.didichuxing.dfbasesdk.video_capture.MediaEncoder.MediaEncoderListener r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.mSync = r0
            r0 = 0
            r2.f46826e = r0
            if (r4 == 0) goto L_0x004a
            if (r3 == 0) goto L_0x0042
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.mWeakMuxer = r0
            r3.mo115863a((com.didichuxing.dfbasesdk.video_capture.MediaEncoder) r2)
            r2.mListener = r4
            java.lang.Object r3 = r2.mSync
            monitor-enter(r3)
            android.media.MediaCodec$BufferInfo r4 = new android.media.MediaCodec$BufferInfo     // Catch:{ all -> 0x003f }
            r4.<init>()     // Catch:{ all -> 0x003f }
            r2.f46825d = r4     // Catch:{ all -> 0x003f }
            java.lang.Thread r4 = new java.lang.Thread     // Catch:{ all -> 0x003f }
            java.lang.Class r0 = r2.getClass()     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x003f }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x003f }
            r4.start()     // Catch:{ all -> 0x003f }
            java.lang.Object r4 = r2.mSync     // Catch:{ InterruptedException -> 0x003d }
            r4.wait()     // Catch:{ InterruptedException -> 0x003d }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            throw r4
        L_0x0042:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaMuxerWrapper is null"
            r3.<init>(r4)
            throw r3
        L_0x004a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "MediaEncoderListener is null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.video_capture.MediaEncoder.<init>(com.didichuxing.dfbasesdk.video_capture.MediaMuxerWrapper, com.didichuxing.dfbasesdk.video_capture.MediaEncoder$MediaEncoderListener):void");
    }

    public String getOutputPath() {
        MediaMuxerWrapper mediaMuxerWrapper = (MediaMuxerWrapper) this.mWeakMuxer.get();
        if (mediaMuxerWrapper != null) {
            return mediaMuxerWrapper.getOutputPath();
        }
        return null;
    }

    public boolean frameAvailableSoon() {
        synchronized (this.mSync) {
            if (this.mIsCapturing) {
                if (!this.mRequestStop) {
                    this.f46824c++;
                    this.mSync.notifyAll();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        drain();
        signalEndOfInputStream();
        drain();
        release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            java.lang.Object r0 = r10.mSync
            monitor-enter(r0)
            r1 = 0
            r10.mRequestStop = r1     // Catch:{ all -> 0x0081 }
            r10.f46824c = r1     // Catch:{ all -> 0x0081 }
            java.lang.Object r2 = r10.mSync     // Catch:{ all -> 0x0081 }
            r2.notify()     // Catch:{ all -> 0x0081 }
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
        L_0x000e:
            r0 = 1
            java.lang.Object r2 = r10.mSync     // Catch:{ Exception -> 0x004b }
            monitor-enter(r2)     // Catch:{ Exception -> 0x004b }
            boolean r3 = r10.mRequestStop     // Catch:{ all -> 0x0048 }
            int r4 = r10.f46824c     // Catch:{ all -> 0x0048 }
            if (r4 <= 0) goto L_0x001a
            r4 = 1
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            if (r4 == 0) goto L_0x0022
            int r5 = r10.f46824c     // Catch:{ all -> 0x0048 }
            int r5 = r5 - r0
            r10.f46824c = r5     // Catch:{ all -> 0x0048 }
        L_0x0022:
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0032
            r10.drain()     // Catch:{ Exception -> 0x004b }
            r10.signalEndOfInputStream()     // Catch:{ Exception -> 0x004b }
            r10.drain()     // Catch:{ Exception -> 0x004b }
            r10.release()     // Catch:{ Exception -> 0x004b }
            goto L_0x0068
        L_0x0032:
            if (r4 == 0) goto L_0x0038
            r10.drain()     // Catch:{ Exception -> 0x004b }
            goto L_0x000e
        L_0x0038:
            java.lang.Object r2 = r10.mSync     // Catch:{ Exception -> 0x004b }
            monitor-enter(r2)     // Catch:{ Exception -> 0x004b }
            java.lang.Object r3 = r10.mSync     // Catch:{ InterruptedException -> 0x0044 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0044 }
            monitor-exit(r2)     // Catch:{ all -> 0x0042 }
            goto L_0x000e
        L_0x0042:
            r3 = move-exception
            goto L_0x0046
        L_0x0044:
            monitor-exit(r2)     // Catch:{ all -> 0x0042 }
            goto L_0x0068
        L_0x0046:
            monitor-exit(r2)     // Catch:{ all -> 0x0042 }
            throw r3     // Catch:{ Exception -> 0x004b }
        L_0x0048:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            throw r3     // Catch:{ Exception -> 0x004b }
        L_0x004b:
            r2 = move-exception
            com.didichuxing.dfbasesdk.video_capture.MediaEncoder$MediaEncoderListener r3 = r10.mListener
            if (r3 == 0) goto L_0x0068
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "MediaEncoder record run error , "
            r4.append(r5)
            java.lang.String r2 = android.util.Log.getStackTraceString(r2)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.onError(r2)
        L_0x0068:
            java.lang.String r5 = "MediaEncoder"
            java.lang.String r6 = "Encoder thread exiting"
            r4 = 3
            r7 = 0
            java.lang.String r8 = "com.didichuxing.dfbasesdk.video_capture.MediaEncoder"
            r9 = 156(0x9c, float:2.19E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            java.lang.Object r2 = r10.mSync
            monitor-enter(r2)
            r10.mRequestStop = r0     // Catch:{ all -> 0x007e }
            r10.mIsCapturing = r1     // Catch:{ all -> 0x007e }
            monitor-exit(r2)     // Catch:{ all -> 0x007e }
            return
        L_0x007e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x007e }
            throw r0
        L_0x0081:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.video_capture.MediaEncoder.run():void");
    }

    /* access modifiers changed from: package-private */
    public void startRecording() {
        SystemUtils.log(2, f46823b, "startRecording", (Throwable) null, "com.didichuxing.dfbasesdk.video_capture.MediaEncoder", 172);
        synchronized (this.mSync) {
            this.mIsCapturing = true;
            this.mRequestStop = false;
            this.mSync.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo115853b() {
        /*
            r6 = this;
            java.lang.String r1 = "MediaEncoder"
            java.lang.String r2 = "stopRecording"
            java.lang.String r4 = "com.didichuxing.dfbasesdk.video_capture.MediaEncoder"
            r0 = 2
            r3 = 0
            r5 = 184(0xb8, float:2.58E-43)
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            java.lang.Object r0 = r6.mSync
            monitor-enter(r0)
            boolean r1 = r6.mIsCapturing     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            boolean r1 = r6.mRequestStop     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0019
            goto L_0x0023
        L_0x0019:
            r1 = 1
            r6.mRequestStop = r1     // Catch:{ all -> 0x0025 }
            java.lang.Object r1 = r6.mSync     // Catch:{ all -> 0x0025 }
            r1.notifyAll()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.video_capture.MediaEncoder.mo115853b():void");
    }

    /* access modifiers changed from: protected */
    public void release() {
        SystemUtils.log(3, f46823b, "release:", (Throwable) null, "com.didichuxing.dfbasesdk.video_capture.MediaEncoder", 203);
        try {
            this.mListener.onStopped(this);
        } catch (Exception e) {
            SystemUtils.log(6, f46823b, "failed onStopped", e, "com.didichuxing.dfbasesdk.video_capture.MediaEncoder", 207);
            MediaEncoderListener mediaEncoderListener = this.mListener;
            if (mediaEncoderListener != null) {
                mediaEncoderListener.onError("failed onStopped, " + e.getMessage());
            }
        }
        this.mIsCapturing = false;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            } catch (Exception e2) {
                SystemUtils.log(6, f46823b, "failed releasing MediaCodec", e2, "com.didichuxing.dfbasesdk.video_capture.MediaEncoder", 219);
                MediaEncoderListener mediaEncoderListener2 = this.mListener;
                if (mediaEncoderListener2 != null) {
                    mediaEncoderListener2.onError("failed releasing MediaCodec, " + e2.getMessage());
                }
            }
        }
        if (this.mMuxerStarted) {
            WeakReference<MediaMuxerWrapper> weakReference = this.mWeakMuxer;
            MediaMuxerWrapper mediaMuxerWrapper = weakReference != null ? (MediaMuxerWrapper) weakReference.get() : null;
            if (mediaMuxerWrapper != null) {
                try {
                    mediaMuxerWrapper.mo115865b();
                } catch (Exception e3) {
                    SystemUtils.log(6, f46823b, "failed stopping muxer", e3, "com.didichuxing.dfbasesdk.video_capture.MediaEncoder", 231);
                    MediaEncoderListener mediaEncoderListener3 = this.mListener;
                    if (mediaEncoderListener3 != null) {
                        mediaEncoderListener3.onError("failed stopping muxer, " + e3.getMessage());
                    }
                }
            }
        }
        this.f46825d = null;
    }

    /* access modifiers changed from: protected */
    public void signalEndOfInputStream() {
        SystemUtils.log(3, f46823b, "sending EOS to encoder", (Throwable) null, "com.didichuxing.dfbasesdk.video_capture.MediaEncoder", 242);
        encode((ByteBuffer) null, 0, getPTSUs());
    }

    /* access modifiers changed from: protected */
    public void encode(ByteBuffer byteBuffer, int i, long j) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (this.mIsCapturing) {
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            while (this.mIsCapturing) {
                int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer3 = inputBuffers[dequeueInputBuffer];
                    byteBuffer3.clear();
                    if (byteBuffer2 != null) {
                        byteBuffer3.put(byteBuffer);
                    }
                    if (i <= 0) {
                        this.mIsEOS = true;
                        SystemUtils.log(4, f46823b, "send BUFFER_FLAG_END_OF_STREAM", (Throwable) null, "com.didichuxing.dfbasesdk.video_capture.MediaEncoder", 271);
                        this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                        return;
                    }
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x008e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r13 = this;
            android.media.MediaCodec r0 = r13.mMediaCodec     // Catch:{ Exception -> 0x0130 }
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.media.MediaCodec r0 = r13.mMediaCodec     // Catch:{ Exception -> 0x0130 }
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()     // Catch:{ Exception -> 0x0130 }
            java.lang.ref.WeakReference<com.didichuxing.dfbasesdk.video_capture.MediaMuxerWrapper> r1 = r13.mWeakMuxer     // Catch:{ Exception -> 0x0130 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0130 }
            com.didichuxing.dfbasesdk.video_capture.MediaMuxerWrapper r1 = (com.didichuxing.dfbasesdk.video_capture.MediaMuxerWrapper) r1     // Catch:{ Exception -> 0x0130 }
            if (r1 != 0) goto L_0x0023
            java.lang.String r3 = "MediaEncoder"
            java.lang.String r4 = "muxer is unexpectedly null"
            r2 = 5
            r5 = 0
            java.lang.String r6 = "com.didichuxing.dfbasesdk.video_capture.MediaEncoder"
            r7 = 299(0x12b, float:4.19E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0130 }
            return
        L_0x0023:
            r2 = 0
            r3 = 0
        L_0x0025:
            boolean r4 = r13.mIsCapturing     // Catch:{ Exception -> 0x0130 }
            if (r4 == 0) goto L_0x014d
            android.media.MediaCodec r4 = r13.mMediaCodec     // Catch:{ Exception -> 0x0130 }
            android.media.MediaCodec$BufferInfo r5 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            r6 = 10000(0x2710, double:4.9407E-320)
            int r4 = r4.dequeueOutputBuffer(r5, r6)     // Catch:{ Exception -> 0x0130 }
            r5 = -1
            if (r4 != r5) goto L_0x0041
            boolean r4 = r13.mIsEOS     // Catch:{ Exception -> 0x0130 }
            if (r4 != 0) goto L_0x0025
            int r3 = r3 + 1
            r4 = 5
            if (r3 <= r4) goto L_0x0025
            goto L_0x014d
        L_0x0041:
            r5 = -3
            if (r4 != r5) goto L_0x0058
            java.lang.String r7 = "MediaEncoder"
            java.lang.String r8 = "INFO_OUTPUT_BUFFERS_CHANGED"
            r6 = 2
            r9 = 0
            java.lang.String r10 = "com.didichuxing.dfbasesdk.video_capture.MediaEncoder"
            r11 = 313(0x139, float:4.39E-43)
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0130 }
            android.media.MediaCodec r0 = r13.mMediaCodec     // Catch:{ Exception -> 0x0130 }
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()     // Catch:{ Exception -> 0x0130 }
            goto L_0x0025
        L_0x0058:
            r5 = -2
            if (r4 != r5) goto L_0x009e
            java.lang.String r7 = "MediaEncoder"
            java.lang.String r8 = "INFO_OUTPUT_FORMAT_CHANGED"
            r6 = 2
            r9 = 0
            java.lang.String r10 = "com.didichuxing.dfbasesdk.video_capture.MediaEncoder"
            r11 = 317(0x13d, float:4.44E-43)
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0130 }
            boolean r4 = r13.mMuxerStarted     // Catch:{ Exception -> 0x0130 }
            if (r4 != 0) goto L_0x0096
            android.media.MediaCodec r4 = r13.mMediaCodec     // Catch:{ Exception -> 0x0130 }
            android.media.MediaFormat r4 = r4.getOutputFormat()     // Catch:{ Exception -> 0x0130 }
            int r4 = r1.mo115861a((android.media.MediaFormat) r4)     // Catch:{ Exception -> 0x0130 }
            r13.mTrackIndex = r4     // Catch:{ Exception -> 0x0130 }
            r4 = 1
            r13.mMuxerStarted = r4     // Catch:{ Exception -> 0x0130 }
            boolean r4 = r1.mo115864a()     // Catch:{ Exception -> 0x0130 }
            if (r4 != 0) goto L_0x0025
            monitor-enter(r1)     // Catch:{ Exception -> 0x0130 }
        L_0x0082:
            boolean r4 = r1.isStarted()     // Catch:{ all -> 0x0093 }
            if (r4 != 0) goto L_0x0091
            r4 = 100
            r1.wait(r4)     // Catch:{ InterruptedException -> 0x008e }
            goto L_0x0082
        L_0x008e:
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
            goto L_0x014d
        L_0x0091:
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
            goto L_0x0025
        L_0x0093:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0093 }
            throw r0     // Catch:{ Exception -> 0x0130 }
        L_0x0096:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0130 }
            java.lang.String r1 = "format changed twice"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0130 }
            throw r0     // Catch:{ Exception -> 0x0130 }
        L_0x009e:
            if (r4 >= 0) goto L_0x00be
            java.lang.String r5 = "MediaEncoder"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r6.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = "drain:unexpected result from encoder#dequeueOutputBuffer: "
            r6.append(r7)     // Catch:{ Exception -> 0x0130 }
            r6.append(r4)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0130 }
            r4 = 5
            r7 = 0
            java.lang.String r8 = "com.didichuxing.dfbasesdk.video_capture.MediaEncoder"
            r9 = 344(0x158, float:4.82E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0130 }
            goto L_0x0025
        L_0x00be:
            r5 = r0[r4]     // Catch:{ Exception -> 0x0130 }
            if (r5 == 0) goto L_0x0114
            android.media.MediaCodec$BufferInfo r6 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            int r6 = r6.flags     // Catch:{ Exception -> 0x0130 }
            r6 = r6 & 2
            if (r6 == 0) goto L_0x00db
            java.lang.String r8 = "MediaEncoder"
            java.lang.String r9 = "drain:BUFFER_FLAG_CODEC_CONFIG"
            r7 = 3
            r10 = 0
            java.lang.String r11 = "com.didichuxing.dfbasesdk.video_capture.MediaEncoder"
            r12 = 356(0x164, float:4.99E-43)
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0130 }
            android.media.MediaCodec$BufferInfo r6 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            r6.size = r2     // Catch:{ Exception -> 0x0130 }
        L_0x00db:
            android.media.MediaCodec$BufferInfo r6 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            int r6 = r6.size     // Catch:{ Exception -> 0x0130 }
            if (r6 == 0) goto L_0x0104
            boolean r3 = r13.mMuxerStarted     // Catch:{ Exception -> 0x0130 }
            if (r3 == 0) goto L_0x00fc
            android.media.MediaCodec$BufferInfo r3 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            long r6 = r13.getPTSUs()     // Catch:{ Exception -> 0x0130 }
            r3.presentationTimeUs = r6     // Catch:{ Exception -> 0x0130 }
            int r3 = r13.mTrackIndex     // Catch:{ Exception -> 0x0130 }
            android.media.MediaCodec$BufferInfo r6 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            r1.mo115862a(r3, r5, r6)     // Catch:{ Exception -> 0x0130 }
            android.media.MediaCodec$BufferInfo r3 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            long r5 = r3.presentationTimeUs     // Catch:{ Exception -> 0x0130 }
            r13.f46826e = r5     // Catch:{ Exception -> 0x0130 }
            r3 = 0
            goto L_0x0104
        L_0x00fc:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0130 }
            java.lang.String r1 = "drain:muxer hasn't started"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0130 }
            throw r0     // Catch:{ Exception -> 0x0130 }
        L_0x0104:
            android.media.MediaCodec r5 = r13.mMediaCodec     // Catch:{ Exception -> 0x0130 }
            r5.releaseOutputBuffer(r4, r2)     // Catch:{ Exception -> 0x0130 }
            android.media.MediaCodec$BufferInfo r4 = r13.f46825d     // Catch:{ Exception -> 0x0130 }
            int r4 = r4.flags     // Catch:{ Exception -> 0x0130 }
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0025
            r13.mIsCapturing = r2     // Catch:{ Exception -> 0x0130 }
            goto L_0x014d
        L_0x0114:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0130 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r1.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)     // Catch:{ Exception -> 0x0130 }
            r1.append(r4)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r2 = " was null"
            r1.append(r2)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0130 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0130 }
            throw r0     // Catch:{ Exception -> 0x0130 }
        L_0x0130:
            r0 = move-exception
            com.didichuxing.dfbasesdk.video_capture.MediaEncoder$MediaEncoderListener r1 = r13.mListener
            if (r1 == 0) goto L_0x014d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "MediaEncoder record drain error , "
            r2.append(r3)
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.onError(r0)
        L_0x014d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.video_capture.MediaEncoder.drain():void");
    }

    /* access modifiers changed from: protected */
    public long getPTSUs() {
        long nanoTime = System.nanoTime() / 1000;
        long j = this.f46826e;
        return nanoTime < j ? nanoTime + (j - nanoTime) : nanoTime;
    }
}
