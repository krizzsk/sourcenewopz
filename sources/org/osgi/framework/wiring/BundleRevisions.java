package org.osgi.framework.wiring;

import java.util.List;
import org.osgi.framework.BundleReference;

public interface BundleRevisions extends BundleReference {
    List<BundleRevision> getRevisions();
}
