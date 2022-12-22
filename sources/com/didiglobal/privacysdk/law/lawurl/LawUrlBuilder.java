package com.didiglobal.privacysdk.law.lawurl;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.privacysdk.law.prepose.AppUtils;

public class LawUrlBuilder {

    /* renamed from: a */
    private static final String f50645a = "https://common.didiglobal.com";

    /* renamed from: b */
    private static final String f50646b = "https://common-g.didiglobal.com";

    /* renamed from: c */
    private static final String f50647c = "/icmc/pmc/lawUrl";

    /* renamed from: d */
    private static final String f50648d = "appID";

    /* renamed from: e */
    private static final String f50649e = "phone_country";

    /* renamed from: f */
    private static final String f50650f = "location_country";

    /* renamed from: g */
    private static final String f50651g = "lang";

    /* renamed from: h */
    private static final String f50652h = "business";

    /* renamed from: i */
    private String f50653i = "";

    /* renamed from: j */
    private String f50654j = AppUtils.getCountryCodeISO3166();

    /* renamed from: k */
    private String f50655k = "";

    /* renamed from: l */
    private String f50656l = "";

    /* renamed from: m */
    private String f50657m = "";

    public String build() {
        return m36366a(this.f50653i, this.f50654j, this.f50655k, this.f50656l, this.f50657m);
    }

    public String buildForPreposeDialog() {
        return m36368b(this.f50653i, this.f50654j, this.f50655k, this.f50656l, this.f50657m);
    }

    public LawUrlBuilder setAppId(String str) {
        this.f50653i = str;
        return this;
    }

    public LawUrlBuilder setPhoneCountry(String str) {
        this.f50654j = str;
        return this;
    }

    public LawUrlBuilder setLocationCountry(String str) {
        this.f50655k = str;
        return this;
    }

    public LawUrlBuilder setLang(String str) {
        this.f50656l = str;
        return this;
    }

    public LawUrlBuilder setBusiness(String str) {
        this.f50657m = str;
        return this;
    }

    /* renamed from: a */
    private static String m36366a(String str, String str2, String str3, String str4, String str5) {
        return m36367a("https://common.didiglobal.com/icmc/pmc/lawUrl", str, str2, str3, str4, str5);
    }

    /* renamed from: b */
    private static String m36368b(String str, String str2, String str3, String str4, String str5) {
        return m36367a("https://common-g.didiglobal.com/icmc/pmc/lawUrl", str, str2, str3, str4, str5);
    }

    /* renamed from: a */
    private static String m36367a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str2)) {
            str = m36365a(str, "appID", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str = m36365a(str, f50649e, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            str = m36365a(str, "location_country", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            str = m36365a(str, "lang", str5);
        }
        return !TextUtils.isEmpty(str6) ? m36365a(str, "business", str6) : str;
    }

    /* renamed from: a */
    private static String m36365a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        String str4 = str2 + "=" + str3;
        if (str.endsWith("?")) {
            return str + str4;
        } else if (!str.contains("?")) {
            return str + "?" + str4;
        } else if (str.endsWith(ParamKeys.SIGN_AND)) {
            return str + str4;
        } else {
            return str + ParamKeys.SIGN_AND + str4;
        }
    }
}
