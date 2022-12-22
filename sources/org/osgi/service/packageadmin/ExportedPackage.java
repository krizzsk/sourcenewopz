package org.osgi.service.packageadmin;

import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

public interface ExportedPackage {
    Bundle getExportingBundle();

    Bundle[] getImportingBundles();

    String getName();

    String getSpecificationVersion();

    Version getVersion();

    boolean isRemovalPending();
}
