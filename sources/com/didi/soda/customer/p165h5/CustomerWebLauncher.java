package com.didi.soda.customer.p165h5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.router.DiRouter;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import java.util.Map;

/* renamed from: com.didi.soda.customer.h5.CustomerWebLauncher */
public final class CustomerWebLauncher {

    /* renamed from: a */
    private static final String f41288a = "CustomerWebLauncher";

    private CustomerWebLauncher() {
    }

    public static void launchWebPage(WebConfig webConfig, boolean z, Bundle bundle, Class cls) {
        Uri parse = Uri.parse(webConfig.url);
        if ("1".equals(parse.getQueryParameter(Const.PageParams.DIDI_PASS)) && !LoginUtil.isLogin()) {
            LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 20);
        } else if ("1".equals(parse.getQueryParameter("nativeWebUIType")) || "2".equals(parse.getQueryParameter("nativeWebUIType"))) {
            DiRouter.request().path(RoutePath.LANDING_WEB_PAGE).putParcelable(WebConstant.WEB_MODEL, buildWebConfig(webConfig, true)).putBundle("webpagebundle", bundle).open();
        } else {
            String str = CustomerVerticalWebPage.class.isAssignableFrom(cls) ? "verticalWebPage" : "webPage";
            if ("0".equals(parse.getQueryParameter("backbuttonshow"))) {
                z = false;
            }
            DiRouter.request().path(str).putParcelable(WebConstant.WEB_MODEL, buildWebConfig(webConfig, false)).putBoolean("backbuttonshow", z).putBundle("webpagebundle", bundle).open();
        }
    }

    public static void launchWebPageForResulit(ScopeContext scopeContext, WebConfig webConfig) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(WebConstant.WEB_MODEL, buildWebConfig(webConfig, false));
        scopeContext.getNavigator().pushForResult((CustomerWebPage) PageFactory.newInstance(CustomerWebPage.class, bundle));
    }

    public static void launchWebActivity(Context context, WebConfig webConfig) {
        if (context != null && webConfig != null) {
            Intent intent = new Intent();
            intent.setClass(context, CustomerWebActivity.class);
            intent.putExtra(WebConstant.WEB_MODEL, buildWebConfig(webConfig, false));
            context.startActivity(intent);
        }
    }

    public static void launchTransparentWebPageDirect(ScopeContext scopeContext, WebConfig webConfig) {
        DiRouter.request().path(RoutePath.TRANSPARENT_WEB_PAGE).putParcelable(WebConstant.WEB_MODEL, buildWebConfig(webConfig, true)).open();
    }

    public static WebConfig buildWebConfig(WebConfig webConfig, boolean z) {
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
        if ("1".equals(Uri.parse(webConfig.url).getQueryParameter(Const.PageParams.DIDI_PASS))) {
            webConfig.url = ParamsHelper.addDiDiPassParams(webConfig.url);
            CustomerDidiPassTrackKt.trackGoDidiPass();
        }
        if (!TextUtils.isEmpty(webConfig.url) && m29241a(webConfig.url)) {
            webConfig.url = OmegaCommonParamHelper.fillWebUrlWithGuideParam(webConfig.url);
        }
        if (!TextUtils.isEmpty(webConfig.url)) {
            webConfig.url = ParamsHelper.addH5CommonParams(webConfig.url);
        }
        webConfig.isSupportCache = true;
        webConfig.isUseNativeTitltBar = !z;
        return webConfig;
    }

    /* renamed from: a */
    private static boolean m29241a(String str) {
        return !str.startsWith(CustomerH5UrlConst.m29227a()) && !str.startsWith("https://help.didiglobal.com/");
    }
}
