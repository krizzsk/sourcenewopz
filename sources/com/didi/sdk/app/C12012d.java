package com.didi.sdk.app;

import com.didi.sdk.util.SystemUtil;
import com.didichuxing.swarm.toolkit.DistributionService;

/* renamed from: com.didi.sdk.app.d */
/* compiled from: DistributionServiceImpl */
class C12012d implements DistributionService {
    C12012d() {
    }

    public String getChannelId() {
        return SystemUtil.getChannelId();
    }
}
