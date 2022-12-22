package org.osgi.service.packageadmin;

import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

public interface RequiredBundle {
    Bundle getBundle();

    Bundle[] getRequiringBundles();

    String getSymbolicName();

    Version getVersion();

    boolean isRemovalPending();
}
