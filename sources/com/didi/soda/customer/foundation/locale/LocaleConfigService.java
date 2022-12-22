package com.didi.soda.customer.foundation.locale;

import android.content.Context;
import android.text.TextUtils;
import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didi.foundation.sdk.service.LocaleConfig;
import com.didi.foundation.sdk.service.LocaleConfigServiceProvider;
import com.didi.foundation.sdk.utils.FileUtils;
import com.didi.foundation.sdk.utils.FoundationApolloUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider({LocaleConfigServiceProvider.class})
public class LocaleConfigService implements LocaleConfigServiceProvider {
    public LocaleConfig getLocaleConfig() {
        LocaleConfig localeConfig = new LocaleConfig();
        localeConfig.isGlobal = false;
        localeConfig.isDebug = CustomerToolBoxUtil.DEBUG;
        localeConfig.localAssetsLanguageConfData = $$Lambda$LocaleConfigService$scr27cAYR49iI7QVVeDxzqsOn0.INSTANCE;
        localeConfig.preInitCB = $$Lambda$LocaleConfigService$ot2WcyBSzI9Q7uBRc7mljuYmiU.INSTANCE;
        localeConfig.remoteLanguageConfData = $$Lambda$LocaleConfigService$ID_g21eu2xq5lN_ASZ9dIqsIQLw.INSTANCE;
        localeConfig.errorTrackCallBack = $$Lambda$LocaleConfigService$y3f2u1SY3EUvvrSivHklRgWa7Q.INSTANCE;
        return localeConfig;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ Map m29085c(Context context) {
        if (context == null) {
            context = GlobalContext.getContext();
        }
        Map map = (Map) GsonUtil.fromJson(FileUtils.INSTANCE.getFormAssets(context, "local_rlab_language_config.json"), new HashMap().getClass());
        return map == null ? new HashMap() : map;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m29084b(Context context) {
        CustomerApolloUtil.addParameters();
        Apollo.addCacheLoadedListener($$Lambda$LocaleConfigService$vywqoKgv9ZlKB8UOtiqiTCGE2Xo.INSTANCE);
        Apollo.addToggleStateChangeListener($$Lambda$LocaleConfigService$rTjOAqAJy6KnLV0SGNrVDDAu9U.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m29083b() {
        String localeLangkMessages = FoundationApolloUtil.getLocaleLangkMessages("sailing_rlab_founding_configuration");
        LocaleStorageConfig localeStorageConfig = new LocaleStorageConfig();
        localeStorageConfig.mJsonStr = localeLangkMessages;
        new LocaleStorage(FoundationApplicationListener.getApplication()).setData(localeStorageConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29081a() {
        String localeLangkMessages = FoundationApolloUtil.getLocaleLangkMessages("sailing_rlab_founding_configuration");
        LocaleStorageConfig localeStorageConfig = new LocaleStorageConfig();
        localeStorageConfig.mJsonStr = localeLangkMessages;
        new LocaleStorage(FoundationApplicationListener.getApplication()).setData(localeStorageConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Map m29080a(Context context) {
        String localeLangkMessages = FoundationApolloUtil.getLocaleLangkMessages("sailing_rlab_founding_configuration");
        if (TextUtils.isEmpty(localeLangkMessages)) {
            localeLangkMessages = new LocaleStorage(context).getData().mJsonStr;
        }
        Map map = (Map) GsonUtil.fromJson(localeLangkMessages, new HashMap().getClass());
        return map == null ? new HashMap() : map;
    }
}
