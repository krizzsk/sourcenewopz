package com.didi.dimina.container.secondparty.permission.bridge;

import com.didi.dimina.container.secondparty.permission.bridge.Messenger;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.didi.dimina.container.secondparty.permission.bridge.a */
/* compiled from: RequestExecutor */
final class C7587a extends Thread implements Messenger.Callback {

    /* renamed from: a */
    private final BlockingQueue<BridgeRequest> f17346a;

    /* renamed from: b */
    private BridgeRequest f17347b;

    /* renamed from: c */
    private Messenger f17348c;

    public C7587a(BlockingQueue<BridgeRequest> blockingQueue) {
        this.f17346a = blockingQueue;
    }

    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.f17347b = this.f17346a.take();
                    try {
                        Messenger messenger = new Messenger(this.f17347b.getSource().getContext(), this);
                        this.f17348c = messenger;
                        messenger.mo55886a();
                        m12886a();
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
    private void m12886a() {
        switch (this.f17347b.getType()) {
            case 1:
                BridgeActivity.m12875a(this.f17347b.getSource());
                return;
            case 2:
                BridgeActivity.m12876a(this.f17347b.getSource(), this.f17347b.getPermissions());
                return;
            case 3:
                BridgeActivity.m12877b(this.f17347b.getSource());
                return;
            case 4:
                BridgeActivity.m12878c(this.f17347b.getSource());
                return;
            case 5:
                BridgeActivity.m12879d(this.f17347b.getSource());
                return;
            case 6:
                BridgeActivity.m12880e(this.f17347b.getSource());
                return;
            case 7:
                BridgeActivity.m12881f(this.f17347b.getSource());
                return;
            case 8:
                BridgeActivity.m12882g(this.f17347b.getSource());
                return;
            default:
                return;
        }
    }

    public void onCallback() {
        synchronized (this) {
            this.f17348c.mo55887b();
            this.f17347b.getCallback().onCallback();
            notify();
        }
    }
}
