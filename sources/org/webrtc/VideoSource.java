package org.webrtc;

import java.util.Objects;

public class VideoSource extends MediaSource {
    private final CapturerObserver capturerObserver = new CapturerObserver() {
        public void onCapturerStarted(boolean z) {
            VideoSource.this.nativeAndroidVideoTrackSource.setState(z);
            synchronized (VideoSource.this.videoProcessorLock) {
                boolean unused = VideoSource.this.isCapturerRunning = z;
                if (VideoSource.this.videoProcessor != null) {
                    VideoSource.this.videoProcessor.onCapturerStarted(z);
                }
            }
        }

        public void onCapturerStopped() {
            VideoSource.this.nativeAndroidVideoTrackSource.setState(false);
            synchronized (VideoSource.this.videoProcessorLock) {
                boolean unused = VideoSource.this.isCapturerRunning = false;
                if (VideoSource.this.videoProcessor != null) {
                    VideoSource.this.videoProcessor.onCapturerStopped();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
            r4 = org.webrtc.VideoProcessor.CC.applyFrameAdaptationParameters(r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
            if (r4 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
            org.webrtc.VideoSource.access$000(r3.this$0).onFrameCaptured(r4);
            r4.release();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFrameCaptured(org.webrtc.VideoFrame r4) {
            /*
                r3 = this;
                org.webrtc.VideoSource r0 = org.webrtc.VideoSource.this
                org.webrtc.NativeAndroidVideoTrackSource r0 = r0.nativeAndroidVideoTrackSource
                org.webrtc.VideoProcessor$FrameAdaptationParameters r0 = r0.adaptFrame(r4)
                if (r0 != 0) goto L_0x001d
                org.webrtc.VideoSource r0 = org.webrtc.VideoSource.this
                org.webrtc.NativeAndroidVideoTrackSource r0 = r0.nativeAndroidVideoTrackSource
                r0.onFrameCaptured(r4)
                java.lang.String r4 = "FrameAdaptationParameters parameters ="
                java.lang.String r0 = " parameters == null"
                org.webrtc.Logging.m3801e(r4, r0)
                return
            L_0x001d:
                org.webrtc.VideoSource r1 = org.webrtc.VideoSource.this
                java.lang.Object r1 = r1.videoProcessorLock
                monitor-enter(r1)
                org.webrtc.VideoSource r2 = org.webrtc.VideoSource.this     // Catch:{ all -> 0x004b }
                org.webrtc.VideoProcessor r2 = r2.videoProcessor     // Catch:{ all -> 0x004b }
                if (r2 == 0) goto L_0x0037
                org.webrtc.VideoSource r2 = org.webrtc.VideoSource.this     // Catch:{ all -> 0x004b }
                org.webrtc.VideoProcessor r2 = r2.videoProcessor     // Catch:{ all -> 0x004b }
                r2.onFrameCaptured(r4, r0)     // Catch:{ all -> 0x004b }
                monitor-exit(r1)     // Catch:{ all -> 0x004b }
                return
            L_0x0037:
                monitor-exit(r1)     // Catch:{ all -> 0x004b }
                org.webrtc.VideoFrame r4 = org.webrtc.VideoProcessor.CC.applyFrameAdaptationParameters(r4, r0)
                if (r4 == 0) goto L_0x004a
                org.webrtc.VideoSource r0 = org.webrtc.VideoSource.this
                org.webrtc.NativeAndroidVideoTrackSource r0 = r0.nativeAndroidVideoTrackSource
                r0.onFrameCaptured(r4)
                r4.release()
            L_0x004a:
                return
            L_0x004b:
                r4 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x004b }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.webrtc.VideoSource.C30041.onFrameCaptured(org.webrtc.VideoFrame):void");
        }
    };
    /* access modifiers changed from: private */
    public boolean isCapturerRunning;
    /* access modifiers changed from: private */
    public final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;
    /* access modifiers changed from: private */
    public VideoProcessor videoProcessor;
    /* access modifiers changed from: private */
    public final Object videoProcessorLock = new Object();

    public static class AspectRatio {
        public static final AspectRatio UNDEFINED = new AspectRatio(0, 0);
        public final int height;
        public final int width;

        public AspectRatio(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    public VideoSource(long j) {
        super(j);
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j);
    }

    public void adaptOutputFormat(int i, int i2, int i3) {
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        adaptOutputFormat(max, min, min, max, i3);
    }

    public void adaptOutputFormat(int i, int i2, int i3, int i4, int i5) {
        adaptOutputFormat(new AspectRatio(i, i2), Integer.valueOf(i * i2), new AspectRatio(i3, i4), Integer.valueOf(i3 * i4), Integer.valueOf(i5));
    }

    public void adaptOutputFormat(AspectRatio aspectRatio, Integer num, AspectRatio aspectRatio2, Integer num2, Integer num3) {
        this.nativeAndroidVideoTrackSource.adaptOutputFormat(aspectRatio, num, aspectRatio2, num2, num3);
    }

    public void setVideoProcessor(VideoProcessor videoProcessor2) {
        synchronized (this.videoProcessorLock) {
            if (this.videoProcessor != null) {
                this.videoProcessor.setSink((VideoSink) null);
                if (this.isCapturerRunning) {
                    this.videoProcessor.onCapturerStopped();
                }
            }
            this.videoProcessor = videoProcessor2;
            if (videoProcessor2 != null) {
                NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource2 = this.nativeAndroidVideoTrackSource;
                Objects.requireNonNull(nativeAndroidVideoTrackSource2);
                videoProcessor2.setSink(new VideoSink() {
                    public final void onFrame(VideoFrame videoFrame) {
                        NativeAndroidVideoTrackSource.this.onFrameCaptured(videoFrame);
                    }
                });
                if (this.isCapturerRunning) {
                    videoProcessor2.onCapturerStarted(true);
                }
            }
        }
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    /* access modifiers changed from: package-private */
    public long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }

    public void dispose() {
        setVideoProcessor((VideoProcessor) null);
        super.dispose();
    }
}
