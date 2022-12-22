package org.osgi.util.tracker;

import org.osgi.framework.ServiceReference;

public interface ServiceTrackerCustomizer<S, T> {
    T addingService(ServiceReference<S> serviceReference);

    void modifiedService(ServiceReference<S> serviceReference, T t);

    void removedService(ServiceReference<S> serviceReference, T t);
}
