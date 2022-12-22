package com.didi.global.fintech.cashier.user.facade;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.base.module.BaseGlobalCashierModule;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleManager;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.user.bridge.PaymentModule;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import com.didi.global.fintech.cashier.user.theme.ThemeType;
import com.didi.onehybrid.FusionEngine;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rui.config.RConfigConstants;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e0$H\u0002J$\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010'H\u0016J*\u0010,\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010-2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010'H\u0016J \u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0012H\u0016J\"\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\"\u00101\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\u0006\u0010!\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0016J*\u00108\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u0010!\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\"\u0010;\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010<H\u0016J\"\u0010;\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\u0006\u0010!\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010<H\u0016J*\u0010=\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u0010>\u001a\u00020?2\u0006\u0010!\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0016J*\u0010=\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\u0006\u0010>\u001a\u00020?2\u0006\u0010!\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010@\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006B"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/facade/CashierFacade;", "Lcom/didi/global/fintech/cashier/user/facade/ICashierFacade;", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "cashierProcessor", "Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor;", "configurationProxy", "Lcom/didi/global/fintech/cashier/user/facade/CashierConfigurationProxy;", "getConfigurationProxy", "()Lcom/didi/global/fintech/cashier/user/facade/CashierConfigurationProxy;", "setConfigurationProxy", "(Lcom/didi/global/fintech/cashier/user/facade/CashierConfigurationProxy;)V", "initConfig", "Lcom/didi/global/fintech/cashier/user/facade/CashierInitConfig;", "getInitConfig", "()Lcom/didi/global/fintech/cashier/user/facade/CashierInitConfig;", "setInitConfig", "(Lcom/didi/global/fintech/cashier/user/facade/CashierInitConfig;)V", "theme", "Lcom/didi/global/fintech/cashier/user/theme/ThemeType;", "getTheme", "()Lcom/didi/global/fintech/cashier/user/theme/ThemeType;", "setTheme", "(Lcom/didi/global/fintech/cashier/user/theme/ThemeType;)V", "checkVersion", "", "context", "Landroid/content/Context;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "callback", "Lkotlin/Function1;", "", "getParamByModuleSync", "", "moduleType", "Lcom/didi/global/fintech/cashier/base/module/GlobalCashierModuleType;", "paramName", "args", "getParamListByModuleSync", "", "init", "app", "config", "launch", "activity", "Landroid/app/Activity;", "listener", "Lcom/didi/global/fintech/cashier/user/facade/CashierLaunchListener;", "fragment", "Landroidx/fragment/app/Fragment;", "launchCustomCashier", "intent", "Landroid/content/Intent;", "launchForCashierResult", "Lcom/didi/global/fintech/cashier/user/facade/CashierResultListener;", "launchForResult", "requestCode", "", "updateConfigurationProxy", "Companion", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierFacade.kt */
public final class CashierFacade implements ICashierFacade {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final CashierFacade f22020c = new CashierFacade();

    /* renamed from: a */
    private CashierConfigurationProxy f22021a;
    public Application application;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IGlobalCashierProcessor f22022b = ((IGlobalCashierProcessor) ServiceLoader.load(IGlobalCashierProcessor.class).get());
    public CashierInitConfig initConfig;
    public ThemeType theme;

    @JvmStatic
    public static final CashierFacade getInstance() {
        return Companion.getInstance();
    }

