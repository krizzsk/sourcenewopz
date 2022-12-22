package org.osgi.framework.hooks.resolver;

import java.util.Collection;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleRevision;

public interface ResolverHook {
    void end();

    void filterMatches(BundleRequirement bundleRequirement, Collection<BundleCapability> collection);

    void filterResolvable(Collection<BundleRevision> collection);

    void filterSingletonCollisions(BundleCapability bundleCapability, Collection<BundleCapability> collection);
}
