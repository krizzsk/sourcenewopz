package com.didi.component.never.base;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeLaunchMode;

public class ForwardOptions {
    public Bundle bundle;
    public NodeLaunchMode launchMode;
    public String nodeID;

    public ForwardOptions(String str, NodeLaunchMode nodeLaunchMode, Bundle bundle2) {
        this.nodeID = str;
        this.launchMode = nodeLaunchMode;
        this.bundle = bundle2;
    }
}
