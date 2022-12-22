package com.didi.nova.assembly.components.bigimage.photoview;

import android.view.ScaleGestureDetector;

class CustomGestureDetector$1 implements ScaleGestureDetector.OnScaleGestureListener {
    final /* synthetic */ C10261b this$0;

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    CustomGestureDetector$1(C10261b bVar) {
        this.this$0 = bVar;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.this$0.f29149k.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }
}
