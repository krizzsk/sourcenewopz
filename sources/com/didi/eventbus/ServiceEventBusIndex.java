package com.didi.eventbus;

import com.didi.component.service.AbsServicePresenter;
import com.didi.component.service.HomeServiceNewPresenter;
import com.didi.component.service.SugServicePresenter;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

public class ServiceEventBusIndex implements SubscriberInfoIndex {

    /* renamed from: a */
    private static final Map<Class<?>, SubscriberInfo> f21070a = new HashMap();

    static {
        m15512a(new SimpleSubscriberInfo(HomeServiceNewPresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", CarInfoUpdateEvent.class, ThreadMode.MAIN)}));
        m15512a(new SimpleSubscriberInfo(AbsServicePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", CarInfoUpdateEvent.class, ThreadMode.MAIN)}));
        m15512a(new SimpleSubscriberInfo(SugServicePresenter.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", CarInfoUpdateEvent.class, ThreadMode.MAIN)}));
    }

    /* renamed from: a */
    private static void m15512a(SubscriberInfo subscriberInfo) {
        f21070a.put(subscriberInfo.getSubscriberClass(), subscriberInfo);
    }

    public SubscriberInfo getSubscriberInfo(Class<?> cls) {
        SubscriberInfo subscriberInfo = f21070a.get(cls);
        if (subscriberInfo != null) {
            return subscriberInfo;
        }
        return null;
    }
}
