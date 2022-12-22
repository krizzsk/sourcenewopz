package com.didichuxing.mlcp.drtc.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.trackupload.sdk.Constants;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcCaptureFrameType;
import com.didichuxing.mlcp.drtc.enums.DrtcMode;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.enums.DrtcSvcStatus;
import com.didichuxing.mlcp.drtc.interfaces.C15889c;
import com.didichuxing.mlcp.drtc.interfaces.C15890d;
import com.didichuxing.mlcp.drtc.interfaces.C15891e;
import com.didichuxing.mlcp.drtc.interfaces.CallingService;
import com.didichuxing.mlcp.drtc.interfaces.CallingServiceListener;
import com.didichuxing.mlcp.drtc.interfaces.FrameReceiver;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15895d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15897f;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15898g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C15899h;
import com.didichuxing.mlcp.drtc.models.C15901a;
import com.didichuxing.mlcp.drtc.models.C15903c;
import com.didichuxing.mlcp.drtc.p192a.C15880e;
import com.didichuxing.mlcp.drtc.p192a.C15885g;
import com.didichuxing.mlcp.drtc.p192a.C15886h;
import com.didichuxing.mlcp.drtc.utils.C15916a;
import com.didichuxing.mlcp.drtc.utils.C15924f;
import com.didichuxing.mlcp.drtc.utils.DrtcAudioManager;
import com.didichuxing.mlcp.drtc.utils.MetricReporter;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.EglBase;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* renamed from: com.didichuxing.mlcp.drtc.sdk.a */
/* compiled from: DrtcCallingServiceImpl */
class C15910a implements CallingService, C15890d, C15897f {

    /* renamed from: a */
    private static DrtcSvcStatus f48401a = DrtcSvcStatus.idle;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f48402b = C15910a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DrtcSDK f48403c;

    /* renamed from: d */
    private final C15891e f48404d;

    /* renamed from: e */
    private final List<PeerConnection.IceServer> f48405e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Deque<VideoSink> f48406f = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final HashMap<BigInteger, VideoSink> f48407g = new HashMap<>();

    /* renamed from: h */
    private final DrtcAudioManager f48408h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C15901a f48409i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final HashMap<BigInteger, String> f48410j = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public EglBase f48411k;

    /* renamed from: l */
    private SurfaceViewRenderer f48412l;

    /* renamed from: m */
    private ProxyVideoSink f48413m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C15880e f48414n;

    /* renamed from: o */
    private FrameReceiver f48415o;

    /* renamed from: p */
    private boolean f48416p = false;

    /* renamed from: q */
    private volatile boolean f48417q = false;

    /* renamed from: r */
    private boolean f48418r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f48419s = true;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f48420t = -1;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f48421u = "DroidSDK";
    /* access modifiers changed from: private */

    /* renamed from: v */
    public String f48422v = null;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public String f48423w = "";

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$a */
    /* compiled from: DrtcCallingServiceImpl */
    class C15911a implements C15895d {

        /* renamed from: a */
        private final VideoSink f48424a;

        /* renamed from: b */
        private final BigInteger f48425b;

        /* renamed from: c */
        private final BigInteger f48426c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public DrtcPluginHandle f48427d = null;

        /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$a$a */
        /* compiled from: DrtcCallingServiceImpl */
        class C15912a implements C15899h {

            /* renamed from: a */
            final C15911a f48429a = ((C15911a) this.f48430b.get());

            /* renamed from: b */
            final /* synthetic */ WeakReference f48430b;

            /* renamed from: c */
            final /* synthetic */ JSONObject f48431c;

            C15912a(WeakReference weakReference, JSONObject jSONObject) {
                this.f48430b = weakReference;
                this.f48431c = jSONObject;
            }

            /* renamed from: a */
            public void mo118908a(JSONObject jSONObject) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("jsep", jSONObject);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("request", "start");
                    jSONObject3.put(SDKConsts.TAG_KEY_ROOM, C15910a.this.f48420t);
                    jSONObject2.put("message", jSONObject3);
                    this.f48429a.f48427d.mo119000a((C15898g) new C15885g(jSONObject2));
                } catch (JSONException e) {
                    String b = C15910a.f48402b;
                    SystemUtils.log(6, b, "listener start and config message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a$a", 11);
                }
            }

            /* renamed from: b */
            public Context mo118909b() {
                return C15910a.this.f48403c.mo119023a();
            }

            /* renamed from: c */
            public void mo118890c(String str) {
            }

            /* renamed from: j */
            public JSONObject mo118910j() {
                return this.f48431c;
            }

            /* renamed from: m */
            public EglBase.Context mo118911m() {
                return C15910a.this.f48411k.getEglBaseContext();
            }

