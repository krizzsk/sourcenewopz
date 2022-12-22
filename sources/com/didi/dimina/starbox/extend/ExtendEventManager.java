package com.didi.dimina.starbox.extend;

import com.didi.dimina.container.util.LogUtil;
import java.util.LinkedList;
import java.util.List;

public class ExtendEventManager {

    /* renamed from: a */
    private final List<ExtendEvent> f17997a;

    private ExtendEventManager() {
        this.f17997a = new LinkedList();
    }

    private static class ExtendEventManagerHolder {
        /* access modifiers changed from: private */
        public static final ExtendEventManager sExtendEventManager = new ExtendEventManager();

        private ExtendEventManagerHolder() {
        }
    }

    public static ExtendEventManager getExtendEventManager() {
        return ExtendEventManagerHolder.sExtendEventManager;
    }

    public List<ExtendEvent> getExtendEventList() {
        return this.f17997a;
    }

    public void registerExtendEvent(ExtendEvent extendEvent) {
        LogUtil.m13411i("ExtendEventManager -> registerExtendEvent: " + extendEvent.getEventType());
        this.f17997a.add(extendEvent);
    }

    public void unregisterExtendEvent(ExtendEvent extendEvent) {
        LogUtil.m13411i("ExtendEventManager -> unregisterExtendEvent: " + extendEvent.getEventType());
        this.f17997a.remove(extendEvent);
    }
}
