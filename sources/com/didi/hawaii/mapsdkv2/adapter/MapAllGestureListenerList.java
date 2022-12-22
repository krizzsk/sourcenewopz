package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.PointF;
import com.didi.map.outer.model.MapAllGestureListener;
import com.didi.map.outer.model.MapGestureListener;
import java.util.ArrayList;
import java.util.Iterator;

public class MapAllGestureListenerList implements MapAllGestureListener {

    /* renamed from: a */
    private ArrayList<MapAllGestureListener> f23706a = null;

    /* renamed from: b */
    private ArrayList<MapGestureListener> f23707b = null;

    public void addAllMapListener(MapAllGestureListener mapAllGestureListener) {
        if (this.f23706a == null) {
            this.f23706a = new ArrayList<>();
        }
        this.f23706a.add(mapAllGestureListener);
    }

    public void removeAllMapListener(MapAllGestureListener mapAllGestureListener) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            arrayList.remove(mapAllGestureListener);
        }
    }

    public void addSimpleMapListener(MapGestureListener mapGestureListener) {
        if (this.f23707b == null) {
            this.f23707b = new ArrayList<>();
        }
        this.f23707b.add(mapGestureListener);
    }

    public void removeSimpleMapListener(MapGestureListener mapGestureListener) {
        ArrayList<MapGestureListener> arrayList = this.f23707b;
        if (arrayList != null) {
            arrayList.remove(mapGestureListener);
        }
    }

    public boolean onDoubleTap(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onDoubleTap(f, f2);
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 == null) {
            return false;
        }
        Iterator<MapGestureListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().onDoubleTap(f, f2);
        }
        return false;
    }

    public boolean onSingleTap(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onSingleTap(f, f2);
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 == null) {
            return false;
        }
        Iterator<MapGestureListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().onSingleTap(f, f2);
        }
        return false;
    }

    public boolean onFling(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onFling(f, f2);
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 == null) {
            return false;
        }
        Iterator<MapGestureListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().onFling(f, f2);
        }
        return false;
    }

    public boolean onScroll(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onScroll(f, f2);
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 == null) {
            return false;
        }
        Iterator<MapGestureListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().onScroll(f, f2);
        }
        return false;
    }

    public boolean onLongPress(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onLongPress(f, f2);
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 == null) {
            return false;
        }
        Iterator<MapGestureListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().onLongPress(f, f2);
        }
        return false;
    }

    public boolean onDown(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onDown(f, f2);
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 == null) {
            return false;
        }
        Iterator<MapGestureListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().onDown(f, f2);
        }
        return false;
    }

    public boolean onUp(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onUp(f, f2);
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 == null) {
            return false;
        }
        Iterator<MapGestureListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            it2.next().onUp(f, f2);
        }
        return false;
    }

    public boolean onMove(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onMove(f, f2);
        }
        return false;
    }

    public boolean onDoubleTapDown(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onDoubleTapDown(f, f2);
        }
        return false;
    }

    public boolean onDoubleTapMove(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onDoubleTapMove(f, f2);
        }
        return false;
    }

    public boolean onDoubleTapUp(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onDoubleTapUp(f, f2);
        }
        return false;
    }

    public boolean onTwoFingerSingleTap(float f, float f2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTwoFingerSingleTap(f, f2);
        }
        return false;
    }

    public boolean onTwoFingerDown() {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTwoFingerDown();
        }
        return false;
    }

    public boolean onTwoFingerMoveVertical(float f) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTwoFingerMoveVertical(f);
        }
        return false;
    }

    public boolean onTwoFingerMoveHorizontal(float f) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTwoFingerMoveHorizontal(f);
        }
        return false;
    }

    public boolean onTwoFingerUp() {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTwoFingerUp();
        }
        return false;
    }

    public boolean onTwoFingerRotate(PointF pointF, PointF pointF2, float f) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTwoFingerRotate(pointF, pointF2, f);
        }
        return false;
    }

    public boolean onTwoFingerMoveAgainst(PointF pointF, PointF pointF2, double d, double d2) {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList == null) {
            return false;
        }
        Iterator<MapAllGestureListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTwoFingerMoveAgainst(pointF, pointF2, d, d2);
        }
        return false;
    }

    public void onMapStable() {
        ArrayList<MapAllGestureListener> arrayList = this.f23706a;
        if (arrayList != null) {
            Iterator<MapAllGestureListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onMapStable();
            }
        }
        ArrayList<MapGestureListener> arrayList2 = this.f23707b;
        if (arrayList2 != null) {
            Iterator<MapGestureListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onMapStable();
            }
        }
    }
}
