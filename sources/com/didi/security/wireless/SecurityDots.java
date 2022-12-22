package com.didi.security.wireless;

import android.view.InputDevice;
import android.view.MotionEvent;
import java.util.ArrayList;

public class SecurityDots {
    private static final int DOTS_CAPACITY = 512;
    private boolean actionMoveCollected;
    private int capacity;
    private ArrayList<String> dots;
    private InputDevice inputDevice;
    private String inputDeviceDetail;
    private boolean isTouchOn;

    private static class Holder {
        /* access modifiers changed from: private */
        public static SecurityDots instance = new SecurityDots();

        private Holder() {
        }
    }

    public static SecurityDots getInstance() {
        return Holder.instance;
    }

    private SecurityDots() {
        this.dots = new ArrayList<>();
        this.actionMoveCollected = false;
        this.inputDeviceDetail = "";
        this.inputDevice = null;
        this.capacity = 512;
        this.isTouchOn = false;
    }

    public void setTouch(boolean z) {
        this.isTouchOn = z;
    }

    public String getTouchList() {
        if (!this.isTouchOn) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.dots.size(); i++) {
            if (i != 0) {
                sb.append("|");
            }
            sb.append(this.dots.get(i));
        }
        return sb.toString();
    }

    public String getTouchDevice() {
        if (!this.isTouchOn) {
            return null;
        }
        return this.inputDeviceDetail;
    }

    public void reset() {
        this.dots.clear();
        this.inputDevice = null;
        this.inputDeviceDetail = "";
        this.actionMoveCollected = false;
    }

    public void setDotsCapacity(int i) {
        this.capacity = i;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (this.isTouchOn && this.dots.size() <= this.capacity) {
            if (this.inputDevice == null) {
                InputDevice device = motionEvent.getDevice();
                this.inputDevice = device;
                if (device != null) {
                    this.inputDeviceDetail = TouchManager.getDeviceInfo(device);
                }
            }
            if (motionEvent.getAction() == 2) {
                if (!this.actionMoveCollected) {
                    this.actionMoveCollected = true;
                } else {
                    return;
                }
            }
            this.dots.add(TouchManager.genResult(motionEvent));
        }
    }

    public void report(String str) {
        if (this.isTouchOn) {
            SecurityManager.report("touch", str);
        }
    }
}
