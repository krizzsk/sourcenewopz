package com.didi.foundation.sdk.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.didi.foundation.sdk.mlocale.LoadSupportListUtils;
import com.didi.foundation.sdk.mlocale.LocaleConstant;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.foundation.sdk.utils.LogUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.GlobalCountryCode;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.base.BaseDataLoader;
import com.global.didi.elvish.language.LanguageModel;
import com.global.didi.elvish.language.SupportLanguageItemModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function1;

@ServiceProvider({LocaleServiceProvider.class})
public class LocaleServiceImpl implements LocaleServiceProvider {

    /* renamed from: a */
    private static Logger f21306a = LoggerFactory.getLogger("LocaleServiceImpl");

    /* renamed from: b */
    private static final String f21307b = "locale_sp";

    /* renamed from: c */
    private static final String f21308c = "current_locale";

    /* renamed from: d */
    private static final String f21309d = "current_real_locale";

    /* renamed from: e */
    private static final String f21310e = "current_rlab_locale";

    /* renamed from: f */
    private final ArrayList<LocaleServiceProvider.OnLocaleChangedListener> f21311f = new ArrayList<>();

    /* renamed from: g */
    private SharedPreferences f21312g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Context f21313h;

    /* renamed from: i */
    private boolean f21314i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LocaleConfig f21315j;

    /* renamed from: k */
    private String f21316k = "";

    /* renamed from: l */
    private String f21317l = "";

