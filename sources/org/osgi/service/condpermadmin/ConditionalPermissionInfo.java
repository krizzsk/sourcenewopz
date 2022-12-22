package org.osgi.service.condpermadmin;

import org.osgi.service.permissionadmin.PermissionInfo;

public interface ConditionalPermissionInfo {
    public static final String ALLOW = "allow";
    public static final String DENY = "deny";

    void delete();

    boolean equals(Object obj);

    String getAccessDecision();

    ConditionInfo[] getConditionInfos();

    String getEncoded();

    String getName();

    PermissionInfo[] getPermissionInfos();

    int hashCode();

    String toString();
}
