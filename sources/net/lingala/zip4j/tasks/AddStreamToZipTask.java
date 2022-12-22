package net.lingala.zip4j.tasks;

import java.io.InputStream;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class AddStreamToZipTask extends AbstractAddFileToZipTask<AddStreamToZipTaskParameters> {
    /* access modifiers changed from: protected */
    public long calculateTotalWork(AddStreamToZipTaskParameters addStreamToZipTaskParameters) {
        return 0;
    }

    public AddStreamToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b8, code lost:
        if (r0 != null) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00be, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r6.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c2, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ca, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cb, code lost:
        r6.addSuppressed(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ce, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeTask(net.lingala.zip4j.tasks.AddStreamToZipTask.AddStreamToZipTaskParameters r6, net.lingala.zip4j.progress.ProgressMonitor r7) throws java.io.IOException {
        /*
            r5 = this;
            net.lingala.zip4j.model.ZipParameters r0 = r6.zipParameters
            r5.mo24467a(r0)
            net.lingala.zip4j.model.ZipParameters r0 = r6.zipParameters
            java.lang.String r0 = r0.getFileNameInZip()
            boolean r0 = net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(r0)
            if (r0 == 0) goto L_0x00cf
            net.lingala.zip4j.model.ZipModel r0 = r5.getZipModel()
            net.lingala.zip4j.model.Zip4jConfig r1 = r6.zip4jConfig
            net.lingala.zip4j.model.ZipParameters r2 = r6.zipParameters
            java.lang.String r2 = r2.getFileNameInZip()
            r5.m3218a(r0, r1, r2, r7)
            net.lingala.zip4j.model.ZipParameters r7 = r6.zipParameters
            r0 = 1
            r7.setWriteExtendedLocalFileHeader(r0)
            net.lingala.zip4j.model.ZipParameters r7 = r6.zipParameters
            net.lingala.zip4j.model.enums.CompressionMethod r7 = r7.getCompressionMethod()
            net.lingala.zip4j.model.enums.CompressionMethod r0 = net.lingala.zip4j.model.enums.CompressionMethod.STORE
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0047
            net.lingala.zip4j.model.ZipParameters r7 = r6.zipParameters
            r0 = 0
            r7.setEntrySize(r0)
        L_0x0047:
            net.lingala.zip4j.io.outputstream.SplitOutputStream r7 = new net.lingala.zip4j.io.outputstream.SplitOutputStream
            net.lingala.zip4j.model.ZipModel r0 = r5.getZipModel()
            java.io.File r0 = r0.getZipFile()
            net.lingala.zip4j.model.ZipModel r1 = r5.getZipModel()
            long r1 = r1.getSplitLength()
            r7.<init>(r0, r1)
            net.lingala.zip4j.model.Zip4jConfig r0 = r6.zip4jConfig     // Catch:{ all -> 0x00c3 }
            net.lingala.zip4j.io.outputstream.ZipOutputStream r0 = r5.mo24463a((net.lingala.zip4j.p067io.outputstream.SplitOutputStream) r7, (net.lingala.zip4j.model.Zip4jConfig) r0)     // Catch:{ all -> 0x00c3 }
            net.lingala.zip4j.model.Zip4jConfig r1 = r6.zip4jConfig     // Catch:{ all -> 0x00b5 }
            int r1 = r1.getBufferSize()     // Catch:{ all -> 0x00b5 }
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x00b5 }
            net.lingala.zip4j.model.ZipParameters r2 = r6.zipParameters     // Catch:{ all -> 0x00b5 }
            r0.putNextEntry(r2)     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = r2.getFileNameInZip()     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "/"
            boolean r3 = r3.endsWith(r4)     // Catch:{ all -> 0x00b5 }
            if (r3 != 0) goto L_0x0099
            java.lang.String r2 = r2.getFileNameInZip()     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "\\"
            boolean r2 = r2.endsWith(r3)     // Catch:{ all -> 0x00b5 }
            if (r2 != 0) goto L_0x0099
        L_0x0089:
            java.io.InputStream r2 = r6.inputStream     // Catch:{ all -> 0x00b5 }
            int r2 = r2.read(r1)     // Catch:{ all -> 0x00b5 }
            r3 = -1
            if (r2 == r3) goto L_0x0099
            r3 = 0
            r0.write(r1, r3, r2)     // Catch:{ all -> 0x00b5 }
            goto L_0x0089
        L_0x0099:
            net.lingala.zip4j.model.FileHeader r6 = r0.closeEntry()     // Catch:{ all -> 0x00b5 }
            net.lingala.zip4j.model.enums.CompressionMethod r1 = r6.getCompressionMethod()     // Catch:{ all -> 0x00b5 }
            net.lingala.zip4j.model.enums.CompressionMethod r2 = net.lingala.zip4j.model.enums.CompressionMethod.STORE     // Catch:{ all -> 0x00b5 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00ac
            r5.mo24465a((net.lingala.zip4j.model.FileHeader) r6, (net.lingala.zip4j.p067io.outputstream.SplitOutputStream) r7)     // Catch:{ all -> 0x00b5 }
        L_0x00ac:
            if (r0 == 0) goto L_0x00b1
            r0.close()     // Catch:{ all -> 0x00c3 }
        L_0x00b1:
            r7.close()
            return
        L_0x00b5:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r1 = move-exception
            if (r0 == 0) goto L_0x00c2
            r0.close()     // Catch:{ all -> 0x00be }
            goto L_0x00c2
        L_0x00be:
            r0 = move-exception
            r6.addSuppressed(r0)     // Catch:{ all -> 0x00c3 }
        L_0x00c2:
            throw r1     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            r7.close()     // Catch:{ all -> 0x00ca }
            goto L_0x00ce
        L_0x00ca:
            r7 = move-exception
            r6.addSuppressed(r7)
        L_0x00ce:
            throw r0
        L_0x00cf:
            net.lingala.zip4j.exception.ZipException r6 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r7 = "fileNameInZip has to be set in zipParameters when adding stream"
            r6.<init>((java.lang.String) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.AddStreamToZipTask.executeTask(net.lingala.zip4j.tasks.AddStreamToZipTask$AddStreamToZipTaskParameters, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    /* renamed from: a */
    private void m3218a(ZipModel zipModel, Zip4jConfig zip4jConfig, String str, ProgressMonitor progressMonitor) throws ZipException {
        FileHeader fileHeader = HeaderUtil.getFileHeader(zipModel, str);
        if (fileHeader != null) {
            mo24466a(fileHeader, progressMonitor, zip4jConfig);
        }
    }

    public static class AddStreamToZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */
        public InputStream inputStream;
        /* access modifiers changed from: private */
        public ZipParameters zipParameters;

        public AddStreamToZipTaskParameters(InputStream inputStream2, ZipParameters zipParameters2, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.inputStream = inputStream2;
            this.zipParameters = zipParameters2;
        }
    }
}
