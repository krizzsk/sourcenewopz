package com.didi.sdk.sidebar.setup.mutilocale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Locale;

public class MultiLocaleHelperImpl extends MultiLocaleHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Logger f37434a = LoggerFactory.getLogger("multilocale-debug");

    public MultiLocaleHelperImpl() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        try {
            DIDIApplication.getAppContext().registerReceiver(new LocaleChangeReceiver(), intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void initAppLocale(Context context) {
        calculateAppLocale(context);
    }

    public Locale code2SupportLocale(String str) {
        Locale locale = null;
        if (TextUtils.isEmpty(str)) {
            f37434a.error("code2SupportLocale localeCode is null ", new Object[0]);
            return null;
        }
        String[] split = str.split("-");
        if (split.length == 2) {
            locale = new Locale(split[0], split[1]);
        }
        return locale == null ? Locale.US : locale;
    }

    class LocaleChangeReceiver extends BroadcastReceiver {
        LocaleChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                MultiLocaleHelperImpl.f37434a.info("LocaleChangeReceiver onReceive...", new Object[0]);
                MultiLocaleHelperImpl.this.calculateAppLocale(context);
                MultiLocaleHelperImpl.this.reInitElvish(context);
            }
        }
    }
}
