package com.didi.eventbus;

import android.util.Pair;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.app.BizManager;
import com.didi.sdk.app.mainactivitydelegate.MainLawPopActivityDelegate;
import com.didi.sdk.events.CustomerDataStatus;
import com.didi.sdk.events.FusionTitlebarRightClickEvent;
import com.didi.sdk.events.FusionTitlebarRightTextEvent;
import com.didi.sdk.events.IMRefreshEvent;
import com.didi.sdk.events.OpenSideBarPageEvent;
import com.didi.sdk.events.RedDotStatusChangedEvent;
import com.didi.sdk.events.RedDotStatusEvent;
import com.didi.sdk.events.RemotionalMessageEvent;
import com.didi.sdk.events.SettingsLoadingEvent;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.home.view.HomeNewTitleBarFragment;
import com.didi.sdk.misconfig.MisConfigInitializationer;
import com.didi.sdk.misconfig.MisDataReceiver;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.p146ad.event.AdEvent;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.component.SidebarItemComponent;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.sidebar.templet.BottomTitleFragment;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.webview.WebActivity;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SimpleSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

public class GlobalSdkEventBusIndex implements SubscriberInfoIndex {

    /* renamed from: a */
    private static final Map<Class<?>, SubscriberInfo> f21067a = new HashMap();

    static {
        m15509a(new SimpleSubscriberInfo(MainLawPopActivityDelegate.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", CarInfoUpdateEvent.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(HomeNewTitleBarFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("isShowRedDot", RedDotStatusEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("showMessage", RemotionalMessageEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("dismissCustomerMessage", CustomerDataStatus.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(SidebarItemComponent.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("refreshIM", IMRefreshEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("showRedDot", RedDotStatusEvent.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(BottomTitleFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onLoadingRequested", SettingsLoadingEvent.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(MisDataReceiver.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", CarInfoUpdateEvent.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(BaseMainActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onAdEvent", AdEvent.class, ThreadMode.MAIN, 0, true)}));
        m15509a(new SimpleSubscriberInfo(DataContainer.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", RedDotStatusChangedEvent.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(MisConfigInitializationer.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", Pair.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(WebActivity.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", FusionTitlebarRightTextEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onReceive", FusionTitlebarRightClickEvent.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(HomeNavDrawerFragment.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo(EventKeys.Sidebar.OPEN_SIDEBAR, SidebarEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo(EventKeys.Sidebar.CLOSE_SIDEBAR, SidebarEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo(EventKeys.Sidebar.REFRESH_SIDEBAR, SidebarPage.class, ThreadMode.MAIN)}));
        m15509a(new SimpleSubscriberInfo(BizManager.class, true, new SubscriberMethodInfo[]{new SubscriberMethodInfo("onReceive", CarInfoUpdateEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onSwitchType", SwitchTypeEvent.class, ThreadMode.MAIN), new SubscriberMethodInfo("onSideBarPageRequested", OpenSideBarPageEvent.class, ThreadMode.MAIN)}));
    }

    /* renamed from: a */
    private static void m15509a(SubscriberInfo subscriberInfo) {
        f21067a.put(subscriberInfo.getSubscriberClass(), subscriberInfo);
    }

    public SubscriberInfo getSubscriberInfo(Class<?> cls) {
        SubscriberInfo subscriberInfo = f21067a.get(cls);
        if (subscriberInfo != null) {
            return subscriberInfo;
        }
        return null;
    }
}
