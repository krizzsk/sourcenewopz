package com.didi.component.framework.delegate;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.envsetbase.toolbase.IEnvChange;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.List;

@ServiceProvider({IEnvChange.class})
public class EnvConfigChangeMonitor implements IEnvChange {

    /* renamed from: a */
    private static final String f13735a = "EnvConfigChangeMonitor";

    public void change(Context context, int i, List<String> list) {
        SystemUtils.log(4, f13735a, "env is changed and pGetConfig cached file need to delete!", (Throwable) null, "com.didi.component.framework.delegate.EnvConfigChangeMonitor", 23);
        DDTravelConfigStore.getInstance().clear(context);
    }
}
