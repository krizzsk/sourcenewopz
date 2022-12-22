package com.yanzhenjie.permission.runtime.option;

import com.yanzhenjie.permission.runtime.PermissionRequest;
import com.yanzhenjie.permission.runtime.setting.SettingRequest;

public interface RuntimeOption {
    PermissionRequest permission(String... strArr);

    PermissionRequest permission(String[]... strArr);

    SettingRequest setting();
}
