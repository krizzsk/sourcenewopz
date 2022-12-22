package com.didi.dimina.container.p106ui.wheelview.timer;

import com.didi.dimina.container.p106ui.wheelview.view.WheelView;
import java.util.TimerTask;

/* renamed from: com.didi.dimina.container.ui.wheelview.timer.InertiaTimerTask */
public final class InertiaTimerTask extends TimerTask {

    /* renamed from: a */
    private float f17873a = 2.14748365E9f;

    /* renamed from: b */
    private final float f17874b;

    /* renamed from: c */
    private final WheelView f17875c;

    public InertiaTimerTask(WheelView wheelView, float f) {
        this.f17875c = wheelView;
        this.f17874b = f;
    }

    public final void run() {
        if (this.f17873a == 2.14748365E9f) {
            float f = 2000.0f;
            if (Math.abs(this.f17874b) > 2000.0f) {
                if (this.f17874b <= 0.0f) {
                    f = -2000.0f;
                }
                this.f17873a = f;
            } else {
                this.f17873a = this.f17874b;
            }
        }
        if (Math.abs(this.f17873a) < 0.0f || Math.abs(this.f17873a) > 20.0f) {
            WheelView wheelView = this.f17875c;
            float f2 = (float) ((int) (this.f17873a / 100.0f));
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f17875c.isLoop()) {
                float itemHeight = this.f17875c.getItemHeight();
                float f3 = ((float) (-this.f17875c.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.f17875c.getItemsCount() - 1) - this.f17875c.getInitPosition())) * itemHeight;
                double d = ((double) itemHeight) * 0.25d;
                if (((double) this.f17875c.getTotalScrollY()) - d < ((double) f3)) {
                    f3 = this.f17875c.getTotalScrollY() + f2;
                } else if (((double) this.f17875c.getTotalScrollY()) + d > ((double) itemsCount)) {
                    itemsCount = this.f17875c.getTotalScrollY() + f2;
                }
                if (this.f17875c.getTotalScrollY() <= f3) {
                    this.f17873a = 40.0f;
                    this.f17875c.setTotalScrollY((float) ((int) f3));
                } else if (this.f17875c.getTotalScrollY() >= itemsCount) {
                    this.f17875c.setTotalScrollY((float) ((int) itemsCount));
                    this.f17873a = -40.0f;
                }
            }
            float f4 = this.f17873a;
            if (f4 < 0.0f) {
                this.f17873a = f4 + 20.0f;
            } else {
                this.f17873a = f4 - 20.0f;
            }
            this.f17875c.getHandler().sendEmptyMessage(1000);
            return;
        }
        this.f17875c.cancelFuture();
        this.f17875c.getHandler().sendEmptyMessage(2000);
    }
}
