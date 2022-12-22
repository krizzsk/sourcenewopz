package org.osgi.framework.wiring;

import org.osgi.resource.Wire;

public interface BundleWire extends Wire {
    BundleCapability getCapability();

    BundleRevision getProvider();

    BundleWiring getProviderWiring();

    BundleRequirement getRequirement();

    BundleRevision getRequirer();

    BundleWiring getRequirerWiring();
}
