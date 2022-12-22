package com.didi.dimina.container.secondparty.jsmodule.jsbridge.setting;

import java.util.HashSet;
import java.util.Set;

public interface BridgePermission {
    public static final String NAVIGATE_TO_MINI_PROGRAM = "scope.navigateToMiniProgram";
    public static final Set<String> bridgePermissionSet = new HashSet<String>() {
        {
            add(BridgePermission.NAVIGATE_TO_MINI_PROGRAM);
        }
    };
}
