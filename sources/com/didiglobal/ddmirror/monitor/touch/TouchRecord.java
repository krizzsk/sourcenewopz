package com.didiglobal.ddmirror.monitor.touch;

import android.view.MotionEvent;
import com.didiglobal.ddmirror.monitor.PrismMonitor;

public class TouchRecord {
    public boolean isClick;
    public long mDownTime;
    public float mDownX;
    public float mDownY;
    public int mPointerId;
    public long mUpTime;
    public float mUpX;
    public float mUpY;

    public void onActionDown(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        this.mPointerId = motionEvent.getPointerId(actionIndex);
        this.mDownTime = motionEvent.getDownTime();
        this.mDownX = motionEvent.getX(actionIndex);
        this.mDownY = motionEvent.getY(actionIndex);
    }

    public void onActionUp(MotionEvent motionEvent) {
        this.mUpTime = motionEvent.getEventTime();
        int actionIndex = motionEvent.getActionIndex();
        this.mUpX = motionEvent.getX(actionIndex);
        this.mUpY = motionEvent.getY(actionIndex);
        this.isClick = Math.abs(this.mDownX - this.mUpX) < ((float) PrismMonitor.sTouchSlop) && Math.abs(this.mDownY - this.mUpY) < ((float) PrismMonitor.sTouchSlop);
    }

    public class MoveTouch {
        public long mMoveTime;
        public float mMoveX;
        public float mMoveY;

        public MoveTouch() {
        }
    }
}
