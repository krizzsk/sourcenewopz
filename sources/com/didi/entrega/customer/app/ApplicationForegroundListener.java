package com.didi.entrega.customer.app;

public interface ApplicationForegroundListener {
    void onBecomeBackground(long j, long j2);

    void onBecomeForeground(long j, long j2);
}
