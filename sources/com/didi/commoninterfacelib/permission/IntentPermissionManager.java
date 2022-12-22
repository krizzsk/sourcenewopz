package com.didi.commoninterfacelib.permission;

public final class IntentPermissionManager implements PermissionDialogInterface {
    private static IntentPermissionManager manager;
    private PermissionDialogInterface permissionDialogInterface;

    public void setPermissionDialogInterface(PermissionDialogInterface permissionDialogInterface2) {
        this.permissionDialogInterface = permissionDialogInterface2;
    }

    private IntentPermissionManager() {
    }

    public final String getPermissionDescription(String str) {
        PermissionDialogInterface permissionDialogInterface2 = this.permissionDialogInterface;
        return permissionDialogInterface2 != null ? permissionDialogInterface2.getPermissionDescription(str) : "";
    }

    public static IntentPermissionManager getInstance() {
        if (manager == null) {
            manager = new IntentPermissionManager();
        }
        return manager;
    }

    public String getConfirm() {
        PermissionDialogInterface permissionDialogInterface2 = this.permissionDialogInterface;
        return permissionDialogInterface2 != null ? permissionDialogInterface2.getConfirm() : "";
    }

    public String getCancel() {
        PermissionDialogInterface permissionDialogInterface2 = this.permissionDialogInterface;
        return permissionDialogInterface2 != null ? permissionDialogInterface2.getCancel() : "";
    }
}
