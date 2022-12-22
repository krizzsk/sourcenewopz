package org.osgi.util.tracker;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;

public interface BundleTrackerCustomizer<T> {
    T addingBundle(Bundle bundle, BundleEvent bundleEvent);

    void modifiedBundle(Bundle bundle, BundleEvent bundleEvent, T t);

    void removedBundle(Bundle bundle, BundleEvent bundleEvent, T t);
}
