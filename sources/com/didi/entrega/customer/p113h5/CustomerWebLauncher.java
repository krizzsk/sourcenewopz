package com.didi.entrega.customer.p113h5;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import java.util.Map;

/* renamed from: com.didi.entrega.customer.h5.CustomerWebLauncher */
public final class CustomerWebLauncher {

    /* renamed from: a */
    private static final String f20164a = "CustomerWebLauncher";

    /* renamed from: a */
    private static boolean m14852a(String str) {
        return true;
    }

    private CustomerWebLauncher() {
    }

    public static void launchWebPage(Request request, WebConfig webConfig, boolean z, Bundle bundle, Class cls) {
        Uri.parse(webConfig.url);
        DiRouter.request().setFromPage(request.getFromPage()).path(CustomerVerticalWebPage.class.isAssignableFrom(cls) ? "verticalWebPage" : "webPage").putParcelable(WebConstant.WEB_MODEL, m14851a(webConfig, false)).putBoolean("backbuttonshow", z).putBundle("webpagebundle", bundle).open();
    }

    /* renamed from: a */
    private static WebConfig m14851a(WebConfig webConfig, boolean z) {
        if (webConfig == null) {
            return webConfig;
        }
        if (webConfig.mCustomerParameters != null && webConfig.mCustomerParameters.size() > 0) {
            Uri.Builder buildUpon = Uri.parse(webConfig.url).buildUpon();
            for (Map.Entry next : webConfig.mCustomerParameters.entrySet()) {
                buildUpon.appendQueryParameter((String) next.getKey(), "" + ((String) next.getValue()));
            }
            webConfig.url = buildUpon.build().toString();
        }
        Uri.parse(webConfig.url);
        if (!TextUtils.isEmpty(webConfig.url)) {
            webConfig.url = ParamsHelper.addH5CommonParams(webConfig.url);
        }
        webConfig.isSupportCache = true;
        webConfig.isUseNativeTitltBar = !z;
        return webConfig;
    }
}
