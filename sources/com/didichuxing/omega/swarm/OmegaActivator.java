package com.didichuxing.omega.swarm;

import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.swarm.runtime.SwarmPlugin;
import org.osgi.framework.BundleContext;

public class OmegaActivator extends SwarmPlugin {
    public void stop(BundleContext bundleContext) throws Exception {
    }

    public void start(BundleContext bundleContext) throws Exception {
        OmegaSDK.addBlackPage("c.d.s.a.MainActivity");
        OmegaSDK.addBlackPage("c.d.c.f.BtsFwHomeFragment");
        OmegaSwarmAdaptor.adaptConfig(bundleContext);
    }
}
