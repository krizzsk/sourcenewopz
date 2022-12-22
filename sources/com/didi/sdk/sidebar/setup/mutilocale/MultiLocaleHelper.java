package com.didi.sdk.sidebar.setup.mutilocale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.GlobalScreenFitHelper;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.language.LanguageModel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class MultiLocaleHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Logger f37433a = LoggerFactory.getLogger("MultiLocaleHelper");
    protected MainActivity mainActivity;

    public abstract Locale code2SupportLocale(String str);

    public MultiLocaleHelper() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        try {
            DIDIApplication.getAppContext().registerReceiver(new LocaleChangeReceiver(), intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        m26607b();
    }

    /* renamed from: b */
    private void m26607b() {
        Locale defaultLocale = MultiLocaleUtil.getDefaultLocale();
        if (defaultLocale != null) {
            final String str = defaultLocale.getLanguage() + "-" + defaultLocale.getCountry();
            ActivityLifecycleManager.getInstance().addAppStateListener(new ActivityLifecycleManager.AppStateListener() {
                public void onStateChanged(int i) {
                    if (i == 1) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("lang", str);
                        hashMap.put("current_lang", MultiLocaleStore.getInstance().getLocaleCode());
                        Logger a = MultiLocaleHelper.f37433a;
                        a.info("add systemlang trace = " + str, new Object[0]);
                        OmegaSDKAdapter.trackEvent("phone_system_lang", (Map<String, Object>) hashMap);
                    }
                }
            });
        }
    }

    public void initAppLocale(Context context) {
        MultiLocaleUtil.initSystemLocale();
        calculateAppLocale(context);
    }

    /* renamed from: a */
    private void m26605a(Context context) {
        f37433a.info("calculateAppLocale called: from Elvish", new Object[0]);
        LanguageModel languageAndLocale = Elvish.Companion.getLanguageAndLocale(context, MultiLocaleUtil.sysLocale.getLanguage(), MultiLocaleUtil.sysLocale.getCountry(), AppUtils.isGlobalApp(context));
        Logger logger = f37433a;
        logger.info("calculateAppLocale called: from Elvish：language = " + languageAndLocale.toString(), new Object[0]);
        Locale settingLocale = languageAndLocale.getSettingLocale();
        MultiLocaleUtil.languageModel = languageAndLocale;
        MultiLocaleStore.getInstance().notifyLocaleChange(MultiLocaleStore.getInstance().getLocaleCode(), languageAndLocale.getLang());
        m26606a(context, settingLocale);
    }

    /* access modifiers changed from: protected */
    public void calculateAppLocale(Context context) {
        m26605a(context);
    }

    public void refreshAppLocale(Context context) {
        String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        Logger logger = f37433a;
        logger.info("refreshAppLocale called : locale code = " + localeCode, new Object[0]);
        Locale code2SupportLocale = code2SupportLocale(localeCode);
        m26606a(context, code2SupportLocale);
        m26606a(context.getApplicationContext(), code2SupportLocale);
    }

    public Locale getLocale() {
        String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        Logger logger = f37433a;
        logger.info("appLocale called : locale code = " + localeCode, new Object[0]);
        return code2SupportLocale(localeCode);
    }

    /* renamed from: a */
    private static void m26606a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        if (Apollo.getToggle("global_fit_screen").allow()) {
            GlobalScreenFitHelper.startFitSingleContext(context);
        }
        Logger logger = f37433a;
        logger.info("updateLocale2Cfg called: locale = " + locale, new Object[0]);
    }

    public void setMainActivity(MainActivity mainActivity2) {
        this.mainActivity = mainActivity2;
    }

    class LocaleChangeReceiver extends BroadcastReceiver {
        LocaleChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                MultiLocaleHelper.f37433a.info("LocaleChangeReceiver onReceive...", new Object[0]);
                MultiLocaleUtil.initSystemLocale();
                MultiLocaleHelper.this.calculateAppLocale(context);
                MultiLocaleHelper.this.reInitElvish(context);
            }
        }
    }

    public boolean needChangeLocaleCode() {
        IToggle toggle = Apollo.getToggle("switch_from_ENUS_to_ENBR");
        return toggle != null && toggle.allow();
    }

    public String getLocaleCode() {
        return MultiLocaleStore.getInstance().getLocaleCode();
    }

    /* access modifiers changed from: protected */
    public void reInitElvish(Context context) {
        try {
            Elvish.Companion.init(context, MultiLocaleStore.getInstance().getLocaleCode(), MultiLocaleUtil.getLanguageModel().getLocale(), NationTypeUtil.getNationComponentData().getLocCountry(), NationTypeUtil.getNationComponentData().getCityId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger logger = f37433a;
        logger.info("reInitElvish getLocaleCode : " + MultiLocaleStore.getInstance().getLocaleCode(), new Object[0]);
        Logger logger2 = f37433a;
        logger2.info("reInitElvish getLocCountry : " + NationTypeUtil.getNationComponentData().getLocCountry(), new Object[0]);
        Logger logger3 = f37433a;
        logger3.info("reInitElvish getCityId : " + NationTypeUtil.getNationComponentData().getCityId(), new Object[0]);
    }
}
