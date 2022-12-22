package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class PathKeyframeAnimation extends C1482a<PointF> {

    /* renamed from: b */
    private final PointF f1330b = new PointF();

    /* renamed from: c */
    private final float[] f1331c = new float[2];

    /* renamed from: d */
    private PathKeyframe f1332d;

    /* renamed from: e */
    private PathMeasure f1333e = new PathMeasure();

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path a = pathKeyframe.mo15255a();
        if (a == null) {
            return (PointF) keyframe.startValue;
        }
        if (this.valueCallback != null) {
            PointF pointF = (PointF) this.valueCallback.getValueInternal(pathKeyframe.startFrame, pathKeyframe.endFrame.floatValue(), pathKeyframe.startValue, pathKeyframe.endValue, mo15224a(), f, getProgress());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f1332d != pathKeyframe) {
            this.f1333e.setPath(a, false);
            this.f1332d = pathKeyframe;
        }
        PathMeasure pathMeasure = this.f1333e;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.f1331c, (float[]) null);
        PointF pointF2 = this.f1330b;
        float[] fArr = this.f1331c;
        pointF2.set(fArr[0], fArr[1]);
        return this.f1330b;
    }
}
