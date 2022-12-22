package com.didi.reactive.tracker;

import android.view.View;
import java.util.Map;

public class OneshotShowEventAttrGetter implements ShowEventAttrGetter {
    public Map getAttrs() {
        return null;
    }

    public Object getShowTag(View view) {
        return view;
    }
}
