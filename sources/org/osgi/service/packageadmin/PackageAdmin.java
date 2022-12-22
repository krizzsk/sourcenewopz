package org.osgi.service.packageadmin;

import org.osgi.framework.Bundle;

public interface PackageAdmin {
    public static final int BUNDLE_TYPE_FRAGMENT = 1;

    Bundle getBundle(Class cls);

    int getBundleType(Bundle bundle);

    Bundle[] getBundles(String str, String str2);

    ExportedPackage getExportedPackage(String str);

    ExportedPackage[] getExportedPackages(String str);

    ExportedPackage[] getExportedPackages(Bundle bundle);

    Bundle[] getFragments(Bundle bundle);

    Bundle[] getHosts(Bundle bundle);

    RequiredBundle[] getRequiredBundles(String str);

    void refreshPackages(Bundle[] bundleArr);

    boolean resolveBundles(Bundle[] bundleArr);
}
