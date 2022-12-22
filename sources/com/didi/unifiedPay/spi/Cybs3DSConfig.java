package com.didi.unifiedPay.spi;

import android.content.Context;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifiedPay.util.ABTestProxyHolder;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didi.unifiedPay.util.UnipayAppUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import global.didi.pay.threeds.contract.ICybs3DSConfig;
import kotlin.Metadata;

@ServiceProvider(alias = "globalapi", value = {ICybs3DSConfig.class})
@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/unifiedPay/spi/Cybs3DSConfig;", "Lglobal/didi/pay/threeds/contract/ICybs3DSConfig;", "()V", "appVersion", "", "context", "Landroid/content/Context;", "sdkVersion", "terminalId", "testEnv", "", "(Landroid/content/Context;)Ljava/lang/Boolean;", "token", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DSConfig.kt */
public final class Cybs3DSConfig implements ICybs3DSConfig {
    public String token(Context context) {
        if (context == null) {
            return null;
        }
        return UniPayParamUtil.getToken(context);
    }

    public String appVersion(Context context) {
        if (context == null) {
            return null;
        }
        return SystemUtil.getVersionName(context);
    }

    public String terminalId(Context context) {
        if (context == null) {
            return null;
        }
        return String.valueOf(UniPayParamUtil.getTerminalId(context));
    }

    public String sdkVersion(Context context) {
        if (context == null) {
            return null;
        }
        return UnipayAppUtil.getMetaDataByKey(context, "global.didi.pay.threeds.sdk.version");
    }

    public Boolean testEnv(Context context) {
        return Boolean.valueOf(ABTestProxyHolder.getStatus("cybs_test_env", false));
    }
}
