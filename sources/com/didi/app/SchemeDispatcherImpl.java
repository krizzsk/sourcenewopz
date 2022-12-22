package com.didi.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerLib;
import com.didi.app.delegate.MapViewHolder;
import com.didi.app.router.DRouterUtils;
import com.didi.app.router.PageRouter;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BroadcastSender;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.app.ISchemeDispatcherHandler;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.WebViewUtils;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.sdk.webview.store.WebConfigStore;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.net.URLEncoder;

public class SchemeDispatcherImpl extends SchemeDispatcher {
    public static final String HOST_ALIPAY_BACK = "alipay_pay_back";
    public static final String HOST_ALIPAY_BIND_BACK = "alipay_bind_back";
    public static final String HOST_DIDI_COMMON_URL = "didi_common_url";
    public static final String HOST_ONE = "one";
    public static final String HOST_PAY = "pay";
    public static final String HOST_QQ_SIGN_BACK = "qqpay_sign_back";
    public static final String PARAM_DROUTER_URL = "drouter_url";
    public static final String SCHEME_DIDICOMMON = "didicommon";
    public static final String SCHEME_DIDIPASNGER = "didipasnger";
    public static final String SCHEME_ONE_TRAVEL = "OneTravel";
    public static final String SCHEME_PUSH = "PushTravel";

    /* renamed from: a */
    private static Logger f8232a = LoggerFactory.getLogger("SchemeDispatcher");

    /* renamed from: a */
    private void m5363a(Intent intent) {
        if (intent != null) {
            SystemUtils.log(3, "ibt_gp_appvisit_sw", "action：" + intent.getAction(), (Throwable) null, "com.didi.app.SchemeDispatcherImpl", 67);
            if (intent.getCategories() != null) {
                SystemUtils.log(3, "ibt_gp_appvisit_sw", "getCategories:" + intent.getCategories().toString(), (Throwable) null, "com.didi.app.SchemeDispatcherImpl", 69);
            }
            if ("com.didi.global.fcm.msg.click".equals(intent.getAction()) || "com.didi.br.fcm.msg.click".equals(intent.getAction())) {
                VisitTrackManager.INSTANCE.setType("push");
                return;
            }
            VisitTrackManager.INSTANCE.setType("ext");
            VisitTrackManager.INSTANCE.setUri(intent.getData());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        com.didi.sdk.log.Logger.easylog("SchemeDispatcher", NachoLifecycleManager.LIFECYCLE_ON_CREATE);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        m5363a(intent);
        if (this.hasHand) {
            finish();
            return;
        }
        handleScheme(intent);
        finish();
        AppsFlyerLib.getInstance().sendDeepLinkData(this);
    }

    /* access modifiers changed from: protected */
    public void handleScheme(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            finish();
            return;
        }
        String scheme = data.getScheme();
        com.didi.sdk.log.Logger.easylog("SchemeDispatcher", "scheme -> " + scheme + "  getSchemeOneTravel:" + getSchemeOneTravel());
        Logger logger = f8232a;
        StringBuilder sb = new StringBuilder();
        sb.append("uri:");
        sb.append(data.toString());
        logger.warn(sb.toString(), new Object[0]);
        if (SCHEME_DIDIPASNGER.equalsIgnoreCase(scheme)) {
            m5365a(data.getHost());
        } else if (getSchemeOneTravel().equalsIgnoreCase(scheme)) {
            m5364a(data);
        } else if (SCHEME_PUSH.equalsIgnoreCase(scheme)) {
            handleSchemeOfPush(intent);
        } else if (getSchemeDidicommon().equalsIgnoreCase(scheme)) {
            m5367b(data);
        } else {
            DRouterUtils.startUrlSafety(this, data);
        }
    }

    /* access modifiers changed from: protected */
    public void handleSchemeOfPush(Intent intent) {
        tryToStartMainActivity();
        ISchemeDispatcherHandler iSchemeDispatcherHandler = (ISchemeDispatcherHandler) ComponentLoadUtil.getComponent(ISchemeDispatcherHandler.class);
        if (iSchemeDispatcherHandler != null) {
            iSchemeDispatcherHandler.handleSchemeOfPush(intent, this);
        }
    }

