package com.didi.safetoolkit.imageloader;

import android.view.View;

public interface ISfImageLoader {
    void cancel(Object obj);

    void loadInto(Object obj, View view);

    void loadInto(Object obj, View view, int i);
}
