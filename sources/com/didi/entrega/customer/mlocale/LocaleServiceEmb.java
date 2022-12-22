package com.didi.entrega.customer.mlocale;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.foundation.sdk.mlocale.LoadSupportListUtils;
import com.didi.foundation.sdk.service.LocaleConfig;
import com.didi.foundation.sdk.service.LocaleConfigServiceProvider;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.global.didi.elvish.language.SupportLanguageItemModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class LocaleServiceEmb {

    /* renamed from: b */
    private static final String f20209b = "current_locale";

    /* renamed from: c */
    private static final String f20210c = "current_real_locale";

    /* renamed from: k */
    private static LocaleServiceEmb f20211k;

    /* renamed from: a */
    private Logger f20212a = LoggerFactory.getLogger("LocaleServiceImpl");

    /* renamed from: d */
    private final ArrayList<LocaleServiceProvider.OnLocaleChangedListener> f20213d = new ArrayList<>();

    /* renamed from: e */
    private SharedPreferences f20214e;

    /* renamed from: f */
    private Context f20215f;

    /* renamed from: g */
    private boolean f20216g;

    /* renamed from: h */
    private LocaleConfig f20217h = new LocaleConfig();

    /* renamed from: i */
    private String f20218i = "";

    /* renamed from: j */
    private String f20219j = "";

    public static LocaleServiceEmb getInstance() {
        if (f20211k == null) {
            synchronized (LocaleServiceEmb.class) {
                if (f20211k == null) {
                    f20211k = new LocaleServiceEmb();
                }
            }
        }
        return f20211k;
    }

    private LocaleServiceEmb() {
    }

    public List<Locale> getDefaultList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Locale("en-US"));
        return arrayList;
    }

    public void initEmb(Context context, String str) {
        if (context != null) {
            this.f20216g = true;
            this.f20215f = context;
            this.f20214e = SystemUtils.getSharedPreferences(context, getClass().getName(), 0);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "en-US";
                }
                CustomerElvish.Companion.init(context, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LocaleConfig localeConfig = ((LocaleConfigServiceProvider) ServiceLoader.load(LocaleConfigServiceProvider.class).get()).getLocaleConfig();
            this.f20217h = localeConfig;
            LocaleUtils.isGlobal = localeConfig.isGlobal;
            LocaleUtils.isDubug = this.f20217h.isDebug;
            m14871a(str);
        }
    }

    /* renamed from: a */
    private void m14871a(String str) {
        this.f20212a.info("calculateAppLocale called: from CustomerElvish", new Object[0]);
        Logger logger = this.f20212a;
        logger.info("rlab_locale:" + str, new Object[0]);
        LanguageModel languageAndLocale = CustomerElvish.Companion.getInstance().getLanguageAndLocale(this.f20215f, LocaleUtils.tagToLocale(str), LocaleUtils.isGlobal);
        Logger logger2 = this.f20212a;
        logger2.info("calculateAppLocale called: from CustomerElvish：language = " + languageAndLocale.toString(), new Object[0]);
        this.f20218i = languageAndLocale.getLang();
        String locale = languageAndLocale.getLocale();
        this.f20219j = locale;
        m14872a(this.f20218i, locale);
    }

    /* renamed from: a */
    private void m14872a(String str, String str2) {
        m14874b(str);
        m14875c(str2);
    }

    /* renamed from: b */
    private void m14874b(String str) {
        SharedPreferences sharedPreferences = this.f20214e;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f20209b, str).apply();
        }
    }

    /* renamed from: a */
    private String m14870a() {
        SharedPreferences sharedPreferences = this.f20214e;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(f20209b, this.f20218i);
    }

    /* renamed from: c */
    private void m14875c(String str) {
        if (this.f20214e != null) {
            str.replace("_", "-");
            this.f20214e.edit().putString(f20210c, str).apply();
        }
    }

    /* renamed from: b */
    private String m14873b() {
        SharedPreferences sharedPreferences = this.f20214e;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(f20210c, this.f20219j);
        if (!TextUtils.isEmpty(string)) {
            string = string.replace("_", "-");
        }
        return string == null ? "en-US" : string;
    }

    public List<Locale> getSupportLocaleList() {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (!(this.f20217h.remoteLanguageConfData == null || this.f20217h.remoteLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap = this.f20217h.remoteLanguageConfData.loadConf(GlobalContext.getContext());
        }
        if (!(this.f20217h.localAssetsLanguageConfData == null || this.f20217h.localAssetsLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap2 = this.f20217h.localAssetsLanguageConfData.loadConf(GlobalContext.getContext());
        }
        ArrayList<SupportLanguageItemModel> supportList = LoadSupportListUtils.getSupportList(hashMap, hashMap2);
        ArrayList arrayList = new ArrayList();
        if (supportList == null || supportList.isEmpty()) {
            return getDefaultList();
        }
        for (SupportLanguageItemModel lang : supportList) {
            arrayList.add(LocaleUtils.tagToLocale(lang.getLang()));
        }
        return arrayList;
    }

    public Locale getCurrentLocale() {
        return LocaleUtils.tagToLocale(m14873b());
    }

    public String getCurrentLocaleTag() {
        return m14873b();
    }

    public Locale getCurrentLang() {
        return LocaleUtils.tagToLocale(m14870a());
    }

    public String getCurrentLangTag() {
        return m14870a();
    }
}
