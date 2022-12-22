package com.yanzhenjie.permission.setting.write;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.Rationale;

public interface WriteRequest {
    WriteRequest onDenied(Action<Void> action);

    WriteRequest onGranted(Action<Void> action);

    WriteRequest rationale(Rationale<Void> rationale);

    void start();
}
