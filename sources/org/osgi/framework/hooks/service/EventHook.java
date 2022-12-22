package org.osgi.framework.hooks.service;

import java.util.Collection;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;

public interface EventHook {
    void event(ServiceEvent serviceEvent, Collection<BundleContext> collection);
}
