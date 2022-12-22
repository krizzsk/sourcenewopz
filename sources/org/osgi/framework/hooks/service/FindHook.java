package org.osgi.framework.hooks.service;

import java.util.Collection;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public interface FindHook {
    void find(BundleContext bundleContext, String str, String str2, boolean z, Collection<ServiceReference<?>> collection);
}
