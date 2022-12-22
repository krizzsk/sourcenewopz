package com.didi.dimina.container.secondparty.permission.notify.listener;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;

public interface ListenerRequest {
    ListenerRequest onDenied(Action<Void> action);

    ListenerRequest onGranted(Action<Void> action);

    ListenerRequest rationale(Rationale<Void> rationale);

    void start();
}
