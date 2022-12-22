package p001a;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import com.jumio.commons.log.Log;
import com.jumio.core.enums.ErrorCase;
import com.jumio.defaultui.view.LoadingView;
import com.jumio.sdk.JumioSDK;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.result.JumioResult;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: a.a */
/* compiled from: JumioViewModel.kt */
public final class C0010a extends AndroidViewModel implements JumioControllerInterface, JumioScanPartInterface {

    /* renamed from: m */
    public static final String f0m = C0010a.class.getSimpleName();

    /* renamed from: a */
    public final SavedStateHandle f1a;

    /* renamed from: b */
    public final Lazy f2b;

    /* renamed from: c */
    public JumioController f3c;

    /* renamed from: d */
    public ArrayList<JumioCredentialInfo> f4d = new ArrayList<>();

    /* renamed from: e */
    public JumioCredential f5e;

    /* renamed from: f */
    public JumioScanPart f6f;

    /* renamed from: g */
    public final C0020c<C0013c> f7g;

    /* renamed from: h */
    public final MutableLiveData<JumioScanStep> f8h;

    /* renamed from: i */
    public final MutableLiveData<Pair<JumioScanUpdate, JumioScanSide>> f9i;

    /* renamed from: j */
    public final MutableLiveData<Boolean> f10j;

    /* renamed from: k */
    public MutableLiveData<JumioResult> f11k;

    /* renamed from: l */
    public MutableLiveData<JumioError> f12l;

    /* renamed from: a.a$a */
    /* compiled from: JumioViewModel.kt */
    public static final class C0011a extends Lambda implements Function4<JumioController, ArrayList<JumioCredentialInfo>, JumioCredential, JumioScanPart, Unit> {

        /* renamed from: a */
        public final /* synthetic */ C0010a f13a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0011a(C0010a aVar) {
            super(4);
            this.f13a = aVar;
        }

