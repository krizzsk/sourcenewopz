package com.didi.commoninterfacelib.permission;

import java.io.Serializable;

public interface PermissionCallback extends Serializable {
    void isAllGranted(boolean z, String[] strArr);
}
