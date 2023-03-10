package org.apache.commons.p071io;

import com.didi.safetoolkit.api.SfConstant;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.File;
import java.io.IOException;

/* renamed from: org.apache.commons.io.FileDeleteStrategy */
public class FileDeleteStrategy {
    public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();
    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy(SfConstant.SfDangerLevel.LEVEL_NORMAL);
    private final String name;

    protected FileDeleteStrategy(String str) {
        this.name = str;
    }

    public boolean deleteQuietly(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        try {
            return doDelete(file);
        } catch (IOException unused) {
            return false;
        }
    }

    public void delete(File file) throws IOException {
        if (file.exists() && !doDelete(file)) {
            throw new IOException("Deletion failed: " + file);
        }
    }

    /* access modifiers changed from: protected */
    public boolean doDelete(File file) throws IOException {
        return file.delete();
    }

    public String toString() {
        return "FileDeleteStrategy[" + this.name + Const.jaRight;
    }

    /* renamed from: org.apache.commons.io.FileDeleteStrategy$ForceFileDeleteStrategy */
    static class ForceFileDeleteStrategy extends FileDeleteStrategy {
        ForceFileDeleteStrategy() {
            super("Force");
        }

        /* access modifiers changed from: protected */
        public boolean doDelete(File file) throws IOException {
            FileUtils.forceDelete(file);
            return true;
        }
    }
}
