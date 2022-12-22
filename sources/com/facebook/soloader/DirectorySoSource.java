package com.facebook.soloader;

import android.os.StrictMode;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;
import org.osgi.framework.VersionRange;

public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    protected final int flags;
    protected final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this.soDirectory = file;
        this.flags = i;
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            SystemUtils.log(3, "SoLoader", str + " not found on " + file.getCanonicalPath(), (Throwable) null, "com.facebook.soloader.DirectorySoSource", 59);
            return 0;
        }
        SystemUtils.log(3, "SoLoader", str + " found on " + file.getCanonicalPath(), (Throwable) null, "com.facebook.soloader.DirectorySoSource", 62);
        if ((i & 1) == 0 || (this.flags & 2) == 0) {
            if ((this.flags & 1) != 0) {
                loadDependencies(file2, i, threadPolicy);
            } else {
                SystemUtils.log(3, "SoLoader", "Not resolving dependencies for " + str, (Throwable) null, "com.facebook.soloader.DirectorySoSource", 73);
            }
            try {
                SoLoader.sSoFileLoader.load(file2.getAbsolutePath(), i);
                return 1;
            } catch (UnsatisfiedLinkError e) {
                if (e.getMessage().contains("bad ELF magic")) {
                    SystemUtils.log(3, "SoLoader", "Corrupted lib file detected", (Throwable) null, "com.facebook.soloader.DirectorySoSource", 80);
                    return 3;
                }
                throw e;
            }
        } else {
            SystemUtils.log(3, "SoLoader", str + " loaded implicitly", (Throwable) null, "com.facebook.soloader.DirectorySoSource", 66);
            return 2;
        }
    }

    @Nullable
    public String getLibraryPath(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file.getCanonicalPath();
        }
        return null;
    }

    @Nullable
    public String[] getLibraryDependencies(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return getDependencies(file);
        }
        return null;
    }

    private static void loadDependencies(File file, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies = getDependencies(file);
        SystemUtils.log(3, "SoLoader", "Loading lib dependencies: " + Arrays.toString(dependencies), (Throwable) null, "com.facebook.soloader.DirectorySoSource", 115);
        for (String str : dependencies) {
            if (!str.startsWith("/")) {
                SoLoader.loadLibraryBySoName(str, i | 1, threadPolicy);
            }
        }
    }

    private static String[] getDependencies(File file) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", file.getName(), Const.jaRight);
        }
        try {
            return MinElf.extract_DT_NEEDED(file);
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    @Nullable
    public File unpackLibrary(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    public String toString() {
        String str;
        try {
            str = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            str = this.soDirectory.getName();
        }
        return getClass().getName() + "[root = " + str + " flags = " + this.flags + VersionRange.RIGHT_CLOSED;
    }
}
