package com.vladium.emma.p226rt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jacoco.agent.p086rt.C2857RT;

@Deprecated
/* renamed from: com.vladium.emma.rt.RT */
public final class C20626RT {
    private C20626RT() {
    }

    public static void dumpCoverageData(File file, boolean z, boolean z2) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, z);
        try {
            fileOutputStream.write(C2857RT.getAgent().getExecutionData(false));
        } finally {
            fileOutputStream.close();
        }
    }

    public static synchronized void dumpCoverageData(File file, boolean z) throws IOException {
        synchronized (C20626RT.class) {
            dumpCoverageData(file, true, z);
        }
    }
}
