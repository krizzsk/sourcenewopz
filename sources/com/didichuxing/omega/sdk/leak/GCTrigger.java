package com.didichuxing.omega.sdk.leak;

class GCTrigger {
    GCTrigger() {
    }

    public void runGc() {
        Runtime.getRuntime().gc();
        enqueueReferences();
        System.runFinalization();
    }

    private void enqueueReferences() {
        try {
            Thread.sleep((long) LeakCollector.WAIT_GC_SLEEP_TIME);
        } catch (InterruptedException unused) {
            throw new AssertionError();
        }
    }
}
