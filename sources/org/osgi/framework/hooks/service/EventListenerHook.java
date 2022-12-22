package org.osgi.framework.hooks.service;

import java.util.Collection;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.hooks.service.ListenerHook;

public interface EventListenerHook {
    void event(ServiceEvent serviceEvent, Map<BundleContext, Collection<ListenerHook.ListenerInfo>> map);
}
