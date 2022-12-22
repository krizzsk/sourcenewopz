package com.didi.global.fintech.cashier.threeds.spi;

import android.content.Context;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.global.fintech.cashier.threeds.GlobalCashierThreeDSModule;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.ICashierFacade;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import global.didi.pay.threeds.contract.ICybs3DSConfig;
import kotlin.Metadata;

@ServiceProvider(alias = "cashier", value = {ICybs3DSConfig.class})
@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/spi/Cybs3DSConfig;", "Lglobal/didi/pay/threeds/contract/ICybs3DSConfig;", "()V", "appVersion", "", "context", "Landroid/content/Context;", "sdkVersion", "terminalId", "testEnv", "", "(Landroid/content/Context;)Ljava/lang/Boolean;", "token", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DSConfig.kt */
public final class Cybs3DSConfig implements ICybs3DSConfig {
    public String token(Context context) {
        if (context == null) {
            return null;
        }
        return CashierFacade.Companion.getInstance().getInitConfig().getToken();
    }

    public String appVersion(Context context) {
        if (context == null) {
            return null;
        }
        return SystemUtil.getVersionName(context);
    }

    public String terminalId(Context context) {
        return CashierFacade.Companion.getInstance().getInitConfig().getTerminalID();
    }

    public String sdkVersion(Context context) {
        if (context == null) {
            return null;
        }
        return CashierFacade.Companion.getInstance().getParamByModuleSync(GlobalCashierModuleType.Core, GlobalCashierCoreModule.META_DATA, ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.ThreeDS, GlobalCashierThreeDSModule.THREEDS_SDK_VERSION_NAME, (String) null, 4, (Object) null));
    }

    public Boolean testEnv(Context context) {
        return Boolean.valueOf(Boolean.parseBoolean(CashierFacade.Companion.getInstance().getParamByModuleSync(GlobalCashierModuleType.Core, GlobalCashierCoreModule.APOLLO, "cybs_test_env")));
    }
}
