package com.didi.dimina.container.secondparty.permission.runtime;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;
import java.util.List;

public interface PermissionRequest {
    PermissionRequest onDenied(Action<List<String>> action);

    PermissionRequest onGranted(Action<List<String>> action);

    PermissionRequest permission(String... strArr);

    PermissionRequest rationale(Rationale<List<String>> rationale);

    void start();
}
