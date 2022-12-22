package com.didi.soda.customer.foundation.tracker.model;

import android.os.Bundle;

public class ModuleModelV2 {
    public static final String DEFAULT_PLACEHOLDER = "default";
    public int mAbsoluteIndex = -1;
    public int mColumnInModule = -1;
    public String mComponentId;
    public String mComponentType;
    private Bundle mExtra = new Bundle();
    public int mIndexInModule = -1;
    public String mModuleId;
    public String mModuleIndex = "default";
    public String mModuleType = "default";
    public String mPageFilter = "";
    public String mPageId;
    public int mPageInModule = -1;
    public String mRecId;
    public int mRowInModule = -1;
    public String mTraceId;

    public Bundle getExtra() {
        return this.mExtra;
    }

    public String toModuleString() {
        return this.mPageId + "_" + this.mComponentId + "_" + this.mModuleType + "_" + this.mComponentType + "_" + this.mModuleIndex + "_" + this.mPageInModule + "_" + this.mRowInModule + "_" + this.mColumnInModule + "_" + this.mIndexInModule + "_" + this.mAbsoluteIndex;
    }
}
