package com.contrarywind.timer;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

public final class InertiaTimerTask extends TimerTask {

    /* renamed from: a */
    private float f3317a = 2.14748365E9f;

    /* renamed from: b */
    private final float f3318b;

    /* renamed from: c */
    private final WheelView f3319c;

    public InertiaTimerTask(WheelView wheelView, float f) {
        this.f3319c = wheelView;
        this.f3318b = f;
    }

    public final void run() {
        if (this.f3317a == 2.14748365E9f) {
            float f = 2000.0f;
            if (Math.abs(this.f3318b) > 2000.0f) {
                if (this.f3318b <= 0.0f) {
                    f = -2000.0f;
                }
                this.f3317a = f;
            } else {
                this.f3317a = this.f3318b;
            }
        }
        if (Math.abs(this.f3317a) < 0.0f || Math.abs(this.f3317a) > 20.0f) {
            WheelView wheelView = this.f3319c;
            float f2 = (float) ((int) (this.f3317a / 100.0f));
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f3319c.isLoop()) {
                float itemHeight = this.f3319c.getItemHeight();
                float f3 = ((float) (-this.f3319c.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.f3319c.getItemsCount() - 1) - this.f3319c.getInitPosition())) * itemHeight;
                double d = ((double) itemHeight) * 0.25d;
                if (((double) this.f3319c.getTotalScrollY()) - d < ((double) f3)) {
                    f3 = this.f3319c.getTotalScrollY() + f2;
                } else if (((double) this.f3319c.getTotalScrollY()) + d > ((double) itemsCount)) {
                    itemsCount = this.f3319c.getTotalScrollY() + f2;
                }
                if (this.f3319c.getTotalScrollY() <= f3) {
                    this.f3317a = 40.0f;
                    this.f3319c.setTotalScrollY((float) ((int) f3));
                } else if (this.f3319c.getTotalScrollY() >= itemsCount) {
                    this.f3319c.setTotalScrollY((float) ((int) itemsCount));
                    this.f3317a = -40.0f;
                }
            }
            float f4 = this.f3317a;
            if (f4 < 0.0f) {
                this.f3317a = f4 + 20.0f;
            } else {
                this.f3317a = f4 - 20.0f;
            }
            this.f3319c.getHandler().sendEmptyMessage(1000);
            return;
        }
        this.f3319c.cancelFuture();
        this.f3319c.getHandler().sendEmptyMessage(2000);
    }
}
