package com.didiglobal.ddmirror.monitor.event;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.ddmirror.monitor.PrismMonitor;
import com.didiglobal.ddmirror.monitor.core.WindowCallbacks;
import com.didiglobal.ddmirror.monitor.model.EventData;
import com.didiglobal.ddmirror.monitor.touch.TouchEventHelper;
import com.didiglobal.ddmirror.monitor.touch.TouchRecord;
import com.didiglobal.ddmirror.monitor.touch.TouchRecordManager;
import com.didiglobal.ddmirror.monitor.touch.TouchTracker;
import java.util.LinkedList;

public class PrismMonitorWindowCallbacks extends WindowCallbacks {
    PrismMonitor mPrismMonitor = PrismMonitor.getInstance();
    private Window window;

    public PrismMonitorWindowCallbacks(Window window2) {
        super(window2.getCallback());
        this.window = window2;
    }

    public boolean touchEvent(MotionEvent motionEvent) {
        TouchRecord touchRecord;
        if (this.mPrismMonitor.isMonitoring()) {
            TouchRecordManager.getInstance().touchEvent(motionEvent);
            if (motionEvent.getActionMasked() == 1 && (touchRecord = TouchRecordManager.getInstance().getTouchRecord()) != null && touchRecord.isClick) {
                int[] iArr = {(int) touchRecord.mDownX, (int) touchRecord.mDownY};
                ViewGroup viewGroup = (ViewGroup) this.window.getDecorView();
                if (!touchRecord.isClick) {
                    iArr = null;
                }
                View findTargetView = TouchTracker.findTargetView(viewGroup, iArr);
                if (findTargetView != null) {
                    EventData createEventData = TouchEventHelper.createEventData(this.window, findTargetView, touchRecord);
                    findView(findTargetView, touchRecord);
                    if (createEventData != null) {
                        this.mPrismMonitor.post(createEventData);
                    }
                }
            }
        }
        return false;
    }

    public boolean dispatchBackKeyEvent() {
        if (!this.mPrismMonitor.isMonitoring()) {
            return false;
        }
        this.mPrismMonitor.post(1);
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mPrismMonitor.isMonitoring() && this.window.getAttributes().type == 2) {
            this.mPrismMonitor.post(4);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPrismMonitor.isMonitoring() && this.window.getAttributes().type == 2) {
            this.mPrismMonitor.post(5);
        }
    }

    private void findView(View view, TouchRecord touchRecord) {
        if (view instanceof ViewGroup) {
            LinkedList linkedList = new LinkedList();
            linkedList.push(view);
            while (!linkedList.isEmpty()) {
                View view2 = (View) linkedList.pop();
                printView(view2, touchRecord);
                if (view2 instanceof ViewGroup) {
                    int i = 0;
                    while (true) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        if (i >= viewGroup.getChildCount()) {
                            break;
                        }
                        linkedList.push(viewGroup.getChildAt(i));
                        i++;
                    }
                }
            }
        }
    }

    private void printView(View view, TouchRecord touchRecord) {
        EventData createEventData = TouchEventHelper.createEventData(this.window, view, touchRecord);
        SystemUtils.log(3, "aa", "view:" + view + "; path: " + createEventData.getUnionId(), (Throwable) null, "com.didiglobal.ddmirror.monitor.event.PrismMonitorWindowCallbacks", 99);
    }
}
