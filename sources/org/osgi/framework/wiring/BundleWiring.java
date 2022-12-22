package org.osgi.framework.wiring;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import org.osgi.framework.BundleReference;
import org.osgi.resource.Capability;
import org.osgi.resource.Requirement;
import org.osgi.resource.Wire;
import org.osgi.resource.Wiring;

public interface BundleWiring extends BundleReference, Wiring {
    public static final int FINDENTRIES_RECURSE = 1;
    public static final int LISTRESOURCES_LOCAL = 2;
    public static final int LISTRESOURCES_RECURSE = 1;

    List<URL> findEntries(String str, String str2, int i);

    List<BundleCapability> getCapabilities(String str);

    ClassLoader getClassLoader();

    List<Wire> getProvidedResourceWires(String str);

    List<BundleWire> getProvidedWires(String str);

    List<Wire> getRequiredResourceWires(String str);

    List<BundleWire> getRequiredWires(String str);

    List<BundleRequirement> getRequirements(String str);

    BundleRevision getResource();

    List<Capability> getResourceCapabilities(String str);

    List<Requirement> getResourceRequirements(String str);

    BundleRevision getRevision();

    boolean isCurrent();

    boolean isInUse();

    Collection<String> listResources(String str, String str2, int i);
}
