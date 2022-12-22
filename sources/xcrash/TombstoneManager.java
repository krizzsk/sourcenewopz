package xcrash;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Comparator;

public class TombstoneManager {
    public static final String BODY_SUFFIX = ".body";
    public static final String BOTTOM_SUFFIX = ".bottom";
    public static final String ENCODE_UTF8 = "UTF-8";
    public static final String HEAD_SUFFIX = ".head";
    public static final String JAVA_STACKTRACE = "java stacktrace:";
    public static final String MEMORY_INFO = "memory info:";
    public static final String NEW_SUFFIX = ".new";

    private TombstoneManager() {
    }

    public static boolean appendSection(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str3 == null) {
            return false;
        }
        C3165c a = C3165c.m4219a();
        return a.mo38803a(str, "\n\n" + str2 + ":\n" + str3 + "\n\n");
    }

    public static boolean isJavaCrash(File file) {
        return file.getName().endsWith(".java.xcrash");
    }

    public static boolean isNativeCrash(File file) {
        return file.getName().endsWith(".native.xcrash");
    }

    public static boolean isAnr(File file) {
        return file.getName().endsWith(".anr.xcrash");
    }

    public static boolean isTrace(File file) {
        return file.getName().endsWith(".trace.xcrash");
    }

    public static File[] getJavaTombstones() {
        return m4182a(new String[]{".java.xcrash"});
    }

    public static File[] getNativeTombstones() {
        return m4182a(new String[]{".native.xcrash"});
    }

    public static File[] getAnrTombstones() {
        return m4182a(new String[]{".anr.xcrash"});
    }

    public static File[] getTraceTombstones() {
        return m4182a(new String[]{".trace.xcrash"});
    }

    public static File[] getAllTombstones() {
        return m4182a(new String[]{".java.xcrash", ".native.xcrash", ".anr.xcrash", ".trace.xcrash"});
    }

    public static boolean deleteTombstone(File file) {
        return C3165c.m4219a().mo38802a(file);
    }

    public static boolean deleteTombstone(String str) {
        return C3165c.m4219a().mo38802a(new File(str));
    }

    public static boolean clearJavaTombstones() {
        return m4183b(new String[]{".java.xcrash"});
    }

    public static boolean clearNativeTombstones() {
        return m4183b(new String[]{".native.xcrash"});
    }

    public static boolean clearAnrTombstones() {
        return m4183b(new String[]{".anr.xcrash"});
    }

    public static boolean clearAllTombstones() {
        return m4183b(new String[]{".java.xcrash", ".native.xcrash", ".anr.xcrash", ".trace.xcrash"});
    }

    public static File[] getOtherLogs(final String[] strArr) {
        String logDir = XCrash.getLogDir();
        if (logDir == null) {
            return new File[0];
        }
        File file = new File(logDir);
        if (!file.exists() || !file.isDirectory()) {
            return new File[0];
        }
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                for (String endsWith : strArr) {
                    if (str.endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            }
        });
        if (listFiles == null) {
            return new File[0];
        }
        Arrays.sort(listFiles, new Comparator<File>() {
            public int compare(File file, File file2) {
                return file.getName().compareTo(file2.getName());
            }
        });
        return listFiles;
    }

    /* renamed from: a */
    private static File[] m4182a(final String[] strArr) {
        String logDir = XCrash.getLogDir();
        if (logDir == null) {
            return new File[0];
        }
        File file = new File(logDir);
        if (!file.exists() || !file.isDirectory()) {
            return new File[0];
        }
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                if (!str.startsWith("tombstone_")) {
                    return false;
                }
                for (String endsWith : strArr) {
                    if (str.endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            }
        });
        if (listFiles == null) {
            return new File[0];
        }
        Arrays.sort(listFiles, new Comparator<File>() {
            public int compare(File file, File file2) {
                return file.getName().compareTo(file2.getName());
            }
        });
        return listFiles;
    }

    /* renamed from: b */
    private static boolean m4183b(final String[] strArr) {
        File[] listFiles;
        String logDir = XCrash.getLogDir();
        if (logDir == null) {
            return false;
        }
        File file = new File(logDir);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                if (!str.startsWith("tombstone_")) {
                    return false;
                }
                for (String endsWith : strArr) {
                    if (str.endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            }
        })) == null) {
            return false;
        }
        boolean z = true;
        for (File a : listFiles) {
            if (!C3165c.m4219a().mo38802a(a)) {
                z = false;
            }
        }
        return z;
    }

    public static void operateSrcFile(String str, String str2, String str3) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream3;
        BufferedOutputStream bufferedOutputStream4;
        BufferedOutputStream bufferedOutputStream5;
        BufferedOutputStream bufferedOutputStream6;
        BufferedOutputStream bufferedOutputStream7 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                bufferedOutputStream6 = new BufferedOutputStream(new FileOutputStream(str + HEAD_SUFFIX));
                try {
                    bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str + BODY_SUFFIX));
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedOutputStream2 = null;
                    bufferedOutputStream = null;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    e.printStackTrace();
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                } catch (IOException e2) {
                    e = e2;
                    bufferedOutputStream2 = null;
                    bufferedOutputStream = null;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    e.printStackTrace();
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                } catch (Exception e3) {
                    e = e3;
                    bufferedOutputStream2 = null;
                    bufferedOutputStream = null;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    e.printStackTrace();
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream2 = null;
                    bufferedOutputStream = null;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                bufferedOutputStream3 = null;
                bufferedOutputStream = bufferedOutputStream2;
                e.printStackTrace();
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
            } catch (IOException e5) {
                e = e5;
                bufferedOutputStream4 = null;
                bufferedOutputStream = bufferedOutputStream2;
                e.printStackTrace();
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
            } catch (Exception e6) {
                e = e6;
                bufferedOutputStream5 = null;
                bufferedOutputStream = bufferedOutputStream2;
                e.printStackTrace();
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = null;
                bufferedOutputStream = bufferedOutputStream2;
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
                throw th;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str + BOTTOM_SUFFIX));
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else if (z) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            String str4 = new String(bArr, 0, read);
                            if (!z2) {
                                int indexOf = str4.indexOf(str2);
                                if (indexOf == -1) {
                                    bufferedOutputStream6.write(bArr, 0, read);
                                } else {
                                    bufferedOutputStream6.write(bArr, 0, indexOf);
                                    bufferedOutputStream6.flush();
                                    closeBufferedOutputStream(bufferedOutputStream6);
                                    bufferedOutputStream2.write(bArr, indexOf, read - indexOf);
                                    z2 = true;
                                }
                            } else {
                                int indexOf2 = str4.indexOf(str3);
                                if (indexOf2 == -1) {
                                    bufferedOutputStream2.write(bArr, 0, read);
                                } else {
                                    bufferedOutputStream2.write(bArr, 0, indexOf2);
                                    bufferedOutputStream2.flush();
                                    closeBufferedOutputStream(bufferedOutputStream2);
                                    bufferedOutputStream.write(bArr, indexOf2, read - indexOf2);
                                    z = true;
                                }
                            }
                        }
                    }
                    bufferedOutputStream.flush();
                    closeBufferedOutputStream(bufferedOutputStream6);
                } catch (FileNotFoundException e7) {
                    e = e7;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    e.printStackTrace();
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                } catch (IOException e8) {
                    e = e8;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    e.printStackTrace();
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                } catch (Exception e9) {
                    e = e9;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    e.printStackTrace();
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream7 = bufferedOutputStream6;
                    closeBufferedOutputStream(bufferedOutputStream7);
                    closeBufferedOutputStream(bufferedOutputStream2);
                    closeBufferedOutputStream(bufferedOutputStream);
                    closeBufferedInputStream(bufferedInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                e = e10;
                bufferedOutputStream = null;
                bufferedOutputStream7 = bufferedOutputStream6;
                e.printStackTrace();
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
            } catch (IOException e11) {
                e = e11;
                bufferedOutputStream = null;
                bufferedOutputStream7 = bufferedOutputStream6;
                e.printStackTrace();
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
            } catch (Exception e12) {
                e = e12;
                bufferedOutputStream = null;
                bufferedOutputStream7 = bufferedOutputStream6;
                e.printStackTrace();
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedOutputStream7 = bufferedOutputStream6;
                closeBufferedOutputStream(bufferedOutputStream7);
                closeBufferedOutputStream(bufferedOutputStream2);
                closeBufferedOutputStream(bufferedOutputStream);
                closeBufferedInputStream(bufferedInputStream);
                throw th;
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            bufferedInputStream = null;
            bufferedOutputStream3 = null;
            bufferedOutputStream = bufferedOutputStream2;
            e.printStackTrace();
            closeBufferedOutputStream(bufferedOutputStream7);
            closeBufferedOutputStream(bufferedOutputStream2);
            closeBufferedOutputStream(bufferedOutputStream);
            closeBufferedInputStream(bufferedInputStream);
        } catch (IOException e14) {
            e = e14;
            bufferedInputStream = null;
            bufferedOutputStream4 = null;
            bufferedOutputStream = bufferedOutputStream2;
            e.printStackTrace();
            closeBufferedOutputStream(bufferedOutputStream7);
            closeBufferedOutputStream(bufferedOutputStream2);
            closeBufferedOutputStream(bufferedOutputStream);
            closeBufferedInputStream(bufferedInputStream);
        } catch (Exception e15) {
            e = e15;
            bufferedInputStream = null;
            bufferedOutputStream5 = null;
            bufferedOutputStream = bufferedOutputStream2;
            e.printStackTrace();
            closeBufferedOutputStream(bufferedOutputStream7);
            closeBufferedOutputStream(bufferedOutputStream2);
            closeBufferedOutputStream(bufferedOutputStream);
            closeBufferedInputStream(bufferedInputStream);
        } catch (Throwable th5) {
            th = th5;
            closeBufferedOutputStream(bufferedOutputStream7);
            closeBufferedOutputStream(bufferedOutputStream2);
            closeBufferedOutputStream(bufferedOutputStream);
            closeBufferedInputStream(bufferedInputStream);
            throw th;
        }
        closeBufferedOutputStream(bufferedOutputStream2);
        closeBufferedOutputStream(bufferedOutputStream);
        closeBufferedInputStream(bufferedInputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v40, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v41, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v42, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v43, resolved type: java.io.BufferedInputStream} */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r8v5, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r8v8, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r8v32 */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r8v38 */
    /* JADX WARNING: type inference failed for: r8v39 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x01c0=Splitter:B:69:0x01c0, B:63:0x0151=Splitter:B:63:0x0151, B:75:0x022e=Splitter:B:75:0x022e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void compositeAll(java.lang.String r14) {
        /*
            java.lang.String r0 = ".bottom"
            java.lang.String r1 = ".body"
            java.lang.String r2 = ".head"
            java.lang.String r3 = ".new"
            r4 = 0
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            r7.append(r14)     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            r7.append(r3)     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x022a, IOException -> 0x01bc, Exception -> 0x014d, all -> 0x0147 }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            r8.append(r14)     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            r8.append(r2)     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0143, IOException -> 0x013f, Exception -> 0x013c, all -> 0x0139 }
            r7 = 8192(0x2000, float:1.14794E-41)
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
        L_0x003f:
            int r8 = r6.read(r7)     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            r9 = 0
            r10 = -1
            if (r8 == r10) goto L_0x004b
            r5.write(r7, r9, r8)     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            goto L_0x003f
        L_0x004b:
            r5.flush()     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            r12.<init>()     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            r12.append(r14)     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            r12.append(r0)     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            java.lang.String r12 = r12.toString()     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            r11.<init>(r12)     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
            r8.<init>(r11)     // Catch:{ FileNotFoundException -> 0x0133, IOException -> 0x012d, Exception -> 0x0128, all -> 0x0122 }
        L_0x0067:
            int r11 = r8.read(r7)     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            if (r11 == r10) goto L_0x0071
            r5.write(r7, r9, r11)     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            goto L_0x0067
        L_0x0071:
            r5.flush()     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            java.io.RandomAccessFile r11 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            r12.<init>()     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            r12.append(r14)     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            r12.append(r1)     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            java.lang.String r12 = r12.toString()     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            java.lang.String r13 = "rw"
            r11.<init>(r12, r13)     // Catch:{ FileNotFoundException -> 0x011f, IOException -> 0x011c, Exception -> 0x0119, all -> 0x0116 }
            java.lang.String r4 = "memory info:\n"
            java.lang.String r12 = "UTF-8"
            byte[] r4 = r4.getBytes(r12)     // Catch:{ FileNotFoundException -> 0x0114, IOException -> 0x0112, Exception -> 0x0110, all -> 0x010e }
            int r4 = r4.length     // Catch:{ FileNotFoundException -> 0x0114, IOException -> 0x0112, Exception -> 0x0110, all -> 0x010e }
            int r4 = r4 + -1
            long r12 = (long) r4     // Catch:{ FileNotFoundException -> 0x0114, IOException -> 0x0112, Exception -> 0x0110, all -> 0x010e }
            r11.seek(r12)     // Catch:{ FileNotFoundException -> 0x0114, IOException -> 0x0112, Exception -> 0x0110, all -> 0x010e }
        L_0x0099:
            int r4 = r11.read(r7)     // Catch:{ FileNotFoundException -> 0x0114, IOException -> 0x0112, Exception -> 0x0110, all -> 0x010e }
            if (r4 == r10) goto L_0x00a3
            r5.write(r7, r9, r4)     // Catch:{ FileNotFoundException -> 0x0114, IOException -> 0x0112, Exception -> 0x0110, all -> 0x010e }
            goto L_0x0099
        L_0x00a3:
            r5.flush()     // Catch:{ FileNotFoundException -> 0x0114, IOException -> 0x0112, Exception -> 0x0110, all -> 0x010e }
            closeBufferedInputStream(r6)
            closeBufferedInputStream(r8)
            closeRandomAccessFile(r11)
            closeBufferedOutputStream(r5)
            deleteFile((java.lang.String) r14)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            deleteFile((java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            deleteFile((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            deleteFile((java.lang.String) r0)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r14)
            r0.renameTo(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x0297
        L_0x010e:
            r7 = move-exception
            goto L_0x0125
        L_0x0110:
            r7 = move-exception
            goto L_0x012b
        L_0x0112:
            r7 = move-exception
            goto L_0x0130
        L_0x0114:
            r7 = move-exception
            goto L_0x0136
        L_0x0116:
            r7 = move-exception
            r11 = r4
            goto L_0x0125
        L_0x0119:
            r7 = move-exception
            r11 = r4
            goto L_0x012b
        L_0x011c:
            r7 = move-exception
            r11 = r4
            goto L_0x0130
        L_0x011f:
            r7 = move-exception
            r11 = r4
            goto L_0x0136
        L_0x0122:
            r7 = move-exception
            r8 = r4
            r11 = r8
        L_0x0125:
            r4 = r6
            goto L_0x02a6
        L_0x0128:
            r7 = move-exception
            r8 = r4
            r11 = r8
        L_0x012b:
            r4 = r6
            goto L_0x0151
        L_0x012d:
            r7 = move-exception
            r8 = r4
            r11 = r8
        L_0x0130:
            r4 = r6
            goto L_0x01c0
        L_0x0133:
            r7 = move-exception
            r8 = r4
            r11 = r8
        L_0x0136:
            r4 = r6
            goto L_0x022e
        L_0x0139:
            r7 = move-exception
            r8 = r4
            goto L_0x014a
        L_0x013c:
            r7 = move-exception
            r8 = r4
            goto L_0x0150
        L_0x013f:
            r7 = move-exception
            r8 = r4
            goto L_0x01bf
        L_0x0143:
            r7 = move-exception
            r8 = r4
            goto L_0x022d
        L_0x0147:
            r7 = move-exception
            r5 = r4
            r8 = r5
        L_0x014a:
            r11 = r8
            goto L_0x02a6
        L_0x014d:
            r7 = move-exception
            r5 = r4
            r8 = r5
        L_0x0150:
            r11 = r8
        L_0x0151:
            r7.printStackTrace()     // Catch:{ all -> 0x02a5 }
            closeBufferedInputStream(r4)
            closeBufferedInputStream(r8)
            closeRandomAccessFile(r11)
            closeBufferedOutputStream(r5)
            deleteFile((java.lang.String) r14)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            deleteFile((java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            deleteFile((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            deleteFile((java.lang.String) r0)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r14)
            r0.renameTo(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x0297
        L_0x01bc:
            r7 = move-exception
            r5 = r4
            r8 = r5
        L_0x01bf:
            r11 = r8
        L_0x01c0:
            r7.printStackTrace()     // Catch:{ all -> 0x02a5 }
            closeBufferedInputStream(r4)
            closeBufferedInputStream(r8)
            closeRandomAccessFile(r11)
            closeBufferedOutputStream(r5)
            deleteFile((java.lang.String) r14)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            deleteFile((java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            deleteFile((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            deleteFile((java.lang.String) r0)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r14)
            r0.renameTo(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x0297
        L_0x022a:
            r7 = move-exception
            r5 = r4
            r8 = r5
        L_0x022d:
            r11 = r8
        L_0x022e:
            r7.printStackTrace()     // Catch:{ all -> 0x02a5 }
            closeBufferedInputStream(r4)
            closeBufferedInputStream(r8)
            closeRandomAccessFile(r11)
            closeBufferedOutputStream(r5)
            deleteFile((java.lang.String) r14)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            deleteFile((java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            deleteFile((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            deleteFile((java.lang.String) r0)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r14)
            r0.renameTo(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0297:
            r0.append(r14)
            r0.append(r3)
            java.lang.String r14 = r0.toString()
            deleteFile((java.lang.String) r14)
            return
        L_0x02a5:
            r7 = move-exception
        L_0x02a6:
            closeBufferedInputStream(r4)
            closeBufferedInputStream(r8)
            closeRandomAccessFile(r11)
            closeBufferedOutputStream(r5)
            deleteFile((java.lang.String) r14)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r14)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            deleteFile((java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            deleteFile((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            deleteFile((java.lang.String) r0)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r14)
            r0.renameTo(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            r0.append(r3)
            java.lang.String r14 = r0.toString()
            deleteFile((java.lang.String) r14)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.TombstoneManager.compositeAll(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int findLocationBySpecial(java.lang.String r7, java.lang.String r8) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r7 = 8192(0x2000, float:1.14794E-41)
            r1 = 0
            r2 = -1
            r3 = 0
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x003e }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x003e }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003e }
            r5.<init>(r0)     // Catch:{ Exception -> 0x003e }
            r4.<init>(r5)     // Catch:{ Exception -> 0x003e }
            r0 = 0
            r3 = -1
        L_0x0018:
            int r5 = r4.read(r7)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            if (r5 == r2) goto L_0x0030
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r6.<init>(r7, r1, r5)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            int r3 = r6.indexOf(r8)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            if (r3 != r2) goto L_0x002f
            int r5 = r6.length()     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            int r0 = r0 + r5
            goto L_0x0018
        L_0x002f:
            int r0 = r0 + r3
        L_0x0030:
            closeBufferedInputStream(r4)
            goto L_0x0048
        L_0x0034:
            r7 = move-exception
            r3 = r4
            goto L_0x004d
        L_0x0037:
            r7 = move-exception
            r1 = r0
            r8 = r3
            r3 = r4
            goto L_0x0040
        L_0x003c:
            r7 = move-exception
            goto L_0x004d
        L_0x003e:
            r7 = move-exception
            r8 = -1
        L_0x0040:
            r7.printStackTrace()     // Catch:{ all -> 0x003c }
            closeBufferedInputStream(r3)
            r3 = r8
            r0 = r1
        L_0x0048:
            if (r3 != r2) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r2 = r0
        L_0x004c:
            return r2
        L_0x004d:
            closeBufferedInputStream(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.TombstoneManager.findLocationBySpecial(java.lang.String, java.lang.String):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void insertToSpecial(java.lang.String r9, long r10, java.lang.String r12) {
        /*
            java.lang.String r0 = "UTF-8"
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.io.File r1 = new java.io.File
            r1.<init>(r9)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0015
            return
        L_0x0015:
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            java.lang.String r9 = ".tmp"
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            r2.<init>(r9)
            r9 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x00bb, IOException -> 0x00b4, Exception -> 0x00ad, all -> 0x00a9 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00bb, IOException -> 0x00b4, Exception -> 0x00ad, all -> 0x00a9 }
            r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00bb, IOException -> 0x00b4, Exception -> 0x00ad, all -> 0x00a9 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00bb, IOException -> 0x00b4, Exception -> 0x00ad, all -> 0x00a9 }
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x00a3, Exception -> 0x00a0, all -> 0x009d }
            java.lang.String r5 = "rw"
            r4.<init>(r1, r5)     // Catch:{ FileNotFoundException -> 0x00a6, IOException -> 0x00a3, Exception -> 0x00a0, all -> 0x009d }
            r4.seek(r10)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r4.readLine()     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
        L_0x0047:
            int r5 = r4.read(r1)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r6 = 0
            r7 = -1
            if (r5 == r7) goto L_0x0053
            r3.write(r1, r6, r5)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            goto L_0x0047
        L_0x0053:
            r3.flush()     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r4.seek(r10)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            byte[] r10 = r12.getBytes(r0)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r4.write(r10)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            java.lang.String r10 = "\n\n-\n"
            byte[] r10 = r10.getBytes(r0)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r4.write(r10)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r11.<init>(r2)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
            r10.<init>(r11)     // Catch:{ FileNotFoundException -> 0x009b, IOException -> 0x0099, Exception -> 0x0097 }
        L_0x0073:
            int r9 = r10.read(r1)     // Catch:{ FileNotFoundException -> 0x0092, IOException -> 0x008d, Exception -> 0x0088, all -> 0x0082 }
            if (r9 == r7) goto L_0x007d
            r4.write(r1, r6, r9)     // Catch:{ FileNotFoundException -> 0x0092, IOException -> 0x008d, Exception -> 0x0088, all -> 0x0082 }
            goto L_0x0073
        L_0x007d:
            closeBufferedInputStream(r10)
            goto L_0x00c4
        L_0x0082:
            r9 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00cf
        L_0x0088:
            r9 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00b0
        L_0x008d:
            r9 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00b7
        L_0x0092:
            r9 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00be
        L_0x0097:
            r10 = move-exception
            goto L_0x00b0
        L_0x0099:
            r10 = move-exception
            goto L_0x00b7
        L_0x009b:
            r10 = move-exception
            goto L_0x00be
        L_0x009d:
            r10 = move-exception
            r4 = r9
            goto L_0x00cf
        L_0x00a0:
            r10 = move-exception
            r4 = r9
            goto L_0x00b0
        L_0x00a3:
            r10 = move-exception
            r4 = r9
            goto L_0x00b7
        L_0x00a6:
            r10 = move-exception
            r4 = r9
            goto L_0x00be
        L_0x00a9:
            r10 = move-exception
            r3 = r9
            r4 = r3
            goto L_0x00cf
        L_0x00ad:
            r10 = move-exception
            r3 = r9
            r4 = r3
        L_0x00b0:
            r10.printStackTrace()     // Catch:{ all -> 0x00ce }
            goto L_0x00c1
        L_0x00b4:
            r10 = move-exception
            r3 = r9
            r4 = r3
        L_0x00b7:
            r10.printStackTrace()     // Catch:{ all -> 0x00ce }
            goto L_0x00c1
        L_0x00bb:
            r10 = move-exception
            r3 = r9
            r4 = r3
        L_0x00be:
            r10.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x00c1:
            closeBufferedInputStream(r9)
        L_0x00c4:
            closeBufferedOutputStream(r3)
            closeRandomAccessFile(r4)
            deleteFile((java.io.File) r2)
            return
        L_0x00ce:
            r10 = move-exception
        L_0x00cf:
            closeBufferedInputStream(r9)
            closeBufferedOutputStream(r3)
            closeRandomAccessFile(r4)
            deleteFile((java.io.File) r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: xcrash.TombstoneManager.insertToSpecial(java.lang.String, long, java.lang.String):void");
    }

    public static void deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    public static void closeBufferedOutputStream(BufferedOutputStream bufferedOutputStream) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeBufferedInputStream(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeRandomAccessFile(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
