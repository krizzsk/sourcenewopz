package com.didi.entrega.customer.foundation.locale;

import android.content.Context;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didi.foundation.sdk.service.LocaleConfig;
import com.didi.foundation.sdk.service.LocaleConfigServiceProvider;
import com.didi.foundation.sdk.utils.FileUtils;
import com.didi.foundation.sdk.utils.FoundationApolloUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider({LocaleConfigServiceProvider.class})
public class LocaleConfigService implements LocaleConfigServiceProvider {
    public LocaleConfig getLocaleConfig() {
        LocaleConfig localeConfig = new LocaleConfig();
        localeConfig.isGlobal = !GlobalContext.isBrazil();
        localeConfig.isDebug = CustomerToolBoxUtil.DEBUG;
        localeConfig.localAssetsLanguageConfData = $$Lambda$LocaleConfigService$C4Fg3sbCQRMLGD7mCTyqbVBQoA.INSTANCE;
        localeConfig.preInitCB = $$Lambda$LocaleConfigService$vPLAuMPrZOAmXehyXqATASOIWdY.INSTANCE;
        localeConfig.remoteLanguageConfData = $$Lambda$LocaleConfigService$mVp5ZqL44X0kulBbF1Y3WUyHjc.INSTANCE;
        localeConfig.errorTrackCallBack = $$Lambda$LocaleConfigService$jWUorLk3rFb03xbWdcB1GfSerF8.INSTANCE;
        return localeConfig;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ Map m14746c(Context context) {
        if (context == null) {
            context = GlobalContext.getContext();
        }
        Map map = (Map) GsonUtil.fromJson(FileUtils.INSTANCE.getFormAssets(context, "local_entrega_language_config.json"), new HashMap().getClass());
        return map == null ? new HashMap() : map;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m14745b(Context context) {
        CustomerApolloUtil.addParameters();
        Apollo.addCacheLoadedListener($$Lambda$LocaleConfigService$VyvQ98qMMqFG9n5D3D_5P3xEWG0.INSTANCE);
        Apollo.addToggleStateChangeListener($$Lambda$LocaleConfigService$Sk4nLBfhaT_nEtk7jxoCrdQ1RUw.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m14744b() {
        String localeLangkMessages = FoundationApolloUtil.getLocaleLangkMessages("sailing_rlab_entrega_founding_configuration");
        LocaleStorageConfig localeStorageConfig = new LocaleStorageConfig();
        localeStorageConfig.mJsonStr = localeLangkMessages;
        new LocaleStorage(FoundationApplicationListener.getApplication()).setData(localeStorageConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m14742a() {
        String localeLangkMessages = FoundationApolloUtil.getLocaleLangkMessages("sailing_rlab_entrega_founding_configuration");
        LocaleStorageConfig localeStorageConfig = new LocaleStorageConfig();
        localeStorageConfig.mJsonStr = localeLangkMessages;
        new LocaleStorage(FoundationApplicationListener.getApplication()).setData(localeStorageConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Map m14741a(Context context) {
        String localeLangkMessages = FoundationApolloUtil.getLocaleLangkMessages("sailing_rlab_entrega_founding_configuration");
        if (TextUtils.isEmpty(localeLangkMessages)) {
            localeLangkMessages = new LocaleStorage(context).getData().mJsonStr;
        }
        Map map = (Map) GsonUtil.fromJson(localeLangkMessages, new HashMap().getClass());
        return map == null ? new HashMap() : map;
    }
}
