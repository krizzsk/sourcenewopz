package org.osgi.framework.startlevel;

import org.osgi.framework.BundleReference;

public interface BundleStartLevel extends BundleReference {
    int getStartLevel();

    boolean isActivationPolicyUsed();

    boolean isPersistentlyStarted();

    void setStartLevel(int i);
}
