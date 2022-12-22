package com.didi.dimina.container.secondparty.permission.runtime.option;

import com.didi.dimina.container.secondparty.permission.runtime.PermissionRequest;
import com.didi.dimina.container.secondparty.permission.runtime.setting.SettingRequest;

public interface RuntimeOption {
    PermissionRequest permission(String... strArr);

    PermissionRequest permission(String[]... strArr);

    SettingRequest setting();
}
