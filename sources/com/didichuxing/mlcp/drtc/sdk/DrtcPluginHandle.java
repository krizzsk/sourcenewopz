package com.didichuxing.mlcp.drtc.sdk;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.RTCConsts;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.enums.DrtcTransactionType;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15895d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15898g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15899h;
import com.didichuxing.mlcp.drtc.models.C15901a;
import com.didichuxing.mlcp.drtc.p192a.C15880e;
import com.didichuxing.mlcp.drtc.utils.C15919d;
import com.didichuxing.mlcp.drtc.utils.C15925g;
import java.lang.Thread;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.Camera1Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;

public class DrtcPluginHandle {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f48349c = "DrtcPluginHandle";

    /* renamed from: A */
    private PeerConnectionFactory.Options f48350A;

    /* renamed from: B */
    private SurfaceTextureHelper f48351B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public DrtcPluginRoleType f48352C;

    /* renamed from: D */
    private C15919d f48353D = null;

    /* renamed from: E */
    private Thread f48354E = null;

    /* renamed from: F */
    private int f48355F = 3;

    /* renamed from: G */
    private final CameraVideoCapturer.CameraEventsHandler f48356G = new C15905b();

    /* renamed from: a */
    public final DrtcSupportedPlugins f48357a;

    /* renamed from: b */
    public final Context f48358b;

    /* renamed from: d */
    private final BigInteger f48359d;

    /* renamed from: e */
    private final C15880e f48360e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C15895d f48361f;

    /* renamed from: g */
    private final ExecutorService f48362g = Executors.newSingleThreadExecutor();

    /* renamed from: h */
    private final ScheduledExecutorService f48363h = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: i */
    private String f48364i;

    /* renamed from: j */
    private String f48365j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public MediaStream f48366k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SessionDescription f48367l = null;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public PeerConnection f48368m = null;

    /* renamed from: n */
    private AudioDeviceModule f48369n = null;

    /* renamed from: o */
    private RtpSender f48370o = null;

    /* renamed from: p */
    private VideoCapturer f48371p;

    /* renamed from: q */
    private DrtcCameraType f48372q;

    /* renamed from: r */
    private int f48373r = 8000;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f48374s = true;

    /* renamed from: t */
    private boolean f48375t = false;

    /* renamed from: u */
    private boolean f48376u = false;

    /* renamed from: v */
    private boolean f48377v = true;

    /* renamed from: w */
    private boolean f48378w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f48379x = true;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f48380y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public PeerConnectionFactory f48381z = null;

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$a */
    class C15904a implements JavaAudioDeviceModule.AudioRecordStateCallback {
        C15904a() {
        }

        public void onWebRtcAudioRecordStart() {
            boolean unused = DrtcPluginHandle.this.f48380y = true;
            if (DrtcPluginHandle.this.f48379x && DrtcPluginHandle.this.f48352C == DrtcPluginRoleType.PublisherRole) {
                DrtcPluginHandle.this.startExAudioRecorder();
            }
        }

