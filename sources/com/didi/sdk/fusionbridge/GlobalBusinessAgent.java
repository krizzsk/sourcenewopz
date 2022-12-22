package com.didi.sdk.fusionbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.appsflyer.AppsFlyerLib;
import com.didi.app.delegate.BffInitManager;
import com.didi.commoninterfacelib.ServiceProviderManager;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.util.FusionMimeTypeMap;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.bff.BffService;
import com.didi.sdk.config.commonconfig.p149sp.CommonConfigSp;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.net.ICommonBusinessParamInterceptor;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.sidebar.sdk.api.utils.DidiHttpUtils;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.WebViewUtils;
import com.didi.sdk.webview.store.WebConfigStore;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.IDomainFilter;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GlobalBusinessAgent extends BusinessAgent {

    /* renamed from: a */
    private static final long f35976a = 5242880;

    /* renamed from: c */
    private static final String f35977c = "hybrid_webview_package";

    /* renamed from: b */
    private Logger f35978b = LoggerFactory.getLogger("GlobalBusinessAgent");

    /* renamed from: d */
    private Context f35979d;

    /* renamed from: e */
    private boolean f35980e = false;

    /* renamed from: f */
    private Set<String> f35981f = new HashSet();

    public GlobalBusinessAgent(Context context) {
        super(context);
        this.f35979d = context;
        this.f35980e = DomainUtil.isSupportDomainSwitch(context);
    }

    public boolean isWhiteUrl(Context context, String str) {
        return WebConfigStore.getInstance().isWhiteUrl(str, context);
    }

    public String getBusinessUA() {
        StringBuilder sb = new StringBuilder();
        String versionName = SystemUtil.getVersionName(this.appContext);
        sb.append(NationTypeUtil.getNationComponentData().getUserAgentPrefix());
        sb.append("/");
        sb.append(versionName);
        if (this.appContext != null) {
            sb.append(" ");
            sb.append(this.appContext.getPackageName());
            sb.append("/");
            sb.append(versionName);
        }
        return sb.toString();
    }

    public boolean shouldIntercept(Context context, String str) {
        return FusionCacheInterceptFilter.sInstance.shouldIntercept(str);
    }

    public String getOfflineBundleFilePath() {
        return super.getOfflineBundleFilePath();
    }

    public boolean isOfflineOpen() {
        if ((this.f35979d.getApplicationInfo().flags & 2) != 0) {
            return EnvPreferenceUtil.getBooleanSafely(this.f35979d, f35977c, true);
        }
        IToggle toggle = Apollo.getToggle(f35977c);
        if (toggle == null) {
            return super.isOfflineOpen();
        }
        IExperiment experiment = toggle.getExperiment();
        if ((experiment != null ? ((Integer) experiment.getParam("enable", 0)).intValue() : 0) == 1) {
            return true;
        }
        return false;
    }

    public void refreshAppLocale(Context context) {
        MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(context);
    }

    public Map<String, String> getCommonHeaders() {
        HashMap hashMap = new HashMap();
        int productId = BffInitManager.getProductId(ConfProxy.getInstance().getSelectedType());
        hashMap.put("Cityid", NationTypeUtil.getNationComponentData().getCityId());
        hashMap.put("Productid", String.valueOf(productId));
        return hashMap;
    }

    /* renamed from: a */
    private boolean m25454a(String str) {
        if (!this.f35980e || TextUtil.isEmpty(str) || !DomainUtil.checkUrlSupportDomainSwitch(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if (!"text/html".equalsIgnoreCase(FusionMimeTypeMap.getMimeTypeFromUrl(str)) || (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme))) {
            return false;
        }
        return true;
    }

    public boolean interceptWhenOverrideUrlLoading(String str) {
        ELog.log("interceptWhenOverrideUrlLoading() url = " + str);
        boolean a = m25454a(str);
        ELog.log("interceptWhenOverrideUrlLoading() return " + a);
        return a;
    }

    public String addCommonQuery(String str) {
        if ((!str.startsWith("http:") && !str.startsWith("https:")) || !isWhiteUrl(this.f35979d, str)) {
            return str;
        }
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        HashMap hashMap = new HashMap();
        if (!str.contains("lang=")) {
            hashMap.put("lang", nationComponentData.getLocaleCode());
        }
        hashMap.put("locale", nationComponentData.getLocaleCode());
        hashMap.put("utc_offset", Integer.valueOf(nationComponentData.getTimeZoneUtcOffset()));
        hashMap.put("origin_id", nationComponentData.getOriginID());
        hashMap.put("terminal_id", nationComponentData.getTerminal_id());
        hashMap.put("platform_type", nationComponentData.getPlatform_type());
        hashMap.put("maptype", nationComponentData.getMapTypeString());
        hashMap.put("trip_type", nationComponentData.getLocCountry());
        hashMap.put("appID", BffService.getAppId(this.f35979d));
        hashMap.put("user_role", "passenger");
        hashMap.put("aid", AppsFlyerLib.getInstance().getAppsFlyerUID(this.f35979d));
        hashMap.put("frid", CommonConfigSp.getInstance().get(CommonConfigSp.KEY_FIREBASE_APP_ID, ""));
        NationComponentData.LoginInfo loginInfo = nationComponentData.getLoginInfo();
        if (!(loginInfo == null || loginInfo.getToken() == null || !WebViewUtils.isUrlStartWithHttps(str))) {
            hashMap.put("token", loginInfo.getToken());
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                if (!parse.getQueryParameterNames().contains(ServerParam.PARAM_TRIPCOUNTRY)) {
                    hashMap.put(ServerParam.PARAM_TRIPCOUNTRY, nationComponentData.getLocCountry());
                }
                if (!parse.getQueryParameterNames().contains("trip_country")) {
                    hashMap.put("trip_country", nationComponentData.getLocCountry());
                }
                if (!parse.getQueryParameterNames().contains("trip_cityid")) {
                    hashMap.put("trip_cityid", nationComponentData.getCityId());
                }
            }
        } catch (Exception unused) {
            SystemUtils.log(3, "WebConfigStore", "Uri.parse error", (Throwable) null, "com.didi.sdk.fusionbridge.GlobalBusinessAgent", 228);
        }
        hashMap.put("location_country", nationComponentData.getLocCountry());
        hashMap.put("location_cityid", nationComponentData.getCityId());
        hashMap.put(ServerParam.PARAM_H5_COUNTRY, nationComponentData.getLocCountry());
        hashMap.put(ServerParam.PARAM_H5_CITY_ID, nationComponentData.getCityId());
        hashMap.put("city", nationComponentData.getCityId());
        hashMap.put("locale", MultiLocaleUtil.getLanguageModel().getLocale());
        ICommonBusinessParamInterceptor iCommonBusinessParamInterceptor = (ICommonBusinessParamInterceptor) ServiceProviderManager.getInstance().getComponent(ICommonBusinessParamInterceptor.class);
        if (iCommonBusinessParamInterceptor != null) {
            HashMap<String, Object> params = iCommonBusinessParamInterceptor.getParams();
            if (params != null) {
                hashMap.putAll(params);
                Logger logger = this.f35978b;
                logger.info("common business data:" + params.toString(), new Object[0]);
            } else {
                this.f35978b.info("common business data: null", new Object[0]);
            }
        }
        if (this.f35980e) {
            String domainSuffix = DomainServiceManager.getInstance().getDomainSuffix(this.f35979d);
            if (!TextUtils.isEmpty(domainSuffix)) {
                ArrayList arrayList = new ArrayList();
                Iterator<S> it = ServiceLoader.load(IDomainFilter.class).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                String rebuildUrl = DomainUtil.rebuildUrl(str, domainSuffix, (List<IDomainFilter>) arrayList);
                String trunckURLRootPath = DomainUtil.trunckURLRootPath(rebuildUrl);
                ELog.log("new url=" + rebuildUrl);
                CookieManager.getInstance().setAcceptCookie(true);
                if (rebuildUrl.equals(str)) {
                    CookieManager.getInstance().setCookie(trunckURLRootPath, "domain_suffix=");
                } else {
                    ELog.log("bind cookie to domain: " + trunckURLRootPath);
                    CookieManager.getInstance().setCookie(trunckURLRootPath, String.format("domain_suffix=-%s", new Object[]{domainSuffix}));
                }
                CookieSyncManager.getInstance().sync();
                str = rebuildUrl;
            }
        }
        return DidiHttpUtils.link(str, hashMap);
    }

    public String getUserPhone() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
    }

    public Map<String, Object> getBundleParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("datatype", 1);
        return hashMap;
    }

    public String getBundleBlackList() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(f35977c);
        if (toggle == null || (experiment = toggle.getExperiment()) == null) {
            return super.getBundleBlackList();
        }
        return (String) experiment.getParam("black_list", "");
    }

    public long getFlowLimit() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(f35977c);
        if (toggle == null || (experiment = toggle.getExperiment()) == null) {
            return super.getFlowLimit();
        }
        return ((Long) experiment.getParam("flowlimit", Long.valueOf(f35976a))).longValue();
    }
}
