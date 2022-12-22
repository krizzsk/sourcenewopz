package org.osgi.framework;

public interface PrototypeServiceFactory<S> extends ServiceFactory<S> {
    S getService(Bundle bundle, ServiceRegistration<S> serviceRegistration);

    void ungetService(Bundle bundle, ServiceRegistration<S> serviceRegistration, S s);
}
