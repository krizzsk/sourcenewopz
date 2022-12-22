package com.iproov.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C19889if;
import com.iproov.sdk.core.C19902return;
import com.iproov.sdk.core.exception.CaptureAlreadyActiveException;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.ListenerNotRegisteredException;
import com.iproov.sdk.core.exception.MultiWindowUnsupportedException;
import com.iproov.sdk.crypto.KeyPair;
import com.iproov.sdk.logging.IPLog;
import com.jumio.core.environment.Environment;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p066native.C2381if;
import p093switch.C3127throw;

public final class IProov {

    /* renamed from: a */
    static final AtomicBoolean f53987a = new AtomicBoolean(false);

    /* renamed from: b */
    static C19889if f53988b = null;

    /* renamed from: c */
    private static final String f53989c = "IProov";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Options f53990d = new Options();

    /* renamed from: e */
    private static C19763a f53991e = new C19763a();
    public static final NativeBridge nativeBridge = new NativeBridge();

    public enum Camera {
        FRONT,
        EXTERNAL
    }

    public enum FaceDetector {
        AUTO,
        CLASSIC,
        ML_KIT,
        BLAZEFACE
    }

    public static class FailureResult {
        public final String feedbackCode;
        public final Bitmap frame;
        public final String reason;
        public final String token;

        public FailureResult(String str, String str2, String str3, Bitmap bitmap) {
            this.token = str;
            this.reason = str2;
            this.feedbackCode = str3;
            this.frame = bitmap;
        }
    }

    public enum Filter {
        CLASSIC(1.0f),
        SHADED(0.75f),
        VIBRANT(0.0f);
        
        private final float alpha;

        private Filter(float f) {
            this.alpha = f;
        }

        public float getAlpha() {
            return this.alpha;
        }
    }

    public interface Listener {
        void onCancelled();

        void onConnected();

        void onConnecting();

        void onError(IProovException iProovException);

        void onFailure(FailureResult failureResult);

        void onProcessing(double d, String str);

        void onSuccess(SuccessResult successResult);
    }

    public static class Options {
        public Capture capture = new Capture();
        public Network network = new Network();

        /* renamed from: ui */
        public C19751UI f53992ui = new C19751UI();

        public static final class Capture {
            public Camera camera = Camera.FRONT;
            public FaceDetector faceDetector = FaceDetector.AUTO;
            public GenuinePresenceAssurance genuinePresenceAssurance = new GenuinePresenceAssurance();

            public static final class GenuinePresenceAssurance {
                public Float maxPitch = null;
                public Float maxRoll = null;
                public Float maxYaw = null;
            }
        }

        public static final class Network {
            public List<Object> certificates = new ArrayList(Collections.singletonList(Integer.valueOf(R.raw.iproov__certificate)));
            public String path = "/socket.io/v2/";
            public int timeoutSecs = 10;
        }

        /* renamed from: com.iproov.sdk.IProov$Options$UI */
        public static final class C19751UI {
            public Integer activityCompatibilityRequestCode = null;
            public int backgroundColor = Color.parseColor("#FAFAFA");
            public boolean enableScreenshots = false;
            public Filter filter = Filter.SHADED;
            public boolean floatingPromptEnabled = false;
            public String fontPath = null;
            public int fontResource = -1;
            public int footerBackgroundColor = Color.parseColor("#AA000000");
            @Deprecated
            public int footerTextColor = Color.parseColor("#FFFFFFFF");
            public GenuinePresenceAssurance genuinePresenceAssurance = new GenuinePresenceAssurance();
            public int headerBackgroundColor = Color.parseColor("#AA000000");
            public int headerTextColor = Color.parseColor("#FFFFFFFF");
            public int lineColor = Color.parseColor("#404040");
            public LivenessAssurance livenessAssurance = new LivenessAssurance();
            public Drawable logoImageDrawable = null;
            public int logoImageResource = -1;
            public Orientation orientation = Orientation.PORTRAIT;
            public int promptTextColor = Color.parseColor("#FFFFFFFF");
            public String title = null;

            /* renamed from: com.iproov.sdk.IProov$Options$UI$GenuinePresenceAssurance */
            public static final class GenuinePresenceAssurance {
                public boolean autoStartDisabled = false;
                public int notReadyTintColor = Color.parseColor("#f5a623");
                public int progressBarColor = Color.parseColor("#FF000000");
                public int readyTintColor = Color.parseColor("#01bf46");
            }

            /* renamed from: com.iproov.sdk.IProov$Options$UI$LivenessAssurance */
            public static final class LivenessAssurance {
                public int primaryTintColor = Color.parseColor("#1756E5");
                public int secondaryTintColor = Color.parseColor("#A8A8A8");
            }

            public int getPromptTextColor() {
                if (this.promptTextColor != IProov.f53990d.f53992ui.promptTextColor) {
                    return this.promptTextColor;
                }
                return this.footerTextColor;
            }
        }
    }

    public enum StreamingTransport {
        WEB_SOCKETS,
        POLLING,
        AUTO
    }

    public static class SuccessResult {
        public final Bitmap frame;
        public final String token;

        public SuccessResult(String str, Bitmap bitmap) {
            this.token = str;
            this.frame = bitmap;
        }
    }

    private IProov() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m38648b(Context context, String str, String str2, C19902return returnR) {
        try {
            C19889if ifVar = new C19889if(context, str, str2, returnR, f53991e);
            f53988b = ifVar;
            ifVar.m47527super();
        } catch (IProovException e) {
            e.printStackTrace();
            f53991e.onError(e);
        }
    }

    public static String getBuildHash() {
        return "1b8668f8 ";
    }

    public static String getBuildNumber() {
        return "6135";
    }

    public static C19889if getCaptureManager() {
        return f53988b;
    }

    public static KeyPair getKeyPair(Context context) throws IProovException {
        return new KeyPair(context);
    }

    public static String getSDKVersion() {
        return Environment.IPROOV_VERSION;
    }

    public static void launch(Context context, String str, String str2) throws IProovException {
        launch(context, str, str2, new Options());
    }

    public static void registerListener(Listener listener) {
        f53991e.mo161867a(listener, false);
    }

    public static void unregisterListener(Listener listener) {
        f53991e.mo161866a(listener);
    }

    public static void launch(Context context, String str, String str2, Options options) throws IProovException {
        m38647a(context, str, str2, new C19902return(options));
    }

    public static void registerListener(Listener listener, boolean z) {
        f53991e.mo161867a(listener, z);
    }

    /* renamed from: a */
    static void m38647a(Context context, String str, String str2, C19902return returnR) throws IProovException {
        if (!f53991e.mo161869a()) {
            throw new ListenerNotRegisteredException(context);
        } else if (Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode()) {
            throw new MultiWindowUnsupportedException(context);
        } else if (f53987a.compareAndSet(false, true)) {
            f53991e.mo161870b();
            IPLog.setLoggingEnabled(new C2381if(context).m46150final());
            C3127throw.m4052do((Runnable) new Runnable(context, str, str2, returnR) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ C19902return f$3;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    IProov.m38648b(this.f$0, this.f$1, this.f$2, this.f$3);
                }
            });
        } else {
            throw new CaptureAlreadyActiveException(context);
        }
    }
}
