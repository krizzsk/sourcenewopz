package org.osgi.resource;

import java.util.List;

public interface Resource {
    boolean equals(Object obj);

    List<Capability> getCapabilities(String str);

    List<Requirement> getRequirements(String str);

    int hashCode();
}
