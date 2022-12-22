package com.didi.soda.customer.foundation.tracker.model;

import android.os.Bundle;

public class ModuleModel {

    /* renamed from: a */
    private Bundle f41104a = new Bundle();
    public int mColumnInModule = -1;
    public int mIndexInModule = -1;
    public String mModuleId;
    public int mModuleIndex = -1;
    public String mModuleType;
    public int mPageInModule = -1;
    public String mRecId;
    public int mRowInModule = -1;
    public String traceId;

    public Bundle getExtra() {
        return this.f41104a;
    }
}
