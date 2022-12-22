package org.osgi.service.condpermadmin;

import java.util.List;

public interface ConditionalPermissionUpdate {
    boolean commit();

    List<ConditionalPermissionInfo> getConditionalPermissionInfos();
}
