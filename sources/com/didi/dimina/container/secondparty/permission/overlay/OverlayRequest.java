package com.didi.dimina.container.secondparty.permission.overlay;

import com.didi.dimina.container.secondparty.permission.Action;
import com.didi.dimina.container.secondparty.permission.Rationale;

public interface OverlayRequest {
    OverlayRequest onDenied(Action<Void> action);

    OverlayRequest onGranted(Action<Void> action);

    OverlayRequest rationale(Rationale<Void> rationale);

    void start();
}
