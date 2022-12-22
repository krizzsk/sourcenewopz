package com.contrarywind.timer;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;

    /* renamed from: a */
    private final WheelView f3320a;

    public MessageHandler(WheelView wheelView) {
        this.f3320a = wheelView;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f3320a.invalidate();
        } else if (i == 2000) {
            this.f3320a.smoothScroll(WheelView.ACTION.FLING);
        } else if (i == 3000) {
            this.f3320a.onItemSelected();
        }
    }
}
