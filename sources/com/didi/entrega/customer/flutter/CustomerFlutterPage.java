package com.didi.entrega.customer.flutter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.HorizontalChangeHandler;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.base.pages.CustomerPageDelegate;
import com.didi.entrega.customer.base.pages.PageBackHelper;
import com.didi.entrega.customer.base.pages.changehandler.CustomerVerticalChangeHandler;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.util.CustomerStatusBarHelper;
import com.didi.entrega.customer.foundation.util.GpsManager;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.IHubHandler;
import com.didi.entrega.router.Request;
import com.didi.entrega.router.Response;
import com.didi.entrega.router.annotations.Route;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.android.BaseNachoSkeletonPage;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.systemchannels.LocalizationChannel;

@Metadata(mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u001c\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010-0,H\u0002J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0014H\u0002J\b\u00101\u001a\u00020\u0014H\u0002J\b\u00102\u001a\u00020\u0014H\u0002J\b\u00103\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058CX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/CustomerFlutterPage;", "Lio/flutter/embedding/android/BaseNachoSkeletonPage;", "Lcom/didi/entrega/router/IHubHandler;", "()V", "changeHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "getChangeHandler", "()Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "isPageDestroyed", "", "mAppSoftInputMode", "", "mCustomerPageDelegate", "Lcom/didi/entrega/customer/base/pages/CustomerPageDelegate;", "mLogger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "alias", "", "finish", "", "data", "Landroid/os/Bundle;", "getContext", "Landroid/content/Context;", "getInitialRoute", "getPopHandler", "getPushHandler", "onCreate", "view", "Landroid/view/View;", "onDestroy", "onFinalize", "onHandleBack", "onInitialize", "onResume", "onStart", "onStop", "openRoute", "request", "Lcom/didi/entrega/router/Request;", "response", "Lcom/didi/entrega/router/Response;", "parseInitRouteParams", "", "", "provideNachoAction", "Lcom/didi/flutter/nacho2/v2/NachoAction;", "restoreSoftInputAdjustResize", "saveSoftInputAdjustResize", "setSoftInputAdjustResize", "updateLocale", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"flutterCommonPage"})
/* compiled from: CustomerFlutterPage.kt */
public class CustomerFlutterPage extends BaseNachoSkeletonPage implements IHubHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final CustomerPageDelegate f19888a;

    /* renamed from: b */
    private final Logger f19889b;

    /* renamed from: c */
    private int f19890c = 48;

    /* renamed from: d */
    private boolean f19891d;

    public String getInitialRoute() {
        return "/";
    }

    public CustomerFlutterPage() {
        Logger logger = LogService.getLogger("CustomerFlutterPage");
        this.f19889b = logger;
        logger.debug(this + "CustomerFlutterPage()", new Object[0]);
        this.f19888a = new CustomerPageDelegate(this, true);
    }

    /* renamed from: a */
    private final ControllerChangeHandler m14720a() {
        AnimatorChangeHandler animatorChangeHandler;
        Bundle args = getArgs();
        if (args == null) {
            return new HorizontalChangeHandler();
        }
        String string = args.getString("changehandler", "");
        Intrinsics.checkNotNullExpressionValue(string, "changeHandler");
        if (string.length() == 0) {
            return new HorizontalChangeHandler();
        }
        if (Intrinsics.areEqual((Object) string, (Object) "CustomerVerticalChangeHandler")) {
            animatorChangeHandler = new CustomerVerticalChangeHandler();
        } else {
            animatorChangeHandler = new HorizontalChangeHandler();
        }
        return animatorChangeHandler;
    }

    public void openRoute(Request request, Response response) {
        this.f19888a.openRoute(request);
    }

    public void onInitialize() {
        super.onInitialize();
        this.f19888a.onInitialize(this);
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle args = getArgs();
        GpsManager.Companion.getInstance().registerGpsReceiver(getContext());
        ScopeContext scopeContext = getScopeContext();
        if (scopeContext != null) {
            scopeContext.attach("PageName", alias());
        }
        if (args != null) {
            args.putString("brand", GlobalContext.getBrand() == 2 ? "99" : "global");
        }
        if (GlobalContext.isEmbed()) {
            m14722c();
            m14723d();
        }
        this.f19888a.onCreate();
        super.onCreate(view);
    }

    public void onStart() {
        super.onStart();
        this.f19888a.onStart((View) null, 0);
    }

    public void onResume() {
        super.onResume();
        this.f19888a.onResume();
        this.mRootView.requestFocus();
    }

    public void onStop() {
        super.onStop();
        this.f19888a.onStop();
    }

    public void updateLocale() {
        FlutterEngine engine;
        LocalizationChannel localizationChannel;
        super.updateLocale();
        ArrayList arrayList = new ArrayList(1);
        for (int i = 0; i < 1; i++) {
            Locale lang = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLang();
            if (lang == null) {
                lang = new Locale("en-US");
            }
            arrayList.add(lang);
        }
        List list = arrayList;
        NachoAction bizMainEngineAction = FlutterEngineStore.getInstance().getBizMainEngineAction();
        if (bizMainEngineAction != null && (engine = bizMainEngineAction.getEngine()) != null && (localizationChannel = engine.getLocalizationChannel()) != null) {
            localizationChannel.sendLocales(list);
        }
    }

    public NachoAction provideNachoAction() {
        NachoAction bizMainEngineAction = FlutterEngineStore.getInstance().getBizMainEngineAction();
        Intrinsics.checkNotNullExpressionValue(bizMainEngineAction, "getInstance().bizMainEngineAction");
        return bizMainEngineAction;
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", alias()).build().track();
        return super.onHandleBack();
    }

    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            CustomerStatusBarHelper.getHelper().resetState();
            CustomerStatusBarHelper.getHelper().setStatusBarBgLightning(getActivity(), false);
        }
        if (GlobalContext.isEmbed()) {
            m14724e();
        }
        GpsManager.Companion.getInstance().unRegisterGpsReceiver(getContext());
        this.f19891d = true;
    }

    public void onFinalize() {
        if (!this.f19891d) {
            onDestroy();
        }
        super.onFinalize();
    }

    public String alias() {
        if (getScopeContext() != null) {
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNull(scopeContext);
            if (scopeContext.getBundle().getString("path") != null) {
                ScopeContext scopeContext2 = getScopeContext();
                Intrinsics.checkNotNull(scopeContext2);
                String string = scopeContext2.getBundle().getString("path");
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNullExpressionValue(string, "scopeContext!!.bundle.ge…ommons.BUNDLE_KEY_PATH)!!");
                return string;
            }
        }
        String alias = super.alias();
        Intrinsics.checkNotNullExpressionValue(alias, "super.alias()");
        return alias;
    }

    public Context getContext() {
        Context context = this.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        return context;
    }

    public ControllerChangeHandler getPushHandler() {
        return m14720a();
    }

    public ControllerChangeHandler getPopHandler() {
        return m14720a();
    }

    public void finish() {
        if (!PageBackHelper.Companion.popBackStack(this)) {
            super.finish();
        }
    }

    public void finish(Bundle bundle) {
        if (!PageBackHelper.Companion.popBackStack(this)) {
            super.finish(bundle);
        }
    }

    /* renamed from: b */
    private final Map<String, Object> m14721b() {
        Logger logger = this.f19889b;
        logger.debug(this + "parseInitRouteParams()", new Object[0]);
        Bundle args = getArgs();
        Map<String, Object> hashMap = new HashMap<>();
        Bundle bundle = args.getBundle("params");
        if (bundle == null) {
            bundle = new Bundle();
        }
        hashMap.put("path", args.getString("path"));
        hashMap.put("params", transformBundleParameters(bundle));
        return hashMap;
    }

    /* renamed from: c */
    private final void m14722c() {
        try {
            Activity activity = getActivity();
            int i = 48;
            if (activity != null) {
                Window window = activity.getWindow();
                if (window != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (attributes != null) {
                        i = attributes.softInputMode;
                    }
                }
            }
            this.f19890c = i;
            Logger logger = this.f19889b;
            logger.debug(this + "mAppSoftInputMode = " + this.f19890c, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private final void m14723d() {
        Window window;
        Logger logger = this.f19889b;
        logger.debug(this + "setSoftInputAdjustResize", new Object[0]);
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(16);
        }
    }

    /* renamed from: e */
    private final void m14724e() {
        Window window;
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(this.f19890c);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/CustomerFlutterPage$Companion;", "", "()V", "showPage", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerFlutterPage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showPage() {
            DiRouter.request().path("flutterCommonPage").putString("path", FlutterCommons.FLUTTER_ROUTE_POI_PAGE).open();
        }
    }
}
