package org.osgi.resource;

public interface Wire {
    boolean equals(Object obj);

    Capability getCapability();

    Resource getProvider();

    Requirement getRequirement();

    Resource getRequirer();

    int hashCode();
}
