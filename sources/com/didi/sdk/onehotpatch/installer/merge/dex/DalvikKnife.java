package com.didi.sdk.onehotpatch.installer.merge.dex;

import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DalvikKnife {
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean compare(java.io.File r10, java.io.File r11, java.io.File r12) throws java.lang.Exception {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            if (r11 == 0) goto L_0x0139
            boolean r3 = r11.exists()
            if (r3 == 0) goto L_0x0139
            boolean r3 = r11.isFile()
            if (r3 == 0) goto L_0x0139
            boolean r3 = r11.canRead()
            if (r3 != 0) goto L_0x001b
            goto L_0x0139
        L_0x001b:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r11 = com.didi.sdk.onehotpatch.commonstatic.util.FileUtils.readFileToString(r11)
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>(r11)
            java.util.Iterator r11 = r4.keys()
        L_0x002d:
            boolean r5 = r11.hasNext()
            if (r5 == 0) goto L_0x005d
            java.lang.Object r5 = r11.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Integer.valueOf(r5)
            org.json.JSONArray r6 = r4.getJSONArray(r5)
            int r7 = r6.length()
            int[] r7 = new int[r7]
            r8 = 0
        L_0x0047:
            int r9 = r6.length()
            if (r8 >= r9) goto L_0x0056
            int r9 = r6.getInt(r8)
            r7[r8] = r9
            int r8 = r8 + 1
            goto L_0x0047
        L_0x0056:
            java.util.Arrays.sort(r7)
            r3.put(r5, r7)
            goto L_0x002d
        L_0x005d:
            boolean r11 = r3.isEmpty()
            if (r11 == 0) goto L_0x006b
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.String r11 = "patchMap is empty."
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r11, r10)
            return r2
        L_0x006b:
            java.lang.Runtime r11 = java.lang.Runtime.getRuntime()
            int r11 = r11.availableProcessors()
            r4 = 4
            int r4 = java.lang.Math.max(r4, r11)
            int r5 = r3.size()
            int r4 = java.lang.Math.min(r4, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "cpu cores="
            r5.append(r6)
            r5.append(r11)
            java.lang.String r11 = ", poolSize="
            r5.append(r11)
            r5.append(r4)
            java.lang.String r11 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r11, r5)
            java.util.concurrent.ExecutorService r11 = java.util.concurrent.Executors.newFixedThreadPool(r4)
            r4 = 0
            java.util.zip.ZipFile r5 = new java.util.zip.ZipFile     // Catch:{ all -> 0x0132 }
            r5.<init>(r10)     // Catch:{ all -> 0x0132 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x012f }
            r10.<init>()     // Catch:{ all -> 0x012f }
            int r4 = getDexCount(r5)     // Catch:{ all -> 0x012f }
            r6 = 1
            r7 = 1
        L_0x00b3:
            if (r7 > r4) goto L_0x00de
            java.lang.String r8 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x012f }
            boolean r9 = r3.containsKey(r8)     // Catch:{ all -> 0x012f }
            if (r9 == 0) goto L_0x00cf
            java.lang.Object r8 = r3.get(r8)     // Catch:{ all -> 0x012f }
            int[] r8 = (int[]) r8     // Catch:{ all -> 0x012f }
            com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife$CopyAndStripTask r9 = new com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife$CopyAndStripTask     // Catch:{ all -> 0x012f }
            r9.<init>(r5, r7, r8, r12)     // Catch:{ all -> 0x012f }
            java.util.concurrent.Future r8 = r11.submit(r9)     // Catch:{ all -> 0x012f }
            goto L_0x00d8
        L_0x00cf:
            com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife$CopyTask r8 = new com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife$CopyTask     // Catch:{ all -> 0x012f }
            r8.<init>(r5, r7, r12)     // Catch:{ all -> 0x012f }
            java.util.concurrent.Future r8 = r11.submit(r8)     // Catch:{ all -> 0x012f }
        L_0x00d8:
            r10.add(r8)     // Catch:{ all -> 0x012f }
            int r7 = r7 + 1
            goto L_0x00b3
        L_0x00de:
            r11.shutdown()     // Catch:{ all -> 0x012f }
        L_0x00e1:
            r3 = 30
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x00e1 }
            boolean r12 = r11.awaitTermination(r3, r12)     // Catch:{ InterruptedException -> 0x00e1 }
            if (r12 == 0) goto L_0x00e1
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x012f }
        L_0x00ef:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x012f }
            if (r11 == 0) goto L_0x010b
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x012f }
            java.util.concurrent.Future r11 = (java.util.concurrent.Future) r11     // Catch:{ all -> 0x012f }
            java.lang.Object r11 = r11.get()     // Catch:{ all -> 0x012f }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x012f }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x012f }
            if (r11 != 0) goto L_0x00ef
            r5.close()
            return r2
        L_0x010b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r10.<init>()     // Catch:{ all -> 0x012f }
            java.lang.String r11 = "Total cost time: "
            r10.append(r11)     // Catch:{ all -> 0x012f }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012f }
            long r11 = r11 - r0
            r10.append(r11)     // Catch:{ all -> 0x012f }
            java.lang.String r11 = " ms"
            r10.append(r11)     // Catch:{ all -> 0x012f }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x012f }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ all -> 0x012f }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r10, r11)     // Catch:{ all -> 0x012f }
            r5.close()
            return r6
        L_0x012f:
            r10 = move-exception
            r4 = r5
            goto L_0x0133
        L_0x0132:
            r10 = move-exception
        L_0x0133:
            if (r4 == 0) goto L_0x0138
            r4.close()
        L_0x0138:
            throw r10
        L_0x0139:
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.String r11 = "Invalid map file."
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r11, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife.compare(java.io.File, java.io.File, java.io.File):boolean");
    }

    private static int getDexCount(ZipFile zipFile) {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (!zipEntry.isDirectory() && !name.contains("../") && name.contains("classes") && name.contains(".dex")) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static String getDexNameByIndex(int i) {
        if (i < 2) {
            return "classes.dex";
        }
        return String.format(Locale.ENGLISH, "classes%d.dex", new Object[]{Integer.valueOf(i)});
    }

    static class CopyTask implements Callable<Boolean> {
        static final String TAG_PREFIX = "CopyTask-";
        int index;
        File patchedDexDir;
        ZipFile zipFile;

        CopyTask(ZipFile zipFile2, int i, File file) {
            this.zipFile = zipFile2;
            this.index = i;
            this.patchedDexDir = file;
        }

        public Boolean call() throws Exception {
            String access$000 = DalvikKnife.getDexNameByIndex(this.index);
            long currentTimeMillis = System.currentTimeMillis();
            Logger.log(TAG_PREFIX + access$000 + ": begin", new Object[0]);
            ZipEntry entry = this.zipFile.getEntry(access$000);
            if (entry != null) {
                InputStream inputStream = null;
                try {
                    inputStream = this.zipFile.getInputStream(entry);
                    File file = new File(this.patchedDexDir, access$000);
                    Logger.log(TAG_PREFIX + access$000 + ": loaded zip entry, cost time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms", new Object[0]);
                    FileUtils.copyInputStreamToFile(inputStream, file);
                    Logger.log(TAG_PREFIX + access$000 + ": end saved to file, cost time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms", new Object[0]);
                    return true;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } else {
                throw new IllegalStateException("Unable to get " + access$000 + " in base.apk");
            }
        }
    }

    static class CopyAndStripTask implements Callable<Boolean> {
        static final String TAG_PREFIX = "CopyAndStripTask-";
        int[] classIndexes;
        String dexName;
        File patchedDexDir;
        ZipFile zipFile;

        CopyAndStripTask(ZipFile zipFile2, int i, int[] iArr, File file) {
            this.zipFile = zipFile2;
            this.dexName = DalvikKnife.getDexNameByIndex(i);
            this.classIndexes = iArr;
            this.patchedDexDir = file;
        }

        /* JADX WARNING: type inference failed for: r8v1 */
        /* JADX WARNING: type inference failed for: r8v2, types: [java.io.InputStream] */
        /* JADX WARNING: type inference failed for: r8v3 */
        /* JADX WARNING: type inference failed for: r8v4, types: [java.io.RandomAccessFile] */
        /* JADX WARNING: type inference failed for: r8v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0233  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x023d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean call() throws java.lang.Exception {
            /*
                r19 = this;
                r1 = r19
                java.lang.String r0 = " ms"
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "CopyAndStripTask-"
                r4.append(r5)
                java.lang.String r6 = r1.dexName
                r4.append(r6)
                java.lang.String r6 = ": begin"
                r4.append(r6)
                java.lang.String r4 = r4.toString()
                r6 = 0
                java.lang.Object[] r7 = new java.lang.Object[r6]
                com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r4, r7)
                java.util.zip.ZipFile r4 = r1.zipFile
                java.lang.String r7 = r1.dexName
                java.util.zip.ZipEntry r4 = r4.getEntry(r7)
                if (r4 == 0) goto L_0x0241
                java.io.File r7 = new java.io.File
                java.io.File r8 = r1.patchedDexDir
                java.lang.String r9 = r1.dexName
                r7.<init>(r8, r9)
                r8 = 0
                java.util.zip.ZipFile r9 = r1.zipFile     // Catch:{ all -> 0x023a }
                java.io.InputStream r4 = r9.getInputStream(r4)     // Catch:{ all -> 0x023a }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0237 }
                r9.<init>()     // Catch:{ all -> 0x0237 }
                r9.append(r5)     // Catch:{ all -> 0x0237 }
                java.lang.String r10 = r1.dexName     // Catch:{ all -> 0x0237 }
                r9.append(r10)     // Catch:{ all -> 0x0237 }
                java.lang.String r10 = ": loaded zip entry, cost time: "
                r9.append(r10)     // Catch:{ all -> 0x0237 }
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0237 }
                long r10 = r10 - r2
                r9.append(r10)     // Catch:{ all -> 0x0237 }
                r9.append(r0)     // Catch:{ all -> 0x0237 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0237 }
                java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x0237 }
                com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r9, r10)     // Catch:{ all -> 0x0237 }
                com.didi.sdk.onehotpatch.commonstatic.util.FileUtils.copyInputStreamToFile(r4, r7)     // Catch:{ all -> 0x0237 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0237 }
                r9.<init>()     // Catch:{ all -> 0x0237 }
                r9.append(r5)     // Catch:{ all -> 0x0237 }
                java.lang.String r10 = r1.dexName     // Catch:{ all -> 0x0237 }
                r9.append(r10)     // Catch:{ all -> 0x0237 }
                java.lang.String r10 = ": saved to file, cost time: "
                r9.append(r10)     // Catch:{ all -> 0x0237 }
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0237 }
                long r10 = r10 - r2
                r9.append(r10)     // Catch:{ all -> 0x0237 }
                r9.append(r0)     // Catch:{ all -> 0x0237 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0237 }
                java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x0237 }
                com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r9, r10)     // Catch:{ all -> 0x0237 }
                if (r4 == 0) goto L_0x0094
                r4.close()
            L_0x0094:
                com.didi.sdk.onehotpatch.installer.merge.dex.Dex r4 = new com.didi.sdk.onehotpatch.installer.merge.dex.Dex     // Catch:{ all -> 0x0230 }
                r4.<init>(r7)     // Catch:{ all -> 0x0230 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0230 }
                r9.<init>()     // Catch:{ all -> 0x0230 }
                r9.append(r5)     // Catch:{ all -> 0x0230 }
                java.lang.String r10 = r1.dexName     // Catch:{ all -> 0x0230 }
                r9.append(r10)     // Catch:{ all -> 0x0230 }
                java.lang.String r10 = ": read dex info, cost time: "
                r9.append(r10)     // Catch:{ all -> 0x0230 }
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0230 }
                long r10 = r10 - r2
                r9.append(r10)     // Catch:{ all -> 0x0230 }
                r9.append(r0)     // Catch:{ all -> 0x0230 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0230 }
                java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r9, r10)     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents r9 = r4.getTableOfContents()     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents$Section r9 = r9.classDefs     // Catch:{ all -> 0x0230 }
                int r9 = r9.off     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents r10 = r4.getTableOfContents()     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents$Section r10 = r10.classDefs     // Catch:{ all -> 0x0230 }
                int r10 = r10.size     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents r11 = r4.getTableOfContents()     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents$Section r11 = r11.classDefs     // Catch:{ all -> 0x0230 }
                short r11 = r11.type     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents r4 = r4.getTableOfContents()     // Catch:{ all -> 0x0230 }
                com.didi.sdk.onehotpatch.installer.merge.dex.TableOfContents$Section r4 = r4.mapList     // Catch:{ all -> 0x0230 }
                int r4 = r4.off     // Catch:{ all -> 0x0230 }
                java.io.RandomAccessFile r12 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0230 }
                java.lang.String r13 = "rw"
                r12.<init>(r7, r13)     // Catch:{ all -> 0x0230 }
                r7 = 4096(0x1000, float:5.74E-42)
                byte[] r8 = new byte[r7]     // Catch:{ all -> 0x022d }
                int r13 = r10 * 32
                int r13 = r13 + r9
                r6 = r9
                r15 = r6
                r14 = 0
            L_0x00f1:
                int[] r7 = r1.classIndexes     // Catch:{ all -> 0x022d }
                int r7 = r7.length     // Catch:{ all -> 0x022d }
                if (r14 > r7) goto L_0x0164
                int[] r7 = r1.classIndexes     // Catch:{ all -> 0x022d }
                int r7 = r7.length     // Catch:{ all -> 0x022d }
                if (r14 >= r7) goto L_0x0100
                int[] r7 = r1.classIndexes     // Catch:{ all -> 0x022d }
                r7 = r7[r14]     // Catch:{ all -> 0x022d }
                goto L_0x0101
            L_0x0100:
                r7 = r10
            L_0x0101:
                int r7 = r7 * 32
                int r7 = r7 + r9
                int r7 = r7 - r6
                if (r7 <= 0) goto L_0x0157
                if (r6 < r15) goto L_0x014f
                if (r6 != r15) goto L_0x0118
                r16 = r2
                long r2 = (long) r6     // Catch:{ all -> 0x022d }
                r12.seek(r2)     // Catch:{ all -> 0x022d }
                int r2 = r7 + 32
                int r6 = r6 + r2
                int r15 = r15 + r7
                r18 = r4
                goto L_0x015d
            L_0x0118:
                r16 = r2
                r2 = 4096(0x1000, float:5.74E-42)
                if (r7 <= r2) goto L_0x0121
                r2 = 4096(0x1000, float:5.74E-42)
                goto L_0x0122
            L_0x0121:
                r2 = r7
            L_0x0122:
                if (r7 <= 0) goto L_0x0159
                r18 = r4
                long r3 = (long) r6     // Catch:{ all -> 0x022d }
                r12.seek(r3)     // Catch:{ all -> 0x022d }
                r3 = 0
                int r2 = r12.read(r8, r3, r2)     // Catch:{ all -> 0x022d }
                if (r2 <= 0) goto L_0x0147
                long r3 = (long) r15     // Catch:{ all -> 0x022d }
                r12.seek(r3)     // Catch:{ all -> 0x022d }
                r3 = 0
                r12.write(r8, r3, r2)     // Catch:{ all -> 0x022d }
                int r6 = r6 + r2
                int r15 = r15 + r2
                int r7 = r7 - r2
                r2 = 4096(0x1000, float:5.74E-42)
                if (r7 <= r2) goto L_0x0143
                r2 = 4096(0x1000, float:5.74E-42)
                goto L_0x0144
            L_0x0143:
                r2 = r7
            L_0x0144:
                r4 = r18
                goto L_0x0122
            L_0x0147:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x022d }
                java.lang.String r2 = "bad read"
                r0.<init>(r2)     // Catch:{ all -> 0x022d }
                throw r0     // Catch:{ all -> 0x022d }
            L_0x014f:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x022d }
                java.lang.String r2 = "bad position"
                r0.<init>(r2)     // Catch:{ all -> 0x022d }
                throw r0     // Catch:{ all -> 0x022d }
            L_0x0157:
                r16 = r2
            L_0x0159:
                r18 = r4
                int r6 = r6 + 32
            L_0x015d:
                int r14 = r14 + 1
                r2 = r16
                r4 = r18
                goto L_0x00f1
            L_0x0164:
                r16 = r2
                r18 = r4
                int r2 = r13 - r15
                r3 = 4096(0x1000, float:5.74E-42)
                if (r2 >= r3) goto L_0x0170
                r4 = r2
                goto L_0x0172
            L_0x0170:
                r4 = 4096(0x1000, float:5.74E-42)
            L_0x0172:
                r6 = 0
                java.util.Arrays.fill(r8, r6, r4, r6)     // Catch:{ all -> 0x022d }
            L_0x0176:
                if (r2 <= r3) goto L_0x017e
                r12.write(r8)     // Catch:{ all -> 0x022d }
                int r2 = r2 + -4096
                goto L_0x0176
            L_0x017e:
                r3 = 0
                r12.write(r8, r3, r2)     // Catch:{ all -> 0x022d }
                int[] r2 = r1.classIndexes     // Catch:{ all -> 0x022d }
                int r2 = r2.length     // Catch:{ all -> 0x022d }
                int r10 = r10 - r2
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r8)     // Catch:{ all -> 0x022d }
                java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x022d }
                r2.order(r3)     // Catch:{ all -> 0x022d }
                r3 = 0
                r2.position(r3)     // Catch:{ all -> 0x022d }
                r2.putInt(r10)     // Catch:{ all -> 0x022d }
                r6 = 96
                r12.seek(r6)     // Catch:{ all -> 0x022d }
                int r4 = r2.position()     // Catch:{ all -> 0x022d }
                r12.write(r8, r3, r4)     // Catch:{ all -> 0x022d }
                r4 = r18
                long r6 = (long) r4     // Catch:{ all -> 0x022d }
                r12.seek(r6)     // Catch:{ all -> 0x022d }
                r4 = 4
                r12.readFully(r8, r3, r4)     // Catch:{ all -> 0x022d }
                r2.position(r3)     // Catch:{ all -> 0x022d }
                int r6 = r2.getInt()     // Catch:{ all -> 0x022d }
                r7 = 0
            L_0x01b4:
                if (r7 >= r6) goto L_0x01d9
                r12.readFully(r8, r3, r4)     // Catch:{ all -> 0x022d }
                r2.position(r3)     // Catch:{ all -> 0x022d }
                short r9 = r2.getShort()     // Catch:{ all -> 0x022d }
                r2.getShort()     // Catch:{ all -> 0x022d }
                if (r9 != r11) goto L_0x01cf
                r2.position(r3)     // Catch:{ all -> 0x022d }
                r2.putInt(r10)     // Catch:{ all -> 0x022d }
                r12.write(r8, r3, r4)     // Catch:{ all -> 0x022d }
                goto L_0x01d9
            L_0x01cf:
                r12.skipBytes(r4)     // Catch:{ all -> 0x022d }
                r12.skipBytes(r4)     // Catch:{ all -> 0x022d }
                int r7 = r7 + 1
                r3 = 0
                goto L_0x01b4
            L_0x01d9:
                byte[] r3 = com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife.computeSignature(r12, r8)     // Catch:{ all -> 0x022d }
                r6 = 12
                r12.seek(r6)     // Catch:{ all -> 0x022d }
                r12.write(r3)     // Catch:{ all -> 0x022d }
                int r3 = com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife.computeChecksum(r12, r8)     // Catch:{ all -> 0x022d }
                r4 = 0
                r2.position(r4)     // Catch:{ all -> 0x022d }
                r2.putInt(r3)     // Catch:{ all -> 0x022d }
                r6 = 8
                r12.seek(r6)     // Catch:{ all -> 0x022d }
                int r2 = r2.position()     // Catch:{ all -> 0x022d }
                r12.write(r8, r4, r2)     // Catch:{ all -> 0x022d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x022d }
                r2.<init>()     // Catch:{ all -> 0x022d }
                r2.append(r5)     // Catch:{ all -> 0x022d }
                java.lang.String r3 = r1.dexName     // Catch:{ all -> 0x022d }
                r2.append(r3)     // Catch:{ all -> 0x022d }
                java.lang.String r3 = ": end stripped dex, cost time: "
                r2.append(r3)     // Catch:{ all -> 0x022d }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x022d }
                long r3 = r3 - r16
                r2.append(r3)     // Catch:{ all -> 0x022d }
                r2.append(r0)     // Catch:{ all -> 0x022d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x022d }
                r2 = 0
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x022d }
                com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r0, r2)     // Catch:{ all -> 0x022d }
                r0 = 1
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x022d }
                r12.close()
                return r0
            L_0x022d:
                r0 = move-exception
                r8 = r12
                goto L_0x0231
            L_0x0230:
                r0 = move-exception
            L_0x0231:
                if (r8 == 0) goto L_0x0236
                r8.close()
            L_0x0236:
                throw r0
            L_0x0237:
                r0 = move-exception
                r8 = r4
                goto L_0x023b
            L_0x023a:
                r0 = move-exception
            L_0x023b:
                if (r8 == 0) goto L_0x0240
                r8.close()
            L_0x0240:
                throw r0
            L_0x0241:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unable to get "
                r2.append(r3)
                java.lang.String r3 = r1.dexName
                r2.append(r3)
                java.lang.String r3 = " in base.apk"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.installer.merge.dex.DalvikKnife.CopyAndStripTask.call():java.lang.Boolean");
        }
    }

    /* access modifiers changed from: private */
    public static byte[] computeSignature(RandomAccessFile randomAccessFile, byte[] bArr) throws IOException {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            randomAccessFile.seek(32);
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read <= 0) {
                    return instance.digest();
                }
                instance.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public static int computeChecksum(RandomAccessFile randomAccessFile, byte[] bArr) throws IOException {
        Adler32 adler32 = new Adler32();
        randomAccessFile.seek(12);
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read <= 0) {
                return (int) adler32.getValue();
            }
            adler32.update(bArr, 0, read);
        }
    }
}
