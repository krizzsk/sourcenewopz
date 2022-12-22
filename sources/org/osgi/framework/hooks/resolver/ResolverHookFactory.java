package org.osgi.framework.hooks.resolver;

import java.util.Collection;
import org.osgi.framework.wiring.BundleRevision;

public interface ResolverHookFactory {
    ResolverHook begin(Collection<BundleRevision> collection);
}
