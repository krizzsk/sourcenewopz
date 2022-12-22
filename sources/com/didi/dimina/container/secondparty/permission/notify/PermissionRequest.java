package com.didi.dimina.container.secondparty.permission.notify;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;

public interface PermissionRequest {
    PermissionRequest onDenied(Action<Void> action);

    PermissionRequest onGranted(Action<Void> action);

    PermissionRequest rationale(Rationale<Void> rationale);

    void start();
}
