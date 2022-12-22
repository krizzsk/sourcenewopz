package com.didi.dimina.container.secondparty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DefaultDMNavigator;
import com.didi.dimina.container.secondparty.route.RouteConfig;
import com.didi.dimina.container.secondparty.route.RouteParseManager;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/Dimina4DiContainerActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "loadingView", "Landroid/widget/ProgressBar;", "mConfig", "Lcom/didi/dimina/container/DMConfig;", "mDmMina", "Lcom/didi/dimina/container/DMMina;", "afterLaunch", "", "dmMina", "beforeLaunch", "uiConfig", "Lcom/didi/dimina/container/DMConfig$UIConfig;", "doFinish", "doLaunch", "getRouteConfig", "Lcom/didi/dimina/container/secondparty/route/RouteConfig;", "arguments", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "parseConfig", "startDimina", "config", "Companion", "DiminaNavigator", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Dimina4DiContainerActivity.kt */
public class Dimina4DiContainerActivity extends FragmentActivity {
    public static final String BUNDLE_DIMINA_ROUTE_CONFIG = "dimina_route_config";
    public static final String BUNDLE_DIMINA_SCHEME = "dimina_scheme";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_DIMINA_REQUEST_CODE = 1110;
    public static final String TAG = "Dimina4DiContainerActivity";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DMConfig f17044a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DMMina f17045b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ProgressBar f17046c;

    /* renamed from: d */
    private HashMap f17047d;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMMina.InstallStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DMMina.InstallStatus.TRIGGER_FORCE_UPDATE.ordinal()] = 1;
            $EnumSwitchMapping$0[DMMina.InstallStatus.BUNDLE_CONFIG_VALID.ordinal()] = 2;
        }
    }

    @JvmStatic
    public static final void open(Context context, RouteConfig routeConfig) {
        Companion.open$default(Companion, context, routeConfig, 0, 4, (Object) null);
    }

    @JvmStatic
    public static final void open(Context context, RouteConfig routeConfig, int i) {
        Companion.open(context, routeConfig, i);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f17047d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f17047d == null) {
            this.f17047d = new HashMap();
        }
        View view = (View) this.f17047d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f17047d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void afterLaunch(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "dmMina");
    }

    /* access modifiers changed from: protected */
    public void beforeLaunch(DMConfig.UIConfig uIConfig) {
        Intrinsics.checkParameterIsNotNull(uIConfig, "uiConfig");
    }

    public static final /* synthetic */ ProgressBar access$getLoadingView$p(Dimina4DiContainerActivity dimina4DiContainerActivity) {
        ProgressBar progressBar = dimina4DiContainerActivity.f17046c;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        }
        return progressBar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        if ((intent != null ? intent.getExtras() : null) == null || m12566a(intent.getExtras()) == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.dimina_container_activity);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(extras, "intent.extras!!");
        parseConfig(extras);
        View findViewById = findViewById(R.id.container_acty_loading_view);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById<ProgressBar…tainer_acty_loading_view)");
        this.f17046c = (ProgressBar) findViewById;
        DMConfig dMConfig = this.f17044a;
        if (dMConfig != null) {
            DMConfig.UIConfig uIConfig = dMConfig.getUIConfig();
            Intrinsics.checkExpressionValueIsNotNull(uIConfig, "it.uiConfig");
            beforeLaunch(uIConfig);
            m12568a(this.f17044a);
            DMMina dMMina = this.f17045b;
            if (dMMina == null) {
                Intrinsics.throwNpe();
            }
            afterLaunch(dMMina);
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void parseConfig(Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "arguments");
        DMConfig transformConfig = RouteParseManager.transformConfig(this, m12566a(bundle));
        this.f17044a = transformConfig;
        if (transformConfig != null) {
            DMConfig.CallBackConfig callbackConfig = transformConfig.getCallbackConfig();
            Intrinsics.checkExpressionValueIsNotNull(callbackConfig, "it.callbackConfig");
            callbackConfig.setRelaunchCallback(new Dimina4DiContainerActivity$parseConfig$$inlined$let$lambda$1(this));
        }
    }

    /* renamed from: a */
    private final RouteConfig m12566a(Bundle bundle) {
        RouteConfig routeConfig = null;
        if (bundle == null) {
            return routeConfig;
        }
        if (bundle.get(BUNDLE_DIMINA_ROUTE_CONFIG) != null) {
            return (RouteConfig) bundle.getSerializable(BUNDLE_DIMINA_ROUTE_CONFIG);
        }
        if (bundle.get(BUNDLE_DIMINA_SCHEME) == null) {
            return routeConfig;
        }
        Context context = this;
        Uri uri = (Uri) bundle.get(BUNDLE_DIMINA_SCHEME);
        if (uri == null) {
            Intrinsics.throwNpe();
        }
        return RouteParseManager.parseUri(context, uri);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12568a(DMConfig dMConfig) {
        if (dMConfig != null) {
            DMMina generate = DMMinaPool.generate(this, dMConfig);
            this.f17045b = generate;
            if (generate != null) {
                generate.preInstall(new Dimina4DiContainerActivity$startDimina$$inlined$let$lambda$1(generate, this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12567a() {
        DMMina dMMina = this.f17045b;
        if (dMMina != null) {
            dMMina.launch(new DiminaNavigator(getSupportFragmentManager(), R.id.container));
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/Dimina4DiContainerActivity$DiminaNavigator;", "Lcom/didi/dimina/container/mina/DefaultDMNavigator;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerViewId", "", "(Lcom/didi/dimina/container/secondparty/Dimina4DiContainerActivity;Landroidx/fragment/app/FragmentManager;I)V", "closeDimina", "", "navigateBack", "minaIndex", "stackIndex", "popCount", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Dimina4DiContainerActivity.kt */
    public final class DiminaNavigator extends DefaultDMNavigator {
        public DiminaNavigator(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        public boolean navigateBack(int i, int i2, int i3) {
            boolean navigateBack = super.navigateBack(i, i2, i3);
            new Handler(Looper.getMainLooper()).post(new Dimina4DiContainerActivity$DiminaNavigator$navigateBack$1(this));
            return navigateBack;
        }

        public boolean closeDimina() {
            boolean closeDimina = super.closeDimina();
            if (closeDimina) {
                Dimina4DiContainerActivity.this.m12569b();
            }
            return closeDimina;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m12569b() {
        finish();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/Dimina4DiContainerActivity$Companion;", "", "()V", "BUNDLE_DIMINA_ROUTE_CONFIG", "", "BUNDLE_DIMINA_SCHEME", "DEFAULT_DIMINA_REQUEST_CODE", "", "TAG", "open", "", "context", "Landroid/content/Context;", "config", "Lcom/didi/dimina/container/secondparty/route/RouteConfig;", "requestCode", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Dimina4DiContainerActivity.kt */
    public static final class Companion {
        @JvmStatic
        public final void open(Context context, RouteConfig routeConfig) {
            open$default(this, context, routeConfig, 0, 4, (Object) null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void open$default(Companion companion, Context context, RouteConfig routeConfig, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 1110;
            }
            companion.open(context, routeConfig, i);
        }

        @JvmStatic
        public final void open(Context context, RouteConfig routeConfig, int i) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent();
            intent.setClass(context, Dimina4DiContainerActivity.class);
            intent.putExtra(Dimina4DiContainerActivity.BUNDLE_DIMINA_ROUTE_CONFIG, routeConfig);
            ((Activity) context).startActivityForResult(intent, i);
        }
    }
}
