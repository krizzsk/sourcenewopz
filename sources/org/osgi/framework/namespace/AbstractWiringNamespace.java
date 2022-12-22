package org.osgi.framework.namespace;

import org.osgi.resource.Namespace;

public abstract class AbstractWiringNamespace extends Namespace {
    public static final String CAPABILITY_BUNDLE_VERSION_ATTRIBUTE = "bundle-version";
    public static final String CAPABILITY_MANDATORY_DIRECTIVE = "mandatory";

    AbstractWiringNamespace() {
    }
}
