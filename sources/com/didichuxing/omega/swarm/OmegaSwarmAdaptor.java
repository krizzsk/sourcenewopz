package com.didichuxing.omega.swarm;

import android.app.Application;
import com.didichuxing.omega.sdk.init.OmegaConfigurator;
import com.didichuxing.swarm.toolkit.TimeService;
import com.didichuxing.toggle.OmegaToggleService;
import org.osgi.framework.BundleContext;

public class OmegaSwarmAdaptor {
    public static void adaptConfig(BundleContext bundleContext) {
        Application application = (Application) bundleContext.getService(bundleContext.getServiceReference(Application.class));
        if (application != null) {
            OmegaConfigurator.setToggleService(application, new OmegaToggleService());
        }
        try {
            OmegaConfigurator.setTimeOffset(((TimeService) bundleContext.getService(bundleContext.getServiceReference(TimeService.class))).getTimeDifference());
        } catch (Throwable unused) {
        }
    }
}
