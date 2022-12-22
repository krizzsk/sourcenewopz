package com.didi.sdk.app;

import android.content.Context;
import com.didi.sdk.spi.IAppTool;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IAppTool.class})
public class AppToolImpl implements IAppTool {
    public boolean isBrazilApp(Context context) {
        return AppUtils.isBrazilApp(context);
    }

    public boolean isGlobalApp(Context context) {
        return AppUtils.isGlobalApp(context);
    }
}
