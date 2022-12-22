package com.didiglobal.p205sa.biz.tab.manager;

import com.didi.sdk.util.SaApolloUtil;
import com.didichuxing.apollo.sdk.Apollo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaTabUserCenterDemoteManager;", "", "()V", "hideUserCenter", "", "isFirstLoad", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabUserCenterDemoteManager */
/* compiled from: SaTabUserCenterDemoteManager.kt */
public final class SaTabUserCenterDemoteManager {
    public static final SaTabUserCenterDemoteManager INSTANCE = new SaTabUserCenterDemoteManager();

    /* renamed from: a */
    private static boolean f51244a = true;

    /* renamed from: b */
    private static boolean f51245b;

    private SaTabUserCenterDemoteManager() {
    }

    public final boolean hideUserCenter() {
        if (f51244a) {
            f51245b = Apollo.getToggle("sa_usercenter_demote").allow();
            f51244a = false;
        }
        SaApolloUtil.INSTANCE.setShowSaUserTab(!f51245b);
        return f51245b;
    }
}
