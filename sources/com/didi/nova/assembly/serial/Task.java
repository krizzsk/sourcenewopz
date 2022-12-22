package com.didi.nova.assembly.serial;

import com.didi.nova.assembly.serial.Dispatcher;

public abstract class Task implements Dispatcher.DispatchRunnable {
    public abstract void onCancel();

    public String getCategory() {
        return getClass().getName();
    }
}
