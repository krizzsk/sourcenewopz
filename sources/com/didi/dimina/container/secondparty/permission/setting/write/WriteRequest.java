package com.didi.dimina.container.secondparty.permission.setting.write;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;

public interface WriteRequest {
    WriteRequest onDenied(Action<Void> action);

    WriteRequest onGranted(Action<Void> action);

    WriteRequest rationale(Rationale<Void> rationale);

    void start();
}
