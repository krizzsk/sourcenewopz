package com.didichuxing.apollo.sdk.swarm;

import android.app.Activity;
import android.app.Application;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IAppInfoDelegate;
import com.didichuxing.apollo.sdk.IUserInfoDelegate;
import com.didichuxing.apollo.sdk.log.ApolloErrorLog;
import com.didichuxing.apollo.sdk.log.ApolloLog;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.model.ConfigureData;
import com.didichuxing.apollo.sdk.swarm.impl.ToggleServiceImpl;
import com.didichuxing.swarm.launcher.toolkit.VersionService;
import com.didichuxing.swarm.runtime.SwarmPlugin;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.CityChangeEvent;
import com.didichuxing.swarm.toolkit.ConfigurationService;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.LocationChangeEvent;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.OnAuthenticationStateChangeListener;
import com.didichuxing.swarm.toolkit.OnCityChangeListener;
import com.didichuxing.swarm.toolkit.OnLocationChangeListener;
import com.didichuxing.swarm.toolkit.TransmissionService;
import com.didichuxing.swarm.toolkit.UserService;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ApolloActivator extends SwarmPlugin {

    /* renamed from: b */
    private static final String f45640b = "com.didichuxing.apollo.sdk.swarm";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f45641e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static String f45642f = "";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static String f45643g = "";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static String f45644h = "";

    /* renamed from: i */
    private static final String f45645i = "+86";

    /* renamed from: l */
    private static final String f45646l = "-1";

    /* renamed from: a */
    private final ToggleService f45647a = new ToggleServiceImpl();

    /* renamed from: c */
    private OnLocationChangeListener f45648c;

    /* renamed from: d */
    private OnCityChangeListener f45649d;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Boolean f45650j = true;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile Boolean f45651k = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public List<Activity> f45652m = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Boolean f45653n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public VersionService f45654o;

    /* renamed from: p */
    private Timer f45655p = new Timer();

    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference<S> serviceReference = bundleContext.getServiceReference(Application.class);
        ServiceReference<S> serviceReference2 = bundleContext.getServiceReference(TransmissionService.class);
        ServiceReference<S> serviceReference3 = bundleContext.getServiceReference(LocationService.class);
        ServiceReference<S> serviceReference4 = bundleContext.getServiceReference(UserService.class);
        ServiceReference<S> serviceReference5 = bundleContext.getServiceReference(ConfigurationService.class);
        ServiceReference<S> serviceReference6 = bundleContext.getServiceReference(AuthenticationService.class);
        ServiceReference<S> serviceReference7 = bundleContext.getServiceReference(LanguageService.class);
        ServiceReference<S> serviceReference8 = bundleContext.getServiceReference(VersionService.class);
        Application application = (Application) bundleContext.getService(serviceReference);
        final TransmissionService transmissionService = (TransmissionService) bundleContext.getService(serviceReference2);
        final LocationService locationService = (LocationService) bundleContext.getService(serviceReference3);
        final UserService userService = (UserService) bundleContext.getService(serviceReference4);
        ConfigurationService configurationService = (ConfigurationService) bundleContext.getService(serviceReference5);
        final AuthenticationService authenticationService = (AuthenticationService) bundleContext.getService(serviceReference6);
        final LanguageService languageService = (LanguageService) bundleContext.getService(serviceReference7);
        if (serviceReference8 != null) {
            this.f45654o = (VersionService) bundleContext.getService(serviceReference8);
        }
        bundleContext.registerService(ToggleService.class, this.f45647a, (Dictionary<String, ?>) null);
        Apollo.init(application);
        ConfigureData a = m32695a(configurationService);
        if (a != null) {
            Apollo.setNamespace(a.getNameSpace());
            if (a.getBaseUrl() != null && !a.getBaseUrl().isEmpty()) {
                String baseUrl = a.getBaseUrl();
                if (DomainUtil.isSupportDomainSwitch(application)) {
                    ELog.log("omega sdk init serverhost, dynamic domain support!");
                    baseUrl = DomainUtil.rebuildHost(baseUrl, DomainServiceManager.getInstance().getDomainSuffix(application));
                }
                Apollo.setServerHost(baseUrl);
            }
        }
        Apollo.setUserInfoDelegate(new IUserInfoDelegate() {
            public String getPhone() {
                String string = userService.getAuthData().getString("phonecountrycode");
                String string2 = userService.getAuthData().getString("phone");
                if (string2 == null || string2.equals("") || string2.contains("+") || string == null || string.equals(ApolloActivator.f45645i)) {
                    return string2;
                }
                return string + userService.getAuthData().getString("phone");
            }

            public String getUid() {
                return userService.getAuthData().getString("uid");
            }

            public String getToken() {
                return userService.getAuthData().getString("token");
            }

            public String getLatString() {
                return ApolloActivator.f45642f;
            }

            public String getLngString() {
                return ApolloActivator.f45641e;
            }

            public String getOrderCityId() {
                return ApolloActivator.f45644h;
            }

            public String getLocationCityId() {
                return ApolloActivator.f45643g;
            }

            public String getLang() {
                return languageService.getLanguage();
            }
        });
        Apollo.setLogDelegate(new ILogDelegate() {
            public void saveLog(ApolloLog apolloLog) {
                transmissionService.transmit(apolloLog);
            }

            public void saveErrorLog(ApolloErrorLog apolloErrorLog) {
                transmissionService.transmit(apolloErrorLog);
            }
        });
        Apollo.setAppInfoDelegate(new IAppInfoDelegate() {
            public String getFullVersion() {
                if (ApolloActivator.this.f45654o == null) {
                    return "";
                }
                return ApolloActivator.this.f45654o.getFullVersion();
            }
        });
        C150594 r1 = new OnCityChangeListener() {
            public void onCityChanged(CityChangeEvent cityChangeEvent) {
                String newCityId = cityChangeEvent.getNewCityId();
                if (!newCityId.equals("-1")) {
                    String unused = ApolloActivator.f45644h = newCityId;
                }
                Apollo.checkUpdate();
            }
        };
        this.f45649d = r1;
        locationService.addCityChangeListener(r1);
        C150605 r12 = new OnLocationChangeListener() {
            public void onLocationChanged(LocationChangeEvent locationChangeEvent) {
                String str;
                Location location = locationService.getLocation();
                boolean z = true;
                Boolean unused = ApolloActivator.this.f45651k = true;
                if (location != null) {
                    try {
                        Bundle extras = location.getExtras();
                        if (extras == null) {
                            str = "-1";
                        } else {
                            str = extras.getString("city_id");
                        }
                        String unused2 = ApolloActivator.f45641e = String.valueOf(location.getLongitude());
                        String unused3 = ApolloActivator.f45642f = String.valueOf(location.getLatitude());
                        if (str != null && !str.equals("-1")) {
                            String unused4 = ApolloActivator.f45643g = str;
                        }
                        if (ApolloActivator.this.f45650j.booleanValue()) {
                            if (str != null && !str.equals("-1")) {
                                String unused5 = ApolloActivator.f45644h = str;
                            }
                            Apollo.checkUpdate();
                            ApolloActivator apolloActivator = ApolloActivator.this;
                            if (ApolloActivator.this.f45650j.booleanValue()) {
                                z = false;
                            }
                            Boolean unused6 = apolloActivator.f45650j = Boolean.valueOf(z);
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        SystemUtils.log(6, GlobalCashierCoreModule.APOLLO, th2.getMessage(), th2, "com.didichuxing.apollo.sdk.swarm.ApolloActivator$5", 247);
                    }
                }
            }
        };
        this.f45648c = r12;
        locationService.addLocationChangeListener(r12);
        authenticationService.addAuthenticationChangeListener(new OnAuthenticationStateChangeListener() {
            public void onAuthenticationStateChanged(AuthenticationChangeEvent authenticationChangeEvent) {
                if (authenticationService.isAuthenticated()) {
                    Apollo.checkUpdate();
                    Apollo.resetCoolDownLogger();
                }
            }
        });
        languageService.addOnLanguageChangedListener(new LanguageService.OnLanguageChangedListener() {
            public void onLanguageChanged(String str, String str2) {
                Apollo.checkUpdate();
            }
        });
        m32700a(application);
        Apollo.enableLooper(a.getIsLoop(), (long) a.getInterval().intValue());
        Apollo.startup();
        m32713e();
    }

    /* renamed from: e */
    private void m32713e() {
        this.f45655p.schedule(new TimerTask() {
            public void run() {
                if (!ApolloActivator.this.f45651k.booleanValue()) {
                    Apollo.checkUpdate();
                }
            }
        }, 1000);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        Apollo.shutdown();
        bundleContext.ungetService(bundleContext.getServiceReference(ToggleService.class));
    }

    /* renamed from: a */
    private void m32700a(Application application) {
        if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public void onActivityDestroyed(Activity activity) {
                }

                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                    if (ApolloActivator.this.f45652m.isEmpty()) {
                        if (!ApolloActivator.this.f45653n.booleanValue()) {
                            Apollo.checkUpdate();
                        } else {
                            ApolloActivator apolloActivator = ApolloActivator.this;
                            Boolean unused = apolloActivator.f45653n = Boolean.valueOf(!apolloActivator.f45653n.booleanValue());
                        }
                    }
                    ApolloActivator.this.f45652m.add(activity);
                }

                public void onActivityStopped(Activity activity) {
                    ApolloActivator.this.f45652m.remove(activity);
                }
            });
        }
    }

    /* renamed from: a */
    private ConfigureData m32695a(ConfigurationService configurationService) {
        Gson gson = new Gson();
        InputStream inputStream = null;
        try {
            inputStream = configurationService.getConfiguration(f45640b);
            ConfigureData configureData = (ConfigureData) gson.fromJson((Reader) new InputStreamReader(inputStream), ConfigureData.class);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return configureData;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
