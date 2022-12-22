package com.didiglobal.dittoview;

import android.view.View;
import com.facebook.yoga.YogaNode;

public interface IParser {
    View getView();

    void onParseEnd();

    void parse(String str, String str2, YogaNode yogaNode);
}
