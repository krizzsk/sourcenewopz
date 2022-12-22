package com.didi.global.fintech.cashier.user.facade;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleManager;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.model.FastPayCashierEnv;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.global.fintech.cashier.user.spi.IFastPayProcessor;
import com.didichuxing.foundation.spi.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/facade/FastPayFacade;", "Lcom/didi/global/fintech/cashier/user/facade/IFastPayFacade;", "()V", "fastPayProcessor", "Lcom/didi/global/fintech/cashier/user/spi/IFastPayProcessor;", "cashierEnv", "Lcom/didi/global/fintech/cashier/user/model/FastPayCashierEnv;", "exist", "", "context", "Landroid/content/Context;", "init", "", "application", "Landroid/app/Application;", "order", "activity", "Landroid/app/Activity;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "pay", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "fragment", "Landroidx/fragment/app/Fragment;", "setting", "Companion", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayFacade.kt */
public final class FastPayFacade implements IFastPayFacade {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final FastPayFacade f22023b = new FastPayFacade();

    /* renamed from: a */
    private IFastPayProcessor f22024a = ((IFastPayProcessor) ServiceLoader.load(IFastPayProcessor.class).get());

    @JvmStatic
    public static final FastPayFacade getInstance() {
        return Companion.getInstance();
    }

    public void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
    }

    private FastPayFacade() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/facade/FastPayFacade$Companion;", "", "()V", "INS", "Lcom/didi/global/fintech/cashier/user/facade/FastPayFacade;", "getInstance", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayFacade.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FastPayFacade getInstance() {
            return FastPayFacade.f22023b;
        }
    }

    public FastPayCashierEnv cashierEnv() {
        IFastPayProcessor iFastPayProcessor = this.f22024a;
        if (iFastPayProcessor == null) {
            return null;
        }
        return iFastPayProcessor.cashierEnv();
    }

    public boolean exist(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GlobalCashierModuleManager globalCashierModuleManager = GlobalCashierModuleManager.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        return globalCashierModuleManager.getModule(applicationContext instanceof Application ? (Application) applicationContext : null, GlobalCashierModuleType.FastPay) != null;
    }

    public void setting(Activity activity, int i, FastPayParam fastPayParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fastPayParam, "param");
        IFastPayProcessor iFastPayProcessor = this.f22024a;
        if (iFastPayProcessor != null) {
            iFastPayProcessor.setting(activity, Integer.valueOf(i), fastPayParam);
        }
    }

    public void order(Activity activity, int i, FastPayParam fastPayParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fastPayParam, "param");
        IFastPayProcessor iFastPayProcessor = this.f22024a;
        if (iFastPayProcessor != null) {
            iFastPayProcessor.order(activity, Integer.valueOf(i), fastPayParam);
        }
    }

    public void pay(Activity activity, int i, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        IFastPayProcessor iFastPayProcessor = this.f22024a;
        if (iFastPayProcessor != null) {
            iFastPayProcessor.pay(activity, Integer.valueOf(i), cashierParam);
        }
    }

    public void pay(Fragment fragment, int i, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        IFastPayProcessor iFastPayProcessor = this.f22024a;
        if (iFastPayProcessor != null) {
            iFastPayProcessor.pay(fragment, Integer.valueOf(i), cashierParam);
        }
    }
}
