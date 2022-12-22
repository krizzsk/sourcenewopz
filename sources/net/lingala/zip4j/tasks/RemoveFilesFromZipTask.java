package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.p067io.outputstream.SplitOutputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class RemoveFilesFromZipTask extends C2398a<RemoveFilesFromZipTaskParameters> {

    /* renamed from: a */
    private ZipModel f5042a;

    /* renamed from: b */
    private HeaderWriter f5043b;

    public RemoveFilesFromZipTask(ZipModel zipModel, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f5042a = zipModel;
        this.f5043b = headerWriter;
    }

    /* access modifiers changed from: protected */
    public void executeTask(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        Throwable th;
        List<FileHeader> list;
        RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters2 = removeFilesFromZipTaskParameters;
        if (!this.f5042a.isSplitArchive()) {
            List<String> b = m3237b(removeFilesFromZipTaskParameters.filesToRemove);
            if (!b.isEmpty()) {
                File a = mo24496a(this.f5042a.getZipFile().getPath());
                boolean z = false;
                try {
                    SplitOutputStream splitOutputStream = new SplitOutputStream(a);
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f5042a.getZipFile(), RandomAccessFileMode.READ.getValue());
                        try {
                            List<FileHeader> a2 = mo24497a(this.f5042a.getCentralDirectory().getFileHeaders());
                            long j = 0;
                            for (FileHeader next : a2) {
                                long a3 = mo24495a(a2, next, this.f5042a) - splitOutputStream.getFilePointer();
                                if (m3236a(next, b)) {
                                    m3235a(a2, next, a3);
                                    if (this.f5042a.getCentralDirectory().getFileHeaders().remove(next)) {
                                        j += a3;
                                        list = a2;
                                    } else {
                                        throw new ZipException("Could not remove entry from list of central directory headers");
                                    }
                                } else {
                                    list = a2;
                                    j += super.mo24494a(randomAccessFile, splitOutputStream, j, a3, progressMonitor, removeFilesFromZipTaskParameters2.zip4jConfig.getBufferSize());
                                }
                                verifyIfTaskIsCancelled();
                                a2 = list;
                            }
                            this.f5043b.finalizeZipFile(this.f5042a, splitOutputStream, removeFilesFromZipTaskParameters2.zip4jConfig.getCharset());
                            z = true;
                            randomAccessFile.close();
                            splitOutputStream.close();
                            mo24499a(true, this.f5042a.getZipFile(), a);
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            randomAccessFile.close();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    } finally {
                        th = th4;
                        try {
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            splitOutputStream.close();
                            throw th6;
                        }
                    }
                } catch (Throwable th7) {
                    mo24499a(z, this.f5042a.getZipFile(), a);
                    throw th7;
                }
            }
        } else {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters) {
        return this.f5042a.getZipFile().length();
    }

    /* renamed from: b */
    private List<String> m3237b(List<String> list) throws ZipException {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (HeaderUtil.getFileHeader(this.f5042a, next) != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m3236a(FileHeader fileHeader, List<String> list) {
        for (String startsWith : list) {
            if (fileHeader.getFileName().startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m3235a(List<FileHeader> list, FileHeader fileHeader, long j) throws ZipException {
        mo24498a(list, this.f5042a, fileHeader, m3234a(j));
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.f5042a.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setOffsetOfStartOfCentralDirectory(endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory() - j);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectory() - 1);
        if (endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() > 0) {
            endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() - 1);
        }
        if (this.f5042a.isZip64Format()) {
            this.f5042a.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(this.f5042a.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() - j);
            this.f5042a.getZip64EndOfCentralDirectoryRecord().setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(this.f5042a.getZip64EndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory() - 1);
            this.f5042a.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(this.f5042a.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord() - j);
        }
    }

    /* renamed from: a */
    private long m3234a(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("long overflow");
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.REMOVE_ENTRY;
    }

    public static class RemoveFilesFromZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */
        public List<String> filesToRemove;

        public RemoveFilesFromZipTaskParameters(List<String> list, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.filesToRemove = list;
        }
    }
}
