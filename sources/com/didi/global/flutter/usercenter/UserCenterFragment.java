package com.didi.global.flutter.usercenter;

import androidx.fragment.app.Fragment;
import com.didi.flutter.nacho.NachoFlutterFragment;
import com.didi.global.flutter.linker.FlutterApplicationDelegate;
import com.didi.sdk.app.business.ISaTabDelegate;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import p242io.flutter.embedding.android.FlutterFragment2;

@ServiceProvider(alias = "tab_user", value = {ISaTabDelegate.class})
public class UserCenterFragment implements ISaTabDelegate {

    /* renamed from: a */
    private Fragment f22030a;

    public boolean canSwitch() {
        return true;
    }

    public Fragment getFragment() {
        FlutterFragment2 build = NachoFlutterFragment.withCachedEngine(UserCenterNachoFlutterFragment.class).engineId(FlutterApplicationDelegate.USER_CENTER_ENGINE_ID).params((HashMap) null).initialRoute("/usercenter_page").build();
        this.f22030a = build;
        return build;
    }
}
