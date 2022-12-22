package org.apache.commons.p071io.input;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.lang3.CharUtils;

/* renamed from: org.apache.commons.io.input.Tailer */
public class Tailer implements Runnable {
    private final long delay;
    private final boolean end;
    private final File file;
    private final TailerListener listener;
    private volatile boolean run;

    public Tailer(File file2, TailerListener tailerListener) {
        this(file2, tailerListener, 1000);
    }

    public Tailer(File file2, TailerListener tailerListener, long j) {
        this(file2, tailerListener, j, false);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z) {
        this.run = true;
        this.file = file2;
        this.delay = j;
        this.end = z;
        this.listener = tailerListener;
        tailerListener.init(this);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z) {
        Tailer tailer = new Tailer(file2, tailerListener, j, z);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j) {
        return create(file2, tailerListener, j, false);
    }

    public static Tailer create(File file2, TailerListener tailerListener) {
        return create(file2, tailerListener, 1000, false);
    }

    public File getFile() {
        return this.file;
    }

    public long getDelay() {
        return this.delay;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r11.listener.fileNotFound();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A[SYNTHETIC, Splitter:B:12:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023 A[SYNTHETIC, Splitter:B:14:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r11 = this;
            r0 = 0
            r2 = 0
            r3 = r0
            r5 = r3
        L_0x0005:
            boolean r7 = r11.run     // Catch:{ Exception -> 0x008c }
            java.lang.String r8 = "r"
            if (r7 == 0) goto L_0x0038
            if (r2 != 0) goto L_0x0038
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0016 }
            java.io.File r9 = r11.file     // Catch:{ FileNotFoundException -> 0x0016 }
            r7.<init>(r9, r8)     // Catch:{ FileNotFoundException -> 0x0016 }
            r2 = r7
            goto L_0x001b
        L_0x0016:
            org.apache.commons.io.input.TailerListener r7 = r11.listener     // Catch:{ Exception -> 0x008c }
            r7.fileNotFound()     // Catch:{ Exception -> 0x008c }
        L_0x001b:
            if (r2 != 0) goto L_0x0023
            long r7 = r11.delay     // Catch:{ InterruptedException -> 0x0005 }
            java.lang.Thread.sleep(r7)     // Catch:{ InterruptedException -> 0x0005 }
            goto L_0x0005
        L_0x0023:
            boolean r3 = r11.end     // Catch:{ Exception -> 0x008c }
            if (r3 == 0) goto L_0x002f
            java.io.File r3 = r11.file     // Catch:{ Exception -> 0x008c }
            long r3 = r3.length()     // Catch:{ Exception -> 0x008c }
            r5 = r3
            goto L_0x0030
        L_0x002f:
            r5 = r0
        L_0x0030:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x008c }
            r2.seek(r5)     // Catch:{ Exception -> 0x008c }
            goto L_0x0005
        L_0x0038:
            boolean r7 = r11.run     // Catch:{ Exception -> 0x008c }
            if (r7 == 0) goto L_0x0092
            java.io.File r7 = r11.file     // Catch:{ Exception -> 0x008c }
            long r9 = r7.length()     // Catch:{ Exception -> 0x008c }
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0066
            org.apache.commons.io.input.TailerListener r7 = r11.listener     // Catch:{ Exception -> 0x008c }
            r7.fileRotated()     // Catch:{ Exception -> 0x008c }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0060 }
            java.io.File r9 = r11.file     // Catch:{ FileNotFoundException -> 0x0060 }
            r7.<init>(r9, r8)     // Catch:{ FileNotFoundException -> 0x0060 }
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x005b, all -> 0x0058 }
            r5 = r0
            r2 = r7
            goto L_0x0038
        L_0x0058:
            r0 = move-exception
            r2 = r7
            goto L_0x0096
        L_0x005b:
            r0 = move-exception
            r2 = r7
            goto L_0x008d
        L_0x005e:
            r5 = r0
            r2 = r7
        L_0x0060:
            org.apache.commons.io.input.TailerListener r7 = r11.listener     // Catch:{ Exception -> 0x008c }
            r7.fileNotFound()     // Catch:{ Exception -> 0x008c }
            goto L_0x0038
        L_0x0066:
            if (r7 <= 0) goto L_0x0071
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x008c }
            long r5 = r11.readLines(r2)     // Catch:{ Exception -> 0x008c }
            goto L_0x0084
        L_0x0071:
            java.io.File r7 = r11.file     // Catch:{ Exception -> 0x008c }
            boolean r7 = org.apache.commons.p071io.FileUtils.isFileNewer((java.io.File) r7, (long) r3)     // Catch:{ Exception -> 0x008c }
            if (r7 == 0) goto L_0x0084
            r2.seek(r0)     // Catch:{ Exception -> 0x008c }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x008c }
            long r5 = r11.readLines(r2)     // Catch:{ Exception -> 0x008c }
        L_0x0084:
            long r9 = r11.delay     // Catch:{ InterruptedException -> 0x0038 }
            java.lang.Thread.sleep(r9)     // Catch:{ InterruptedException -> 0x0038 }
            goto L_0x0038
        L_0x008a:
            r0 = move-exception
            goto L_0x0096
        L_0x008c:
            r0 = move-exception
        L_0x008d:
            org.apache.commons.io.input.TailerListener r1 = r11.listener     // Catch:{ all -> 0x008a }
            r1.handle((java.lang.Exception) r0)     // Catch:{ all -> 0x008a }
        L_0x0092:
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.Closeable) r2)
            return
        L_0x0096:
            org.apache.commons.p071io.IOUtils.closeQuietly((java.io.Closeable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p071io.input.Tailer.run():void");
    }

    public void stop() {
        this.run = false;
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        long filePointer = randomAccessFile.getFilePointer();
        String readLine = readLine(randomAccessFile);
        while (readLine != null) {
            filePointer = randomAccessFile.getFilePointer();
            this.listener.handle(readLine);
            readLine = readLine(randomAccessFile);
        }
        randomAccessFile.seek(filePointer);
        return filePointer;
    }

    private String readLine(RandomAccessFile randomAccessFile) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        while (true) {
            int read = randomAccessFile.read();
            if (read == -1) {
                return null;
            }
            if (read == 10) {
                return stringBuffer.toString();
            }
            if (read != 13) {
                if (z) {
                    stringBuffer.append(CharUtils.f5620CR);
                    z = false;
                }
                stringBuffer.append((char) read);
            } else {
                z = true;
            }
        }
    }
}
