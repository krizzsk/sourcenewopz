package com.didi.sdk.lawpop;

import android.content.Context;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.UrlUtils;

public class LawUtil {
    public static final String LAW_CONST_BASE_URL = "https://common.didiglobal.com";
    public static final String LAW_CONST_BASE_URL_FOR_PREPOSE_DIALOG = "https://common-g.didiglobal.com";
    public static final String LAW_URL = "/common/v6/client/law";

    /* renamed from: a */
    private static final String f36430a = "phone_country";

    /* renamed from: b */
    private static final String f36431b = "lang";

    /* renamed from: c */
    private static final String f36432c = "terminal_id";

    public static String getLawUrl(Context context) {
        return UrlUtils.addParam("https://common.didiglobal.com/common/v6/client/law", f36430a, AppUtils.getCountryCodeISO3166());
    }

    public static String getLawUrlForPreposeDialog(Context context, String str, String str2) {
        return UrlUtils.addParam(UrlUtils.addParam(UrlUtils.addParam("https://common-g.didiglobal.com/common/v6/client/law", f36430a, str), "terminal_id", String.valueOf(AppUtils.isBrazilApp(context) ? 5 : 7)), "lang", str2);
    }
}
