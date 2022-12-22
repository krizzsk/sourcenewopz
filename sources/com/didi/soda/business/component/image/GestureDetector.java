package com.didi.soda.business.component.image;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import com.didi.app.nova.support.util.DisplayUtils;

public class GestureDetector {

    /* renamed from: a */
    private static final int f39611a = 800;

    /* renamed from: b */
    private static final int f39612b = 100;

    /* renamed from: c */
    private Vector f39613c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f39614d = false;

    /* renamed from: e */
    private boolean f39615e = false;

    /* renamed from: f */
    private Handler f39616f = new Handler();

    /* renamed from: g */
    private Context f39617g;

    /* renamed from: h */
    private OnGestureListener f39618h;

    /* renamed from: i */
    private Runnable f39619i = new Runnable() {
        public void run() {
            boolean unused = GestureDetector.this.f39614d = true;
        }
    };

    public interface OnGestureListener {
        void onClick();

        void onGlide();
    }

    public GestureDetector(Context context, OnGestureListener onGestureListener) {
        this.f39617g = context;
        this.f39618h = onGestureListener;
    }

    public void onMotionEvent(MotionEvent motionEvent, Rect rect) {
        Vector vector;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f39614d = false;
            this.f39615e = false;
            this.f39613c = Vector.creator((int) motionEvent.getX(), (int) motionEvent.getY());
            this.f39616f.postDelayed(this.f39619i, 800);
        } else if (action == 1) {
            this.f39616f.removeCallbacks(this.f39619i);
            Vector creator = Vector.creator((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!this.f39614d && (vector = this.f39613c) != null) {
                Vector subtract = Vector.subtract(creator, vector);
                if (subtract.module() > ((double) DisplayUtils.dip2px(this.f39617g, 100.0f))) {
                    m28182a(subtract);
                }
                if (!this.f39615e && subtract.module() == 0.0d) {
                    m28183a(creator, rect);
                }
            }
        } else if (action != 2) {
            if (action == 3) {
                this.f39616f.removeCallbacks(this.f39619i);
            }
        } else if ((!this.f39615e && motionEvent.getX() != ((float) this.f39613c.f39620x)) || motionEvent.getY() != ((float) this.f39613c.f39621y)) {
            this.f39615e = true;
        }
    }

    /* renamed from: a */
    private void m28182a(Vector vector) {
        OnGestureListener onGestureListener;
        if (vector.f39620x <= vector.f39621y && vector.f39620x >= (-vector.f39621y) && (onGestureListener = this.f39618h) != null) {
            onGestureListener.onGlide();
        }
    }

    /* renamed from: a */
    private void m28183a(Vector vector, Rect rect) {
        OnGestureListener onGestureListener;
        if (rect != null && !m28185b(vector, rect) && (onGestureListener = this.f39618h) != null) {
            onGestureListener.onClick();
        }
    }

    /* renamed from: b */
    private boolean m28185b(Vector vector, Rect rect) {
        return vector.f39620x >= rect.left && vector.f39620x <= rect.right && vector.f39621y >= rect.top && vector.f39621y <= rect.bottom;
    }

    private static class Vector {

        /* renamed from: x */
        int f39620x;

        /* renamed from: y */
        int f39621y;

        private Vector() {
        }

        static Vector creator(int i, int i2) {
            Vector vector = new Vector();
            vector.f39620x = i;
            vector.f39621y = i2;
            return vector;
        }

        static Vector subtract(Vector vector, Vector vector2) {
            Vector vector3 = new Vector();
            vector3.f39620x = vector.f39620x - vector2.f39620x;
            vector3.f39621y = vector.f39621y - vector2.f39621y;
            return vector3;
        }

        /* access modifiers changed from: package-private */
        public double module() {
            int i = this.f39620x;
            int i2 = this.f39621y;
            return Math.sqrt((double) ((i * i) + (i2 * i2)));
        }
    }
}
