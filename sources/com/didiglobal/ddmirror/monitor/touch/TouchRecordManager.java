package com.didiglobal.ddmirror.monitor.touch;

import android.view.MotionEvent;

public class TouchRecordManager {
    private static TouchRecordManager sTouchRecordManager;
    private TouchRecord mTouchRecord;

    public static TouchRecordManager getInstance() {
        TouchRecordManager touchRecordManager;
        synchronized (TouchRecordManager.class) {
            if (sTouchRecordManager == null) {
                sTouchRecordManager = new TouchRecordManager();
            }
            touchRecordManager = sTouchRecordManager;
        }
        return touchRecordManager;
    }

    public void touchEvent(MotionEvent motionEvent) {
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            TouchRecord touchRecord = new TouchRecord();
            this.mTouchRecord = touchRecord;
            touchRecord.onActionDown(motionEvent);
            return;
        }
        TouchRecord touchRecord2 = this.mTouchRecord;
        if (touchRecord2 != null && touchRecord2.mPointerId == pointerId) {
            if (actionMasked == 1) {
                this.mTouchRecord.onActionUp(motionEvent);
            } else if (actionMasked == 3) {
                this.mTouchRecord = null;
            }
        }
    }

    public TouchRecord getTouchRecord() {
        return this.mTouchRecord;
    }
}
