package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class ShapeData {

    /* renamed from: a */
    private final List<CubicCurveData> f1459a;

    /* renamed from: b */
    private PointF f1460b;

    /* renamed from: c */
    private boolean f1461c;

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.f1460b = pointF;
        this.f1461c = z;
        this.f1459a = new ArrayList(list);
    }

    public ShapeData() {
        this.f1459a = new ArrayList();
    }

    /* renamed from: a */
    private void m1311a(float f, float f2) {
        if (this.f1460b == null) {
            this.f1460b = new PointF();
        }
        this.f1460b.set(f, f2);
    }

    public PointF getInitialPoint() {
        return this.f1460b;
    }

    public boolean isClosed() {
        return this.f1461c;
    }

    public List<CubicCurveData> getCurves() {
        return this.f1459a;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, float f) {
        if (this.f1460b == null) {
            this.f1460b = new PointF();
        }
        this.f1461c = shapeData.isClosed() || shapeData2.isClosed();
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            Logger.warning("Curves must have the same number of control points. Shape 1: " + shapeData.getCurves().size() + "\tShape 2: " + shapeData2.getCurves().size());
        }
        int min = Math.min(shapeData.getCurves().size(), shapeData2.getCurves().size());
        if (this.f1459a.size() < min) {
            for (int size = this.f1459a.size(); size < min; size++) {
                this.f1459a.add(new CubicCurveData());
            }
        } else if (this.f1459a.size() > min) {
            for (int size2 = this.f1459a.size() - 1; size2 >= min; size2--) {
                List<CubicCurveData> list = this.f1459a;
                list.remove(list.size() - 1);
            }
        }
        PointF initialPoint = shapeData.getInitialPoint();
        PointF initialPoint2 = shapeData2.getInitialPoint();
        m1311a(MiscUtils.lerp(initialPoint.x, initialPoint2.x, f), MiscUtils.lerp(initialPoint.y, initialPoint2.y, f));
        for (int size3 = this.f1459a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.getCurves().get(size3);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF controlPoint12 = cubicCurveData2.getControlPoint1();
            PointF controlPoint22 = cubicCurveData2.getControlPoint2();
            PointF vertex2 = cubicCurveData2.getVertex();
            this.f1459a.get(size3).setControlPoint1(MiscUtils.lerp(controlPoint1.x, controlPoint12.x, f), MiscUtils.lerp(controlPoint1.y, controlPoint12.y, f));
            this.f1459a.get(size3).setControlPoint2(MiscUtils.lerp(controlPoint2.x, controlPoint22.x, f), MiscUtils.lerp(controlPoint2.y, controlPoint22.y, f));
            this.f1459a.get(size3).setVertex(MiscUtils.lerp(vertex.x, vertex2.x, f), MiscUtils.lerp(vertex.y, vertex2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f1459a.size() + "closed=" + this.f1461c + '}';
    }
}
