package org.osgi.resource;

import java.util.List;

public interface Wiring {
    List<Wire> getProvidedResourceWires(String str);

    List<Wire> getRequiredResourceWires(String str);

    Resource getResource();

    List<Capability> getResourceCapabilities(String str);

    List<Requirement> getResourceRequirements(String str);
}