    /* renamed from: a */
    private void m5365a(String str) {
        com.didi.sdk.log.Logger.easylog("SchemeDispatcher", "handleSchemeOfPasnger host=" + str);
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1081020301) {
                if (hashCode != -409678542) {
                    if (hashCode == 408045556 && str.equals(HOST_ALIPAY_BIND_BACK)) {
                        c = 1;
                    }
                } else if (str.equals(HOST_QQ_SIGN_BACK)) {
                    c = 2;
                }
            } else if (str.equals(HOST_ALIPAY_BACK)) {
                c = 0;
            }
            if (c == 0) {
                sendBroadcast((String) null, SCHEME_DIDIPASNGER, str, getIntent());
                tryToStartMainActivity();
            } else if (c == 1) {
                sendBroadcast((String) null, SCHEME_DIDIPASNGER, str, getIntent());
                tryToStartMainActivity();
            } else if (c == 2) {
                sendBroadcast((String) null, SCHEME_DIDIPASNGER, str, getIntent());
                tryToStartMainActivity();
            }
        }
    }

    /* renamed from: a */
    private void m5364a(Uri uri) {
        String host = uri.getHost();
        if (!TextUtil.isEmpty(host)) {
            char c = 65535;
            int hashCode = host.hashCode();
            if (hashCode != 110182) {
                if (hashCode == 110760 && host.equals(HOST_PAY)) {
                    c = 0;
                }
            } else if (host.equals("one")) {
                c = 1;
            }
            if (c != 0) {
                DRouterUtils.startUrlSafety(this, uri);
            } else {
                m5369c(host);
            }
        }
    }

    /* renamed from: b */
    private void m5367b(Uri uri) {
        String host = uri.getHost();
        com.didi.sdk.log.Logger.easylog("SchemeDispatcher", "handleSchemeOfStartUrl host=" + host);
        if (host != null) {
            char c = 65535;
            if (host.hashCode() == -1741285200 && host.equals(HOST_DIDI_COMMON_URL)) {
                c = 0;
            }
            if (c == 0) {
                m5368c(uri);
            }
        }
    }

    /* renamed from: c */
    private void m5368c(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String queryParameter = uri.getQueryParameter("url");
        if (queryParameter != null) {
            String replace = TextUtils.isEmpty(queryParameter.trim()) ? "" : queryParameter.replace(Const.jsQuote, "");
            if (!TextUtils.isEmpty(replace.trim())) {
                try {
                    boolean isUrlStartWithHttps = WebViewUtils.isUrlStartWithHttps(replace);
                    if (WebConfigStore.getInstance().isWhiteUrl(replace, this) && isUrlStartWithHttps) {
                        replace = m5366b(replace);
                    }
                    String queryParameter2 = uri.getQueryParameter("title");
                    if (TextUtils.isEmpty(queryParameter2)) {
                        str = "";
                    } else {
                        str = queryParameter2.replace(Const.jsQuote, "");
                    }
                    String queryParameter3 = uri.getQueryParameter("addparam");
                    if (TextUtils.isEmpty(queryParameter3)) {
                        str2 = "";
                    } else {
                        str2 = queryParameter3.replace(Const.jsQuote, "");
                    }
                    String queryParameter4 = uri.getQueryParameter("type");
                    String replace2 = TextUtils.isEmpty(queryParameter4) ? "0" : queryParameter4.replace(Const.jsQuote, "");
                    String queryParameter5 = uri.getQueryParameter("speechtype");
                    if (TextUtils.isEmpty(queryParameter5)) {
                        str3 = "0";
                    } else {
                        str3 = queryParameter5.replace(Const.jsQuote, "");
                    }
                    String queryParameter6 = uri.getQueryParameter("paramtype");
                    if (TextUtils.isEmpty(queryParameter6)) {
                        str4 = "0";
                    } else {
                        str4 = queryParameter6.replace(Const.jsQuote, "");
                    }
                    tryToStartMainActivity();
                    WebViewModel webViewModel = new WebViewModel();
                    boolean z = true;
                    webViewModel.isCommonModel = true;
                    webViewModel.url = replace;
                    webViewModel.isFromOutApp = true;
                    webViewModel.isSuportJs = !replace2.equals("0");
                    webViewModel.isSuportSpeechJs = !str3.equals("0");
                    if (str4.equals("0")) {
                        z = false;
                    }
                    webViewModel.isAddCommonParam = z;
                    if (!"".equals(str.trim())) {
                        webViewModel.title = str.trim();
                        webViewModel.canChangeWebViewTitle = false;
                    }
                    if (!"".equals(str2.trim())) {
                        webViewModel.customparams = str2.trim();
                    }
                    if (TextUtils.isEmpty(replace) || !replace.contains("fusion=true")) {
                        Class<BaseWebActivity> cls = BaseWebActivity.class;
                    }
                    Intent intent = new Intent(this, BaseWebActivity.class);
                    intent.putExtra("web_view_model", webViewModel);
                    startActivity(intent);
                } catch (Exception unused) {
                    com.didi.sdk.log.Logger.easylog("SchemeDispatcher", "handleHostOfCommonForURL exception");
                }
            }
        }
    }

    /* renamed from: b */
    private String m5366b(String str) {
        String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        if (!TextUtils.isEmpty(token)) {
            if (TextUtils.isEmpty(token.trim())) {
                token = "";
            } else {
                token = URLEncoder.encode(token);
            }
        }
        String str2 = "token=" + token;
        if ("".equals(str)) {
            return str;
        }
        if (str.endsWith("?")) {
            return str + str2;
        } else if (!str.contains("?")) {
            return str + "?" + str2;
        } else if (str.endsWith(ParamKeys.SIGN_AND)) {
            return str + str2;
        } else {
            return str + ParamKeys.SIGN_AND + str2;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: c */
    private void m5369c(String str) {
        sendBroadcast((String) null, getSchemeOneTravel(), str, getIntent());
        tryToStartMainActivity();
    }

    /* access modifiers changed from: protected */
    public void sendBroadcast(String str, String str2, String str3, Intent intent) {
        com.didi.sdk.log.Logger.easylog("SchemeDispatcher", "sendBroadcast: " + str + "|" + str2 + "|" + str3 + "|" + intent);
        Intent intent2 = new Intent();
        intent2.setAction("com.xiaojukeji.action.EXTERNAL_INTENT");
        if (!TextUtils.isEmpty(str)) {
            intent2.setData(Uri.parse("OneReceiver://" + str + "/external_intent"));
        }
        intent2.putExtra("scheme", str2);
        intent2.putExtra("host", str3);
        intent2.putExtra("intent", intent);
        BroadcastSender.getInstance(this).sendBroadcast(intent2);
    }

    /* access modifiers changed from: protected */
    public void tryToStartMainActivity() {
        if (!ActivityLifecycleManager.getInstance().isMainActivityRunning()) {
            com.didi.sdk.log.Logger.easylog("SchemeDispatcher", "MainActivity is not running, start it.");
            m5362a();
            Intent intent = new Intent();
            intent.addFlags(805306368);
            PageRouter.getInstance().startMainActivity(this, intent);
        }
    }

    /* access modifiers changed from: protected */
    public String getSchemeDidicommon() {
        return NationTypeUtil.getNationComponentData().getProductPreFix() + SCHEME_DIDICOMMON;
    }

    /* access modifiers changed from: protected */
    public String getSchemeOneTravel() {
        return NationTypeUtil.getNationComponentData().getProductPreFix() + SCHEME_ONE_TRAVEL;
    }

    /* renamed from: a */
    private void m5362a() {
        IToggle toggle = Apollo.getToggle("global_passenger_map_init_rollback");
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
        if (toggle != null && toggle.allow() && ((Integer) toggle.getExperiment().getParam("initmode", 0)).intValue() == 1) {
            if ((iCollector == null || iCollector.isHMSupportPreInitMap()) && MapViewHolder.getInstance().getMapView() == null) {
                MapViewHolder.getInstance().postInitMap(DIDIApplicationDelegate.getAppContext());
            }
        }
    }
}
