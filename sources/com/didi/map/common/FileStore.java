package com.didi.map.common;

import android.os.StatFs;
import com.didi.hawaii.utils.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;

public class FileStore {

    /* renamed from: a */
    private String f24644a;

    /* renamed from: b */
    private File f24645b;

    /* renamed from: c */
    private long f24646c;

    /* renamed from: d */
    private long f24647d = -1;

    /* renamed from: e */
    private Object f24648e;

    public void setComparator(Comparator<File> comparator) {
    }

    public FileStore(String str, long j) {
        this.f24644a = str;
        File file = new File(str);
        this.f24645b = file;
        if (!file.exists()) {
            this.f24645b.mkdir();
        }
        this.f24646c = j;
        this.f24648e = new Object();
    }

    public boolean save(String str, byte[] bArr) {
        return save("", str, bArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0038 A[SYNTHETIC, Splitter:B:25:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0042 A[SYNTHETIC, Splitter:B:31:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x004d A[SYNTHETIC, Splitter:B:37:0x004d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0033=Splitter:B:22:0x0033, B:28:0x003d=Splitter:B:28:0x003d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean save(java.lang.String r5, java.lang.String r6, byte[] r7) {
        /*
            r4 = this;
            int r0 = r7.length
            boolean r0 = r4.m17551a((int) r0)
            r1 = 0
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            java.io.File r5 = r4.m17554b(r5, r6)
            r6 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0032 }
            r0.<init>(r5)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0032 }
            r0.write(r7)     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002a, all -> 0x0027 }
            long r5 = r4.f24647d     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002a, all -> 0x0027 }
            int r7 = r7.length     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002a, all -> 0x0027 }
            long r2 = (long) r7     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002a, all -> 0x0027 }
            long r5 = r5 + r2
            r4.f24647d = r5     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002a, all -> 0x0027 }
            r5 = 1
            r0.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0026:
            return r5
        L_0x0027:
            r5 = move-exception
            r6 = r0
            goto L_0x004b
        L_0x002a:
            r5 = move-exception
            r6 = r0
            goto L_0x0033
        L_0x002d:
            r5 = move-exception
            r6 = r0
            goto L_0x003d
        L_0x0030:
            r5 = move-exception
            goto L_0x004b
        L_0x0032:
            r5 = move-exception
        L_0x0033:
            r5.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r6 == 0) goto L_0x004a
            r6.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x003c:
            r5 = move-exception
        L_0x003d:
            r5.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r6 == 0) goto L_0x004a
            r6.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004a:
            return r1
        L_0x004b:
            if (r6 == 0) goto L_0x0055
            r6.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.common.FileStore.save(java.lang.String, java.lang.String, byte[]):boolean");
    }

    /* renamed from: a */
    private FileOutputStream m17550a(String str, String str2) throws FileNotFoundException {
        return new FileOutputStream(m17554b(str, str2));
    }

    /* renamed from: a */
    private boolean m17551a(int i) {
        long a = m17549a(this.f24644a);
        if (this.f24647d < 0) {
            this.f24647d = FileUtil.getFileLen(this.f24645b);
        }
        long j = (long) i;
        return (this.f24647d + j <= this.f24646c && a >= j) || m17552a(m17553b(i), this.f24645b);
    }

    public boolean save(String str, InputStream inputStream) {
        return save("", str, inputStream);
    }

    public boolean save(String str, String str2, InputStream inputStream) {
        if (!m17551a(0)) {
            return false;
        }
        try {
            FileOutputStream a = m17550a(str, str2);
            byte[] bArr = new byte[10240];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return true;
                }
                a.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private long m17553b(int i) {
        return this.f24646c / 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m17552a(long r11, java.io.File r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r13.exists()     // Catch:{ all -> 0x0057 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r10)
            return r1
        L_0x000a:
            java.io.File[] r13 = r13.listFiles()     // Catch:{ all -> 0x0057 }
            if (r13 == 0) goto L_0x0055
            int r0 = r13.length     // Catch:{ all -> 0x0057 }
            r2 = 1
            if (r0 >= r2) goto L_0x0015
            goto L_0x0055
        L_0x0015:
            com.didi.map.common.FileStore$1 r0 = new com.didi.map.common.FileStore$1     // Catch:{ Exception -> 0x001e }
            r0.<init>()     // Catch:{ Exception -> 0x001e }
            java.util.Arrays.sort(r13, r0)     // Catch:{ Exception -> 0x001e }
            goto L_0x0038
        L_0x001e:
            r0 = move-exception
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "hwcomparecrash"
            com.didi.hawaii.log.HWLog.m16761i(r3, r0)     // Catch:{ all -> 0x0057 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "exception"
            r3.put(r4, r0)     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "tech_hawaii_compre_crash"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r3)     // Catch:{ all -> 0x0057 }
        L_0x0038:
            r3 = 0
            int r0 = r13.length     // Catch:{ all -> 0x0057 }
            r5 = 0
        L_0x003c:
            if (r5 >= r0) goto L_0x0053
            r6 = r13[r5]     // Catch:{ all -> 0x0057 }
            long r6 = com.didi.hawaii.utils.FileUtil.deleteFiles((java.io.File) r6)     // Catch:{ all -> 0x0057 }
            long r3 = r3 + r6
            long r8 = r10.f24647d     // Catch:{ all -> 0x0057 }
            long r8 = r8 - r6
            r10.f24647d = r8     // Catch:{ all -> 0x0057 }
            int r6 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r6 < 0) goto L_0x0050
            monitor-exit(r10)
            return r2
        L_0x0050:
            int r5 = r5 + 1
            goto L_0x003c
        L_0x0053:
            monitor-exit(r10)
            return r1
        L_0x0055:
            monitor-exit(r10)
            return r1
        L_0x0057:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.common.FileStore.m17552a(long, java.io.File):boolean");
    }

    public InputStream getInputStream(String str) {
        return getInputStream("", str);
    }

    public InputStream getInputStream(String str, String str2) {
        try {
            return new FileInputStream(m17554b(str, str2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] getData(String str) {
        return getData("", str);
    }

    public byte[] getData(String str, String str2) {
        InputStream inputStream = getInputStream(str, str2);
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] readFull = FileUtil.readFull(inputStream);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readFull;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private File m17554b(String str, String str2) {
        File file;
        synchronized (this.f24648e) {
            File file2 = new File(this.f24645b, str);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file2.setLastModified(System.currentTimeMillis());
            file = new File(file2, str2);
        }
        return file;
    }

    /* renamed from: a */
    private long m17549a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception unused) {
            return 0;
        }
    }
}
