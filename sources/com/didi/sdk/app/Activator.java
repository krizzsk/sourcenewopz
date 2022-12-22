package com.didi.sdk.app;

import com.didi.sdk.sidebar.setup.mutilocale.LocaleSwarmServiceImpl;
import com.didi.sdk.swarm.NationServiceImpl;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.swarm.launcher.toolkit.NationService;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.BusinessContextService;
import com.didichuxing.swarm.toolkit.DeviceService;
import com.didichuxing.swarm.toolkit.DistributionService;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.LogService;
import com.didichuxing.swarm.toolkit.OmegaService;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import com.didichuxing.swarm.toolkit.SecurityService;
import com.didichuxing.swarm.toolkit.TransmissionService;
import com.didichuxing.swarm.toolkit.UserService;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;

@ServiceProvider({AbsActivator.class})
public class Activator extends AbsActivator {
    public static String[] ASSET_BUNDLES = {"bundles/theonelog/manifest.json", "bundles/com.didichuxing.apollo.sdk.swarm/manifest.json", "bundles/com.xiaoju.nova.passenger.sidebar/manifest.json", "bundles/alpha/manifest.json", "bundles/devicemanager/manifest.json", "bundles/feedback/manifest.json", "bundles/omega-swarm/manifest.json", "bundles/zhongce-h5test/manifest.json", "bundles/autotest/manifest.json"};

    /* renamed from: a */
    private final BusinessContextService f35084a = new C12010b();

    /* renamed from: b */
    private final C12011c f35085b = new C12011c();

    /* renamed from: c */
    private final C12013e f35086c = new C12013e();

    /* renamed from: d */
    private final OmegaService f35087d = new C12016h();

    /* renamed from: e */
    private final UserService f35088e = new C12019k();

    /* renamed from: f */
    private final TransmissionService f35089f = new C12018j();

    /* renamed from: g */
    private final SecurityServiceImpl f35090g = new SecurityServiceImpl();

    /* renamed from: h */
    private final ScreenshotService f35091h = new ScreenshotServiceImpl(DIDIBaseApplication.getAppContext());

    /* renamed from: i */
    private final DistributionService f35092i = new C12012d();

    /* renamed from: j */
    private final LogService f35093j = new C12014f();

    /* renamed from: k */
    private final AuthenticationService f35094k = new C12009a(DIDIBaseApplication.getAppContext());

    /* renamed from: l */
    private final LanguageService f35095l = new LocaleSwarmServiceImpl();

    /* renamed from: m */
    private final NationService f35096m = new NationServiceImpl();

    public String[] getAssetBundles() {
        return ASSET_BUNDLES;
    }

    public void start(BundleContext bundleContext) {
        bundleContext.registerService(BusinessContextService.class, this.f35084a, (Dictionary<String, ?>) null);
        bundleContext.registerService(DeviceService.class, this.f35085b, (Dictionary<String, ?>) null);
        bundleContext.registerService(LocationService.class, this.f35086c, (Dictionary<String, ?>) null);
        bundleContext.registerService(OmegaService.class, this.f35087d, (Dictionary<String, ?>) null);
        bundleContext.registerService(UserService.class, this.f35088e, (Dictionary<String, ?>) null);
        bundleContext.registerService(TransmissionService.class, this.f35089f, (Dictionary<String, ?>) null);
        bundleContext.registerService(SecurityService.class, this.f35090g, (Dictionary<String, ?>) null);
        bundleContext.registerService(ScreenshotService.class, this.f35091h, (Dictionary<String, ?>) null);
        bundleContext.registerService(DistributionService.class, this.f35092i, (Dictionary<String, ?>) null);
        bundleContext.registerService(LogService.class, this.f35093j, (Dictionary<String, ?>) null);
        bundleContext.registerService(AuthenticationService.class, this.f35094k, (Dictionary<String, ?>) null);
        bundleContext.registerService(LanguageService.class, this.f35095l, (Dictionary<String, ?>) null);
        bundleContext.registerService(NationService.class, this.f35096m, (Dictionary<String, ?>) null);
    }

    public void stop(BundleContext bundleContext) {
        bundleContext.ungetService(bundleContext.getServiceReference(BusinessContextService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(DeviceService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LocationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(OmegaService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(UserService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(TransmissionService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(SecurityService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(ScreenshotService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(DistributionService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LogService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(AuthenticationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LanguageService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(NationService.class));
    }
}
