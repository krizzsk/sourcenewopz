package com.microblink.blinkbarcode.view.viewfinder.points;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.microblink.blinkbarcode.view.viewfinder.points.PointSetView;

/* compiled from: line */
class llIIlIlIIl implements Runnable {
    public final /* synthetic */ PointSetView llIIlIlIIl;

    public llIIlIlIIl(PointSetView pointSetView) {
        this.llIIlIlIIl = pointSetView;
    }

    public void run() {
        if (this.llIIlIlIIl.llIIlIIlll != null) {
            this.llIIlIlIIl.llIIlIIlll.cancel();
        }
        PointSetView pointSetView = this.llIIlIlIIl;
        PointSetView.IlIllIlIIl ilIllIlIIl = new PointSetView.IlIllIlIIl(pointSetView, (llIIlIlIIl) null);
        PointSetView pointSetView2 = this.llIIlIlIIl;
        PointSetView pointSetView3 = this.llIIlIlIIl;
        ValueAnimator unused = pointSetView.llIIlIIlll = ValueAnimator.ofObject(ilIllIlIIl, new Object[]{new PointSetView.llIIlIlIIl(pointSetView2, pointSetView2.lllIIIlIlI, this.llIIlIlIIl.lIIIIIllll), new PointSetView.llIIlIlIIl(pointSetView3, pointSetView3.lIIIIIllll, this.llIIlIlIIl.lllIIIlIlI)});
        this.llIIlIlIIl.llIIlIIlll.setDuration(250);
        this.llIIlIlIIl.llIIlIIlll.setInterpolator(new AccelerateDecelerateInterpolator());
        this.llIIlIlIIl.llIIlIIlll.addUpdateListener(this.llIIlIlIIl);
        this.llIIlIlIIl.llIIlIIlll.start();
    }
}
