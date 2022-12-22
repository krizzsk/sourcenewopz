package org.osgi.framework.startlevel;

import org.osgi.framework.BundleReference;
import org.osgi.framework.FrameworkListener;

public interface FrameworkStartLevel extends BundleReference {
    int getInitialBundleStartLevel();

    int getStartLevel();

    void setInitialBundleStartLevel(int i);

    void setStartLevel(int i, FrameworkListener... frameworkListenerArr);
}
