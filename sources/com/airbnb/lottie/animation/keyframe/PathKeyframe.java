package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe extends Keyframe<PointF> {

    /* renamed from: a */
    private Path f1328a;

    /* renamed from: b */
    private final Keyframe<PointF> f1329b;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        this.f1329b = keyframe;
        createPath();
    }

    public void createPath() {
        boolean z = (this.endValue == null || this.startValue == null || !((PointF) this.startValue).equals(((PointF) this.endValue).x, ((PointF) this.endValue).y)) ? false : true;
        if (this.endValue != null && !z) {
            this.f1328a = Utils.createPath((PointF) this.startValue, (PointF) this.endValue, this.f1329b.pathCp1, this.f1329b.pathCp2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Path mo15255a() {
        return this.f1328a;
    }
}
