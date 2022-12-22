package rui.internal.loopview;

/* renamed from: rui.internal.loopview.a */
/* compiled from: InertiaTimerTask */
final class C3017a implements Runnable {

    /* renamed from: a */
    float f6806a = 2.14748365E9f;

    /* renamed from: b */
    final float f6807b;

    /* renamed from: c */
    final LoopView f6808c;

    C3017a(LoopView loopView, float f) {
        this.f6808c = loopView;
        this.f6807b = f;
    }

    public final void run() {
        if (this.f6806a == 2.14748365E9f) {
            if (Math.abs(this.f6807b) <= 2000.0f) {
                this.f6806a = this.f6807b;
            } else if (this.f6807b > 0.0f) {
                this.f6806a = 2000.0f;
            } else {
                this.f6806a = -2000.0f;
            }
        }
        if (Math.abs(this.f6806a) < 0.0f || Math.abs(this.f6806a) > 20.0f) {
            this.f6808c.f6789h -= (int) ((this.f6806a * 10.0f) / 1000.0f);
            if (!this.f6808c.f6782a) {
                float f = (float) this.f6808c.f6792k;
                if (this.f6808c.f6789h <= ((int) (((float) (-this.f6808c.f6790i)) * f))) {
                    this.f6806a = 40.0f;
                    LoopView loopView = this.f6808c;
                    loopView.f6789h = (int) (((float) (-loopView.f6790i)) * f);
                } else if (this.f6808c.f6789h >= ((int) (((float) ((this.f6808c.f6797p.size() - 1) - this.f6808c.f6790i)) * f))) {
                    LoopView loopView2 = this.f6808c;
                    loopView2.f6789h = (int) (((float) ((loopView2.f6797p.size() - 1) - this.f6808c.f6790i)) * f);
                    this.f6806a = -40.0f;
                }
            }
            float f2 = this.f6806a;
            if (f2 < 0.0f) {
                this.f6806a = f2 + 20.0f;
            } else {
                this.f6806a = f2 - 20.0f;
            }
            this.f6808c.f6795n.sendEmptyMessage(1000);
            return;
        }
        this.f6808c.cancelFuture();
        this.f6808c.f6795n.sendEmptyMessage(2000);
    }
}
