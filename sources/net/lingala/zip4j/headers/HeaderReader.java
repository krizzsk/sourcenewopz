package net.lingala.zip4j.headers;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.DigitalSignature;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.p067io.inputstream.NumberedSplitRandomAccessFile;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderReader {

    /* renamed from: a */
    private ZipModel f4825a;

    /* renamed from: b */
    private RawIO f4826b = new RawIO();

    /* renamed from: c */
    private byte[] f4827c = new byte[4];

    public ZipModel readAllHeaders(RandomAccessFile randomAccessFile, Zip4jConfig zip4jConfig) throws IOException {
        if (randomAccessFile.length() >= 22) {
            ZipModel zipModel = new ZipModel();
            this.f4825a = zipModel;
            try {
                zipModel.setEndOfCentralDirectoryRecord(m3087a(randomAccessFile, this.f4826b, zip4jConfig));
                if (this.f4825a.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory() == 0) {
                    return this.f4825a;
                }
                ZipModel zipModel2 = this.f4825a;
                zipModel2.setZip64EndOfCentralDirectoryLocator(m3088a(randomAccessFile, this.f4826b, zipModel2.getEndOfCentralDirectoryRecord().getOffsetOfEndOfCentralDirectory()));
                if (this.f4825a.isZip64Format()) {
                    this.f4825a.setZip64EndOfCentralDirectoryRecord(m3089a(randomAccessFile, this.f4826b));
                    if (this.f4825a.getZip64EndOfCentralDirectoryRecord() == null || this.f4825a.getZip64EndOfCentralDirectoryRecord().getNumberOfThisDisk() <= 0) {
                        this.f4825a.setSplitArchive(false);
                    } else {
                        this.f4825a.setSplitArchive(true);
                    }
                }
                this.f4825a.setCentralDirectory(m3086a(randomAccessFile, this.f4826b, zip4jConfig.getCharset()));
                return this.f4825a;
            } catch (ZipException e) {
                throw e;
            } catch (IOException e2) {
                throw new ZipException("Zip headers not found. Probably not a zip file or a corrupted zip file", (Exception) e2);
            }
        } else {
            throw new ZipException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
    }

    /* renamed from: a */
    private EndOfCentralDirectoryRecord m3087a(RandomAccessFile randomAccessFile, RawIO rawIO, Zip4jConfig zip4jConfig) throws IOException {
        long length = randomAccessFile.length() - 22;
        m3097b(randomAccessFile, length);
        if (((long) rawIO.readIntLittleEndian(randomAccessFile)) != HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue()) {
            length = m3096b(randomAccessFile, zip4jConfig.getBufferSize());
            randomAccessFile.seek(4 + length);
        }
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = new EndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setSignature(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
        endOfCentralDirectoryRecord.setNumberOfThisDisk(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setSizeOfCentralDirectory(rawIO.readIntLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setOffsetOfEndOfCentralDirectory(length);
        randomAccessFile.readFully(this.f4827c);
        boolean z = false;
        endOfCentralDirectoryRecord.setOffsetOfStartOfCentralDirectory(rawIO.readLongLittleEndian(this.f4827c, 0));
        endOfCentralDirectoryRecord.setComment(m3081a(randomAccessFile, rawIO.readShortLittleEndian(randomAccessFile), zip4jConfig.getCharset()));
        ZipModel zipModel = this.f4825a;
        if (endOfCentralDirectoryRecord.getNumberOfThisDisk() > 0) {
            z = true;
        }
        zipModel.setSplitArchive(z);
        return endOfCentralDirectoryRecord;
    }

    /* renamed from: a */
    private CentralDirectory m3086a(RandomAccessFile randomAccessFile, RawIO rawIO, Charset charset) throws IOException {
        RandomAccessFile randomAccessFile2 = randomAccessFile;
        RawIO rawIO2 = rawIO;
        Charset charset2 = charset;
        CentralDirectory centralDirectory = new CentralDirectory();
        ArrayList arrayList = new ArrayList();
        long offsetStartOfCentralDirectory = HeaderUtil.getOffsetStartOfCentralDirectory(this.f4825a);
        long a = m3080a(this.f4825a);
        randomAccessFile2.seek(offsetStartOfCentralDirectory);
        int i = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i2 = 0;
        int i3 = 0;
        while (((long) i3) < a) {
            FileHeader fileHeader = new FileHeader();
            byte[] bArr3 = bArr2;
            if (((long) rawIO2.readIntLittleEndian(randomAccessFile2)) == HeaderSignature.CENTRAL_DIRECTORY.getValue()) {
                fileHeader.setSignature(HeaderSignature.CENTRAL_DIRECTORY);
                fileHeader.setVersionMadeBy(rawIO2.readShortLittleEndian(randomAccessFile2));
                fileHeader.setVersionNeededToExtract(rawIO2.readShortLittleEndian(randomAccessFile2));
                byte[] bArr4 = new byte[i];
                randomAccessFile2.readFully(bArr4);
                fileHeader.setEncrypted(BitUtils.isBitSet(bArr4[i2], i2));
                fileHeader.setDataDescriptorExists(BitUtils.isBitSet(bArr4[i2], 3));
                fileHeader.setFileNameUTF8Encoded(BitUtils.isBitSet(bArr4[1], 3));
                fileHeader.setGeneralPurposeFlag((byte[]) bArr4.clone());
                fileHeader.setCompressionMethod(CompressionMethod.getCompressionMethodFromCode(rawIO2.readShortLittleEndian(randomAccessFile2)));
                fileHeader.setLastModifiedTime((long) rawIO2.readIntLittleEndian(randomAccessFile2));
                byte[] bArr5 = bArr3;
                randomAccessFile2.readFully(bArr5);
                fileHeader.setCrc(rawIO2.readLongLittleEndian(bArr5, i2));
                int i4 = i3;
                fileHeader.setCompressedSize(rawIO2.readLongLittleEndian(randomAccessFile2, 4));
                fileHeader.setUncompressedSize(rawIO2.readLongLittleEndian(randomAccessFile2, 4));
                int readShortLittleEndian = rawIO2.readShortLittleEndian(randomAccessFile2);
                fileHeader.setFileNameLength(readShortLittleEndian);
                fileHeader.setExtraFieldLength(rawIO2.readShortLittleEndian(randomAccessFile2));
                int readShortLittleEndian2 = rawIO2.readShortLittleEndian(randomAccessFile2);
                fileHeader.setFileCommentLength(readShortLittleEndian2);
                fileHeader.setDiskNumberStart(rawIO2.readShortLittleEndian(randomAccessFile2));
                randomAccessFile2.readFully(bArr);
                fileHeader.setInternalFileAttributes((byte[]) bArr.clone());
                randomAccessFile2.readFully(bArr5);
                fileHeader.setExternalFileAttributes((byte[]) bArr5.clone());
                randomAccessFile2.readFully(bArr5);
                long j = a;
                byte[] bArr6 = bArr;
                fileHeader.setOffsetLocalHeader(rawIO2.readLongLittleEndian(bArr5, 0));
                if (readShortLittleEndian > 0) {
                    byte[] bArr7 = new byte[readShortLittleEndian];
                    randomAccessFile2.readFully(bArr7);
                    String decodeStringWithCharset = HeaderUtil.decodeStringWithCharset(bArr7, fileHeader.isFileNameUTF8Encoded(), charset2);
                    if (decodeStringWithCharset.contains(":\\")) {
                        decodeStringWithCharset = decodeStringWithCharset.substring(decodeStringWithCharset.indexOf(":\\") + 2);
                    }
                    fileHeader.setFileName(decodeStringWithCharset);
                } else {
                    fileHeader.setFileName((String) null);
                }
                fileHeader.setDirectory(isDirectory(fileHeader.getExternalFileAttributes(), fileHeader.getFileName()));
                m3093a(randomAccessFile2, fileHeader);
                m3094a(fileHeader, rawIO2);
                m3098b(fileHeader, rawIO2);
                if (readShortLittleEndian2 > 0) {
                    byte[] bArr8 = new byte[readShortLittleEndian2];
                    randomAccessFile2.readFully(bArr8);
                    fileHeader.setFileComment(HeaderUtil.decodeStringWithCharset(bArr8, fileHeader.isFileNameUTF8Encoded(), charset2));
                }
                if (fileHeader.isEncrypted()) {
                    if (fileHeader.getAesExtraDataRecord() != null) {
                        fileHeader.setEncryptionMethod(EncryptionMethod.AES);
                    } else {
                        fileHeader.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
                    }
                }
                arrayList.add(fileHeader);
                i3 = i4 + 1;
                bArr2 = bArr5;
                bArr = bArr6;
                a = j;
                i = 2;
                i2 = 0;
            } else {
                throw new ZipException("Expected central directory entry not found (#" + (i3 + 1) + ")");
            }
        }
        centralDirectory.setFileHeaders(arrayList);
        DigitalSignature digitalSignature = new DigitalSignature();
        if (((long) rawIO2.readIntLittleEndian(randomAccessFile2)) == HeaderSignature.DIGITAL_SIGNATURE.getValue()) {
            digitalSignature.setSignature(HeaderSignature.DIGITAL_SIGNATURE);
            digitalSignature.setSizeOfData(rawIO2.readShortLittleEndian(randomAccessFile2));
            if (digitalSignature.getSizeOfData() > 0) {
                byte[] bArr9 = new byte[digitalSignature.getSizeOfData()];
                randomAccessFile2.readFully(bArr9);
                digitalSignature.setSignatureData(new String(bArr9));
            }
        }
        return centralDirectory;
    }

    /* renamed from: a */
    private void m3093a(RandomAccessFile randomAccessFile, FileHeader fileHeader) throws IOException {
        int extraFieldLength = fileHeader.getExtraFieldLength();
        if (extraFieldLength > 0) {
            fileHeader.setExtraDataRecords(m3083a(randomAccessFile, extraFieldLength));
        }
    }

    /* renamed from: a */
    private void m3091a(InputStream inputStream, LocalFileHeader localFileHeader) throws IOException {
        int extraFieldLength = localFileHeader.getExtraFieldLength();
        if (extraFieldLength > 0) {
            localFileHeader.setExtraDataRecords(m3082a(inputStream, extraFieldLength));
        }
    }

    /* renamed from: a */
    private List<ExtraDataRecord> m3083a(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i >= 4) {
            byte[] bArr = new byte[i];
            randomAccessFile.read(bArr);
            try {
                return m3084a(bArr, i);
            } catch (Exception unused) {
                return Collections.emptyList();
            }
        } else if (i <= 0) {
            return null;
        } else {
            randomAccessFile.skipBytes(i);
            return null;
        }
    }

    /* renamed from: a */
    private List<ExtraDataRecord> m3082a(InputStream inputStream, int i) throws IOException {
        if (i >= 4) {
            byte[] bArr = new byte[i];
            Zip4jUtil.readFully(inputStream, bArr);
            try {
                return m3084a(bArr, i);
            } catch (Exception unused) {
                return Collections.emptyList();
            }
        } else if (i <= 0) {
            return null;
        } else {
            inputStream.skip((long) i);
            return null;
        }
    }

    /* renamed from: a */
    private List<ExtraDataRecord> m3084a(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            ExtraDataRecord extraDataRecord = new ExtraDataRecord();
            extraDataRecord.setHeader((long) this.f4826b.readShortLittleEndian(bArr, i2));
            int i3 = i2 + 2;
            int readShortLittleEndian = this.f4826b.readShortLittleEndian(bArr, i3);
            extraDataRecord.setSizeOfData(readShortLittleEndian);
            int i4 = i3 + 2;
            if (readShortLittleEndian > 0) {
                byte[] bArr2 = new byte[readShortLittleEndian];
                System.arraycopy(bArr, i4, bArr2, 0, readShortLittleEndian);
                extraDataRecord.setData(bArr2);
            }
            i2 = i4 + readShortLittleEndian;
            arrayList.add(extraDataRecord);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    /* renamed from: a */
    private Zip64EndOfCentralDirectoryLocator m3088a(RandomAccessFile randomAccessFile, RawIO rawIO, long j) throws IOException {
        Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = new Zip64EndOfCentralDirectoryLocator();
        m3092a(randomAccessFile, j);
        if (((long) rawIO.readIntLittleEndian(randomAccessFile)) == HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.getValue()) {
            this.f4825a.setZip64Format(true);
            zip64EndOfCentralDirectoryLocator.setSignature(HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR);
            zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(rawIO.readIntLittleEndian(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(rawIO.readLongLittleEndian(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(rawIO.readIntLittleEndian(randomAccessFile));
            return zip64EndOfCentralDirectoryLocator;
        }
        this.f4825a.setZip64Format(false);
        return null;
    }

    /* renamed from: a */
    private Zip64EndOfCentralDirectoryRecord m3089a(RandomAccessFile randomAccessFile, RawIO rawIO) throws IOException {
        if (this.f4825a.getZip64EndOfCentralDirectoryLocator() != null) {
            long offsetZip64EndOfCentralDirectoryRecord = this.f4825a.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord();
            if (offsetZip64EndOfCentralDirectoryRecord >= 0) {
                randomAccessFile.seek(offsetZip64EndOfCentralDirectoryRecord);
                Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new Zip64EndOfCentralDirectoryRecord();
                if (((long) rawIO.readIntLittleEndian(randomAccessFile)) == HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD.getValue()) {
                    zip64EndOfCentralDirectoryRecord.setSignature(HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
                    zip64EndOfCentralDirectoryRecord.setSizeOfZip64EndCentralDirectoryRecord(rawIO.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setVersionMadeBy(rawIO.readShortLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setVersionNeededToExtract(rawIO.readShortLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(rawIO.readIntLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(rawIO.readIntLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(rawIO.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(rawIO.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setSizeOfCentralDirectory(rawIO.readLongLittleEndian(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(rawIO.readLongLittleEndian(randomAccessFile));
                    long sizeOfZip64EndCentralDirectoryRecord = zip64EndOfCentralDirectoryRecord.getSizeOfZip64EndCentralDirectoryRecord() - 44;
                    if (sizeOfZip64EndCentralDirectoryRecord > 0) {
                        byte[] bArr = new byte[((int) sizeOfZip64EndCentralDirectoryRecord)];
                        randomAccessFile.readFully(bArr);
                        zip64EndOfCentralDirectoryRecord.setExtensibleDataSector(bArr);
                    }
                    return zip64EndOfCentralDirectoryRecord;
                }
                throw new ZipException("invalid signature for zip64 end of central directory record");
            }
            throw new ZipException("invalid offset for start of end of central directory record");
        }
        throw new ZipException("invalid zip64 end of central directory locator");
    }

    /* renamed from: a */
    private void m3094a(FileHeader fileHeader, RawIO rawIO) throws ZipException {
        Zip64ExtendedInfo a;
        if (fileHeader.getExtraDataRecords() != null && fileHeader.getExtraDataRecords().size() > 0 && (a = m3090a(fileHeader.getExtraDataRecords(), rawIO, fileHeader.getUncompressedSize(), fileHeader.getCompressedSize(), fileHeader.getOffsetLocalHeader(), fileHeader.getDiskNumberStart())) != null) {
            fileHeader.setZip64ExtendedInfo(a);
            if (a.getUncompressedSize() != -1) {
                fileHeader.setUncompressedSize(a.getUncompressedSize());
            }
            if (a.getCompressedSize() != -1) {
                fileHeader.setCompressedSize(a.getCompressedSize());
            }
            if (a.getOffsetLocalHeader() != -1) {
                fileHeader.setOffsetLocalHeader(a.getOffsetLocalHeader());
            }
            if (a.getDiskNumberStart() != -1) {
                fileHeader.setDiskNumberStart(a.getDiskNumberStart());
            }
        }
    }

    /* renamed from: a */
    private void m3095a(LocalFileHeader localFileHeader, RawIO rawIO) throws ZipException {
        Zip64ExtendedInfo a;
        if (localFileHeader == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        } else if (localFileHeader.getExtraDataRecords() != null && localFileHeader.getExtraDataRecords().size() > 0 && (a = m3090a(localFileHeader.getExtraDataRecords(), rawIO, localFileHeader.getUncompressedSize(), localFileHeader.getCompressedSize(), 0, 0)) != null) {
            localFileHeader.setZip64ExtendedInfo(a);
            if (a.getUncompressedSize() != -1) {
                localFileHeader.setUncompressedSize(a.getUncompressedSize());
            }
            if (a.getCompressedSize() != -1) {
                localFileHeader.setCompressedSize(a.getCompressedSize());
            }
        }
    }

    /* renamed from: a */
    private Zip64ExtendedInfo m3090a(List<ExtraDataRecord> list, RawIO rawIO, long j, long j2, long j3, int i) {
        RawIO rawIO2 = rawIO;
        for (ExtraDataRecord next : list) {
            if (next != null) {
                if (HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue() == next.getHeader()) {
                    Zip64ExtendedInfo zip64ExtendedInfo = new Zip64ExtendedInfo();
                    byte[] data = next.getData();
                    if (next.getSizeOfData() <= 0) {
                        return null;
                    }
                    int i2 = 0;
                    if (next.getSizeOfData() > 0 && j == InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                        zip64ExtendedInfo.setUncompressedSize(rawIO.readLongLittleEndian(data, 0));
                        i2 = 8;
                    }
                    if (i2 < next.getSizeOfData() && j2 == InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                        zip64ExtendedInfo.setCompressedSize(rawIO.readLongLittleEndian(data, i2));
                        i2 += 8;
                    }
                    if (i2 < next.getSizeOfData() && j3 == InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                        zip64ExtendedInfo.setOffsetLocalHeader(rawIO.readLongLittleEndian(data, i2));
                        i2 += 8;
                    }
                    if (i2 < next.getSizeOfData() && i == 65535) {
                        zip64ExtendedInfo.setDiskNumberStart(rawIO.readIntLittleEndian(data, i2));
                    }
                    return zip64ExtendedInfo;
                }
                int i3 = i;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m3092a(RandomAccessFile randomAccessFile, long j) throws IOException {
        m3097b(randomAccessFile, (((j - 4) - 8) - 4) - 4);
    }

    public LocalFileHeader readLocalFileHeader(InputStream inputStream, Charset charset) throws IOException {
        LocalFileHeader localFileHeader = new LocalFileHeader();
        byte[] bArr = new byte[4];
        if (((long) this.f4826b.readIntLittleEndian(inputStream)) != HeaderSignature.LOCAL_FILE_HEADER.getValue()) {
            return null;
        }
        localFileHeader.setSignature(HeaderSignature.LOCAL_FILE_HEADER);
        localFileHeader.setVersionNeededToExtract(this.f4826b.readShortLittleEndian(inputStream));
        byte[] bArr2 = new byte[2];
        if (Zip4jUtil.readFully(inputStream, bArr2) == 2) {
            localFileHeader.setEncrypted(BitUtils.isBitSet(bArr2[0], 0));
            localFileHeader.setDataDescriptorExists(BitUtils.isBitSet(bArr2[0], 3));
            boolean z = true;
            localFileHeader.setFileNameUTF8Encoded(BitUtils.isBitSet(bArr2[1], 3));
            localFileHeader.setGeneralPurposeFlag((byte[]) bArr2.clone());
            localFileHeader.setCompressionMethod(CompressionMethod.getCompressionMethodFromCode(this.f4826b.readShortLittleEndian(inputStream)));
            localFileHeader.setLastModifiedTime((long) this.f4826b.readIntLittleEndian(inputStream));
            Zip4jUtil.readFully(inputStream, bArr);
            localFileHeader.setCrc(this.f4826b.readLongLittleEndian(bArr, 0));
            localFileHeader.setCompressedSize(this.f4826b.readLongLittleEndian(inputStream, 4));
            localFileHeader.setUncompressedSize(this.f4826b.readLongLittleEndian(inputStream, 4));
            int readShortLittleEndian = this.f4826b.readShortLittleEndian(inputStream);
            localFileHeader.setFileNameLength(readShortLittleEndian);
            localFileHeader.setExtraFieldLength(this.f4826b.readShortLittleEndian(inputStream));
            if (readShortLittleEndian > 0) {
                byte[] bArr3 = new byte[readShortLittleEndian];
                Zip4jUtil.readFully(inputStream, bArr3);
                String decodeStringWithCharset = HeaderUtil.decodeStringWithCharset(bArr3, localFileHeader.isFileNameUTF8Encoded(), charset);
                if (decodeStringWithCharset != null) {
                    if (decodeStringWithCharset.contains(":" + System.getProperty("file.separator"))) {
                        decodeStringWithCharset = decodeStringWithCharset.substring(decodeStringWithCharset.indexOf(":" + System.getProperty("file.separator")) + 2);
                    }
                    localFileHeader.setFileName(decodeStringWithCharset);
                    if (!decodeStringWithCharset.endsWith("/") && !decodeStringWithCharset.endsWith("\\")) {
                        z = false;
                    }
                    localFileHeader.setDirectory(z);
                } else {
                    throw new ZipException("file name is null, cannot assign file name to local file header");
                }
            } else {
                localFileHeader.setFileName((String) null);
            }
            m3091a(inputStream, localFileHeader);
            m3095a(localFileHeader, this.f4826b);
            m3099b(localFileHeader, this.f4826b);
            if (localFileHeader.isEncrypted() && localFileHeader.getEncryptionMethod() != EncryptionMethod.AES) {
                if (BitUtils.isBitSet(localFileHeader.getGeneralPurposeFlag()[0], 6)) {
                    localFileHeader.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG);
                } else {
                    localFileHeader.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
                }
            }
            return localFileHeader;
        }
        throw new ZipException("Could not read enough bytes for generalPurposeFlags");
    }

    public DataDescriptor readDataDescriptor(InputStream inputStream, boolean z) throws IOException {
        DataDescriptor dataDescriptor = new DataDescriptor();
        byte[] bArr = new byte[4];
        Zip4jUtil.readFully(inputStream, bArr);
        long readLongLittleEndian = this.f4826b.readLongLittleEndian(bArr, 0);
        if (readLongLittleEndian == HeaderSignature.EXTRA_DATA_RECORD.getValue()) {
            dataDescriptor.setSignature(HeaderSignature.EXTRA_DATA_RECORD);
            Zip4jUtil.readFully(inputStream, bArr);
            dataDescriptor.setCrc(this.f4826b.readLongLittleEndian(bArr, 0));
        } else {
            dataDescriptor.setCrc(readLongLittleEndian);
        }
        if (z) {
            dataDescriptor.setCompressedSize(this.f4826b.readLongLittleEndian(inputStream));
            dataDescriptor.setUncompressedSize(this.f4826b.readLongLittleEndian(inputStream));
        } else {
            dataDescriptor.setCompressedSize((long) this.f4826b.readIntLittleEndian(inputStream));
            dataDescriptor.setUncompressedSize((long) this.f4826b.readIntLittleEndian(inputStream));
        }
        return dataDescriptor;
    }

    /* renamed from: b */
    private void m3098b(FileHeader fileHeader, RawIO rawIO) throws ZipException {
        AESExtraDataRecord a;
        if (fileHeader.getExtraDataRecords() != null && fileHeader.getExtraDataRecords().size() > 0 && (a = m3085a(fileHeader.getExtraDataRecords(), rawIO)) != null) {
            fileHeader.setAesExtraDataRecord(a);
            fileHeader.setEncryptionMethod(EncryptionMethod.AES);
        }
    }

    /* renamed from: b */
    private void m3099b(LocalFileHeader localFileHeader, RawIO rawIO) throws ZipException {
        AESExtraDataRecord a;
        if (localFileHeader.getExtraDataRecords() != null && localFileHeader.getExtraDataRecords().size() > 0 && (a = m3085a(localFileHeader.getExtraDataRecords(), rawIO)) != null) {
            localFileHeader.setAesExtraDataRecord(a);
            localFileHeader.setEncryptionMethod(EncryptionMethod.AES);
        }
    }

    /* renamed from: a */
    private AESExtraDataRecord m3085a(List<ExtraDataRecord> list, RawIO rawIO) throws ZipException {
        if (list == null) {
            return null;
        }
        for (ExtraDataRecord next : list) {
            if (next != null && next.getHeader() == HeaderSignature.AES_EXTRA_DATA_RECORD.getValue()) {
                if (next.getData() != null) {
                    AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
                    aESExtraDataRecord.setSignature(HeaderSignature.AES_EXTRA_DATA_RECORD);
                    aESExtraDataRecord.setDataSize(next.getSizeOfData());
                    byte[] data = next.getData();
                    aESExtraDataRecord.setAesVersion(AesVersion.getFromVersionNumber(rawIO.readShortLittleEndian(data, 0)));
                    byte[] bArr = new byte[2];
                    System.arraycopy(data, 2, bArr, 0, 2);
                    aESExtraDataRecord.setVendorID(new String(bArr));
                    aESExtraDataRecord.setAesKeyStrength(AesKeyStrength.getAesKeyStrengthFromRawCode(data[4] & 255));
                    aESExtraDataRecord.setCompressionMethod(CompressionMethod.getCompressionMethodFromCode(rawIO.readShortLittleEndian(data, 5)));
                    return aESExtraDataRecord;
                }
                throw new ZipException("corrupt AES extra data records");
            }
        }
        return null;
    }

    /* renamed from: a */
    private long m3080a(ZipModel zipModel) {
        if (zipModel.isZip64Format()) {
            return zipModel.getZip64EndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory();
        }
        return (long) zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory();
    }

    /* renamed from: b */
    private long m3096b(RandomAccessFile randomAccessFile, int i) throws IOException {
        byte[] bArr = new byte[i];
        long filePointer = randomAccessFile.getFilePointer();
        do {
            int i2 = filePointer > ((long) i) ? i : (int) filePointer;
            filePointer = (filePointer - ((long) i2)) + 4;
            if (filePointer == 4) {
                filePointer = 0;
            }
            m3097b(randomAccessFile, filePointer);
            randomAccessFile.read(bArr, 0, i2);
            for (int i3 = 0; i3 < i2 - 3; i3++) {
                if (((long) this.f4826b.readIntLittleEndian(bArr, i3)) == HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue()) {
                    return filePointer + ((long) i3);
                }
            }
        } while (filePointer > 0);
        throw new ZipException("Zip headers not found. Probably not a zip file");
    }

    /* renamed from: b */
    private void m3097b(RandomAccessFile randomAccessFile, long j) throws IOException {
        if (randomAccessFile instanceof NumberedSplitRandomAccessFile) {
            ((NumberedSplitRandomAccessFile) randomAccessFile).seekInCurrentPart(j);
        } else {
            randomAccessFile.seek(j);
        }
    }

    /* renamed from: a */
    private String m3081a(RandomAccessFile randomAccessFile, int i, Charset charset) {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            randomAccessFile.readFully(bArr);
            if (charset == null) {
                charset = InternalZipConstants.ZIP4J_DEFAULT_CHARSET;
            }
            return HeaderUtil.decodeStringWithCharset(bArr, false, charset);
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean isDirectory(byte[] bArr, String str) {
        if (bArr[0] != 0 && BitUtils.isBitSet(bArr[0], 4)) {
            return true;
        }
        if (bArr[3] != 0 && BitUtils.isBitSet(bArr[3], 6)) {
            return true;
        }
        if (str == null) {
            return false;
        }
        if (str.endsWith("/") || str.endsWith("\\")) {
            return true;
        }
        return false;
    }
}
