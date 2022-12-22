package org.osgi.framework;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Dictionary;

public interface BundleContext extends BundleReference {
    void addBundleListener(BundleListener bundleListener);

    void addFrameworkListener(FrameworkListener frameworkListener);

    void addServiceListener(ServiceListener serviceListener);

    void addServiceListener(ServiceListener serviceListener, String str) throws InvalidSyntaxException;

    Filter createFilter(String str) throws InvalidSyntaxException;

    ServiceReference<?>[] getAllServiceReferences(String str, String str2) throws InvalidSyntaxException;

    Bundle getBundle();

    Bundle getBundle(long j);

    Bundle getBundle(String str);

    Bundle[] getBundles();

    File getDataFile(String str);

    String getProperty(String str);

    <S> S getService(ServiceReference<S> serviceReference);

    <S> ServiceObjects<S> getServiceObjects(ServiceReference<S> serviceReference);

    <S> ServiceReference<S> getServiceReference(Class<S> cls);

    ServiceReference<?> getServiceReference(String str);

    <S> Collection<ServiceReference<S>> getServiceReferences(Class<S> cls, String str) throws InvalidSyntaxException;

    ServiceReference<?>[] getServiceReferences(String str, String str2) throws InvalidSyntaxException;

    Bundle installBundle(String str) throws BundleException;

    Bundle installBundle(String str, InputStream inputStream) throws BundleException;

    <S> ServiceRegistration<S> registerService(Class<S> cls, S s, Dictionary<String, ?> dictionary);

    <S> ServiceRegistration<S> registerService(Class<S> cls, ServiceFactory<S> serviceFactory, Dictionary<String, ?> dictionary);

    ServiceRegistration<?> registerService(String str, Object obj, Dictionary<String, ?> dictionary);

    ServiceRegistration<?> registerService(String[] strArr, Object obj, Dictionary<String, ?> dictionary);

    void removeBundleListener(BundleListener bundleListener);

    void removeFrameworkListener(FrameworkListener frameworkListener);

    void removeServiceListener(ServiceListener serviceListener);

    boolean ungetService(ServiceReference<?> serviceReference);
}
