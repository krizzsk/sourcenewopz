package com.didi.sdk.envsetbase.toolbase;

import android.content.Context;
import com.taxis99.R;

public abstract class IEnvTool implements Comparable<IEnvTool> {
    public int getIcon() {
        return R.drawable.env_icon_btn;
    }

    public abstract String getName();

    public int getWeight() {
        return 0;
    }

    public abstract void openTool(Context context);

    public EnvGroup getGroup() {
        return EnvGroup.OTHERTOOLS;
    }

    public int compareTo(IEnvTool iEnvTool) {
        int groupWeight = iEnvTool.getGroup().getGroupWeight() - getGroup().getGroupWeight();
        return groupWeight == 0 ? iEnvTool.getWeight() - getWeight() : groupWeight;
    }
}
