package com.jumio.defaultui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.AnimBuilder;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.fragment.NavHostFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.util.DeviceUtil;
import com.jumio.core.util.ReflectionUtil;
import com.jumio.defaultui.view.JumioFragmentCallback;
import com.jumio.defaultui.view.LoadingView;
import com.jumio.sdk.JumioSDK;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.enums.JumioDataCenter;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.result.JumioResult;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p001a.C0010a;
import rui.config.RConfigConstants;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003gfhB\u0007¢\u0006\u0004\bd\u0010eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J.\u0010\u0017\u001a\u00020\u0004*\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u001a\u001a\u00020\u0004H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\b\u0010\u001c\u001a\u00020\u0004H\u0014J\f\u0010\u001f\u001a\u00060\u001dR\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0013H\u0014J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H\u0016J\u0012\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0016J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\rH\u0016J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010>\u001a\u000202H\u0016J-\u0010D\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00112\f\u0010A\u001a\b\u0012\u0004\u0012\u00020.0@2\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010TR\u0016\u0010U\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00108\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\\\u0010]R\u001d\u0010c\u001a\u00020^8B@\u0002X\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b¨\u0006i"}, mo175978d2 = {"Lcom/jumio/defaultui/JumioActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/jumio/defaultui/view/JumioFragmentCallback;", "", "shutdown", "initObservers", "Lcom/jumio/sdk/error/JumioError;", "error", "showError", "Lcom/jumio/sdk/result/JumioResult;", "jumioResult", "finishActivity", "Landroid/content/Context;", "context", "installSplitContext", "Landroidx/navigation/NavController;", "", "resId", "Landroid/os/Bundle;", "args", "Landroidx/navigation/NavOptions;", "navOptions", "navigateIfRequired", "savedInstanceState", "onCreate", "onResume", "onPause", "onDestroy", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getTheme", "outState", "onSaveInstanceState", "onBackPressed", "skipAddonPart", "announceAccessibilityFragmentTitle", "Lcom/jumio/commons/utils/DeviceRotationManager;", "getRotationManager", "color", "setBackgroundColor", "resourceId", "setActionBarQuitIcon", "Lcom/jumio/defaultui/view/LoadingView$State;", "loadingState", "updateLoadingState", "", "automationString", "setUiAutomationString", "hideLoading", "", "isRunningTest", "startUserJourney", "startCountrySelection", "countrySelected", "retakeImage", "Landroid/view/View;", "v", "onClick", "base", "attachBaseContext", "onRestoreInstanceState", "validatePermissions", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "", "finishLock", "Ljava/lang/Object;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rotationManager", "Lcom/jumio/commons/utils/DeviceRotationManager;", "Landroid/widget/ImageButton;", "btnQuit", "Landroid/widget/ImageButton;", "Lcom/jumio/defaultui/view/LoadingView;", "loadingView", "Lcom/jumio/defaultui/view/LoadingView;", "Lcom/jumio/sdk/error/JumioError;", "token", "Ljava/lang/String;", "Lcom/jumio/sdk/enums/JumioDataCenter;", "datacenter", "Lcom/jumio/sdk/enums/JumioDataCenter;", "customThemeId", "I", "navController", "Landroidx/navigation/NavController;", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "<init>", "()V", "Companion", "a", "b", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioActivity.kt */
public final class JumioActivity extends AppCompatActivity implements View.OnClickListener, JumioFragmentCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_CUSTOM_THEME = "com.jumio.defaultui.JumioActivity.EXTRA_CUSTOM_THEME";
    public static final String EXTRA_DATACENTER = "com.jumio.defaultui.JumioActivity.EXTRA_DATACENTER";
    public static final String EXTRA_RESULT = "com.jumio.defaultui.JumioActivity.EXTRA_RESULT";
    public static final String EXTRA_TOKEN = "com.jumio.defaultui.JumioActivity.EXTRA_TOKEN";
    public static final int PERMISSION_REQUEST_CODE = 100;
    private static final String TAG = JumioActivity.class.getSimpleName();
    private ImageButton btnQuit;
    /* access modifiers changed from: private */
    public int customThemeId;
    /* access modifiers changed from: private */
    public JumioDataCenter datacenter = JumioDataCenter.US;
    /* access modifiers changed from: private */
    public JumioError error;
    private final Object finishLock = new Object();
    private final Lazy jumioViewModel$delegate = new ViewModelLazy(C21490Reflection.getOrCreateKotlinClass(C0010a.class), new C20051o(this), new C20050n(this));
    /* access modifiers changed from: private */
    public LoadingView loadingView;
    private NavController navController;
    private ConstraintLayout rootContainer;
    private DeviceRotationManager rotationManager;
    /* access modifiers changed from: private */
    public String token = "";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u000f"}, mo175978d2 = {"Lcom/jumio/defaultui/JumioActivity$Companion;", "", "", "EXTRA_CUSTOM_THEME", "Ljava/lang/String;", "EXTRA_DATACENTER", "EXTRA_RESULT", "EXTRA_TOKEN", "", "PERMISSION_REQUEST_CODE", "I", "kotlin.jvm.PlatformType", "TAG", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$a */
    /* compiled from: JumioActivity.kt */
    public final class C20027a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ JumioActivity f55006a;

        public C20027a(JumioActivity jumioActivity, JumioError jumioError) {
            Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
            this.f55006a = jumioActivity;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
            this.f55006a.shutdown();
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$b */
    /* compiled from: JumioActivity.kt */
    public final class C20028b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ JumioActivity f55007a;

        /* renamed from: com.jumio.defaultui.JumioActivity$b$a */
        /* compiled from: JumioActivity.kt */
        public /* synthetic */ class C20029a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f55008a;

            static {
                int[] iArr = new int[C0010a.C0013c.values().length];
                iArr[C0010a.C0013c.NFC.ordinal()] = 1;
                iArr[C0010a.C0013c.LOADING.ordinal()] = 2;
                iArr[C0010a.C0013c.SCAN.ordinal()] = 3;
                iArr[C0010a.C0013c.UPLOAD.ordinal()] = 4;
                f55008a = iArr;
            }
        }

        public C20028b(JumioActivity jumioActivity) {
            Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
            this.f55007a = jumioActivity;
        }

        public void onClick(View view) {
            JumioController q;
            AutoTrackHelper.trackViewOnClick(view);
            Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
            C0010a.C0013c value = this.f55007a.getJumioViewModel().mo3A().getValue();
            int i = value == null ? -1 : C20029a.f55008a[value.ordinal()];
            if (i == 1) {
                LoadingView access$getLoadingView$p = this.f55007a.loadingView;
                if (access$getLoadingView$p != null) {
                    access$getLoadingView$p.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null));
                }
            } else if (i == 2 || i == 3) {
                LoadingView access$getLoadingView$p2 = this.f55007a.loadingView;
                if (access$getLoadingView$p2 != null) {
                    access$getLoadingView$p2.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, R.string.jumio_loading_title, (String) null, 0, (View.OnClickListener) null, 28, (DefaultConstructorMarker) null));
                }
            } else if (i != 4) {
                LoadingView access$getLoadingView$p3 = this.f55007a.loadingView;
                if (access$getLoadingView$p3 != null) {
                    LoadingView.hide$default(access$getLoadingView$p3, (AnimatorListenerAdapter) null, 0, 0, 7, (Object) null);
                }
            } else {
                LoadingView access$getLoadingView$p4 = this.f55007a.loadingView;
                if (access$getLoadingView$p4 != null) {
                    access$getLoadingView$p4.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, R.string.jumio_uploading_title, (String) null, 0, (View.OnClickListener) null, 28, (DefaultConstructorMarker) null));
                }
            }
            JumioError access$getError$p = this.f55007a.error;
            if (access$getError$p != null && (q = this.f55007a.getJumioViewModel().mo60q()) != null) {
                q.retry(access$getError$p);
            }
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$c */
    /* compiled from: JumioActivity.kt */
    public /* synthetic */ class C20030c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f55009a;

        static {
            int[] iArr = new int[C0010a.C0013c.values().length];
            iArr[C0010a.C0013c.LOADING.ordinal()] = 1;
            iArr[C0010a.C0013c.START.ordinal()] = 2;
            iArr[C0010a.C0013c.SCAN.ordinal()] = 3;
            iArr[C0010a.C0013c.NFC.ordinal()] = 4;
            iArr[C0010a.C0013c.SELECTION_DOCUMENT.ordinal()] = 5;
            iArr[C0010a.C0013c.CONFIRMATION.ordinal()] = 6;
            iArr[C0010a.C0013c.REJECT.ordinal()] = 7;
            iArr[C0010a.C0013c.SELECTION_COUNTRY.ordinal()] = 8;
            iArr[C0010a.C0013c.UPLOAD.ordinal()] = 9;
            f55009a = iArr;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$d */
    /* compiled from: JumioActivity.kt */
    public static final class C20031d extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20031d f55010a = new C20031d();

        /* renamed from: com.jumio.defaultui.JumioActivity$d$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20032a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20032a f55011a = new C20032a();

            public C20032a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163232a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163232a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20031d() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163231a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.setPopUpTo(R.id.startFragment);
            navOptionsBuilder.anim(C20032a.f55011a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163231a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$e */
    /* compiled from: JumioActivity.kt */
    public static final class C20033e extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20033e f55012a = new C20033e();

        /* renamed from: com.jumio.defaultui.JumioActivity$e$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20034a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20034a f55013a = new C20034a();

            public C20034a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163234a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163234a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20033e() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163233a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.anim(C20034a.f55013a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163233a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$f */
    /* compiled from: JumioActivity.kt */
    public static final class C20035f extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20035f f55014a = new C20035f();

        /* renamed from: com.jumio.defaultui.JumioActivity$f$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20036a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20036a f55015a = new C20036a();

            public C20036a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163236a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163236a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20035f() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163235a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.setPopUpTo(R.id.documentSelectionFragment);
            navOptionsBuilder.anim(C20036a.f55015a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163235a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$g */
    /* compiled from: JumioActivity.kt */
    public static final class C20037g extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20037g f55016a = new C20037g();

        /* renamed from: com.jumio.defaultui.JumioActivity$g$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20038a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20038a f55017a = new C20038a();

            public C20038a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163238a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setExit(R.animator.jumio_slide_out);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163238a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20037g() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163237a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.setPopUpTo(R.id.documentSelectionFragment);
            navOptionsBuilder.anim(C20038a.f55017a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163237a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$h */
    /* compiled from: JumioActivity.kt */
    public static final class C20039h extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20039h f55018a = new C20039h();

        /* renamed from: com.jumio.defaultui.JumioActivity$h$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20040a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20040a f55019a = new C20040a();

            public C20040a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163240a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163240a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20039h() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163239a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.anim(C20040a.f55019a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163239a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$i */
    /* compiled from: JumioActivity.kt */
    public static final class C20041i extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20041i f55020a = new C20041i();

        /* renamed from: com.jumio.defaultui.JumioActivity$i$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20042a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20042a f55021a = new C20042a();

            public C20042a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163242a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163242a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20041i() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163241a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.anim(C20042a.f55021a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163241a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$j */
    /* compiled from: JumioActivity.kt */
    public static final class C20043j extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20043j f55022a = new C20043j();

        /* renamed from: com.jumio.defaultui.JumioActivity$j$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20044a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20044a f55023a = new C20044a();

            public C20044a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163244a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163244a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20043j() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163243a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.anim(C20044a.f55023a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163243a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$k */
    /* compiled from: JumioActivity.kt */
    public static final class C20045k extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20045k f55024a = new C20045k();

        /* renamed from: com.jumio.defaultui.JumioActivity$k$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20046a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20046a f55025a = new C20046a();

            public C20046a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163246a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163246a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20045k() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163245a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.anim(C20046a.f55025a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163245a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$l */
    /* compiled from: JumioActivity.kt */
    public static final class C20047l extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ JumioActivity f55026a;

        public C20047l(JumioActivity jumioActivity) {
            this.f55026a = jumioActivity;
        }

        public void onAnimationEnd(Animator animator) {
            LoadingView access$getLoadingView$p;
            if (this.f55026a.error == null && (access$getLoadingView$p = this.f55026a.loadingView) != null) {
                access$getLoadingView$p.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, R.string.jumio_loading_title, (String) null, 0, (View.OnClickListener) null, 28, (DefaultConstructorMarker) null));
            }
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$m */
    /* compiled from: JumioActivity.kt */
    public static final class C20048m extends Lambda implements Function1<NavOptionsBuilder, Unit> {

        /* renamed from: a */
        public static final C20048m f55027a = new C20048m();

        /* renamed from: com.jumio.defaultui.JumioActivity$m$a */
        /* compiled from: JumioActivity.kt */
        public static final class C20049a extends Lambda implements Function1<AnimBuilder, Unit> {

            /* renamed from: a */
            public static final C20049a f55028a = new C20049a();

            public C20049a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo163249a(AnimBuilder animBuilder) {
                Intrinsics.checkNotNullParameter(animBuilder, "$this$anim");
                animBuilder.setEnter(R.animator.jumio_slide_in);
                animBuilder.setPopExit(R.animator.jumio_slide_out);
            }

            public /* synthetic */ Object invoke(Object obj) {
                mo163249a((AnimBuilder) obj);
                return Unit.INSTANCE;
            }
        }

        public C20048m() {
            super(1);
        }

        /* renamed from: a */
        public final void mo163248a(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
            navOptionsBuilder.anim(C20049a.f55028a);
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163248a((NavOptionsBuilder) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$n */
    /* compiled from: JumioActivity.kt */
    public static final class C20050n extends Lambda implements Function0<ViewModelProvider.Factory> {

        /* renamed from: a */
        public final /* synthetic */ JumioActivity f55029a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20050n(JumioActivity jumioActivity) {
            super(0);
            this.f55029a = jumioActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
            r0 = r0.getString(com.jumio.defaultui.JumioActivity.EXTRA_DATACENTER);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.lifecycle.ViewModelProvider.Factory invoke() {
            /*
                r9 = this;
                com.jumio.defaultui.JumioActivity r0 = r9.f55029a
                android.content.Intent r0 = r0.getIntent()
                if (r0 == 0) goto L_0x0094
                com.jumio.defaultui.JumioActivity r0 = r9.f55029a
                android.content.Intent r0 = r0.getIntent()
                android.os.Bundle r0 = r0.getExtras()
                if (r0 == 0) goto L_0x0094
                com.jumio.defaultui.JumioActivity r0 = r9.f55029a
                android.content.Intent r0 = r0.getIntent()
                android.os.Bundle r0 = r0.getExtras()
                com.jumio.defaultui.JumioActivity r1 = r9.f55029a
                if (r0 != 0) goto L_0x0023
                goto L_0x002b
            L_0x0023:
                java.lang.String r2 = "com.jumio.defaultui.JumioActivity.EXTRA_TOKEN"
                java.lang.String r2 = r0.getString(r2)
                if (r2 != 0) goto L_0x002d
            L_0x002b:
                java.lang.String r2 = ""
            L_0x002d:
                r1.token = r2
                com.jumio.defaultui.JumioActivity r1 = r9.f55029a
                if (r0 != 0) goto L_0x0035
                goto L_0x003d
            L_0x0035:
                java.lang.String r2 = "com.jumio.defaultui.JumioActivity.EXTRA_DATACENTER"
                java.lang.String r0 = r0.getString(r2)
                if (r0 != 0) goto L_0x003f
            L_0x003d:
                r0 = 0
                goto L_0x0043
            L_0x003f:
                com.jumio.sdk.enums.JumioDataCenter r0 = com.jumio.sdk.enums.JumioDataCenter.valueOf(r0)
            L_0x0043:
                if (r0 != 0) goto L_0x0047
                com.jumio.sdk.enums.JumioDataCenter r0 = com.jumio.sdk.enums.JumioDataCenter.US
            L_0x0047:
                r1.datacenter = r0
                com.jumio.defaultui.JumioActivity r0 = r9.f55029a
                android.content.Intent r1 = r0.getIntent()
                r2 = 0
                if (r1 != 0) goto L_0x0054
                goto L_0x005a
            L_0x0054:
                android.os.Bundle r1 = r1.getExtras()
                if (r1 != 0) goto L_0x005c
            L_0x005a:
                r1 = 0
                goto L_0x0062
            L_0x005c:
                java.lang.String r3 = "com.jumio.defaultui.JumioActivity.EXTRA_CUSTOM_THEME"
                int r1 = r1.getInt(r3, r2)
            L_0x0062:
                r0.customThemeId = r1
                com.jumio.defaultui.JumioActivity r0 = r9.f55029a
                int r0 = r0.customThemeId
                if (r0 == 0) goto L_0x0077
                com.jumio.defaultui.JumioActivity r0 = r9.f55029a
                int r1 = r0.customThemeId
                r0.setTheme(r1)
                goto L_0x0094
            L_0x0077:
                com.jumio.defaultui.JumioActivity r0 = r9.f55029a
                android.content.pm.PackageManager r1 = r0.getPackageManager()
                if (r1 != 0) goto L_0x0080
                goto L_0x0091
            L_0x0080:
                com.jumio.defaultui.JumioActivity r3 = r9.f55029a
                android.content.ComponentName r3 = r3.getComponentName()
                android.content.pm.ActivityInfo r1 = r1.getActivityInfo(r3, r2)
                if (r1 != 0) goto L_0x008d
                goto L_0x0091
            L_0x008d:
                int r2 = r1.getThemeResource()
            L_0x0091:
                r0.customThemeId = r2
            L_0x0094:
                a.b r0 = new a.b
                com.jumio.defaultui.JumioActivity r4 = r9.f55029a
                java.lang.String r5 = r4.token
                com.jumio.defaultui.JumioActivity r1 = r9.f55029a
                com.jumio.sdk.enums.JumioDataCenter r6 = r1.datacenter
                com.jumio.defaultui.JumioActivity r1 = r9.f55029a
                int r7 = r1.customThemeId
                com.jumio.defaultui.JumioActivity r1 = r9.f55029a
                android.app.Application r8 = r1.getApplication()
                java.lang.String r1 = "this.application"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
                r3 = r0
                r3.<init>(r4, r5, r6, r7, r8)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.C20050n.invoke():androidx.lifecycle.ViewModelProvider$Factory");
        }
    }

    /* renamed from: com.jumio.defaultui.JumioActivity$o */
    /* compiled from: ActivityViewModelLazy.kt */
    public static final class C20051o extends Lambda implements Function0<ViewModelStore> {

        /* renamed from: a */
        public final /* synthetic */ ComponentActivity f55030a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20051o(ComponentActivity componentActivity) {
            super(0);
            this.f55030a = componentActivity;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.f55030a.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void finishActivity(com.jumio.sdk.result.JumioResult r5) {
        /*
            r4 = this;
            java.lang.String r0 = TAG
            java.lang.String r1 = "finishSDK called"
            com.jumio.commons.log.Log.m39456d((java.lang.String) r0, (java.lang.String) r1)
            java.lang.Object r1 = r4.finishLock
            monitor-enter(r1)
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x0056 }
            r2.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = "com.jumio.defaultui.JumioActivity.EXTRA_RESULT"
            r2.putExtra(r3, r5)     // Catch:{ all -> 0x0056 }
            r5 = -1
            r4.setResult(r5, r2)     // Catch:{ all -> 0x0056 }
            java.lang.String r5 = "finishing activity..."
            com.jumio.commons.log.Log.m39456d((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ all -> 0x0056 }
            com.jumio.defaultui.view.LoadingView r5 = r4.loadingView     // Catch:{ all -> 0x0056 }
            r0 = 1
            if (r5 != 0) goto L_0x0023
            goto L_0x002a
        L_0x0023:
            boolean r5 = r5.isShowing()     // Catch:{ all -> 0x0056 }
            if (r5 != r0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            if (r0 == 0) goto L_0x004f
            com.jumio.defaultui.view.LoadingView r5 = r4.loadingView     // Catch:{ all -> 0x0056 }
            if (r5 != 0) goto L_0x0033
            r5 = 0
            goto L_0x0037
        L_0x0033:
            com.jumio.defaultui.view.LoadingView$ViewState r5 = r5.getViewState()     // Catch:{ all -> 0x0056 }
        L_0x0037:
            com.jumio.defaultui.view.LoadingView$ViewState r0 = com.jumio.defaultui.view.LoadingView.ViewState.SUCCESS     // Catch:{ all -> 0x0056 }
            if (r5 != r0) goto L_0x004f
            android.os.Handler r5 = new android.os.Handler     // Catch:{ all -> 0x0056 }
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0056 }
            r5.<init>(r0)     // Catch:{ all -> 0x0056 }
            com.jumio.defaultui.-$$Lambda$JumioActivity$ibJjCCEZIMQbDVw72HSStGwaZks r0 = new com.jumio.defaultui.-$$Lambda$JumioActivity$ibJjCCEZIMQbDVw72HSStGwaZks     // Catch:{ all -> 0x0056 }
            r0.<init>()     // Catch:{ all -> 0x0056 }
            r2 = 2000(0x7d0, double:9.88E-321)
            r5.postDelayed(r0, r2)     // Catch:{ all -> 0x0056 }
            goto L_0x0054
        L_0x004f:
            r4.finish()     // Catch:{ all -> 0x0056 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r1)
            return
        L_0x0056:
            r5 = move-exception
            monitor-exit(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.finishActivity(com.jumio.sdk.result.JumioResult):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: finishActivity$lambda-7$lambda-6  reason: not valid java name */
    public static final void m47558finishActivity$lambda7$lambda6(JumioActivity jumioActivity) {
        Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
        jumioActivity.finish();
    }

    /* access modifiers changed from: private */
    public final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    private final void initObservers() {
        getJumioViewModel().mo69z().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                JumioActivity.m47559initObservers$lambda2(JumioActivity.this, (JumioResult) obj);
            }
        });
        getJumioViewModel().mo52o().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                JumioActivity.m47560initObservers$lambda3(JumioActivity.this, (JumioError) obj);
            }
        });
        getJumioViewModel().mo3A().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                JumioActivity.m47561initObservers$lambda5(JumioActivity.this, (C0010a.C0013c) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: initObservers$lambda-2  reason: not valid java name */
    public static final void m47559initObservers$lambda2(JumioActivity jumioActivity, JumioResult jumioResult) {
        LoadingView loadingView2;
        Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
        if (jumioResult.isSuccess()) {
            LoadingView loadingView3 = jumioActivity.loadingView;
            boolean z = true;
            if (loadingView3 == null || !loadingView3.isShowing()) {
                z = false;
            }
            if (z && (loadingView2 = jumioActivity.loadingView) != null) {
                loadingView2.update(new LoadingView.State(LoadingView.ViewState.SUCCESS, R.string.jumio_uploading_success, "", 0, (View.OnClickListener) null, 24, (DefaultConstructorMarker) null));
            }
        }
        Intrinsics.checkNotNullExpressionValue(jumioResult, "it");
        jumioActivity.finishActivity(jumioResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: initObservers$lambda-3  reason: not valid java name */
    public static final void m47560initObservers$lambda3(JumioActivity jumioActivity, JumioError jumioError) {
        Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
        jumioActivity.setActionBarQuitIcon(R.drawable.jumio_ic_close);
        Intrinsics.checkNotNullExpressionValue(jumioError, "it");
        jumioActivity.showError(jumioError);
    }

    /* access modifiers changed from: private */
    /* renamed from: initObservers$lambda-5  reason: not valid java name */
    public static final void m47561initObservers$lambda5(JumioActivity jumioActivity, C0010a.C0013c cVar) {
        LoadingView loadingView2;
        LoadingView loadingView3;
        Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
        if (cVar != null) {
            LoadingView loadingView4 = jumioActivity.loadingView;
            boolean z = false;
            if (!(!(loadingView4 != null && loadingView4.isShowing()) || cVar == C0010a.C0013c.LOADING || cVar == C0010a.C0013c.UPLOAD || (loadingView3 = jumioActivity.loadingView) == null)) {
                LoadingView.hide$default(loadingView3, (AnimatorListenerAdapter) null, 0, 0, 7, (Object) null);
            }
            switch (C20030c.f55009a[cVar.ordinal()]) {
                case 1:
                    LoadingView loadingView5 = jumioActivity.loadingView;
                    if (loadingView5 != null) {
                        LoadingView.show$default(loadingView5, new C20047l(jumioActivity), 0, 0, 6, (Object) null);
                        return;
                    }
                    return;
                case 2:
                    NavController navController2 = jumioActivity.navController;
                    if (navController2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController2 = null;
                    }
                    jumioActivity.navigateIfRequired(navController2, R.id.startFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20031d.f55010a));
                    return;
                case 3:
                    if (jumioActivity.getJumioViewModel().mo44g() instanceof JumioIDCredential) {
                        NavController navController3 = jumioActivity.navController;
                        if (navController3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navController");
                            navController3 = null;
                        }
                        jumioActivity.navigateIfRequired(navController3, R.id.scanFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20039h.f55018a));
                        return;
                    } else if (jumioActivity.getJumioViewModel().mo44g() instanceof JumioFaceCredential) {
                        JumioScanPart k = jumioActivity.getJumioViewModel().mo48k();
                        if ((k == null ? null : k.getScanMode()) == JumioScanMode.FACE_IPROOV) {
                            NavController navController4 = jumioActivity.navController;
                            if (navController4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("navController");
                                navController4 = null;
                            }
                            jumioActivity.navigateIfRequired(navController4, R.id.iproovScanFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20041i.f55020a));
                            return;
                        }
                        NavController navController5 = jumioActivity.navController;
                        if (navController5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navController");
                            navController5 = null;
                        }
                        jumioActivity.navigateIfRequired(navController5, R.id.scanFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20043j.f55022a));
                        return;
                    } else {
                        return;
                    }
                case 4:
                    NavController navController6 = jumioActivity.navController;
                    if (navController6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController6 = null;
                    }
                    jumioActivity.navigateIfRequired(navController6, R.id.nfcScanFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20045k.f55024a));
                    return;
                case 5:
                    NavController navController7 = jumioActivity.navController;
                    if (navController7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController7 = null;
                    }
                    jumioActivity.navigateIfRequired(navController7, R.id.documentSelectionFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20035f.f55014a));
                    return;
                case 6:
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            JumioActivity.m47562initObservers$lambda5$lambda4(JumioActivity.this);
                        }
                    }, 200);
                    return;
                case 7:
                    NavController navController8 = jumioActivity.navController;
                    if (navController8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController8 = null;
                    }
                    jumioActivity.navigateIfRequired(navController8, R.id.rejectFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20033e.f55012a));
                    jumioActivity.setActionBarQuitIcon(R.drawable.jumio_ic_close);
                    return;
                case 8:
                    NavController navController9 = jumioActivity.navController;
                    if (navController9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                        navController9 = null;
                    }
                    jumioActivity.navigateIfRequired(navController9, R.id.countrySelectionFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20037g.f55016a));
                    return;
                case 9:
                    LoadingView loadingView6 = jumioActivity.loadingView;
                    if (loadingView6 != null && !loadingView6.isShowing()) {
                        z = true;
                    }
                    if (z && (loadingView2 = jumioActivity.loadingView) != null) {
                        LoadingView.show$default(loadingView2, (AnimatorListenerAdapter) null, 100, 0, 5, (Object) null);
                    }
                    LoadingView loadingView7 = jumioActivity.loadingView;
                    if (loadingView7 != null) {
                        loadingView7.update(new LoadingView.State(LoadingView.ViewState.PROGRESS, R.string.jumio_uploading_title, (String) null, 0, (View.OnClickListener) null, 28, (DefaultConstructorMarker) null));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initObservers$lambda-5$lambda-4  reason: not valid java name */
    public static final void m47562initObservers$lambda5$lambda4(JumioActivity jumioActivity) {
        Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
        NavController navController2 = jumioActivity.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        jumioActivity.navigateIfRequired(navController2, R.id.confirmationFragment, (Bundle) null, NavOptionsBuilderKt.navOptions(C20048m.f55027a));
        jumioActivity.setActionBarQuitIcon(R.drawable.jumio_ic_close);
    }

    private final void installSplitContext(Context context) {
        try {
            if (ReflectionUtil.hasClass("com.google.android.play.core.splitcompat.SplitCompat")) {
                Class<?> cls = Class.forName("com.google.android.play.core.splitcompat.SplitCompat");
                ReflectionUtil.invokeMethodWithArgs(cls, HotpatchStateConst.INSTALL, new Class[]{Context.class}, (Object) null, context);
                ReflectionUtil.invokeMethodWithArgs(cls, "installActivity", new Class[]{Context.class}, (Object) null, context);
            }
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0003, code lost:
        r0 = r2.getCurrentDestination();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigateIfRequired(androidx.navigation.NavController r2, int r3, android.os.Bundle r4, androidx.navigation.NavOptions r5) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            goto L_0x0012
        L_0x0003:
            androidx.navigation.NavDestination r0 = r2.getCurrentDestination()
            if (r0 != 0) goto L_0x000a
            goto L_0x0012
        L_0x000a:
            int r0 = r0.getId()
            if (r0 != r3) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 != 0) goto L_0x001c
            if (r2 != 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            r0 = 0
            r2.navigate((int) r3, (android.os.Bundle) r4, (androidx.navigation.NavOptions) r5, (androidx.navigation.Navigator.Extras) r0)
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.navigateIfRequired(androidx.navigation.NavController, int, android.os.Bundle, androidx.navigation.NavOptions):void");
    }

    public static /* synthetic */ void navigateIfRequired$default(JumioActivity jumioActivity, NavController navController2, int i, Bundle bundle, NavOptions navOptions, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        if ((i2 & 4) != 0) {
            navOptions = null;
        }
        jumioActivity.navigateIfRequired(navController2, i, bundle, navOptions);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m47563onCreate$lambda0(JumioActivity jumioActivity, NavController navController2, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
        Intrinsics.checkNotNullParameter(navController2, "$noName_0");
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Current destination: ");
        sb.append(navDestination.getLabel());
        sb.append(", State: ");
        C0010a.C0013c value = jumioActivity.getJumioViewModel().mo3A().getValue();
        sb.append(value == null ? null : value.name());
        Log.m39466i(str, sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-1  reason: not valid java name */
    public static final void m47564onResume$lambda1(JumioActivity jumioActivity) {
        Intrinsics.checkNotNullParameter(jumioActivity, "this$0");
        LoadingView loadingView2 = jumioActivity.loadingView;
        if (loadingView2 != null) {
            loadingView2.setPause(false);
        }
    }

    private final void showError(JumioError jumioError) {
        this.error = jumioError;
        View.OnClickListener bVar = jumioError.isRetryable() ? new C20028b(this) : new C20027a(this, jumioError);
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            loadingView2.update(new LoadingView.ErrorState(jumioError, bVar));
        }
        LoadingView loadingView3 = this.loadingView;
        if (loadingView3 != null) {
            LoadingView.show$default(loadingView3, (AnimatorListenerAdapter) null, 100, 0, 5, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void shutdown() {
        try {
            JumioController q = getJumioViewModel().mo60q();
            if (q != null) {
                q.cancel();
            }
        } catch (Exception e) {
            String str = TAG;
            String message = e.getMessage();
            if (message == null) {
                message = "No message available";
            }
            Log.m39456d(str, message);
        }
    }

    public void announceAccessibilityFragmentTitle() {
    }

    public void attachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "base");
        super.attachBaseContext(context);
        installSplitContext(context);
        installSplitContext(this);
    }

    public void countrySelected() {
        getJumioViewModel().mo7E();
    }

    public DeviceRotationManager getRotationManager() {
        return this.rotationManager;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = super.getTheme();
        int i = this.customThemeId;
        if (i != 0) {
            theme.applyStyle(i, true);
        }
        Intrinsics.checkNotNullExpressionValue(theme, RConfigConstants.SEGMENT_THEME);
        return theme;
    }

    public void hideLoading() {
        LoadingView loadingView2;
        LoadingView loadingView3 = this.loadingView;
        boolean z = true;
        if (loadingView3 == null || !loadingView3.isShowing()) {
            z = false;
        }
        if (z && (loadingView2 = this.loadingView) != null) {
            LoadingView.hide$default(loadingView2, (AnimatorListenerAdapter) null, 0, 0, 7, (Object) null);
        }
    }

    public boolean isRunningTest() {
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r2 = this;
            a.a r0 = r2.getJumioViewModel()
            a.c r0 = r0.mo3A()
            java.lang.Object r0 = r0.getValue()
            a.a$c r0 = (p001a.C0010a.C0013c) r0
            if (r0 != 0) goto L_0x0012
            r0 = -1
            goto L_0x001a
        L_0x0012:
            int[] r1 = com.jumio.defaultui.JumioActivity.C20030c.f55009a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x001a:
            switch(r0) {
                case 1: goto L_0x00b7;
                case 2: goto L_0x00b7;
                case 3: goto L_0x007b;
                case 4: goto L_0x006c;
                case 5: goto L_0x0056;
                case 6: goto L_0x00c5;
                case 7: goto L_0x00c5;
                case 8: goto L_0x0051;
                case 9: goto L_0x0029;
                default: goto L_0x001d;
            }
        L_0x001d:
            a.a r0 = r2.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r0 = r0.mo44g()
            if (r0 != 0) goto L_0x00bb
            goto L_0x00be
        L_0x0029:
            com.jumio.defaultui.view.LoadingView r0 = r2.loadingView
            if (r0 != 0) goto L_0x002f
            r0 = 0
            goto L_0x0033
        L_0x002f:
            com.jumio.defaultui.view.LoadingView$ViewState r0 = r0.getViewState()
        L_0x0033:
            com.jumio.defaultui.view.LoadingView$ViewState r1 = com.jumio.defaultui.view.LoadingView.ViewState.ERROR
            if (r0 != r1) goto L_0x004e
            a.a r0 = r2.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r0 = r0.mo44g()
            if (r0 != 0) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            r0.cancel()
        L_0x0045:
            a.a r0 = r2.getJumioViewModel()
            r0.mo8F()
            goto L_0x00c5
        L_0x004e:
            r0 = 0
            goto L_0x00c6
        L_0x0051:
            r2.countrySelected()
            goto L_0x00c5
        L_0x0056:
            a.a r0 = r2.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r0 = r0.mo44g()
            if (r0 != 0) goto L_0x0061
            goto L_0x0064
        L_0x0061:
            r0.cancel()
        L_0x0064:
            a.a r0 = r2.getJumioViewModel()
            r0.mo8F()
            goto L_0x00c5
        L_0x006c:
            a.a r0 = r2.getJumioViewModel()
            r0.mo18a()
            a.a r0 = r2.getJumioViewModel()
            r0.mo8F()
            goto L_0x00c5
        L_0x007b:
            a.a r0 = r2.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r0 = r0.mo44g()
            boolean r0 = r0 instanceof com.jumio.sdk.credentials.JumioFaceCredential
            if (r0 != 0) goto L_0x00a1
            a.a r0 = r2.getJumioViewModel()
            boolean r0 = r0.mo50m()
            if (r0 == 0) goto L_0x0092
            goto L_0x00a1
        L_0x0092:
            a.a r0 = r2.getJumioViewModel()
            r0.mo18a()
            a.a r0 = r2.getJumioViewModel()
            r0.mo7E()
            goto L_0x00c5
        L_0x00a1:
            a.a r0 = r2.getJumioViewModel()
            com.jumio.sdk.credentials.JumioCredential r0 = r0.mo44g()
            if (r0 != 0) goto L_0x00ac
            goto L_0x00af
        L_0x00ac:
            r0.cancel()
        L_0x00af:
            a.a r0 = r2.getJumioViewModel()
            r0.mo8F()
            goto L_0x00c5
        L_0x00b7:
            r2.shutdown()
            goto L_0x00c5
        L_0x00bb:
            r0.cancel()
        L_0x00be:
            a.a r0 = r2.getJumioViewModel()
            r0.mo8F()
        L_0x00c5:
            r0 = 1
        L_0x00c6:
            if (r0 == 0) goto L_0x00cb
            super.onBackPressed()
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.JumioActivity.onBackPressed():void");
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        if (view.getId() == R.id.ib_quit) {
            if (getJumioViewModel().mo3A().getValue() == C0010a.C0013c.UPLOAD) {
                LoadingView loadingView2 = this.loadingView;
                if ((loadingView2 == null ? null : loadingView2.getViewState()) != LoadingView.ViewState.ERROR) {
                    return;
                }
            }
            shutdown();
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                TypedValue typedValue = new TypedValue();
                getTheme().resolveAttribute(R.attr.colorOnPrimary, typedValue, true);
                window.setStatusBarColor(typedValue.data);
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
        }
        initObservers();
        if (!DeviceUtil.isDebug(getApplicationContext())) {
            getWindow().addFlags(8192);
        }
        setContentView((int) R.layout.activity_jumio);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.root_container);
        this.rootContainer = constraintLayout;
        NavController navController2 = null;
        FrameLayout frameLayout = constraintLayout == null ? null : (FrameLayout) constraintLayout.findViewById(R.id.jumio_loadingView);
        if (frameLayout != null) {
            this.loadingView = new LoadingView(this, frameLayout);
            this.rotationManager = new DeviceRotationManager(this, Rotation.NATIVE);
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            if (findFragmentById != null) {
                NavController navController3 = ((NavHostFragment) findFragmentById).getNavController();
                this.navController = navController3;
                if (navController3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController3 = null;
                }
                navController3.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
                        JumioActivity.m47563onCreate$lambda0(JumioActivity.this, navController, navDestination, bundle);
                    }
                });
                if (!(bundle == null || (i = bundle.getInt("lastFragment", 0)) == 0 || i == R.id.blankFragment)) {
                    NavController navController4 = this.navController;
                    if (navController4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                    } else {
                        navController2 = navController4;
                    }
                    navController2.navigate(i);
                }
                View findViewById = findViewById(R.id.ib_quit);
                if (findViewById != null) {
                    ImageButton imageButton = (ImageButton) findViewById;
                    this.btnQuit = imageButton;
                    imageButton.setContentDescription(getString(R.string.jumio_accessibility_quit_scan));
                    ImageButton imageButton2 = this.btnQuit;
                    if (imageButton2 != null) {
                        imageButton2.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageButton");
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public void onDestroy() {
        getJumioViewModel().mo69z().removeObservers(this);
        getJumioViewModel().mo52o().removeObservers(this);
        getJumioViewModel().mo3A().removeObservers(this);
        Log.m39454d("MobileActivity onDestroy");
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            loadingView2.setPause(true);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        LoadingView loadingView2;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                getJumioViewModel().mo5C();
                return;
            }
            LoadingView loadingView3 = this.loadingView;
            if ((loadingView3 == null ? null : loadingView3.getViewState()) == LoadingView.ViewState.ERROR && (loadingView2 = this.loadingView) != null) {
                LoadingView.hide$default(loadingView2, (AnimatorListenerAdapter) null, 50, 0, 5, (Object) null);
            }
            if (getJumioViewModel().mo3A().getValue() == C0010a.C0013c.SCAN && getJumioViewModel().mo67x().getValue() == JumioScanStep.SCAN_VIEW) {
                getJumioViewModel().mo16N();
            }
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        if (getJumioViewModel().mo64u().getViewState() == LoadingView.ViewState.PROGRESS) {
            updateLoadingState(getJumioViewModel().mo64u());
        }
    }

    public void onResume() {
        super.onResume();
        ConstraintLayout constraintLayout = this.rootContainer;
        if (constraintLayout != null) {
            constraintLayout.post(new Runnable() {
                public final void run() {
                    JumioActivity.m47564onResume$lambda1(JumioActivity.this);
                }
            });
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NavController navController2 = this.navController;
        LoadingView.State state = null;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        NavDestination currentDestination = navController2.getCurrentDestination();
        bundle.putInt("lastFragment", currentDestination == null ? 0 : currentDestination.getId());
        C0010a jumioViewModel = getJumioViewModel();
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            state = loadingView2.getCurrentState$jumio_defaultui_release();
        }
        if (state == null) {
            state = new LoadingView.State(LoadingView.ViewState.STOPPED, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null);
        }
        jumioViewModel.mo20a(state);
    }

    public void retakeImage() {
        setActionBarQuitIcon(R.drawable.jumio_ic_clear_white);
        getJumioViewModel().mo6D();
    }

    public void setActionBarQuitIcon(int i) {
        ImageButton imageButton = this.btnQuit;
        if (imageButton == null) {
            return;
        }
        if (i != 0) {
            if (imageButton != null) {
                imageButton.setImageResource(i);
            }
            ImageButton imageButton2 = this.btnQuit;
            if (imageButton2 != null) {
                imageButton2.setVisibility(0);
            }
        } else if (imageButton != null) {
            imageButton.setVisibility(8);
        }
    }

    public void setBackgroundColor(int i) {
        ConstraintLayout constraintLayout = this.rootContainer;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(i);
        }
    }

    public void setUiAutomationString(String str) {
        View findViewById = findViewById(R.id.nav_host_fragment);
        if (findViewById != null) {
            if (!(str == null || str.length() == 0)) {
                findViewById.setContentDescription(str);
            }
        }
    }

    public void skipAddonPart() {
        getJumioViewModel().mo9G();
    }

    public void startCountrySelection() {
        getJumioViewModel().mo10H();
    }

    public void startUserJourney() {
        getJumioViewModel().mo14L();
    }

    public void updateLoadingState(LoadingView.State state) {
        Intrinsics.checkNotNullParameter(state, "loadingState");
        LoadingView loadingView2 = this.loadingView;
        if (loadingView2 != null) {
            LoadingView.show$default(loadingView2, (AnimatorListenerAdapter) null, 50, 0, 5, (Object) null);
        }
        LoadingView loadingView3 = this.loadingView;
        if (loadingView3 != null) {
            loadingView3.update(state);
        }
    }

    public boolean validatePermissions() {
        if (JumioSDK.Companion.hasAllRequiredPermissions(this)) {
            return true;
        }
        ActivityCompat.requestPermissions(this, JumioSDK.Companion.getMissingPermissions(this), 100);
        return false;
    }
}