            /* renamed from: r */
            public C15901a mo118912r() {
                C15901a i = C15901a.m34545i();
                i.mo118979a((C15903c) null);
                i.mo118984d(false);
                i.mo118981b(C15910a.this.f48409i.mo118985d());
                i.mo118982c(C15910a.this.f48409i.mo118986e());
                return C15910a.this.f48409i;
            }

            /* renamed from: s */
            public Boolean mo118913s() {
                return true;
            }
        }

        C15911a(BigInteger bigInteger, VideoSink videoSink, BigInteger bigInteger2) {
            this.f48424a = videoSink;
            this.f48425b = bigInteger;
            this.f48426c = bigInteger2;
        }

        /* renamed from: a */
        public void mo118947a(int i) {
        }

        /* renamed from: a */
        public void mo118948a(DrtcCameraType drtcCameraType) {
        }

        /* renamed from: a */
        public void mo118950a(String str) {
        }

        /* renamed from: a */
        public void mo118953a(PeerConnection.IceConnectionState iceConnectionState) {
        }

        /* renamed from: a */
        public boolean mo118954a() {
            return true;
        }

        /* renamed from: c */
        public DrtcPluginRoleType mo118955c() {
            return DrtcPluginRoleType.ListenerRole;
        }

        /* renamed from: c */
        public void mo118890c(String str) {
        }

        /* renamed from: d */
        public void mo118956d() {
            SystemUtils.log(6, C15910a.f48402b, "Remote Feed Detached.......", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 1);
        }

        /* renamed from: d */
        public void mo118957d(String str) {
        }

        /* renamed from: g */
        public DrtcSupportedPlugins mo118958g() {
            if (C15910a.this.f48409i.mo118976a() != DrtcMode.OnlyAudio) {
                return DrtcSupportedPlugins.SATURN_VIDEO_ROOM;
            }
            return DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE;
        }

        /* renamed from: o */
        public void mo118959o() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", "leave");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", jSONObject);
                this.f48427d.mo119000a((C15898g) new C15885g(jSONObject2));
            } catch (JSONException e) {
                String b = C15910a.f48402b;
                SystemUtils.log(6, b, "listener send leave message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 8);
            }
        }

        /* renamed from: p */
        public String mo118960p() {
            return "";
        }

        /* renamed from: a */
        public void mo118949a(DrtcPluginHandle drtcPluginHandle) {
            this.f48427d = drtcPluginHandle;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", SDKConsts.ACTION_VALUE_JOIN);
                jSONObject.put(SDKConsts.TAG_KEY_PTYPE, SDKConsts.TAG_VALUE_SUBSCRIBER);
                jSONObject.put(SDKConsts.TAG_KEY_ROOM, C15910a.this.f48420t);
                jSONObject.put(SDKConsts.TAG_KEY_PRIVID, this.f48426c);
                jSONObject.put(SDKConsts.TAG_KEY_FEED, this.f48425b);
                if (StringUtils.isNotEmpty(C15910a.this.f48422v)) {
                    jSONObject.put(SDKConsts.TAG_KEY_PIN, C15910a.this.f48422v);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", jSONObject);
                this.f48427d.mo119000a((C15898g) new C15885g(jSONObject2));
            } catch (JSONException e) {
                String b = C15910a.f48402b;
                SystemUtils.log(6, b, "listener start and config message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 18);
            }
        }

        /* renamed from: a */
        public void mo118951a(JSONObject jSONObject, JSONObject jSONObject2, DrtcPluginHandle drtcPluginHandle) {
            try {
                String string = jSONObject.getString("videoroom");
                if (string.equals("attached") && jSONObject2 != null) {
                    this.f48427d.mo119004b((C15899h) new C15912a(new WeakReference(this), jSONObject2));
                } else if (string.equals("event")) {
                    if (jSONObject.has("started")) {
                        if (jSONObject.getString("started") != null && jSONObject.getString("started").equals("ok")) {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("request", SDKConsts.TAG_VALUE_CONFIGURE);
                                jSONObject4.put("audio", C15910a.this.f48409i.mo118985d());
                                jSONObject4.put("video", C15910a.this.f48409i.mo118986e());
                                jSONObject3.put("message", jSONObject4);
                                this.f48427d.mo119000a((C15898g) new C15885g(jSONObject3));
                                C15910a.this.f48414n.mo118882a(this.f48425b, (C15895d) this);
                                return;
                            } catch (JSONException e) {
                                String b = C15910a.f48402b;
                                SystemUtils.log(6, b, "listener start and config message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 95);
                                return;
                            }
                        }
                    }
                    if (jSONObject.has("left") && jSONObject.getString("left") != null && jSONObject.getString("left").equals("ok")) {
                        C15910a.this.f48414n.mo118887b(this.f48425b, this);
                        drtcPluginHandle.detach();
                    }
                }
            } catch (JSONException e2) {
                String b2 = C15910a.f48402b;
                SystemUtils.log(6, b2, "listener handle rec message ex:" + e2.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 105);
            }
        }

        /* renamed from: a */
        public void mo118952a(MediaStream mediaStream) {
            if (C15910a.this.f48409i.mo118986e()) {
                if (mediaStream.videoTracks.size() > 0) {
                    mediaStream.videoTracks.get(0).addSink(this.f48424a);
                }
            } else if (mediaStream.videoTracks.size() > 0) {
                mediaStream.videoTracks.get(0).setEnabled(false);
                mediaStream.dispose();
            }
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$b */
    /* compiled from: DrtcCallingServiceImpl */
    class C15913b implements C15895d {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C15897f f48433a;

        /* renamed from: b */
        private BigInteger f48434b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public DrtcPluginHandle f48435c;

        /* renamed from: d */
        private boolean f48436d = false;

        /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$b$a */
        /* compiled from: DrtcCallingServiceImpl */
        class C15914a implements C15899h {

            /* renamed from: a */
            final C15913b f48438a = ((C15913b) this.f48439b.get());

            /* renamed from: b */
            final /* synthetic */ WeakReference f48439b;

            C15914a(WeakReference weakReference) {
                this.f48439b = weakReference;
            }

            /* renamed from: a */
            public void mo118908a(JSONObject jSONObject) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("request", SDKConsts.TAG_VALUE_CONFIGURE);
                    jSONObject2.put("audio", C15910a.this.f48409i.mo118987f());
                    jSONObject2.put("video", C15910a.this.f48409i.mo118988g());
                    jSONObject2.put(SDKConsts.TAG_KEY_BITRATE, 800000);
                    jSONObject2.put(SDKConsts.TAG_KEY_RECORD, C15910a.this.f48409i.mo118983c());
                    if (C15910a.this.f48409i.mo118983c() && StringUtils.isNotEmpty(C15910a.this.f48423w)) {
                        jSONObject2.put(SDKConsts.TAG_KEY_FILENAME, C15910a.this.f48423w);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("message", jSONObject2);
                    jSONObject3.put("jsep", jSONObject);
                    this.f48438a.f48435c.mo119000a((C15898g) new C15885g(jSONObject3));
                    this.f48438a.f48433a.mo118890c("[I] Publisher create jsep success and send");
                } catch (JSONException e) {
                    C15897f b = this.f48438a.f48433a;
                    b.mo118890c("[Ex] Publisher send message failed,ex:" + e.getMessage());
                }
            }

            /* renamed from: b */
            public Context mo118909b() {
                return C15910a.this.f48403c.mo119023a();
            }

            /* renamed from: c */
            public void mo118890c(String str) {
                this.f48438a.f48433a.mo118890c(str);
            }

            /* renamed from: j */
            public JSONObject mo118910j() {
                return null;
            }

            /* renamed from: m */
            public EglBase.Context mo118911m() {
                if (C15910a.this.f48411k != null) {
                    return C15910a.this.f48411k.getEglBaseContext();
                }
                return null;
            }

            /* renamed from: r */
            public C15901a mo118912r() {
                C15901a i = C15901a.m34545i();
                i.mo118984d(C15910a.this.f48409i.mo118987f());
                if (C15910a.this.f48409i.mo118976a() == DrtcMode.OnlyAudio) {
                    i.mo118981b(true);
                } else {
                    i.mo118979a(C15910a.this.f48409i.mo118989h());
                    i.mo118981b(false);
                    i.mo118982c(false);
                }
                return C15910a.this.f48409i;
            }

            /* renamed from: s */
            public Boolean mo118913s() {
                return true;
            }
        }

        C15913b(C15897f fVar) {
            this.f48433a = fVar;
        }

        /* renamed from: e */
        private void m34689e() {
            if (this.f48435c != null) {
                WeakReference weakReference = new WeakReference(this);
                if (C15910a.this.f48410j != null) {
                    C15910a.this.f48410j.put(BigInteger.valueOf(999999), C15910a.this.f48421u);
                }
                this.f48435c.mo119001a((C15899h) new C15914a(weakReference));
                return;
            }
            this.f48433a.mo118890c("[E] Publish failed, publisher handler is null");
        }

        /* renamed from: f */
        private void m34690f() {
            if (this.f48435c != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("request", SDKConsts.ACTION_VALUE_JOIN);
                    jSONObject.put(SDKConsts.TAG_KEY_ROOM, C15910a.this.f48420t);
                    jSONObject.put("id", C15910a.this.f48414n.mo118898t());
                    jSONObject.put(SDKConsts.TAG_KEY_PTYPE, SDKConsts.TAG_VALUE_PUBLISHER);
                    jSONObject.put("display", C15910a.this.f48421u);
                    if (StringUtils.isNotEmpty(C15910a.this.f48422v)) {
                        jSONObject.put(SDKConsts.TAG_KEY_PIN, C15910a.this.f48422v);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", jSONObject);
                    this.f48435c.mo119000a((C15898g) new C15885g(jSONObject2));
                    this.f48433a.mo118890c("[I] Publisher joining session ...");
                } catch (JSONException e) {
                    C15897f fVar = this.f48433a;
                    fVar.mo118890c("[Ex] Publisher join session failed, ex:" + e.getMessage());
                }
            } else {
                this.f48433a.mo118890c("[E] Publisher join session, publisher handler is null");
            }
        }

        /* renamed from: a */
        public void mo118952a(MediaStream mediaStream) {
        }

        /* renamed from: c */
        public DrtcPluginRoleType mo118955c() {
            return DrtcPluginRoleType.PublisherRole;
        }

        /* renamed from: d */
        public void mo118957d(String str) {
            C15910a.this.m34640g();
        }

        /* renamed from: g */
        public DrtcSupportedPlugins mo118958g() {
            if (C15910a.this.f48409i.mo118976a() != DrtcMode.OnlyAudio) {
                return DrtcSupportedPlugins.SATURN_VIDEO_ROOM;
            }
            return DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE;
        }

        /* renamed from: o */
        public void mo118959o() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("message", new JSONObject().put("request", "leave"));
                this.f48435c.mo119000a((C15898g) new C15885g(jSONObject));
                this.f48433a.mo118890c("[I] Publisher on leaving...");
            } catch (JSONException e) {
                String b = C15910a.f48402b;
                SystemUtils.log(6, b, "listener send leave message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$b", 9);
            }
        }

        /* renamed from: p */
        public String mo118960p() {
            return "DrtcSDKDroid-" + new C15924f().mo119065a(12);
        }

        /* renamed from: a */
        private void m34687a(BigInteger bigInteger, BigInteger bigInteger2, String str) {
            VideoSink videoSink;
            if (C15910a.this.f48410j != null) {
                if (!C15910a.this.f48410j.containsKey(bigInteger)) {
                    C15910a.this.f48410j.put(bigInteger, str);
                } else {
                    return;
                }
            }
            C15910a.this.m34624a(str);
            if (C15910a.this.f48409i.mo118976a() != DrtcMode.OnlyAudio) {
                if (C15910a.this.f48409i.mo118986e()) {
                    try {
                        Thread.sleep(Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
                    } catch (InterruptedException e) {
                        C15897f fVar = this.f48433a;
                        fVar.mo118890c("[Ex] New Remote Feed thread sleep ex: " + e.getMessage());
                    }
                    if (!C15910a.this.f48407g.containsKey(bigInteger)) {
                        if (C15910a.this.f48406f.isEmpty()) {
                            this.f48433a.mo118890c("[W] No available renderer for Remote Feed ");
                            return;
                        }
                        C15910a.this.f48407g.put(bigInteger, C15910a.this.f48406f.pop());
                    }
                    if (C15910a.this.f48407g.size() > 0) {
                        videoSink = (VideoSink) C15910a.this.f48407g.get(bigInteger);
                        C15910a.this.f48414n.mo118880a((C15895d) new C15911a(bigInteger, videoSink, bigInteger2));
                        this.f48433a.mo118890c("[I] New remote feed attaching ...");
                    }
                }
                videoSink = null;
                C15910a.this.f48414n.mo118880a((C15895d) new C15911a(bigInteger, videoSink, bigInteger2));
                this.f48433a.mo118890c("[I] New remote feed attaching ...");
            }
        }

        /* renamed from: c */
        public void mo118890c(String str) {
            this.f48433a.mo118890c(str);
        }

        /* renamed from: d */
        public void mo118956d() {
            C15910a.this.f48414n.mo118902x();
        }

        /* renamed from: a */
        public void mo118949a(DrtcPluginHandle drtcPluginHandle) {
            C15897f fVar = this.f48433a;
            fVar.mo118890c("[I] Publisher plugin attach success,handler id : " + drtcPluginHandle.mo119003b());
            this.f48435c = drtcPluginHandle;
            C15910a.this.f48403c.f48391a = drtcPluginHandle;
            m34690f();
        }

        /* renamed from: a */
        public void mo118950a(String str) {
            C15910a.this.m34641g(str);
        }

        /* renamed from: a */
        public void mo118951a(JSONObject jSONObject, JSONObject jSONObject2, DrtcPluginHandle drtcPluginHandle) {
            try {
                String string = jSONObject.getString(DrtcSupportedPlugins.pluginEventTag(mo118958g()));
                if (string.equals("joined")) {
                    this.f48433a.mo118890c("[I] Rec resp event: [joined]");
                    if (jSONObject.has(SDKConsts.TAG_KEY_PRIVID)) {
                        this.f48434b = new BigInteger(jSONObject.getString(SDKConsts.TAG_KEY_PRIVID));
                    }
                    if (!this.f48436d && mo118958g() == DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE) {
                        this.f48436d = true;
                        m34689e();
                    }
                    m34685a(mo118958g(), jSONObject);
                } else if (string.equals("destroyed")) {
                    this.f48433a.mo118890c("[I] Publisher receive event: [destroyed]");
                    C15910a.this.m34645j();
                } else if (string.equals("event")) {
                    m34685a(mo118958g(), jSONObject);
                    if (jSONObject.has("leaving")) {
                        this.f48433a.mo118890c("[I] Receive event: [leaving]");
                        if (jSONObject.getString("leaving").equals("ok")) {
                            this.f48435c.detach();
                        } else {
                            m34686a(new BigInteger(jSONObject.getString("leaving")), mo118958g());
                        }
                    } else {
                        if (jSONObject.has("error_code")) {
                            if (jSONObject.getInt("error_code") == 433 || jSONObject.getInt("error_code") == 489) {
                                C15910a.this.m34641g(jSONObject.getString("error"));
                            }
                        }
                        if (jSONObject.has("error_code") && (jSONObject.getInt("error_code") == 426 || jSONObject.getInt("error_code") == 485)) {
                            C15910a.this.m34641g(jSONObject.getString("error"));
                        } else if (jSONObject.has("result") && jSONObject.getString("result").equals("ok")) {
                            this.f48433a.mo118890c("[I] Handler ab configured");
                        } else if (!jSONObject.has("configured") || !jSONObject.getString("configured").equals("ok")) {
                            C15897f fVar = this.f48433a;
                            fVar.mo118890c("[W] Any other event [" + jSONObject + "] ,no resolve");
                        } else {
                            this.f48433a.mo118890c("[I] Handler vc configured");
                        }
                    }
                } else if (string.equals("left")) {
                    this.f48436d = false;
                    this.f48435c.detach();
                }
                if (jSONObject2 != null) {
                    this.f48435c.mo119005c((C15899h) new C15886h((C15901a) null, jSONObject2, true));
                }
            } catch (JSONException e) {
                C15897f fVar2 = this.f48433a;
                fVar2.mo118890c("Publish Message Handle ex: " + e.getMessage());
            }
        }

        /* renamed from: a */
        private void m34685a(DrtcSupportedPlugins drtcSupportedPlugins, JSONObject jSONObject) throws JSONException {
            String str = drtcSupportedPlugins == DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE ? SDKConsts.TAG_COMMON_PARTICIPANTS : SDKConsts.TAG_COMMON_PUBLISHERS;
            if (jSONObject.has(str)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    m34687a(new BigInteger(jSONObject2.getString("id")), this.f48434b, jSONObject2.getString("display"));
                }
            }
        }

        /* renamed from: a */
        private void m34686a(BigInteger bigInteger, DrtcSupportedPlugins drtcSupportedPlugins) {
            if (drtcSupportedPlugins != DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE || C15910a.this.f48410j == null) {
                C15910a.this.f48414n.mo118886b(bigInteger);
                C15910a.this.m34634d(bigInteger.toString());
            } else if (C15910a.this.f48410j.containsKey(bigInteger)) {
                C15910a.this.f48410j.remove(bigInteger);
                C15910a.this.m34634d((String) C15910a.this.f48410j.get(bigInteger));
            }
        }

        /* renamed from: a */
        public boolean mo118954a() {
            return C15910a.this.f48419s;
        }

        /* renamed from: a */
        public void mo118948a(DrtcCameraType drtcCameraType) {
            C15910a.this.m34618a(drtcCameraType);
        }

        /* renamed from: a */
        public void mo118947a(int i) {
            C15910a.this.m34617a(i);
        }

        /* renamed from: a */
        public void mo118953a(PeerConnection.IceConnectionState iceConnectionState) {
            C15897f fVar = this.f48433a;
            fVar.mo118890c("[I] Publisher's ice state change to " + iceConnectionState.toString());
            C15910a.this.m34625a(iceConnectionState);
        }
    }

    C15910a(DrtcSDK drtcSDK) {
        if (drtcSDK != null) {
            m34619a(DrtcSvcStatus.idle);
            this.f48403c = drtcSDK;
            this.f48404d = new C15891e();
            this.f48408h = this.f48403c.f48392b;
            this.f48409i = C15901a.m34545i();
            return;
        }
        throw new NullPointerException("[Ex] Drtc SDK shouldn't be null");
    }

    /* renamed from: a */
    public static DrtcSvcStatus m34616a() {
        return f48401a;
    }

    /* renamed from: c */
    private boolean m34631c() {
        return f48401a == DrtcSvcStatus.idle;
    }

    /* renamed from: d */
    private void m34633d() {
        m34619a(DrtcSvcStatus.idle);
        C15880e eVar = this.f48414n;
        if (eVar != null && this.f48403c != null) {
            eVar.mo118900v();
            mo118890c("[I] Client leave session :" + this.f48403c.mo119026b());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m34638f() {
        m34619a(DrtcSvcStatus.inCall);
        mo118890c("[I] Client pc connected");
        C15889c[] b = this.f48404d.mo118945b();
        if (b != null) {
            for (C15889c cVar : b) {
                CallingServiceListener callingServiceListener = (CallingServiceListener) cVar;
                HashMap<BigInteger, String> hashMap = this.f48410j;
                if (hashMap != null) {
                    callingServiceListener.onConnectReady(false, hashMap.size());
                } else {
                    callingServiceListener.onConnectReady(false, 0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m34640g() {
        mo118890c("[W] Camera open failed --> permission deny");
        C15889c[] b = this.f48404d.mo118945b();
        if (b != null) {
            for (C15889c cVar : b) {
                ((CallingServiceListener) cVar).onCameraNoPermission();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m34645j() {
        mo118890c("[I] Core Session has been destroyed");
        m34619a(DrtcSvcStatus.idle);
        C15889c[] b = this.f48404d.mo118945b();
        if (b != null) {
            for (C15889c cVar : b) {
                ((CallingServiceListener) cVar).onSessionDestroy();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m34647k() {
        if (!m34631c()) {
            mo118890c("[W] Media connection closed by network lost ");
            C15889c[] b = this.f48404d.mo118945b();
            if (b != null) {
                for (C15889c cVar : b) {
                    ((CallingServiceListener) cVar).onDisconnectedByError();
                }
            }
            m34619a(DrtcSvcStatus.idle);
        }
    }

    public void addListener(CallingServiceListener callingServiceListener) {
        C15891e eVar = this.f48404d;
        if (eVar != null) {
            eVar.mo118942a(callingServiceListener);
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str) {
        return callOut(context, surfaceViewRenderer, i, str, true);
    }

    public synchronized DrtcCaptureFrameType captureLocalFrame(FrameReceiver frameReceiver) {
        if (m34631c()) {
            return DrtcCaptureFrameType.NOTINCALLING;
        } else if (!this.f48417q) {
            this.f48417q = true;
            this.f48415o = frameReceiver;
            return DrtcCaptureFrameType.SUCCESS;
        } else {
            return DrtcCaptureFrameType.CAPTURING;
        }
    }

    public int hangupCalling() {
        this.f48403c.mo119024a("[I] Hang up call");
        this.f48408h.mo119044a();
        m34633d();
        return 0;
    }

    /* renamed from: q */
    public List<PeerConnection.IceServer> mo118968q() {
        return this.f48405e;
    }

    public void removeListener(CallingServiceListener callingServiceListener) {
        C15891e eVar = this.f48404d;
        if (eVar != null && eVar.mo118946c() > 0) {
            this.f48404d.mo118944b(callingServiceListener);
        }
    }

    public int setupRemoteVideo(SurfaceViewRenderer surfaceViewRenderer) {
        if (surfaceViewRenderer == null) {
            return -1;
        }
        surfaceViewRenderer.init(this.f48411k.getEglBaseContext(), (RendererCommon.RendererEvents) null);
        surfaceViewRenderer.setEnableHardwareScaler(true);
        this.f48406f.push(surfaceViewRenderer);
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34624a(String str) {
        mo118890c("[I] New remote peer joined");
        C15889c[] b = this.f48404d.mo118945b();
        if (b != null) {
            for (C15889c cVar : b) {
                CallingServiceListener callingServiceListener = (CallingServiceListener) cVar;
                callingServiceListener.onNewRemoteFeed(str);
                callingServiceListener.onNewRemoteFeedWithCount(str, this.f48410j.size());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34634d(String str) {
        mo118890c("[I] Remote peer leaved");
        C15889c[] b = this.f48404d.mo118945b();
        if (b != null) {
            for (C15889c cVar : b) {
                CallingServiceListener callingServiceListener = (CallingServiceListener) cVar;
                callingServiceListener.onRemoteFeedLeave(str);
                callingServiceListener.onRemoteFeedLeaveWithCount(str, this.f48410j.size());
            }
        }
    }

    /* renamed from: e */
    private void m34636e() {
        m34619a(DrtcSvcStatus.idle);
        this.f48403c.mo119027c();
        try {
            if (this.f48405e.size() > 0) {
                this.f48405e.clear();
                mo118890c("[I] Clear ice servers pool");
            }
            if (this.f48407g.size() > 0) {
                for (Map.Entry<BigInteger, VideoSink> value : this.f48407g.entrySet()) {
                    SurfaceViewRenderer surfaceViewRenderer = (SurfaceViewRenderer) value.getValue();
                    surfaceViewRenderer.clearImage();
                    surfaceViewRenderer.release();
                }
                this.f48407g.clear();
                mo118890c("[I] Clear remote renderers");
            }
            if (this.f48412l != null) {
                this.f48412l.clearImage();
                this.f48412l.release();
                mo118890c("[I] Release local renderer");
            }
            if (this.f48411k != null) {
                this.f48411k.release();
                mo118890c("[I] Release rootEglBase context");
            }
            if (this.f48404d.mo118946c() > 0) {
                this.f48404d.mo118943a();
            }
        } catch (NullPointerException e) {
            mo118890c("[Ex] Close Resources ex:" + e.getMessage());
        } finally {
            this.f48412l = null;
            this.f48411k = null;
        }
        mo118890c("[I] Release all resources already");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m34641g(String str) {
        mo118890c("[I] Join session failed :" + str);
        m34619a(DrtcSvcStatus.idle);
        C15889c[] b = this.f48404d.mo118945b();
        if (b != null) {
            for (C15889c cVar : b) {
                ((CallingServiceListener) cVar).onJoinFailed(str);
            }
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, boolean z) {
        this.f48409i.mo118984d(z);
        return m34614a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* renamed from: n */
    public String mo118967n() {
        return SDKConsts.getSysConfig().f48335b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34617a(int i) {
        C15889c[] b;
        if (!m34631c() && (b = this.f48404d.mo118945b()) != null) {
            for (C15889c cVar : b) {
                ((CallingServiceListener) cVar).onNetworkQuality(i);
            }
        }
    }

    /* renamed from: c */
    public void mo118890c(String str) {
        DrtcSDK drtcSDK = this.f48403c;
        if (drtcSDK != null) {
            drtcSDK.mo119024a(str);
        }
    }

    /* renamed from: e */
    public void mo118963e(String str) {
        mo118890c("[I] Session server start Success:" + str);
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, boolean z) {
        return m34614a(context, surfaceViewRenderer, i, str, z, (String) null);
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode) {
        this.f48409i.mo118978a(drtcMode);
        return m34614a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* renamed from: a */
    static synchronized void m34619a(DrtcSvcStatus drtcSvcStatus) {
        synchronized (C15910a.class) {
            f48401a = drtcSvcStatus;
        }
    }

    /* renamed from: a */
    private int m34614a(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, boolean z, String str2) {
        Context context2 = context;
        SurfaceViewRenderer surfaceViewRenderer2 = surfaceViewRenderer;
        int i2 = i;
        String str3 = str;
        boolean z2 = z;
        if (context2 == null || !m34631c()) {
            mo118890c("[W] SDK is in calling ");
            return -1;
        }
        m34619a(DrtcSvcStatus.onCalling);
        this.f48422v = str2;
        this.f48420t = i2;
        this.f48421u = str3;
        if (!this.f48403c.mo119025a(i2)) {
            mo118890c("[W] Init session conn svr failed,please check session info.");
            m34619a(DrtcSvcStatus.idle);
            return -1;
        }
        mo118890c(String.format("[I] Init session conn svr success.server[%s],icesvr[%s]", new Object[]{SDKConsts.getSysConfig().f48335b, SDKConsts.getSysConfig().f48338e}));
        this.f48409i.mo118977a(z2);
        if (z2) {
            this.f48423w = String.format("%s-%s-%s.wav", new Object[]{Integer.valueOf(i), str3, Long.valueOf(new Date().getTime())});
        }
        mo118890c("[I] Joining in drtc-session:" + this.f48403c.mo119026b());
        this.f48411k = EglBase.CC.create();
        if (!(surfaceViewRenderer2 == null || this.f48409i.mo118976a() == DrtcMode.OnlyAudio)) {
            this.f48413m = new ProxyVideoSink();
            this.f48412l = surfaceViewRenderer2;
            try {
                surfaceViewRenderer2.init(this.f48411k.getEglBaseContext(), (RendererCommon.RendererEvents) null);
            } catch (IllegalStateException unused) {
                mo118890c("[W] local render has been init again");
                SystemUtils.log(5, f48402b, "local render has been init again", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a", 48);
            }
            this.f48412l.setMirror(true);
            this.f48412l.setZOrderMediaOverlay(true);
            this.f48412l.setEnableHardwareScaler(true);
            this.f48413m.setTarget(this.f48412l);
            this.f48413m.setListener(this);
        }
        if (this.f48405e.size() < 2) {
            if (StringUtils.isEmpty(SDKConsts.getSysConfig().f48338e) || StringUtils.isEmpty(SDKConsts.getSysConfig().f48339f) || StringUtils.isEmpty(SDKConsts.getSysConfig().f48340g)) {
                mo118890c("[W] add ice servers failed");
            } else {
                this.f48405e.add(PeerConnection.IceServer.builder(String.format("turn:%s?transport=udp", new Object[]{SDKConsts.getSysConfig().f48338e})).setUsername(SDKConsts.getSysConfig().f48339f).setPassword(SDKConsts.getSysConfig().f48340g).createIceServer());
                this.f48405e.add(PeerConnection.IceServer.builder(String.format("stun:%s?transport=udp", new Object[]{SDKConsts.getSysConfig().f48338e})).setUsername(SDKConsts.getSysConfig().f48339f).setPassword(SDKConsts.getSysConfig().f48340g).createIceServer());
                this.f48405e.add(PeerConnection.IceServer.builder(String.format("stun:%s?transport=tcp", new Object[]{SDKConsts.getSysConfig().f48338e})).setUsername(SDKConsts.getSysConfig().f48339f).setPassword(SDKConsts.getSysConfig().f48340g).createIceServer());
            }
        }
        if (this.f48414n == null) {
            this.f48414n = new C15880e(this);
        }
        C15880e eVar = this.f48414n;
        if (eVar == null) {
            mo118890c("[E] Join in session failed,session svr is null");
            m34619a(DrtcSvcStatus.idle);
            return -1;
        } else if (eVar.mo118878a(context2, this.f48418r).mo118901w()) {
            return 0;
        } else {
            mo118890c("[E] Session server start failed,end calling");
            m34619a(DrtcSvcStatus.idle);
            return -1;
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode, boolean z) {
        this.f48419s = z;
        this.f48409i.mo118978a(drtcMode);
        return m34614a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34625a(PeerConnection.IceConnectionState iceConnectionState) {
        if (iceConnectionState.equals(PeerConnection.IceConnectionState.DISCONNECTED)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C15910a.this.m34647k();
                }
            });
        }
        if (iceConnectionState.equals(PeerConnection.IceConnectionState.CONNECTED)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C15910a.this.m34638f();
                }
            });
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode, boolean z, boolean z2) {
        this.f48416p = z2;
        this.f48419s = z;
        this.f48409i.mo118978a(drtcMode);
        return m34614a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* renamed from: h */
    public void mo118965h() {
        mo118890c("[I] Core session destroyed");
        this.f48414n = null;
        m34645j();
        m34636e();
    }

    /* renamed from: i */
    public PeerConnection.IceTransportsType mo118966i() {
        if (this.f48416p) {
            return PeerConnection.IceTransportsType.RELAY;
        }
        return PeerConnection.IceTransportsType.ALL;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34618a(DrtcCameraType drtcCameraType) {
        this.f48412l.setMirror(drtcCameraType == DrtcCameraType.FrontFace);
        mo118890c("[I] Camera switch to " + drtcCameraType.toString() + " by client remote command");
    }

    /* renamed from: b */
    public void mo118962b(String str) {
        mo118890c("[E] Session server start failed:" + str);
        m34641g(str);
    }

    /* renamed from: f */
    public void mo118964f(String str) {
        mo118890c("[E] Core session create failure");
        m34641g(str);
    }

    /* renamed from: a */
    public void mo118941a(VideoFrame videoFrame) {
        if (this.f48417q && videoFrame != null && this.f48415o != null) {
            this.f48417q = false;
            this.f48415o.receiveNewFrame(C15916a.m34717a(videoFrame), DrtcCaptureFrameType.SUCCESS);
            mo118890c("[I] Capture one frame of local");
        }
    }

    /* renamed from: a */
    public void mo118961a(BigInteger bigInteger) {
        mo118890c("[I] Core session [" + bigInteger + "] create success");
        this.f48414n.mo118880a((C15895d) new C15913b(this));
        MetricReporter.getInstance().SetReporterSession(bigInteger.toString());
    }
}
