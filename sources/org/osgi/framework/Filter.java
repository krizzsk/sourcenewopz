package org.osgi.framework;

import java.util.Dictionary;
import java.util.Map;

public interface Filter {
    boolean equals(Object obj);

    int hashCode();

    boolean match(Dictionary<String, ?> dictionary);

    boolean match(ServiceReference<?> serviceReference);

    boolean matchCase(Dictionary<String, ?> dictionary);

    boolean matches(Map<String, ?> map);

    String toString();
}