    public List<Locale> getDefaultList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Locale("en-US"));
        return arrayList;
    }

    public void init(Context context) {
        if (context != null) {
            this.f21314i = true;
            this.f21313h = context;
            this.f21312g = SystemUtils.getSharedPreferences(context, f21307b, 0);
            LocaleUtils.initCofnigLocale();
            LocaleConfig localeConfig = ((LocaleConfigServiceProvider) ServiceLoader.load(LocaleConfigServiceProvider.class).get()).getLocaleConfig();
            this.f21315j = localeConfig;
            if (localeConfig.preInitCB != null) {
                this.f21315j.preInitCB.onPreInit(context);
            }
            LocaleUtils.isGlobal = this.f21315j.isGlobal;
            LocaleUtils.isDubug = this.f21315j.isDebug;
            LanguageModel a = m15650a(m15651a());
            m15652a((Intent) null, LocaleUtils.tagToLocale(a.getLocale()));
            try {
                String[] split = a.getLocale().split("-");
                Elvish.Companion.init(context, a.getLocale(), LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale), split.length > 1 ? split[split.length - 1] : GlobalCountryCode.AMERICA, this.f21315j.city_id);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils logUtils = LogUtils.INSTANCE;
                logUtils.mo63518d("locale is null:" + e.getMessage());
            }
        } else {
            throw new NullPointerException("context is null!");
        }
    }

    /* renamed from: a */
    private LanguageModel m15650a(Locale locale) {
        LanguageModel loadLanguageConfig = new BaseDataLoader().loadLanguageConfig(this.f21313h, locale, this.f21315j.isGlobal, (Function1<? super Context, ? extends Map<String, Object>>) new Function1<Context, Map<String, Object>>() {
            public Map<String, Object> invoke(Context context) {
                if (LocaleServiceImpl.this.f21315j.remoteLanguageConfData != null) {
                    return LocaleServiceImpl.this.f21315j.remoteLanguageConfData.loadConf(LocaleServiceImpl.this.f21313h);
                }
                LogUtils.INSTANCE.mo63518d("remoteLanguageConfData is null,now is empty");
                return new HashMap();
            }
        }, (Function1<? super Context, ? extends Map<String, Object>>) new Function1<Context, Map<String, Object>>() {
            public Map<String, Object> invoke(Context context) {
                if (LocaleServiceImpl.this.f21315j.localAssetsLanguageConfData != null) {
                    return LocaleServiceImpl.this.f21315j.localAssetsLanguageConfData.loadConf(LocaleServiceImpl.this.f21313h);
                }
                LogUtils.INSTANCE.mo63518d("localAssetsLanguageConfData is null,now is empty");
                return new HashMap();
            }
        });
        Logger logger = f21306a;
        logger.info("calculateAppLocale called: from Elvish：language = " + loadLanguageConfig.toString(), new Object[0]);
        this.f21316k = loadLanguageConfig.getLang();
        this.f21317l = loadLanguageConfig.getLocale();
        return loadLanguageConfig;
    }

    /* renamed from: a */
    private Locale m15651a() {
        String str;
        String b = m15660b();
        f21306a.info("calculateAppLocale called: from Elvish", new Object[0]);
        if (TextUtils.isEmpty(b)) {
            f21306a.info("无缓存的lang————————————————", new Object[0]);
            str = LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale);
        } else {
            f21306a.info("存在缓存的lang————————————————", new Object[0]);
            String localeToTag = LocaleUtils.localeToTag(new Locale(LocaleUtils.tagToLocale(b).getLanguage(), LocaleUtils.getSysLocale().getCountry()));
            Logger logger = f21306a;
            logger.info("oldLang:" + b, new Object[0]);
            str = localeToTag;
        }
        Logger logger2 = f21306a;
        logger2.info("target4Checklocale:" + str, new Object[0]);
        Logger logger3 = f21306a;
        logger3.info("defaultConfigLocale:" + LocaleUtils.defaultConfigLocale.toString(), new Object[0]);
        Logger logger4 = f21306a;
        logger4.info("sysLocale:" + LocaleUtils.getSysLocale().toString(), new Object[0]);
        return LocaleUtils.tagToLocale(str);
    }

    /* renamed from: a */
    private void m15656a(String str, String str2) {
        m15655a(str);
        m15661b(str2);
    }

    /* renamed from: b */
    private boolean m15663b(String str, String str2) {
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        return str.split("-")[0].equals(str2.split("-")[0]);
    }

    public Context attachBaseContext(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? m15648a(context) : context;
    }

    /* renamed from: a */
    private Context m15648a(Context context) {
        Resources resources;
        if (!this.f21314i) {
            init(context);
        }
        if (context.getApplicationContext() == null) {
            resources = context.getResources();
        } else {
            resources = context.getApplicationContext().getResources();
        }
        Locale tagToLocale = LocaleUtils.tagToLocale(m15665c());
        Logger logger = f21306a;
        logger.info("updateResources:locale is " + tagToLocale, new Object[0]);
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(tagToLocale);
        LocaleList localeList = new LocaleList(new Locale[]{tagToLocale});
        configuration.setLocales(localeList);
        LocaleList.setDefault(localeList);
        Locale.setDefault(tagToLocale);
        LocaleUtils.initCofnigLocale();
        return context.createConfigurationContext(configuration);
    }

    public Locale switchLocale(Intent intent, String str) {
        return switchLocale(intent, LocaleUtils.tagToLocale(str));
    }

    public Locale switchLocale(Intent intent, Locale locale) {
        Locale locale2;
        String str;
        try {
            String localeToTag = LocaleUtils.localeToTag(locale);
            String substring = localeToTag.substring(0, localeToTag.indexOf("-"));
            String[] split = LocaleUtils.getSysLocaleTag().split("-");
            int length = split.length;
            if (length == 2) {
                str = split[1];
            } else if (length != 3) {
                str = GlobalCountryCode.AMERICA;
                m15666c(LocaleConstant.ERROR_SWITCH_SPLIT, "sysLocale:" + LocaleUtils.getSysLocaleTag());
            } else {
                str = split[2];
            }
            locale2 = new Locale(substring, str);
        } catch (Exception e) {
            e.printStackTrace();
            locale2 = getCurrentLocale();
            m15666c(LocaleConstant.ERROR_SWITCH_EXCEPTION, e.getMessage());
        }
        LanguageModel a = m15650a(locale2);
        Locale tagToLocale = LocaleUtils.tagToLocale(a.getLang());
        if (m15664b(tagToLocale)) {
            return tagToLocale;
        }
        return m15652a(intent, LocaleUtils.tagToLocale(a.getLocale()));
    }

    /* renamed from: c */
    private void m15666c(String str, String str2) {
        LocaleConfig localeConfig = this.f21315j;
        if (localeConfig != null && localeConfig.errorTrackCallBack != null) {
            try {
                this.f21315j.errorTrackCallBack.trackError(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Locale getCurrentLocale() {
        return LocaleUtils.tagToLocale(m15665c());
    }

    public String getCurrentLocaleTag() {
        return m15665c();
    }

    public Locale getCurrentLang() {
        return LocaleUtils.tagToLocale(m15660b());
    }

    public String getCurrentLangTag() {
        return m15660b();
    }

    public List<Locale> getSupportLocaleList() {
        Map hashMap = new HashMap();
        if (!(this.f21315j.remoteLanguageConfData == null || this.f21315j.remoteLanguageConfData.loadConf(this.f21313h) == null)) {
            hashMap = this.f21315j.remoteLanguageConfData.loadConf(this.f21313h);
        }
        Map hashMap2 = new HashMap();
        if (!(this.f21315j.localAssetsLanguageConfData == null || this.f21315j.localAssetsLanguageConfData.loadConf(this.f21313h) == null)) {
            hashMap2 = this.f21315j.localAssetsLanguageConfData.loadConf(this.f21313h);
        }
        ArrayList<SupportLanguageItemModel> supportList = LoadSupportListUtils.getSupportList(hashMap, hashMap2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (supportList == null || supportList.isEmpty()) {
            List<Locale> defaultList = getDefaultList();
            m15666c(LocaleConstant.ERROR_SUPPORT_LIST, "remote size:" + hashMap.size() + ",locale size:" + hashMap2.size());
            return defaultList;
        }
        for (SupportLanguageItemModel next : supportList) {
            if (m15662b(next)) {
                arrayList2.add(next);
            } else {
                arrayList.add(LocaleUtils.tagToLocale(next.getLang()));
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        arrayList.add(m15653a((List<SupportLanguageItemModel>) arrayList2));
        return arrayList;
    }

    /* renamed from: a */
    private Locale m15653a(List<SupportLanguageItemModel> list) {
        if (list == null || list.isEmpty()) {
            return LocaleUtils.tagToLocale("es-MX");
        }
        String country = LocaleUtils.getSysLocale().getCountry();
        for (SupportLanguageItemModel next : list) {
            if (country.equals(m15658a(next)[1])) {
                return LocaleUtils.tagToLocale(next.getLang());
            }
        }
        return LocaleUtils.tagToLocale(list.get(0).getLang());
    }

    /* renamed from: a */
    private String[] m15658a(SupportLanguageItemModel supportLanguageItemModel) {
        return supportLanguageItemModel.getLang().split("-");
    }

    /* renamed from: b */
    private boolean m15662b(SupportLanguageItemModel supportLanguageItemModel) {
        String[] a = m15658a(supportLanguageItemModel);
        return a.length > 0 && "es".equals(a[0]);
    }

    /* renamed from: b */
    private boolean m15664b(Locale locale) {
        return TextUtils.equals(LocaleUtils.localeToTag(locale), m15660b());
    }

    /* renamed from: a */
    private Locale m15652a(Intent intent, Locale locale) {
        String localeToTag = LocaleUtils.localeToTag(locale);
        Logger logger = f21306a;
        logger.debug("switchLocale: targetLocale is " + localeToTag, new Object[0]);
        Resources resources = this.f21313h.getResources();
        Configuration configuration = resources.getConfiguration();
        m15654a(configuration, locale);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        String c = m15665c();
        if (c.isEmpty()) {
            c = LocaleUtils.getSysLocaleTag();
        }
        m15656a(this.f21316k, localeToTag);
        if (Build.VERSION.SDK_INT >= 24) {
            m15648a(this.f21313h);
        }
        resources.updateConfiguration(configuration, displayMetrics);
        LocaleUtils.initCofnigLocale();
        m15657a(LocaleUtils.tagToLocale(c), locale);
        Logger logger2 = f21306a;
        logger2.info("internalSwitchLocale:locale is " + locale, new Object[0]);
        if (intent != null) {
            f21306a.debug("switchLocale recreate", new Object[0]);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.f21313h.startActivity(intent);
        }
        return locale;
    }

    public void addOnLocaleChangedListener(LocaleServiceProvider.OnLocaleChangedListener onLocaleChangedListener) {
        this.f21311f.add(onLocaleChangedListener);
    }

    public void removeOnLocaleChangedListener(LocaleServiceProvider.OnLocaleChangedListener onLocaleChangedListener) {
        this.f21311f.remove(onLocaleChangedListener);
    }

    /* renamed from: a */
    private void m15657a(Locale locale, Locale locale2) {
        if (!this.f21311f.isEmpty()) {
            for (int i = 0; i < this.f21311f.size(); i++) {
                this.f21311f.get(i).onLocaleChanged(locale, locale2);
            }
        }
    }

    public List<LocaleServiceProvider.OnLocaleChangedListener> getOnLocaleChangedListeners() {
        return new ArrayList(this.f21311f);
    }

    public void refreshLocale(Context context) {
        Locale tagToLocale = LocaleUtils.tagToLocale(m15665c());
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(tagToLocale);
            LocaleList localeList = new LocaleList(new Locale[]{tagToLocale});
            configuration.setLocales(localeList);
            LocaleList.setDefault(localeList);
        } else {
            configuration.locale = tagToLocale;
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    /* renamed from: a */
    private void m15655a(String str) {
        if (this.f21312g == null) {
            f21306a.info("saveLang:mPreferences is null", new Object[0]);
            return;
        }
        Logger logger = f21306a;
        logger.info("saveLang:" + str, new Object[0]);
        this.f21312g.edit().putString(f21308c, str).apply();
    }

    /* renamed from: b */
    private String m15660b() {
        SharedPreferences sharedPreferences = this.f21312g;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f21308c, this.f21316k);
        }
        f21306a.info("getLangFromSP:mPreferences is null", new Object[0]);
        return "";
    }

    /* renamed from: b */
    private void m15661b(String str) {
        if (this.f21312g == null) {
            f21306a.info("saveLocale:mPreferences is null", new Object[0]);
            return;
        }
        Logger logger = f21306a;
        logger.info("saveLocale:mPreferences is " + str, new Object[0]);
        str.replace("_", "-");
        this.f21312g.edit().putString(f21309d, str).apply();
    }

    /* renamed from: c */
    private String m15665c() {
        SharedPreferences sharedPreferences = this.f21312g;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(f21309d, this.f21317l);
        if (!TextUtils.isEmpty(string)) {
            string = string.replace("_", "-");
        }
        if (string != null) {
            return string;
        }
        f21306a.info("getLocaleFromSP:localeTag is null", new Object[0]);
        return "en-US";
    }

    /* renamed from: a */
    private void m15654a(Configuration configuration, Locale locale) {
        if (configuration != null && locale != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                configuration.setLocale(locale);
            } else {
                configuration.locale = locale;
            }
        }
    }
}
