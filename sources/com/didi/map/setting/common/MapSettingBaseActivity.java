package com.didi.map.setting.common;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.setting.common.utils.DLog;
import com.didi.map.setting.common.utils.MapSettingUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.GlobalCountryCode;
import java.util.Locale;

public class MapSettingBaseActivity extends FragmentActivity {
    protected IMapSettingDelegate mDelegate;
    protected IMapSettingPreferences mPreferences;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
    }

    public void dealBackView(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapSettingBaseActivity.this.finish();
            }
        });
    }

    public void dealTitleView(View view, String str) {
        ((TextView) view).setText(str);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        MapSettingSP.getInstance(this).destroy();
        if (this.mPreferences != null) {
            this.mPreferences = null;
        }
        if (this.mDelegate != null) {
            this.mDelegate = null;
        }
    }

    public void onBackPressed() {
        if (!MapSettingUtils.isFastDoubleClick()) {
            super.onBackPressed();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        this.mPreferences = MapSettingFactory.createMapPreferences(context);
        IMapSettingDelegate createMapDelegate = MapSettingFactory.createMapDelegate(context);
        this.mDelegate = createMapDelegate;
        if (this.mPreferences == null || createMapDelegate == null) {
            finish();
            return;
        }
        String language = context.getResources().getConfiguration().locale.getLanguage();
        DLog.m20371d("default language = " + language, new Object[0]);
        DLog.m20371d("PlatInfo country code = " + PlatInfo.getInstance().getCountryCode(), new Object[0]);
        DLog.m20371d("PlatInfo country language = " + PlatInfo.getInstance().getCountryLanguage(), new Object[0]);
        if (!TextUtils.isEmpty(PlatInfo.getInstance().getCountryLanguage())) {
            language = PlatInfo.getInstance().getCountryLanguage();
        } else if (!TextUtils.isEmpty(this.mDelegate.getLanguage(PlatInfo.getInstance().getCountryCode()))) {
            language = this.mDelegate.getLanguage(PlatInfo.getInstance().getCountryCode());
        }
        DLog.m20371d("after setting language = " + language, new Object[0]);
        Context createConfigurationContext = createConfigurationContext(context, language);
        if (createConfigurationContext != null) {
            context = createConfigurationContext;
        }
        super.attachBaseContext(context);
    }

    public Context createConfigurationContext(Context context, String str) {
        if (context == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Resources resources = context.getResources();
        Locale a = m20365a(str);
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(a);
        configuration.setLocales(new LocaleList(new Locale[]{a}));
        return context.createConfigurationContext(configuration);
    }

    /* renamed from: a */
    private Locale m20365a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.indexOf("-") <= 0) {
            return new Locale(str);
        }
        String[] split = str.split("-");
        String str2 = split[0];
        String str3 = split[1];
        if (!TextUtils.isEmpty(str3)) {
            return new Locale(str2, str3);
        }
        return new Locale("en", GlobalCountryCode.AMERICA);
    }
}
