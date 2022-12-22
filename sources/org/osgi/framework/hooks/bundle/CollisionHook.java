package org.osgi.framework.hooks.bundle;

import java.util.Collection;
import org.osgi.framework.Bundle;

public interface CollisionHook {
    public static final int INSTALLING = 1;
    public static final int UPDATING = 2;

    void filterCollisions(int i, Bundle bundle, Collection<Bundle> collection);
}
