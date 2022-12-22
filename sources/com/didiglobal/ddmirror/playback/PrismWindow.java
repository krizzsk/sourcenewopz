package com.didiglobal.ddmirror.playback;

import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;

public class PrismWindow {
    private WeakReference<Window> mWindowReference;

    public PrismWindow(Window window) {
        this.mWindowReference = new WeakReference<>(window);
    }

    public Window getWindow() {
        return (Window) this.mWindowReference.get();
    }

    public ViewGroup getDecorView() {
        Window window = getWindow();
        if (window != null) {
            return (ViewGroup) window.getDecorView();
        }
        return null;
    }
}
