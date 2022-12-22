package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u000f\u001a\u00020\u00102\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00100\u0012j\u0002`\u00132\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00100\u0012j\u0002`\u00132\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00100\u0012j\u0002`\u0013J\u0010\u0010\u0016\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bJG\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00182#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00100\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/FreezeInterceptor;", "", "()V", "FREEZE_5K_STATUS", "", "FREEZE_ALL_INTERCEPTOR", "FREEZE_NORMAL_STATUS", "FREEZE_PERMANENT_STATUS", "FREEZE_TEMP_PERMANENT_INTERCEPTOR", "FREEZE_TEMP_STATUS", "freezeInfo", "Lcom/didi/payment/commonsdk/basemodel/account/AccountFreezeData;", "strategyMap", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/IFreezeStrategy;", "dispatchClickEvent", "", "normal", "Lkotlin/Function0;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/NoneClick;", "freeze5K", "permanent", "init", "onInterceptor", "", "context", "Landroid/content/Context;", "interceptorType", "isJump", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "status", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.FreezeInterceptor */
/* compiled from: FreezeInterceptor.kt */
public final class FreezeInterceptor {
    public static final int FREEZE_5K_STATUS = 3;
    public static final int FREEZE_ALL_INTERCEPTOR = 1;
    public static final int FREEZE_NORMAL_STATUS = 0;
    public static final int FREEZE_PERMANENT_STATUS = 2;
    public static final int FREEZE_TEMP_PERMANENT_INTERCEPTOR = 2;
    public static final int FREEZE_TEMP_STATUS = 1;
    public static final FreezeInterceptor INSTANCE = new FreezeInterceptor();

    /* renamed from: a */
    private static final Map<Integer, IFreezeStrategy> f32773a;

    /* renamed from: b */
    private static AccountFreezeData f32774b;

    private FreezeInterceptor() {
    }

    static {
        Map<Integer, IFreezeStrategy> linkedHashMap = new LinkedHashMap<>();
        f32773a = linkedHashMap;
        linkedHashMap.put(1, new AllFreezeStrategy());
        f32773a.put(2, new TempAndPermanentFreezeStrategy());
    }

    public final void init(AccountFreezeData accountFreezeData) {
        f32774b = accountFreezeData;
    }

    public static /* synthetic */ boolean onInterceptor$default(FreezeInterceptor freezeInterceptor, Context context, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return freezeInterceptor.onInterceptor(context, i, z, function1);
    }

    public final boolean onInterceptor(Context context, int i, boolean z, Function1<? super Integer, Unit> function1) {
        boolean z2;
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!(context instanceof Activity)) {
            if (context != null) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
            }
        }
        IFreezeStrategy iFreezeStrategy = f32773a.get(Integer.valueOf(i));
        Integer num = null;
        if (iFreezeStrategy == null) {
            z2 = false;
        } else {
            AccountFreezeData accountFreezeData = f32774b;
            z2 = iFreezeStrategy.executeStrategy(accountFreezeData == null ? null : Integer.valueOf(accountFreezeData.freezeStatus));
        }
        if (z && z2) {
            ((Request) DRouter.build("99pay://one/freeze/dialog").putExtra("key", (Serializable) f32774b)).start(context);
        }
        if (!z2) {
            AccountFreezeData accountFreezeData2 = f32774b;
            if (accountFreezeData2 != null) {
                num = Integer.valueOf(accountFreezeData2.freezeStatus);
            }
            function1.invoke(num);
        }
        return z2;
    }

    public static /* synthetic */ void dispatchClickEvent$default(FreezeInterceptor freezeInterceptor, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = FreezeInterceptor$dispatchClickEvent$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function02 = FreezeInterceptor$dispatchClickEvent$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function03 = FreezeInterceptor$dispatchClickEvent$3.INSTANCE;
        }
        freezeInterceptor.dispatchClickEvent(function0, function02, function03);
    }

    public final void dispatchClickEvent(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        boolean z;
        Intrinsics.checkNotNullParameter(function0, "normal");
        Intrinsics.checkNotNullParameter(function02, "freeze5K");
        Intrinsics.checkNotNullParameter(function03, "permanent");
        AccountFreezeData accountFreezeData = f32774b;
        Integer valueOf = accountFreezeData == null ? null : Integer.valueOf(accountFreezeData.freezeStatus);
        boolean z2 = false;
        if (valueOf == null || valueOf.intValue() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            function0.invoke();
            return;
        }
        if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2)) {
            z2 = true;
        }
        if (z2) {
            function03.invoke();
        } else if (valueOf != null && valueOf.intValue() == 3) {
            function02.invoke();
        }
    }
}
