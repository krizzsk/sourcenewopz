package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.taxis99.R;

public class StandardGestureDetector extends BaseGesture<StandardOnGestureListener> {

    /* renamed from: a */
    final StandardOnGestureListener f23631a = new StandardOnGestureListener() {
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return StandardGestureDetector.this.canExecute(5) && ((StandardOnGestureListener) StandardGestureDetector.this.listener).onSingleTapUp(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (StandardGestureDetector.this.canExecute(6)) {
                ((StandardOnGestureListener) StandardGestureDetector.this.listener).onLongPress(motionEvent);
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!StandardGestureDetector.this.canExecute(0) || !((StandardOnGestureListener) StandardGestureDetector.this.listener).onScroll(motionEvent, motionEvent2, f, f2)) {
                return false;
            }
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float dimension = StandardGestureDetector.this.context.getResources().getDimension(R.dimen.min_fling_distance);
            float x = motionEvent.getX();
            float x2 = motionEvent2.getX() - x;
            float y = motionEvent2.getY() - motionEvent.getY();
            return StandardGestureDetector.this.canExecute(7) && Math.sqrt((double) ((x2 * x2) + (y * y))) >= ((double) dimension) && ((StandardOnGestureListener) StandardGestureDetector.this.listener).onFling(motionEvent, motionEvent2, f, f2);
        }

        public void onShowPress(MotionEvent motionEvent) {
            if (StandardGestureDetector.this.canExecute(8)) {
                ((StandardOnGestureListener) StandardGestureDetector.this.listener).onShowPress(motionEvent);
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            return StandardGestureDetector.this.canExecute(9) && ((StandardOnGestureListener) StandardGestureDetector.this.listener).onDown(motionEvent);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return StandardGestureDetector.this.canExecute(10) && ((StandardOnGestureListener) StandardGestureDetector.this.listener).onDoubleTap(motionEvent);
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return StandardGestureDetector.this.canExecute(11) && ((StandardOnGestureListener) StandardGestureDetector.this.listener).onDoubleTapEvent(motionEvent);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return StandardGestureDetector.this.canExecute(12) && ((StandardOnGestureListener) StandardGestureDetector.this.listener).onSingleTapConfirmed(motionEvent);
        }
    };

    /* renamed from: b */
    private final GestureDetector f23632b;

    public static class SimpleStandardOnGestureListener implements StandardOnGestureListener {
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public interface StandardOnGestureListener extends GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    }

    public StandardGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        this.f23632b = new GestureDetector(context, this.f23631a);
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        return this.f23632b.onTouchEvent(motionEvent);
    }

    public boolean isLongpressEnabled() {
        return this.f23632b.isLongpressEnabled();
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f23632b.setIsLongpressEnabled(z);
    }
}
