package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import com.didi.sdk.apm.SystemUtils;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    @Nullable
    private String[] mAbis;
    protected final Context mContext;
    @Nullable
    protected String mCorruptedLib;
    private final Map<String, Object> mLibsBeingLoaded = new HashMap();

    /* access modifiers changed from: protected */
    public abstract Unpacker makeUnpacker() throws IOException;

    protected UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    protected static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        public void close() throws IOException {
            this.content.close();
        }
    }

    protected static abstract class InputDsoIterator implements Closeable {
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;

        protected InputDsoIterator() {
        }
    }

    protected static abstract class Unpacker implements Closeable {
        public void close() throws IOException {
        }

        /* access modifiers changed from: protected */
        public abstract DsoManifest getDsoManifest() throws IOException;

        /* access modifiers changed from: protected */
        public abstract InputDsoIterator openDsoIterator() throws IOException;

        protected Unpacker() {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r4 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeState(java.io.File r3, byte r4) throws java.io.IOException {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r3, r1)
            r1 = 0
            r0.seek(r1)     // Catch:{ all -> 0x0021 }
            r0.write(r4)     // Catch:{ all -> 0x0021 }
            long r3 = r0.getFilePointer()     // Catch:{ all -> 0x0021 }
            r0.setLength(r3)     // Catch:{ all -> 0x0021 }
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ all -> 0x0021 }
            r3.sync()     // Catch:{ all -> 0x0021 }
            r0.close()
            return
        L_0x0021:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x002c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.writeState(java.io.File, byte):void");
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(str)) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        SystemUtils.log(2, TAG, "deleting unaccounted-for file " + file, (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 206);
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        String str;
        boolean writable;
        SystemUtils.log(4, TAG, "extracting DSO " + inputDso.dso.name, (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 213);
        try {
            if (this.soDirectory.setWritable(true)) {
                extractDsoImpl(inputDso, bArr);
                if (writable) {
                    return;
                }
                return;
            }
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        } finally {
            if (!this.soDirectory.setWritable(false)) {
                str = "com.facebook.soloader.UnpackingSoSource";
                SystemUtils.log(5, TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission", (Throwable) null, str, 221);
            }
        }
    }

    private void extractDsoImpl(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        InputDso inputDso2 = inputDso;
        File file = new File(this.soDirectory, inputDso2.dso.name);
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (file.exists() && !file.setWritable(true)) {
                SystemUtils.log(5, TAG, "error adding write permission to: " + file, (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 231);
            }
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                IOException iOException = e;
                SystemUtils.log(5, TAG, "error overwriting " + file + " trying to delete and start over", iOException, "com.facebook.soloader.UnpackingSoSource", 237);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            randomAccessFile2 = randomAccessFile;
            int available = inputDso2.content.available();
            if (available > 1) {
                SysUtil.fallocateIfSupported(randomAccessFile2.getFD(), (long) available);
            }
            SysUtil.copyBytes(randomAccessFile2, inputDso2.content, Integer.MAX_VALUE, bArr);
            randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
            if (file.setExecutable(true, false)) {
                if (!file.setWritable(false)) {
                    SystemUtils.log(5, TAG, "error removing " + file + " write permission", (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 257);
                }
                randomAccessFile2.close();
                return;
            }
            throw new IOException("cannot make file executable: " + file);
        } catch (IOException e2) {
            SysUtil.dumbDeleteRecursive(file);
            throw e2;
        } catch (Throwable th) {
            if (!file.setWritable(false)) {
                SystemUtils.log(5, TAG, "error removing " + file + " write permission", (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 257);
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050 A[Catch:{ all -> 0x00a8, all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067 A[Catch:{ all -> 0x00a8, all -> 0x00dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void regenerate(byte r9, com.facebook.soloader.UnpackingSoSource.DsoManifest r10, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r11) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r8.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r2 = 2
            java.lang.String r3 = "fb-UnpackingSoSource"
            r5 = 0
            java.lang.String r6 = "com.facebook.soloader.UnpackingSoSource"
            r7 = 267(0x10b, float:3.74E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            java.io.File r0 = new java.io.File
            java.io.File r1 = r8.soDirectory
            java.lang.String r2 = "dso_manifest"
            r0.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r0, r2)
            r0 = 1
            if (r9 != r0) goto L_0x004c
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r1)     // Catch:{ Exception -> 0x003f }
            goto L_0x004d
        L_0x003c:
            r9 = move-exception
            goto L_0x00db
        L_0x003f:
            r5 = move-exception
            java.lang.String r3 = "fb-UnpackingSoSource"
            java.lang.String r4 = "error reading existing DSO manifest"
            r2 = 4
            java.lang.String r6 = "com.facebook.soloader.UnpackingSoSource"
            r7 = 275(0x113, float:3.85E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x003c }
        L_0x004c:
            r9 = 0
        L_0x004d:
            r2 = 0
            if (r9 != 0) goto L_0x0057
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch:{ all -> 0x003c }
            com.facebook.soloader.UnpackingSoSource$Dso[] r3 = new com.facebook.soloader.UnpackingSoSource.Dso[r2]     // Catch:{ all -> 0x003c }
            r9.<init>(r3)     // Catch:{ all -> 0x003c }
        L_0x0057:
            com.facebook.soloader.UnpackingSoSource$Dso[] r10 = r10.dsos     // Catch:{ all -> 0x003c }
            r8.deleteUnmentionedFiles(r10)     // Catch:{ all -> 0x003c }
            r10 = 32768(0x8000, float:4.5918E-41)
            byte[] r10 = new byte[r10]     // Catch:{ all -> 0x003c }
        L_0x0061:
            boolean r3 = r11.hasNext()     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x00b3
            com.facebook.soloader.UnpackingSoSource$InputDso r3 = r11.next()     // Catch:{ all -> 0x003c }
            r4 = 1
            r5 = 0
        L_0x006d:
            if (r4 == 0) goto L_0x009a
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x0098 }
            int r6 = r6.length     // Catch:{ all -> 0x0098 }
            if (r5 >= r6) goto L_0x009a
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x0098 }
            r6 = r6[r5]     // Catch:{ all -> 0x0098 }
            java.lang.String r6 = r6.name     // Catch:{ all -> 0x0098 }
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch:{ all -> 0x0098 }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x0098 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0098 }
            if (r6 == 0) goto L_0x0095
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x0098 }
            r6 = r6[r5]     // Catch:{ all -> 0x0098 }
            java.lang.String r6 = r6.hash     // Catch:{ all -> 0x0098 }
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch:{ all -> 0x0098 }
            java.lang.String r7 = r7.hash     // Catch:{ all -> 0x0098 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0098 }
            if (r6 == 0) goto L_0x0095
            r4 = 0
        L_0x0095:
            int r5 = r5 + 1
            goto L_0x006d
        L_0x0098:
            r9 = move-exception
            goto L_0x00a0
        L_0x009a:
            if (r4 == 0) goto L_0x00ad
            r8.extractDso(r3, r10)     // Catch:{ all -> 0x0098 }
            goto L_0x00ad
        L_0x00a0:
            throw r9     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            r10 = move-exception
            if (r3 == 0) goto L_0x00ac
            r3.close()     // Catch:{ all -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r11 = move-exception
            r9.addSuppressed(r11)     // Catch:{ all -> 0x003c }
        L_0x00ac:
            throw r10     // Catch:{ all -> 0x003c }
        L_0x00ad:
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ all -> 0x003c }
            goto L_0x0061
        L_0x00b3:
            r1.close()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Finished regenerating DSO store "
            r9.append(r10)
            java.lang.Class r10 = r8.getClass()
            java.lang.String r10 = r10.getName()
            r9.append(r10)
            java.lang.String r2 = r9.toString()
            r0 = 2
            r3 = 0
            r5 = 300(0x12c, float:4.2E-43)
            java.lang.String r1 = "fb-UnpackingSoSource"
            java.lang.String r4 = "com.facebook.soloader.UnpackingSoSource"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            return
        L_0x00db:
            throw r9     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r10 = move-exception
            r1.close()     // Catch:{ all -> 0x00e1 }
            goto L_0x00e5
        L_0x00e1:
            r11 = move-exception
            r9.addSuppressed(r11)
        L_0x00e5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean refreshLocked(com.facebook.soloader.FileLocker r18, int r19, byte[] r20) throws java.io.IOException {
        /*
            r17 = this;
            r8 = r17
            java.io.File r6 = new java.io.File
            java.io.File r0 = r8.soDirectory
            java.lang.String r1 = "dso_state"
            r6.<init>(r0, r1)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r0 = "rw"
            r1.<init>(r6, r0)
            r9 = 1
            r2 = 0
            byte r3 = r1.readByte()     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            if (r3 == r9) goto L_0x004e
            java.lang.String r11 = "fb-UnpackingSoSource"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            r3.<init>()     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            java.lang.String r4 = "dso store "
            r3.append(r4)     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            java.io.File r4 = r8.soDirectory     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            r3.append(r4)     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            java.lang.String r4 = " regeneration interrupted: wiping clean"
            r3.append(r4)     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            java.lang.String r12 = r3.toString()     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
            r10 = 2
            r13 = 0
            java.lang.String r14 = "com.facebook.soloader.UnpackingSoSource"
            r15 = 311(0x137, float:4.36E-43)
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)     // Catch:{ EOFException -> 0x003d, all -> 0x003f }
        L_0x003d:
            r3 = 0
            goto L_0x004e
        L_0x003f:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r0 = move-exception
            r3 = r0
            r1.close()     // Catch:{ all -> 0x0048 }
            goto L_0x004d
        L_0x0048:
            r0 = move-exception
            r1 = r0
            r2.addSuppressed(r1)
        L_0x004d:
            throw r3
        L_0x004e:
            r1.close()
            java.io.File r4 = new java.io.File
            java.io.File r1 = r8.soDirectory
            java.lang.String r5 = "dso_deps"
            r4.<init>(r1, r5)
            r1 = 0
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile
            r5.<init>(r4, r0)
            long r10 = r5.length()     // Catch:{ all -> 0x0124 }
            int r0 = (int) r10     // Catch:{ all -> 0x0124 }
            byte[] r7 = new byte[r0]     // Catch:{ all -> 0x0124 }
            int r10 = r5.read(r7)     // Catch:{ all -> 0x0124 }
            if (r10 == r0) goto L_0x007e
            java.lang.String r12 = "fb-UnpackingSoSource"
            java.lang.String r13 = "short read of so store deps file: marking unclean"
            r11 = 2
            r14 = 0
            java.lang.String r15 = "com.facebook.soloader.UnpackingSoSource"
            r16 = 324(0x144, float:4.54E-43)
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0124 }
            r0 = r20
            r3 = 0
            goto L_0x0080
        L_0x007e:
            r0 = r20
        L_0x0080:
            boolean r7 = java.util.Arrays.equals(r7, r0)     // Catch:{ all -> 0x0124 }
            if (r7 != 0) goto L_0x0094
            java.lang.String r11 = "fb-UnpackingSoSource"
            java.lang.String r12 = "deps mismatch on deps store: regenerating"
            r10 = 2
            r13 = 0
            java.lang.String r14 = "com.facebook.soloader.UnpackingSoSource"
            r15 = 329(0x149, float:4.61E-43)
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0124 }
            r3 = 0
        L_0x0094:
            if (r3 == 0) goto L_0x009d
            r7 = r19 & 2
            if (r7 == 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r7 = r1
            goto L_0x00c6
        L_0x009d:
            java.lang.String r11 = "fb-UnpackingSoSource"
            java.lang.String r12 = "so store dirty: regenerating"
            r10 = 2
            r13 = 0
            java.lang.String r14 = "com.facebook.soloader.UnpackingSoSource"
            r15 = 334(0x14e, float:4.68E-43)
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0124 }
            writeState(r6, r2)     // Catch:{ all -> 0x0124 }
            com.facebook.soloader.UnpackingSoSource$Unpacker r1 = r17.makeUnpacker()     // Catch:{ all -> 0x0124 }
            com.facebook.soloader.UnpackingSoSource$DsoManifest r7 = r1.getDsoManifest()     // Catch:{ all -> 0x0113 }
            com.facebook.soloader.UnpackingSoSource$InputDsoIterator r10 = r1.openDsoIterator()     // Catch:{ all -> 0x0113 }
            r8.regenerate(r3, r7, r10)     // Catch:{ all -> 0x0102 }
            if (r10 == 0) goto L_0x00c1
            r10.close()     // Catch:{ all -> 0x0113 }
        L_0x00c1:
            if (r1 == 0) goto L_0x00c6
            r1.close()     // Catch:{ all -> 0x0124 }
        L_0x00c6:
            r5.close()
            if (r7 != 0) goto L_0x00cc
            return r2
        L_0x00cc:
            com.facebook.soloader.UnpackingSoSource$1 r10 = new com.facebook.soloader.UnpackingSoSource$1
            r1 = r10
            r2 = r17
            r3 = r4
            r4 = r20
            r5 = r7
            r7 = r18
            r1.<init>(r3, r4, r5, r6, r7)
            r0 = r19 & 1
            if (r0 == 0) goto L_0x00fe
            java.lang.Thread r0 = new java.lang.Thread
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SoSync:"
            r1.append(r2)
            java.io.File r2 = r8.soDirectory
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r10, r1)
            r0.start()
            goto L_0x0101
        L_0x00fe:
            r10.run()
        L_0x0101:
            return r9
        L_0x0102:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x0105 }
        L_0x0105:
            r0 = move-exception
            r3 = r0
            if (r10 == 0) goto L_0x0112
            r10.close()     // Catch:{ all -> 0x010d }
            goto L_0x0112
        L_0x010d:
            r0 = move-exception
            r4 = r0
            r2.addSuppressed(r4)     // Catch:{ all -> 0x0113 }
        L_0x0112:
            throw r3     // Catch:{ all -> 0x0113 }
        L_0x0113:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x0116 }
        L_0x0116:
            r0 = move-exception
            r3 = r0
            if (r1 == 0) goto L_0x0123
            r1.close()     // Catch:{ all -> 0x011e }
            goto L_0x0123
        L_0x011e:
            r0 = move-exception
            r1 = r0
            r2.addSuppressed(r1)     // Catch:{ all -> 0x0124 }
        L_0x0123:
            throw r3     // Catch:{ all -> 0x0124 }
        L_0x0124:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0127 }
        L_0x0127:
            r0 = move-exception
            r2 = r0
            r5.close()     // Catch:{ all -> 0x012d }
            goto L_0x0132
        L_0x012d:
            r0 = move-exception
            r3 = r0
            r1.addSuppressed(r3)
        L_0x0132:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getDepsBlock() throws java.io.IOException {
        /*
            r5 = this;
            android.os.Parcel r0 = android.os.Parcel.obtain()
            com.facebook.soloader.UnpackingSoSource$Unpacker r1 = r5.makeUnpacker()
            com.facebook.soloader.UnpackingSoSource$DsoManifest r2 = r1.getDsoManifest()     // Catch:{ all -> 0x0038 }
            com.facebook.soloader.UnpackingSoSource$Dso[] r2 = r2.dsos     // Catch:{ all -> 0x0038 }
            r3 = 1
            r0.writeByte(r3)     // Catch:{ all -> 0x0038 }
            int r3 = r2.length     // Catch:{ all -> 0x0038 }
            r0.writeInt(r3)     // Catch:{ all -> 0x0038 }
            r3 = 0
        L_0x0017:
            int r4 = r2.length     // Catch:{ all -> 0x0038 }
            if (r3 >= r4) goto L_0x002b
            r4 = r2[r3]     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = r4.name     // Catch:{ all -> 0x0038 }
            r0.writeString(r4)     // Catch:{ all -> 0x0038 }
            r4 = r2[r3]     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = r4.hash     // Catch:{ all -> 0x0038 }
            r0.writeString(r4)     // Catch:{ all -> 0x0038 }
            int r3 = r3 + 1
            goto L_0x0017
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            byte[] r1 = r0.marshall()
            r0.recycle()
            return r1
        L_0x0038:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003a }
        L_0x003a:
            r2 = move-exception
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0045:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.getDepsBlock():byte[]");
    }

    /* access modifiers changed from: protected */
    public void prepare(int i) throws IOException {
        String str;
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker lock = FileLocker.lock(new File(this.soDirectory, LOCK_FILE_NAME));
        try {
            SystemUtils.log(2, TAG, "locked dso store " + this.soDirectory, (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 432);
            if (refreshLocked(lock, i, getDepsBlock())) {
                lock = null;
            } else {
                SystemUtils.log(4, TAG, "dso store is up-to-date: " + this.soDirectory, (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 436);
            }
            if (lock == null) {
                SystemUtils.log(2, TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)", (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 443);
            }
        } finally {
            if (lock != null) {
                str = "com.facebook.soloader.UnpackingSoSource";
                SystemUtils.log(2, TAG, "releasing dso store lock for " + this.soDirectory, (Throwable) null, str, 440);
                lock.close();
            } else {
                SystemUtils.log(2, TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)", (Throwable) null, "com.facebook.soloader.UnpackingSoSource", 443);
            }
        }
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }
}
