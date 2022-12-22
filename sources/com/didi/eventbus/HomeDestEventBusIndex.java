package com.didi.eventbus;

import com.didi.component.homedestination.newversion.p102b.HomeDestinationNewPlanBPresenter;
import com.didi.sdk.sidebar.SidebarEvent;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

public class HomeDestEventBusIndex implements SubscriberInfoIndex {

    /* renamed from: a */
    private static final Map<Class<?>, SubscriberInfo> f21068a = new HashMap();

    static {
        m15510a(new SimpleSubscriberInfo(HomeDestinationNewPlanBPresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onSidebarOpened", SidebarEvent.class, ThreadMode.MAIN)}));
    }

    /* renamed from: a */
    private static void m15510a(SubscriberInfo subscriberInfo) {
        f21068a.put(subscriberInfo.getSubscriberClass(), subscriberInfo);
    }

    public SubscriberInfo getSubscriberInfo(Class<?> cls) {
        SubscriberInfo subscriberInfo = f21068a.get(cls);
        if (subscriberInfo != null) {
            return subscriberInfo;
        }
        return null;
    }
}
