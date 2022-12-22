package org.osgi.framework.launch;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;

public interface Framework extends Bundle {
    <A> A adapt(Class<A> cls);

    Enumeration<URL> findEntries(String str, String str2, boolean z);

    long getBundleId();

    URL getEntry(String str);

    Enumeration<String> getEntryPaths(String str);

    long getLastModified();

    String getLocation();

    String getSymbolicName();

    void init() throws BundleException;

    void init(FrameworkListener... frameworkListenerArr) throws BundleException;

    void start() throws BundleException;

    void start(int i) throws BundleException;

    void stop() throws BundleException;

    void stop(int i) throws BundleException;

    void uninstall() throws BundleException;

    void update() throws BundleException;

    void update(InputStream inputStream) throws BundleException;

    FrameworkEvent waitForStop(long j) throws InterruptedException;
}
