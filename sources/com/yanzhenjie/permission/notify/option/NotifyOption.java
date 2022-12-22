package com.yanzhenjie.permission.notify.option;

import com.yanzhenjie.permission.notify.PermissionRequest;
import com.yanzhenjie.permission.notify.listener.ListenerRequest;

public interface NotifyOption {
    ListenerRequest listener();

    PermissionRequest permission();
}
