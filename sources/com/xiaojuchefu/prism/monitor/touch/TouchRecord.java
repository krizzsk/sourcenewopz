package com.xiaojuchefu.prism.monitor.touch;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import java.util.ArrayList;
import java.util.List;

public class TouchRecord {

    /* renamed from: a */
    private long f56126a;

    /* renamed from: b */
    private float f56127b;

    /* renamed from: c */
    private float f56128c;
    public boolean isClick;
    public long mDownTime;
    public float mDownX;
    public float mDownY;
    public List<MoveTouch> mMoveTouch;
    public int mPointerId;
    public long mUpTime;
    public float mUpX;
    public float mUpY;

    public void onActionDown(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        this.mPointerId = motionEvent.getPointerId(actionIndex);
        long downTime = motionEvent.getDownTime();
        this.f56126a = downTime;
        this.mDownTime = downTime;
        float x = motionEvent.getX(actionIndex);
        this.f56127b = x;
        this.mDownX = x;
        float y = motionEvent.getY(actionIndex);
        this.f56128c = y;
        this.mDownY = y;
    }

    public void onActionMove(MotionEvent motionEvent) {
        if (this.mMoveTouch == null) {
            this.mMoveTouch = new ArrayList();
        }
        MoveTouch moveTouch = new MoveTouch();
        moveTouch.mMoveTime = motionEvent.getEventTime() - this.f56126a;
        this.f56126a = moveTouch.mMoveTime + this.f56126a;
        int actionIndex = motionEvent.getActionIndex();
        moveTouch.mMoveX = motionEvent.getX(actionIndex) - this.f56127b;
        moveTouch.mMoveY = motionEvent.getY(actionIndex) - this.f56128c;
        this.f56127b = moveTouch.mMoveX + this.f56127b;
        this.f56128c = moveTouch.mMoveY + this.f56128c;
        this.mMoveTouch.add(moveTouch);
    }

    public void onActionUp(MotionEvent motionEvent) {
        this.mUpTime = motionEvent.getEventTime();
        int actionIndex = motionEvent.getActionIndex();
        this.mUpX = motionEvent.getX(actionIndex);
        this.mUpY = motionEvent.getY(actionIndex);
        this.isClick = Math.abs(this.mDownX - this.mUpX) < ((float) PrismMonitor.sTouchSlop) && Math.abs(this.mDownY - this.mUpY) < ((float) PrismMonitor.sTouchSlop);
    }

    public boolean isLongPress() {
        return this.isClick && this.mUpTime - this.mDownTime > ((long) ViewConfiguration.getLongPressTimeout());
    }

    public class MoveTouch {
        public long mMoveTime;
        public float mMoveX;
        public float mMoveY;

        public MoveTouch() {
        }
    }
}
