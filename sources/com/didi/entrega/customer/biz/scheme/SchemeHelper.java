package com.didi.entrega.customer.biz.scheme;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.param.GlobalParam;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.immap.IMMapHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class SchemeHelper {
    public static final String FROM_OTHER = "other";
    public static final String FROM_WEB = "webPage";
    public static final boolean NOT_COLD_LAUNCH = false;
    public static final String SCHEME_FROM = "schem_from";

    /* renamed from: a */
    private static final String f19833a = "SchemeHelper";

    /* renamed from: b */
    private static final int f19834b = 5000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Request.Builder f19835c;

    /* renamed from: d */
    private static Runnable f19836d = new Runnable() {
        public void run() {
            Request.Builder unused = SchemeHelper.f19835c = null;
        }
    };

    public static void dispatchMsg(String str) {
        if (!TextUtils.isEmpty(str)) {
            dispatchMsg(Uri.parse(str), false);
        }
    }

    public static void dispatchMsg(Uri uri, String str, String str2, boolean z) {
        if (uri.getQueryParameter("closeSideMenu") != null && "1".equals(uri.getQueryParameter("closeSideMenu"))) {
            ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).closeSideMenu();
        }
        LogUtil.m14765i(f19833a, "dispatchMsg curTime=" + System.currentTimeMillis());
        if (NetWorkUtils.isHttpUri(uri)) {
            LogUtil.m14765i(f19833a, "dispatchMsg -> isHttpUri");
            DiRouter.request().path("webPage").putString("url", uri.toString()).putString("title", str2).open();
        } else if (!RouteValidation.isEntregaSchemeUri(uri)) {
            LogUtil.m14765i(f19833a, "dispatchMsg -> NotEntregaSchemeUri");
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SCHEME).addModuleName("scheme").addErrorType("fail").addErrorMsg(uri.toString()).build().trackError();
        } else if (RouteValidation.isWalletSchemeUri(uri)) {
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity((Activity) GlobalContext.getContext(), 1, new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR));
        } else if (RouteValidation.isIMLocationSchemeUri(uri)) {
            IMMapHelper.startNavIMMap(uri.toString());
        } else {
            m14701a(uri, str, z);
        }
    }

    public static void dispatchMsg(Uri uri, boolean z) {
        dispatchMsg(uri, "other", "", z);
    }

    public static void delayOpenPage() {
        if (f19835c != null) {
            LogUtil.m14765i(f19833a, "延迟跳转 curTime=" + System.currentTimeMillis());
            f19835c.open();
            f19835c = null;
        }
    }

    public static void recycle() {
        LogUtil.m14765i(f19833a, "清空缓存");
        f19835c = null;
    }

    /* renamed from: a */
    private static void m14701a(Uri uri, String str, boolean z) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path) || path.trim().equals("//") || path.trim().equals("/") || path.trim().contains("homePage")) {
            path = "taxis99OneTravel://sodaEntrega";
        }
        LogUtil.m14765i(f19833a, "routePath = " + path);
        Request.Builder request = DiRouter.request();
        m14702a(request, uri, z);
        if ("webPage".equals(str)) {
            request.path(path).putString("schem_from", "webPage");
        } else {
            request.path("taxis99OneTravel://sodaEntrega");
        }
        request.putString("schemeAssistPath", path);
        request.putInt("schemeRouterTag", 1);
        if (GlobalContext.isFragmentInited()) {
            LogUtil.m14765i(f19833a, "直接跳转");
            request.open();
            f19835c = null;
            return;
        }
        LogUtil.m14765i(f19833a, "延迟跳转－存储数据");
        f19835c = request;
        UiHandlerUtil.removeCallbacks(f19836d);
        UiHandlerUtil.postDelayed(f19836d, 5000);
    }

    /* renamed from: a */
    private static void m14702a(Request.Builder builder, Uri uri, boolean z) {
        if (!TextUtils.isEmpty(uri.getQuery())) {
            GlobalParam.ExternalGlobalParam externalGlobalParam = new GlobalParam.ExternalGlobalParam();
            for (String next : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(next);
                LogUtil.m14765i(f19833a, "params[" + next + ":" + queryParameter + Const.jaRight);
                if (!externalGlobalParam.fetchParam(next, queryParameter, z)) {
                    builder.putString(next, queryParameter);
                }
            }
            if (externalGlobalParam.hasData()) {
                OmegaCommonParamHelper.setExternalGlobalParam(externalGlobalParam);
            }
        }
    }
}
