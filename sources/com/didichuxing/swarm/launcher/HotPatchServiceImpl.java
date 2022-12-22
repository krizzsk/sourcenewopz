package com.didichuxing.swarm.launcher;

import com.didichuxing.swarm.launcher.toolkit.HotPatchService;
import org.osgi.framework.launch.Framework;

public class HotPatchServiceImpl implements HotPatchService {

    /* renamed from: a */
    private long f49157a = 0;

    HotPatchServiceImpl(Framework framework) {
    }

    public void setVersion(long j) {
        this.f49157a = j;
    }

    public long getVersion() {
        return this.f49157a;
    }
}
