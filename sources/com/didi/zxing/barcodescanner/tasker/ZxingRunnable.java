package com.didi.zxing.barcodescanner.tasker;

import com.didi.zxing.barcodescanner.SourceData;
import com.didi.zxing.barcodescanner.executor.BalanceRunnable;

public abstract class ZxingRunnable extends BalanceRunnable {
    private SourceData source;

    public ZxingRunnable(SourceData sourceData) {
        this.source = sourceData;
    }

    public SourceData getSource() {
        return this.source;
    }

    public void setSource(SourceData sourceData) {
        this.source = sourceData;
    }

    public void clear() {
        this.source = null;
    }
}
