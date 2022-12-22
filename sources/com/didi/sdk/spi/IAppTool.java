package com.didi.sdk.spi;

import android.content.Context;

public interface IAppTool {
    boolean isBrazilApp(Context context);

    boolean isGlobalApp(Context context);
}
