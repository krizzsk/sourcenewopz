package com.didi.sdk.logging.util;

import java.io.File;
import java.util.List;

public class ZipUtil {

    public static class EntrySet {
        public File baseDir;
        public List<File> files;
        public String prefixPath;

        public EntrySet(String str, File file, List<File> list) {
            this.prefixPath = str;
            this.baseDir = file;
            this.files = list;
        }
    }

    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:48|49|(2:51|52)|53|54) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00ca */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c7 A[SYNTHETIC, Splitter:B:51:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToZip(java.util.List<com.didi.sdk.logging.util.ZipUtil.EntrySet> r12, java.io.File r13) {
        /*
            if (r12 == 0) goto L_0x00d5
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L_0x000a
            goto L_0x00d5
        L_0x000a:
            boolean r0 = r13.exists()
            if (r0 == 0) goto L_0x0013
            r13.delete()
        L_0x0013:
            r0 = 0
            r13.createNewFile()     // Catch:{ all -> 0x00d0 }
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x00d0 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00d0 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00d0 }
            r3.<init>(r13)     // Catch:{ all -> 0x00d0 }
            r2.<init>(r3)     // Catch:{ all -> 0x00d0 }
            r1.<init>(r2)     // Catch:{ all -> 0x00d0 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00cf }
        L_0x002a:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x00cf }
            if (r13 == 0) goto L_0x00cb
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x00cf }
            com.didi.sdk.logging.util.ZipUtil$EntrySet r13 = (com.didi.sdk.logging.util.ZipUtil.EntrySet) r13     // Catch:{ all -> 0x00cf }
            java.util.List<java.io.File> r2 = r13.files     // Catch:{ all -> 0x00cf }
            java.io.File r3 = r13.baseDir     // Catch:{ all -> 0x00cf }
            java.lang.String r13 = r13.prefixPath     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x002a
            int r4 = r2.size()     // Catch:{ all -> 0x00cf }
            if (r4 <= 0) goto L_0x002a
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x00cf }
            r5 = 0
            r6 = 0
        L_0x004a:
            int r7 = r2.size()     // Catch:{ all -> 0x00cf }
            if (r6 >= r7) goto L_0x002a
            java.lang.Object r7 = r2.get(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.io.File r7 = (java.io.File) r7     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r8 = "/"
            if (r3 != 0) goto L_0x005f
            java.lang.String r9 = r7.getName()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            goto L_0x007c
        L_0x005f:
            java.lang.String r9 = r7.getAbsolutePath()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r10.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r11 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r10.append(r11)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r10.append(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r11 = ""
            java.lang.String r9 = r9.replace(r10, r11)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
        L_0x007c:
            boolean r10 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            if (r10 == 0) goto L_0x0083
            goto L_0x0095
        L_0x0083:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r10.<init>()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r10.append(r13)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r10.append(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r10.append(r9)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
        L_0x0095:
            java.util.zip.ZipEntry r8 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.putNextEntry(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
        L_0x00a2:
            int r7 = r8.read(r4)     // Catch:{ Exception -> 0x00b4 }
            r9 = -1
            if (r7 == r9) goto L_0x00ad
            r1.write(r4, r5, r7)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00a2
        L_0x00ad:
            r1.closeEntry()     // Catch:{ Exception -> 0x00b4 }
        L_0x00b0:
            r8.close()     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00c0
        L_0x00b4:
            r7 = move-exception
            goto L_0x00ba
        L_0x00b6:
            r12 = move-exception
            goto L_0x00c5
        L_0x00b8:
            r7 = move-exception
            r8 = r0
        L_0x00ba:
            r7.printStackTrace()     // Catch:{ all -> 0x00c3 }
            if (r8 == 0) goto L_0x00c0
            goto L_0x00b0
        L_0x00c0:
            int r6 = r6 + 1
            goto L_0x004a
        L_0x00c3:
            r12 = move-exception
            r0 = r8
        L_0x00c5:
            if (r0 == 0) goto L_0x00ca
            r0.close()     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            throw r12     // Catch:{ all -> 0x00cf }
        L_0x00cb:
            r1.close()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00d5
        L_0x00cf:
            r0 = r1
        L_0x00d0:
            if (r0 == 0) goto L_0x00d5
            r0.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.util.ZipUtil.writeToZip(java.util.List, java.io.File):void");
    }

    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:31|32|(2:34|35)|36|37) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0079 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A[SYNTHETIC, Splitter:B:34:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToZip(java.io.File r8, java.util.List<java.io.File> r9, java.io.File r10) {
        /*
            boolean r0 = r10.exists()
            if (r0 == 0) goto L_0x0009
            r10.delete()
        L_0x0009:
            r0 = 0
            r10.createNewFile()     // Catch:{ all -> 0x0080 }
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0080 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0080 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0080 }
            r3.<init>(r10)     // Catch:{ all -> 0x0080 }
            r2.<init>(r3)     // Catch:{ all -> 0x0080 }
            r1.<init>(r2)     // Catch:{ all -> 0x0080 }
            if (r9 == 0) goto L_0x007c
            int r10 = r9.size()     // Catch:{ all -> 0x007a }
            if (r10 <= 0) goto L_0x007c
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ all -> 0x007a }
            r2 = 0
            r3 = 0
        L_0x002a:
            int r4 = r9.size()     // Catch:{ all -> 0x007a }
            if (r3 >= r4) goto L_0x007c
            java.lang.Object r4 = r9.get(r3)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.io.File r4 = (java.io.File) r4     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r6 = r8.getAbsolutePath()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.util.zip.ZipEntry r6 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r1.putNextEntry(r6)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
        L_0x0051:
            int r4 = r5.read(r10)     // Catch:{ Exception -> 0x0063 }
            r6 = -1
            if (r4 == r6) goto L_0x005c
            r1.write(r10, r2, r4)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0051
        L_0x005c:
            r1.closeEntry()     // Catch:{ Exception -> 0x0063 }
        L_0x005f:
            r5.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x006f
        L_0x0063:
            r4 = move-exception
            goto L_0x0069
        L_0x0065:
            r8 = move-exception
            goto L_0x0074
        L_0x0067:
            r4 = move-exception
            r5 = r0
        L_0x0069:
            r4.printStackTrace()     // Catch:{ all -> 0x0072 }
            if (r5 == 0) goto L_0x006f
            goto L_0x005f
        L_0x006f:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0072:
            r8 = move-exception
            r0 = r5
        L_0x0074:
            if (r0 == 0) goto L_0x0079
            r0.close()     // Catch:{ Exception -> 0x0079 }
        L_0x0079:
            throw r8     // Catch:{ all -> 0x007a }
        L_0x007a:
            r0 = r1
            goto L_0x0080
        L_0x007c:
            r1.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0085
        L_0x0080:
            if (r0 == 0) goto L_0x0085
            r0.close()     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.util.ZipUtil.writeToZip(java.io.File, java.util.List, java.io.File):void");
    }
}
