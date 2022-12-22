package org.osgi.service.permissionadmin;

public interface PermissionAdmin {
    PermissionInfo[] getDefaultPermissions();

    String[] getLocations();

    PermissionInfo[] getPermissions(String str);

    void setDefaultPermissions(PermissionInfo[] permissionInfoArr);

    void setPermissions(String str, PermissionInfo[] permissionInfoArr);
}
