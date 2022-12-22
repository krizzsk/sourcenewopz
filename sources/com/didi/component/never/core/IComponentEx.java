package com.didi.component.never.core;

import android.os.Bundle;

public interface IComponentEx extends IComponent {
    public static final String BUNDLE_KEY_BID = "BUNDLE_KEY_BID";
    public static final String BUNDLE_KEY_COMBO_TYPE = "BUNDLE_KEY_COMBO_TYPE";
    public static final String BUNDLE_KEY_PARAMS = "BUNDLE_KEY_PARAMS";
    public static final String BUNDLE_KEY_PARENT_SID = "BUNDLE_KEY_PARENT_SID";
    public static final String BUNDLE_KEY_SID = "BUNDLE_KEY_SID";
    public static final String BUNDLE_KEY_TYPE = "BUNDLE_KEY_TYPE";

    <T> T getExtra(String str);

    void setExtras(Bundle bundle);
}
