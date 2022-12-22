package com.jumio.core.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.base.Ascii;
import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALESettings;
import com.jumio.analytics.AnalyticsEvent;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.api.calls.C19963a;
import com.jumio.core.api.calls.C19964b;
import com.jumio.core.api.calls.C19965c;
import com.jumio.core.api.calls.IproovTokenCall;
import com.jumio.core.api.calls.IproovValidateCall;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.api.calls.UsabilityCall;
import com.jumio.core.enums.C19969b;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.C19998b;
import com.jumio.core.persistence.C20003a;
import com.jumio.core.persistence.DataManager;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioDataCenter;
import com.jumio.sdk.enums.JumioScanSide;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLException;
import jumio.core.C21341b0;
import jumio.core.C21342c;
import jumio.core.C21347e;
import jumio.core.C21351f;
import jumio.core.C21353g;
import jumio.core.C21358i0;
import jumio.core.C21376q0;
import jumio.core.C21378r0;
import jumio.core.C21380s0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001_B\u001f\u0012\u0006\u0010B\u001a\u00020=\u0012\u0006\u0010H\u001a\u00020C\u0012\u0006\u0010N\u001a\u00020I¢\u0006\u0004\b]\u0010^J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0007J\u001a\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013J\u0006\u0010\u0017\u001a\u00020\u0007J\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J0\u0010-\u001a\u00020\u00072\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020\u0005J0\u0010/\u001a\u00020\u00072\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0007J\u001e\u00105\u001a\u00020\u00072\n\u00102\u001a\u0006\u0012\u0002\b\u0003012\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u001e\u00108\u001a\u00020\u00072\n\u00102\u001a\u0006\u0012\u0002\b\u0003012\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u001c\u0010<\u001a\u00020;2\b\u00109\u001a\u0004\u0018\u0001032\n\u0010:\u001a\u0006\u0012\u0002\b\u00030\u0013R\u001c\u0010B\u001a\u00020=8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010H\u001a\u00020C8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010N\u001a\u00020I8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0016\u0010W\u001a\u00020T8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0X8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006`"}, mo175978d2 = {"Lcom/jumio/core/api/BackendManager;", "Ljumio/core/f;", "Ljumio/core/g;", "Lcom/jumio/core/persistence/a$a;", "persistor", "", "stop", "", "persist", "Lcom/jumio/core/persistence/a$b;", "restorer", "restore", "Lcom/jumio/core/network/ApiBinding;", "binding", "addBinding", "removeBinding", "clearQueue", "cancelCall", "retry", "Ljava/lang/Class;", "Lcom/jumio/core/network/ApiCall;", "clazz", "remove", "settings", "Lcom/jumio/sdk/credentials/JumioCredential;", "credential", "Lcom/jumio/core/models/ScanPartModel;", "scanPart", "uploadPart", "Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;", "livenessModel", "uploadLiveness", "", "resultKey", "usability", "requestIproovToken", "validateIproovToken", "extractData", "Ljava/util/ArrayList;", "Lcom/jumio/analytics/AnalyticsEvent;", "Lkotlin/collections/ArrayList;", "events", "", "offset", "fireAndForget", "reporting", "lastCall", "analytics", "finalizeCall", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "", "error", "onError", "", "result", "onResult", "e", "sourceClass", "Lcom/jumio/core/error/Error;", "errorFromThrowable", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/jumio/core/persistence/DataManager;", "b", "Lcom/jumio/core/persistence/DataManager;", "getDataManager", "()Lcom/jumio/core/persistence/DataManager;", "dataManager", "Lcom/jumio/core/models/AuthorizationModel;", "c", "Lcom/jumio/core/models/AuthorizationModel;", "getAuthorizationModel", "()Lcom/jumio/core/models/AuthorizationModel;", "authorizationModel", "getEndpoint", "()Ljava/lang/String;", "endpoint", "getUserAgent", "userAgent", "Lcom/jumio/core/network/b;", "getEncryptionProvider", "()Lcom/jumio/core/network/b;", "encryptionProvider", "", "", "getPublicKeys", "()[[B", "publicKeys", "<init>", "(Landroid/content/Context;Lcom/jumio/core/persistence/DataManager;Lcom/jumio/core/models/AuthorizationModel;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: BackendManager.kt */
public final class BackendManager implements C21351f, C21353g {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    public static final String f54617j;

    /* renamed from: k */
    public static final String f54618k;

    /* renamed from: l */
    public static final String f54619l;

    /* renamed from: m */
    public static final String f54620m = StringDeobfuscator.deobfuscate(new byte[]{-102, 125, 101, -22, Ascii.ESC, -1, -83}, 4627847860243393458L);

    /* renamed from: n */
    public static final String f54621n;

    /* renamed from: o */
    public static final String f54622o;

    /* renamed from: p */
    public static final String f54623p;

    /* renamed from: q */
    public static final String f54624q = C21347e.f59604a;

    /* renamed from: r */
    public static final String f54625r = C21347e.f59605b;

    /* renamed from: s */
    public static final String f54626s = C21347e.f59606c;

    /* renamed from: t */
    public static final String f54627t = C21347e.f59607d;

    /* renamed from: u */
    public static final String f54628u = C21347e.f59608e;

    /* renamed from: v */
    public static final String f54629v = C21347e.f59609f;

    /* renamed from: a */
    public final Context f54630a;

    /* renamed from: b */
    public final DataManager f54631b;

    /* renamed from: c */
    public final AuthorizationModel f54632c;

    /* renamed from: d */
    public final SingleProcessor f54633d;

    /* renamed from: e */
    public final QueueProcessor f54634e;

    /* renamed from: f */
    public ALECore f54635f;

    /* renamed from: g */
    public final C21378r0 f54636g = ((C21378r0) getDataManager().get(SettingsModel.class));

    /* renamed from: h */
    public final Object f54637h = new Object();

    /* renamed from: i */
    public final HashMap<Class<?>, ApiBinding> f54638i = new HashMap<>();

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\bR\u001e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\b¨\u0006\u0019"}, mo175978d2 = {"Lcom/jumio/core/api/BackendManager$Companion;", "", "Ljava/lang/Class;", "sourceClass", "", "callNumber", "", "URL_API_NV", "Ljava/lang/String;", "URL_PREFIX_EU", "URL_PREFIX_SG", "URL_PREFIX_US", "USER_AGENT", "kotlin.jvm.PlatformType", "euAleKeyID", "euAlePublicKey", "euPrefix", "sgAleKeyID", "sgAlePublicKey", "sgPrefix", "usAleKeyID", "usAlePublicKey", "usPrefix", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: BackendManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int callNumber(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "sourceClass");
            if (Intrinsics.areEqual((Object) cls, (Object) C19965c.class)) {
                return 1;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) C19963a.class)) {
                return 3;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) UploadCall.class)) {
                return 4;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) C21358i0.class)) {
                return 5;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) C19964b.class)) {
                return 6;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) UsabilityCall.class)) {
                return 7;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) IproovTokenCall.class)) {
                return 8;
            }
            return Intrinsics.areEqual((Object) cls, (Object) IproovValidateCall.class) ? 9 : 0;
        }
    }

    /* renamed from: com.jumio.core.api.BackendManager$a */
    /* compiled from: BackendManager.kt */
    public /* synthetic */ class C19961a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f54639a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f54640b;

        static {
            int[] iArr = new int[JumioScanSide.values().length];
            iArr[JumioScanSide.FRONT.ordinal()] = 1;
            iArr[JumioScanSide.NFC.ordinal()] = 2;
            iArr[JumioScanSide.BACK.ordinal()] = 3;
            iArr[JumioScanSide.FACE.ordinal()] = 4;
            iArr[JumioScanSide.DOCUMENT.ordinal()] = 5;
            f54639a = iArr;
            int[] iArr2 = new int[JumioDataCenter.values().length];
            iArr2[JumioDataCenter.EU.ordinal()] = 1;
            iArr2[JumioDataCenter.US.ordinal()] = 2;
            iArr2[JumioDataCenter.SG.ordinal()] = 3;
            f54640b = iArr2;
        }
    }

    static {
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-38, -22, -25, -126, -69, 10, 65, Ascii.ETB, -28, -59, -20, -57, 45, 85, -81, 79, 32, 42, -106, -35, Ascii.ESC, -118, -85, -69, -95, -37, -83, 79}, 3102386395588422242L);
        f54617j = deobfuscate;
        String deobfuscate2 = StringDeobfuscator.deobfuscate(new byte[]{84, 44, -61, -52, -17, -21, -52, -94, -124, -123, -62, Ascii.f53587FS, -27, 46, 64, 109, -8, -103, 58, 104, -12, 69, -16, 96, -113, 84, 124, -71}, -2860111990246517939L);
        f54618k = deobfuscate2;
        String deobfuscate3 = StringDeobfuscator.deobfuscate(new byte[]{76, -51, -1, -118, 106, -19, 70, Ascii.ETB, -28, 88, 53, 95, 60, 56, 79, -35, -16, -117, 97, 54, Ascii.f53593SI, -117, -47, -32, -101, 11, -76, -85}, -412348624451039355L);
        f54619l = deobfuscate3;
        f54621n = deobfuscate;
        f54622o = deobfuscate2;
        f54623p = deobfuscate3;
    }

    public BackendManager(Context context, DataManager dataManager, AuthorizationModel authorizationModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        this.f54630a = context;
        this.f54631b = dataManager;
        this.f54632c = authorizationModel;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f54633d = new SingleProcessor(newSingleThreadExecutor, this, this);
        ExecutorService newSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor2, "newSingleThreadExecutor()");
        this.f54634e = new QueueProcessor(newSingleThreadExecutor2, this, this);
    }

    /* renamed from: a */
    public static /* synthetic */ void m39501a(BackendManager backendManager, ApiCallDataModel apiCallDataModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        backendManager.mo162540a(apiCallDataModel, z);
    }

    public static /* synthetic */ void analytics$default(BackendManager backendManager, ArrayList arrayList, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        backendManager.analytics(arrayList, j, z);
    }

    @JvmStatic
    public static final int callNumber(Class<?> cls) {
        return Companion.callNumber(cls);
    }

    public static /* synthetic */ void cancelCall$default(BackendManager backendManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        backendManager.cancelCall(z);
    }

    public static /* synthetic */ void reporting$default(BackendManager backendManager, ArrayList arrayList, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        backendManager.reporting(arrayList, j, z);
    }

    public final void addBinding(ApiBinding apiBinding) {
        Intrinsics.checkNotNullParameter(apiBinding, "binding");
        synchronized (this.f54637h) {
            for (Class put : apiBinding.getBindingClasses()) {
                this.f54638i.put(put, apiBinding);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void analytics(ArrayList<AnalyticsEvent> arrayList, long j, boolean z) {
        Intrinsics.checkNotNullParameter(arrayList, "events");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(AnalyticsCall.class);
        apiCallDataModel.setTimeout(this.f54636g.getAnalytics());
        apiCallDataModel.setFireAndForget(z);
        apiCallDataModel.setIgnoreErrors(z);
        apiCallDataModel.getData().put("DATA_EVENTS", arrayList);
        apiCallDataModel.getData().put("DATA_OFFSET", Long.valueOf(j));
        mo162540a(apiCallDataModel, z);
    }

    public final void cancelCall(boolean z) {
        this.f54634e.mo162568a();
        if (z) {
            this.f54634e.mo162573b();
        }
    }

    public final Error errorFromThrowable(Throwable th, Class<?> cls) {
        ErrorCase errorCase;
        Intrinsics.checkNotNullParameter(cls, "sourceClass");
        if (th instanceof Error) {
            return (Error) th;
        }
        Object systemService = getContext().getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) systemService);
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                errorCase = ErrorCase.DEVICE_IS_OFFLINE;
            } else {
                boolean z = th instanceof C21380s0;
                if (z && ((C21380s0) th).mo175871a() == 401) {
                    errorCase = ErrorCase.AUTH_FAILED;
                } else if (z && ((C21380s0) th).mo175871a() == 305) {
                    errorCase = ErrorCase.ALE_KEY_NOT_VALID;
                } else if (z && ((C21380s0) th).mo175871a() == 412) {
                    errorCase = ErrorCase.TRANSACTION_FINISHED;
                } else if (th instanceof SSLException) {
                    errorCase = ErrorCase.CERTIFICATE_ERROR;
                } else if (!z || ((C21380s0) th).mo175871a() != 400 || !Intrinsics.areEqual((Object) cls, (Object) C19964b.class)) {
                    errorCase = ErrorCase.GENERAL_NETWORK_ERROR;
                } else {
                    errorCase = ErrorCase.PROCESS_CANT_BE_COMPLETED;
                }
            }
            return new Error(errorCase, Companion.callNumber(cls), th instanceof C21380s0 ? ((C21380s0) th).mo175871a() : 0);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final void extractData() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C19963a.class);
        apiCallDataModel.setTimeout(this.f54636g.getExtractdata());
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void finalizeCall() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C19964b.class);
        apiCallDataModel.setTimeout(this.f54636g.getFinalize());
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final AuthorizationModel getAuthorizationModel() {
        return this.f54632c;
    }

    public Context getContext() {
        return this.f54630a;
    }

    public DataManager getDataManager() {
        return this.f54631b;
    }

    public synchronized C19998b getEncryptionProvider() {
        if (this.f54635f == null) {
            Environment.loadAleLib();
            ALESettings aLESettings = new ALESettings();
            String str = "";
            int i = C19961a.f54640b[this.f54632c.getDataCenter().ordinal()];
            if (i == 1) {
                aLESettings.setKeyID(f54625r);
                aLESettings.setPublicKey(f54628u);
                str = f54622o;
            } else if (i == 2) {
                aLESettings.setKeyID(f54624q);
                aLESettings.setPublicKey(f54627t);
                str = f54621n;
            } else if (i == 3) {
                aLESettings.setKeyID(f54626s);
                aLESettings.setPublicKey(f54629v);
                str = f54623p;
            }
            String a = C21347e.m42104a(str);
            String stringPlus = Intrinsics.stringPlus(Environment.getDataDirectory(getContext()).getAbsolutePath(), "/ale/");
            if (a != null) {
                stringPlus = stringPlus + a + IOUtils.DIR_SEPARATOR_UNIX;
            }
            File file = new File(stringPlus);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    throw new RuntimeException(Intrinsics.stringPlus("cannot create directory ", file));
                }
            }
            aLESettings.setDirectory(stringPlus);
            this.f54635f = new C21376q0(aLESettings);
        }
        return new C21342c(this.f54635f, this.f54632c.getAuthorization());
    }

    public String getEndpoint() {
        String str;
        int i = C19961a.f54640b[this.f54632c.getDataCenter().ordinal()];
        if (i == 1) {
            str = f54622o;
        } else if (i == 2) {
            str = f54621n;
        } else if (i == 3) {
            str = f54623p;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Intrinsics.stringPlus(str, f54620m);
    }

    public byte[][] getPublicKeys() {
        int i = C19961a.f54640b[this.f54632c.getDataCenter().ordinal()];
        if (i == 1) {
            byte[][] bArr = C21341b0.f59597b;
            Intrinsics.checkNotNullExpressionValue(bArr, "PUBLIC_KEY_EU");
            return bArr;
        } else if (i == 2) {
            byte[][] bArr2 = C21341b0.f59596a;
            Intrinsics.checkNotNullExpressionValue(bArr2, "PUBLIC_KEY_US");
            return bArr2;
        } else if (i == 3) {
            byte[][] bArr3 = C21341b0.f59598c;
            Intrinsics.checkNotNullExpressionValue(bArr3, "PUBLIC_KEY_SG");
            return bArr3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public String getUserAgent() {
        return "Netverify Android SDK 4.1.0";
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        synchronized (this.f54637h) {
            if (this.f54638i.containsKey(apiCallDataModel.getCall())) {
                ApiBinding apiBinding = this.f54638i.get(apiCallDataModel.getCall());
                if (apiBinding != null) {
                    apiBinding.onError(apiCallDataModel, th);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                Log.m39459e(Intrinsics.stringPlus("No error binding for ", apiCallDataModel.getCall().getSimpleName()));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        synchronized (this.f54637h) {
            if (this.f54638i.containsKey(apiCallDataModel.getCall())) {
                ApiBinding apiBinding = this.f54638i.get(apiCallDataModel.getCall());
                if (apiBinding != null) {
                    apiBinding.onResult(apiCallDataModel, obj);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                Log.m39459e(Intrinsics.stringPlus("No result binding for ", apiCallDataModel.getCall().getSimpleName()));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void persist(C20003a.C20004a aVar, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "persistor");
        this.f54633d.mo162579a(aVar, z);
        this.f54634e.mo162570a(aVar, z);
    }

    public final void remove(Class<? extends ApiCall<?>> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.f54634e.mo162572a(cls);
    }

    public final void removeBinding(ApiBinding apiBinding) {
        Intrinsics.checkNotNullParameter(apiBinding, "binding");
        for (Class remove : apiBinding.getBindingClasses()) {
            this.f54638i.remove(remove);
        }
    }

    public final void reporting(ArrayList<AnalyticsEvent> arrayList, long j, boolean z) {
        Intrinsics.checkNotNullParameter(arrayList, "events");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C21358i0.class);
        apiCallDataModel.setTimeout(this.f54636g.getAnalytics());
        apiCallDataModel.setFireAndForget(z);
        apiCallDataModel.setIgnoreErrors(z);
        apiCallDataModel.getData().put("DATA_EVENTS", arrayList);
        apiCallDataModel.getData().put("DATA_OFFSET", Long.valueOf(j));
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void requestIproovToken() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(IproovTokenCall.class);
        apiCallDataModel.setTimeout(this.f54636g.getIproovtoken());
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void restore(C20003a.C20005b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "restorer");
        this.f54633d.mo162580a(bVar);
        this.f54634e.mo162571a(bVar);
    }

    public final void retry() {
        this.f54634e.mo162574c();
    }

    public final void settings() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C19965c.class);
        apiCallDataModel.setTimeout(10000);
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void uploadLiveness(JumioCredential jumioCredential, LivenessDataModel livenessDataModel) {
        Intrinsics.checkNotNullParameter(jumioCredential, "credential");
        Intrinsics.checkNotNullParameter(livenessDataModel, "livenessModel");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(UploadCall.class);
        apiCallDataModel.setTimeout(this.f54636g.getUpload());
        apiCallDataModel.getData().put(UploadCall.DATA_UPLOAD_TYPE, UploadCall.DATA_UPLOAD_TYPE_LIVENESS);
        apiCallDataModel.getData().put(UploadCall.DATA_CREDENTIAL_ID, jumioCredential.getData$jumio_core_release().mo175835e());
        HashMap hashMap = new HashMap();
        hashMap.put(C19969b.LIVENESS_SERIES, livenessDataModel);
        apiCallDataModel.getData().put(UploadCall.DATA_PARTS, hashMap);
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c7, code lost:
        if (r3 != false) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uploadPart(com.jumio.sdk.credentials.JumioCredential r10, com.jumio.core.models.ScanPartModel r11) {
        /*
            r9 = this;
            java.lang.String r0 = "credential"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "scanPart"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.jumio.core.models.ApiCallDataModel r0 = new com.jumio.core.models.ApiCallDataModel
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r1 = com.jumio.core.api.calls.UploadCall.class
            r0.<init>(r1)
            jumio.core.r0 r1 = r9.f54636g
            int r1 = r1.getUpload()
            r0.setTimeout(r1)
            java.util.HashMap r1 = r0.getData()
            java.lang.String r2 = "DATA_UPLOAD_TYPE"
            java.lang.String r3 = "DATA_UPLOAD_TYPE_DEFAULT"
            r1.put(r2, r3)
            java.util.HashMap r1 = r0.getData()
            jumio.core.l r10 = r10.getData$jumio_core_release()
            java.lang.String r10 = r10.mo175835e()
            java.lang.String r2 = "DATA_CREDENTIAL_ID"
            r1.put(r2, r10)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            com.jumio.sdk.enums.JumioScanSide r1 = r11.getSide()
            int[] r2 = com.jumio.core.api.BackendManager.C19961a.f54639a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0068
            if (r1 == r2) goto L_0x0065
            r4 = 3
            if (r1 == r4) goto L_0x0062
            r4 = 4
            if (r1 == r4) goto L_0x005f
            r4 = 5
            if (r1 != r4) goto L_0x0059
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C19969b.FRONTSIDE
            goto L_0x006a
        L_0x0059:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x005f:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C19969b.f54703d
            goto L_0x006a
        L_0x0062:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C19969b.BACKSIDE
            goto L_0x006a
        L_0x0065:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C19969b.FRONTSIDE
            goto L_0x006a
        L_0x0068:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C19969b.FRONTSIDE
        L_0x006a:
            r10.put(r1, r11)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            boolean r4 = r11 instanceof com.jumio.core.models.IDScanPartModel
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L_0x00da
            r4 = r11
            com.jumio.core.models.IDScanPartModel r4 = (com.jumio.core.models.IDScanPartModel) r4
            com.jumio.core.models.DocumentDataModel r7 = r4.getDocumentData()
            if (r7 != 0) goto L_0x0082
            goto L_0x0085
        L_0x0082:
            r7.fillRequest(r1, r11)
        L_0x0085:
            com.jumio.core.util.b r11 = com.jumio.core.util.C20014b.f54990a
            com.jumio.core.models.SelectionModel r7 = r4.getSelectionModel()
            com.jumio.core.data.document.DocumentType r7 = r7.getDocumentType()
            com.jumio.sdk.document.JumioDocumentType r7 = r7.getIdType()
            java.lang.String r7 = r7.name()
            java.lang.String r8 = "idType"
            r11.mo163156a(r1, r8, r7)
            com.jumio.core.models.SelectionModel r7 = r4.getSelectionModel()
            com.jumio.core.data.document.DocumentVariant r7 = r7.getVariant()
            com.jumio.sdk.document.JumioDocumentVariant r7 = r7.getVariant()
            java.lang.String r7 = r7.name()
            java.lang.String r8 = "documentVariant"
            r11.mo163156a(r1, r8, r7)
            com.jumio.core.models.DocumentDataModel r7 = r4.getDocumentData()
            if (r7 != 0) goto L_0x00b9
            r7 = r5
            goto L_0x00bd
        L_0x00b9:
            java.lang.String r7 = r7.getIssuingCountry()
        L_0x00bd:
            if (r7 == 0) goto L_0x00c9
            int r8 = r7.length()
            if (r8 != 0) goto L_0x00c6
            goto L_0x00c7
        L_0x00c6:
            r3 = 0
        L_0x00c7:
            if (r3 == 0) goto L_0x00d5
        L_0x00c9:
            com.jumio.core.models.SelectionModel r3 = r4.getSelectionModel()
            com.jumio.core.data.country.Country r3 = r3.getCountry()
            java.lang.String r7 = r3.getIsoCode()
        L_0x00d5:
            java.lang.String r3 = "issuingCountry"
            r11.mo163156a(r1, r3, r7)
        L_0x00da:
            int r11 = r1.length()
            if (r11 == 0) goto L_0x00ee
            com.jumio.core.enums.b r11 = com.jumio.core.enums.C19969b.DATA
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "json.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r10.put(r11, r1)
        L_0x00ee:
            java.util.HashMap r11 = r0.getData()
            java.lang.String r1 = "DATA_PARTS"
            r11.put(r1, r10)
            m39501a(r9, r0, r6, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.BackendManager.uploadPart(com.jumio.sdk.credentials.JumioCredential, com.jumio.core.models.ScanPartModel):void");
    }

    public final void usability(String str) {
        Intrinsics.checkNotNullParameter(str, "resultKey");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(UsabilityCall.class);
        apiCallDataModel.setTimeout(this.f54636g.getUsability());
        apiCallDataModel.getData().put("DATA_RESULT_KEY", str);
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void validateIproovToken() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(IproovValidateCall.class);
        apiCallDataModel.setTimeout(this.f54636g.getIproovvalidate());
        m39501a(this, apiCallDataModel, false, 2, (Object) null);
    }

    /* renamed from: a */
    public final void mo162540a(ApiCallDataModel<?> apiCallDataModel, boolean z) {
        if (z) {
            this.f54634e.mo162569a(apiCallDataModel);
        } else {
            this.f54633d.mo162578a(apiCallDataModel);
        }
    }
}
