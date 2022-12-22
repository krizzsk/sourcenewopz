package org.osgi.framework.wiring;

import java.util.Map;
import org.osgi.resource.Requirement;

public interface BundleRequirement extends Requirement {
    Map<String, Object> getAttributes();

    Map<String, String> getDirectives();

    String getNamespace();

    BundleRevision getResource();

    BundleRevision getRevision();

    boolean matches(BundleCapability bundleCapability);
}
