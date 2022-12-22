package org.osgi.service.condpermadmin;

import java.security.AccessControlContext;
import java.util.Enumeration;
import org.osgi.service.permissionadmin.PermissionInfo;

public interface ConditionalPermissionAdmin {
    ConditionalPermissionInfo addConditionalPermissionInfo(ConditionInfo[] conditionInfoArr, PermissionInfo[] permissionInfoArr);

    AccessControlContext getAccessControlContext(String[] strArr);

    ConditionalPermissionInfo getConditionalPermissionInfo(String str);

    Enumeration<ConditionalPermissionInfo> getConditionalPermissionInfos();

    ConditionalPermissionInfo newConditionalPermissionInfo(String str);

    ConditionalPermissionInfo newConditionalPermissionInfo(String str, ConditionInfo[] conditionInfoArr, PermissionInfo[] permissionInfoArr, String str2);

    ConditionalPermissionUpdate newConditionalPermissionUpdate();

    ConditionalPermissionInfo setConditionalPermissionInfo(String str, ConditionInfo[] conditionInfoArr, PermissionInfo[] permissionInfoArr);
}
