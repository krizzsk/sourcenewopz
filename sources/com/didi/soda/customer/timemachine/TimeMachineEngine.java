package com.didi.soda.customer.timemachine;

import java.util.List;

public final class TimeMachineEngine {

    /* renamed from: a */
    private CustomerTimeMachineConfig f41405a;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final TimeMachineEngine INSTANCE = new TimeMachineEngine();

        private Holder() {
        }
    }

    private TimeMachineEngine() {
    }

    public static TimeMachineEngine getInstance() {
        return Holder.INSTANCE;
    }

    public void init(CustomerTimeMachineConfig customerTimeMachineConfig) {
        this.f41405a = customerTimeMachineConfig;
    }

    public List<String> getTraceDomainList() {
        if (checkEngineAvailable()) {
            return this.f41405a.traceDomainList();
        }
        return null;
    }

    public String getPageName() {
        if (checkEngineAvailable()) {
            return this.f41405a.getCurrentPage();
        }
        return null;
    }

    public boolean checkEngineAvailable() {
        return this.f41405a != null;
    }
}
