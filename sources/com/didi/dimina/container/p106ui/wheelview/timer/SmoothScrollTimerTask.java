package com.didi.dimina.container.p106ui.wheelview.timer;

import com.didi.dimina.container.p106ui.wheelview.view.WheelView;
import java.util.TimerTask;

/* renamed from: com.didi.dimina.container.ui.wheelview.timer.SmoothScrollTimerTask */
public final class SmoothScrollTimerTask extends TimerTask {

    /* renamed from: a */
    private int f17877a = Integer.MAX_VALUE;

    /* renamed from: b */
    private int f17878b = 0;

    /* renamed from: c */
    private final int f17879c;

    /* renamed from: d */
    private final WheelView f17880d;

    public SmoothScrollTimerTask(WheelView wheelView, int i) {
        this.f17880d = wheelView;
        this.f17879c = i;
    }

    public final void run() {
        if (this.f17877a == Integer.MAX_VALUE) {
            this.f17877a = this.f17879c;
        }
        int i = this.f17877a;
        int i2 = (int) (((float) i) * 0.1f);
        this.f17878b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f17878b = -1;
            } else {
                this.f17878b = 1;
            }
        }
        if (Math.abs(this.f17877a) <= 1) {
            this.f17880d.cancelFuture();
            this.f17880d.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f17880d;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + ((float) this.f17878b));
        if (!this.f17880d.isLoop()) {
            float itemHeight = this.f17880d.getItemHeight();
            float f = ((float) (-this.f17880d.getInitPosition())) * itemHeight;
            float itemsCount = ((float) ((this.f17880d.getItemsCount() - 1) - this.f17880d.getInitPosition())) * itemHeight;
            if (this.f17880d.getTotalScrollY() <= f || this.f17880d.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f17880d;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - ((float) this.f17878b));
                this.f17880d.cancelFuture();
                this.f17880d.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f17880d.getHandler().sendEmptyMessage(1000);
        this.f17877a -= this.f17878b;
    }
}
