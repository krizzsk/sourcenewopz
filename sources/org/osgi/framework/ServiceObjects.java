package org.osgi.framework;

public interface ServiceObjects<S> {
    S getService();

    ServiceReference<S> getServiceReference();

    void ungetService(S s);
}
