package rui.internal.loopview;

import android.os.Handler;
import android.os.Message;
import rui.internal.loopview.LoopView;

/* renamed from: rui.internal.loopview.c */
/* compiled from: MessageHandler */
final class C3019c extends Handler {

    /* renamed from: a */
    public static final int f6810a = 1000;

    /* renamed from: b */
    public static final int f6811b = 2000;

    /* renamed from: c */
    public static final int f6812c = 3000;

    /* renamed from: d */
    private final LoopView f6813d;

    C3019c(LoopView loopView) {
        this.f6813d = loopView;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f6813d.invalidate();
        } else if (i == 2000) {
            this.f6813d.mo38468a(LoopView.ACTION.FLING);
        } else if (i == 3000) {
            this.f6813d.onItemSelected();
        }
    }
}
