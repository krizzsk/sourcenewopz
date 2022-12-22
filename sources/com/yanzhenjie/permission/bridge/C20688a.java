package com.yanzhenjie.permission.bridge;

import com.yanzhenjie.permission.bridge.Messenger;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.yanzhenjie.permission.bridge.a */
/* compiled from: RequestExecutor */
final class C20688a extends Thread implements Messenger.Callback {

    /* renamed from: a */
    private final BlockingQueue<BridgeRequest> f56169a;

    /* renamed from: b */
    private BridgeRequest f56170b;

    /* renamed from: c */
    private Messenger f56171c;

    public C20688a(BlockingQueue<BridgeRequest> blockingQueue) {
        this.f56169a = blockingQueue;
    }

    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.f56170b = this.f56169a.take();
                    try {
                        Messenger messenger = new Messenger(this.f56170b.getSource().getContext(), this);
                        this.f56171c = messenger;
                        messenger.mo169056a();
                        m40427a();
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m40427a() {
        switch (this.f56170b.getType()) {
            case 1:
                BridgeActivity.m40416a(this.f56170b.getSource());
                return;
            case 2:
                BridgeActivity.m40417a(this.f56170b.getSource(), this.f56170b.getPermissions());
                return;
            case 3:
                BridgeActivity.m40418b(this.f56170b.getSource());
                return;
            case 4:
                BridgeActivity.m40419c(this.f56170b.getSource());
                return;
            case 5:
                BridgeActivity.m40420d(this.f56170b.getSource());
                return;
            case 6:
                BridgeActivity.m40421e(this.f56170b.getSource());
                return;
            case 7:
                BridgeActivity.m40422f(this.f56170b.getSource());
                return;
            case 8:
                BridgeActivity.m40423g(this.f56170b.getSource());
                return;
            default:
                return;
        }
    }

    public void onCallback() {
        synchronized (this) {
            this.f56171c.mo169057b();
            this.f56170b.getCallback().onCallback();
            notify();
        }
    }
}
