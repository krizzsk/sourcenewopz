package com.xiaojuchefu.prism.monitor.touch;

import android.view.MotionEvent;

public class TouchRecordManager {

    /* renamed from: a */
    private static TouchRecordManager f56129a;

    /* renamed from: b */
    private TouchRecord f56130b;

    public static TouchRecordManager getInstance() {
        TouchRecordManager touchRecordManager;
        synchronized (TouchRecordManager.class) {
            if (f56129a == null) {
                f56129a = new TouchRecordManager();
            }
            touchRecordManager = f56129a;
        }
        return touchRecordManager;
    }

    public void touchEvent(MotionEvent motionEvent) {
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            TouchRecord touchRecord = new TouchRecord();
            this.f56130b = touchRecord;
            touchRecord.onActionDown(motionEvent);
            return;
        }
        TouchRecord touchRecord2 = this.f56130b;
        if (touchRecord2 != null && touchRecord2.mPointerId == pointerId) {
            if (actionMasked == 2) {
                this.f56130b.onActionMove(motionEvent);
            } else if (actionMasked == 1) {
                this.f56130b.onActionUp(motionEvent);
            } else if (actionMasked == 3) {
                this.f56130b = null;
            }
        }
    }

    public TouchRecord getTouchRecord() {
        return this.f56130b;
    }
}
