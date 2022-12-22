package com.kwai.koom.javaoom.monitor;

import java.util.ArrayList;
import java.util.List;

public class MonitorManager {

    /* renamed from: a */
    private List<Monitor> f55632a = new ArrayList();

    /* renamed from: b */
    private MonitorThread f55633b = new MonitorThread();

    public void start() {
        this.f55633b.start(this.f55632a);
    }

    public void stop() {
        for (Monitor stop : this.f55632a) {
            stop.stop();
        }
        this.f55633b.stop();
    }

    public void startMonitor(Monitor monitor) {
        monitor.start();
    }

    public void stopMonitor(Monitor monitor) {
        monitor.stop();
    }

    public void addMonitor(Monitor monitor) {
        this.f55632a.add(monitor);
    }

    public void removeMonitor(Monitor monitor) {
        this.f55632a.remove(monitor);
    }

    public void setTriggerListener(MonitorTriggerListener monitorTriggerListener) {
        this.f55633b.setMonitorTriggerListener(monitorTriggerListener);
    }
}
