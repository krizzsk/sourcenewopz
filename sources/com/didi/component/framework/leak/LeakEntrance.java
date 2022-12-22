package com.didi.component.framework.leak;

import android.content.Context;
import android.content.Intent;
import com.didi.sdk.envsetbase.toolbase.EnvGroup;
import com.didi.sdk.envsetbase.toolbase.IEnvTool;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;

@ServiceProvider({IEnvTool.class})
public class LeakEntrance extends IEnvTool {
    public int getIcon() {
        return R.drawable.leak_canary;
    }

    public String getName() {
        return "Leaks";
    }

    public EnvGroup getGroup() {
        return EnvGroup.OTHERTOOLS;
    }

    public void openTool(Context context) {
        Intent intent = new Intent("com.didi.component.framework.leakcanary.ACTION");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
