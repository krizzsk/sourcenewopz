package rui.internal.loopview;

/* renamed from: rui.internal.loopview.e */
/* compiled from: SmoothScrollTimerTask */
final class C3021e implements Runnable {

    /* renamed from: a */
    int f6815a = Integer.MAX_VALUE;

    /* renamed from: b */
    int f6816b = 0;

    /* renamed from: c */
    int f6817c;

    /* renamed from: d */
    final LoopView f6818d;

    C3021e(LoopView loopView, int i) {
        this.f6818d = loopView;
        this.f6817c = i;
    }

    public final void run() {
        if (this.f6815a == Integer.MAX_VALUE) {
            this.f6815a = this.f6817c;
        }
        int i = this.f6815a;
        int i2 = (int) (((float) i) * 0.1f);
        this.f6816b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f6816b = -1;
            } else {
                this.f6816b = 1;
            }
        }
        if (Math.abs(this.f6815a) <= 0) {
            this.f6818d.cancelFuture();
            this.f6818d.f6795n.sendEmptyMessage(3000);
            return;
        }
        this.f6818d.f6789h += this.f6816b;
        this.f6818d.f6795n.sendEmptyMessage(1000);
        this.f6815a -= this.f6816b;
    }
}
