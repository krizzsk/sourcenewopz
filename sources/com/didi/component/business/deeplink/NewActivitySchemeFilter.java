package com.didi.component.business.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.deeplink.jumpstrategy.DeepLinkManage;
import com.didi.component.business.event.ActivityDeepLinkEvent;
import com.didi.component.business.event.BaseDeepLinkEvent;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.DidiLoadDexActivity;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({AbsSchemeDispatcherFilter.class})
public class NewActivitySchemeFilter extends AbsSchemeDispatcherFilter {

    /* renamed from: a */
    private static DeepLinkManage f11297a = new DeepLinkManage();

    public boolean doFilter(Intent intent, SchemeDispatcher schemeDispatcher) {
        Uri data = intent.getData();
        if (data == null || !f11297a.filterHost(data.getHost()) || !f11297a.filterPath(data.getPath())) {
            return false;
        }
        if (m7623a()) {
            handleScheme(schemeDispatcher, data);
        } else {
            m7622a(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, new ActivityDeepLinkEvent(data));
            m7621a(schemeDispatcher);
        }
        schemeDispatcher.finish();
        return true;
    }

    /* renamed from: a */
    private void m7622a(String str, BaseDeepLinkEvent baseDeepLinkEvent) {
        if (!TextUtils.isEmpty(str)) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            BaseEventPublisher.getPublisher().publishSticky(str, baseDeepLinkEvent);
        }
    }

    /* renamed from: a */
    private boolean m7623a() {
        return ActivityLifecycleManager.getInstance().isMainActivityRunning();
    }

    /* renamed from: a */
    private void m7621a(SchemeDispatcher schemeDispatcher) {
        if (!m7623a()) {
            schemeDispatcher.startActivity(new Intent(schemeDispatcher, DidiLoadDexActivity.class));
            schemeDispatcher.finish();
        }
    }

    public static void handleScheme(Activity activity, Uri uri) {
        f11297a.query(uri.getPath()).deepLink(activity, uri);
    }
}
