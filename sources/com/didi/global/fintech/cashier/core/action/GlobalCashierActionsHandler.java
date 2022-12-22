package com.didi.global.fintech.cashier.core.action;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J'\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0005H\u0002¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R$\u0010\u0003\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/action/GlobalCashierActionsHandler;", "", "()V", "handlers", "", "Ljava/lang/Class;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierBaseActionHandler;", "handleAction", "", "context", "Landroid/content/Context;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "uniqueId", "", "handler", "T", "clazz", "(Ljava/lang/Class;)Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierBaseActionHandler;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierActionsHandler.kt */
public final class GlobalCashierActionsHandler {
    public static final GlobalCashierActionsHandler INSTANCE = new GlobalCashierActionsHandler();

    /* renamed from: a */
    private static final Map<Class<? extends IGlobalCashierBaseActionHandler>, IGlobalCashierBaseActionHandler> f21420a;

    private GlobalCashierActionsHandler() {
    }

    static {
        Map<Class<? extends IGlobalCashierBaseActionHandler>, IGlobalCashierBaseActionHandler> linkedHashMap = new LinkedHashMap<>();
        f21420a = linkedHashMap;
        linkedHashMap.put(IGlobalCashierPixActionHandler.class, ServiceLoader.load(IGlobalCashierPixActionHandler.class).get());
        f21420a.put(IGlobalCashier3DSActionHandler.class, ServiceLoader.load(IGlobalCashier3DSActionHandler.class).get());
        f21420a.put(IGlobalCashier3DSV2ActionHandler.class, ServiceLoader.load(IGlobalCashier3DSV2ActionHandler.class).get());
        f21420a.put(IGlobalCashierRandomVerifyActionHandler.class, ServiceLoader.load(IGlobalCashierRandomVerifyActionHandler.class).get());
        f21420a.put(IGlobalCashierUpdateCardInfoActionHandler.class, ServiceLoader.load(IGlobalCashierUpdateCardInfoActionHandler.class).get());
        f21420a.put(IGlobalCashierPasswordActionHandler.class, ServiceLoader.load(IGlobalCashierPasswordActionHandler.class).get());
        f21420a.put(IGlobalCashierTopUpActionHandler.class, ServiceLoader.load(IGlobalCashierTopUpActionHandler.class).get());
        f21420a.put(IGlobalCashierSignUpActionHandler.class, ServiceLoader.load(IGlobalCashierSignUpActionHandler.class).get());
        f21420a.put(IGlobalCashierAddCardActionHandler.class, ServiceLoader.load(IGlobalCashierAddCardActionHandler.class).get());
        f21420a.put(IGlobalCashierConfirmPayActionHandler.class, ServiceLoader.load(IGlobalCashierConfirmPayActionHandler.class).get());
        f21420a.put(IGlobalCashierOpenUrlActionHandler.class, ServiceLoader.load(IGlobalCashierOpenUrlActionHandler.class).get());
        f21420a.put(IGlobalCashierCloseCashierActionHandler.class, ServiceLoader.load(IGlobalCashierCloseCashierActionHandler.class).get());
    }

    /* renamed from: a */
    private final <T extends IGlobalCashierBaseActionHandler> T m15724a(Class<T> cls) {
        T t = f21420a.get(cls);
        if (t instanceof IGlobalCashierBaseActionHandler) {
            return (IGlobalCashierBaseActionHandler) t;
        }
        return null;
    }

    public final void onDestroy() {
        for (IGlobalCashierBaseActionHandler iGlobalCashierBaseActionHandler : f21420a.values()) {
            if (iGlobalCashierBaseActionHandler != null) {
                iGlobalCashierBaseActionHandler.onDestroy();
            }
        }
    }

