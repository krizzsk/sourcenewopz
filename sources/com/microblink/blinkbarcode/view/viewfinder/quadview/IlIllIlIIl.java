package com.microblink.blinkbarcode.view.viewfinder.quadview;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.microblink.blinkbarcode.geometry.QuadrangleEvaluator;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
class IlIllIlIIl implements Runnable {
    public final /* synthetic */ IllIIIllII llIIlIlIIl;

    public IlIllIlIIl(IllIIIllII illIIIllII) {
        this.llIIlIlIIl = illIIIllII;
    }

    public void run() {
        Log.m40227d(this.llIIlIlIIl, "Starting quad animation", new Object[0]);
        if (this.llIIlIlIIl.llIIlIIIll != null) {
            this.llIIlIlIIl.llIIlIIIll.cancel();
        }
        ValueAnimator unused = this.llIIlIlIIl.llIIlIIIll = ValueAnimator.ofObject(new QuadrangleEvaluator(), new Object[]{this.llIIlIlIIl.lllIIIlIlI, this.llIIlIlIIl.IlIllIlllI});
        this.llIIlIlIIl.llIIlIIIll.setDuration(this.llIIlIlIIl.lIIIIIllll);
        this.llIIlIlIIl.llIIlIIIll.setInterpolator(new AccelerateDecelerateInterpolator());
        this.llIIlIlIIl.llIIlIIIll.addUpdateListener(this.llIIlIlIIl);
        this.llIIlIlIIl.llIIlIIIll.addListener(this.llIIlIlIIl.IlIIlIIIII);
        this.llIIlIlIIl.llIIlIIIll.start();
    }
}
