package org.osgi.framework.wiring;

import java.util.Collection;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleReference;
import org.osgi.framework.FrameworkListener;
import org.osgi.resource.Requirement;

public interface FrameworkWiring extends BundleReference {
    Collection<BundleCapability> findProviders(Requirement requirement);

    Collection<Bundle> getDependencyClosure(Collection<Bundle> collection);

    Collection<Bundle> getRemovalPendingBundles();

    void refreshBundles(Collection<Bundle> collection, FrameworkListener... frameworkListenerArr);

    boolean resolveBundles(Collection<Bundle> collection);
}
