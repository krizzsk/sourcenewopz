package com.didi.sdk.audiorecorder.helper.recorder;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.AmrEncoder;
import com.didi.sdk.audiorecorder.helper.recorder.modules.AmrFileWriter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.PcmRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.modules.SilenceDetector;
import com.didi.sdk.audiorecorder.model.AudioRecordContextParcel;
import com.didi.sdk.audiorecorder.speechdetect.SpeechDetectorWrapper;
import com.didi.sdk.audiorecorder.utils.BroadcastHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class AudioRecorderImpl implements AudioRecorder, AudioRecorder.FileSlicer, AudioRecorder.Inner, Supporter.FileConsumer, Supporter.Pcm8kConsumer {

    /* renamed from: a */
    private static final String f35322a = "AudioRecorderImpl -> ";

    /* renamed from: b */
    private static final int f35323b = 1;

    /* renamed from: c */
    private static final int f35324c = 2;

    /* renamed from: d */
    private static final int f35325d = 3;

    /* renamed from: e */
    private static final int f35326e = 4;

    /* renamed from: f */
    private static final int f35327f = 5;

    /* renamed from: g */
    private static final int f35328g = 6;

    /* renamed from: h */
    private static final int f35329h = 7;

    /* renamed from: i */
    private static final int f35330i = 8;

    /* renamed from: A */
    private AudioRecorder.WordsDetectListener f35331A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public AudioRecorder.FileSliceListener f35332B;

    /* renamed from: C */
    private AudioRecorder.OnErrorListener f35333C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public AudioRecorder.DurationChangedListener f35334D;

    /* renamed from: E */
    private Supporter.Pcm16kConsumer f35335E;

    /* renamed from: F */
    private boolean f35336F;

    /* renamed from: G */
    private final ExecutorService f35337G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public final Handler f35338H = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                case 2:
                    removeMessages(5);
                    sendMessageDelayed(obtainMessage(5, AudioRecorderImpl.this.m25041b() + 1000, 0), 1000);
                    if (AudioRecorderImpl.this.f35360y != null) {
                        if (message.what == 1) {
                            AudioRecorderImpl.this.f35360y.onStart();
                        } else {
                            AudioRecorderImpl.this.f35360y.onResume();
                        }
                    }
                    if (AudioRecorderImpl.this.f35354s && AudioRecorderImpl.this.f35359x) {
                        AudioRecorderImpl.this.m25045c();
                        return;
                    }
                    return;
                case 3:
                case 4:
                    removeMessages(5);
                    if (message.what == 4) {
                        AudioRecorderImpl.this.m25032a();
                    }
                    if (AudioRecorderImpl.this.f35360y != null) {
                        if (message.what == 4) {
                            AudioRecorderImpl.this.f35360y.onStop();
                        } else {
                            AudioRecorderImpl.this.f35360y.onPause();
                        }
                    }
                    if (AudioRecorderImpl.this.f35354s && AudioRecorderImpl.this.f35359x) {
                        AudioRecorderImpl.this.m25050e();
                        return;
                    }
                    return;
                case 5:
                    int i = message.arg1;
                    AudioRecorderImpl.this.m25033a(i);
                    sendMessageDelayed(obtainMessage(5, i + 1000, 0), 1000);
                    if (AudioRecorderImpl.this.f35334D != null) {
                        AudioRecorderImpl.this.f35334D.onTimeTick(i);
                        return;
                    }
                    return;
                case 6:
                    if (AudioRecorderImpl.this.f35332B != null) {
                        AudioRecorderImpl.this.f35332B.onAudioFileSliced(((File) message.obj).getAbsolutePath());
                        return;
                    }
                    return;
                case 7:
                    if (AudioRecorderImpl.this.f35332B != null) {
                        AudioRecorderImpl.this.f35332B.onAudioFileCreated(((File) message.obj).getAbsolutePath());
                        return;
                    }
                    return;
                case 8:
                    if (AudioRecorderImpl.this.f35359x && AudioRecorderImpl.this.isRecording()) {
                        AudioRecorderImpl.this.m25048d();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: I */
    private BroadcastReceiver f35339I = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int profileConnectionState = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
            if (profileConnectionState == 0) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt headset disconnect");
            } else if (2 == profileConnectionState) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt headset connected");
                AudioRecorderImpl.this.f35338H.removeMessages(8);
                AudioRecorderImpl.this.f35338H.sendEmptyMessageDelayed(8, 1000);
            } else if (1 == profileConnectionState) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt headset connecting");
            } else if (3 == profileConnectionState) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt headset disconnecting");
            } else {
                LogUtil.log(AudioRecorderImpl.f35322a, "btn headset unknown status：" + profileConnectionState);
            }
        }
    };

    /* renamed from: J */
    private IntentFilter f35340J = new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");

    /* renamed from: K */
    private BroadcastReceiver f35341K = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 0) {
                    LogUtil.log(AudioRecorderImpl.f35322a, "wired headset disconnected");
                    AudioRecorderImpl.this.f35338H.removeMessages(8);
                    AudioRecorderImpl.this.f35338H.sendEmptyMessageDelayed(8, 1000);
                } else if (1 == intExtra) {
                    LogUtil.log(AudioRecorderImpl.f35322a, "wired headset connect");
                } else {
                    LogUtil.log(AudioRecorderImpl.f35322a, "wired headset unknown status: " + intExtra);
                }
            } else {
                LogUtil.log(AudioRecorderImpl.f35322a, "wired headset broadcast empty status");
            }
        }
    };

    /* renamed from: L */
    private IntentFilter f35342L = new IntentFilter("android.intent.action.HEADSET_PLUG");

    /* renamed from: M */
    private BroadcastReceiver f35343M = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            if (1 == intExtra) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt sco connected");
            } else if (2 == intExtra) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt sco connecting");
            } else if (intExtra == 0) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt sco disconnected");
            } else if (-1 == intExtra) {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt sco error");
            } else {
                LogUtil.log(AudioRecorderImpl.f35322a, "bt sco illegal state：" + intExtra);
            }
        }
    };

    /* renamed from: N */
    private IntentFilter f35344N = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");

    /* renamed from: j */
    private final File f35345j;

    /* renamed from: k */
    private final Map<String, Integer> f35346k;

    /* renamed from: l */
    private final C12078a f35347l = new C12078a();

    /* renamed from: m */
    private PcmRecorder f35348m;

    /* renamed from: n */
    private AmrEncoder f35349n;

    /* renamed from: o */
    private AmrFileWriter f35350o;

    /* renamed from: p */
    private SilenceDetector f35351p;

    /* renamed from: q */
    private SpeechDetectorWrapper f35352q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Context f35353r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f35354s;

    /* renamed from: t */
    private String f35355t;

    /* renamed from: u */
    private AudioRecordContext f35356u;

    /* renamed from: v */
    private AudioRecordContextParcel f35357v;

    /* renamed from: w */
    private File f35358w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f35359x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public AudioRecorder.RecordListener f35360y;

    /* renamed from: z */
    private AudioRecorder.RecordListener2 f35361z;

    public AudioRecorderImpl(Context context, String str) {
        this.f35353r = context;
        File file = new File(str);
        this.f35345j = file;
        if (!file.exists()) {
            this.f35345j.mkdirs();
        }
        LogUtil.log(f35322a, "default dir: " + this.f35345j.getAbsolutePath());
        this.f35346k = new HashMap();
        this.f35349n = new AmrEncoder();
        this.f35350o = new AmrFileWriter();
        this.f35351p = new SilenceDetector();
        this.f35352q = new SpeechDetectorWrapper(this.f35353r);
        this.f35350o.setFileConsumer(this);
        this.f35337G = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "didi-recorder");
                thread.setPriority(1);
                return thread;
            }
        });
        m25034a(this.f35353r);
    }

    /* renamed from: a */
    private void m25034a(final Context context) {
        this.f35337G.execute(new Runnable() {
            public void run() {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                try {
                    boolean unused = AudioRecorderImpl.this.f35354s = audioManager != null && audioManager.isBluetoothScoAvailableOffCall();
                } catch (Exception e) {
                    LogUtil.log(AudioRecorderImpl.f35322a, "Failed to get bluetoothSoc available state. ", e.getMessage());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25032a() {
        m25033a(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25033a(int i) {
        this.f35346k.put(this.f35355t, Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m25041b() {
        Integer num = this.f35346k.get(this.f35355t);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void update(AudioRecordContext audioRecordContext, AudioRecordContextParcel audioRecordContextParcel, String str, final boolean z, final String str2, String str3) {
        this.f35356u = audioRecordContext;
        this.f35357v = audioRecordContextParcel;
        this.f35355t = str;
        LogUtil.log("AudioRecorderImpl update : businessAlias = " + str);
        this.f35352q.connectToTtsServer(str3);
        m25035a(audioRecordContext, audioRecordContextParcel);
        this.f35337G.execute(new Runnable() {
            public void run() {
                AudioRecorderImpl.this.m25038a(str2);
                AudioRecorderImpl.this.m25039a(z);
            }
        });
    }

    /* renamed from: a */
    private void m25035a(AudioRecordContext audioRecordContext, AudioRecordContextParcel audioRecordContextParcel) {
        PcmRecorder a = this.f35347l.mo91068a(audioRecordContext, audioRecordContextParcel);
        PcmRecorder pcmRecorder = this.f35348m;
        if (!(pcmRecorder == null || a == pcmRecorder || !pcmRecorder.isStarted())) {
            LogUtil.log(f35322a, "Unable to switch recorder until it was stopped.");
        }
        AmrEncoder amrEncoder = this.f35349n;
        if (!(amrEncoder == null || audioRecordContextParcel == null)) {
            amrEncoder.setConfig(audioRecordContextParcel.amrConvertSwitch, audioRecordContextParcel.amrBitRate);
        }
        if (this.f35348m != a) {
            LogUtil.log(f35322a, "buildRelations");
            this.f35348m = a;
            this.f35351p.setPcm8kProvider(a);
            this.f35352q.buildRelations(a, this.f35349n, this.f35350o);
            AudioRecorder.OnErrorListener onErrorListener = this.f35333C;
            if (onErrorListener != null) {
                a.setOnErrorListener(onErrorListener);
            }
            Supporter.Pcm16kConsumer pcm16kConsumer = this.f35335E;
            if (pcm16kConsumer != null) {
                a.addPcm16kConsumer(pcm16kConsumer);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25039a(boolean z) {
        LogUtil.log(f35322a, "initBluetoothRecordConfig, isBluetoothRecordEnable = " + z + ", mScoAvailable = " + this.f35354s);
        if (this.f35354s && this.f35359x != z) {
            this.f35359x = z;
            if (!isRecording()) {
                return;
            }
            if (z) {
                m25045c();
            } else {
                m25050e();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25038a(String str) {
        LogUtil.log(f35322a, "initAudioCacheDir, target dir:" + str);
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    file = this.f35345j;
                }
                this.f35358w = file;
                LogUtil.log(f35322a, "initAudioCacheDir -> create defined cacheDir. success = " + mkdirs);
            } else if (!file.isDirectory() || !file.canRead() || !file.canWrite()) {
                this.f35358w = this.f35345j;
                LogUtil.log(f35322a, "initAudioCacheDir -> illegal dir");
            } else {
                this.f35358w = file;
            }
        } else {
            this.f35358w = this.f35345j;
        }
        LogUtil.log(f35322a, "initAudioCacheDir -> final dir: ", this.f35358w.getAbsolutePath());
    }

    public synchronized void startRecord() {
        m25035a(this.f35356u, this.f35357v);
        m25044b(true);
    }

    public synchronized void resumeRecord() {
        m25044b(false);
    }

    /* renamed from: b */
    private void m25044b(boolean z) {
        PcmRecorder pcmRecorder;
        if (!this.f35336F && (pcmRecorder = this.f35348m) != null) {
            try {
                pcmRecorder.start();
                if (this.f35348m.isStarted()) {
                    this.f35350o.start();
                    if (!this.f35350o.isStarted()) {
                        this.f35348m.stop();
                        return;
                    }
                    this.f35349n.start();
                    if (!this.f35349n.isStarted()) {
                        this.f35348m.stop();
                        this.f35350o.stop();
                        return;
                    }
                    this.f35352q.start();
                    this.f35351p.start();
                    this.f35336F = true;
                    this.f35338H.sendMessage(this.f35338H.obtainMessage(z ? 1 : 2));
                    BroadcastHelper.getInstance().sendBroadcast(9, "9");
                }
            } catch (Throwable th) {
                LogUtil.log("AudioRecorderImpl resumeRecord -> startRecording failed, state illegal. ", th.getMessage());
                AudioRecorder.OnErrorListener onErrorListener = this.f35333C;
                if (onErrorListener != null) {
                    onErrorListener.onError(0);
                }
            }
        }
    }

    public synchronized void stopRecord() {
        if (this.f35336F) {
            m25046c(true);
        }
    }

    public synchronized void pauseRecord() {
        if (this.f35336F) {
            m25046c(false);
        }
    }

    public void setRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f35360y = recordListener;
        this.f35361z = (recordListener == null || !(recordListener instanceof AudioRecorder.RecordListener2)) ? null : (AudioRecorder.RecordListener2) recordListener;
    }

    public boolean isRecording() {
        return this.f35336F;
    }

    public void setOnErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f35333C = onErrorListener;
        PcmRecorder pcmRecorder = this.f35348m;
        if (pcmRecorder != null) {
            pcmRecorder.setOnErrorListener(onErrorListener);
        }
        this.f35350o.setOnErrorListener(onErrorListener);
        this.f35351p.setOnErrorListener(onErrorListener);
    }

    /* renamed from: c */
    private void m25046c(boolean z) {
        this.f35336F = false;
        PcmRecorder pcmRecorder = this.f35348m;
        if (pcmRecorder != null) {
            pcmRecorder.stop();
        }
        this.f35349n.stop();
        this.f35350o.stop();
        this.f35352q.stop();
        this.f35351p.stop();
        Handler handler = this.f35338H;
        handler.sendMessage(handler.obtainMessage(z ? 4 : 3, (Object) null));
        BroadcastHelper.getInstance().sendBroadcast(9, "10");
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        AudioRecorder.RecordListener2 recordListener2 = this.f35361z;
        if (recordListener2 != null) {
            recordListener2.onGetPcmStream(bArr, 0, i);
        }
    }

    public File getCacheDir() {
        return this.f35358w;
    }

    public File getDefaultDir() {
        return this.f35345j;
    }

    public boolean isDefaultDir(File file) {
        return file != null && (file == this.f35345j || TextUtils.equals(file.getAbsolutePath(), this.f35345j.getAbsolutePath()));
    }

    public void sliceAudioFile() {
        if (this.f35336F) {
            this.f35350o.sliceFile();
        }
    }

    public void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
        this.f35331A = wordsDetectListener;
        this.f35352q.setDetectListener(wordsDetectListener);
    }

    public void setDurationChangedListener(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f35334D = durationChangedListener;
    }

    public void setPcm16kConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        Supporter.Pcm16kConsumer pcm16kConsumer2 = this.f35335E;
        if (pcm16kConsumer2 == null || pcm16kConsumer2 != pcm16kConsumer) {
            PcmRecorder pcmRecorder = this.f35348m;
            if (pcmRecorder != null) {
                if (pcm16kConsumer != null) {
                    pcmRecorder.addPcm16kConsumer(pcm16kConsumer);
                } else {
                    pcmRecorder.removePcm16kConsumer(this.f35335E);
                }
            }
            this.f35335E = pcm16kConsumer;
        }
    }

    public void onTmpFileCreated(File file) {
        Handler handler = this.f35338H;
        handler.sendMessage(handler.obtainMessage(7, file));
    }

    public void onFileFeed(File file) {
        Handler handler = this.f35338H;
        handler.sendMessage(handler.obtainMessage(6, file));
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        this.f35332B = fileSliceListener;
    }

    public void updateSpeechDetectParams(String str) {
        this.f35352q.updateParams(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m25045c() {
        LogUtil.log(f35322a, "startBluetoothScoConnection");
        try {
            try {
                this.f35353r.registerReceiver(this.f35339I, this.f35340J);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        } catch (Exception e2) {
            LogUtil.log(f35322a, "Fail to reg mBluetoothHeadsetReceiver. " + e2.getMessage());
        }
        try {
            try {
                this.f35353r.registerReceiver(this.f35341K, this.f35342L);
            } catch (Exception e3) {
                Log.d("Context", "registerReceiver", e3);
            }
        } catch (Exception e4) {
            LogUtil.log(f35322a, "Fail to reg mWiredHeadsetReceiver. " + e4.getMessage());
        }
        try {
            try {
                this.f35353r.registerReceiver(this.f35343M, this.f35344N);
            } catch (Exception e5) {
                Log.d("Context", "registerReceiver", e5);
            }
        } catch (Exception e6) {
            LogUtil.log(f35322a, "Fail to reg mScoChangedReceiver. " + e6.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25048d() {
        this.f35337G.execute(new Runnable() {
            public void run() {
                AudioManager audioManager;
                if (AudioRecorderImpl.this.f35359x && AudioRecorderImpl.this.isRecording() && (audioManager = (AudioManager) AudioRecorderImpl.this.f35353r.getSystemService("audio")) != null) {
                    LogUtil.log(AudioRecorderImpl.f35322a, "startBluetoothSco");
                    audioManager.setBluetoothScoOn(true);
                    audioManager.startBluetoothSco();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m25050e() {
        LogUtil.log(f35322a, "stopBluetoothScoConnection");
        this.f35338H.removeMessages(8);
        try {
            try {
                this.f35353r.unregisterReceiver(this.f35339I);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        } catch (Exception e2) {
            LogUtil.log(f35322a, "Fail to reg mWiredHeadsetReceiver. " + e2.getMessage());
        }
        try {
            try {
                this.f35353r.unregisterReceiver(this.f35341K);
            } catch (Exception e3) {
                Log.d("Context", "unregisterReceiver", e3);
            }
        } catch (Exception e4) {
            LogUtil.log(f35322a, "Fail to reg mWiredHeadsetReceiver. " + e4.getMessage());
        }
        m25052f();
    }

    /* renamed from: f */
    private void m25052f() {
        this.f35337G.execute(new Runnable() {
            public void run() {
                AudioManager audioManager = (AudioManager) AudioRecorderImpl.this.f35353r.getSystemService("audio");
                if (audioManager != null) {
                    LogUtil.log(AudioRecorderImpl.f35322a, "stopBluetoothSco");
                    audioManager.setBluetoothScoOn(false);
                    audioManager.stopBluetoothSco();
                }
            }
        });
    }

    public void clearTtsDataCache() {
        this.f35352q.clearTtsDataCache();
    }
}
