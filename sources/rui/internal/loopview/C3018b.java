package rui.internal.loopview;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: rui.internal.loopview.b */
/* compiled from: LoopViewGestureListener */
final class C3018b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final LoopView f6809a;

    C3018b(LoopView loopView) {
        this.f6809a = loopView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f6809a.scrollBy(f2);
        return true;
    }
}
