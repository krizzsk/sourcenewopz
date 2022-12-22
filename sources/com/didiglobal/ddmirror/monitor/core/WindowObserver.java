package com.didiglobal.ddmirror.monitor.core;

import android.view.View;
import android.view.Window;
import com.taxis99.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WindowObserver extends ArrayList<View> {
    private Class mDecorClass;
    private List<WindowObserverListener> mListeners = new ArrayList();
    private Field sWindowField;

    public interface WindowObserverListener {
        void add(Window window);

        void remove(Window window);
    }

    WindowObserver() {
        try {
            this.mDecorClass = Class.forName("com.android.internal.policy.DecorView");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean add(View view) {
        if (this.mDecorClass == null) {
            this.mDecorClass = view.getRootView().getClass();
        }
        if (view.getClass() != this.mDecorClass) {
            return super.add(view);
        }
        Window window = getWindow(view);
        if (window == null) {
            return super.add(view);
        }
        view.setTag(R.id.ddmirror_window, window);
        for (int i = 0; i < this.mListeners.size(); i++) {
            WindowObserverListener windowObserverListener = this.mListeners.get(i);
            if (windowObserverListener != null) {
                windowObserverListener.add(window);
            }
        }
        return super.add(view);
    }

    public View remove(int i) {
        Window window = (Window) ((View) get(i)).getTag(R.id.ddmirror_window);
        if (window != null) {
            for (int i2 = 0; i2 < this.mListeners.size(); i2++) {
                WindowObserverListener windowObserverListener = this.mListeners.get(i2);
                if (windowObserverListener != null) {
                    windowObserverListener.remove(window);
                }
            }
        }
        return (View) super.remove(i);
    }

    public void bindWindow(View view) {
        Window window;
        if (this.mDecorClass == null) {
            this.mDecorClass = view.getClass();
        }
        if (view.getClass() == this.mDecorClass && (window = getWindow(view)) != null) {
            view.setTag(R.id.ddmirror_window, window);
        }
    }

    public Window getWindow(View view) {
        if (this.sWindowField == null) {
            try {
                Field declaredField = view.getClass().getDeclaredField("mWindow");
                this.sWindowField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        Field field = this.sWindowField;
        if (field == null) {
            return null;
        }
        try {
            return (Window) field.get(view);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void addWindowObserverListener(WindowObserverListener windowObserverListener) {
        if (windowObserverListener != null) {
            this.mListeners.add(windowObserverListener);
        }
    }

    public void removeWindowObserverListener(WindowObserverListener windowObserverListener) {
        this.mListeners.remove(windowObserverListener);
    }
}
