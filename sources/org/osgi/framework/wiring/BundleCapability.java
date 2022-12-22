package org.osgi.framework.wiring;

import java.util.Map;
import org.osgi.resource.Capability;

public interface BundleCapability extends Capability {
    Map<String, Object> getAttributes();

    Map<String, String> getDirectives();

    String getNamespace();

    BundleRevision getResource();

    BundleRevision getRevision();
}
