package org.osgi.framework;

import java.util.Dictionary;

public interface ServiceRegistration<S> {
    ServiceReference<S> getReference();

    void setProperties(Dictionary<String, ?> dictionary);

    void unregister();
}
