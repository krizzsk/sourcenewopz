package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.RawIO;

public class MergeSplitZipFileTask extends AsyncZipTask<MergeSplitZipFileTaskParameters> {

    /* renamed from: a */
    private ZipModel f5040a;

    /* renamed from: b */
    private RawIO f5041b = new RawIO();

    public MergeSplitZipFileTask(ZipModel zipModel, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f5040a = zipModel;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5 A[SYNTHETIC, Splitter:B:37:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00a8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeTask(net.lingala.zip4j.tasks.MergeSplitZipFileTask.MergeSplitZipFileTaskParameters r26, net.lingala.zip4j.progress.ProgressMonitor r27) throws java.io.IOException {
        /*
            r25 = this;
            r7 = r25
            r0 = r26
            net.lingala.zip4j.model.ZipModel r1 = r7.f5040a
            boolean r1 = r1.isSplitArchive()
            if (r1 == 0) goto L_0x0104
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ CloneNotSupportedException -> 0x00fd }
            java.io.File r1 = r26.outputZipFile     // Catch:{ CloneNotSupportedException -> 0x00fd }
            r6.<init>(r1)     // Catch:{ CloneNotSupportedException -> 0x00fd }
            net.lingala.zip4j.model.ZipModel r1 = r7.f5040a     // Catch:{ all -> 0x00ed }
            net.lingala.zip4j.model.EndOfCentralDirectoryRecord r1 = r1.getEndOfCentralDirectoryRecord()     // Catch:{ all -> 0x00ed }
            int r5 = r1.getNumberOfThisDisk()     // Catch:{ all -> 0x00ed }
            if (r5 <= 0) goto L_0x00e2
            r16 = 0
            r3 = 0
            r17 = r3
            r1 = 0
            r2 = 0
        L_0x0029:
            if (r2 > r5) goto L_0x00ca
            net.lingala.zip4j.model.ZipModel r8 = r7.f5040a     // Catch:{ all -> 0x00ed }
            java.io.RandomAccessFile r15 = r7.m3231b((net.lingala.zip4j.model.ZipModel) r8, (int) r2)     // Catch:{ all -> 0x00ed }
            long r8 = r15.length()     // Catch:{ all -> 0x00b6 }
            r10 = 4
            if (r2 != 0) goto L_0x0057
            net.lingala.zip4j.util.RawIO r11 = r7.f5041b     // Catch:{ all -> 0x0050 }
            int r11 = r11.readIntLittleEndian((java.io.RandomAccessFile) r15)     // Catch:{ all -> 0x0050 }
            long r11 = (long) r11     // Catch:{ all -> 0x0050 }
            net.lingala.zip4j.headers.HeaderSignature r13 = net.lingala.zip4j.headers.HeaderSignature.SPLIT_ZIP     // Catch:{ all -> 0x0050 }
            long r13 = r13.getValue()     // Catch:{ all -> 0x0050 }
            int r19 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r19 != 0) goto L_0x004c
            r19 = 4
            goto L_0x005a
        L_0x004c:
            r15.seek(r3)     // Catch:{ all -> 0x0050 }
            goto L_0x0057
        L_0x0050:
            r0 = move-exception
            r1 = r0
            r9 = r6
            r24 = r15
            goto L_0x00bb
        L_0x0057:
            r19 = r1
            r10 = 0
        L_0x005a:
            if (r2 != r5) goto L_0x0066
            net.lingala.zip4j.model.ZipModel r1 = r7.f5040a     // Catch:{ all -> 0x0050 }
            net.lingala.zip4j.model.EndOfCentralDirectoryRecord r1 = r1.getEndOfCentralDirectoryRecord()     // Catch:{ all -> 0x0050 }
            long r8 = r1.getOffsetOfStartOfCentralDirectory()     // Catch:{ all -> 0x0050 }
        L_0x0066:
            r20 = r8
            long r12 = (long) r10
            net.lingala.zip4j.model.Zip4jConfig r1 = r0.zip4jConfig     // Catch:{ all -> 0x00b6 }
            int r1 = r1.getBufferSize()     // Catch:{ all -> 0x00b6 }
            r8 = r15
            r9 = r6
            r10 = r12
            r22 = r12
            r12 = r20
            r14 = r27
            r24 = r15
            r15 = r1
            net.lingala.zip4j.util.FileUtils.copyFile(r8, r9, r10, r12, r14, r15)     // Catch:{ all -> 0x00b3 }
            long r20 = r20 - r22
            long r17 = r17 + r20
            net.lingala.zip4j.model.ZipModel r1 = r7.f5040a     // Catch:{ all -> 0x00b3 }
            net.lingala.zip4j.model.CentralDirectory r1 = r1.getCentralDirectory()     // Catch:{ all -> 0x00b3 }
            java.util.List r8 = r1.getFileHeaders()     // Catch:{ all -> 0x00b3 }
            if (r2 != 0) goto L_0x0090
            r9 = r3
            goto L_0x0092
        L_0x0090:
            r9 = r17
        L_0x0092:
            r1 = r25
            r11 = r2
            r2 = r8
            r12 = r3
            r3 = r9
            r8 = r5
            r5 = r11
            r9 = r6
            r6 = r19
            r1.m3227a((java.util.List<net.lingala.zip4j.model.FileHeader>) r2, (long) r3, (int) r5, (int) r6)     // Catch:{ all -> 0x00b1 }
            r25.verifyIfTaskIsCancelled()     // Catch:{ all -> 0x00b1 }
            if (r24 == 0) goto L_0x00a8
            r24.close()     // Catch:{ all -> 0x00eb }
        L_0x00a8:
            int r2 = r11 + 1
            r5 = r8
            r6 = r9
            r3 = r12
            r1 = r19
            goto L_0x0029
        L_0x00b1:
            r0 = move-exception
            goto L_0x00ba
        L_0x00b3:
            r0 = move-exception
            r9 = r6
            goto L_0x00ba
        L_0x00b6:
            r0 = move-exception
            r9 = r6
            r24 = r15
        L_0x00ba:
            r1 = r0
        L_0x00bb:
            throw r1     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r0 = move-exception
            r2 = r0
            if (r24 == 0) goto L_0x00c9
            r24.close()     // Catch:{ all -> 0x00c4 }
            goto L_0x00c9
        L_0x00c4:
            r0 = move-exception
            r3 = r0
            r1.addSuppressed(r3)     // Catch:{ all -> 0x00eb }
        L_0x00c9:
            throw r2     // Catch:{ all -> 0x00eb }
        L_0x00ca:
            r9 = r6
            net.lingala.zip4j.model.ZipModel r2 = r7.f5040a     // Catch:{ all -> 0x00eb }
            net.lingala.zip4j.model.Zip4jConfig r0 = r0.zip4jConfig     // Catch:{ all -> 0x00eb }
            java.nio.charset.Charset r6 = r0.getCharset()     // Catch:{ all -> 0x00eb }
            r1 = r25
            r3 = r17
            r5 = r9
            r1.m3230a((net.lingala.zip4j.model.ZipModel) r2, (long) r3, (java.io.OutputStream) r5, (java.nio.charset.Charset) r6)     // Catch:{ all -> 0x00eb }
            r27.endProgressMonitor()     // Catch:{ all -> 0x00eb }
            r9.close()     // Catch:{ CloneNotSupportedException -> 0x00fd }
            return
        L_0x00e2:
            r9 = r6
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "zip archive not a split zip file"
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x00eb }
            throw r0     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r0 = move-exception
            goto L_0x00ef
        L_0x00ed:
            r0 = move-exception
            r9 = r6
        L_0x00ef:
            r1 = r0
            throw r1     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            r0 = move-exception
            r2 = r0
            r9.close()     // Catch:{ all -> 0x00f7 }
            goto L_0x00fc
        L_0x00f7:
            r0 = move-exception
            r3 = r0
            r1.addSuppressed(r3)     // Catch:{ CloneNotSupportedException -> 0x00fd }
        L_0x00fc:
            throw r2     // Catch:{ CloneNotSupportedException -> 0x00fd }
        L_0x00fd:
            r0 = move-exception
            net.lingala.zip4j.exception.ZipException r1 = new net.lingala.zip4j.exception.ZipException
            r1.<init>((java.lang.Exception) r0)
            throw r1
        L_0x0104:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "archive not a split zip file"
            r0.<init>((java.lang.String) r1)
            r1 = r27
            r1.endProgressMonitor(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.MergeSplitZipFileTask.executeTask(net.lingala.zip4j.tasks.MergeSplitZipFileTask$MergeSplitZipFileTaskParameters, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters) {
        long j = 0;
        if (!this.f5040a.isSplitArchive()) {
            return 0;
        }
        for (int i = 0; i <= this.f5040a.getEndOfCentralDirectoryRecord().getNumberOfThisDisk(); i++) {
            j += m3226a(this.f5040a, i).length();
        }
        return j;
    }

    /* renamed from: a */
    private void m3227a(List<FileHeader> list, long j, int i, int i2) {
        for (FileHeader next : list) {
            if (next.getDiskNumberStart() == i) {
                next.setOffsetLocalHeader((next.getOffsetLocalHeader() + j) - ((long) i2));
                next.setDiskNumberStart(0);
            }
        }
    }

    /* renamed from: a */
    private File m3226a(ZipModel zipModel, int i) {
        if (i == zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) {
            return zipModel.getZipFile();
        }
        String str = i >= 9 ? ".z" : ".z0";
        String path = zipModel.getZipFile().getPath();
        return new File(zipModel.getZipFile().getPath().substring(0, path.lastIndexOf(".")) + str + (i + 1));
    }

    /* renamed from: b */
    private RandomAccessFile m3231b(ZipModel zipModel, int i) throws FileNotFoundException {
        return new RandomAccessFile(m3226a(zipModel, i), RandomAccessFileMode.READ.getValue());
    }

    /* renamed from: a */
    private void m3230a(ZipModel zipModel, long j, OutputStream outputStream, Charset charset) throws IOException, CloneNotSupportedException {
        ZipModel zipModel2 = (ZipModel) zipModel.clone();
        zipModel2.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(j);
        m3229a(zipModel2, j);
        new HeaderWriter().finalizeZipFileWithoutValidations(zipModel2, outputStream, charset);
    }

    /* renamed from: a */
    private void m3229a(ZipModel zipModel, long j) {
        zipModel.setSplitArchive(false);
        m3228a(zipModel);
        if (zipModel.isZip64Format()) {
            m3232b(zipModel, j);
            m3233c(zipModel, j);
        }
    }

    /* renamed from: a */
    private void m3228a(ZipModel zipModel) {
        int size = zipModel.getCentralDirectory().getFileHeaders().size();
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(0);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(size);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(size);
    }

    /* renamed from: b */
    private void m3232b(ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryLocator() != null) {
            Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = zipModel.getZip64EndOfCentralDirectoryLocator();
            zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
            zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryLocator.getOffsetZip64EndOfCentralDirectoryRecord() + j);
            zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(1);
        }
    }

    /* renamed from: c */
    private void m3233c(ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryRecord() != null) {
            Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = zipModel.getZip64EndOfCentralDirectoryRecord();
            zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(0);
            zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(0);
            zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk((long) zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory());
            zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(zip64EndOfCentralDirectoryRecord.getOffsetStartCentralDirectoryWRTStartDiskNumber() + j);
        }
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.MERGE_ZIP_FILES;
    }

    public static class MergeSplitZipFileTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */
        public File outputZipFile;

        public MergeSplitZipFileTaskParameters(File file, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputZipFile = file;
        }
    }
}
