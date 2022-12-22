package com.didichuxing.doraemonkit.kit;

import android.content.Context;

public interface IKit {
    int getCategory();

    int getIcon();

    int getName();

    void onAppInit(Context context);

    void onClick(Context context);
}
