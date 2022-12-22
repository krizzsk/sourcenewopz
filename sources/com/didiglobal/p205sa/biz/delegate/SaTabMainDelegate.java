package com.didiglobal.p205sa.biz.delegate;

import androidx.fragment.app.Fragment;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.sdk.app.business.ISaTabDelegate;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.p205sa.biz.fragment.SuperAppMainFragment;
import com.didiglobal.p205sa.biz.util.BaseEventKeys;
import kotlin.Metadata;

@ServiceProvider(alias = "tab_home", value = {ISaTabDelegate.class})
@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/delegate/SaTabMainDelegate;", "Lcom/didi/sdk/app/business/ISaTabDelegate;", "()V", "canSwitch", "", "getFragment", "Landroidx/fragment/app/Fragment;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.delegate.SaTabMainDelegate */
/* compiled from: SaTabMainDelegate.kt */
public final class SaTabMainDelegate implements ISaTabDelegate {
    public Fragment getFragment() {
        return new SuperAppMainFragment();
    }

    public boolean canSwitch() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SA_Panel.EVENT_HOME_PANEL_SCROLL_TOP);
        return true;
    }
}
