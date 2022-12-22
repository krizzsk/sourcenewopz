package rui.internal.loopview;

/* renamed from: rui.internal.loopview.d */
/* compiled from: OnItemSelectedRunnable */
final class C3020d implements Runnable {

    /* renamed from: a */
    final LoopView f6814a;

    C3020d(LoopView loopView) {
        this.f6814a = loopView;
    }

    public final void run() {
        this.f6814a.f6796o.onItemSelected(this.f6814a.getSelectedItemPosition());
    }
}
