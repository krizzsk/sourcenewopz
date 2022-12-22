package com.didiglobal.ddmirror.monitor.core;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

public class WindowCallbacks implements Window.Callback {
    private Window.Callback mCallBack;

    public boolean dispatchBackKeyEvent() {
        return false;
    }

    public boolean touchEvent(MotionEvent motionEvent) {
        return false;
    }

    public WindowCallbacks(Window.Callback callback) {
        this.mCallBack = callback;
    }

    public Window.Callback getCallBack() {
        return this.mCallBack;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            Window.Callback callback = this.mCallBack;
            if (callback == null || !callback.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        } else if (dispatchBackKeyEvent()) {
            return true;
        } else {
            Window.Callback callback2 = this.mCallBack;
            if (callback2 == null || !callback2.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mCallBack != null && (touchEvent(motionEvent) || this.mCallBack.dispatchTouchEvent(motionEvent));
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.dispatchTrackballEvent(motionEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        Window.Callback callback = this.mCallBack;
        if (callback == null) {
            return null;
        }
        return callback.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onWindowAttributesChanged(layoutParams);
        }
    }

    public void onContentChanged() {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onWindowFocusChanged(z);
        }
    }

    public void onAttachedToWindow() {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onAttachedToWindow();
        }
    }

    public void onDetachedFromWindow() {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onDetachedFromWindow();
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onPanelClosed(i, menu);
        }
    }

    public boolean onSearchRequested() {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        Window.Callback callback = this.mCallBack;
        return callback != null && callback.onSearchRequested(searchEvent);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Window.Callback callback2 = this.mCallBack;
        if (callback2 == null) {
            return null;
        }
        return callback2.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        Window.Callback callback2 = this.mCallBack;
        if (callback2 == null) {
            return null;
        }
        return callback2.onWindowStartingActionMode(callback, i);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onActionModeStarted(actionMode);
        }
    }

    public void onActionModeFinished(ActionMode actionMode) {
        Window.Callback callback = this.mCallBack;
        if (callback != null) {
            callback.onActionModeFinished(actionMode);
        }
    }
}