        public void onWebRtcAudioRecordStop() {
            boolean unused = DrtcPluginHandle.this.f48380y = false;
            DrtcPluginHandle.this.stopExAudioRecorder();
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$b */
    class C15905b implements CameraVideoCapturer.CameraEventsHandler {
        C15905b() {
        }

        public void onCameraClosed() {
        }

        public void onCameraDisconnected() {
        }

        public void onCameraError(String str) {
            DrtcPluginHandle.this.f48361f.mo118957d(str);
        }

        public void onCameraFreezed(String str) {
        }

        public void onCameraOpening(String str) {
        }

        public void onFirstFrameAvailable() {
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$c */
    static /* synthetic */ class C15906c {

        /* renamed from: a */
        static final /* synthetic */ int[] f48384a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.webrtc.PeerConnection$IceGatheringState[] r0 = org.webrtc.PeerConnection.IceGatheringState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f48384a = r0
                org.webrtc.PeerConnection$IceGatheringState r1 = org.webrtc.PeerConnection.IceGatheringState.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f48384a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.webrtc.PeerConnection$IceGatheringState r1 = org.webrtc.PeerConnection.IceGatheringState.NEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f48384a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.webrtc.PeerConnection$IceGatheringState r1 = org.webrtc.PeerConnection.IceGatheringState.GATHERING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle.C15906c.<clinit>():void");
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$d */
    private class C15907d extends AsyncTask<C15899h, Void, Void> {
        private C15907d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(C15899h... hVarArr) {
            C15899h hVar = hVarArr[0];
            if (DrtcPluginHandle.this.f48381z == null) {
                hVar.mo118890c("WebRtc PeerFactory is not initialized. Please call initializeMediaContext");
                return null;
            }
            JSONObject j = hVar.mo118910j();
            if (j != null) {
                if (DrtcPluginHandle.this.f48368m == null) {
                    DrtcPluginHandle.this.f48361f.mo118890c("No peerconnection created, if this is an answer please use createAnswer");
                    return null;
                }
                try {
                    DrtcPluginHandle.this.f48368m.setRemoteDescription(new C15909f(hVar), new SessionDescription(SessionDescription.Type.fromCanonicalForm(j.getString("type")), j.getString("sdp")));
                } catch (JSONException e) {
                    hVar.mo118890c(e.getMessage());
                }
            }
            return null;
        }

        /* synthetic */ C15907d(DrtcPluginHandle drtcPluginHandle, C15904a aVar) {
            this();
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$e */
    private class C15908e extends AsyncTask<C15899h, Void, Void> {
        private C15908e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(C15899h... hVarArr) {
            DrtcPluginHandle.this.m34592d(hVarArr[0]);
            return null;
        }

        /* synthetic */ C15908e(DrtcPluginHandle drtcPluginHandle, C15904a aVar) {
            this();
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f */
    private class C15909f implements PeerConnection.Observer, SdpObserver {

        /* renamed from: a */
        private final C15899h f48387a;

        C15909f(C15899h hVar) {
            this.f48387a = hVar;
        }

        public void onAddStream(MediaStream mediaStream) {
            String a = DrtcPluginHandle.f48349c;
            SystemUtils.log(3, a, "[I] Adding remote stream " + mediaStream.getId(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
            MediaStream unused = DrtcPluginHandle.this.f48366k = mediaStream;
            DrtcPluginHandle.this.m34582a(mediaStream);
        }

        public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            String a = DrtcPluginHandle.f48349c;
            SystemUtils.log(3, a, "[I] On add track,receiver id:" + rtpReceiver.mo38015id() + " ms length:" + mediaStreamArr.length, (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }

        public /* synthetic */ void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
            PeerConnection.Observer.CC.$default$onConnectionChange(this, peerConnectionState);
        }

        public void onCreateFailure(String str) {
            C15899h hVar = this.f48387a;
            hVar.mo118890c("[E] Create local SDP failure:" + str);
        }

        public void onCreateSuccess(SessionDescription sessionDescription) {
            this.f48387a.mo118890c("[I] Create local SDP Success");
            DrtcPluginHandle.this.m34583a(sessionDescription, this.f48387a);
        }

        public void onDataChannel(DataChannel dataChannel) {
            SystemUtils.log(3, DrtcPluginHandle.f48349c, "we don't have any channel", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }

        public void onIceCandidate(IceCandidate iceCandidate) {
            if (DrtcPluginHandle.this.f48374s) {
                DrtcPluginHandle.this.m34581a(iceCandidate);
            }
        }

        public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
            this.f48387a.mo118890c("[I] ICE candidate removing...");
        }

        public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
            C15899h hVar = this.f48387a;
            hVar.mo118890c("[I] ICE connection change to:" + iceConnectionState.toString());
            if (DrtcPluginHandle.this.f48361f != null) {
                DrtcPluginHandle.this.f48361f.mo118953a(iceConnectionState);
            }
        }

        public void onIceConnectionReceivingChange(boolean z) {
            C15899h hVar = this.f48387a;
            hVar.mo118890c("[I] ICE connection Receiving change to:" + z);
        }

        public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
            if (C15906c.f48384a[iceGatheringState.ordinal()] == 1) {
                if (!DrtcPluginHandle.this.f48374s) {
                    DrtcPluginHandle drtcPluginHandle = DrtcPluginHandle.this;
                    SessionDescription unused = drtcPluginHandle.f48367l = drtcPluginHandle.f48368m.getLocalDescription();
                    DrtcPluginHandle.this.m34598f(this.f48387a);
                } else {
                    DrtcPluginHandle.this.m34581a((IceCandidate) null);
                }
            }
            C15899h hVar = this.f48387a;
            hVar.mo118890c("[I] ICE gathering change to:" + iceGatheringState.toString());
        }

        public void onRemoveStream(MediaStream mediaStream) {
            String a = DrtcPluginHandle.f48349c;
            SystemUtils.log(6, a, "[I] Removing remote stream " + mediaStream.getId(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
            if (mediaStream != null && mediaStream.videoTracks.size() > 0) {
                mediaStream.videoTracks.get(0).setEnabled(false);
                mediaStream.dispose();
            }
        }

        public void onRenegotiationNeeded() {
            SystemUtils.log(3, DrtcPluginHandle.f48349c, "[I] Ice Renegotiation needed", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }

        public /* synthetic */ void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
            PeerConnection.Observer.CC.$default$onSelectedCandidatePairChanged(this, candidatePairChangeEvent);
        }

        public void onSetFailure(String str) {
            C15899h hVar = this.f48387a;
            hVar.mo118890c("[E] On set Remote SDP Failure" + str);
        }

        public void onSetSuccess() {
            this.f48387a.mo118890c("[I] Set Remote SDP Success");
            if (DrtcPluginHandle.this.f48367l == null) {
                DrtcPluginHandle.this.m34575a(this.f48387a, (Boolean) false);
            }
        }

        public void onSignalingChange(PeerConnection.SignalingState signalingState) {
            C15899h hVar = this.f48387a;
            hVar.mo118890c("[I] RTC signaling change to:" + signalingState.toString());
        }

        public /* synthetic */ void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
            PeerConnection.Observer.CC.$default$onStandardizedIceConnectionChange(this, iceConnectionState);
        }

        public void onTrack(RtpTransceiver rtpTransceiver) {
            String a = DrtcPluginHandle.f48349c;
            SystemUtils.log(3, a, "[I] On add transceiver,transceiver id:" + rtpTransceiver.getMid() + " ,type:" + rtpTransceiver.getMediaType(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }
    }

    public DrtcPluginHandle(C15880e eVar, Context context, DrtcSupportedPlugins drtcSupportedPlugins, BigInteger bigInteger, C15895d dVar, DrtcPluginRoleType drtcPluginRoleType, boolean z) {
        this.f48360e = eVar;
        this.f48357a = drtcSupportedPlugins;
        this.f48359d = bigInteger;
        this.f48361f = dVar;
        this.f48358b = context;
        this.f48352C = drtcPluginRoleType;
        this.f48372q = DrtcCameraType.FrontFace;
        this.f48379x = z;
        PeerConnectionFactory.Options options = new PeerConnectionFactory.Options();
        this.f48350A = options;
        options.disableNetworkMonitor = true;
        this.f48362g.execute(new Runnable() {
            public final void run() {
                DrtcPluginHandle.this.m34590c();
            }
        });
    }

    public void detach() {
        this.f48360e.mo118883a(new JSONObject(), DrtcMessageType.detach, this.f48359d);
    }

    public DrtcPluginRoleType getPluginRoleType() {
        return this.f48352C;
    }

    public void getStats() {
        if (this.f48368m != null) {
            this.f48361f.mo118947a(this.f48355F);
            this.f48355F = 3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hangUp() {
        /*
            r4 = this;
            com.didichuxing.mlcp.drtc.interfaces.f.d r0 = r4.f48361f
            r0.mo118959o()
            java.util.concurrent.ScheduledExecutorService r0 = r4.f48363h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isShutdown()
            if (r0 != 0) goto L_0x0014
            java.util.concurrent.ScheduledExecutorService r0 = r4.f48363h
            r0.shutdown()
        L_0x0014:
            com.didichuxing.mlcp.drtc.utils.d r0 = r4.f48353D
            if (r0 == 0) goto L_0x001b
            r0.mo119058b()
        L_0x001b:
            org.webrtc.PeerConnection r0 = r4.f48368m
            r1 = 0
            if (r0 == 0) goto L_0x0051
            org.webrtc.PeerConnection$SignalingState r0 = r0.signalingState()
            org.webrtc.PeerConnection$SignalingState r2 = org.webrtc.PeerConnection.SignalingState.CLOSED
            if (r0 == r2) goto L_0x0051
            org.webrtc.PeerConnection r0 = r4.f48368m
            java.util.List r0 = r0.getTransceivers()
            java.util.Iterator r0 = r0.iterator()
        L_0x0032:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r0.next()
            org.webrtc.RtpTransceiver r2 = (org.webrtc.RtpTransceiver) r2
            if (r2 == 0) goto L_0x0032
            boolean r3 = r2.isStopped()
            if (r3 != 0) goto L_0x0032
            r2.stop()
            goto L_0x0032
        L_0x004a:
            org.webrtc.PeerConnection r0 = r4.f48368m
            r0.dispose()
            r4.f48368m = r1
        L_0x0051:
            org.webrtc.PeerConnectionFactory r0 = r4.f48381z
            if (r0 == 0) goto L_0x005a
            r0.dispose()
            r4.f48381z = r1
        L_0x005a:
            r4.f48367l = r1
            r0 = 1
            r4.f48374s = r0
            r0 = 0
            r4.f48375t = r0
            r4.f48376u = r0
            org.webrtc.VideoCapturer r0 = r4.f48371p     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            if (r0 == 0) goto L_0x0072
            org.webrtc.VideoCapturer r0 = r4.f48371p     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            r0.stopCapture()     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            r4.f48371p = r1     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r0 = move-exception
            throw r0
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle.hangUp():void");
    }

    public void mute(boolean z) {
        if (this.f48370o != null || (this.f48352C == DrtcPluginRoleType.PublisherRole && this.f48369n != null)) {
            C15895d dVar = this.f48361f;
            dVar.mo118890c("[I] Audio sender mute audio :" + z);
            this.f48369n.setMicrophoneMute(z);
        }
    }

    public void onDetached() {
        this.f48361f.mo118956d();
    }

    public void onMediaStreamArrived(String str, String str2) {
        this.f48361f.mo118890c(String.format("[I] Media stream arrived,type:%s -- receiving:%s", new Object[]{str, str2}));
        this.f48363h.scheduleAtFixedRate(new Runnable() {
            public final void run() {
                DrtcPluginHandle.this.getStats();
            }
        }, 0, 10000, TimeUnit.MILLISECONDS);
    }

    public void onMessage(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f48361f.mo118951a(jSONObject, jSONObject2, this);
    }

    public void pushAudioManual(byte[] bArr) {
        AudioDeviceModule audioDeviceModule;
        if (Build.VERSION.SDK_INT <= 28 && (audioDeviceModule = this.f48369n) != null && bArr != null && bArr.length > 0 && this.f48380y) {
            audioDeviceModule.setAudioBuffer(bArr);
        }
    }

    public void speakerStatus(boolean z) {
        if (this.f48370o != null || (this.f48352C == DrtcPluginRoleType.PublisherRole && this.f48369n != null)) {
            this.f48369n.setSpeakerMute(!z);
        }
    }

    public boolean startExAudioRecorder() {
        if (Build.VERSION.SDK_INT > 28) {
            return true;
        }
        if (this.f48353D == null) {
            C15919d c = C15919d.m34724c();
            this.f48353D = c;
            c.mo119056a(new C15919d.C15920a() {
                /* renamed from: a */
                public final void mo118996a(byte[] bArr) {
                    DrtcPluginHandle.this.m34584a(bArr);
                }
            });
            this.f48354E = new Thread(this.f48353D);
        }
        if (!this.f48353D.mo119057a() && this.f48354E.getState() != Thread.State.NEW) {
            this.f48354E = null;
            this.f48354E = new Thread(this.f48353D);
        }
        this.f48354E.start();
        return true;
    }

    public boolean stopExAudioRecorder() {
        C15919d dVar;
        if (Build.VERSION.SDK_INT <= 28 && (dVar = this.f48353D) != null && dVar.mo119057a()) {
            this.f48353D.mo119058b();
        }
        return true;
    }

    public void updateNtQua(int i) {
        this.f48355F = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34590c() {
        this.f48364i = RTCConsts.VIDEO_CODEC_H264;
        this.f48365j = RTCConsts.AUDIO_CODEC_OPUS;
        if (this.f48377v) {
            AudioDeviceModule d = m34591d();
            this.f48369n = d;
            if (d != null) {
                this.f48381z = PeerConnectionFactory.builder().setOptions(this.f48350A).setAudioDeviceModule(this.f48369n).createPeerConnectionFactory();
                this.f48369n.release();
                this.f48369n.setMicrophoneMute(false);
            }
        } else {
            this.f48381z = PeerConnectionFactory.builder().setOptions(this.f48350A).createPeerConnectionFactory();
        }
        this.f48378w = true;
    }

    /* renamed from: d */
    private AudioDeviceModule m34591d() {
        if (this.f48358b == null) {
            this.f48361f.mo118890c("[E] Create audio device failed since ctx is null");
            return null;
        } else if (Build.VERSION.SDK_INT > 28) {
            this.f48361f.mo118890c("[I] Create audio device with default recorder");
            JavaAudioDeviceModule.Builder builder = JavaAudioDeviceModule.builder(this.f48358b);
            getClass();
            return builder.setAudioFormat(2).setInputSampleRate(this.f48373r).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).setAudioSource(7).setNeedLocalAuidoRecord(true).createAudioDeviceModule();
        } else {
            this.f48361f.mo118890c("[I] Create audio device with extra recorder");
            JavaAudioDeviceModule.Builder builder2 = JavaAudioDeviceModule.builder(this.f48358b);
            getClass();
            return builder2.setAudioFormat(2).setInputSampleRate(this.f48373r).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).setAudioRecordStateCallback(new C15904a()).setAudioSource(7).setNeedLocalAuidoRecord(false).createAudioDeviceModule();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m34598f(C15899h hVar) {
        if (this.f48367l != null) {
            SessionDescription localDescription = this.f48368m.getLocalDescription();
            this.f48367l = localDescription;
            if (!this.f48376u) {
                this.f48376u = true;
                try {
                    SessionDescription sessionDescription = new SessionDescription(this.f48367l.type, C15925g.m34745a(C15925g.m34745a(C15925g.m34746a(this.f48364i, true, localDescription.description, 1), this.f48364i, false), this.f48365j, true));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdp", sessionDescription.description);
                    jSONObject.put("type", sessionDescription.type.canonicalForm());
                    hVar.mo118908a(jSONObject);
                } catch (JSONException e) {
                    hVar.mo118890c("[ERROR]Send sdp error:" + e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo119005c(C15899h hVar) {
        new C15907d(this, (C15904a) null).execute(new C15899h[]{hVar});
        this.f48361f.mo118890c("[I] Handling remote Jsep");
    }

    /* renamed from: e */
    private AudioTrack m34595e() {
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_ECHO_CANCELLATION_CONSTRAINT, "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_AUTO_GAIN_CONTROL_CONSTRAINT, "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_HIGH_PASS_FILTER_CONSTRAINT, SDKConsts.BOOLEAN_FALSE));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_NOISE_SUPPRESSION_CONSTRAINT, "true"));
        PeerConnectionFactory peerConnectionFactory = this.f48381z;
        if (peerConnectionFactory == null) {
            this.f48361f.mo118890c("[E] Create audio track failed:factory is null");
            return null;
        }
        AudioSource createAudioSource = peerConnectionFactory.createAudioSource(mediaConstraints);
        if (createAudioSource == null) {
            this.f48361f.mo118890c("[E] Audio source create failed");
            return null;
        }
        this.f48361f.mo118890c("[I] Audio source create success");
        return this.f48381z.createAudioTrack(RTCConsts.AUDIO_TRACK_ID, createAudioSource);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo119001a(C15899h hVar) {
        new C15908e(this, (C15904a) null).execute(new C15899h[]{hVar});
        this.f48361f.mo118890c("[I] Creating offer sdp");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public BigInteger mo119003b() {
        return this.f48359d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34584a(byte[] bArr) {
        this.f48369n.setAudioBuffer(bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo119000a(C15898g gVar) {
        this.f48360e.mo118879a(DrtcTransactionType.plugin_handle_message, this.f48359d, gVar, this.f48357a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo119004b(C15899h hVar) {
        new C15908e(this, (C15904a) null).execute(new C15899h[]{hVar});
        this.f48361f.mo118890c("[I] Creating answer sdp");
    }

    /* renamed from: a */
    private void m34576a(C15899h hVar, MediaStreamTrack mediaStreamTrack, MediaStreamTrack mediaStreamTrack2) {
        PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(this.f48360e.mo118899u());
        rTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
        rTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.MAXBUNDLE;
        rTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
        rTCConfiguration.keyType = PeerConnection.KeyType.ECDSA;
        rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        rTCConfiguration.iceTransportsType = this.f48360e.f48304a;
        rTCConfiguration.presumeWritableWhenFullyRelayed = true;
        rTCConfiguration.disableIpv6 = true;
        rTCConfiguration.iceCandidatePoolSize = 0;
        rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
        rTCConfiguration.iceConnectionReceivingTimeout = 3000;
        do {
        } while (!this.f48378w);
        PeerConnectionFactory peerConnectionFactory = this.f48381z;
        if (peerConnectionFactory != null) {
            PeerConnection createPeerConnection = peerConnectionFactory.createPeerConnection(rTCConfiguration, (PeerConnection.Observer) new C15909f(hVar));
            this.f48368m = createPeerConnection;
            if (createPeerConnection == null) {
                hVar.mo118890c("[E] Create peerconnection failed");
                return;
            }
            hVar.mo118890c("[I] PeerConnection is prepared and creating... ");
            RtpTransceiver.RtpTransceiverInit a = m34571a(hVar, true);
            if (mediaStreamTrack != null && a != null) {
                this.f48370o = this.f48368m.addTransceiver(mediaStreamTrack, a).getSender();
            } else if (a != null) {
                hVar.mo118890c("[E] audio track is null,add audio track self");
                this.f48370o = this.f48368m.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO, a).getSender();
            }
            RtpTransceiver.RtpTransceiverInit a2 = m34571a(hVar, false);
            if (mediaStreamTrack2 != null) {
                this.f48368m.addTransceiver(mediaStreamTrack2, a2).getSender();
            } else if (a2 != null) {
                this.f48368m.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO, a2).getSender();
            }
            if (hVar.mo118910j() == null) {
                m34575a(hVar, (Boolean) true);
                return;
            }
            try {
                JSONObject j = hVar.mo118910j();
                this.f48368m.setRemoteDescription(new C15909f(hVar), new SessionDescription(SessionDescription.Type.fromCanonicalForm(j.getString("type")), j.getString("sdp")));
            } catch (Exception e) {
                hVar.mo118890c(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34592d(C15899h hVar) {
        MediaStreamTrack mediaStreamTrack;
        MediaStreamTrack mediaStreamTrack2;
        if (this.f48368m == null) {
            this.f48374s = hVar.mo118913s() != null ? hVar.mo118913s().booleanValue() : false;
            do {
            } while (!this.f48378w);
            MediaStreamTrack mediaStreamTrack3 = null;
            if (this.f48352C == DrtcPluginRoleType.PublisherRole) {
                if (hVar.mo118912r().mo118987f()) {
                    mediaStreamTrack2 = m34595e();
                    if (mediaStreamTrack2 == null) {
                        hVar.mo118890c("[E] Audio track created fail");
                    } else {
                        hVar.mo118890c("[I] Audio track created success");
                    }
                } else {
                    mediaStreamTrack2 = null;
                }
                if (hVar.mo118912r().mo118988g().booleanValue()) {
                    try {
                        C15901a r = hVar.mo118912r();
                        mediaStreamTrack3 = m34574a(r.mo118980b(), r.mo118989h().mo118994c(), r.mo118989h().mo118993b(), r.mo118989h().mo118992a(), hVar.mo118911m(), hVar.mo118909b());
                        hVar.mo118890c("[I] Video track created");
                    } catch (Exception e) {
                        hVar.mo118890c(e.getMessage());
                    }
                }
                MediaStreamTrack mediaStreamTrack4 = mediaStreamTrack3;
                mediaStreamTrack3 = mediaStreamTrack2;
                mediaStreamTrack = mediaStreamTrack4;
            } else {
                mediaStreamTrack = null;
            }
            m34576a(hVar, mediaStreamTrack3, mediaStreamTrack);
        } else if (hVar.mo118910j() == null) {
            hVar.mo118890c("[E] Set remote sdp failed,remote sdp is null");
            m34575a(hVar, (Boolean) true);
        } else {
            try {
                JSONObject j = hVar.mo118910j();
                String string = j.getString("sdp");
                this.f48368m.setRemoteDescription(new C15909f(hVar), new SessionDescription(SessionDescription.Type.fromCanonicalForm(j.getString("type")), string));
                hVar.mo118890c("[I] Setting remote sdp ......" + string);
            } catch (JSONException e2) {
                hVar.mo118890c(e2.getMessage());
            }
        }
    }

    /* renamed from: e */
    private MediaConstraints m34596e(C15899h hVar) {
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.optional.add(new MediaConstraints.KeyValuePair(RTCConsts.DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT, "true"));
        if (hVar.mo118912r().mo118985d()) {
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.MEDIA_CONSTRAINTS_RECV_AUDIO, "true"));
        }
        if (hVar.mo118912r().mo118986e()) {
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.MEDIA_CONSTRAINTS_RECV_VIDEO, "true"));
        }
        return mediaConstraints;
    }

    /* renamed from: a */
    private RtpTransceiver.RtpTransceiverInit m34571a(C15899h hVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1198181");
        RtpTransceiver.RtpTransceiverDirection rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.INACTIVE;
        if (z) {
            if (hVar.mo118912r().mo118985d() && hVar.mo118912r().mo118987f()) {
                rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_RECV;
            } else if (hVar.mo118912r().mo118985d()) {
                rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.RECV_ONLY;
            } else if (hVar.mo118912r().mo118987f()) {
                rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_ONLY;
            }
        } else if (hVar.mo118912r().mo118986e() && hVar.mo118912r().mo118988g().booleanValue()) {
            rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_RECV;
        } else if (hVar.mo118912r().mo118986e()) {
            rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.RECV_ONLY;
        } else if (hVar.mo118912r().mo118988g().booleanValue()) {
            rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_ONLY;
        }
        if (rtpTransceiverDirection == RtpTransceiver.RtpTransceiverDirection.INACTIVE) {
            return null;
        }
        return new RtpTransceiver.RtpTransceiverInit(rtpTransceiverDirection, arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34582a(MediaStream mediaStream) {
        this.f48361f.mo118952a(mediaStream);
    }

    /* renamed from: a */
    private VideoTrack m34574a(DrtcCameraType drtcCameraType, int i, int i2, int i3, EglBase.Context context, Context context2) throws Exception {
        VideoCapturer videoCapturer = this.f48371p;
        if (videoCapturer != null) {
            videoCapturer.stopCapture();
        }
        VideoCapturer a = m34573a((CameraEnumerator) new Camera1Enumerator(false), drtcCameraType);
        this.f48371p = a;
        if (a != null) {
            this.f48351B = SurfaceTextureHelper.create("CaptureThread", context);
            VideoSource createVideoSource = this.f48381z.createVideoSource(this.f48371p.isScreencast());
            if (createVideoSource != null) {
                this.f48371p.initialize(this.f48351B, context2, createVideoSource.getCapturerObserver());
                this.f48371p.startCapture(i, i2, i3);
                VideoTrack createVideoTrack = this.f48381z.createVideoTrack(RTCConsts.VIDEO_TRACK_ID, createVideoSource);
                createVideoTrack.setEnabled(true);
                return createVideoTrack;
            }
            throw new Exception("[Ex] Can't create local video track");
        }
        throw new Exception("[Ex] Can't create local video track");
    }

    /* renamed from: a */
    private VideoCapturer m34573a(CameraEnumerator cameraEnumerator, DrtcCameraType drtcCameraType) {
        CameraVideoCapturer createCapturer;
        CameraVideoCapturer createCapturer2;
        CameraVideoCapturer createCapturer3;
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        for (String str : deviceNames) {
            if (DrtcCameraType.FrontFace.equals(drtcCameraType)) {
                if (cameraEnumerator.isFrontFacing(str) && (createCapturer3 = cameraEnumerator.createCapturer(str, this.f48356G)) != null) {
                    return createCapturer3;
                }
            } else if (cameraEnumerator.isBackFacing(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, this.f48356G)) != null) {
                return createCapturer2;
            }
        }
        for (String str2 : deviceNames) {
            if (!cameraEnumerator.isFrontFacing(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, (CameraVideoCapturer.CameraEventsHandler) null)) != null) {
                return createCapturer;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34575a(C15899h hVar, Boolean bool) {
        if (bool.booleanValue()) {
            this.f48368m.createOffer(new C15909f(hVar), m34596e(hVar));
        } else {
            this.f48368m.createAnswer(new C15909f(hVar), m34596e(hVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo119002a(DrtcCameraType drtcCameraType) {
        C15895d dVar = this.f48361f;
        dVar.mo118890c("[I] Switch camera :" + drtcCameraType.toString());
        if (this.f48372q.equals(drtcCameraType)) {
            return true;
        }
        VideoCapturer videoCapturer = this.f48371p;
        if (!(videoCapturer instanceof CameraVideoCapturer)) {
            return false;
        }
        ((CameraVideoCapturer) videoCapturer).switchCamera((CameraVideoCapturer.CameraSwitchHandler) null);
        this.f48372q = drtcCameraType;
        this.f48361f.mo118948a(drtcCameraType);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34583a(SessionDescription sessionDescription, C15899h hVar) {
        if (this.f48368m != null) {
            if (this.f48367l == null) {
                SessionDescription sessionDescription2 = new SessionDescription(sessionDescription.type, C15925g.m34745a(C15925g.m34745a(C15925g.m34746a(this.f48364i, true, sessionDescription.description, 1), this.f48364i, false), this.f48365j, true));
                this.f48367l = null;
                this.f48367l = sessionDescription2;
                this.f48368m.setLocalDescription(new C15909f(hVar), sessionDescription2);
                hVar.mo118890c("[I] Setting local sdp,sdp type : " + this.f48367l.type);
            }
            if ((this.f48375t || this.f48374s) && !this.f48376u) {
                try {
                    this.f48376u = true;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdp", this.f48367l.description);
                    jSONObject.put("type", this.f48367l.type.canonicalForm());
                    hVar.mo118908a(jSONObject);
                } catch (JSONException e) {
                    hVar.mo118890c(e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34581a(IceCandidate iceCandidate) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (iceCandidate == null) {
                jSONObject2.put("completed", true);
            } else {
                jSONObject2.put("candidate", iceCandidate.sdp);
                jSONObject2.put("sdpMid", iceCandidate.sdpMid);
                jSONObject2.put("sdpMLineIndex", iceCandidate.sdpMLineIndex);
            }
            jSONObject.put("candidate", jSONObject2);
            this.f48360e.mo118883a(jSONObject, DrtcMessageType.trickle, this.f48359d);
        } catch (JSONException e) {
            C15895d dVar = this.f48361f;
            dVar.mo118890c("[ERROR]Send candidates error:" + e.getMessage());
        }
    }
}
