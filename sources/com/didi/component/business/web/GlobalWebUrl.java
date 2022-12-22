package com.didi.component.business.web;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.constant.WebUrlConstants;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class GlobalWebUrl {
    public static String getXpanelAgent(Context context, String str) {
        return TextUtil.isEmpty(str) ? "https://ctv3.didiglobal.com/" : str;
    }

    public static String getCancelTripRuleUrl(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = DDTravelConfigStore.getInstance().getCancelTripURL();
        }
        return TextUtil.isEmpty(str) ? WebUrlConstants.CANCEL_TRIP_RULE : str;
    }

    public static String getCancelTripUrl(Context context, String str) {
        if (TextUtil.isEmpty(str)) {
            str = DDTravelConfigStore.getInstance().getCancelTripURL();
        }
        return TextUtil.isEmpty(str) ? WebUrlConstants.CANCEL_TRIP : str;
    }

    public static String getDashCamAgreementUrl(String str) {
        return TextUtil.isEmpty(str) ? WebUrlConstants.DASH_CAM_AGREEMENT : str;
    }

    public static String getServiceHelpUrl(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = GlobalApolloUtil.getHelpCenterUrl();
        }
        return TextUtil.isEmpty(str) ? "https://help.didiglobal.com/processing-passenger.html" : str;
    }

    public static String getOtherPageHelpUrl(Context context, String str) {
        return TextUtil.isEmpty(str) ? WebUrlConstants.OTHER_PAGE_HELP : str;
    }

    public static String getEstimatePriceDetailUrl(Context context, String str) {
        if (TextUtil.isEmpty(str)) {
            str = DDTravelConfigStore.getInstance().getEstimatePriceUrl();
        }
        return TextUtil.isEmpty(str) ? WebUrlConstants.ESTIMATE_PRICE_DETAIL : str;
    }

    public static String getPriceDetail(Context context, String str) {
        if (TextUtil.isEmpty(str)) {
            str = DDTravelConfigStore.getInstance().getOnServicePriceDetailUrl();
        }
        return TextUtil.isEmpty(str) ? WebUrlConstants.PRICE_DETAILS : str;
    }

    /* renamed from: a */
    private static boolean m7729a() {
        return DebugUtils.isOnlie();
    }

    /* renamed from: a */
    private static boolean m7730a(Context context) {
        return DebugUtils.getDebugCountry(context) == 1;
    }

    /* renamed from: b */
    private static boolean m7731b(Context context) {
        return DebugUtils.getDebugCountry(context) == 2;
    }

    /* renamed from: c */
    private static boolean m7732c(Context context) {
        return DebugUtils.getDebugCountry(context) == 3;
    }

    /* renamed from: d */
    private static boolean m7733d(Context context) {
        return DebugUtils.getDebugCountry(context) == 4;
    }

    public static String buildUrl(String str) {
        return buildUrl(str, (Map<String, Object>) null);
    }

    public static String buildUrl(String str, Map<String, Object> map) {
        return buildUrl(str, map, false, false);
    }

    public static String buildUrl(String str, Map<String, Object> map, boolean z, boolean z2) {
        UrlBuilderWrapper newBuilder = UrlBuilderWrapper.newBuilder(str);
        newBuilder.enableUrlEncode(z);
        newBuilder.enableHttpsAvailable(z2);
        newBuilder.append(map);
        return newBuilder.build();
    }

    public static WebViewModel buildWebViewModel(String str) {
        return buildWebViewModel(str, "", true, true);
    }

    public static WebViewModel buildWebViewModel(String str, String str2) {
        return buildWebViewModel(str, str2, true, true);
    }

    public static WebViewModel buildWebViewModel(String str, String str2, boolean z, boolean z2) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.url = str;
        if (!TextUtils.isEmpty(str2)) {
            webViewModel.title = str2;
        }
        webViewModel.isPostBaseParams = z;
        webViewModel.isSupportCache = z2;
        return webViewModel;
    }

    public static class UrlBuilderWrapper {
        private boolean mIsHttpsAvailable;
        private String mUrl;
        private boolean mUrlEncode = false;
        private HashMap<String, Object> mUrlParams;

        public static UrlBuilderWrapper newBuilder(String str) {
            return new UrlBuilderWrapper(str);
        }

        private UrlBuilderWrapper(String str) {
            this.mUrl = str;
            this.mUrlParams = new HashMap<>();
        }

        public void enableUrlEncode(boolean z) {
            this.mUrlEncode = z;
        }

        public void enableHttpsAvailable(boolean z) {
            this.mIsHttpsAvailable = z;
        }

        public UrlBuilderWrapper append(Map<String, Object> map) {
            if (map != null && map.size() > 0) {
                this.mUrlParams.putAll(map);
            }
            return this;
        }

        public UrlBuilderWrapper append(String str, Object obj) {
            this.mUrlParams.put(str, obj);
            return this;
        }

        public String build() {
            if (TextUtil.isEmpty(this.mUrl)) {
                return null;
            }
            if (this.mIsHttpsAvailable) {
                this.mUrl = this.mUrl.replace("http://", "https://");
            }
            UrlBuilder urlBuilder = new UrlBuilder(this.mUrl);
            if (this.mUrlParams.size() == 0) {
                return urlBuilder.newUrl();
            }
            for (Map.Entry next : this.mUrlParams.entrySet()) {
                urlBuilder.append((String) next.getKey(), String.valueOf(next.getValue()), this.mUrlEncode);
            }
            return urlBuilder.newUrl();
        }
    }

    public static class UrlBuilder {
        private String mURL;

        public UrlBuilder(String str) {
            this.mURL = str;
        }

        public UrlBuilder append(String str, String str2) {
            return append(str, str2, false);
        }

        public UrlBuilder append(String str, String str2, boolean z) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                appendQuestionMark();
                addParamKeyValue(str, str2, z);
            }
            return this;
        }

        public String newUrl() {
            return this.mURL;
        }

        private void appendQuestionMark() {
            if (TextUtils.isEmpty(this.mURL) || this.mURL.endsWith("?") || this.mURL.endsWith(ParamKeys.SIGN_AND)) {
                return;
            }
            if (!this.mURL.contains("?")) {
                this.mURL = this.mURL.concat("?");
            } else {
                this.mURL = this.mURL.concat(ParamKeys.SIGN_AND);
            }
        }

        private void addParamKeyValue(String str, String str2, boolean z) {
            String str3;
            String concat = this.mURL.concat(str).concat("=");
            this.mURL = concat;
            if (z) {
                try {
                    str3 = URLEncoder.encode(str2, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    str3 = URLEncoder.encode(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    str3 = str3.replaceAll("\\+", "%20");
                }
                this.mURL = this.mURL.concat(str3);
                return;
            }
            this.mURL = concat.concat(str2);
        }
    }
}
