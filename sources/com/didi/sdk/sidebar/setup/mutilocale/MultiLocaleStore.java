package com.didi.sdk.sidebar.setup.mutilocale;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class MultiLocaleStore {

    /* renamed from: a */
    private static final String f37435a = "multilocale-debug";

    /* renamed from: b */
    private static Logger f37436b = LoggerFactory.getLogger("MultiLocaleStore");

    /* renamed from: c */
    private static MultiLocaleStore f37437c = new MultiLocaleStore();

    /* renamed from: d */
    private HashSet<LocaleChangeListener> f37438d = new HashSet<>();

    /* renamed from: e */
    private MultiLocaleHelper f37439e = new MultiLocaleHelperImpl();

    /* renamed from: f */
    private int f37440f = -1;

    /* renamed from: g */
    private String f37441g = "";

    /* renamed from: h */
    private Locale f37442h;

    public boolean isSwitchOn() {
        return true;
    }

    private MultiLocaleStore() {
        Locale defaultLocale = MultiLocaleUtil.getDefaultLocale();
        this.f37442h = defaultLocale;
        if (defaultLocale != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lang", this.f37442h.getCountry());
            Logger logger = f37436b;
            logger.info("systemLocale code : " + this.f37442h.getCountry() + " " + this.f37442h.getLanguage(), new Object[0]);
            OmegaSDK.trackEvent("phone_system_lang", "", hashMap);
        }
    }

    /* renamed from: a */
    private int m26609a() {
        int i;
        String metaDataByKey = AppUtils.getMetaDataByKey("COUNTRY");
        if ("JP".equalsIgnoreCase(metaDataByKey)) {
            i = 1;
        } else if ("AU".equalsIgnoreCase(metaDataByKey)) {
            i = 2;
        } else {
            i = EnvPreferenceUtil.getIntSafely(DIDIApplicationDelegate.getAppContext(), "key_app_global_version", 0);
        }
        SystemUtils.log(4, "MetaDataCountry", "country:" + metaDataByKey + "  cy:" + i, (Throwable) null, "com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore", 68);
        Logger logger = f37436b;
        StringBuilder sb = new StringBuilder();
        sb.append("appCountry : ");
        sb.append(i);
        logger.info(sb.toString(), new Object[0]);
        return i;
    }

    public boolean isJapan() {
        return m26609a() == 1;
    }

    public boolean isAustralia() {
        return m26609a() == 2;
    }

    public Locale getSystemLocale() {
        return this.f37442h;
    }

    public static MultiLocaleStore getInstance() {
        return f37437c;
    }

    public MultiLocaleHelper getLocaleHelper() {
        return this.f37439e;
    }

    public synchronized void addLocaleChangeListener(LocaleChangeListener localeChangeListener) {
        if (this.f37438d != null) {
            if (localeChangeListener != null) {
                f37436b.infoEvent(f37435a, "addLocaleChangeListener...");
                this.f37438d.add(localeChangeListener);
                return;
            }
        }
        f37436b.infoEvent(f37435a, "addLocaleChangeListener is null");
    }

    public synchronized void removeLocaleChangeListener(LocaleChangeListener localeChangeListener) {
        if (this.f37438d != null) {
            if (localeChangeListener != null) {
                f37436b.infoEvent(f37435a, f37435a, "removeLocaleChangeListener...");
                this.f37438d.remove(localeChangeListener);
                return;
            }
        }
        f37436b.infoEvent(f37435a, f37435a, "removeLocaleChangeListener is null");
    }

    public synchronized void notifyLocaleChange(String str, String str2) {
        this.f37441g = str2;
        if (this.f37438d != null) {
            if (!this.f37438d.isEmpty()) {
                Iterator<LocaleChangeListener> it = this.f37438d.iterator();
                while (it.hasNext()) {
                    it.next().onLocaleChange(str, str2);
                }
                return;
            }
        }
        f37436b.infoEvent(f37435a, f37435a, "no listeners");
    }

    public synchronized String getLocaleCode() {
        if (this.f37441g == null) {
            return "";
        }
        return this.f37441g;
    }

    public boolean isEnglish() {
        return "en-US".equals(this.f37441g);
    }

    public boolean isJapanese() {
        return "ja-JP".equals(this.f37441g);
    }
}
