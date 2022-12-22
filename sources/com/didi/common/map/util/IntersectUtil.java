package com.didi.common.map.util;

import android.graphics.PointF;
import android.graphics.Rect;
import java.util.List;

public class IntersectUtil {
    public static boolean isRectIntersectWithRect(Rect rect, Rect rect2) {
        return Math.abs(((rect.left + rect.right) / 2) - ((rect2.left + rect2.right) / 2)) < (((rect.right - rect.left) + rect2.right) - rect2.left) / 2 && Math.abs(((rect.top + rect.bottom) / 2) - ((rect2.top + rect2.bottom) / 2)) < (((rect.bottom - rect.top) + rect2.bottom) - rect2.top) / 2;
    }

    public static boolean isLineIntersectWithRect(Rect rect, List<PointF> list) {
        int i = 0;
        while (i < list.size() - 1) {
            i++;
            if (m7386a(rect, list.get(i), list.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m7386a(Rect rect, PointF pointF, PointF pointF2) {
        if (rect.contains((int) pointF.x, (int) pointF.y) || rect.contains((int) pointF2.x, (int) pointF2.y)) {
            return true;
        }
        PointF pointF3 = new PointF((float) rect.left, (float) rect.top);
        PointF pointF4 = new PointF((float) rect.left, (float) rect.bottom);
        if (m7385a(pointF, pointF2, pointF3, pointF4)) {
            return true;
        }
        PointF pointF5 = new PointF((float) rect.right, (float) rect.top);
        if (m7385a(pointF, pointF2, pointF3, pointF5)) {
            return true;
        }
        PointF pointF6 = new PointF((float) rect.right, (float) rect.bottom);
        if (!m7385a(pointF, pointF2, pointF5, pointF6) && !m7385a(pointF, pointF2, pointF4, pointF6)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m7385a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        if (Math.min(pointF.x, pointF2.x) > Math.max(pointF3.x, pointF4.x) || Math.min(pointF3.y, pointF4.y) > Math.max(pointF.y, pointF2.y) || Math.min(pointF3.x, pointF4.x) > Math.max(pointF.x, pointF2.x) || Math.min(pointF.y, pointF2.y) > Math.max(pointF3.y, pointF4.y)) {
            return false;
        }
        double d = (double) (((pointF.x - pointF3.x) * (pointF4.y - pointF3.y)) - ((pointF4.x - pointF3.x) * (pointF.y - pointF3.y)));
        double d2 = (double) (((pointF2.x - pointF3.x) * (pointF4.y - pointF3.y)) - ((pointF4.x - pointF3.x) * (pointF2.y - pointF3.y)));
        if (((double) (((pointF3.x - pointF.x) * (pointF2.y - pointF.y)) - ((pointF2.x - pointF.x) * (pointF3.y - pointF.y)))) * ((double) (((pointF4.x - pointF.x) * (pointF2.y - pointF.y)) - ((pointF2.x - pointF.x) * (pointF4.y - pointF.y)))) > 0.0d || d * d2 > 0.0d) {
            return false;
        }
        return true;
    }
}