        /* renamed from: a */
        public final void mo70a(JumioController jumioController, ArrayList<JumioCredentialInfo> arrayList, JumioCredential jumioCredential, JumioScanPart jumioScanPart) {
            Intrinsics.checkNotNullParameter(jumioController, "controller");
            Intrinsics.checkNotNullParameter(arrayList, "credentials");
            this.f13a.mo21a(jumioController);
            this.f13a.mo29a(arrayList);
            this.f13a.mo22a(jumioCredential);
            this.f13a.mo26a(jumioScanPart);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            mo70a((JumioController) obj, (ArrayList) obj2, (JumioCredential) obj3, (JumioScanPart) obj4);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: a.a$b */
    /* compiled from: JumioViewModel.kt */
    public static final class C0012b {
        public C0012b() {
        }

        public /* synthetic */ C0012b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a.a$c */
    /* compiled from: JumioViewModel.kt */
    public enum C0013c {
        START,
        LOADING,
        SELECTION_DOCUMENT,
        SELECTION_COUNTRY,
        SCAN,
        NFC,
        CONFIRMATION,
        REJECT,
        UPLOAD
    }

    /* renamed from: a.a$d */
    /* compiled from: JumioViewModel.kt */
    public /* synthetic */ class C0014d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f24a;

        static {
            int[] iArr = new int[JumioScanStep.values().length];
            iArr[JumioScanStep.CAN_FINISH.ordinal()] = 1;
            f24a = iArr;
        }
    }

    /* renamed from: a.a$e */
    /* compiled from: JumioViewModel.kt */
    public static final class C0015e extends Lambda implements Function0<JumioSDK> {

        /* renamed from: a */
        public final /* synthetic */ C0010a f25a;

        /* renamed from: b */
        public final /* synthetic */ Application f26b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0015e(C0010a aVar, Application application) {
            super(0);
            this.f25a = aVar;
            this.f26b = application;
        }

        /* renamed from: a */
        public final JumioSDK invoke() {
            C0010a aVar = this.f25a;
            Context applicationContext = this.f26b.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
            return aVar.mo17a(applicationContext);
        }
    }

    /* renamed from: a.a$f */
    /* compiled from: JumioViewModel.kt */
    public static final class C0016f extends Lambda implements Function1<JumioScanSide, CharSequence> {

        /* renamed from: a */
        public static final C0016f f27a = new C0016f();

        public C0016f() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(JumioScanSide jumioScanSide) {
            Intrinsics.checkNotNullParameter(jumioScanSide, "it");
            return jumioScanSide.name();
        }
    }

    static {
        new C0012b((DefaultConstructorMarker) null);
    }

    /* JADX WARNING: type inference failed for: r10v19, types: [java.io.Serializable] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0010a(androidx.lifecycle.SavedStateHandle r10, android.app.Application r11, java.lang.String r12, com.jumio.sdk.enums.JumioDataCenter r13, int r14) {
        /*
            r9 = this;
            java.lang.String r0 = "savedStateHandle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "application"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "token"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "datacenter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r9.<init>(r11)
            r9.f1a = r10
            a.a$e r0 = new a.a$e
            r0.<init>(r9, r11)
            kotlin.Lazy r0 = kotlin.LazyKt.lazy(r0)
            r9.f2b = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.f4d = r0
            a.c r0 = new a.c
            r0.<init>()
            r9.f7g = r0
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r9.f8h = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r9.f9i = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r9.f10j = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r9.f11k = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r9.f12l = r1
            java.lang.String r1 = "jumioSDK"
            java.lang.Object r2 = r10.get(r1)
            android.os.Bundle r2 = (android.os.Bundle) r2
            a.-$$Lambda$6ZZIAtceNzWa5tqlISctbYJmDrA r3 = new a.-$$Lambda$6ZZIAtceNzWa5tqlISctbYJmDrA
            r3.<init>()
            r10.setSavedStateProvider(r1, r3)
            com.jumio.sdk.JumioSDK r10 = r9.mo61r()
            if (r14 == 0) goto L_0x006e
            r10.setCustomThemeId(r14)
        L_0x006e:
            r10.setToken(r12)
            r10.setDataCenter(r13)
            if (r2 != 0) goto L_0x0087
            com.jumio.sdk.JumioSDK r10 = r9.mo61r()
            com.jumio.sdk.controller.JumioController r10 = r10.start(r11, r9)
            r9.f3c = r10
            a.a$c r10 = p001a.C0010a.C0013c.LOADING
            r0.setValue(r10)
            goto L_0x0156
        L_0x0087:
            com.jumio.sdk.JumioSDK r3 = r9.mo61r()
            android.app.Application r4 = r9.getApplication()
            java.lang.String r10 = "getApplication()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            a.a$a r8 = new a.a$a
            r8.<init>(r9)
            r5 = r2
            r6 = r9
            r7 = r9
            r3.restore(r4, r5, r6, r7, r8)
            java.lang.String r10 = "sdkStateEvent"
            java.io.Serializable r10 = r2.getSerializable(r10)
            boolean r11 = r10 instanceof p001a.C0010a.C0013c
            r12 = 0
            if (r11 == 0) goto L_0x00ad
            a.a$c r10 = (p001a.C0010a.C0013c) r10
            goto L_0x00ae
        L_0x00ad:
            r10 = r12
        L_0x00ae:
            if (r10 != 0) goto L_0x00b1
            goto L_0x00b8
        L_0x00b1:
            a.c r11 = r9.mo3A()
            r11.setValue(r10)
        L_0x00b8:
            java.lang.String r10 = "scanStepEvent"
            java.io.Serializable r10 = r2.getSerializable(r10)
            boolean r11 = r10 instanceof com.jumio.sdk.enums.JumioScanStep
            if (r11 == 0) goto L_0x00c5
            com.jumio.sdk.enums.JumioScanStep r10 = (com.jumio.sdk.enums.JumioScanStep) r10
            goto L_0x00c6
        L_0x00c5:
            r10 = r12
        L_0x00c6:
            if (r10 != 0) goto L_0x00c9
            goto L_0x00d0
        L_0x00c9:
            androidx.lifecycle.MutableLiveData r11 = r9.mo67x()
            r11.setValue(r10)
        L_0x00d0:
            java.lang.String r10 = "scanUpdateEvent"
            java.io.Serializable r10 = r2.getSerializable(r10)
            boolean r11 = r10 instanceof kotlin.Pair
            if (r11 == 0) goto L_0x00dd
            kotlin.Pair r10 = (kotlin.Pair) r10
            goto L_0x00de
        L_0x00dd:
            r10 = r12
        L_0x00de:
            if (r10 != 0) goto L_0x00e1
            goto L_0x0107
        L_0x00e1:
            java.lang.Object r11 = r10.getFirst()
            boolean r13 = r11 instanceof com.jumio.sdk.enums.JumioScanUpdate
            if (r13 == 0) goto L_0x00ec
            com.jumio.sdk.enums.JumioScanUpdate r11 = (com.jumio.sdk.enums.JumioScanUpdate) r11
            goto L_0x00ed
        L_0x00ec:
            r11 = r12
        L_0x00ed:
            if (r11 != 0) goto L_0x00f0
            goto L_0x0107
        L_0x00f0:
            androidx.lifecycle.MutableLiveData r13 = r9.mo68y()
            java.lang.Object r10 = r10.getSecond()
            boolean r14 = r10 instanceof com.jumio.sdk.enums.JumioScanSide
            if (r14 == 0) goto L_0x00ff
            com.jumio.sdk.enums.JumioScanSide r10 = (com.jumio.sdk.enums.JumioScanSide) r10
            goto L_0x0100
        L_0x00ff:
            r10 = r12
        L_0x0100:
            kotlin.Pair r10 = kotlin.TuplesKt.m42317to(r11, r10)
            r13.setValue(r10)
        L_0x0107:
            java.lang.String r10 = "helpViewVisible"
            java.io.Serializable r10 = r2.getSerializable(r10)
            boolean r11 = r10 instanceof java.lang.Boolean
            if (r11 == 0) goto L_0x0114
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L_0x0115
        L_0x0114:
            r10 = r12
        L_0x0115:
            if (r10 != 0) goto L_0x0118
            goto L_0x0127
        L_0x0118:
            boolean r10 = r10.booleanValue()
            androidx.lifecycle.MutableLiveData r11 = r9.mo59p()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r11.setValue(r10)
        L_0x0127:
            java.lang.String r10 = "sdkResult"
            java.io.Serializable r10 = r2.getSerializable(r10)
            boolean r11 = r10 instanceof com.jumio.sdk.result.JumioResult
            if (r11 == 0) goto L_0x0134
            com.jumio.sdk.result.JumioResult r10 = (com.jumio.sdk.result.JumioResult) r10
            goto L_0x0135
        L_0x0134:
            r10 = r12
        L_0x0135:
            if (r10 != 0) goto L_0x0138
            goto L_0x013f
        L_0x0138:
            androidx.lifecycle.MutableLiveData r11 = r9.mo69z()
            r11.setValue(r10)
        L_0x013f:
            java.lang.String r10 = "error"
            java.io.Serializable r10 = r2.getSerializable(r10)
            boolean r11 = r10 instanceof com.jumio.sdk.error.JumioError
            if (r11 == 0) goto L_0x014c
            r12 = r10
            com.jumio.sdk.error.JumioError r12 = (com.jumio.sdk.error.JumioError) r12
        L_0x014c:
            if (r12 != 0) goto L_0x014f
            goto L_0x0156
        L_0x014f:
            androidx.lifecycle.MutableLiveData r10 = r9.mo52o()
            r10.setValue(r12)
        L_0x0156:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a.C0010a.<init>(androidx.lifecycle.SavedStateHandle, android.app.Application, java.lang.String, com.jumio.sdk.enums.JumioDataCenter, int):void");
    }

    /* renamed from: A */
    public final C0020c<C0013c> mo3A() {
        return this.f7g;
    }

    /* renamed from: B */
    public final int mo4B() {
        Integer num = (Integer) this.f1a.get("shutterButtonVisibility");
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }

    /* renamed from: C */
    public final void mo5C() {
        ErrorCase errorCase = ErrorCase.NO_CAMERA_CONNECTION;
        boolean retry = errorCase.getRetry();
        String domain = errorCase.getDomain();
        String string = getApplication().getString(errorCase.getMessage());
        Intrinsics.checkNotNullExpressionValue(string, "getApplication<Applicati…ring(cameraError.message)");
        onError(new JumioError(retry, domain, "H00000", string));
    }

    /* renamed from: D */
    public final void mo6D() {
        this.f7g.setValue(C0013c.SCAN);
    }

    /* renamed from: E */
    public final void mo7E() {
        Log.m39464i("SdkState: ViewModel set SELECTION_DOCUMENT");
        this.f7g.setValue(C0013c.SELECTION_DOCUMENT);
    }

    /* renamed from: F */
    public final void mo8F() {
        Log.m39464i("SdkState: ViewModel set START");
        this.f7g.setValue(C0013c.START);
    }

    /* renamed from: G */
    public final void mo9G() {
        mo18a();
        mo36c();
    }

    /* renamed from: H */
    public final void mo10H() {
        this.f7g.setValue(C0013c.SELECTION_COUNTRY);
    }

    /* renamed from: I */
    public final void mo11I() {
        JumioCredential jumioCredential = this.f5e;
        if (!(jumioCredential instanceof JumioIDCredential)) {
            return;
        }
        if (jumioCredential == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.jumio.sdk.credentials.JumioIDCredential");
        } else if (((JumioIDCredential) jumioCredential).getSuggestedCountry() != null) {
            JumioCredential jumioCredential2 = this.f5e;
            if (jumioCredential2 != null) {
                String suggestedCountry = ((JumioIDCredential) jumioCredential2).getSuggestedCountry();
                if (suggestedCountry == null) {
                    suggestedCountry = "";
                }
                mo37c(suggestedCountry);
                this.f7g.setValue(C0013c.SELECTION_DOCUMENT);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.jumio.sdk.credentials.JumioIDCredential");
        } else {
            JumioCredential jumioCredential3 = this.f5e;
            if (jumioCredential3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.jumio.sdk.credentials.JumioIDCredential");
            } else if (((JumioIDCredential) jumioCredential3).getCountries().size() == 1) {
                JumioCredential jumioCredential4 = this.f5e;
                if (jumioCredential4 != null) {
                    mo37c((String) CollectionsKt.first(((JumioIDCredential) jumioCredential4).getCountries().keySet()));
                    this.f7g.setValue(C0013c.SELECTION_DOCUMENT);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.jumio.sdk.credentials.JumioIDCredential");
            } else {
                this.f7g.setValue(C0013c.SELECTION_COUNTRY);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getScanSides();
     */
    /* renamed from: J */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo12J() {
        /*
            r1 = this;
            com.jumio.sdk.credentials.JumioCredential r0 = r1.f5e
            if (r0 != 0) goto L_0x0005
            goto L_0x000b
        L_0x0005:
            java.util.ArrayList r0 = r0.getScanSides()
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r0 = 0
            goto L_0x0013
        L_0x000d:
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            com.jumio.sdk.enums.JumioScanSide r0 = (com.jumio.sdk.enums.JumioScanSide) r0
        L_0x0013:
            r1.mo24a((com.jumio.sdk.enums.JumioScanSide) r0)
            com.jumio.sdk.enums.JumioScanSide r0 = r1.mo49l()
            r1.mo33b((com.jumio.sdk.enums.JumioScanSide) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a.C0010a.mo12J():void");
    }

    /* renamed from: K */
    public final void mo13K() {
        mo35b(true);
        mo12J();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006b  */
    /* renamed from: L */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo14L() {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = r4.mo66w()     // Catch:{ IllegalArgumentException -> 0x0051 }
            int r2 = r2.length()     // Catch:{ IllegalArgumentException -> 0x0051 }
            if (r2 <= 0) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            if (r2 == 0) goto L_0x0019
            com.jumio.sdk.controller.JumioController r2 = r4.f3c     // Catch:{ IllegalArgumentException -> 0x0051 }
            if (r2 != 0) goto L_0x0016
            goto L_0x0019
        L_0x0016:
            r2.userConsented()     // Catch:{ IllegalArgumentException -> 0x0051 }
        L_0x0019:
            com.jumio.sdk.credentials.JumioCredential r2 = r4.f5e     // Catch:{ Exception -> 0x0022 }
            if (r2 != 0) goto L_0x001e
            goto L_0x0030
        L_0x001e:
            r2.cancel()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0030
        L_0x0022:
            r2 = move-exception
            java.lang.String r3 = f0m     // Catch:{ IllegalArgumentException -> 0x0051 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ IllegalArgumentException -> 0x0051 }
            if (r2 != 0) goto L_0x002d
            java.lang.String r2 = "credential cancel failed"
        L_0x002d:
            com.jumio.commons.log.Log.m39461e((java.lang.String) r3, (java.lang.String) r2)     // Catch:{ IllegalArgumentException -> 0x0051 }
        L_0x0030:
            java.util.ArrayList<com.jumio.sdk.credentials.JumioCredentialInfo> r2 = r4.f4d     // Catch:{ IllegalArgumentException -> 0x0051 }
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)     // Catch:{ IllegalArgumentException -> 0x0051 }
            com.jumio.sdk.credentials.JumioCredentialInfo r2 = (com.jumio.sdk.credentials.JumioCredentialInfo) r2     // Catch:{ IllegalArgumentException -> 0x0051 }
            r4.mo23a((com.jumio.sdk.credentials.JumioCredentialInfo) r2)     // Catch:{ IllegalArgumentException -> 0x0051 }
            com.jumio.sdk.credentials.JumioCredentialInfo r2 = r4.mo45h()     // Catch:{ IllegalArgumentException -> 0x0051 }
            if (r2 != 0) goto L_0x0042
            goto L_0x0048
        L_0x0042:
            com.jumio.sdk.controller.JumioController r3 = r4.mo60q()     // Catch:{ IllegalArgumentException -> 0x0051 }
            if (r3 != 0) goto L_0x004a
        L_0x0048:
            r2 = 0
            goto L_0x004e
        L_0x004a:
            com.jumio.sdk.credentials.JumioCredential r2 = r3.start(r2)     // Catch:{ IllegalArgumentException -> 0x0051 }
        L_0x004e:
            r4.f5e = r2     // Catch:{ IllegalArgumentException -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            r4.mo27a((java.lang.String) r2)
        L_0x0059:
            com.jumio.sdk.credentials.JumioCredential r2 = r4.f5e
            if (r2 != 0) goto L_0x005e
            goto L_0x0065
        L_0x005e:
            boolean r2 = r2.isConfigured()
            if (r2 != r1) goto L_0x0065
            r0 = 1
        L_0x0065:
            if (r0 == 0) goto L_0x006b
            r4.mo13K()
            goto L_0x006e
        L_0x006b:
            r4.mo15M()
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a.C0010a.mo14L():void");
    }

    /* renamed from: M */
    public final void mo15M() {
        mo35b(false);
        mo11I();
    }

    /* renamed from: N */
    public final void mo16N() {
        this.f8h.setValue(JumioScanStep.SCAN_VIEW);
    }

    /* renamed from: b */
    public final void mo34b(String str) {
        this.f1a.set("currentRejectData", str);
    }

    /* renamed from: c */
    public final void mo38c(boolean z) {
        this.f1a.set("legalHintConsumed", Boolean.valueOf(z));
    }

    /* renamed from: d */
    public final void mo40d(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f1a.set("legalText", str);
    }

    /* renamed from: e */
    public final void mo42e(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f1a.set("privacyPolicyUrl", str);
    }

    /* renamed from: f */
    public final ArrayList<JumioCredentialInfo> mo43f() {
        return this.f4d;
    }

    /* renamed from: g */
    public final JumioCredential mo44g() {
        return this.f5e;
    }

    /* renamed from: h */
    public final JumioCredentialInfo mo45h() {
        return (JumioCredentialInfo) this.f1a.get("currentCredentialInfo");
    }

    /* renamed from: i */
    public final String mo46i() {
        return (String) this.f1a.get("currentRejectData");
    }

    /* renamed from: j */
    public final JumioRetryReason mo47j() {
        return (JumioRetryReason) this.f1a.get("currentRetryData");
    }

    /* renamed from: k */
    public final JumioScanPart mo48k() {
        return this.f6f;
    }

    /* renamed from: l */
    public final JumioScanSide mo49l() {
        return (JumioScanSide) this.f1a.get("currentScanSide");
    }

    /* renamed from: m */
    public final boolean mo50m() {
        Boolean bool = (Boolean) this.f1a.get("currentSelectionSkipped");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* renamed from: n */
    public final String mo51n() {
        String str = (String) this.f1a.get("currentlySelectedCountry");
        return str == null ? "" : str;
    }

    /* renamed from: o */
    public final MutableLiveData<JumioError> mo52o() {
        return this.f12l;
    }

    public void onCleared() {
        JumioController jumioController;
        super.onCleared();
        mo27a("onCleared");
        JumioController jumioController2 = this.f3c;
        if ((jumioController2 != null && !jumioController2.isComplete()) && (jumioController = this.f3c) != null) {
            jumioController.stop();
        }
    }

    public void onError(JumioError jumioError) {
        Intrinsics.checkNotNullParameter(jumioError, "error");
        mo27a("onError: " + jumioError.getCode() + jumioError.getMessage());
        this.f12l.setValue(jumioError);
    }

    public void onFinished(JumioResult jumioResult) {
        Intrinsics.checkNotNullParameter(jumioResult, "result");
        mo27a("onFinished");
        this.f11k.setValue(jumioResult);
    }

    public void onInitialized(ArrayList<JumioCredentialInfo> arrayList, String str) {
        Intrinsics.checkNotNullParameter(arrayList, "credentials");
        this.f4d = arrayList;
        if (str != null) {
            mo42e(str);
        }
        Log.m39466i(f0m, Intrinsics.stringPlus("onInitialized: credentials received , size: ", Integer.valueOf(arrayList.size())));
        Log.m39464i("SdkState: ViewModel set START");
        this.f7g.setValue(C0013c.START);
    }

    public void onScanStep(JumioScanStep jumioScanStep, Object obj) {
        Intrinsics.checkNotNullParameter(jumioScanStep, "jumioScanStep");
        mo27a(Intrinsics.stringPlus("onScanStep: ", jumioScanStep.name()));
        if (obj instanceof JumioRetryReason) {
            JumioRetryReason jumioRetryReason = (JumioRetryReason) obj;
            mo27a(Intrinsics.stringPlus("retry reason: ", Integer.valueOf(jumioRetryReason.getCode())));
            mo27a(Intrinsics.stringPlus("retry message: ", jumioRetryReason.getMessage()));
            mo25a(jumioRetryReason);
        }
        if (obj instanceof String) {
            mo27a(Intrinsics.stringPlus("reject reason: ", obj));
            mo34b((String) obj);
        }
        this.f8h.setValue(jumioScanStep);
        if (this.f7g.getValue() == C0013c.SCAN) {
            if (jumioScanStep == JumioScanStep.CONFIRMATION_VIEW) {
                this.f7g.setValue(C0013c.CONFIRMATION);
            } else if (jumioScanStep == JumioScanStep.REJECT_VIEW) {
                this.f7g.setValue(C0013c.REJECT);
            }
        }
        if (C0014d.f24a[jumioScanStep.ordinal()] == 1) {
            mo41e();
        }
    }

    public void onUpdate(JumioScanUpdate jumioScanUpdate, Object obj) {
        Intrinsics.checkNotNullParameter(jumioScanUpdate, "jumioScanUpdate");
        mo27a(Intrinsics.stringPlus("onJumioUpdateType: ", jumioScanUpdate.name()));
        if (jumioScanUpdate == JumioScanUpdate.NFC_EXTRACTION_PROGRESS && (obj instanceof Integer)) {
            mo19a(((Number) obj).intValue());
        } else if (jumioScanUpdate == JumioScanUpdate.LEGAL_HINT && (obj instanceof String)) {
            mo40d((String) obj);
        }
        this.f9i.setValue(TuplesKt.m42317to(jumioScanUpdate, mo49l()));
    }

    /* renamed from: p */
    public final MutableLiveData<Boolean> mo59p() {
        return this.f10j;
    }

    /* renamed from: q */
    public final JumioController mo60q() {
        return this.f3c;
    }

    /* renamed from: r */
    public final JumioSDK mo61r() {
        return (JumioSDK) this.f2b.getValue();
    }

    /* renamed from: s */
    public final boolean mo62s() {
        Boolean bool = (Boolean) this.f1a.get("legalHintConsumed");
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* renamed from: t */
    public final String mo63t() {
        String str = (String) this.f1a.get("legalText");
        return str == null ? "" : str;
    }

    /* renamed from: u */
    public final LoadingView.State mo64u() {
        LoadingView.State state = (LoadingView.State) this.f1a.get("loadingViewState");
        return state == null ? new LoadingView.State(LoadingView.ViewState.STOPPED, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null) : state;
    }

    /* renamed from: v */
    public final int mo65v() {
        Integer num = (Integer) this.f1a.get("nfcProgressPercentage");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: w */
    public final String mo66w() {
        String str = (String) this.f1a.get("privacyPolicyUrl");
        return str == null ? "" : str;
    }

    /* renamed from: x */
    public final MutableLiveData<JumioScanStep> mo67x() {
        return this.f8h;
    }

    /* renamed from: y */
    public final MutableLiveData<Pair<JumioScanUpdate, JumioScanSide>> mo68y() {
        return this.f9i;
    }

    /* renamed from: z */
    public final MutableLiveData<JumioResult> mo69z() {
        return this.f11k;
    }

    /* renamed from: a */
    public final void mo21a(JumioController jumioController) {
        this.f3c = jumioController;
    }

    /* renamed from: b */
    public final void mo35b(boolean z) {
        this.f1a.set("currentSelectionSkipped", Boolean.valueOf(z));
    }

    /* renamed from: c */
    public final void mo37c(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f1a.set("currentlySelectedCountry", str);
    }

    /* renamed from: d */
    public final void mo39d() {
        JumioScanPart jumioScanPart = this.f6f;
        if (jumioScanPart != null) {
            jumioScanPart.finish();
        }
        this.f6f = null;
    }

    /* renamed from: e */
    public final void mo41e() {
        mo39d();
        JumioCredential jumioCredential = this.f5e;
        JumioScanPart addonPart = jumioCredential == null ? null : jumioCredential.getAddonPart();
        this.f6f = addonPart;
        if (addonPart != null) {
            this.f7g.setValue(C0013c.NFC);
        } else {
            mo36c();
        }
    }

    /* renamed from: a */
    public final void mo29a(ArrayList<JumioCredentialInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f4d = arrayList;
    }

    /* renamed from: b */
    public final void mo32b(int i) {
        this.f1a.set("shutterButtonVisibility", Integer.valueOf(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.getScanSides();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo36c() {
        /*
            r4 = this;
            com.jumio.sdk.enums.JumioScanSide r0 = r4.mo49l()
            com.jumio.sdk.credentials.JumioCredential r1 = r4.f5e
            r2 = 0
            if (r1 != 0) goto L_0x000a
            goto L_0x0010
        L_0x000a:
            java.util.ArrayList r1 = r1.getScanSides()
            if (r1 != 0) goto L_0x0012
        L_0x0010:
            r1 = r2
            goto L_0x0018
        L_0x0012:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r1)
            com.jumio.sdk.enums.JumioScanSide r1 = (com.jumio.sdk.enums.JumioScanSide) r1
        L_0x0018:
            r3 = 1
            if (r0 != r1) goto L_0x0038
            com.jumio.sdk.credentials.JumioCredential r0 = r4.f5e
            if (r0 != 0) goto L_0x0020
            goto L_0x0028
        L_0x0020:
            boolean r0 = r0.isComplete()
            if (r0 != r3) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0038
            com.jumio.sdk.credentials.JumioCredential r0 = r4.f5e
            if (r0 != 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            r0.finish()
        L_0x0033:
            r4.mo31b()
            goto L_0x009c
        L_0x0038:
            com.jumio.sdk.credentials.JumioCredential r0 = r4.f5e
            if (r0 != 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            java.util.ArrayList r0 = r0.getScanSides()
            if (r0 != 0) goto L_0x0045
        L_0x0043:
            r0 = r2
            goto L_0x0052
        L_0x0045:
            com.jumio.sdk.enums.JumioScanSide r1 = r4.mo49l()
            int r0 = kotlin.collections.CollectionsKt.indexOf(r0, r1)
            int r0 = r0 + r3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0052:
            if (r0 == 0) goto L_0x009c
            com.jumio.sdk.credentials.JumioCredential r1 = r4.f5e
            if (r1 != 0) goto L_0x005a
            r1 = r2
            goto L_0x005e
        L_0x005a:
            java.util.ArrayList r1 = r1.getScanSides()
        L_0x005e:
            if (r1 == 0) goto L_0x009c
            com.jumio.sdk.credentials.JumioCredential r1 = r4.f5e
            if (r1 != 0) goto L_0x0065
            goto L_0x006b
        L_0x0065:
            java.util.ArrayList r1 = r1.getScanSides()
            if (r1 != 0) goto L_0x006d
        L_0x006b:
            r1 = r2
            goto L_0x0075
        L_0x006d:
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0075:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.intValue()
            int r3 = r0.intValue()
            if (r1 <= r3) goto L_0x009c
            com.jumio.sdk.credentials.JumioCredential r1 = r4.f5e
            if (r1 != 0) goto L_0x0087
            goto L_0x0099
        L_0x0087:
            java.util.ArrayList r1 = r1.getScanSides()
            if (r1 != 0) goto L_0x008e
            goto L_0x0099
        L_0x008e:
            int r0 = r0.intValue()
            java.lang.Object r0 = r1.get(r0)
            r2 = r0
            com.jumio.sdk.enums.JumioScanSide r2 = (com.jumio.sdk.enums.JumioScanSide) r2
        L_0x0099:
            r4.mo33b((com.jumio.sdk.enums.JumioScanSide) r2)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a.C0010a.mo36c():void");
    }

    /* renamed from: a */
    public final void mo22a(JumioCredential jumioCredential) {
        this.f5e = jumioCredential;
    }

    /* renamed from: b */
    public final void mo33b(JumioScanSide jumioScanSide) {
        JumioScanPart jumioScanPart;
        if (jumioScanSide != null) {
            mo24a(jumioScanSide);
            mo38c(false);
            mo18a();
            JumioCredential jumioCredential = this.f5e;
            JumioScanMode jumioScanMode = null;
            this.f6f = jumioCredential == null ? null : jumioCredential.initScanPart(jumioScanSide, this);
            this.f7g.setValue(C0013c.SCAN);
            JumioScanPart jumioScanPart2 = this.f6f;
            if (jumioScanPart2 != null) {
                jumioScanMode = jumioScanPart2.getScanMode();
            }
            if (jumioScanMode != JumioScanMode.FACE_IPROOV && (jumioScanPart = this.f6f) != null) {
                jumioScanPart.start();
            }
        }
    }

    /* renamed from: a */
    public final void mo26a(JumioScanPart jumioScanPart) {
        this.f6f = jumioScanPart;
    }

    /* renamed from: a */
    public final void mo23a(JumioCredentialInfo jumioCredentialInfo) {
        this.f1a.set("currentCredentialInfo", jumioCredentialInfo);
    }

    /* renamed from: a */
    public final void mo24a(JumioScanSide jumioScanSide) {
        this.f1a.set("currentScanSide", jumioScanSide);
    }

    /* renamed from: a */
    public final void mo19a(int i) {
        this.f1a.set("nfcProgressPercentage", Integer.valueOf(i));
    }

    /* renamed from: a */
    public final void mo25a(JumioRetryReason jumioRetryReason) {
        this.f1a.set("currentRetryData", jumioRetryReason);
    }

    /* renamed from: a */
    public final void mo20a(LoadingView.State state) {
        Intrinsics.checkNotNullParameter(state, "value");
        this.f1a.set("loadingViewState", state);
    }

    /* renamed from: a */
    public static final Bundle m0a(C0010a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Bundle bundle = new Bundle();
        JumioController q = aVar.mo60q();
        if (q != null) {
            q.persist(bundle);
        }
        bundle.putSerializable("sdkStateEvent", aVar.mo3A().getValue());
        bundle.putSerializable("scanStepEvent", aVar.mo67x().getValue());
        bundle.putSerializable("scanUpdateEvent", aVar.mo68y().getValue());
        Boolean value = aVar.mo59p().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        bundle.putBoolean("helpViewVisible", value.booleanValue());
        bundle.putSerializable("sdkResult", aVar.mo69z().getValue());
        bundle.putSerializable("error", aVar.mo52o().getValue());
        return bundle;
    }

    /* renamed from: b */
    public final void mo31b() {
        JumioController q;
        JumioCredentialInfo h = mo45h();
        JumioCredential jumioCredential = null;
        if (Intrinsics.areEqual((Object) h == null ? null : h.getId(), (Object) ((JumioCredentialInfo) CollectionsKt.last(this.f4d)).getId())) {
            this.f5e = null;
            this.f7g.setValue(C0013c.UPLOAD);
            JumioController jumioController = this.f3c;
            if (jumioController != null) {
                jumioController.finish();
                return;
            }
            return;
        }
        Iterator<JumioCredentialInfo> it = this.f4d.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            String id = it.next().getId();
            JumioCredentialInfo h2 = mo45h();
            if (Intrinsics.areEqual((Object) id, (Object) h2 == null ? null : h2.getId())) {
                break;
            }
            i++;
        }
        mo23a(this.f4d.get(i + 1));
        JumioCredentialInfo h3 = mo45h();
        if (!(h3 == null || (q = mo60q()) == null)) {
            jumioCredential = q.start(h3);
        }
        this.f5e = jumioCredential;
        if (jumioCredential != null && jumioCredential.isConfigured()) {
            z = true;
        }
        if (z) {
            mo12J();
        } else {
            mo11I();
        }
    }

    /* renamed from: a */
    public final JumioSDK mo17a(Context context) {
        return new JumioSDK(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
        r0 = r11.getScanSides();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo28a(java.lang.String r10, com.jumio.sdk.document.JumioDocument r11) {
        /*
            r9 = this;
            java.lang.String r0 = "country"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.jumio.sdk.credentials.JumioCredential r0 = r9.f5e
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioIDCredential
            if (r1 == 0) goto L_0x004a
            if (r11 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x0042
            com.jumio.sdk.credentials.JumioIDCredential r0 = (com.jumio.sdk.credentials.JumioIDCredential) r0
            r0.setConfiguration(r10, r11)
            r10 = 0
            r9.mo38c((boolean) r10)
            java.lang.String r10 = f0m
            com.jumio.sdk.credentials.JumioCredential r11 = r9.f5e
            if (r11 != 0) goto L_0x001f
            goto L_0x0025
        L_0x001f:
            java.util.ArrayList r0 = r11.getScanSides()
            if (r0 != 0) goto L_0x0027
        L_0x0025:
            r11 = 0
            goto L_0x0035
        L_0x0027:
            a.a$f r6 = p001a.C0010a.C0016f.f27a
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 31
            r8 = 0
            java.lang.String r11 = kotlin.collections.CollectionsKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0035:
            java.lang.String r0 = "Credential sides "
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r11)
            com.jumio.commons.log.Log.m39456d((java.lang.String) r10, (java.lang.String) r11)
            r9.mo12J()
            goto L_0x004a
        L_0x0042:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r11 = "null cannot be cast to non-null type com.jumio.sdk.credentials.JumioIDCredential"
            r10.<init>(r11)
            throw r10
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a.C0010a.mo28a(java.lang.String, com.jumio.sdk.document.JumioDocument):void");
    }

    /* renamed from: a */
    public final void mo30a(boolean z) {
        this.f10j.setValue(Boolean.valueOf(z));
    }

    /* renamed from: a */
    public final void mo18a() {
        try {
            JumioScanPart jumioScanPart = this.f6f;
            if (jumioScanPart != null) {
                jumioScanPart.cancel();
            }
            this.f6f = null;
            mo25a((JumioRetryReason) null);
            mo34b((String) null);
        } catch (SDKNotConfiguredException unused) {
        }
    }

    /* renamed from: a */
    public final void mo27a(String str) {
        Log.m39466i(f0m, Intrinsics.stringPlus("Received : ", str));
    }
}
