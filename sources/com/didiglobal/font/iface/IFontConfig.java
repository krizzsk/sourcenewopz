package com.didiglobal.font.iface;

import android.content.Context;

public interface IFontConfig {
    Context getContext();

    String getCssConfig();

    String getWeightRule();

    Boolean isFlutterSupport();

    Boolean isH5Support();

    Boolean isH5Support(String str);

    Boolean isSupport();
}
