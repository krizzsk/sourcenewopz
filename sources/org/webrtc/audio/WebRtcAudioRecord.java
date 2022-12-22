package org.webrtc.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;

class WebRtcAudioRecord {
    private static final int AUDIO_RECORD_START = 0;
    private static final int AUDIO_RECORD_STOP = 1;
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int CHECK_REC_STATUS_DELAY_MS = 100;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 7;
    private static final String TAG = "WebRtcAudioRecordExternal";
    private final int audioFormat;
    private final AudioManager audioManager;
    /* access modifiers changed from: private */
    public AudioRecord audioRecord;
    /* access modifiers changed from: private */
    public final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
    private final int audioSource;
    private boolean audioSourceMatchesRecordingSession;
    private AudioRecordThread audioThread;
    /* access modifiers changed from: private */
    public ByteBuffer byteBuffer;
    private final Context context;
    private final WebRtcAudioEffects effects;
    /* access modifiers changed from: private */
    public byte[] emptyBytes;
    private final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
    private ScheduledExecutorService executor;
    private ScheduledFuture<String> future;
    private final boolean isAcousticEchoCancelerSupported;
    private boolean isAudioConfigVerified;
    /* access modifiers changed from: private */
    public final boolean isNeedStartLocalAudioRecord;
    private final boolean isNoiseSuppressorSupported;
    /* access modifiers changed from: private */
    public volatile boolean is_have_audio_data;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public volatile boolean microphoneMute;
    /* access modifiers changed from: private */
    public long nativeAudioRecord;
    private final JavaAudioDeviceModule.AudioRecordStateCallback stateCallback;

    private static String audioStateToString(int i) {
        return i != 0 ? i != 1 ? "INVALID" : "STOP" : "START";
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 16 : 12;
    }

    private native void nativeCacheDirectBufferAddress(long j, ByteBuffer byteBuffer2);

    /* access modifiers changed from: private */
    public native void nativeDataIsRecorded(long j, int i);

    private class AudioRecordThread extends Thread {
        private volatile boolean keepAlive = true;

        public AudioRecordThread(String str) {
            super(str);
        }

