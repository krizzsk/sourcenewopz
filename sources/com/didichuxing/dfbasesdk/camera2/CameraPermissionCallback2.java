package com.didichuxing.dfbasesdk.camera2;

public interface CameraPermissionCallback2 {
    void onActivityRestore();

    void onMessage(String str);

    void onPermissionChanged(boolean z);
}
