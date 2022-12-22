package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.account.EditAccountFragment;
import com.didi.sdk.util.EventKeys;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.d */
/* compiled from: SelfCenterDeepLink */
class C4628d implements INewActivityDeepLink {
    C4628d() {
    }

    public void deepLink(Activity activity, Uri uri) {
        BaseBusinessContext curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext();
        if (curBusinessContext != null) {
            Intent intent = new Intent(activity, EditAccountFragment.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("page", "account");
            bundle.putCharSequence("level", "level1");
            intent.putExtras(bundle);
            curBusinessContext.getNavigation().transition(curBusinessContext, intent);
            EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
        }
    }
}
