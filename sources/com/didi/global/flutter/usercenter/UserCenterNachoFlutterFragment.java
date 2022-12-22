package com.didi.global.flutter.usercenter;

import android.app.Activity;
import android.os.Bundle;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMSessionMessageListener;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.flutter.nacho.NachoFlutterFragment;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.events.IMRefreshEvent;
import com.didi.sdk.oneconf.OneConfData;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.sidebar.account.store.AccountStore;
import com.didi.sdk.sidebar.compatible.MsgAndEventUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.usercenter.api.UserCenterFacade;
import com.didiglobal.usercenter.pax_usercenter_module.PaxUsercenterModulePlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import p242io.flutter.plugin.common.MethodChannel;

public class UserCenterNachoFlutterFragment extends NachoFlutterFragment {

    /* renamed from: a */
    MethodChannel f22031a;

    /* renamed from: b */
    LoginListeners.LoginListener f22032b = new LoginListeners.LoginListener() {
        public void onCancel() {
        }

        public void onSuccess(Activity activity, String str) {
            if (UserCenterNachoFlutterFragment.this.f22031a != null) {
                UserCenterNachoFlutterFragment.this.f22031a.invokeMethod("updateProfile", (Object) null);
                UserCenterNachoFlutterFragment.this.f22031a.invokeMethod("updateDefaultData", (Object) null);
            }
        }
    };

    /* renamed from: c */
    LoginListeners.LoginOutListener f22033c = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            UserCenterFacade.getIns().clearUserInfo(UserCenterNachoFlutterFragment.this.getContext());
            if (UserCenterNachoFlutterFragment.this.f22031a != null) {
                UserCenterNachoFlutterFragment.this.f22031a.invokeMethod("updateProfile", (Object) null);
            }
        }
    };

    /* renamed from: e */
    private long f22034e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f22035f = OneConfStore.getInstance().getCityId();

    /* renamed from: g */
    private OneConfStore.OneConfConfigChangeListener f22036g = new OneConfStore.OneConfConfigChangeListener() {
        public void onChanged(OneConfData oneConfData, double d, double d2) {
            if (oneConfData != null && oneConfData.cityId != UserCenterNachoFlutterFragment.this.f22035f) {
                int unused = UserCenterNachoFlutterFragment.this.f22035f = oneConfData.cityId;
                if (UserCenterNachoFlutterFragment.this.f22031a != null) {
                    UserCenterNachoFlutterFragment.this.f22031a.invokeMethod("refreshUserCenterPage", (Object) null);
                }
            }
        }
    };

    /* renamed from: h */
    private IMSessionMessageListener f22037h = new IMSessionMessageListener() {
        public void onSessionMessageArrive(Set<Long> set) {
            UserCenterNachoFlutterFragment.this.m15970c();
        }
    };

    public void onResume() {
        super.onResume();
        GlobalOmegaUtils.trackEvent("ibt_gp_sa_account_page_sw", (Map<String, Object>) new HashMap());
        this.f22034e = System.currentTimeMillis();
        MethodChannel methodChannel = this.f22031a;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshUserCenterPage", (Object) null);
            this.f22031a.invokeMethod("onResume", (Object) null);
        }
        m15970c();
    }

    public void onPause() {
        super.onPause();
        m15968a(System.currentTimeMillis() - this.f22034e);
    }

    /* renamed from: a */
    private void m15968a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put(RavenKey.VERSION, "staytime");
        hashMap.put("time", Long.valueOf(j));
        GlobalOmegaUtils.trackEvent("ibt_gp_sa_account_page_time_sw", (Map<String, Object>) hashMap);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            m15968a(System.currentTimeMillis() - this.f22034e);
            OneConfStore.getInstance().removeOneConfChangeListener(this.f22036g);
            return;
        }
        this.f22034e = System.currentTimeMillis();
        GlobalOmegaUtils.putGlobal("g_PageId", "sa_account");
        OneConfStore.getInstance().addOneConfChangeListener(this.f22036g);
        MethodChannel methodChannel = this.f22031a;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshUserCenterPage", (Object) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaxUsercenterModulePlugin paxUsercenterModulePlugin = (PaxUsercenterModulePlugin) getFlutterEngine().getPlugins().get(PaxUsercenterModulePlugin.class);
        if (paxUsercenterModulePlugin != null) {
            this.f22031a = paxUsercenterModulePlugin.channel;
        }
        OneLoginFacade.getFunction().addLoginListener(this.f22032b);
        OneLoginFacade.getFunction().addLoginOutListener(this.f22033c);
        AccountStore.getInstance().register(this);
        EventBus.getDefault().register(this);
        GlobalOmegaUtils.putGlobal("g_PageId", "sa_account");
        IMEngine.getInstance(getContext());
        IMEngine.addSessionMessageListener(this.f22037h);
        OneConfStore.getInstance().addOneConfChangeListener(this.f22036g);
    }

    public void onDestroy() {
        super.onDestroy();
        OneLoginFacade.getFunction().removeLoginListener(this.f22032b);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f22033c);
        AccountStore.getInstance().unregister(this);
        EventBus.getDefault().unregister(this);
        IMEngine.getInstance(getContext());
        IMEngine.removeSessionMessageListener(this.f22037h);
        OneConfStore.getInstance().removeOneConfChangeListener(this.f22036g);
    }

    @EventReceiver
    public void onReceive(DefaultEvent defaultEvent) {
        MethodChannel methodChannel;
        if (defaultEvent != null && UserCenterFacade.getIns().getUserInfo(getContext()) != null) {
            int i = MsgAndEventUtil.EventToMsg(defaultEvent).what;
            String type = defaultEvent.getType();
            char c = 65535;
            int hashCode = type.hashCode();
            if (hashCode != -619521077) {
                if (hashCode == 2110813523 && type.equals(AccountStore.ACTION_MODIFY_ALL_INFO)) {
                    c = 0;
                }
            } else if (type.equals(AccountStore.ACTION_MODIFY_USERAVATAR)) {
                c = 1;
            }
            if ((c == 0 || c == 1) && i == 1 && (methodChannel = this.f22031a) != null) {
                methodChannel.invokeMethod("updateProfile", (Object) null);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(IMRefreshEvent iMRefreshEvent) {
        m15970c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15970c() {
        IMEngine.getAllUnreadMessageCount(new IMSessionUnreadCallback() {
            public void unReadCount(int i) {
                if (UserCenterNachoFlutterFragment.this.f22031a != null) {
                    UserCenterNachoFlutterFragment.this.f22031a.invokeMethod("updateIMRedPoint", Integer.valueOf(i));
                }
            }
        });
    }
}
