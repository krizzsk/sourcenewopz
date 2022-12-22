package org.apache.commons.p071io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.p071io.FileUtils;

/* renamed from: org.apache.commons.io.output.LockableFileWriter */
public class LockableFileWriter extends Writer {
    private static final String LCK = ".lck";
    private final File lockFile;
    private final Writer out;

    public LockableFileWriter(String str) throws IOException {
        this(str, false, (String) null);
    }

    public LockableFileWriter(String str, boolean z) throws IOException {
        this(str, z, (String) null);
    }

    public LockableFileWriter(String str, boolean z, String str2) throws IOException {
        this(new File(str), z, str2);
    }

    public LockableFileWriter(File file) throws IOException {
        this(file, false, (String) null);
    }

    public LockableFileWriter(File file, boolean z) throws IOException {
        this(file, z, (String) null);
    }

    public LockableFileWriter(File file, boolean z, String str) throws IOException {
        this(file, (String) null, z, str);
    }

    public LockableFileWriter(File file, String str) throws IOException {
        this(file, str, false, (String) null);
    }

    public LockableFileWriter(File file, String str, boolean z, String str2) throws IOException {
        File absoluteFile = file.getAbsoluteFile();
        if (absoluteFile.getParentFile() != null) {
            FileUtils.forceMkdir(absoluteFile.getParentFile());
        }
        if (!absoluteFile.isDirectory()) {
            File file2 = new File(str2 == null ? System.getProperty("java.io.tmpdir") : str2);
            FileUtils.forceMkdir(file2);
            testLockDir(file2);
            this.lockFile = new File(file2, absoluteFile.getName() + LCK);
            createLock();
            this.out = initWriter(absoluteFile, str, z);
            return;
        }
        throw new IOException("File specified is a directory");
    }

    private void testLockDir(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException("Could not find lockDir: " + file.getAbsolutePath());
        } else if (!file.canWrite()) {
            throw new IOException("Could not write to lockDir: " + file.getAbsolutePath());
        }
    }

    private void createLock() throws IOException {
        synchronized (LockableFileWriter.class) {
            if (this.lockFile.createNewFile()) {
                this.lockFile.deleteOnExit();
            } else {
                throw new IOException("Can't write file, lock " + this.lockFile.getAbsolutePath() + " exists");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.Writer initWriter(java.io.File r5, java.lang.String r6, boolean r7) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r5.exists()
            r1 = 0
            if (r6 != 0) goto L_0x0011
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ IOException -> 0x0038, RuntimeException -> 0x0025 }
            java.lang.String r2 = r5.getAbsolutePath()     // Catch:{ IOException -> 0x0038, RuntimeException -> 0x0025 }
            r6.<init>(r2, r7)     // Catch:{ IOException -> 0x0038, RuntimeException -> 0x0025 }
            goto L_0x0020
        L_0x0011:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0038, RuntimeException -> 0x0025 }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ IOException -> 0x0038, RuntimeException -> 0x0025 }
            r2.<init>(r3, r7)     // Catch:{ IOException -> 0x0038, RuntimeException -> 0x0025 }
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0023, RuntimeException -> 0x0021 }
            r7.<init>(r2, r6)     // Catch:{ IOException -> 0x0023, RuntimeException -> 0x0021 }
            r6 = r7
        L_0x0020:
            return r6
        L_0x0021:
            r6 = move-exception
            goto L_0x0027
        L_0x0023:
            r6 = move-exception
            goto L_0x003a
        L_0x0025:
            r6 = move-exception
            r2 = r1
        L_0x0027:
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.Writer) r1)
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.OutputStream) r2)
            java.io.File r7 = r4.lockFile
            org.apache.commons.p071io.FileUtils.deleteQuietly(r7)
            if (r0 != 0) goto L_0x0037
            org.apache.commons.p071io.FileUtils.deleteQuietly(r5)
        L_0x0037:
            throw r6
        L_0x0038:
            r6 = move-exception
            r2 = r1
        L_0x003a:
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.Writer) r1)
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.OutputStream) r2)
            java.io.File r7 = r4.lockFile
            org.apache.commons.p071io.FileUtils.deleteQuietly(r7)
            if (r0 != 0) goto L_0x004a
            org.apache.commons.p071io.FileUtils.deleteQuietly(r5)
        L_0x004a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p071io.output.LockableFileWriter.initWriter(java.io.File, java.lang.String, boolean):java.io.Writer");
    }

    public void close() throws IOException {
        try {
            this.out.close();
        } finally {
            this.lockFile.delete();
        }
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }

    public void write(String str) throws IOException {
        this.out.write(str);
    }

    public void write(String str, int i, int i2) throws IOException {
        this.out.write(str, i, i2);
    }

    public void flush() throws IOException {
        this.out.flush();
    }
}