    private CashierFacade() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/facade/CashierFacade$Companion;", "", "()V", "INS", "Lcom/didi/global/fintech/cashier/user/facade/CashierFacade;", "getInstance", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CashierFacade.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CashierFacade getInstance() {
            return CashierFacade.f22020c;
        }
    }

    public final CashierInitConfig getInitConfig() {
        CashierInitConfig cashierInitConfig = this.initConfig;
        if (cashierInitConfig != null) {
            return cashierInitConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initConfig");
        return null;
    }

    public final void setInitConfig(CashierInitConfig cashierInitConfig) {
        Intrinsics.checkNotNullParameter(cashierInitConfig, "<set-?>");
        this.initConfig = cashierInitConfig;
    }

    public final Application getApplication() {
        Application application2 = this.application;
        if (application2 != null) {
            return application2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }

    public final void setApplication(Application application2) {
        Intrinsics.checkNotNullParameter(application2, "<set-?>");
        this.application = application2;
    }

    public final ThemeType getTheme() {
        ThemeType themeType = this.theme;
        if (themeType != null) {
            return themeType;
        }
        Intrinsics.throwUninitializedPropertyAccessException(RConfigConstants.SEGMENT_THEME);
        return null;
    }

    public final void setTheme(ThemeType themeType) {
        Intrinsics.checkNotNullParameter(themeType, "<set-?>");
        this.theme = themeType;
    }

    public final CashierConfigurationProxy getConfigurationProxy() {
        return this.f22021a;
    }

    public final void setConfigurationProxy(CashierConfigurationProxy cashierConfigurationProxy) {
        this.f22021a = cashierConfigurationProxy;
    }

    public void init(Application application2, ThemeType themeType, CashierInitConfig cashierInitConfig) {
        Intrinsics.checkNotNullParameter(application2, "app");
        Intrinsics.checkNotNullParameter(themeType, RConfigConstants.SEGMENT_THEME);
        Intrinsics.checkNotNullParameter(cashierInitConfig, "config");
        setApplication(application2);
        setTheme(themeType);
        setInitConfig(cashierInitConfig);
        FusionEngine.export("payment", PaymentModule.class);
    }

    public void updateConfigurationProxy(CashierConfigurationProxy cashierConfigurationProxy) {
        this.f22021a = cashierConfigurationProxy;
    }

    public void launch(Activity activity, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        if (cashierLaunchListener == null) {
            IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
            if (iGlobalCashierProcessor != null) {
                iGlobalCashierProcessor.launch(activity, (Intent) null, (Integer) null, cashierParam);
                return;
            }
            return;
        }
        m15957a(activity, cashierParam, new CashierFacade$launch$1(cashierLaunchListener, this, activity, cashierParam));
    }

    public void launch(Fragment fragment, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        if (cashierLaunchListener == null) {
            IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
            if (iGlobalCashierProcessor != null) {
                iGlobalCashierProcessor.launch(fragment, (Intent) null, (Integer) null, cashierParam);
                return;
            }
            return;
        }
        m15957a(fragment.getContext(), cashierParam, new CashierFacade$launch$2(cashierLaunchListener, this, fragment, cashierParam));
    }

    public void launchForResult(Activity activity, int i, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        if (cashierLaunchListener == null) {
            IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
            if (iGlobalCashierProcessor != null) {
                iGlobalCashierProcessor.launch(activity, (Intent) null, Integer.valueOf(i), cashierParam);
                return;
            }
            return;
        }
        m15957a(activity, cashierParam, new CashierFacade$launchForResult$1(cashierLaunchListener, this, activity, i, cashierParam));
    }

    public void launchForResult(Fragment fragment, int i, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        if (cashierLaunchListener == null) {
            IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
            if (iGlobalCashierProcessor != null) {
                iGlobalCashierProcessor.launch(fragment, (Intent) null, Integer.valueOf(i), cashierParam);
                return;
            }
            return;
        }
        m15957a(fragment.getContext(), cashierParam, new CashierFacade$launchForResult$2(cashierLaunchListener, this, fragment, i, cashierParam));
    }

    public void launchForCashierResult(Activity activity, CashierParam cashierParam, CashierResultListener cashierResultListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
        if (iGlobalCashierProcessor != null) {
            iGlobalCashierProcessor.launchForResult(activity, cashierParam, cashierResultListener);
        }
    }

    public void launchForCashierResult(Fragment fragment, CashierParam cashierParam, CashierResultListener cashierResultListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
        if (iGlobalCashierProcessor != null) {
            iGlobalCashierProcessor.launchForResult(fragment, cashierParam, cashierResultListener);
        }
    }

    public void launchCustomCashier(Activity activity, Intent intent, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        if (cashierLaunchListener == null) {
            IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
            if (iGlobalCashierProcessor != null) {
                iGlobalCashierProcessor.launch(activity, intent, (Integer) null, cashierParam);
                return;
            }
            return;
        }
        m15957a(activity, cashierParam, new CashierFacade$launchCustomCashier$1(cashierLaunchListener, this, activity, intent, cashierParam));
    }

    public String getParamByModuleSync(GlobalCashierModuleType globalCashierModuleType, String str, String str2) {
        JSONObject syncCall;
        Intrinsics.checkNotNullParameter(globalCashierModuleType, "moduleType");
        Intrinsics.checkNotNullParameter(str, "paramName");
        BaseGlobalCashierModule module = GlobalCashierModuleManager.INSTANCE.getModule(Companion.getInstance().getApplication(), globalCashierModuleType);
        if (module == null || (syncCall = module.syncCall(BaseGlobalCashierModule.Companion.request(str, str2))) == null) {
            return null;
        }
        return syncCall.optString("response");
    }

    public List<String> getParamListByModuleSync(GlobalCashierModuleType globalCashierModuleType, String str, String str2) {
        Object obj;
        JSONObject syncCall;
        Intrinsics.checkNotNullParameter(globalCashierModuleType, "moduleType");
        Intrinsics.checkNotNullParameter(str, "paramName");
        BaseGlobalCashierModule module = GlobalCashierModuleManager.INSTANCE.getModule(Companion.getInstance().getApplication(), globalCashierModuleType);
        if (module == null || (syncCall = module.syncCall(BaseGlobalCashierModule.Companion.request(str, str2))) == null) {
            obj = null;
        } else {
            obj = syncCall.opt("response");
        }
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    /* renamed from: a */
    private final void m15957a(Context context, CashierParam cashierParam, Function1<? super Boolean, Unit> function1) {
        IGlobalCashierProcessor iGlobalCashierProcessor = this.f22022b;
        if (iGlobalCashierProcessor != null) {
            iGlobalCashierProcessor.showLoading(context);
        }
        IGlobalCashierProcessor iGlobalCashierProcessor2 = this.f22022b;
        if (iGlobalCashierProcessor2 != null) {
            iGlobalCashierProcessor2.newVersionCheck(cashierParam, new CashierFacade$checkVersion$1(this, function1));
        }
    }
}
