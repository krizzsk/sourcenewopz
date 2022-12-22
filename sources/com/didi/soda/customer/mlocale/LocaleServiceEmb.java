package com.didi.soda.customer.mlocale;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.foundation.sdk.mlocale.LoadSupportListUtils;
import com.didi.foundation.sdk.service.LocaleConfig;
import com.didi.foundation.sdk.service.LocaleConfigServiceProvider;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.app.GlobalContext;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.global.didi.elvish.language.SupportLanguageItemModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class LocaleServiceEmb {

    /* renamed from: b */
    private static final String f41379b = "locale_sp";

    /* renamed from: c */
    private static final String f41380c = "current_locale";

    /* renamed from: d */
    private static final String f41381d = "current_real_locale";

    /* renamed from: l */
    private static LocaleServiceEmb f41382l;

    /* renamed from: a */
    private Logger f41383a = LoggerFactory.getLogger("LocaleServiceImpl");

    /* renamed from: e */
    private final ArrayList<LocaleServiceProvider.OnLocaleChangedListener> f41384e = new ArrayList<>();

    /* renamed from: f */
    private SharedPreferences f41385f;

    /* renamed from: g */
    private Context f41386g;

    /* renamed from: h */
    private boolean f41387h;

    /* renamed from: i */
    private LocaleConfig f41388i = new LocaleConfig();

    /* renamed from: j */
    private String f41389j = "";

    /* renamed from: k */
    private String f41390k = "";

    public static LocaleServiceEmb getInstance() {
        if (f41382l == null) {
            synchronized (LocaleServiceEmb.class) {
                if (f41382l == null) {
                    f41382l = new LocaleServiceEmb();
                }
            }
        }
        return f41382l;
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
            this.f41387h = true;
            this.f41386g = context;
            this.f41385f = SystemUtils.getSharedPreferences(context, f41379b, 0);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "en-US";
                }
                CustomerElvish.Companion.init(context, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LocaleConfig localeConfig = ((LocaleConfigServiceProvider) ServiceLoader.load(LocaleConfigServiceProvider.class).get()).getLocaleConfig();
            this.f41388i = localeConfig;
            LocaleUtils.isGlobal = localeConfig.isGlobal;
            LocaleUtils.isDubug = this.f41388i.isDebug;
            m29311a(str);
        }
    }

    /* renamed from: a */
    private void m29311a(String str) {
        this.f41383a.info("calculateAppLocale called: from CustomerElvish", new Object[0]);
        Logger logger = this.f41383a;
        logger.info("rlab_locale:" + str, new Object[0]);
        LanguageModel languageAndLocale = CustomerElvish.Companion.getInstance().getLanguageAndLocale(this.f41386g, LocaleUtils.tagToLocale(str), LocaleUtils.isGlobal);
        Logger logger2 = this.f41383a;
        logger2.info("calculateAppLocale called: from CustomerElvish：language = " + languageAndLocale.toString(), new Object[0]);
        this.f41389j = languageAndLocale.getLang();
        String locale = languageAndLocale.getLocale();
        this.f41390k = locale;
        m29312a(this.f41389j, locale);
    }

    /* renamed from: a */
    private void m29312a(String str, String str2) {
        m29314b(str);
        m29315c(str2);
    }

    /* renamed from: b */
    private void m29314b(String str) {
        SharedPreferences sharedPreferences = this.f41385f;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f41380c, str).apply();
        }
    }

    /* renamed from: a */
    private String m29310a() {
        SharedPreferences sharedPreferences = this.f41385f;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(f41380c, this.f41389j);
    }

    /* renamed from: c */
    private void m29315c(String str) {
        if (this.f41385f != null) {
            str.replace("_", "-");
            this.f41385f.edit().putString(f41381d, str).apply();
        }
    }

    /* renamed from: b */
    private String m29313b() {
        SharedPreferences sharedPreferences = this.f41385f;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(f41381d, this.f41390k);
        if (!TextUtils.isEmpty(string)) {
            string = string.replace("_", "-");
        }
        return string == null ? "en-US" : string;
    }

    public List<Locale> getSupportLocaleList() {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (!(this.f41388i.remoteLanguageConfData == null || this.f41388i.remoteLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap = this.f41388i.remoteLanguageConfData.loadConf(GlobalContext.getContext());
        }
        if (!(this.f41388i.localAssetsLanguageConfData == null || this.f41388i.localAssetsLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap2 = this.f41388i.localAssetsLanguageConfData.loadConf(GlobalContext.getContext());
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
        return LocaleUtils.tagToLocale(m29313b());
    }

    public String getCurrentLocaleTag() {
        return m29313b();
    }

    public Locale getCurrentLang() {
        return LocaleUtils.tagToLocale(m29310a());
    }

    public String getCurrentLangTag() {
        return m29310a();
    }
}
