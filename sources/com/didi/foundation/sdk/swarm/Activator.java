package com.didi.foundation.sdk.swarm;

import android.app.Application;
import com.didichuxing.swarm.runtime.SwarmPlugin;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.BusinessContextService;
import com.didichuxing.swarm.toolkit.DeviceService;
import com.didichuxing.swarm.toolkit.DistributionService;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.LogService;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import com.didichuxing.swarm.toolkit.SecurityService;
import com.didichuxing.swarm.toolkit.TraceLogService;
import com.didichuxing.swarm.toolkit.TransmissionService;
import com.didichuxing.swarm.toolkit.UserService;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;
import org.osgi.framework.BundleContext;

public final class Activator extends SwarmPlugin {
    public static final List<String> ASSET_BUNDLES = Collections.unmodifiableList(Arrays.asList(new String[]{"bundles/theonelog/manifest.json", "bundles/com.didichuxing.apollo.sdk.swarm/manifest.json", "bundles/feedback/manifest.json", "bundles/omega-swarm/manifest.json"}));

    /* renamed from: a */
    private final BusinessContextService f21327a = new C8393a();

    /* renamed from: b */
    private final DeviceService f21328b = new C8394b();

    /* renamed from: c */
    private final LocationService f21329c = new C8396d();

    /* renamed from: d */
    private final UserService f21330d = new C8401i();

    /* renamed from: e */
    private final TransmissionService f21331e = new C8400h();

    /* renamed from: f */
    private final SecurityService f21332f = new C8398f();

    /* renamed from: g */
    private final LogService f21333g = new C8397e();

    /* renamed from: h */
    private final ScreenshotService f21334h;

    /* renamed from: i */
    private final DistributionService f21335i;

    /* renamed from: j */
    private final TraceLogService f21336j;

    /* renamed from: k */
    private final AuthenticationService f21337k;

    /* renamed from: l */
    private final LanguageService f21338l;

    public Activator(Application application) {
        this.f21334h = new ScreenShotServiceImp(application);
        this.f21335i = new C8395c();
        this.f21337k = new AuthenticationServiceImpl(application);
        this.f21336j = new C8399g();
        this.f21338l = new LanguageServiceImpl();
    }

    public void start(BundleContext bundleContext) {
        bundleContext.registerService(BusinessContextService.class, this.f21327a, (Dictionary<String, ?>) null);
        bundleContext.registerService(DeviceService.class, this.f21328b, (Dictionary<String, ?>) null);
        bundleContext.registerService(LocationService.class, this.f21329c, (Dictionary<String, ?>) null);
        bundleContext.registerService(UserService.class, this.f21330d, (Dictionary<String, ?>) null);
        bundleContext.registerService(TransmissionService.class, this.f21331e, (Dictionary<String, ?>) null);
        bundleContext.registerService(SecurityService.class, this.f21332f, (Dictionary<String, ?>) null);
        bundleContext.registerService(LogService.class, this.f21333g, (Dictionary<String, ?>) null);
        bundleContext.registerService(ScreenshotService.class, this.f21334h, (Dictionary<String, ?>) null);
        bundleContext.registerService(UserService.class, this.f21330d, (Dictionary<String, ?>) null);
        bundleContext.registerService(TraceLogService.class, this.f21336j, (Dictionary<String, ?>) null);
        bundleContext.registerService(AuthenticationService.class, this.f21337k, (Dictionary<String, ?>) null);
        bundleContext.registerService(DistributionService.class, this.f21335i, (Dictionary<String, ?>) null);
        bundleContext.registerService(LanguageService.class, this.f21338l, (Dictionary<String, ?>) null);
    }

    public void stop(BundleContext bundleContext) {
        bundleContext.ungetService(bundleContext.getServiceReference(BusinessContextService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(DeviceService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LocationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(UserService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(TransmissionService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(SecurityService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LogService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(ScreenshotService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(UserService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(TraceLogService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(AuthenticationService.class));
        bundleContext.ungetService(bundleContext.getServiceReference(LanguageService.class));
    }
}
