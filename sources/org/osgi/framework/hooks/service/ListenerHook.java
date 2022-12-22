package org.osgi.framework.hooks.service;

import java.util.Collection;
import org.osgi.framework.BundleContext;

public interface ListenerHook {

    public interface ListenerInfo {
        boolean equals(Object obj);

        BundleContext getBundleContext();

        String getFilter();

        int hashCode();

        boolean isRemoved();
    }

    void added(Collection<ListenerInfo> collection);

    void removed(Collection<ListenerInfo> collection);
}
