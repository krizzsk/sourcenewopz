package org.osgi.framework;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public interface Bundle extends Comparable<Bundle> {
    public static final int ACTIVE = 32;
    public static final int INSTALLED = 2;
    public static final int RESOLVED = 4;
    public static final int SIGNERS_ALL = 1;
    public static final int SIGNERS_TRUSTED = 2;
    public static final int STARTING = 8;
    public static final int START_ACTIVATION_POLICY = 2;
    public static final int START_TRANSIENT = 1;
    public static final int STOPPING = 16;
    public static final int STOP_TRANSIENT = 1;
    public static final int UNINSTALLED = 1;

    <A> A adapt(Class<A> cls);

    Enumeration<URL> findEntries(String str, String str2, boolean z);

    BundleContext getBundleContext();

    long getBundleId();

    File getDataFile(String str);

    URL getEntry(String str);

    Enumeration<String> getEntryPaths(String str);

    Dictionary<String, String> getHeaders();

    Dictionary<String, String> getHeaders(String str);

    long getLastModified();

    String getLocation();

    ServiceReference<?>[] getRegisteredServices();

    URL getResource(String str);

    Enumeration<URL> getResources(String str) throws IOException;

    ServiceReference<?>[] getServicesInUse();

    Map<X509Certificate, List<X509Certificate>> getSignerCertificates(int i);

    int getState();

    String getSymbolicName();

    Version getVersion();

    boolean hasPermission(Object obj);

    Class<?> loadClass(String str) throws ClassNotFoundException;

    void start() throws BundleException;

    void start(int i) throws BundleException;

    void stop() throws BundleException;

    void stop(int i) throws BundleException;

    void uninstall() throws BundleException;

    void update() throws BundleException;

    void update(InputStream inputStream) throws BundleException;
}
