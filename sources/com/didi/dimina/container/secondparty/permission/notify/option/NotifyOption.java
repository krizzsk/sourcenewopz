package com.didi.dimina.container.secondparty.permission.notify.option;

import com.didi.dimina.container.secondparty.permission.notify.PermissionRequest;
import com.didi.dimina.container.secondparty.permission.notify.listener.ListenerRequest;

public interface NotifyOption {
    ListenerRequest listener();

    PermissionRequest permission();
}