        public void run() {
            SystemUtils.setProcessThreadPriority(-19);
            WebRtcAudioRecord.this.doAudioRecordStateCallback(0);
            System.nanoTime();
            while (this.keepAlive) {
                if (WebRtcAudioRecord.this.isNeedStartLocalAudioRecord) {
                    int read = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                    if (read != WebRtcAudioRecord.this.byteBuffer.capacity()) {
                        String str = "AudioRecord.read failed: " + read;
                        Logging.m3801e(WebRtcAudioRecord.TAG, str);
                        if (read == -3) {
                            this.keepAlive = false;
                            WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                        }
                    } else {
                        if (WebRtcAudioRecord.this.microphoneMute) {
                            WebRtcAudioRecord.this.byteBuffer.clear();
                            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                        }
                        if (this.keepAlive) {
                            WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                            webRtcAudioRecord.nativeDataIsRecorded(webRtcAudioRecord.nativeAudioRecord, WebRtcAudioRecord.this.byteBuffer.capacity());
                        }
                    }
                } else {
                    synchronized (WebRtcAudioRecord.this.lock) {
                        if (WebRtcAudioRecord.this.is_have_audio_data) {
                            if (WebRtcAudioRecord.this.microphoneMute) {
                                WebRtcAudioRecord.this.byteBuffer.clear();
                                WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                            }
                            if (this.keepAlive) {
                                WebRtcAudioRecord.this.nativeDataIsRecorded(WebRtcAudioRecord.this.nativeAudioRecord, WebRtcAudioRecord.this.byteBuffer.capacity());
                            }
                            boolean unused = WebRtcAudioRecord.this.is_have_audio_data = false;
                        }
                    }
                }
                if (WebRtcAudioRecord.this.audioSamplesReadyCallback != null && WebRtcAudioRecord.this.isNeedStartLocalAudioRecord) {
                    WebRtcAudioRecord.this.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.this.audioRecord.getAudioFormat(), WebRtcAudioRecord.this.audioRecord.getChannelCount(), WebRtcAudioRecord.this.audioRecord.getSampleRate(), Arrays.copyOfRange(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.arrayOffset(), WebRtcAudioRecord.this.byteBuffer.capacity() + WebRtcAudioRecord.this.byteBuffer.arrayOffset())));
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
                WebRtcAudioRecord.this.doAudioRecordStateCallback(1);
            } catch (IllegalStateException e) {
                Logging.m3801e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e.getMessage());
            }
        }

        public void stopThread() {
            Logging.m3800d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    WebRtcAudioRecord(Context context2, AudioManager audioManager2) {
        this(context2, audioManager2, 7, 2, (JavaAudioDeviceModule.AudioRecordErrorCallback) null, (JavaAudioDeviceModule.AudioRecordStateCallback) null, (JavaAudioDeviceModule.SamplesReadyCallback) null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported(), true);
    }

    public WebRtcAudioRecord(Context context2, AudioManager audioManager2, int i, int i2, JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback, JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback, JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, boolean z, boolean z2, boolean z3) {
        this.effects = new WebRtcAudioEffects();
        this.lock = new Object();
        if (z && !WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            throw new IllegalArgumentException("HW AEC not supported");
        } else if (!z2 || WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            this.context = context2;
            this.audioManager = audioManager2;
            this.audioSource = i;
            this.audioFormat = i2;
            this.errorCallback = audioRecordErrorCallback;
            this.stateCallback = audioRecordStateCallback;
            this.audioSamplesReadyCallback = samplesReadyCallback;
            this.isAcousticEchoCancelerSupported = z;
            this.isNoiseSuppressorSupported = z2;
            this.isNeedStartLocalAudioRecord = z3;
            Logging.m3800d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        } else {
            throw new IllegalArgumentException("HW NS not supported");
        }
    }

    public void setNativeAudioRecord(long j) {
        this.nativeAudioRecord = j;
    }

    /* access modifiers changed from: package-private */
    public boolean isAcousticEchoCancelerSupported() {
        return this.isAcousticEchoCancelerSupported;
    }

    /* access modifiers changed from: package-private */
    public boolean isNoiseSuppressorSupported() {
        return this.isNoiseSuppressorSupported;
    }

    /* access modifiers changed from: package-private */
    public boolean isAudioConfigVerified() {
        return this.isAudioConfigVerified;
    }

    /* access modifiers changed from: package-private */
    public boolean isAudioSourceMatchingRecordingSession() {
        if (this.isAudioConfigVerified) {
            return this.audioSourceMatchesRecordingSession;
        }
        Logging.m3804w(TAG, "Audio configuration has not yet been verified");
        return false;
    }

    private boolean enableBuiltInAEC(boolean z) {
        Logging.m3800d(TAG, "enableBuiltInAEC(" + z + ")");
        return this.effects.setAEC(z);
    }

    private boolean enableBuiltInNS(boolean z) {
        Logging.m3800d(TAG, "enableBuiltInNS(" + z + ")");
        return this.effects.setNS(z);
    }

    private int initRecording(int i, int i2) {
        Logging.m3800d(TAG, "initRecording(sampleRate=" + i + ", channels=" + i2 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        this.is_have_audio_data = false;
        int i3 = i / 100;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(getBytesPerSample(this.audioFormat) * i2 * i3);
        this.byteBuffer = allocateDirect;
        if (!allocateDirect.hasArray()) {
            reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
            return -1;
        }
        Logging.m3800d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
        if (!this.isNeedStartLocalAudioRecord) {
            return i3;
        }
        int channelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = AudioRecord.getMinBufferSize(i, channelCountToConfiguration, this.audioFormat);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
            return -1;
        }
        Logging.m3800d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int max = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
        Logging.m3800d(TAG, "bufferSizeInBytes: " + max);
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                this.audioRecord = createAudioRecordOnMOrHigher(this.audioSource, i, channelCountToConfiguration, this.audioFormat, max);
            } else {
                this.audioRecord = createAudioRecordOnLowerThanM(this.audioSource, i, channelCountToConfiguration, this.audioFormat, max);
            }
            AudioRecord audioRecord2 = this.audioRecord;
            if (audioRecord2 == null || audioRecord2.getState() != 1) {
                reportWebRtcAudioRecordInitError("Creation or initialization of audio recorder failed.");
                releaseAudioResources();
                return -1;
            }
            this.effects.enable(this.audioRecord.getAudioSessionId());
            logMainParameters();
            logMainParametersExtended();
            int logRecordingConfigurations = logRecordingConfigurations(false);
            if (logRecordingConfigurations != 0) {
                Logging.m3804w(TAG, "Potential microphone conflict. Active sessions: " + logRecordingConfigurations);
            }
            return i3;
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            reportWebRtcAudioRecordInitError(e.getMessage());
            releaseAudioResources();
            return -1;
        }
    }

    private boolean startRecording() {
        Logging.m3800d(TAG, "startRecording");
        this.is_have_audio_data = false;
        if (this.isNeedStartLocalAudioRecord) {
            assertTrue(this.audioRecord != null);
            assertTrue(this.audioThread == null);
            try {
                this.audioRecord.startRecording();
                if (this.audioRecord.getRecordingState() != 3) {
                    JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH;
                    reportWebRtcAudioRecordStartError(audioRecordStartErrorCode, "AudioRecord.startRecording failed - incorrect state: " + this.audioRecord.getRecordingState());
                    return false;
                }
            } catch (IllegalStateException e) {
                JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode2 = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION;
                reportWebRtcAudioRecordStartError(audioRecordStartErrorCode2, "AudioRecord.startRecording failed: " + e.getMessage());
                return false;
            }
        }
        AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
        this.audioThread = audioRecordThread;
        audioRecordThread.start();
        scheduleLogRecordingConfigurationsTask();
        return true;
    }

    private boolean stopRecording() {
        Logging.m3800d(TAG, "stopRecording");
        assertTrue(this.audioThread != null);
        ScheduledFuture<String> scheduledFuture = this.future;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isDone()) {
                this.future.cancel(true);
            }
            this.future = null;
        }
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.executor = null;
        }
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.m3801e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        }
        this.audioThread = null;
        this.effects.release();
        releaseAudioResources();
        return true;
    }

    private static AudioRecord createAudioRecordOnMOrHigher(int i, int i2, int i3, int i4, int i5) {
        Logging.m3800d(TAG, "createAudioRecordOnMOrHigher");
        return new AudioRecord.Builder().setAudioSource(i).setAudioFormat(new AudioFormat.Builder().setEncoding(i4).setSampleRate(i2).setChannelMask(i3).build()).setBufferSizeInBytes(i5).build();
    }

    private static AudioRecord createAudioRecordOnLowerThanM(int i, int i2, int i3, int i4, int i5) {
        Logging.m3800d(TAG, "createAudioRecordOnLowerThanM");
        return new AudioRecord(i, i2, i3, i4, i5);
    }

    private void logMainParameters() {
        if (this.isNeedStartLocalAudioRecord) {
            Logging.m3800d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
        }
    }

    private void logMainParametersExtended() {
        if (Build.VERSION.SDK_INT >= 23 && this.isNeedStartLocalAudioRecord) {
            Logging.m3800d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
        }
    }

    private int logRecordingConfigurations(boolean z) {
        if (!this.isNeedStartLocalAudioRecord) {
            return 1;
        }
        if (Build.VERSION.SDK_INT < 24) {
            Logging.m3804w(TAG, "AudioManager#getActiveRecordingConfigurations() requires N or higher");
            return 0;
        }
        List<AudioRecordingConfiguration> activeRecordingConfigurations = this.audioManager.getActiveRecordingConfigurations();
        int size = activeRecordingConfigurations.size();
        Logging.m3800d(TAG, "Number of active recording sessions: " + size);
        if (size > 0) {
            logActiveRecordingConfigs(this.audioRecord.getAudioSessionId(), activeRecordingConfigurations);
            if (z) {
                this.audioSourceMatchesRecordingSession = verifyAudioConfig(this.audioRecord.getAudioSource(), this.audioRecord.getAudioSessionId(), this.audioRecord.getFormat(), this.audioRecord.getRoutedDevice(), activeRecordingConfigurations);
                this.isAudioConfigVerified = true;
            }
        }
        return size;
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public void setMicrophoneMute(boolean z) {
        Logging.m3804w(TAG, "setMicrophoneMute(" + z + ")");
        this.microphoneMute = z;
    }

    public void setAudioBuffer(byte[] bArr) {
        synchronized (this.lock) {
            if (bArr.length == this.byteBuffer.capacity()) {
                this.is_have_audio_data = true;
                this.byteBuffer.clear();
                this.byteBuffer.put(bArr);
            }
        }
    }

    private void releaseAudioResources() {
        Logging.m3800d(TAG, "releaseAudioResources");
        AudioRecord audioRecord2 = this.audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.release();
            this.audioRecord = null;
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.m3801e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.m3801e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    /* access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Logging.m3801e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    /* access modifiers changed from: private */
    public void doAudioRecordStateCallback(int i) {
        Logging.m3800d(TAG, "doAudioRecordStateCallback: " + audioStateToString(i));
        JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback = this.stateCallback;
        if (audioRecordStateCallback == null) {
            return;
        }
        if (i == 0) {
            audioRecordStateCallback.onWebRtcAudioRecordStart();
        } else if (i == 1) {
            audioRecordStateCallback.onWebRtcAudioRecordStop();
        } else {
            Logging.m3801e(TAG, "Invalid audio state");
        }
    }

    private static int getBytesPerSample(int i) {
        int i2 = 1;
        if (!(i == 1 || i == 2)) {
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    if (i != 13) {
                        throw new IllegalArgumentException("Bad audio format " + i);
                    }
                }
            }
            return i2;
        }
        return 2;
    }

    private void scheduleLogRecordingConfigurationsTask() {
        Logging.m3800d(TAG, "scheduleLogRecordingConfigurationsTask");
        if (Build.VERSION.SDK_INT >= 24) {
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
            this.executor = Executors.newSingleThreadScheduledExecutor();
            $$Lambda$WebRtcAudioRecord$IuPtu1L1Bj9aB9i_QLIET03iW8Q r0 = new Callable() {
                public final Object call() {
                    return WebRtcAudioRecord.this.mo38226xc3bde0a5();
                }
            };
            ScheduledFuture<String> scheduledFuture = this.future;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.future.cancel(true);
            }
            this.future = this.executor.schedule(r0, 100, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: lambda$scheduleLogRecordingConfigurationsTask$0$WebRtcAudioRecord */
    public /* synthetic */ String mo38226xc3bde0a5() throws Exception {
        logRecordingConfigurations(true);
        return "Scheduled task is done";
    }

    private static boolean logActiveRecordingConfigs(int i, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        Logging.m3800d(TAG, "AudioRecordingConfigurations: ");
        for (AudioRecordingConfiguration next : list) {
            StringBuilder sb = new StringBuilder();
            int clientAudioSource = next.getClientAudioSource();
            sb.append("  client audio source=");
            sb.append(WebRtcAudioUtils.audioSourceToString(clientAudioSource));
            sb.append(", client session id=");
            sb.append(next.getClientAudioSessionId());
            sb.append(" (");
            sb.append(i);
            sb.append(")");
            sb.append("\n");
            AudioFormat format = next.getFormat();
            sb.append("  Device AudioFormat: ");
            sb.append("channel count=");
            sb.append(format.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(format.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(format.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(format.getEncoding()));
            sb.append(", sample rate=");
            sb.append(format.getSampleRate());
            sb.append("\n");
            AudioFormat clientFormat = next.getClientFormat();
            sb.append("  Client AudioFormat: ");
            sb.append("channel count=");
            sb.append(clientFormat.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(clientFormat.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(clientFormat.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(clientFormat.getEncoding()));
            sb.append(", sample rate=");
            sb.append(clientFormat.getSampleRate());
            sb.append("\n");
            AudioDeviceInfo audioDevice = next.getAudioDevice();
            if (audioDevice != null) {
                assertTrue(audioDevice.isSource());
                sb.append("  AudioDevice: ");
                sb.append("type=");
                sb.append(WebRtcAudioUtils.deviceTypeToString(audioDevice.getType()));
                sb.append(", id=");
                sb.append(audioDevice.getId());
            }
            Logging.m3800d(TAG, sb.toString());
        }
        return true;
    }

    private static boolean verifyAudioConfig(int i, int i2, AudioFormat audioFormat2, AudioDeviceInfo audioDeviceInfo, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        for (AudioRecordingConfiguration next : list) {
            AudioDeviceInfo audioDevice = next.getAudioDevice();
            if (audioDevice != null && next.getClientAudioSource() == i && next.getClientAudioSessionId() == i2 && next.getClientFormat().getEncoding() == audioFormat2.getEncoding() && next.getClientFormat().getSampleRate() == audioFormat2.getSampleRate() && next.getClientFormat().getChannelMask() == audioFormat2.getChannelMask() && next.getClientFormat().getChannelIndexMask() == audioFormat2.getChannelIndexMask() && next.getFormat().getEncoding() != 0 && next.getFormat().getSampleRate() > 0) {
                if (!(next.getFormat().getChannelMask() == 0 && next.getFormat().getChannelIndexMask() == 0) && checkDeviceMatch(audioDevice, audioDeviceInfo)) {
                    Logging.m3800d(TAG, "verifyAudioConfig: PASS");
                    return true;
                }
            }
        }
        Logging.m3801e(TAG, "verifyAudioConfig: FAILED");
        return false;
    }

    private static boolean checkDeviceMatch(AudioDeviceInfo audioDeviceInfo, AudioDeviceInfo audioDeviceInfo2) {
        return audioDeviceInfo.getId() == audioDeviceInfo2.getId() && audioDeviceInfo.getType() == audioDeviceInfo2.getType();
    }
}
