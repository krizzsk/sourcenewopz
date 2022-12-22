package com.didi.map.base.bubble;

import android.graphics.PointF;
import com.didi.map.common.utils.PolygonUtils;

public class TrafficHintShowBarn {
    public PointF bottomCenter = new PointF(400.0f, 1400.0f);
    public float bottomCutLine = 1400.0f;
    public float bottomRadius = 400.0f;
    public PointF leftTop = new PointF(0.0f, 800.0f);
    public PointF rightBottom = new PointF(800.0f, 1400.0f);
    public PointF targetCenter = new PointF(400.0f, 1100.0f);
    public PointF topCenter = new PointF(400.0f, 800.0f);
    public float topCutlineY = 800.0f;
    public float topRadius = 400.0f;

    private TrafficHintShowBarn() {
    }

    public static TrafficHintShowBarn makeBarn(double d, PointF pointF, PointF pointF2, double d2) {
        TrafficHintShowBarn trafficHintShowBarn = new TrafficHintShowBarn();
        PointF pointF3 = new PointF(pointF.x + ((pointF2.x - pointF.x) / 2.0f), (float) (((double) pointF.y) - d));
        PointF pointF4 = new PointF(pointF.x + ((pointF2.x - pointF.x) / 2.0f), (float) (((double) pointF2.y) + d2));
        double[] makeCircle = makeCircle(pointF, pointF3, new PointF(pointF2.x, pointF.y));
        double[] makeCircle2 = makeCircle(new PointF(pointF.x, pointF2.y), pointF4, pointF2);
        trafficHintShowBarn.bottomCenter = new PointF((float) makeCircle2[0], (float) makeCircle2[1]);
        trafficHintShowBarn.bottomRadius = (float) makeCircle2[2];
        trafficHintShowBarn.bottomCutLine = pointF2.y;
        trafficHintShowBarn.topCenter = new PointF((float) makeCircle[0], (float) makeCircle[1]);
        trafficHintShowBarn.topRadius = (float) makeCircle[2];
        trafficHintShowBarn.topCutlineY = pointF.y;
        trafficHintShowBarn.leftTop = pointF;
        trafficHintShowBarn.rightBottom = pointF2;
        trafficHintShowBarn.targetCenter = new PointF(pointF3.x, pointF3.y + ((pointF4.y - pointF3.y) / 2.0f));
        return trafficHintShowBarn;
    }

    private static double[] makeCircle(PointF pointF, PointF pointF2, PointF pointF3) {
        return PolygonUtils.generateCircle(pointF, pointF2, pointF3);
    }
}
