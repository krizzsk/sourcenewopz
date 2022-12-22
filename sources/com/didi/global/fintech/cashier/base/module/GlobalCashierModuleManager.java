package com.didi.global.fintech.cashier.base.module;

import android.app.Application;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/base/module/GlobalCashierModuleManager;", "", "()V", "moduleInstances", "", "Lcom/didi/global/fintech/cashier/base/module/GlobalCashierModuleType;", "Lcom/didi/global/fintech/cashier/base/module/BaseGlobalCashierModule;", "getModule", "application", "Landroid/app/Application;", "moduleType", "modulePath", "", "type", "cashier_base_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierModuleManager.kt */
public final class GlobalCashierModuleManager {
    public static final GlobalCashierModuleManager INSTANCE = new GlobalCashierModuleManager();

    /* renamed from: a */
    private static final Map<GlobalCashierModuleType, BaseGlobalCashierModule> f21409a = new LinkedHashMap();

    private GlobalCashierModuleManager() {
    }

    /* renamed from: a */
    private final String m15718a(GlobalCashierModuleType globalCashierModuleType) {
        StringBuilder sb = new StringBuilder();
        sb.append("com.didi.global.fintech.cashier.");
        String name = globalCashierModuleType.name();
        if (name != null) {
            String lowerCase = name.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append(".GlobalCashier");
            sb.append(globalCashierModuleType.name());
            sb.append("Module");
            return sb.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final BaseGlobalCashierModule getModule(Application application, GlobalCashierModuleType globalCashierModuleType) {
        Object obj;
        ClassLoader classLoader;
        Class loadClass;
        Intrinsics.checkNotNullParameter(globalCashierModuleType, "moduleType");
        if (!f21409a.containsKey(globalCashierModuleType)) {
            Map<GlobalCashierModuleType, BaseGlobalCashierModule> map = f21409a;
            BaseGlobalCashierModule baseGlobalCashierModule = null;
            if (application == null || (classLoader = application.getClassLoader()) == null || (loadClass = classLoader.loadClass(m15718a(globalCashierModuleType))) == null) {
                obj = null;
            } else {
                obj = loadClass.newInstance();
            }
            if (obj instanceof BaseGlobalCashierModule) {
                baseGlobalCashierModule = (BaseGlobalCashierModule) obj;
            }
            map.put(globalCashierModuleType, baseGlobalCashierModule);
        }
        return f21409a.get(globalCashierModuleType);
    }
}
