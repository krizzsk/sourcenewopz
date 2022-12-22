package com.contrarywind.timer;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

public final class SmoothScrollTimerTask extends TimerTask {

    /* renamed from: a */
    private int f3321a = Integer.MAX_VALUE;

    /* renamed from: b */
    private int f3322b = 0;

    /* renamed from: c */
    private int f3323c;

    /* renamed from: d */
    private final WheelView f3324d;

    public SmoothScrollTimerTask(WheelView wheelView, int i) {
        this.f3324d = wheelView;
        this.f3323c = i;
    }

    public final void run() {
        if (this.f3321a == Integer.MAX_VALUE) {
            this.f3321a = this.f3323c;
        }
        int i = this.f3321a;
        int i2 = (int) (((float) i) * 0.1f);
        this.f3322b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f3322b = -1;
            } else {
                this.f3322b = 1;
            }
        }
        if (Math.abs(this.f3321a) <= 1) {
            this.f3324d.cancelFuture();
            this.f3324d.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f3324d;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + ((float) this.f3322b));
        if (!this.f3324d.isLoop()) {
            float itemHeight = this.f3324d.getItemHeight();
            float f = ((float) (-this.f3324d.getInitPosition())) * itemHeight;
            float itemsCount = ((float) ((this.f3324d.getItemsCount() - 1) - this.f3324d.getInitPosition())) * itemHeight;
            if (this.f3324d.getTotalScrollY() <= f || this.f3324d.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f3324d;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - ((float) this.f3322b));
                this.f3324d.cancelFuture();
                this.f3324d.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f3324d.getHandler().sendEmptyMessage(1000);
        this.f3321a -= this.f3322b;
    }
}
