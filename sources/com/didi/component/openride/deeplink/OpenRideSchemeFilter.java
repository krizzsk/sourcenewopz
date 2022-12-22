package com.didi.component.openride.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.OpenRideDeepLinkEvent;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.List;

@ServiceProvider({AbsSchemeDispatcherFilter.class})
public class OpenRideSchemeFilter extends AbsSchemeDispatcherFilter {
    public static final String OPEN_RIDE_99_SCHEME = "taxis99onetravel";
    public static final String OPEN_RIDE_GLOBAL_SCHEME = "globalOneTravel";
    public static final String OPEN_RIDE_HOST = "guarana";
    public static final String OPEN_RIDE_KEY_DRIVER_CODE = "driverCode";
    public static final String OPEN_RIDE_PATH = "/openRide";

    /* renamed from: a */
    private static final String f14722a = "OpenRideSchemeFilter";

    public boolean doFilter(Intent intent, SchemeDispatcher schemeDispatcher) {
        if (!isComeFromOpenRide(intent)) {
            return false;
        }
        Uri data = intent.getData();
        if (m10525a()) {
            m10526b(BaseEventKeys.OpenRide.EVENT_HAND_OPEN_RIDE_DEEP_LINK, m10522a(data));
        } else {
            m10524a(BaseEventKeys.OpenRide.EVENT_HAND_OPEN_RIDE_DEEP_LINK, (Object) m10522a(data));
            tryToStartMainActivity(schemeDispatcher);
        }
        schemeDispatcher.finish();
        return true;
    }

    /* renamed from: a */
    private boolean m10525a() {
        return ActivityLifecycleManager.getInstance().isMainActivityRunning();
    }

    public static boolean isComeFromOpenRide(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return false;
        }
        if (OPEN_RIDE_99_SCHEME.equalsIgnoreCase(data.getScheme()) || "globalOneTravel".equalsIgnoreCase(data.getScheme())) {
            String host = data.getHost();
            String path = data.getPath();
            if (!"guarana".equalsIgnoreCase(host) || !OPEN_RIDE_PATH.equalsIgnoreCase(path)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private OpenRideDeepLinkEvent m10522a(Uri uri) {
        FormStore.getInstance().setDriverCode(NumberUtil.parseInt(m10523a(uri, OPEN_RIDE_KEY_DRIVER_CODE)));
        FormStore.getInstance().setIsFromOpenRide(true);
        FormStore.getInstance().setIsOpenRideFromDeepLink(true);
        return new OpenRideDeepLinkEvent(uri);
    }

    /* renamed from: a */
    private String m10523a(Uri uri, String str) {
        String str2;
        try {
            List<String> queryParameters = uri.getQueryParameters(str);
            if (queryParameters == null || queryParameters.isEmpty()) {
                str2 = "";
            } else {
                str2 = queryParameters.get(queryParameters.size() - 1);
            }
            if ("null".equalsIgnoreCase(str2)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private void m10524a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            BaseEventPublisher.getPublisher().publishSticky(str, obj);
        }
    }

    /* renamed from: b */
    private void m10526b(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            BaseEventPublisher.getPublisher().publish(str, obj);
        }
    }
}
