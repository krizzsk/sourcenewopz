package com.didi.sdk.app;

import android.app.Application;
import android.os.Environment;
import com.didichuxing.swarm.launcher.util.SwarmServices;
import com.didichuxing.swarm.toolkit.OmegaService;
import java.io.File;

/* renamed from: com.didi.sdk.app.h */
/* compiled from: OmegaServiceImpl */
class C12016h implements OmegaService {
    C12016h() {
    }

    public File getLogDirectory() {
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        return new File(absolutePath + "/data/" + ((Application) SwarmServices.lookup(Application.class)).getPackageName() + "/files", "log");
    }

    public File[] getLogPaths() {
        return getLogDirectory().listFiles(new OmegaServiceImpl$1(this));
    }
}
