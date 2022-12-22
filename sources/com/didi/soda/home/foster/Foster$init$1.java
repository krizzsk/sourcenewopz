package com.didi.soda.home.foster;

import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Foster.kt */
final class Foster$init$1 extends Lambda implements Function0<Unit> {
    public static final Foster$init$1 INSTANCE = new Foster$init$1();

    Foster$init$1() {
        super(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Map m46958invoke$lambda0() {
        return CustomerServiceHelper.getRegisterService();
    }

    public final void invoke() {
        CustomerServiceManager.init($$Lambda$Foster$init$1$saW7z_nwsfpBw9YEMqGBb71qZQw.INSTANCE);
        SkinUtil.initSkinConfig();
    }
}
