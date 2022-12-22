package org.osgi.framework.wiring;

import java.util.List;
import org.osgi.framework.BundleReference;
import org.osgi.framework.Version;
import org.osgi.resource.Capability;
import org.osgi.resource.Requirement;
import org.osgi.resource.Resource;

public interface BundleRevision extends BundleReference, Resource {
    public static final String BUNDLE_NAMESPACE = "osgi.wiring.bundle";
    public static final String HOST_NAMESPACE = "osgi.wiring.host";
    public static final String PACKAGE_NAMESPACE = "osgi.wiring.package";
    public static final int TYPE_FRAGMENT = 1;

    List<Capability> getCapabilities(String str);

    List<BundleCapability> getDeclaredCapabilities(String str);

    List<BundleRequirement> getDeclaredRequirements(String str);

    List<Requirement> getRequirements(String str);

    String getSymbolicName();

    int getTypes();

    Version getVersion();

    BundleWiring getWiring();
}
