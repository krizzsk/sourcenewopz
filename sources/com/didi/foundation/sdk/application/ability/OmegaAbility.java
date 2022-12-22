package com.didi.foundation.sdk.application.ability;

import android.app.Application;
import android.text.TextUtils;
import com.didi.foundation.sdk.location.LocationConfigService;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.foundation.sdk.service.DeviceService;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.service.VariantConfigService;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.mas.sdk.quality.init.MASSDK;
import com.didichuxing.mas.sdk.quality.report.MASCallback;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didichuxing.swarm.launcher.toolkit.HotPatchService;
import com.didichuxing.swarm.toolkit.PluginInfoService;
import com.didichuxing.swarm.toolkit.TimeService;
import java.util.HashMap;
import java.util.Locale;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class OmegaAbility {
    private OmegaAbility() {
    }

    public static void init(Application application) {
        initOldOmegaSDK(application);
        initMasSDK(application);
    }

    public static void initOldOmegaSDK(Application application) {
        OmegaSDK.setUploadHost(VariantConfigService.getInstance().omegaUploadHost());
        Omega.setGetDailingCountryCode(new OmegaConfig.IGetDailingCountryCode() {
            public String getDailingCountryCode() {
                return AccountService.getInstance().getCountryCode();
            }
        });
        Omega.setCustomLocale(new OmegaConfig.ILocale() {
            public String getLocale() {
                return LocaleUtils.localeToTag(LocaleService.getInstance().getCurrentLang());
            }
        });
        OmegaSDK.setGetPhone(new OmegaConfig.IGetPhone() {
            public String getPhone() {
                return AccountService.getInstance().getPhone();
            }
        });
        OmegaSDK.setGetUid(new OmegaConfig.IGetUid() {
            public String getDidiPassengerUid() {
                return AccountService.getInstance().getUid();
            }
        });
        OmegaSDK.setGetCityId(new OmegaConfig.IGetCityId() {
            public int getCityId() {
                if (TextUtils.isEmpty(AccountService.getInstance().getCityId())) {
                    return 0;
                }
                try {
                    return Integer.parseInt(AccountService.getInstance().getCityId());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });
        OmegaSDK.setCountyId(m15582b());
        OmegaSDK.switchFullUIAutoTracker(!Apollo.getToggle("omega_close_auto_ui").allow());
        OmegaSDK.init(application);
        LocaleService.getInstance().addOnLocaleChangedListener(new LocaleServiceProvider.OnLocaleChangedListener() {
            public void onLocaleChanged(Locale locale, final Locale locale2) {
                Omega.setCustomLocale(new OmegaConfig.ILocale() {
                    public String getLocale() {
                        return LocaleUtils.localeToTag(locale2);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m15582b() {
        if (TextUtils.isEmpty(LocationConfigService.getInstance().getCountyId())) {
            return 0;
        }
        try {
            return Integer.parseInt(LocationConfigService.getInstance().getCountyId());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void initMasSDK(final Application application) {
        Apollo.addToggleStateChangeListener(new OnToggleStateChangeListener() {
            public void onStateChanged() {
                OmegaAbility.m15585c(application);
            }
        });
        Apollo.addCacheLoadedListener(new OnCacheLoadedListener() {
            public void onCacheAlreadyLoaded() {
                OmegaAbility.m15585c(application);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m15585c(final Application application) {
        new Thread(new Runnable() {
            public void run() {
                OmegaAbility.m15587d(application);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m15587d(Application application) {
        MASSDK.setBanLogcatUpload(true);
        MASSDK.setOmegaSDKVersion(OmegaConfig.SDK_VERSION);
        MASSDK.launch(application);
        m15584c();
        m15586d();
    }

    /* renamed from: c */
    private static void m15584c() {
        MASSDK.setGetUid(new MASConfig.IGetUid() {
            public String getUid() {
                return AccountService.getInstance().getUid();
            }
        });
        MASSDK.setGetPhone(new MASConfig.IGetPhone() {
            public String getPhone() {
                return AccountService.getInstance().getPhone();
            }
        });
        MASSDK.setGetCityId(new MASConfig.IGetCityId() {
            public int getCityId() {
                if (TextUtils.isEmpty(AccountService.getInstance().getCityId())) {
                    return 0;
                }
                try {
                    return Integer.parseInt(AccountService.getInstance().getCityId());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });
        MASSDK.setGetChannel(new MASConfig.IGetChannel() {
            public String getChannel() {
                return SystemUtil.getChannelId();
            }
        });
        MASSDK.setGetUiCid(new MASConfig.IGetUiCid() {
            public String getUiCid() {
                return AccountService.getInstance().getUid();
            }
        });
        MASSDK.setGetDidiDeviceId(new MASConfig.IGetDidiDeviceId() {
            public String getDidiDeviceId() {
                return DeviceService.getInstance().getDeviceId();
            }
        });
    }

    /* renamed from: d */
    private static void m15586d() {
        MASSDK.setUploadHost(VariantConfigService.getInstance().omegaUploadHost());
        MASSDK.setGetDailingCountryCode(new MASConfig.IGetDailingCountryCode() {
            public String getDailingCountryCode() {
                return AccountService.getInstance().getCountryCode();
            }
        });
        MASSDK.setCustomLocale(new MASConfig.ILocale() {
            public String getLocale() {
                return LocaleUtils.localeToTag(LocaleService.getInstance().getCurrentLang());
            }
        });
        MASSDK.switchFullUIAutoTracker(!Apollo.getToggle("omega_close_auto_ui").allow());
        LocaleService.getInstance().addOnLocaleChangedListener(new LocaleServiceProvider.OnLocaleChangedListener() {
            public void onLocaleChanged(Locale locale, final Locale locale2) {
                MASSDK.setCustomLocale(new MASConfig.ILocale() {
                    public String getLocale() {
                        return LocaleUtils.localeToTag(locale2);
                    }
                });
            }
        });
        MASConfig.SWITCH_PRINT_TRACE_LOG = true;
        final Logger logger = LoggerFactory.getLogger(Constants.LOG_TAG);
        MASSDK.setPrintLogListener(new MASCallback.PrintLogListener() {
            public void printLog(int i, String str, Throwable th) {
                logger.info(str, th);
            }
        });
        MASSDK.setGetLocationConfig(new MASConfig.ILocationConfig() {
            public boolean isNeedUploadLocation() {
                return true;
            }
        });
        MASSDK.setGetDidiSuuid(new MASConfig.IGetDidiSuuid() {
            public String getDidiSuuid() {
                return null;
            }
        });
        MASSDK.setGetTimeOffset(new MASConfig.IGetTimeOffset() {
            public long getTimeOffset() {
                ServiceReference<S> serviceReference;
                TimeService timeService;
                BundleContext bundleContext = SwarmLauncher.getInstance().getFramework().getBundleContext();
                if (bundleContext == null || (serviceReference = bundleContext.getServiceReference(TimeService.class)) == null || (timeService = (TimeService) bundleContext.getService(serviceReference)) == null) {
                    return 0;
                }
                return timeService.getTimeDifference();
            }
        });
        MASSDK.setGetPluginInfo(new MASConfig.IGetPluginInfo() {
            public String getPluginInfo() {
                ServiceReference<S> serviceReference;
                PluginInfoService pluginInfoService;
                BundleContext bundleContext = SwarmLauncher.getInstance().getFramework().getBundleContext();
                if (bundleContext == null || (serviceReference = bundleContext.getServiceReference(PluginInfoService.class)) == null || (pluginInfoService = (PluginInfoService) bundleContext.getService(serviceReference)) == null) {
                    return "{}";
                }
                HashMap hashMap = new HashMap();
                if (pluginInfoService.getPluginInfo() == null) {
                    return "{}";
                }
                for (PluginInfoService.PluginInfo next : pluginInfoService.getPluginInfo()) {
                    hashMap.put(next.packageName, next.version);
                }
                return JsonUtil.map2Json(hashMap);
            }
        });
        MASSDK.setGetHotpatchVersion(new MASConfig.IGetHotPatchVersion() {
            public long getHotPatchVersion() {
                ServiceReference<S> serviceReference;
                HotPatchService hotPatchService;
                BundleContext bundleContext = SwarmLauncher.getInstance().getFramework().getBundleContext();
                if (bundleContext == null || (serviceReference = bundleContext.getServiceReference(HotPatchService.class)) == null || (hotPatchService = (HotPatchService) bundleContext.getService(serviceReference)) == null) {
                    return -1;
                }
                return hotPatchService.getVersion();
            }
        });
        MASSDK.setGetCountyId(new MASConfig.IGetCountryId() {
            public int getCountryId() {
                return OmegaAbility.m15582b();
            }
        });
    }
}
