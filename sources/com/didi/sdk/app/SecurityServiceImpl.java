package com.didi.sdk.app;

import com.didi.sdk.security.SecurityUtil;
import com.didichuxing.swarm.toolkit.SecurityService;

public class SecurityServiceImpl implements SecurityService {
    public String getSecurityId() {
        return SecurityUtil.getSUUID();
    }
}
