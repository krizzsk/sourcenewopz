package org.osgi.framework;

public interface ServiceReference<S> extends Comparable<Object> {
    int compareTo(Object obj);

    Bundle getBundle();

    Object getProperty(String str);

    String[] getPropertyKeys();

    Bundle[] getUsingBundles();

    boolean isAssignableTo(Bundle bundle, String str);
}
