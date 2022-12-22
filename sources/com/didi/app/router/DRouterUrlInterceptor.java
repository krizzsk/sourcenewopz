package com.didi.app.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.router.Request;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.UiThreadHandler;
import org.greenrobot.eventbus.EventBus;

public class DRouterUrlInterceptor implements IRouterInterceptor {
    public static final String BIZ_SWITCH = "one/biz_switch";
    public static final String ONE_PRODUCT_SWITCH = "one/product/switch";
    public static final String TAG_BUSINESS = "groupType";
    public static final String TAG_NO_SWITCH_TAP = "noSwitchTab";

    /* renamed from: b */
    private static final String f8662b = "closeSideMenu";

    /* renamed from: c */
    private static final String f8663c = "clearTop";

    /* renamed from: a */
    private Logger f8664a = LoggerFactory.getLogger("DRouterUrlInterceptor");

    /* renamed from: a */
    private SwitchTypeEvent m5805a(String str, Uri uri, Bundle bundle) {
        SwitchTypeEvent switchTypeEvent = new SwitchTypeEvent(str);
        switchTypeEvent.scheme = uri.toString();
        switchTypeEvent.extraBundle = bundle;
        return switchTypeEvent;
    }

    public void handle(final Request request) {
        Uri uri = request.getUri();
        if (uri == null) {
            request.getInterceptor().onContinue();
            return;
        }
        String host = uri.getHost();
        if (!"1".equals(uri.getQueryParameter(TAG_NO_SWITCH_TAP)) && !TextUtils.isEmpty(host)) {
            if (!"sodaEntrega".equals(ConfProxy.getInstance().getSelectedType()) && !"bus".equals(ConfProxy.getInstance().getSelectedType())) {
                EventBus.getDefault().post(m5805a(host, uri, request.extra));
            } else if ("soda".equals(host)) {
                EventBus.getDefault().post(m5805a(host, uri, request.extra));
            }
        }
        String queryParameter = uri.getQueryParameter("groupType");
        StringBuffer stringBuffer = new StringBuffer();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(host)) {
            stringBuffer.append(host);
        }
        if (!TextUtils.isEmpty(path)) {
            stringBuffer.append(path);
        }
        if (TextUtils.equals(stringBuffer, ONE_PRODUCT_SWITCH) && !TextUtils.isEmpty(queryParameter)) {
            EventBus.getDefault().post(m5805a(queryParameter, uri, request.extra));
        }
        if ("1".equals(uri.getQueryParameter("closeSideMenu"))) {
            EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.CLOSE_SIDEBAR));
        }
        if ("1".equals(uri.getQueryParameter(f8663c))) {
            m5806a(request.getContext());
        }
        if (SaApolloUtil.INSTANCE.getSaState()) {
            request.getInterceptor().onContinue();
        } else if ("soda".equals(host) && !ConfProxy.getInstance().isContainsGroupType("soda")) {
            Logger logger = this.f8664a;
            logger.error("DRouterUrlInterceptor", "not continue uri because topbar not contains soda ,uri = " + uri.toString());
        } else if (!TextUtils.equals(stringBuffer, ONE_PRODUCT_SWITCH) || TextUtils.isEmpty(queryParameter)) {
            request.getInterceptor().onContinue();
        } else {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    request.getInterceptor().onContinue();
                }
            }, 200);
        }
    }

    /* renamed from: a */
    private void m5806a(Context context) {
        Intent intent = new Intent();
        intent.addFlags(View.STATUS_BAR_TRANSIENT);
        PageRouter.getInstance().startMainActivity(context, intent);
    }
}
