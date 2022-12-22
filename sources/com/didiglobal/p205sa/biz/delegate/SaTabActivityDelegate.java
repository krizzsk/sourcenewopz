package com.didiglobal.p205sa.biz.delegate;

import androidx.fragment.app.Fragment;
import com.didi.sdk.app.business.ISaTabDelegate;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.p205sa.biz.fragment.SuperAppActivityFragment;
import kotlin.Metadata;

@ServiceProvider(alias = "tab_activity", value = {ISaTabDelegate.class})
@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/delegate/SaTabActivityDelegate;", "Lcom/didi/sdk/app/business/ISaTabDelegate;", "()V", "canSwitch", "", "getFragment", "Landroidx/fragment/app/Fragment;", "isLoginNow", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.delegate.SaTabActivityDelegate */
/* compiled from: SaTabActivityDelegate.kt */
public final class SaTabActivityDelegate implements ISaTabDelegate {
    public Fragment getFragment() {
        return new SuperAppActivityFragment();
    }

    public boolean canSwitch() {
        if (!m36677a()) {
            NationTypeUtil.getNationComponentData().getLoginAction().go2Login();
        }
        return m36677a();
    }

    /* renamed from: a */
    private final boolean m36677a() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
    }
}
