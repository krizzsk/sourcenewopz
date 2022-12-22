package com.didi.commoninterfacelib.permission;

import android.content.Context;
import android.content.Intent;

public interface PermissionContext {
    Context getContextByPermissionContext();

    void requestPermissionsByPermissionContext(String[] strArr, int i);

    void startActivityByPermissionContext(Intent intent);

    void startActivityForResultByPermissionContext(Intent intent, int i);
}