    public final boolean handleAction(Context context, CashierAction cashierAction, CashierParam cashierParam, String str) {
        IGlobalCashierAddCardActionHandler iGlobalCashierAddCardActionHandler;
        IGlobalCashierTopUpActionHandler iGlobalCashierTopUpActionHandler;
        IGlobalCashierUpdateCardInfoActionHandler iGlobalCashierUpdateCardInfoActionHandler;
        IGlobalCashierOpenUrlActionHandler iGlobalCashierOpenUrlActionHandler;
        IGlobalCashierCloseCashierActionHandler iGlobalCashierCloseCashierActionHandler;
        IGlobalCashierPixActionHandler iGlobalCashierPixActionHandler;
        IGlobalCashierConfirmPayActionHandler iGlobalCashierConfirmPayActionHandler;
        IGlobalCashier3DSV2ActionHandler iGlobalCashier3DSV2ActionHandler;
        IGlobalCashierPasswordActionHandler iGlobalCashierPasswordActionHandler;
        IGlobalCashier3DSActionHandler iGlobalCashier3DSActionHandler;
        IGlobalCashierSignUpActionHandler iGlobalCashierSignUpActionHandler;
        IGlobalCashierRandomVerifyActionHandler iGlobalCashierRandomVerifyActionHandler;
        Intrinsics.checkNotNullParameter(context, "context");
        String action = cashierAction == null ? null : cashierAction.getAction();
        if (action == null) {
            return false;
        }
        switch (action.hashCode()) {
            case -1236338706:
                if (action.equals("add_card") && (iGlobalCashierAddCardActionHandler = (IGlobalCashierAddCardActionHandler) m15724a(IGlobalCashierAddCardActionHandler.class)) != null) {
                    return iGlobalCashierAddCardActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case -868043323:
                if (action.equals(CashierAction.ACTION_TOP_UP) && (iGlobalCashierTopUpActionHandler = (IGlobalCashierTopUpActionHandler) m15724a(IGlobalCashierTopUpActionHandler.class)) != null) {
                    return iGlobalCashierTopUpActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case -716466041:
                if (action.equals(CashierAction.ACTION_UPDATE_CARD_INFO) && (iGlobalCashierUpdateCardInfoActionHandler = (IGlobalCashierUpdateCardInfoActionHandler) m15724a(IGlobalCashierUpdateCardInfoActionHandler.class)) != null) {
                    return iGlobalCashierUpdateCardInfoActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case -504306182:
                if (action.equals(CashierAction.ACTION_OPEN_URL) && (iGlobalCashierOpenUrlActionHandler = (IGlobalCashierOpenUrlActionHandler) m15724a(IGlobalCashierOpenUrlActionHandler.class)) != null) {
                    return iGlobalCashierOpenUrlActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case -194480260:
                if (action.equals(CashierAction.ACTION_CLOSE_CASHIER) && (iGlobalCashierCloseCashierActionHandler = (IGlobalCashierCloseCashierActionHandler) m15724a(IGlobalCashierCloseCashierActionHandler.class)) != null) {
                    return iGlobalCashierCloseCashierActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case -148840307:
                if (action.equals(CashierAction.ACTION_PIX_CODE) && (iGlobalCashierPixActionHandler = (IGlobalCashierPixActionHandler) m15724a(IGlobalCashierPixActionHandler.class)) != null) {
                    return iGlobalCashierPixActionHandler.handle((FragmentActivity) context, cashierAction, cashierParam, str);
                }
                return false;
            case 344745641:
                if (action.equals(CashierAction.ACTION_CONFIRM_PAY) && (iGlobalCashierConfirmPayActionHandler = (IGlobalCashierConfirmPayActionHandler) m15724a(IGlobalCashierConfirmPayActionHandler.class)) != null) {
                    return iGlobalCashierConfirmPayActionHandler.handle((FragmentActivity) context, cashierAction, cashierParam, str);
                }
                return false;
            case 1047511627:
                if (action.equals(CashierAction.ACTION_THREE_DS_V2) && (iGlobalCashier3DSV2ActionHandler = (IGlobalCashier3DSV2ActionHandler) m15724a(IGlobalCashier3DSV2ActionHandler.class)) != null) {
                    return iGlobalCashier3DSV2ActionHandler.handle((FragmentActivity) context, cashierAction, cashierParam, str);
                }
                return false;
            case 1216985755:
                if (action.equals(CashierAction.ACTION_PASSWORD) && (iGlobalCashierPasswordActionHandler = (IGlobalCashierPasswordActionHandler) m15724a(IGlobalCashierPasswordActionHandler.class)) != null) {
                    return iGlobalCashierPasswordActionHandler.handle((FragmentActivity) context, cashierAction, cashierParam);
                }
                return false;
            case 1473740496:
                if (action.equals(CashierAction.ACTION_THREE_DS) && (iGlobalCashier3DSActionHandler = (IGlobalCashier3DSActionHandler) m15724a(IGlobalCashier3DSActionHandler.class)) != null) {
                    return iGlobalCashier3DSActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case 2088263773:
                if (action.equals("sign_up") && (iGlobalCashierSignUpActionHandler = (IGlobalCashierSignUpActionHandler) m15724a(IGlobalCashierSignUpActionHandler.class)) != null) {
                    return iGlobalCashierSignUpActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case 2092584821:
                if (action.equals(CashierAction.ACTION_RANDOM_VERIFY) && (iGlobalCashierRandomVerifyActionHandler = (IGlobalCashierRandomVerifyActionHandler) m15724a(IGlobalCashierRandomVerifyActionHandler.class)) != null) {
                    return iGlobalCashierRandomVerifyActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            default:
                return false;
        }
    }
}
